package com.example.receitas.ui.screen.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.receitas.data.model.Post
import com.example.receitas.ui.State.UiState

@Composable
fun PostDetailScreen(
    id: Int,
    viewModel: PostDetailViewModel = hiltViewModel()
) {
    LaunchedEffect(id) {
        viewModel.loadPost(id)
    }

    val state by viewModel.uiState.collectAsState()

    when (state) {
        is UiState.Loading -> CircularProgressIndicator()
        is UiState.Error -> Text("Erro")
        is UiState.Success<*> -> {
            val post = (state as UiState.Success<Post>).data
            Column(modifier = Modifier.padding(16.dp)) {
                Text(post.title, fontSize = 20.sp)
                Text(post.body)
            }
        }
    }
}
