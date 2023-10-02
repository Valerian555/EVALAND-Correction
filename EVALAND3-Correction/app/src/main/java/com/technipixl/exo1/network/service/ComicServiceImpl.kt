package com.technipixl.exo1.network.service

import com.technipixl.exo1.network.model.ComicDetailResponse
import retrofit2.Response

class ComicServiceImpl: BaseServiceImpl() {
    suspend fun comicsDetail(comicsId: String,
                             apiKey: String,
                             timeStamp: String,
                             hash: String): Response<ComicDetailResponse> = getRetrofit().create(ComicService::class.java).comicsDetail(comicsId,
        apiKey,
        timeStamp,
        hash)
}