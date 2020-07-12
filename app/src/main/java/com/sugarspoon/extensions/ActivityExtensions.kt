package com.sugarspoon.extensions

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.Toast

/**
 * Created by Evandro Costa 12/07/2020
 */

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