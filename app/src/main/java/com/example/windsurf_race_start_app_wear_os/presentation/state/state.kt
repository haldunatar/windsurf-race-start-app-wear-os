package com.example.windsurf_race_start_app_wear_os.presentation.state

import androidx.compose.runtime.*
import com.example.windsurf_race_start_app_wear_os.presentation.utils.constants.defaultCountdownFormat
import com.example.windsurf_race_start_app_wear_os.presentation.utils.constants.defaultIsCountdownStarted
import com.example.windsurf_race_start_app_wear_os.presentation.utils.constants.defaultIsCountdownStopped
import com.example.windsurf_race_start_app_wear_os.presentation.utils.constants.defaultViewTypeState

class UIState constructor(
    viewType: MutableState<String>,
    countdownFormat: MutableState<Int>,
    isCountdownStarted: MutableState<Boolean>,
    isCountdownStopped: MutableState<Boolean>,
    countdown: MutableState<Int>
) {
    private var _viewTypeState = viewType
    private var _countdownFormatState = countdownFormat
    private var _isCountdownStarted = isCountdownStarted
    private var _isCountdownStopped = isCountdownStopped
    private var _countdown = countdown

    public var currentViewType = _viewTypeState.value
    public var currentCountdownFormat = _countdownFormatState.value
    public var isCountdownStarted = _isCountdownStarted.value
    public var isCountdownStopped = _isCountdownStopped.value
    public var countdown = _countdown.value

    fun updateStartFormatState(newValue: Int) {
        _countdownFormatState.value = newValue
    }

    fun updateViewTypeState(newValue: String) {
        _viewTypeState.value = newValue
    }

    fun updateIsCountdownStartedState(newValue: Boolean) {
        _isCountdownStarted.value = newValue
    }

    fun updateIsCountdownStoppedState(newValue: Boolean) {
        _isCountdownStopped.value = newValue
    }

    fun updateCountdown(newValue: Int) {
        _countdown.value = newValue
    }

    fun countdown() {
        _countdown.value -= 1
    }

    fun resetState() {
        _viewTypeState.value = defaultViewTypeState
        _countdownFormatState.value = defaultCountdownFormat
        _isCountdownStarted.value = defaultIsCountdownStarted
        _isCountdownStopped.value = defaultIsCountdownStopped
        _countdown.value = defaultCountdownFormat * 60
    }
}
