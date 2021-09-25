package com.example.moviedb.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.moviedb.data.model.RepositoryData
import com.example.moviedb.netwoek.RetroServiceInterface
import retrofit2.await
import java.lang.Exception

class CharacterPagingSource(val apiService: RetroServiceInterface) :
    PagingSource<Int, RepositoryData>() {
    override fun getRefreshKey(state: PagingState<Int, RepositoryData>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, RepositoryData> {
        val page = params.key ?: 1
        return try {

            val response = apiService.getDateFromAPi(page).await()
            var nextPageNumber: Int? =null

            //if results total page count less than current page then add +1 count
            if(response.page<response.total_pages){
                nextPageNumber = response.page+1
            }

            LoadResult.Page(
                data = response.results,
                prevKey = null,
                nextKey = nextPageNumber
            )


        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    companion object {
        private const val FIRST_PAGE_INDEX = 1
    }
}

