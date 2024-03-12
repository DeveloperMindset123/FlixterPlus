package com.example.flixterplus

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Glide.*
import com.example.flixterplus.R.id  //allows us to write without typing R.id
import org.w3c.dom.Text


//file that will handle the recycler view aspect that is to be displayed
/**
 * The reycler view adapter [RecyclerView.adapter] that can display [LatestMovies] and makes a call to the specified [OnListFragmentInteractionListener]
 *
 * Image Base path, prepend: "https://image.tmdb.org/t/p/w500/"
 *
 * */
class LatestMoviesRecyclerViewAdapter(
    private val movies : List<LatestMovies>,  //note that we have defined the template for this within the fragment file (this is the class constructor
    private val mListener: OnListFragmentInteractionListener? //initialize mListener to null during initialization
) : RecyclerView.Adapter<LatestMoviesRecyclerViewAdapter.LatestMoviesViewHolder>()  //latestMoviesViewHolder will be defined below within the class body
{
    override fun onCreateViewHolder(  //specify the logic for what will happen upon creating the view holder, one of the three mandatory methods for any custom Recycler view adapter class
        parent: ViewGroup,
        viewType: Int
    ): LatestMoviesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_latest_movie, parent, false)
        return LatestMoviesViewHolder(view)  //add the wrapper LatestMoviesViewHolder around the view fragment
    }

    /**
     * The inner class lets us refer to all the different view components
     *
     * */
    inner class LatestMoviesViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        //define the views releated to the xml file, notice that they are all define as view and at the end their respective viewtype is specified
        var mItem : LatestMovies? = null  //set to null if the movie doesn't exist
        val mMovieTitle : TextView = mView.findViewById<View>(id.Movie_title) as TextView
        //val mMovieDirector : TextView = mView.findViewById<View>(id.Movie_Director) as TextView
        val mBookId : TextView = mView.findViewById<View>(id.MovieId) as TextView
        val mMovieDescription : TextView = mView.findViewById<View>(id.Movie_description) as TextView
        val mMovieImage : ImageView = mView.findViewById<View>(id.Movie_image) as ImageView
        val mMovieId : TextView = mView.findViewById<View>(id.MovieId) as TextView  //extract the movie id from the data model


        //val mMovieButton : Button = mView.findViewById<View>(R.id.movie_button) as Button  ==> did not define this view, will lead to error if I were to uncomment this right now

        //override the default logic for the preexisting function toString
        /**  --> is this function neccessary?
        override fun toString() : String {
            return mMovieTitle.toString() + " '" + mMovieDirector.text + "'"
        } */
    }

    /**
     * This lets us "bind" views in the ViewHolder to it's actual data
     *
     * */
//continue here
    override fun onBindViewHolder(holder: LatestMoviesViewHolder, position: Int) {
        val movie = movies[position]

        //set the text content view to the strings from the json response
        holder.mItem = movie
        holder.mMovieTitle.text = movie.movieTitle
        //holder.mMovieDirector.text = movie.ovmieDirector --> didn't define this in the data model
        holder.mMovieDescription.text = movie.movieOverview
        holder.mMovieId.text = movie.id.toString()  //convert the integer value to string, otherwise, we cannot use the TextView setter

            /**  --> the json response doesn't return any url
        holder.mMovieButton.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(placeholder_url))
            startActivity(it.context, browserIntent, null)
        }
        */

        //use glide for the movie image view
        var image_base_path : String = "https://image.tmdb.org/t/p/w500/"
        with(holder.mView)
            .load(image_base_path + "/" + movie.moviePosterPath)
            .centerInside()
            .into(holder.mMovieImage)

        //upon clicking the image, logic to display the toast message defined within LatestMoviesFragment
        holder.mView.setOnClickListener {
            holder.mItem?.let {
                movie ->
                    mListener?.onItemClick(movie)
            }
        }
    }
    /**
     * Remember that RecyclerView adapter requires a getItemCount() member method
     *
     * */
    override fun getItemCount(): Int {
        return movies.size  //retrieve the length of the movies array
    }
}