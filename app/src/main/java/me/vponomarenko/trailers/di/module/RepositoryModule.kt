package me.vponomarenko.trailers.di.module

import dagger.Binds
import dagger.Module
import me.vponomarenko.trailers.data.repository.ITrailersRepository
import me.vponomarenko.trailers.data.repository.TrailersRepository
import javax.inject.Singleton

/**
 * Author: Valery Ponomarenko
 * Date: 12/02/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

@Module
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun provideTrailersRepository(repository: TrailersRepository): ITrailersRepository

}

