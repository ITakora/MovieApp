package com.example.movieapp.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.data.api.API_KEY
import com.example.movieapp.data.api.movieService
import com.example.movieapp.data.models.MovieModel
import com.example.movieapp.data.models.MovieResponse
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private val _movieState = mutableStateOf(MovieState())
    val movieState : State<MovieState> = _movieState

    init {
        getMovies()
    }

    private fun getMovies () {
        viewModelScope.launch {
            try {
                val response = movieService.getApi(API_KEY.KEY)
                _movieState.value =_movieState.value.copy(
                    data = response.results,
                    loading = false,
                    error = null
                )
            }catch (e: Exception) {
                _movieState.value = _movieState.value.copy(
                    loading = false,
                    error ="Error ${e.message}"
                )
            }
        }
    }


    data class MovieState (
        val loading: Boolean = true,
        val data: List<MovieModel> = emptyList(),
        val error: String? = null
    )
}