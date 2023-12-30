package hr.algebra.marvelapp.api

import android.content.Context
import android.util.Log
import hr.algebra.marvelapp.MarvelReceiver
import hr.algebra.marvelapp.api.model.Character
import hr.algebra.marvelapp.framework.sendBroadcast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MarvelFetcher(private val context: Context) {

    private val marvelCharactersApi : MarvelCharactersApi
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

        val items = mutableListOf<Character>()

        marvelCharacters.forEach {
            val imagePath = null
            items.add(Character(
                null,
                it.name,
                imagePath ?: "",
                it.comics.available,
                it.stories.available,
                it.events.available,
                it.series.available
            )
            )
        }

        println(items)

        context.sendBroadcast<MarvelReceiver>()
    }
}