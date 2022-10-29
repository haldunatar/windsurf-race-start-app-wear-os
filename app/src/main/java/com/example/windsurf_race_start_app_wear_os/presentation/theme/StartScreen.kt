package com.example.windsurf_race_start_app_wear_os.presentation.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun StartScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        TimePicker()
        StartButton()
    }
}

@Composable
fun TimePicker() {

}

@Composable
fun StartButton() {
    
}