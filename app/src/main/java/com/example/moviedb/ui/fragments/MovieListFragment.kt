package com.example.moviedb.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.moviedb.R
import com.example.moviedb.data.Repository
import com.example.moviedb.data.models.Popular
import com.example.moviedb.ui.viewmodel.MovielistFragmentViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MovieListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MovieListFragment : Fragment() {
    // TODO: Rename and change types of parameters
     private lateinit var movielistAdapter :MovielistAdapter

    lateinit var model:MovielistFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

         model = ViewModelProvider(this).get(MovielistFragmentViewModel::class.java)

    }

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btn = view.findViewById<RecyclerView>(R.id.moviesRecycler)
        model.users.observe(viewLifecycleOwner, Observer<Popular> {polular->

            if(polular ==null){
                Log.d("TAG","null")

            }else{
                Log.d("TAGElse","count is"+polular.total_pages.toString())
                movielistAdapter =MovielistAdapter(polular,object :onrecyclerClick{
                    override fun onTap(index: Int) {
                        Log.d("Tap","Clicked position"+index)


                       findNavController().navigate(MovieListFragmentDirections.actionMovieListFragmentToMovieDetailsFragment(polular.results[index]))
                    }
                })
                btn.adapter=movielistAdapter


            }
        })
        model.loadPopularMoview()


    }

}