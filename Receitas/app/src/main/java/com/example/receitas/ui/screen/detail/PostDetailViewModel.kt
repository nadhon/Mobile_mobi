package com.example.receitas.ui.screen.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.receitas.data.model.Post
import com.example.receitas.data.repository.PostRepository
import com.example.receitas.ui.State.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PostDetailViewModel (
    private val repository: PostRepository
) : ViewModel(){
    private val _uiState =
        MutableStateFlow<UiState<Post>>(UiState.Loading)
    val uiState: StateFlow<UiState<Post>> = _uiState

    fun loadPost(id: Int) {
        viewModelScope.launch {
            try{
                _uiState.value = UiState.Success(repository.getPostById(id))
            } catch(e: Exception) {
                _uiState.value = UiState.Error("Erro ao carregar detalhes")
            }
        }
    }
}