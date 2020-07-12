package com.sugarspoon.extensions

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

object TextMask {
    const val CEP_MASK = "#####-###"
    const val CPF_MASK = "###.###.###-##"
    const val PHONE_MASK = "(##) ####-#####"
    const val CPF_OR_CNPJ_MASK = "###.###.###-###"
    const val CEL_PHONE_MASK = "(##) #####-####"
    const val DATE_MASK = "##/##/####"
    const val CNPJ_MASK = "##.###.###/####-##"
    const val HOUR_MASK = "##:##"
    const val CREDIT_CARD_DATE_MASK = "##/##"

    fun unmask(s: String): String {
        return s.replace("[.]".toRegex(), "").replace("[-]".toRegex(), "")
            .replace("[/]".toRegex(), "").replace("[(]".toRegex(), "")
            .replace("[)]".toRegex(), "").replace(" ".toRegex(), "")
            .replace("[:]".toRegex(), "")
    }

    fun mask(mask: String, stringToMask: String): String {
        var i = 0
        val masked = StringBuilder()
        for (m in mask.toCharArray()) {
            if (m != '#') {
                masked.append(m)
            } else {
                try {
                    masked.append(stringToMask[i])
                } catch (e: Exception) {
                    break
                }
                i++
            }
        }
        return masked.toString()
    }

    fun insert(mask: String, edtTxt: EditText): TextWatcher {

        return object : TextWatcher {
            var isUpdating = false
            var old = ""
            var maskAux = mask

            override fun onTextChanged(
                s: CharSequence, start: Int, before: Int,
                count: Int
            ) { }

            override fun beforeTextChanged(
                s: CharSequence, start: Int, count: Int,
                after: Int
            ) { }

            override fun afterTextChanged(s: Editable) {
                if (mask == PHONE_MASK) {
                    maskAux = if (unmask(s.toString()).length > 10) {
                        CEL_PHONE_MASK
                    } else {
                        PHONE_MASK
                    }
                } else if (mask == CNPJ_MASK) {
                    maskAux = if (unmask(s.toString()).length > 11) {
                        CNPJ_MASK
                    } else {
                        CPF_MASK
                    }
                }

                val str = unmask(s.toString())
                var mask = ""
                if (isUpdating) {
                    old = str
                    isUpdating = false
                    return
                }
                var i = 0
                if (str.length != old.length) {
                    for (m in maskAux.toCharArray()) {
                        if (m != '#') {
                            mask += m
                        } else {
                            mask += try {
                                str[i]
                            } catch (e: Exception) {
                                break
                            }
                            i++
                        }
                    }
                } else {
                    mask = s.toString()
                }
                isUpdating = true
                edtTxt.setText(mask)
                edtTxt.setSelection(mask.length)
            }
        }
    }
}
