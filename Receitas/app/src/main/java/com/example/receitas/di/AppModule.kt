package com.example.receitas.di

import com.example.receitas.data.remote.api.ApiService
import com.example.receitas.data.remote.RetrofitClient

object AppModule {
    
    private val api = RetrofitClient.api
    
    val postRepository = postRepository(api)

    private fun postRepository(api: ApiService) {}
}