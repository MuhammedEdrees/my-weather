package com.edrees.myweather.ui.utils

import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.format
import kotlinx.datetime.format.DayOfWeekNames

fun LocalDateTime.formatHourMinute(): String {
    val format = LocalDateTime.Format {
        hour()
        chars(":")
        minute()
    }
    return this.format(format)
}

fun LocalDate.formatDayName(dayOfWeekNames: DayOfWeekNames = DayOfWeekNames.ENGLISH_FULL): String {
    val customFormat =
        LocalDate.Format {
            dayOfWeek(dayOfWeekNames)
        }
    return this.format(customFormat)
}