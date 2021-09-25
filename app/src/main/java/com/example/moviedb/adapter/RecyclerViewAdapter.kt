package com.example.moviedb.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviedb.R
import com.example.moviedb.activity.MovieDetailsActivity
import com.example.moviedb.data.model.MovieDetails
import com.example.moviedb.data.model.RepositoryData
import kotlinx.android.synthetic.main.movie_list_item.view.*

class RecyclerViewAdapter: PagingDataAdapter<RepositoryData,RecyclerViewAdapter.MyViewHolder>(DiffUtilCallBack()) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerViewAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_list_item, parent, false)
        return MyViewHolder(view)    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter.MyViewHolder, position: Int) {
        Log.d("TAG","ITEMS POSITION "+position)
        holder.bind(getItem(position)!!)
        holder.itemView.setOnClickListener{
            val model =getItem(position)
            var mtitle : String = model?.title!!
            var path : String = model.poster_path!!
            var releaseDate : String = model.release_date!!
            var releaselanguage : String = model.original_language!!
            var releaserating : String = model.vote_count.toString()
            val intent =Intent(holder.itemView.context,MovieDetailsActivity::class.java)
            intent.putExtra("title",mtitle)
            intent.putExtra("imagepath",path)
            intent.putExtra("yearkey",releaseDate)
            intent.putExtra("language",releaselanguage)
            intent.putExtra("rating",releaserating)
            holder.itemView.context.startActivity(intent)
        }
    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view)
    {
        val imagePoster = view.moviePosterView
        val moveName = view.movieTitleView

        fun bind(data:RepositoryData)
        {
      moveName.text = data.title
            Glide
                .with(imagePoster)
                .load("https://image.tmdb.org/t/p/w500/"+data.poster_path)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(imagePoster);        }
    }
    //
    //DiffUtilCallBack check the content of each row

    class DiffUtilCallBack: DiffUtil.ItemCallback<RepositoryData>()
    {
        override fun areItemsTheSame(oldItem: RepositoryData, newItem: RepositoryData): Boolean {
           return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: RepositoryData, newItem: RepositoryData): Boolean {
            return oldItem.id == newItem.id
        }

    }
}