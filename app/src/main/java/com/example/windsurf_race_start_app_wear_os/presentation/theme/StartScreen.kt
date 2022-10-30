package com.example.windsurf_race_start_app_wear_os.presentation.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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

@SuppressLint()
@Composable
fun TimePicker() {
    val startFormat = remember {
        mutableStateOf(4)
    }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        TimePickerButton(
            4,
            startFormat.value,
            "4 min.",
        ) {
            startFormat.value = it
        }
        TimePickerButton(
            5,
            startFormat.value,
            "5 min.",
        ) {
            startFormat.value = it
        }
    }
}

@Composable
fun TimePickerButton(
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
    ) {
        Text(label)
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