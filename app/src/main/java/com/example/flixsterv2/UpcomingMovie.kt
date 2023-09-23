package com.example.flixsterv2

import android.support.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Keep
@Serializable
class UpcomingMovie {
    @JvmField
    @SerializedName("title")
    var title: String? = null

    @SerializedName("overview")
    var description: String? = null

    @SerializedName("poster_path")
    var moviePosterUrl: String? = null

    @SerializedName("backdrop_path")
    var movieBackdropUrl: String? = null

    @SerializedName("popularity")
    var popularity: Double? = null

    @SerializedName("release_date")
    var releaseDate: String? = null
}