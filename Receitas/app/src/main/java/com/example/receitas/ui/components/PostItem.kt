package com.example.receitas.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.receitas.data.model.Post

@Composable
fun PostItem(post: Post, onClick:() -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() }
    ){
        Column(Modifier.padding(16.dp)){
            Text(post.title, fontWeight = FontWeight.Bold)
            Text(post.body, maxLines = 2)

        }
    }
}