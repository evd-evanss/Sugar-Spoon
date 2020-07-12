package com.sugarspoon.extensions

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import com.sugarspoon.extensions.MaskedType.Companion.CEL_PHONE
import com.sugarspoon.extensions.MaskedType.Companion.CEP
import com.sugarspoon.extensions.MaskedType.Companion.CNPJ
import com.sugarspoon.extensions.MaskedType.Companion.CPF
import com.sugarspoon.extensions.MaskedType.Companion.CPF_OR_CNPJ
import com.sugarspoon.extensions.MaskedType.Companion.DATE
import com.sugarspoon.extensions.MaskedType.Companion.HOUR
import com.sugarspoon.extensions.MaskedType.Companion.PHONE
import com.sugarspoon.extensions.MaskedType.Companion.RG

/**
 * Created by Evandro Costa 12/07/2020
 */

object MaskedText {

    fun applyMasked(mask: String, edt: EditText): TextWatcher {
        return object : TextWatcher {
            var isUpdating = false
            var old = ""

            override fun onTextChanged(
                s: CharSequence, start: Int, before: Int,
                count: Int
            ) { }

            override fun beforeTextChanged(
                s: CharSequence, start: Int, count: Int,
                after: Int
            ) { }

            override fun afterTextChanged(s: Editable) {
                val maskAux = filterMask(mask, unMask(s.toString()).length)
                val digits = unMask(s.toString())
                var masked = ""

                if (isUpdating) {
                    old = digits
                    isUpdating = false
                    return
                }
                var selector = 0

                if (digits.length != old.length) {
                    for (m in maskAux.toCharArray()) {
                        if (m != '#') {
                            masked += m
                        } else {
                            masked += try {
                                digits[selector]
                            } catch (e: Exception) {
                                break
                            }
                            selector++
                        }
                    }
                } else {
                    masked = s.toString()
                }

                isUpdating = true
                edt.setText(masked)
                edt.setSelection(masked.length)
            }
        }
    }

    private fun unMask(s: String): String {
        return s.replace("[.]".toRegex(), "").replace("[-]".toRegex(), "")
            .replace("[/]".toRegex(), "").replace("[(]".toRegex(), "")
            .replace("[)]".toRegex(), "").replace(" ".toRegex(), "")
            .replace("[:]".toRegex(), "")
    }

    private fun filterMask(mask: String, size: Int): String {
        return when (mask) {
            RG -> RG
            CPF -> CPF
            CNPJ -> CNPJ
            CPF_OR_CNPJ -> filterDocument(size)
            CEP -> CEP
            DATE -> DATE
            HOUR -> HOUR
            PHONE -> filterPhone(size)
            else -> ""
        }
    }

    private fun filterPhone(size: Int): String {
        return when(size) {
            in 0..10 -> PHONE
            else -> CEL_PHONE
        }
    }

    private fun filterDocument(size: Int): String {
        return when (size) {
            in 0..11 -> CPF
            else -> CNPJ
        }
    }

}

