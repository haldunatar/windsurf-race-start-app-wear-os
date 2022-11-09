package com.example.windsurf_race_start_app_wear_os.presentation.screens

import android.content.Context
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
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import androidx.annotation.RequiresApi
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.*
import com.example.windsurf_race_start_app_wear_os.presentation.state.UIState
import kotlinx.coroutines.delay

@RequiresApi(Build.VERSION_CODES.Q)
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


@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun Timer(uiState: UIState) {
    val isTimerStarted = uiState.isCountdownStarted
    val isTimerStopped = uiState.isCountdownStopped
    val countdown = uiState.countdown
    val vibrator = LocalContext.current.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

    LaunchedEffect(key1 = countdown, key2 = isTimerStarted, key3 = isTimerStopped) {
        if(countdown != 0 && isTimerStarted && !isTimerStopped) {
            delay(1000L)
            if (countdown == 60) {
                vibrator.cancel()
                vibrator.vibrate(vibrationEffect(1000, VibrationEffect.DEFAULT_AMPLITUDE))
            }
            if (countdown in (0..10)) {
                vibrator.cancel()
                vibrator.vibrate(vibrationEffect(500, VibrationEffect.EFFECT_TICK))
            }

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

        Text(
            "$minutes:$seconds",
            modifier = Modifier.clickable {
                if (uiState.countdown != 0) {
                    uiState.updateIsCountdownStoppedState(!uiState.isCountdownStopped)
                }

            },
            Color.White, 85.sp, fontWeight = FontWeight.Bold
        )
    }
}

fun vibrationEffect(time: Long, effect: Int): VibrationEffect {
    return VibrationEffect.createOneShot(time, effect)
}