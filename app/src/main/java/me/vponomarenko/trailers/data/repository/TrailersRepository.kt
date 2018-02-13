package me.vponomarenko.trailers.data.repository

import android.content.res.Resources
import io.reactivex.Single
import me.vponomarenko.trailers.data.model.Trailer
import me.vponomarenko.trailers.data.model.TrailerFullInfo
import me.vponomarenko.trailers.data.source.LocalDataSource
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Author: Valery Ponomarenko
 * Date: 12/02/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

@Singleton
class TrailersRepository @Inject constructor(
        private val localDataSource: LocalDataSource
): ITrailersRepository {

    override fun loadTrailers(): Single<List<Trailer>> =
            Single.just(localDataSource.trailers.map { Trailer(it.title, it.imageUrl) })
                    .delay(2, TimeUnit.SECONDS)

    override fun trailerFullInfo(trailerTitle: String): Single<TrailerFullInfo> =
            Single.just(
                    localDataSource.trailers.find { it.title == trailerTitle }
                            ?: throw Resources.NotFoundException()
            )

}