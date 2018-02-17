package me.vponomarenko.trailers.interactor.playerevents

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

/**
 * Author: Valery Ponomarenko
 * Date: 17/02/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

class PlayerEventsInteractor @Inject constructor() : IPlayerEventsInteractor {

    private val playerEventsPublisher = PublishSubject.create<PlayerEvent>()

    override val playerEventsObserver: Observable<PlayerEvent>
        get() = playerEventsPublisher

    override fun publicPlayerEvent(event: PlayerEvent) {
        playerEventsPublisher.onNext(event)
    }

}