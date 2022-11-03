package com.example.windsurf_race_start_app_wear_os.presentation.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.*
import com.example.windsurf_race_start_app_wear_os.presentation.state.UIState
import kotlinx.coroutines.delay

@Composable
fun CountdownScreen(uiState: UIState) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
//        CountdownButtons()
        Timer(uiState)
    }
}

@Composable
fun CountdownButtons() {
    
}

@Composable
fun Timer(uiState: UIState) {
    val currentFormat = uiState.currentCountdownFormat
    val isTimerStarted = uiState.isCountdownStarted
    val countdownSeconds = currentFormat * 60
    val countdown = uiState.countdown

    LaunchedEffect(key1 = countdown, key2 = isTimerStarted) {
        if(countdown != 0 && isTimerStarted) {
            if (countdown != countdownSeconds) delay(1000L)
            uiState.countdown()
        }
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
    ) {
        val minutes = countdown / 60
        val leftSeconds = countdown - minutes * 60
        val seconds = if(leftSeconds < 10) "0$leftSeconds" else leftSeconds

        Text("$minutes:$seconds", modifier = Modifier, Color.White, 75.sp, fontWeight = FontWeight.Bold)
    }
}
