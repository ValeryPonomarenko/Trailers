package me.vponomarenko.trailers.ui.viewholder

import android.graphics.Bitmap
import android.support.v4.view.ViewCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.BitmapImageViewTarget
import com.bumptech.glide.request.transition.Transition
import kotlinx.android.synthetic.main.item_trailer.view.*
import me.vponomarenko.trailers.R
import me.vponomarenko.trailers.data.model.Trailer
import me.vponomarenko.trailers.data.transition.PlayerTransition
import me.vponomarenko.trailers.utils.palette.PaletteHelper

/**
 * Author: Valery Ponomarenko
 * Date: 12/02/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */
 
class TrailerViewHolder(
        inflater: LayoutInflater,
        container: ViewGroup,
        private val paletteHelper: PaletteHelper,
        private val onClickListener: (PlayerTransition) -> Unit
) : RecyclerView.ViewHolder(inflater.inflate(R.layout.item_trailer, container, false)) {

    fun bind(trailer: Trailer) {
        Glide.with(itemView.context)
                .asBitmap()
                .load(trailer.imageUrl)
                .into(object : BitmapImageViewTarget(itemView.image_trailer_logo) {
                    override fun onResourceReady(bitmap: Bitmap, transition: Transition<in Bitmap>?) {
                        super.onResourceReady(bitmap, transition)
                        paletteHelper
                                .getAvgColorOfBitmap(bitmap)
                                .subscribe { color: Int ->
                                    itemView.trailer_card.setBackgroundColor(color)
                                }
                    }
                })
        ViewCompat.setTransitionName(itemView.image_trailer_logo, trailer.title)
        itemView.text_trailer_title.text = trailer.title
        itemView.setOnClickListener {
            onClickListener(PlayerTransition(trailer.title, itemView.image_trailer_logo))
        }
    }

}