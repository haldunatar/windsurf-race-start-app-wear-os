package com.example.windsurf_race_start_app_wear_os.presentation.theme

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Refresh
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
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        AnimatedVisibility(visible = uiState.isCountdownStopped) {
            CountdownButtons(uiState)
        }
        Timer(uiState)
    }
}

@Composable
fun CountdownButtons(uiState: UIState) {
    Row(
        modifier = Modifier
            .fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.Top
    ) {
        Button(onClick = {
            uiState.updateCountdown(uiState.currentCountdownFormat * 60)
            uiState.updateIsCountdownStoppedState(false)
        }) {
            Icon(
                Icons.Filled.Refresh,
                contentDescription = "Refresh",
                modifier = Modifier.size(ButtonDefaults.ExtraSmallButtonSize)
            )
        }
        Button(onClick = {
            uiState.resetState()
        }) {
            Icon(
                Icons.Filled.Close,
                contentDescription = "Close",
                modifier = Modifier.size(ButtonDefaults.ExtraSmallButtonSize)
            )
        }
    }
}

@Composable
fun Timer(uiState: UIState) {
    val isTimerStarted = uiState.isCountdownStarted
    val isTimerStopped = uiState.isCountdownStopped
    val countdown = uiState.countdown

    LaunchedEffect(key1 = countdown, key2 = isTimerStarted, key3 = isTimerStopped) {
        if(countdown != 0 && isTimerStarted && !isTimerStopped) {
            delay(1000L)
            uiState.countdown()
        } else if (countdown == 0) {
            uiState.updateIsCountdownStoppedState(true)
        }
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        val minutes = countdown / 60
        val leftSeconds = countdown - minutes * 60
        val seconds = if (leftSeconds < 10) "0$leftSeconds" else leftSeconds

        Text("$minutes:$seconds",
            modifier = Modifier.clickable {
                if (uiState.countdown != 0) {
                    uiState.updateIsCountdownStoppedState(!uiState.isCountdownStopped)
                }

            },
            Color.White, 85.sp, fontWeight = FontWeight.Bold)
    }
}
