package com.example.movieapp.nav

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.movieapp.data.models.MovieModel
import com.example.movieapp.presentations.views.DetailMovieView
import com.example.movieapp.presentations.views.HomeView
import com.example.movieapp.viewmodels.MainViewModel

@Composable
fun MovieNav(navHostController: NavHostController) {
    val movieStateModel: MainViewModel = viewModel()
    val viewState by movieStateModel.movieState

    Column(modifier = Modifier.fillMaxSize().background(Color.Gray), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        when {
            viewState.loading -> {
                CircularProgressIndicator(Modifier.align(alignment = Alignment.CenterHorizontally))
            }

            viewState.error != null -> {
                Text(text = "${viewState.error}",Modifier.align(alignment = Alignment.CenterHorizontally) )
            }

            else ->{
                HomeView(viewState = viewState) {

                }
            }
        }
    }

    NavHost(navController = navHostController, startDestination = Screens.HomeView.route ) {
        composable(route = Screens.HomeView.route) {
            HomeView( viewState = viewState,navToDetail = {
                navHostController.currentBackStackEntry?.savedStateHandle?.set("data", it)
                navHostController.navigate(Screens.DetailMovieView.route)
            })



        }

        composable(route = Screens.DetailMovieView.route) {
            val category = navHostController.previousBackStackEntry?.savedStateHandle?.get<MovieModel>("data") ?:
            MovieModel(overview = "", title = "", popularity = 0.0, poster_path = "")
            DetailMovieView(dataMovie = category) {
                navHostController.popBackStack()
            }
        }

    }

}