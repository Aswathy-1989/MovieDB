package com.example.moviedb.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviedb.data.Repository
import com.example.moviedb.data.models.Popular
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovielistFragmentViewModel(): ViewModel() {
     val users: MutableLiveData<Popular> by lazy {
        MutableLiveData<Popular>().also {
            loadPopularMoview()
        }
    }

    fun loadPopularMoview(){
        Log.d("Print","Load popular")
        val repository = Repository()
        //return repository.getmovies()
        viewModelScope.launch(Dispatchers.IO) {
            val res = repository.getmovies();
            res.enqueue(object : Callback<Popular> {
                override fun onResponse(call: Call<Popular>, response: Response<Popular>) {
                    users.postValue(response.body()!!)
                }

                override fun onFailure(call: Call<Popular>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })
        }
    }
}