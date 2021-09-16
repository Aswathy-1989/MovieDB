package com.example.moviedb.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movietbl")
data class Movie(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val name :String ,
    val backdrop_path:String,
    val title:String,
    val release_date:String,
    val popularity:String,
    val vote_average:String,
    )


