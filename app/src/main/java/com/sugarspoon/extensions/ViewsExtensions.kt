package com.sugarspoon.extensions

import android.view.View
import android.view.View.*
import android.widget.EditText

/**
 * Created by Evandro Costa 12/07/2020
 */

//EditText
fun EditText.text(text: String) {
    this.setText(text)
}

fun EditText.hintEmail() {
    this.hint = "email@gmail.com"
}

fun EditText.hintPassword() {
    this.hint = "******"
}

fun EditText.addTextMask(mask: String) {
    addTextChangedListener(MaskedText.insertMasked(mask, this))
}

//GenericViews
fun View.setVisibility(isVisible: Boolean?) {
    when(isVisible) {
        true -> this.visibility = VISIBLE
        false -> this.visibility = INVISIBLE
        else -> this.visibility = GONE
    }
}

