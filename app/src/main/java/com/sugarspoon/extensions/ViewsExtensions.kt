package com.sugarspoon.extensions

import android.widget.EditText

fun EditText.text(text: String) {
    this.setText(text)
}

fun EditText.hintEmail() {
    this.hint = "email@gmail.com"
}

fun EditText.hintPassword() {
    this.hint = "******"
}


