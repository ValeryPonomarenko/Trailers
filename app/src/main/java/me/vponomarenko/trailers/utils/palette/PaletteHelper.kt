package me.vponomarenko.trailers.utils.palette

import android.graphics.Bitmap
import android.graphics.Color
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Author: Valery Ponomarenko
 * Date: 15/02/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

class PaletteHelper {

    fun getAvgColorOfBitmap(bitmap: Bitmap, pixelStep: Int = 4): Single<Int> =
            Single
                    .fromCallable {
                        var red = 0
                        var green = 0
                        var blue = 0
                        var pixelsCount = 0

                        for (h in 0 until bitmap.height step pixelStep) {
                            for (w in 0 until bitmap.width step pixelStep) {
                                val color = bitmap.getPixel(w, h)
                                pixelsCount++
                                red += Color.red(color)
                                green += Color.green(color)
                                blue += Color.blue(color)
                            }
                        }

                        return@fromCallable Color.rgb(
                                red / pixelsCount,
                                green / pixelsCount,
                                blue / pixelsCount
                        )
                    }
                    .subscribeOn(Schedulers.computation())
                    .observeOn(AndroidSchedulers.mainThread())

}