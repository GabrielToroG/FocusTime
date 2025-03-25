package com.example.focustime.home.domain.entity

import com.example.focustime.core.presentation.utils.Constants.Companion.FOCUS_TIME
import com.example.focustime.core.presentation.utils.Constants.Companion.LONG_BREAK_TIME
import com.example.focustime.core.presentation.utils.Constants.Companion.ONE_MIN_IN_SEC
import com.example.focustime.core.presentation.utils.Constants.Companion.ONE_SEC_IN_MILLIS
import com.example.focustime.core.presentation.utils.Constants.Companion.SHORT_BREAK_TIME

enum class TimerTypeEnum(val title: String, private val time: Long) {
    FOCUS("Focus Time", FOCUS_TIME),
    SHORT_BREAK("Short Break", SHORT_BREAK_TIME),
    LONG_BREAK("Long Break", LONG_BREAK_TIME);

    fun timeToMillis(): Long {
        return time * ONE_MIN_IN_SEC * ONE_SEC_IN_MILLIS
    }
}