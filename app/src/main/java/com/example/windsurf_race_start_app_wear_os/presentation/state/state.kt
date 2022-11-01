package com.example.windsurf_race_start_app_wear_os.presentation.state

import androidx.compose.runtime.*

class UIState(
    format: MutableState<Int>
) {
    private var startFormatState = format

    public final fun updateStartFormatState(newValue: Int): Unit {

        startFormatState.value = newValue;
    }

    public final fun getStartFormatState(): Int {
        return startFormatState.value;
    }
}

@Composable
fun UIStateContainer(): UIState {
    val format = remember { mutableStateOf(4) }
    return UIState(format)
}