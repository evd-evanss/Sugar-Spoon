package com.sugarspoon.extensions

import android.app.Activity
import android.content.Intent

inline fun <reified T> Activity.navigateTo() {
    startActivity(Intent(this, T::class.java))
}