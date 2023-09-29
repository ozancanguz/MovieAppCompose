package com.example.movieappcompose.data.remote

import com.example.movieappcompose.data.dto.MovieDetailDto
import com.example.movieappcompose.data.dto.Movies
import com.example.movieappcompose.util.Constants.Companion.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPI{

    // https://omdbapi.com/?apiKey=ce8d4496&s=batman
    // https://omdbapi.com/?apiKey=ce8d4496&i=tt0372784

    @GET(".")
      suspend fun getMovies(
          @Query("s")searchString:String,
          @Query("apiKey")apiKey:String=API_KEY
      ): Movies



      @GET(".")
      suspend fun getMovieDetails(
          @Query("i")imdbId:String,
          @Query("apiKey")apiKey:String=API_KEY):MovieDetailDto

}