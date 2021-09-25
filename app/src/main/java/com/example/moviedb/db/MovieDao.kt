package com.example.moviedb.db

import androidx.lifecycle.LiveData
import androidx.paging.PagingSource
import androidx.room.*
import com.example.moviedb.data.model.RepositoryData

@Dao
interface MovieDao {

    @Query(value = "Select * from movietbl")
    fun getMovieList(): PagingSource<Int, RepositoryData>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movietbl: List<RepositoryData>)

    @Query("DELETE FROM movietbl")
    fun clearMovies()
}

