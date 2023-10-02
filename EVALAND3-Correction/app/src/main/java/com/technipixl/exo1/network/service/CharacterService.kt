package com.technipixl.exo1.network.service

import com.technipixl.exo1.network.model.CharacterResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterService {

    /*4. Décrit les requêtes que vous pouvez effectuer vers l'API Marvel à
    l'aide de Retrofit. La fonction getCharacters permet de récupérer la liste de personnages.*/
    @GET("characters")
    suspend fun getCharacters(
        @Query("apikey", encoded = false) term: String,
        @Query("ts", encoded = false) timeStamp: String,
        @Query("hash", encoded = false) hash: String
    ): Response<CharacterResponse>

    @GET("characters/{characterId}")
    suspend fun getCharacter(
        @Path("characterId") characterId: Long,
        @Query("apikey", encoded = false) term: String,
        @Query("ts", encoded = false) timeStamp: String,
        @Query("hash", encoded = false) hash: String
    ): Response<CharacterResponse>
}