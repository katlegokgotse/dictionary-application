package com.example.dictionaryapplication.data.model

data class LanguageResponse(
    val data: Data
)

data class Data(
    val languages: List<Language>
)

data class Language(
    val language: String,
    val name: String
)
