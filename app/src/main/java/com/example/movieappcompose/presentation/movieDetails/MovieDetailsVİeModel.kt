package com.example.movieappcompose.presentation.movieDetails

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.movieappcompose.domain.useCase.getMovie.GetMovieDetailsUseCase
import com.example.movieappcompose.util.Constants.Companion.IMDB_ID
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MovieDetailsVieModel@Inject constructor(private val movieDetailsUseCase: GetMovieDetailsUseCase
    ,private val stateHandle: SavedStateHandle

): ViewModel() {


    private val _state= mutableStateOf(MovieDetailState())
    val state: State<MovieDetailState> = _state


    init {
        stateHandle.get<String>(IMDB_ID).let {

            if (it != null) {
                getMovieDetail(it)
            }
        }

    }


    fun getMovieDetail(imdbId:String){
        movieDetailsUseCase.executeGetMovieDetails(imdbId).onEach {

            _state.value= MovieDetailState(false,it)
        }


    }



}