package com.example.movieapp.data.models


import android.os.Parcelable

import kotlinx.parcelize.Parcelize


@Parcelize
data class MovieModel(
//    val adult: Boolean ,
//    @SerializedName("backdrop_path")
//    val backdropPath: String = "",
//    @SerializedName("original_language")
//    val originalLanguage: String = "",
//    @SerializedName("original_title")
//    val originalTitle: String = "",

    val overview: String ,

    val popularity: Double,
//    @SerializedName("poster_path")
    val poster_path: String,
//    @SerializedName("release_date")
//    val releaseDate: String = "",
    val title: String ,
//    @SerializedName("vote_average")
//    val voteAverage: Double = 0.0,
//    @SerializedName("vote_count")
//    val voteCount: Int = 0
): Parcelable

data class MovieResponse (val results:List<MovieModel>)