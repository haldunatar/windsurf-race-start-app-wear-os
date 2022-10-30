package com.example.windsurf_race_start_app_wear_os.presentation.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
        TimePicker()
        StartButton(updateViewTypeState)
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
//
//@Preview(device = Devices.WEAR_OS_SMALL_ROUND, showSystemUi = true)
//@Composable
//fun DefaultPreview() {
//    StartScreen()
//}