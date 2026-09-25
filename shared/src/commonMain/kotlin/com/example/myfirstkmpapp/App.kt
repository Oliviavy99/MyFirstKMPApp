package com.example.myfirstkmpapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.collectLatest

@Composable
fun App() {
    MaterialTheme {

        var berita by remember {
            mutableStateOf("Menunggu berita...")
        }

        LaunchedEffect(Unit) {
            newsFlow().collectLatest {
                berita = it.title
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {

            Text("News Feed Simulator")

            Text(
                text = berita,
                modifier = Modifier.padding(top = 20.dp)
            )
        }
    }
}