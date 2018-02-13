package me.vponomarenko.trailers.data.repository

import io.reactivex.Single
import me.vponomarenko.trailers.data.model.Trailer
import me.vponomarenko.trailers.data.model.TrailerFullInfo

/**
 * Author: Valery Ponomarenko
 * Date: 12/02/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

interface ITrailersRepository {

    fun loadTrailers(): Single<List<Trailer>>

    fun trailerFullInfo(trailerTitle: String): Single<TrailerFullInfo>

}