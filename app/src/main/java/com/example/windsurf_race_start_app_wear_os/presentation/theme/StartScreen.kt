package com.example.windsurf_race_start_app_wear_os.presentation.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.*

@Composable
fun StartScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TimePicker()
        StartButton()
    }
}

@Composable
fun TimePicker() {
    var startFormat = 4

    Box{
        Text( startFormat.toString())
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = {
                    startFormat = 4
                },
                modifier = Modifier.background(Color.Transparent, MaterialTheme.shapes.small)
            ) {
                Text("4 min.")
            }
            Button(
                onClick = {
                    startFormat = 5
                },
            ) {
                Text("5 min.")
            }
        }
    }
}

@Composable
fun StartButton() {
    Button(
        onClick = { /* ... */ },
    ) {
        Text("Start")
    }
}

@Preview(device = Devices.WEAR_OS_SMALL_ROUND, showSystemUi = true)
@Composable
fun DefaultPreview() {
    StartScreen()
}