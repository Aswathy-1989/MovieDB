package com.example.moviedb.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SpokenLanguage(
    @SerializedName("english_name")
    @Expose
    val english_name: String,
    @SerializedName("iso_639_1")
    @Expose
    val iso_639_1: String,
    @SerializedName("name")
    @Expose
    val name: String
)