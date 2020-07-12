package com.sugarspoon.extensions

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.Toast

inline fun <reified T> Activity.navigateTo() {
    startActivity(Intent(this, T::class.java))
}

inline fun <reified T> Activity.navigateToWithFinish() {
    startActivity(Intent(this, T::class.java))
    this.finish()
}

fun Context.ToastMessage(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_LONG).show()
}