package me.vponomarenko.trailers.extension

import android.graphics.Bitmap
import android.support.v4.view.ViewCompat
import android.view.View

/**
 * Author: Valery Ponomarenko
 * Date: 16/02/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

fun View.toBitmap(config: Bitmap.Config = Bitmap.Config.ARGB_8888): Bitmap {
    if (!ViewCompat.isLaidOut(this)) {
        throw IllegalStateException("View needs to be laid out before calling toBitmap()")
    }
    return Bitmap.createBitmap(width, height, config).applyCanvas(::draw)
}