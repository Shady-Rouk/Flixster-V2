package com.example.flixsterv2

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.google.gson.Gson

const val MOVIE_DETAIL = "MOVIE_DETAIL"

class UpcomingMovieRecyclerViewAdapter (
    private val models: List<UpcomingMovie>,
    private val context: Context)
    : RecyclerView.Adapter<UpcomingMovieRecyclerViewAdapter.MovieViewHolder>(){

        class MovieViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
            var mItem: UpcomingMovie? = null
            val mMovieTitle: TextView = mView.findViewById<View>(R.id.movieTitleMain) as TextView
            val mMoviePoster: ImageView = mView.findViewById<View>(R.id.moviePoster) as ImageView
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_movie_item, parent, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int {
        return models.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = models[position]

        holder.mItem = movie
        holder.mMovieTitle.text = movie.title

        Glide.with(holder.mView)
            .load("https://image.tmdb.org/t/p/w500" + movie.moviePosterUrl)
            .centerInside()
            .transform(RoundedCorners(30))
            .into(holder.mMoviePoster)

        val gson = Gson()
        val movieJson = gson.toJson(movie)
        holder.mView.setOnClickListener {
            // launch details
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(MOVIE_DETAIL, movieJson)
            context.startActivity(intent)
        }
    }
}