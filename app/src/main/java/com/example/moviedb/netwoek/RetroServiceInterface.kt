package com.example.moviedb.netwoek

import com.example.moviedb.data.model.Popular
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroServiceInterface {
    @GET("movie/popular?api_key=ea82a49cc47915bb9477d6032839ae06")
    fun getDateFromAPi(@Query("page")pageno: Int):Call<Popular>
}