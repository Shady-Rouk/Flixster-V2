package com.example.flixsterv2

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.google.gson.Gson

class DetailActivity : AppCompatActivity() {
    private lateinit var movieBackdrop: ImageView
    private lateinit var movieTitle: TextView
    private lateinit var movieReleaseDate: TextView
    private lateinit var moviePopularity: TextView
    private lateinit var movieDescription: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        movieBackdrop = findViewById(R.id.movieBackdrop)
        movieTitle = findViewById(R.id.movieTitleDetail)
        movieReleaseDate = findViewById(R.id.movieReleaseDate)
        moviePopularity = findViewById(R.id.moviePopularity)
        movieDescription = findViewById(R.id.movieDescription)

        val movieJson = intent.getStringExtra(MOVIE_DETAIL)
        val gson = Gson()
        val movieObj = gson.fromJson(movieJson, UpcomingMovie::class.java)

        movieTitle.text = movieObj.title
        movieReleaseDate.text = "Release Date: ${movieObj.releaseDate}"
        moviePopularity.text = "Popularity Score: ${movieObj.popularity.toString()}"
        movieDescription.text = movieObj.description

        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w500" + movieObj.movieBackdropUrl)
            .centerInside()
            .transform(RoundedCorners(30))
            .into(movieBackdrop)
    }
}