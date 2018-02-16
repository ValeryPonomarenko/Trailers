package me.vponomarenko.trailers.data.viewdata

import com.google.android.exoplayer2.source.MediaSource
import me.vponomarenko.trailers.data.model.Trailer
import me.vponomarenko.trailers.data.model.TrailerFullInfo

/**
 * Author: Valery Ponomarenko
 * Date: 13/02/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */
 
sealed class PlayerViewData {

    class Loading : PlayerViewData()

    data class Info(
            val trailerFullInfo: TrailerFullInfo,
            val mediaSource: MediaSource,
            val seeAlso: List<Trailer>
    ) : PlayerViewData()

    data class Error(val message: String) : PlayerViewData()

}