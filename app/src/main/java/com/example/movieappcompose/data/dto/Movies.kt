package com.example.movieappcompose.data.dto

import android.graphics.Movie

data class Movies(
    val Response: String,
    val Search: List<Search>,
    val totalResults: String
)

fun Movies.toMovieList():List<com.example.movieappcompose.domain.model.Movie>{

    return Search.map { search ->
        com.example.movieappcompose.domain.model.Movie(search.Poster,search.Title,search.Year,search.imdbID)

    }
}