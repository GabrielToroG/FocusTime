package com.example.focustime.home.presentation.home.viewmodel

import android.annotation.SuppressLint
import android.os.CountDownTimer
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.focustime.core.presentation.utils.Constants.Companion.ONE_HOUR_IN_MIN
import com.example.focustime.core.presentation.utils.Constants.Companion.ONE_MIN_IN_MILLIS
import com.example.focustime.core.presentation.utils.Constants.Companion.ONE_MIN_IN_SEC
import com.example.focustime.core.presentation.utils.Constants.Companion.ONE_SEC_IN_MILLIS
import com.example.focustime.home.domain.entity.TimerTypeEnum
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {
    private lateinit var timer: CountDownTimer
    private var isTimerActive: Boolean = false

    // mutable state of -> @Published
    private val _timerValue = mutableStateOf(TimerTypeEnum.FOCUS.timeToMillis())
    val timerValueState = _timerValue

    private val _timerTypeState = mutableStateOf(TimerTypeEnum.FOCUS)
    val timerTypeState = _timerTypeState

    private val _roundState = mutableStateOf(0)
    val roundState = _roundState

    private val _todayTimeState = mutableStateOf<Long>(0)
    val todayTimeState = _todayTimeState


    fun onStartTimer() {
        viewModelScope.launch { // Co - rutina
            timer = object : CountDownTimer(
                _timerValue.value,
                ONE_SEC_IN_MILLIS
            ) {
                override fun onTick(millisUntilFinished: Long) {
                    _timerValue.value = millisUntilFinished
                    _todayTimeState.value += ONE_SEC_IN_MILLIS
                }

                override fun onFinish() {
                    onCancelTimer()
                }
            }
            timer.start().also {
                if (!isTimerActive) _roundState.value += 1
                isTimerActive = true
            }
        }
    }
    fun onCancelTimer(reset: Boolean = false) {
        try {
            timer.cancel()
        } catch (_: UninitializedPropertyAccessException) {
//            Handle better the timer error
        }
        if (!isTimerActive || reset) {
            _timerValue.value = _timerTypeState.value.timeToMillis()
        }
        isTimerActive = false
    }

    private fun onResetTime() {
        if (isTimerActive) {
            onCancelTimer()
            onStartTimer()
        }
    }

    fun onUpdateType(timerType: TimerTypeEnum) {
        _timerTypeState.value = timerType
        onCancelTimer(true)
    }

    fun onIncreaseTime() {
        _timerValue.value += ONE_MIN_IN_MILLIS
        onResetTime()
    }

    fun onDecreaseTime() {
        _timerValue.value -= ONE_MIN_IN_MILLIS
        onResetTime()
        if (_timerValue.value < 0) {
            onCancelTimer()
        }
    }

    // SuppressLint
    @SuppressLint("DefaultLocale")
    fun millisToMinutes(value: Long): String {
        val totalSeconds = value / ONE_SEC_IN_MILLIS
        val minutes = (totalSeconds / ONE_MIN_IN_SEC).toInt()
        val seconds = (totalSeconds % ONE_MIN_IN_SEC).toInt()
        // Necesito 2 digitos dos puntos y 2 digitos mas
        return String.format("%02d:%02d", minutes, seconds)
    }

    @SuppressLint("DefaultLocale")
    fun millisToHours(value: Long): String {
        val totalSeconds = value / ONE_SEC_IN_MILLIS
        val seconds = (totalSeconds % ONE_MIN_IN_SEC)
        val totalMinutes = (totalSeconds / ONE_MIN_IN_SEC).toInt()
        val hours = (totalMinutes / ONE_HOUR_IN_MIN)
        val minutes = (totalMinutes % ONE_HOUR_IN_MIN)
        return if (totalMinutes <= ONE_HOUR_IN_MIN) {
            String.format("%02dm %02ds", minutes, seconds)
        } else {
            String.format("%02dh %02dm", hours, minutes)
        }
    }
}