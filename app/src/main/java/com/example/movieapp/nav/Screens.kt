package com.example.movieapp.nav

sealed class Screens(val route:String) {
    data object HomeView:Screens("homeView")
    data object DetailMovieView:Screens("detailMovieView")
}