package com.example.movieappcompose.domain.useCase.getMovie

import android.util.Log
import com.example.movieappcompose.data.dto.toMovieDetail
import com.example.movieappcompose.data.dto.toMovieList
import com.example.movieappcompose.domain.model.Movie
import com.example.movieappcompose.domain.model.MovieDetail
import com.example.movieappcompose.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOError
import javax.inject.Inject

class GetMovieDetailsUseCase@Inject constructor(private val movieRepository: MovieRepository) {

    fun executeGetMovieDetails(imdbId:String): Flow<MovieDetail> = flow{

        try {
            val movieDetail=movieRepository.getMovieDetails(imdbId)
              emit(movieDetail.toMovieDetail())

        }catch (e: IOError){
            Log.d("no data","no data")
        }


    }

}