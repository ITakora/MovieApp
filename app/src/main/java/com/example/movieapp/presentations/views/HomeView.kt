package com.example.movieapp.presentations.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.movieapp.data.models.MovieModel
import com.example.movieapp.presentations.items.GridItem
import com.example.movieapp.viewmodels.MainViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(viewState: MainViewModel.MovieState,  navToDetail: (MovieModel) -> Unit) {

    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        TopAppBar( colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent),title = { Text(text = "Movies")})
    } ) {innerPadding ->

        Column(modifier = Modifier.background(color = Color.Gray).padding(innerPadding.calculateBottomPadding()).padding(top = 26.dp).fillMaxSize(),verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {

            GridItem(data = viewState.data, navToDetail = navToDetail )

        }
    }

}