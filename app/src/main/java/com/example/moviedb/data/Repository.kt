package com.example.moviedb.data

import com.example.moviedb.data.models.Popular
import com.example.moviedb.data.remote.MovieInterface
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory



class Repository {


    suspend fun getmovies(){
       /* val apiServices = MovieInterface.create().getmovies()
        apiServices.enqueue(object :Callback<Popular>{
            override fun onResponse(call: Call<Popular>, response: Response<Popular>) {
                TODO("Not yet implemented")
                response.body().results[0].
            }

            override fun onFailure(call: Call<Popular>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })*/
    }

}