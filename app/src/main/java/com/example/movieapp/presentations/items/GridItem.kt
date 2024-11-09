package com.example.movieapp.presentations.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImagePainter

import coil3.compose.LocalPlatformContext
import coil3.compose.SubcomposeAsyncImage
import coil3.compose.rememberAsyncImagePainter

import com.example.movieapp.data.models.MovieModel



@Composable
fun GridItem(data: List<MovieModel>, navToDetail: (MovieModel) -> Unit) {
    LazyVerticalGrid(GridCells.Fixed(2), modifier = Modifier
        .fillMaxSize()
        .padding(top = 45.dp)) {
        items(data) {
            movie -> ImageTextItem(movie = movie, navToDetail = navToDetail)

        }

    }
}


@Composable
fun ImageTextItem( movie:MovieModel, navToDetail: (MovieModel) -> Unit) {


    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize()
            .clickable { navToDetail(movie) },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Card(
            shape = RoundedCornerShape(8.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
            modifier = Modifier
                .height(210.dp)
                .width(150.dp),
            colors = CardDefaults.cardColors(Color.White),
        ) {
                //https://image.tmdb.org/t/p/original/${movie.poster_path}
            val painter = rememberAsyncImagePainter("https://image.tmdb.org/t/p/original/${movie.poster_path}")
            when (painter.state.collectAsState().value) {
                is AsyncImagePainter.State.Empty -> {
                    Text(text = "404")
                }
                
                is AsyncImagePainter.State.Loading -> {
                    CircularProgressIndicator(modifier = Modifier.fillMaxHeight().align(alignment = Alignment.CenterHorizontally))
                }
                is AsyncImagePainter.State.Success -> {
                    Image(
                        painter = painter,
                        contentDescription = "Thumbnail",
                        alignment = Alignment.Center,
                        contentScale = ContentScale.Crop,
                       
                    )
                }
                is AsyncImagePainter.State.Error -> {


                }
            }

        }


        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = movie.title ?: "This is Title",

            color = Color.Black,
            style = TextStyle(fontWeight = FontWeight.Bold, textAlign = TextAlign.Center),
            modifier = Modifier.padding(top = 4.dp, bottom = 8.dp)
        )

    }
}