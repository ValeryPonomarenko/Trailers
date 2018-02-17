package me.vponomarenko.trailers.interactor.playerevents

import io.reactivex.Observable

/**
 * Author: Valery Ponomarenko
 * Date: 17/02/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

interface IPlayerEventsInteractor {

    val playerEventsObserver: Observable<PlayerEvent>

    fun publicPlayerEvent(event: PlayerEvent)

}