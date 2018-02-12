package me.vponomarenko.trailers.ui.viewholder

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_trailer.view.*
import me.vponomarenko.trailers.R
import me.vponomarenko.trailers.data.model.Trailer

/**
 * Author: Valery Ponomarenko
 * Date: 12/02/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */
 
class TrailerViewHolder(
        inflater: LayoutInflater,
        container: ViewGroup
) : RecyclerView.ViewHolder(inflater.inflate(R.layout.item_trailer, container, false)) {

    fun bind(trailer: Trailer) {
        Glide.with(itemView.context).load(trailer.imageUrl).into(itemView.image_trailer_logo)
        itemView.text_trailer_title.text = trailer.title
    }

}