package me.vponomarenko.trailers.interactor.playerevents

import com.google.android.exoplayer2.source.MediaSource

/**
 * Author: Valery Ponomarenko
 * Date: 17/02/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

sealed class PlayerEvent {

    class Loading() : PlayerEvent()

    data class Paused(val seekPosition: Long) : PlayerEvent()

    data class PlayingInPreview(
            val mediaSource: MediaSource,
            val seekPosition: Long
    ) : PlayerEvent()

    data class Resume(val seekPosition: Long) : PlayerEvent()

    class Clear() : PlayerEvent()

}