package com.example.dictionaryapplication.data.service

import retrofit2.http.GET
import retrofit2.http.Headers

interface TranslateService {
    @GET("languages")
    @Headers(
        "x-rapidapi-host: google-translate1.p.rapidapi.com",
        "x-rapidapi-key: 4445ea223cmsh08128445a6689bep17677bjsnc6d82a73d4d7",
        "Accept-Encoding: application/gzip")
    fun getTranslation()
}

