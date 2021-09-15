package com.example.moviedb.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Popular(
    @SerializedName("page")
    @Expose
    val page: Int,
    @SerializedName("results")
    @Expose
    val results: List<Result>,
    @SerializedName("total_pages")
    @Expose
    val total_pages: Int,
    @SerializedName("total_results")
    @Expose
    val total_results: Int
)