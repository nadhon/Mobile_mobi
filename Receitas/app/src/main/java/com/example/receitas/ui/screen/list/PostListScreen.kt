package com.example.receitas.ui.screen.list

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.navigation.NavController
import com.example.receitas.data.model.Post
import com.example.receitas.ui.State.UiState
import com.example.receitas.ui.components.PostItem
import androidx.compose.foundation.lazy.items

@Composable
fun PostListScreen(
    navController: NavController,
    viewModel: PostListViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    val state by viewModel.uiState.collectAsState()
    when(state){
        is UiState.Loading -> CircularProgressIndicator()

        is UiState.Error ->
            Text((state as UiState.Error).message)

        is UiState.Success -> {
            LazyColumn {
                items(
                    items = (state as UiState.Success<List<Post>>).data
                ) { post ->
                    PostItem(post) {
                        navController.navigate("detail/${post.id}")
                    }
                }
            }

        }
    }
}