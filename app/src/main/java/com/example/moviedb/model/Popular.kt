package com.example.moviedb.data.model
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Popular(
    @SerializedName("page")
    @Expose
    val page: Int,
    @SerializedName("results")
    @Expose
    val results: List<RepositoryData>,
    @SerializedName("total_pages")
    @Expose
    val total_pages: Int,
    @SerializedName("total_results")
    @Expose
    val total_results: Int
)