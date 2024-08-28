package com.example.dictionaryapplication.data.service

import retrofit2.http.POST
import retrofit2.http.Headers
import retrofit2.http.Query

interface TranslateService {
    @POST("{text}")
    @Headers(
        "Content-Type: application/json",
        "x-rapidapi-host: google-translate113.p.rapidapi.com",
        "x-rapidapi-key: 4445ea223cmsh08128445a6689bep17677bjsnc6d82a73d4d7"
    )
    fun translateText(

    )
    @POST("{detect-language}")
    @Headers(
        "Content-Type: multipart/form-data",
        "X-RapidAPI-Key: 4445ea223cmsh08128445a6689bep17677bjsnc6d82a73d4d7",
        "x-rapidapi-host: google-translate113.p.rapidapi.com",
        "x-rapidapi-key: 4445ea223cmsh08128445a6689bep17677bjsnc6d82a73d4d7"
    )
    fun detectTheLanguage(

    )
}


