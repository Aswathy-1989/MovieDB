package com.example.moviedb.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviedb.R

class MovieDetailsActivity : AppCompatActivity() {
    private lateinit var pathImageview: ImageView
    private lateinit var titleText: TextView
    private lateinit var yearText: TextView
    private lateinit var languageText: TextView
    private lateinit var ratingText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_movie_details)
        val actionBar : ActionBar? = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar!!.setDisplayShowHomeEnabled(true)
        actionBar!!.setTitle("Movie Details")
        var intent =intent
        val atitle = intent.getStringExtra("title")
        val path = intent.getStringExtra("imagepath")
        val releseYr = intent.getStringExtra("yearkey")
        val language = intent.getStringExtra("language")
        val rating = intent.getStringExtra("rating")
        pathImageview =findViewById(R.id.movieBackDropView)
        titleText =findViewById(R.id.movieGenres)
        yearText =findViewById(R.id.movieYear)
        languageText =findViewById(R.id.movieLanguage)
        ratingText =findViewById(R.id.movieRating)

        Glide
            .with(this)
            .load("https://image.tmdb.org/t/p/w500/"+path)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .into(pathImageview);
        titleText.text ="Title  :"+atitle
        yearText.text ="Year  :"+releseYr
        ratingText.text ="Rating  :"+rating
        languageText.text ="language  :"+language


    }
    override fun onSupportNavigateUp(): Boolean {
        finish();
        return true;      }
}