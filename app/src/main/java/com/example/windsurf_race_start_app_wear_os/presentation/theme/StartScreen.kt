package com.example.windsurf_race_start_app_wear_os.presentation.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.wear.compose.material.*
import com.example.windsurf_race_start_app_wear_os.presentation.state.UIState
import com.example.windsurf_race_start_app_wear_os.presentation.utils.constants.countdownScreen

@Composable
fun StartScreen(
    uiState: UIState
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CountdownFormatOptions(uiState)
        StartButton(uiState)
    }
}

@SuppressLint()
@Composable
fun CountdownFormatOptions(uiState: UIState) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        CountdownFormatOptionButton(3, uiState.currentCountdownFormat, "3 min.") {
            uiState.updateStartFormatState(it)
            uiState.updateCountdown(it * 60)
        }
        CountdownFormatOptionButton(4, uiState.currentCountdownFormat, "4 min.") {
            uiState.updateStartFormatState(it)
            uiState.updateCountdown(it * 60)
        }
    }
}

@Composable
fun CountdownFormatOptionButton(
    defaultFormatValue: Int,
    currentFormat: Int,
    label: String,
    updateFormatState: (Int) -> Unit
) {
    Button(
        onClick = {
            updateFormatState(defaultFormatValue)
        },
        modifier = Modifier,
        enabled = true,
        colors = if (currentFormat == defaultFormatValue) {
            ButtonDefaults.primaryButtonColors()
        } else {
            ButtonDefaults.secondaryButtonColors()
        }
    ) { Text(label) }
}

@Composable
fun StartButton(uiState: UIState) {
    Button(
        onClick = {
            uiState.updateViewTypeState(countdownScreen)
            uiState.updateIsCountdownStartedState(true)
        },
    ) {
        Text("Start")
    }
}
