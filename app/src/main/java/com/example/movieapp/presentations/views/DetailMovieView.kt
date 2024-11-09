package com.example.movieapp.presentations.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.movieapp.data.models.MovieModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailMovieView(modifier: Modifier = Modifier, dataMovie: MovieModel, navBack: () -> Unit) {
        Scaffold(
            topBar = {
                TopAppBar( colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Gray),title = { Text(text = dataMovie.title)}, navigationIcon = {
                    IconButton(onClick = navBack) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Localized Desk")
                    }
                } )



            }
        ) { paddingValues ->
            Column(modifier.padding(paddingValues).fillMaxSize().background(Color.Gray)) {

            }

        }
}