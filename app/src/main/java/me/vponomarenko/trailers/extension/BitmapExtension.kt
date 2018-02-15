package me.vponomarenko.trailers.extension

import android.graphics.Bitmap
import android.graphics.Canvas

/**
 * Author: Valery Ponomarenko
 * Date: 16/02/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

inline fun Bitmap.applyCanvas(block: Canvas.() -> Unit): Bitmap {
    val c = Canvas(this)
    c.block()
    return this
}