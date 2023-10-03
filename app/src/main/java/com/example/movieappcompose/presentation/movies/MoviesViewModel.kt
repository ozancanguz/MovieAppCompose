package com.example.movieappcompose.presentation.movies

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieappcompose.domain.useCase.getMovie.GetMovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class MoviesViewModel@Inject constructor(private val getMovieUseCase: GetMovieUseCase): ViewModel() {



    private val _state= mutableStateOf<MoviesState>(MoviesState())
    val state: State<MoviesState> =_state


    private var job: Job? =null

    fun getMovies(search:String){

        job?.cancel()

         job=  getMovieUseCase.executeGetMovies(search).onEach {

             _state.value=MoviesState(false,it)



      }.launchIn(viewModelScope)

    }



}