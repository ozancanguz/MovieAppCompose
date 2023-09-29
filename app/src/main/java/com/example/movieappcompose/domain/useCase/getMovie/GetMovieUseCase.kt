package com.example.movieappcompose.domain.useCase.getMovie

import android.util.Log
import com.bumptech.glide.load.engine.Resource
import com.example.movieappcompose.data.dto.toMovieList
import com.example.movieappcompose.domain.model.Movie
import com.example.movieappcompose.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOError


import javax.inject.Inject

class GetMovieUseCase@Inject constructor(private val movieRepo:MovieRepository) {


    fun executeGetMovies(search:String): Flow<List<Movie>> = flow{

        try {
            val movieList=movieRepo.getMovies(search)
            if(movieList.Response.equals("True")){
                emit(movieList.toMovieList())
            }

        }catch (e:IOError){
            Log.d("no data","no data")
        }


    }
}