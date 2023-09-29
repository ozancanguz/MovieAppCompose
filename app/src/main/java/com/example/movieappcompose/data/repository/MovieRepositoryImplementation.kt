package com.example.movieappcompose.data.repository

import com.example.movieappcompose.data.dto.MovieDetailDto
import com.example.movieappcompose.data.dto.Movies
import com.example.movieappcompose.data.remote.MovieAPI
import com.example.movieappcompose.domain.repository.MovieRepository
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject
@ViewModelScoped
class MovieRepositoryImplementation@Inject constructor(private val movieApi:MovieAPI):MovieRepository {
    override suspend fun getMovies(search: String): Movies {

        return movieApi.getMovies(search)
    }

    override suspend fun getMovieDetails(imdbId: String): MovieDetailDto {
       return movieApi.getMovieDetails(imdbId)
    }

}