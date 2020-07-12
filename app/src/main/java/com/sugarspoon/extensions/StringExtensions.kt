package com.sugarspoon.extensions

import android.util.Log
import java.util.*

fun String.clear(): String {
    return ""
}

fun String.isDateValid() : Boolean {
    val cal = Calendar.getInstance()
    val currentYear = cal.get(Calendar.YEAR)
    if(this.length < 8) return false
    val day = this.take(2)
    val month = this.substring(2).take(2)
    val year = this.substring(4).take(4)
    return when{
        day.itsBetween(1, 31) && month.itsBetween(1, 12) && year.itsBetween(1900, currentYear) -> true
        else -> false
    }
}

fun String.itsBetween(startIndex: Int, endIndex: Int): Boolean {
    return when(this.toInt()) {
        in startIndex .. endIndex -> true
        else -> false
    }
}

fun String.isEmailValid(): Boolean {
    return when {
        android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches() -> true
        this.isEmpty() -> false
        else -> false
    }
}