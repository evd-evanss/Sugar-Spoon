package com.sugarspoon.extensions

fun String.addMask(inputMask: String, substitute: Char? = '#'): String {
    var mask = inputMask
    val unmaskedString = this.unmask()
    var index = 0
    var result = ""
    if (mask == TextMask.CPF_OR_CNPJ_MASK) {
        mask = if (unmaskedString.length > 11) TextMask.CNPJ_MASK else TextMask.CPF_MASK
    }
    if (mask == TextMask.CNPJ_MASK) {
        unmaskedString.addZerosUntilLength(14)
    } else if (mask == TextMask.CPF_MASK) {
        unmaskedString.addZerosUntilLength(11)
    }
    mask.forEach { item ->
        if (index < unmaskedString.length) {
            if (item == substitute) {
                result += unmaskedString[index]
                index++
            } else {
                result += item
            }
        }
    }
    return result
}

fun String.unmask() = TextMask.unmask(this)

fun String.addZerosUntilLength(quantity: Int): String {
    var result = this
    if(this.length < quantity) {
        for(i in 1..(quantity-this.length)) {
            result = "0$result"
        }
    }
    return result
}