package com.example.flixterplus

import com.google.gson.annotations.SerializedName


//This is the movie data model file, refer to the json file for the sample response
class LatestMovies {
    @SerializedName("")

}

/**
 * Below represents a sample snippet of what the json file looks like:
 *
 *   "page": 2,
 *   "results": [{
 *     "adult": false,
 *     "backdrop_path": "/9xvBGz7wYjK5faoeXDIaBB9EYDx.jpg",
 *     "genre_ids": [10749, 18, 35],
 *     "id": 1139566,
 *     "original_language": "es",
 *     "original_title": "A través de mi ventana 3: A través de tu mirada",
 *     "overview": "After the events of the summer, Ares and Raquel they don't see a way forward in their relationship and decide to go separate ways. But when they meet again in the winter in Barcelona, the love and desire they feel for each other is undeniable. Will they be able to find a way to get back together?",
 *     "popularity": 464.763,
 *     "poster_path": "/gwpTgtwVAwmvivBN8rAQABpx9Am.jpg",
 *     "release_date": "2024-02-23",
 *     "title": "Through My Window 3: Looking at You",
 *     "video": false,
 *     "vote_average": 6.898,
 *     "vote_count": 266
 *   }, {
 *     "adult": false,
 *     "backdrop_path": "/zLj0peaxy5y2SlC6wNIQ4V0pfqg.jpg",
 *     "genre_ids": [16, 10751, 35, 14],
 *     "id": 1139829,
 *     "original_language": "en",
 *     "original_title": "Orion and the Dark",
 *     "overview": "A boy with an active imagination faces his fears on an unforgettable journey through the night with his new friend: a giant, smiling creature named Dark.",
 *     "popularity": 443.103,
 *     "poster_path": "/uHiXFLMlnl5jBjtfOliapN16yBD.jpg",
 *     "release_date": "2024-02-01",
 *     "title": "Orion and the Dark",
 *     "video": false,
 *     "vote_average": 6.661,
 *     "vote_count": 313
 *   }, {
 *     "adult": false,
 *     "backdrop_path": "/spsQPNKFwrvpFs7qyQz24Oh0Mhc.jpg",
 *     "genre_ids": [27, 53],
 *     "id": 823491,
 *     "original_language": "en",
 *     "original_title": "Out of Darkness",
 *     "overview": "In the Old Stone Age, a disparate gang of early humans band together in search of a new land. But when they suspect a malevolent, mystical, being is hunting them down, the clan are forced to confront a danger they never envisaged.",
 *     "popularity": 414.297,
 *     "poster_path": "/9tG77VE7bP8ve79X86ABwHzDqbb.jpg",
 *     "release_date": "2024-02-09",
 *     "title": "Out of Darkness",
 *     "video": false,
 *     "vote_average": 5.286,
 *     "vote_count": 14
 *   },
 * */