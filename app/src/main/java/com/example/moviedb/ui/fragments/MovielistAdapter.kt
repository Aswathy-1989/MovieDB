package com.example.moviedb.ui.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviedb.R
import com.example.moviedb.data.models.Popular
import kotlinx.android.extensions.LayoutContainer

class MovielistAdapter(private val popular: Popular,private val clickLister:onrecyclerClick) : RecyclerView.Adapter<MovielistAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovielistAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovielistAdapter.ViewHolder, position: Int) {
      // val iem = position[position]

        holder.textview.text =popular.results[position].title
       // holder.imageView.drawable =popular.results[position].poster_path
        Glide
            .with(holder.itemView.context)
            .load("https://image.tmdb.org/t/p/w500/"+popular.results[position].poster_path)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.imageView);

        holder.linearLayout.setOnClickListener {
            clickLister.onTap(position)
        }
    }

    override fun getItemCount(): Int {
        return popular.results.size
    }
    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val textview:TextView
        val imageView:ImageView
        val linearLayout:FrameLayout;
        init {
            textview = view.findViewById(R.id.movieTitleView)
        imageView = view.findViewById(R.id.moviePosterView)
            linearLayout = view.findViewById(R.id.itemMovieView)
        }

    }

}

interface  onrecyclerClick{
    fun onTap(index:Int)
}