package com.example.moviedb.data.remote

import com.example.moviedb.data.models.Popular
import retrofit2.http.GET
import  retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Path

 interface MovieInterface {




     @GET("movie/popular?api_key=ea82a49cc47915bb9477d6032839ae06")
     fun getmovies() :Call<Popular>

     companion object {

         var BASE_URL = "https://api.themoviedb.org/3/"

         fun create() : MovieInterface {

             val retrofit = Retrofit.Builder()
                 .addConverterFactory(GsonConverterFactory.create())
                 .baseUrl(BASE_URL)
                 .build()
             return retrofit.create(MovieInterface::class.java)

         }
     }

}