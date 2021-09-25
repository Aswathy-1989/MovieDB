package com.example.moviedb.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.example.moviedb.data.model.RepositoryData
import com.example.moviedb.db.AppDatabase
import com.example.moviedb.netwoek.RetroRepository
import com.example.moviedb.netwoek.RetroServiceInterface
import com.example.moviedb.paging.CharacterPagingSource
import com.example.moviedb.paging.MovieMediator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ExperimentalPagingApi
@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val retroServiceInterface: RetroServiceInterface,
    private val appDatabase: AppDatabase
) : ViewModel() {


val getAllRepositoyList: Flow<PagingData<RepositoryData>> = Pager(
        config = PagingConfig(pageSize = 20, prefetchDistance = 2),
        pagingSourceFactory = { appDatabase.getMovieDao().getMovieList() },
        remoteMediator = MovieMediator(retroServiceInterface, appDatabase)
    ).flow.cachedIn(
        viewModelScope
    )

//    val getAllRepositoyList: Flow<PagingData<RepositoryData>> = Pager(
//        config = PagingConfig(pageSize = 20, prefetchDistance = 2),
//        pagingSourceFactory = { CharacterPagingSource(retroServiceInterface) },
//    ).flow.cachedIn(
//        viewModelScope
//    )
}