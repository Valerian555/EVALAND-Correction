package com.technipixl.exo1.network.service

import com.technipixl.exo1.network.model.ComicDetailResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ComicService {
    @GET("comics/{comicsId}")
    suspend fun comicsDetail(
        @Path("comicsId") comicsId: String,
        @Query("apikey", encoded = false) term: String,
        @Query("ts", encoded = false) timeStamp: String,
        @Query("hash", encoded = false) hash: String
    ): Response<ComicDetailResponse>
}