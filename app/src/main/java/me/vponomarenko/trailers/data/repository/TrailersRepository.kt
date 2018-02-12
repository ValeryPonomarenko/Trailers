package me.vponomarenko.trailers.data.repository

import io.reactivex.Single
import me.vponomarenko.trailers.data.model.Trailer
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Author: Valery Ponomarenko
 * Date: 12/02/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

@Singleton
class TrailersRepository @Inject constructor(): ITrailersRepository {

    override fun loadTrailers() =
            Single.just(listOf(Trailer("First"), Trailer("Second")))
                    .delay(2, TimeUnit.SECONDS)

}