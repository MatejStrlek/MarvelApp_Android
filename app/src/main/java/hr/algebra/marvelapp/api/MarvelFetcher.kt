package hr.algebra.marvelapp.api

import android.content.ContentValues
import android.content.Context
import android.util.Log
import hr.algebra.marvelapp.MARVEL_PROVIDER_CONTENT_URI
import hr.algebra.marvelapp.MarvelReceiver
import hr.algebra.marvelapp.api.model.Character
import hr.algebra.marvelapp.framework.sendBroadcast
import hr.algebra.marvelapp.handler.downloadImageAndStore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MarvelFetcher(private val context: Context) {

    private val marvelCharactersApi: MarvelCharactersApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        marvelCharactersApi = retrofit.create(MarvelCharactersApi::class.java)
    }

    fun fetchItems() {

        val request = marvelCharactersApi.fetchCharacters()

        request.enqueue(object : Callback<CharacterResponse> {
            override fun onResponse(
                call: Call<CharacterResponse>,
                response: Response<CharacterResponse>
            ) {
                val characterData: CharacterData? = response.body()?.data
                val characterList: List<MarvelCharacter>? = characterData?.results

                if (characterList != null) {
                    populateItems(characterList)
                }
            }

            override fun onFailure(call: Call<CharacterResponse>, t: Throwable) {
                Log.e(javaClass.name, t.toString(), t)
            }

        })
    }

    private fun populateItems(marvelCharacters: List<MarvelCharacter>) {

        val scope = CoroutineScope(Dispatchers.IO)

        scope.launch {
            marvelCharacters.forEach {
                val imagePath = downloadImageAndStore(context, it.thumbnail.path, it.thumbnail.extension)

                val values = ContentValues().apply {
                    put(Character::name.name, it.name)
                    put(Character::imagePath.name, imagePath ?: "")
                    put(Character::comics.name, it.comics.available)
                    put(Character::stories.name, it.stories.available)
                    put(Character::events.name, it.events.available)
                    put(Character::series.name, it.series.available)
                }

                context.contentResolver.insert(
                    MARVEL_PROVIDER_CONTENT_URI,
                    values
                )
            }

            context.sendBroadcast<MarvelReceiver>()
        }
    }
}