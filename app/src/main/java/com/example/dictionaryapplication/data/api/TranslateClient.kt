package com.example.dictionaryapplication.data.api

import com.example.dictionaryapplication.data.service.TranslateService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object TranslateClient {
    private const val BASE_URL="https://google-translate113.p.rapidapi.com/api/v1/translator/"
    val translateRetrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}

object TranslateApiClient{
    val translateService: TranslateService by lazy {
        TranslateClient.translateRetrofit.create(TranslateService::class.java)
    }
}