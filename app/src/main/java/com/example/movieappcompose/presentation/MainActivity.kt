package com.example.movieappcompose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movieappcompose.presentation.nav.MovieDetailsScreen
import com.example.movieappcompose.presentation.nav.MovieScreen
import com.example.movieappcompose.presentation.nav.Screen
import com.example.movieappcompose.ui.theme.MovieAppComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    // api key ce8d4496
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            //navcontroller
            val navController= rememberNavController()

            // navhost
            NavHost(navController =navController , startDestination = Screen.MovieScreen .route){

                composable(Screen.MovieScreen.route){
                    MovieScreen()

                }


                composable(Screen.MovideDetailsScreen.route){
                    MovieDetailsScreen()
                }

            }


        }
    }
}

