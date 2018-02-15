package me.vponomarenko.trailers.extension

import android.graphics.Bitmap
import android.widget.ImageView
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.request.target.BitmapImageViewTarget
import com.bumptech.glide.request.transition.Transition

/**
 * Author: Valery Ponomarenko
 * Date: 16/02/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

fun RequestBuilder<Bitmap>.into(imageView: ImageView, onResourceReady: (Bitmap) -> Unit) {
    into(object : BitmapImageViewTarget(imageView) {
        override fun onResourceReady(bitmap: Bitmap, transition: Transition<in Bitmap>?) {
            super.onResourceReady(bitmap, transition)
            onResourceReady(bitmap)
        }
    })
}
