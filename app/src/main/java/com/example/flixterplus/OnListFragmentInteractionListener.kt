package com.example.flixterplus


/**
 * This interface is used by the [LatestMoviesRecyclerViewAdapter] to ensure it has appropriate listener
 *
 * In this app, it's implemented by [LatestMoviesFragment]
 *
 * */
interface OnListFragmentInteractionListener {
    fun onItemClick(item: LatestMovies)  //parameter item is of LatestMovies model
}