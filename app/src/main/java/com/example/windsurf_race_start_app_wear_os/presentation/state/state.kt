package com.example.windsurf_race_start_app_wear_os.presentation.state

import androidx.compose.runtime.*

@Stable
class UIState constructor(
    viewType: MutableState<String>,
    countdownFormat: MutableState<Int>,
    isCountdownStarted: MutableState<Boolean>,
    countdown: MutableState<Int>
) {
    private var _viewTypeState = viewType
    private var _countdownFormatState = countdownFormat
    private var _isCountdownStarted = isCountdownStarted
    private var _countdown = countdown

    public var currentViewType = _viewTypeState.value
    public var currentCountdownFormat = _countdownFormatState.value
    public var isCountdownStarted = _isCountdownStarted.value
    public var countdown = _countdown.value

    fun updateStartFormatState(newValue: Int) {
        _countdownFormatState.value = newValue
    }

    fun updateViewTypeState(newValue: String) {
        _viewTypeState.value = newValue
    }

    fun updateIsTimerStartedState(newValue: Boolean) {
        _isCountdownStarted.value = newValue
    }

    fun updateCountdown(newValue: Int) {
        _countdown.value = newValue
    }

    fun countdown() {
        _countdown.value -= 1
    }
}
