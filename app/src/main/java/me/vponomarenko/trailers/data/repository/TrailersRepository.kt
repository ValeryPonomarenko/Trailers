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
            Single
                    .just(listOf(
                            Trailer("Wonder Woman", "https://i.ebayimg.com/images/g/4n8AAOSwjKFZQVFt/s-l1600.jpg"),
                            Trailer("Lego: The Movie", "http://www.joblo.com/posters/images/full/Lego-Batman-Movie-character-poster-2.jpg"),
                            Trailer("Coco", "https://images-na.ssl-images-amazon.com/images/M/MV5BYjQ5NjM0Y2YtNjZkNC00ZDhkLWJjMWItN2QyNzFkMDE3ZjAxXkEyXkFqcGdeQXVyODIxMzk5NjA@._V1_SY1000_CR0,0,699,1000_AL_.jpg"),
                            Trailer("Logan", "https://images-na.ssl-images-amazon.com/images/M/MV5BMjQwODQwNTg4OV5BMl5BanBnXkFtZTgwMTk4MTAzMjI@._V1_.jpg"),
                            Trailer("La La Land", "https://images-na.ssl-images-amazon.com/images/M/MV5BMzUzNDM2NzM2MV5BMl5BanBnXkFtZTgwNTM3NTg4OTE@._V1_SY1000_SX675_AL_.jpg"),
                            Trailer("Room", "https://images-na.ssl-images-amazon.com/images/M/MV5BMjE4NzgzNzEwMl5BMl5BanBnXkFtZTgwMTMzMDE0NjE@._V1_SY1000_SX675_AL_.jpg")
                    ))
                    .delay(2, TimeUnit.SECONDS)

}