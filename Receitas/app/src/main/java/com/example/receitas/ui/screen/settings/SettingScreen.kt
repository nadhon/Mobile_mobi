package com.example.receitas.ui.screen.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SettingsScreen() {
    var checked by remember { mutableStateOf(true) }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Reconfigures")
        Switch(
            checked = checked,
            onCheckedChange = { checked = it }
        )
    }
}