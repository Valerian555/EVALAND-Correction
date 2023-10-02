package com.technipixl.exo1.network.service

import com.technipixl.exo1.network.model.CharacterResponse
import retrofit2.Response

//5. responsable de l'accès à l'API Marvel en utilisant Retrofit.
class CharacterServiceImpl: BaseServiceImpl() {
    suspend fun getCharacters(apiKey: String,
                           timeStamp: String,
                           hash: String
    ): Response<CharacterResponse> = getRetrofit().create(CharacterService::class.java).getCharacters(apiKey, timeStamp, hash)

    suspend fun getCharacter(characterId: Long,
                          apiKey: String,
                          timeStamp: String,
                          hash: String): Response<CharacterResponse> = getRetrofit().create(CharacterService::class.java).getCharacter(characterId,
        apiKey,
        timeStamp,
        hash)
}