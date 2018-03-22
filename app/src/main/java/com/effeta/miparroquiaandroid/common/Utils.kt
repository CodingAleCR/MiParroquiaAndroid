package com.effeta.miparroquiaandroid.common

import android.view.View
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import java.text.SimpleDateFormat
import java.util.*


/**
 * Created by aulate on 6/2/18.
 */

fun Date.toString(pattern: String): String {
    val simpleDateFormat = SimpleDateFormat(pattern)
    return simpleDateFormat.format(this)
}

fun Calendar.toString(pattern: String): String {
    val simpleDateFormat = SimpleDateFormat(pattern)
    return simpleDateFormat.format(time)
}

fun DateTime.toString(pattern: String): String {
    val dtf = DateTimeFormat.forPattern(pattern)
    return dtf.print(this)
}

fun View.changeBackground(resId: Int) {
    val pL = paddingLeft
    val pT = paddingTop
    val pR = paddingRight
    val pB = paddingBottom

    setBackgroundResource(resId)
    setPadding(pL, pT, pR, pB)
}

fun Any.logName(): String {
    val str = this.javaClass.simpleName
    if (str.length > 35 - "sl_".length) {
        return "sl_" + str.substring(0, 35 - "sl_".length - 1)
    }

    return "sl_" + str
}