package me.vponomarenko.trailers.di.module

import dagger.Binds
import dagger.Module
import me.vponomarenko.trailers.interactor.playerevents.IPlayerEventsInteractor
import me.vponomarenko.trailers.interactor.playerevents.PlayerEventsInteractor
import javax.inject.Singleton

/**
 * Author: Valery Ponomarenko
 * Date: 17/02/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

@Module
abstract class InteractorModule {

    @Singleton
    @Binds
    abstract fun providePlayerEventsInteractor(
            interactor: PlayerEventsInteractor
    ): IPlayerEventsInteractor
    
}