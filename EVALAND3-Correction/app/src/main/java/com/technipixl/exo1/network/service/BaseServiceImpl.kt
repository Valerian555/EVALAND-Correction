package com.technipixl.exo1.network.service

import com.technipixl.exo1.network.HashGenerator
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

//3.
open class BaseServiceImpl: BaseService {
    override val baseUrl: String = "https://gateway.marvel.com/v1/public/"

    companion object {
        const val publicApiKey = "2de9fa8103a271706e625d8e50738a9e"
        const val privateApiKey = "cf52b21568bf70dfeb4037711fcdf0cb44d847e0"
    }

    //hash la clé API
    fun hash(timeStamp: Long): String {
        return HashGenerator.generateHash(timeStamp, privateApiKey, publicApiKey) ?: ""
    }

    //création de l'instance de RétroFit
    fun getRetrofit(): Retrofit {
        val okBuilder = OkHttpClient().newBuilder().apply {
            connectTimeout(60, TimeUnit.SECONDS)
            callTimeout(60, TimeUnit.SECONDS)
            readTimeout(60, TimeUnit.SECONDS)
            writeTimeout(60, TimeUnit.SECONDS)
        }

        return Retrofit.Builder()
            .baseUrl(baseUrl) //url du JSON de l'API (c'est la baseUrl pas le endpoint, pas oublié le "/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okBuilder.build())
            .build()
    }
}