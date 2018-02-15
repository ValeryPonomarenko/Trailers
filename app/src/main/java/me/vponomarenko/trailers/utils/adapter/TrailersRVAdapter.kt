package me.vponomarenko.trailers.utils.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import me.vponomarenko.trailers.data.model.Trailer
import me.vponomarenko.trailers.ui.viewholder.TrailerViewHolder
import me.vponomarenko.trailers.utils.palette.PaletteHelper
import javax.inject.Inject

/**
 * Author: Valery Ponomarenko
 * Date: 12/02/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

class TrailersRVAdapter @Inject constructor(
        private val paletteHelper: PaletteHelper
): RecyclerView.Adapter<TrailerViewHolder>() {

    var trailers: List<Trailer>? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var onClickListener: ((String) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            TrailerViewHolder(LayoutInflater.from(parent.context), parent, paletteHelper) {
                onClickListener?.invoke(it)
            }

    override fun getItemCount() = trailers?.count() ?: 0

    override fun onBindViewHolder(holder: TrailerViewHolder, position: Int) {
        trailers?.get(position)?.let {
            holder.bind(it)
        }
    }

}