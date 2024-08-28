package com.example.dictionaryapplication.data.api

import com.example.dictionaryapplication.data.service.DictionaryServices
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DictionaryClient {
    private  const val BASE_URL:String="https://api.dictionaryapi.dev/api/v2/entries/en/"
    val wordRetrofitCall: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}
object DictionaryApiClient {
    val dictionaryService: DictionaryServices by lazy {
        DictionaryClient.wordRetrofitCall.create(DictionaryServices::class.java);
    }
}