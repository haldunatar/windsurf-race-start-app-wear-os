package com.example.windsurf_race_start_app_wear_os.presentation

import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.wear.compose.material.MaterialTheme
import com.example.windsurf_race_start_app_wear_os.presentation.state.UIState
import com.example.windsurf_race_start_app_wear_os.presentation.screens.CountdownScreen
import com.example.windsurf_race_start_app_wear_os.presentation.screens.StartScreen
import com.example.windsurf_race_start_app_wear_os.presentation.utils.constants.*

class MainActivity : ComponentActivity() {

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /* Prevent timeout activity */
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        setContent {
            App()
        }
    }
}

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun App() {
    /* is the type of the screen that will be shown: Start or Countdown */
    val viewTypeState = rememberSaveable { mutableStateOf(defaultViewTypeState) }
    /* is the duration of chosen countdown format(default 4): 4 minutes of 3 minutes */
    val countdownFormat = rememberSaveable { mutableStateOf(defaultCountdownFormat) }
    /* countdown toggle state: true or false */
    val isCountdownStarted = rememberSaveable { mutableStateOf(defaultIsCountdownStarted) }
    /* countdown toggle state: true or false */
    val isCountdownStopped = rememberSaveable { mutableStateOf(defaultIsCountdownStopped) }
    /* is the current state of countdown that decreased */
    val currentCountDownState =  rememberSaveable { mutableStateOf(defaultCountdownFormat * 60) }

    val uiState = UIState(viewTypeState, countdownFormat, isCountdownStarted, isCountdownStopped, currentCountDownState)

    MaterialTheme(
        colors = MaterialTheme.colors,
        typography = MaterialTheme.typography,
        shapes = MaterialTheme.shapes
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black),
        ) {
            if (uiState.currentViewType == startScreen) {
                StartScreen(uiState)
            } else {
                CountdownScreen(uiState)
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.Q)
@Preview(device = Devices.WEAR_OS_SMALL_ROUND, showSystemUi = true)
@Composable
fun DefaultPreview() {
    App()
}