package com.example.moviedb.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviedb.R
import com.example.moviedb.data.models.Result

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Use the [MovieDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MovieDetailsFragment : Fragment() {
    // TODO: Rename and change types of parameters

    private var inputText: String? = ""
    private var inputImage: String? = ""
    private var inputTitle: String? = ""
    private var inputLanguage: String? = ""
    private var inputtime: String? = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //arguments of navgraph not null
        arguments?.let { inputText = MovieDetailsFragmentArgs.fromBundle(it).detailddata.release_date
            inputImage =MovieDetailsFragmentArgs.fromBundle(it).detailddata.poster_path
            inputTitle = MovieDetailsFragmentArgs.fromBundle(it).detailddata.title
            inputLanguage = MovieDetailsFragmentArgs.fromBundle(it).detailddata.original_language
            inputtime = MovieDetailsFragmentArgs.fromBundle(it).detailddata.vote_count.toString()
        }?.let {
            Log.e("ERRROR",
                it.toString()

            )

        }
    }

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageView = view.findViewById<ImageView>(R.id.movieBackDropView)
        val releaseDate = view.findViewById<TextView>(R.id.movieYear)
        val movieTitle = view.findViewById<TextView>(R.id.movieGenres)
        val movieanguage = view.findViewById<TextView>(R.id.movieLanguage)
        val movieRating = view.findViewById<TextView>(R.id.movieRating)
        releaseDate.text ="Release Date"+inputText
        movieTitle.text ="Title  :"+inputTitle
        movieanguage.text ="Language  :"+inputLanguage
        movieRating.text ="Rating  :"+inputtime
        Glide
            .with(this)
            .load("https://image.tmdb.org/t/p/w500/"+inputImage)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .into(imageView);


    }

}