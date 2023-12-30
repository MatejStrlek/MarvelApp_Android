package hr.algebra.marvelapp.api

import hr.algebra.marvelapp.BuildConfig
import hr.algebra.marvelapp.framework.md5
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

const val API_URL = "http://gateway.marvel.com/v1/public/"
//const val HASH = "8cf4a00fb5125079a90b0d28af40935f"

interface MarvelCharactersApi {
    companion object {
        private const val PUBLIC_KEY = BuildConfig.marvel_public_api_key
        private const val PRIVATE_KEY = BuildConfig.marvel_private_api_key
        private const val ts = "1"
    }

    @GET("characters")
    fun fetchCharacters(
        @Query("ts") ts: String = "1",
        @Query("apikey") apiKey: String = PUBLIC_KEY,
        @Query("hash") hash: String = "${Companion.ts}$PRIVATE_KEY$PUBLIC_KEY".md5(),
        @Query("limit") limit: Int = 20) : Call<CharacterResponse>

    @GET("characters/{characterId}")
    suspend fun getSuperheroDetails(@Path("characterId") characterId: Long) : Call<CharacterResponse>
}

data class CharacterResponse(
    val code: Int,
    val status: String,
    val data: CharacterData
)

data class CharacterData(
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: List<MarvelCharacter>
)