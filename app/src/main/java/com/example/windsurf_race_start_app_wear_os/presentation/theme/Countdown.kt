package com.example.windsurf_race_start_app_wear_os.presentation.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CountdownScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        Countdown()
        CountdownButtons()
    }
}

@Composable
fun Countdown() {

}

@Composable
fun CountdownButtons() {
    
}