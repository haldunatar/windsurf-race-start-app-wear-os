package com.example.windsurf_race_start_app_wear_os.presentation.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.wear.compose.material.*

@Composable
fun StartScreen(
    updateViewTypeState: (String) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CountdownFormat()
        StartButton(updateViewTypeState)
    }
}

@SuppressLint()
@Composable
fun CountdownFormat() {
    var format by remember {
        mutableStateOf(4)
    }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        CountdownFormatButton(3, format, "3 min.") { format = it }
        CountdownFormatButton(4, format, "4 min.") { format = it }
    }
}

@Composable
fun CountdownFormatButton(
    defaultFormatValue: Int,
    startFormatStateValue: Int,
    label: String,
    updateFormatState: (Int) -> Unit
) {
    Button(
        onClick = {
            updateFormatState(defaultFormatValue)
        },
        modifier = Modifier,
        enabled = true,
        colors = if (startFormatStateValue == defaultFormatValue) {
            ButtonDefaults.primaryButtonColors()
        } else {
            ButtonDefaults.secondaryButtonColors()
        }
    ) { Text(label) }
}

@Composable
fun StartButton(
    updateViewTypeState: (String) -> Unit
) {
    Button(
        onClick = {
            updateViewTypeState("Countdown")
        },
    ) {
        Text("Start")
    }
}
