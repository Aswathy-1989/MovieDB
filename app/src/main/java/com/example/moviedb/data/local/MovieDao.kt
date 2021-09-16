package com.example.moviedb.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import java.util.concurrent.Flow

@Dao
interface MovieDao {

    @Query(value = "Select * from movietbl")
    suspend fun getMovieList(): List<Movie>?
    //suspend fun exceute action in few minutes
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movietbl:List<Movie>)
}