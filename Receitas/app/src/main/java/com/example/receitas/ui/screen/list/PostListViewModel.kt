package com.example.receitas.ui.screen.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.receitas.data.model.Post
import com.example.receitas.data.repository.PostRepository
import com.example.receitas.ui.State.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PostListViewModel (
    private val repository: PostRepository
) : ViewModel(){
    private val _uiState =
        MutableStateFlow<UiState<List<Post>>>(UiState.Loading)
    val uiState: StateFlow<UiState<List<Post>>> = _uiState

    init {
        loadPosts()
    }
    private fun loadPosts(){
        viewModelScope.launch {
            try {
                val posts = repository.getPosts()
                _uiState.value = UiState.Success(posts)
            } catch(e: Exception) {
                _uiState.value = UiState.Error("Erro ao carregar post")
            }
        }
    }
}