package com.example.receitas.data.remote.api
import com.example.receitas.data.model.Post
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("posts")
    suspend fun  getPosts(): List<Post>

    @GET("posts/{id}")
    suspend fun GetPostByID(@Path("id") id: Int): Post
}