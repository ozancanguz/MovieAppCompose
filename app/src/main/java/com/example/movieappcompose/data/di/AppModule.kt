package com.example.movieappcompose.data.di

import com.example.movieappcompose.data.remote.MovieAPI
import com.example.movieappcompose.data.repository.MovieRepositoryImplementation
import com.example.movieappcompose.domain.repository.MovieRepository
import com.example.movieappcompose.util.Constants.Companion.BASE_URL
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

object AppModule {


    @Provides
    @Singleton
    fun provideMovieApi():MovieAPI{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieAPI::class.java)
    }


    @Provides
    @Singleton
    fun provideMovieRepository(api: MovieAPI):MovieRepository{
        return MovieRepositoryImplementation(api)
    }


}