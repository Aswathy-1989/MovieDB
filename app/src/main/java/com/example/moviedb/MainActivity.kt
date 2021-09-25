package com.example.moviedb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.paging.ExperimentalPagingApi
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviedb.adapter.RecyclerViewAdapter
import com.example.moviedb.data.model.RepositoryData
import com.example.moviedb.viewmodel.MainActivityViewModel
import com.facebook.stetho.Stetho
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
@ExperimentalPagingApi
class MainActivity : AppCompatActivity() {
    private lateinit var recyclerViewAdapter: RecyclerViewAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Stetho.initializeWithDefaults(this)
        initViewModel()
        //initMainViewModel()
        initViewModel1();
    }

    private fun initViewModel() {
        recyclerView = findViewById(R.id.moviesRecycler)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            val decoration =
                DividerItemDecoration(applicationContext, DividerItemDecoration.VERTICAL)
            recyclerViewAdapter = RecyclerViewAdapter()
            adapter = recyclerViewAdapter

        }
    }

    private fun initViewModel1() {
        val viewmodel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        lifecycleScope.launchWhenCreated {
            viewmodel.getAllRepositoyList.collectLatest {
                recyclerViewAdapter.submitData(it)
            }
        }
    }
}