package com.example.moviedb.paging

import android.util.Log
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.example.moviedb.data.model.RepositoryData
import com.example.moviedb.db.AppDatabase
import com.example.moviedb.model.RemoteKeys
import com.example.moviedb.netwoek.RetroServiceInterface
import retrofit2.HttpException
import retrofit2.await
import java.io.IOException
import java.io.InvalidObjectException


@ExperimentalPagingApi
class MovieMediator(
    private val apiServiceInterface: RetroServiceInterface,
    private val appDatabase: AppDatabase
) :
    RemoteMediator<Int, RepositoryData>() {

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, RepositoryData>
    ): MediatorResult {
        val pageKeyData = getKeyPage(loadType, state)
        val page = when (pageKeyData) {
            is MediatorResult.Success -> {
                return pageKeyData
            }

            else -> {
                pageKeyData as Int
            }
        }

        try {
            Log.d("PAGE", "PAGE " + page)
            val resopnse = apiServiceInterface.getDateFromAPi(page.plus(1)).await()
            val isEndOfList = resopnse.page == resopnse.total_pages

            appDatabase.runInTransaction {
                if (loadType == LoadType.REFRESH) {
                    appDatabase.getMovieDao().clearMovies()
                    appDatabase.getRemoteKeysDao().removeAllKeys()
                }

                val keys = RemoteKeys(
                    page = resopnse.page.plus(1),
                    total_pages = resopnse.total_pages,
                    total_results = resopnse.total_results
                )
                appDatabase.getRemoteKeysDao().insertKey(keys)
                appDatabase.getMovieDao().insertMovie(resopnse.results)
            }
            return MediatorResult.Success(endOfPaginationReached = isEndOfList)
        } catch (exception: IOException) {
            return MediatorResult.Error(exception)
        } catch (exception: HttpException) {
            return MediatorResult.Error(exception)
        }
    }


    fun getKeyPage(loadType: LoadType, state: PagingState<Int, RepositoryData>): Any? {
        return when (loadType) {
            LoadType.APPEND -> {
                val remoteKey = getLastremoteKey(state)
                    ?: throw InvalidObjectException("remote key should not be null")
                remoteKey.page

            }

            LoadType.PREPEND -> {
                val remoteKey = getFirstRemoteKey(state)
                    ?: throw  InvalidObjectException("Invalid state,key should not be null")
                remoteKey.page >= remoteKey.total_pages ?: return MediatorResult.Success(
                    endOfPaginationReached = true
                )
                remoteKey.page

            }

            LoadType.REFRESH -> {
                val remotekeys = getClosestRemoteKey(state)
                remotekeys?.page ?: 1
            }
        }
    }


    private fun getFirstRemoteKey(state: PagingState<Int, RepositoryData>): RemoteKeys? {
        return appDatabase.getRemoteKeysDao().remoteKeysUsingId()
    }

    private fun getLastremoteKey(state: PagingState<Int, RepositoryData>): RemoteKeys? {
        return appDatabase.getRemoteKeysDao().remoteKeysUsingId()
    }

    private fun getClosestRemoteKey(state: PagingState<Int, RepositoryData>): RemoteKeys? {
        return appDatabase.getRemoteKeysDao().remoteKeysUsingId()
    }
}