package com.example.moviedb.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Genre(
    @SerializedName("id")
    @Expose
    val id: Int,
    @SerializedName("name")
    @Expose
    val name: String
)