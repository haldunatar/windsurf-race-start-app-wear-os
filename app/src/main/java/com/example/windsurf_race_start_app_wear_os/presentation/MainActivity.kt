/* While this template provides a good starting point for using Wear Compose, you can always
 * take a look at https://github.com/android/wear-os-samples/tree/main/ComposeStarter and
 * https://github.com/android/wear-os-samples/tree/main/ComposeAdvanced to find the most up to date
 * changes to the libraries and their usages.
 */

package com.example.windsurf_race_start_app_wear_os.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.wear.compose.material.MaterialTheme
import com.example.windsurf_race_start_app_wear_os.presentation.state.UIState
import com.example.windsurf_race_start_app_wear_os.presentation.theme.CountdownScreen
import com.example.windsurf_race_start_app_wear_os.presentation.theme.StartScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    val defaultCountdownFormat = 4
    /* is the type of the screen that will be shown: Start or Countdown */
    val viewTypeState = rememberSaveable { mutableStateOf("Start") }
    /* is the duration of chosen countdown format(default 4): 4 minutes of 3 minutes */
    val countdownFormat = rememberSaveable { mutableStateOf(defaultCountdownFormat) }
    /* countdown toggle state: true or false */
    val isCountdownStarted = rememberSaveable { mutableStateOf(false) }
    /* is the current state of countdown that decreased */
    val currentCountDownState =  rememberSaveable { mutableStateOf(defaultCountdownFormat * 60) }

    val uiState = UIState(viewTypeState, countdownFormat, isCountdownStarted, currentCountDownState)

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
            if (uiState.currentViewType == "Start") {
                StartScreen(uiState)
            } else {
                CountdownScreen(uiState)
            }
        }
    }
}

@Preview(device = Devices.WEAR_OS_SMALL_ROUND, showSystemUi = true)
@Composable
fun DefaultPreview() {
    App()
}