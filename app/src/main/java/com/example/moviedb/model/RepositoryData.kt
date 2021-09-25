package com.example.moviedb.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "movietbl")
data class RepositoryData(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    @SerializedName("id")
    @Expose
    val id: Int,

    @SerializedName("adult")
    @Expose
    @ColumnInfo(name = "adult")

    val adult: Boolean?,
    @SerializedName("backdrop_path")
    @Expose
    @ColumnInfo(name = "backdrop_path")
    val backdrop_path: String?,

/*    @SerializedName("genre_ids")
    @Expose
   // @ColumnInfo(name = "genre_ids")
    @Ignore
    val genre_ids: List<Int>,*/

    @SerializedName("original_language")
    @Expose
    @ColumnInfo(name = "original_language")
    val original_language: String?,

    @SerializedName("original_title")
    @Expose
    @ColumnInfo(name = "original_title")
    val original_title: String?,

    @SerializedName("overview")
    @Expose
    @ColumnInfo(name = "overview")
    val overview: String?,

    @SerializedName("popularity")
    @Expose
    @ColumnInfo(name = "popularity")
    val popularity: Double,

    @SerializedName("poster_path")
    @Expose
    @ColumnInfo(name = "poster_path")
    val poster_path: String?,

    @SerializedName("release_date")
    @Expose
    @ColumnInfo(name = "release_date")
    val release_date: String?,

    @SerializedName("title")
    @Expose
    @ColumnInfo(name = "title")
    val title: String?,

    @SerializedName("video")
    @Expose
    @ColumnInfo(name = "video")
    val video: Boolean?,

    @SerializedName("vote_average")
    @Expose
    @ColumnInfo(name = "vote_average")
    val vote_average: Double?,

    @SerializedName("vote_count")
    @Expose
    @ColumnInfo(name = "vote_count")
    val vote_count: Int,

)