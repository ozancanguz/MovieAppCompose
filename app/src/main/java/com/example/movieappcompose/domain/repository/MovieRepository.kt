package com.example.movieappcompose.domain.repository

import com.example.movieappcompose.data.dto.MovieDetailDto
import com.example.movieappcompose.data.dto.Movies

interface MovieRepository {


    suspend fun getMovies(search:String): Movies
    suspend fun getMovieDetails(imdbId:String):MovieDetailDto

}