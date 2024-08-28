package com.example.dictionaryapplication

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DictionaryServices {
    @GET("{word}")
    fun getDefinition(
        @Path("word") definition: String
    ) : Call<List<WordModel>>
}