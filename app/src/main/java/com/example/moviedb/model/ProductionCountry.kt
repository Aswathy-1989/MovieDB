package com.example.moviedb.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ProductionCountry(
    @SerializedName("iso_3166_1")
    @Expose
    val iso_3166_1: String,
    @SerializedName("name")
    @Expose
    val name: String
)