package com.example.moviedb.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.moviedb.data.models.Popular
import com.example.moviedb.data.remote.MovieInterface
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory



class Repository {


    suspend fun getmovies():Call<Popular>{
        return MovieInterface.create().getmovies()
       /* val popular = MutableLiveData<Popular>()
        apiServices.isExecuted
        Log.d("apiexecuted",apiServices.isExecuted.toString())*/
      /*apiServices.enqueue(object :Callback<Popular>{
            override fun onResponse(call: Call<Popular>, response: Response<Popular>) {
               // response.body().results[0].
                Log.d("reesulittttt",response.body()!!.results[0].release_date)

                popular.postValue(response.body()!!)
            }

            override fun onFailure(call: Call<Popular>, t: Throwable) {
                TODO("Not yet implemented")
                Log.d("apiexecutedfailute",t.message.toString())

            }

        })
*/        //return popular
    }

}