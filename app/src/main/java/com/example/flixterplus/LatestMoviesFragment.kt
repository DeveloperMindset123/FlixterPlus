package com.example.flixterplus

import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment


private const val API_KEY= "a07e22bc18f5cb106bfe4cc1f83ad8ed"

//api call to be made: https://api.themoviedb.org/3/movie/now_playing?&api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed
class LatestMoviesFragment : Fragment(), OnListFragmentInteractionListener {
    /**
     * Constructing the view
     * */

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        saveInstanceState: Bundle?
    ) : View? {
        val view = inflater
    }
    override fun onItemClick(item: LatestMovies) {  //default generated when extensions Fragment() and OnListFragmentInteractionListener is added (since we defined onItemClick function within interface onListFragmentInteractionListener
        TODO("Not yet implemented")
    }

}