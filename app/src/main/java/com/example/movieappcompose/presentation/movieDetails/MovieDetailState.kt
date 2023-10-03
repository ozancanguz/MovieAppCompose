package com.example.movieappcompose.presentation.movieDetails

import com.example.movieappcompose.domain.model.MovieDetail

class MovieDetailState (

   val  isLoading:Boolean=false,
    val movieDetail: MovieDetail?=null,
    val search:String="batman"
)