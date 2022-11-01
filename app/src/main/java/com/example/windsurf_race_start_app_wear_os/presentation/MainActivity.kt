/* While this template provides a good starting point for using Wear Compose, you can always
 * take a look at https://github.com/android/wear-os-samples/tree/main/ComposeStarter and
 * https://github.com/android/wear-os-samples/tree/main/ComposeAdvanced to find the most up to date
 * changes to the libraries and their usages.
 */

package com.example.windsurf_race_start_app_wear_os.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.MaterialTheme.colors
import androidx.wear.compose.material.Text
import com.example.windsurf_race_start_app_wear_os.presentation.theme.CountdownScreen
import com.example.windsurf_race_start_app_wear_os.presentation.theme.StartScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
            // some changes
        }
    }
}

@Composable
fun App() {
    var viewType by remember {
        mutableStateOf("Start")
    }
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
            if (viewType == "Start") {
                StartScreen() {
                    println("viewType, $viewType")
                    viewType = it
                }
            } else {
                println("viewType, $viewType")
                CountdownScreen()
            }
        }
    }
}

@Preview(device = Devices.WEAR_OS_SMALL_ROUND, showSystemUi = true)
@Composable
fun DefaultPreview() {
    App()
}