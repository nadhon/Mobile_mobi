package com.example.receitas.data.repository

import com.example.receitas.data.remote.api.ApiService
import com.example.receitas.data.model.Post



class PostRepository(private val api: ApiService) {
    suspend fun getPosts(): List<Post>{
        return api.getPosts()
    }
    suspend fun getPostById(id: Int): Post{
        return api.GetPostByID(id)
    }
}
