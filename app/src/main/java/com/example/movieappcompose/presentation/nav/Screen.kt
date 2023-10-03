package com.example.movieappcompose.presentation.nav

sealed class Screen(val route:String){
    object MovieScreen:Screen("movie_screen")
    object MovideDetailsScreen:Screen("movie_details")


}
