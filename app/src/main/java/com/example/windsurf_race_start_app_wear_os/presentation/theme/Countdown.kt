package com.example.windsurf_race_start_app_wear_os.presentation.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.*
import kotlinx.coroutines.delay
import kotlin.math.floor

@Composable
fun CountdownScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
//        CountdownButtons()
        Timer()
    }
}

@Composable
fun CountdownButtons() {
    
}

@Composable
fun Timer(
) {
    val countdownType = 240
    var currentTime by remember {
        mutableStateOf(countdownType)
    }
    val isTimerRunning by remember {
        mutableStateOf(true)
    }
    LaunchedEffect(key1 = currentTime, key2 = isTimerRunning) {
        if(currentTime != 0 && isTimerRunning) {
            if (currentTime != countdownType ) delay(1000L)

            currentTime -= 1
        }
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
    ) {
        val minutes = currentTime / 60
        val seconds = currentTime - minutes * 60;

        Text("$minutes:$seconds", modifier = Modifier, Color.White, 75.sp, fontWeight = FontWeight.Bold)
    }
}
