package com.example.dictionaryapplication.data.model

data class LanguageResponse(
    val data: Data
)

data class Data(
    val languages: List<Language>
)

data class Language(
    val code: String,
    val language: String,
)
