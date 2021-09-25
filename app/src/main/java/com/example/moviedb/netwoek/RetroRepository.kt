package com.example.moviedb.netwoek

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.moviedb.db.MovieDao
import com.example.moviedb.data.model.Popular
import com.example.moviedb.data.model.RepositoryData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class RetroRepository @Inject constructor(private val retroServiceInterface: RetroServiceInterface,
                  private val movieDao: MovieDao) {
//    fun getAllRecords(): LiveData<List<RepositoryData>>
//    {
//        return movieDao.getMovieList()
//    }

//    fun insertMovie(repositoryData: List<RepositoryData>)
//    {
//        movieDao.insertMovie(repositoryData)
//        val records = getAllRecords();
//        Log.d("TAG","count"+records.value?.size)
//    }
    //get the data from movie.com
    fun makeApiCall(query: String?)
    {
        val call : Call<Popular> = retroServiceInterface.getDateFromAPi(1)
        call?.enqueue(object : Callback<Popular>{
            override fun onResponse(call: Call<Popular>, response: Response<Popular>) {
                if(response.isSuccessful)
                {
                    /*response.body()?.it?.forEach
                    {
                        insertMovie(it)
                    }*/
//                    insertMovie(response.body()?.results!!)
                }
             }

            override fun onFailure(call: Call<Popular>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

    }
}