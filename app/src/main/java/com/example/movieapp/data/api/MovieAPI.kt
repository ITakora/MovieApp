package com.example.movieapp.data.api

import com.example.movieapp.data.models.MovieResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


val retrofit = Retrofit.Builder().baseUrl(MovieAPI.BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

interface MovieAPI {

    @GET("day")
    suspend fun getApi (
        @Query("api_key") apiKey : String
    ): MovieResponse


    companion object{
        const val BASE_URL : String = "https://api.themoviedb.org/3/trending/all/"
    }

}

val movieService = retrofit.create(MovieAPI::class.java)

