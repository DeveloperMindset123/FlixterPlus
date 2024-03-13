package com.example.flixterplus

import android.os.Bundle
import android.text.Layout
import android.util.Log
import android.view.LayoutInflater
import android.view.PixelCopy.Request
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.ContentLoadingProgressBar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.GridLayoutManager
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.RequestParams
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.Headers
import org.json.JSONArray
import org.json.JSONObject


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
        val view = inflater.inflate(R.layout.fragment_latest_movies_list, container, false)
        val progressBar = view.findViewById<View>(R.id.progress) as ContentLoadingProgressBar  //this will handle the progress bar animation
        val recyclerView = view.findViewById<View>(R.id.RecyclerViewList) as RecyclerView  //note: needed to specify as RecycelrView in order for the error not to occur
        val context = view.context

        //note that since the extension named layoutManager hasn't been created in the adapter file, it will cause an error
        recyclerView.layoutManager = GridLayoutManager(context, 1)  //set to 1 since we want each movie to be displayed in one row
        updateAdapter(progressBar, recyclerView)
        return view
    }

    //Function logic for updateAdapter
    /**
     * Updataes the recycler view adapter with new data
     * Networking logic occurs here
     *
     * Function accepts two parameters, progressBar view and the recycler view
     *
     * */

    private fun updateAdapter(progressBar: ContentLoadingProgressBar, recyclerView: RecyclerView) {
        progressBar.show()  //display the progress bar while the data is being fetched

        //create and set up an Async HTTP client()
        val client = AsyncHttpClient()
        val params = RequestParams()

        params["api-key"]= API_KEY  //TO:DO: This may require adjustment, depending on the query parameters of the api call

        //using the client, perform the HTTP request
        client["https://api.themoviedb.org/3/movie/now_playing?&api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed", params, object :
        JsonHttpResponseHandler() {
            /**
             * The onSuccess function function gets called when HTTP request status is "200" OK
             *
             * */

            override fun onSuccess(
                statusCode: Int,
                headers: Headers,  //allow for null values on the onSuccess payload
                json: JsonHttpResponseHandler.JSON) {

                //the wait for the response is over
                progressBar.hide()  //this will stop the loading animation in order to display the result

                //determine additonal logic to take place
                //print out the api onSuccess response using log.i
                Log.i("Status code", statusCode.toString())  //convert the status code into a string and print it out
                Log.i("Headers", headers.toString())  //print out information pertaining to the header
                Log.i("Json Response:", json.jsonObject.toString())  //log the result json response in string format

                //note, the following two lines of code may require adjustment depending on the result
                // Assuming 'results' is an array in your JSON structure (refer to MovieData.json file to see how a sample api response looks like --> results is a json array, not a json object, attempting to retrieve it as a jsonObject will cause an type mismatch
                val resultsJsonArray: JSONArray = json.jsonObject.getJSONArray("results")

                val moviesRawJson : String = resultsJsonArray.toString()  //convert jsonArray to string

                //parse JSON into models
                val gson = Gson()
                val arrayMovieType = object : TypeToken<List<LatestMovies>>() {}.type  //retrieve the type the array consists of (which is of LatestMovies type contained within a list)

                //create the model we will feed into recycler view adapter
                val models : List<LatestMovies> = gson.fromJson(moviesRawJson, arrayMovieType)

                //modified to set adapter to the customer adapter class that was defined (refer to LatestMoviesRecyclerViewAdapter)
                recyclerView.adapter = LatestMoviesRecyclerViewAdapter(models, this@LatestMoviesFragment)
                //refer to the logcat for changes
                Log.d("LatestMoviesFragment", "Response Successful")
            }

            //Now call on the onFailure function, i.e (HTTP response is "4XX" (eg. 401, 403, 404)

            override fun onFailure(  //theoretically, this is what will display since I am offline atm
                statusCode: Int,
                headers: Headers?,
                errorResponse: String,
                throwable: Throwable?
            ) {
                //wait for the response is now over
                progressBar.hide()

                //in the case that the error is not null, log it
                throwable?.let {
                    Log.e("LatestMoviesFragment", errorResponse)
                }
            }
        }]


    }
    override fun onItemClick(item: LatestMovies) {  //default generated when extensions Fragment() and OnListFragmentInteractionListener is added (since we defined onItemClick function within interface onListFragmentInteractionListener
        //display the title of the movie
        Toast.makeText(context, "Movie Title: " + item.movieTitle, Toast.LENGTH_SHORT).show()


    }

}

/*
private fun RecyclerView.adapter(models: List<LatestMovies>, latestMoviesFragment: LatestMoviesFragment) {

}
*/