package com.sugarspoon.extensions

fun Float.formatHousesAfterPoint( places: String) : String {
    return "%.$places".format(this) + "%"
}