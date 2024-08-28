package com.example.dictionaryapplication.data.service

import com.example.dictionaryapplication.data.model.WordModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface DictionaryServices {
    @GET("{word}")
    fun getDefinition(
        @Path("word") definition: String
    ) : Call<List<WordModel>>
}