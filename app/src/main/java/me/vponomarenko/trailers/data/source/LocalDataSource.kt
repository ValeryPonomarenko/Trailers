package me.vponomarenko.trailers.data.source

import me.vponomarenko.trailers.data.model.TrailerFullInfo
import javax.inject.Inject

/**
 * Author: Valery Ponomarenko
 * Date: 13/02/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

class LocalDataSource @Inject constructor() {

    val trailers = listOf(
            TrailerFullInfo(
                    "Wonder Woman",
                    "https://i.ebayimg.com/images/g/4n8AAOSwjKFZQVFt/s-l1600.jpg",
                    "When a pilot crashes and tells of conflict in the outside world, Diana, an Amazonian warrior in training, leaves home to fight a war, discovering her full powers and true destiny.",
                    "url"
            ),
            TrailerFullInfo(
                    "Lego: The Movie",
                    "http://www.joblo.com/posters/images/full/Lego-Batman-Movie-character-poster-2.jpg",
                    "An ordinary LEGO construction worker, thought to be the prophesied as \"special\", is recruited to join a quest to stop an evil tyrant from gluing the LEGO universe into eternal stasis.",
                    "url"
            ),
            TrailerFullInfo(
                    "Coco",
                    "https://images-na.ssl-images-amazon.com/images/M/MV5BYjQ5NjM0Y2YtNjZkNC00ZDhkLWJjMWItN2QyNzFkMDE3ZjAxXkEyXkFqcGdeQXVyODIxMzk5NjA@._V1_SY1000_CR0,0,699,1000_AL_.jpg",
                    "Aspiring musician Miguel, confronted with his family's ancestral ban on music, enters the Land of the Dead to find his great-great-grandfather, a legendary singer.",
                    "url"
            ),
            TrailerFullInfo(
                    "Logan",
                    "https://images-na.ssl-images-amazon.com/images/M/MV5BMjQwODQwNTg4OV5BMl5BanBnXkFtZTgwMTk4MTAzMjI@._V1_.jpg",
                    "In the near future, a weary Logan cares for an ailing Professor X, somewhere on the Mexican border. However, Logan's attempts to hide from the world, and his legacy, are upended when a young mutant arrives, pursued by dark forces.",
                    "url"
            ),
            TrailerFullInfo(
                    "La La Land",
                    "https://images-na.ssl-images-amazon.com/images/M/MV5BMzUzNDM2NzM2MV5BMl5BanBnXkFtZTgwNTM3NTg4OTE@._V1_SY1000_SX675_AL_.jpg",
                    "While navigating their careers in Los Angeles, a pianist and an actress fall in love while attempting to reconcile their aspirations for the future.",
                    "url"
            ),
            TrailerFullInfo(
                    "Room",
                    "https://images-na.ssl-images-amazon.com/images/M/MV5BMjE4NzgzNzEwMl5BMl5BanBnXkFtZTgwMTMzMDE0NjE@._V1_SY1000_SX675_AL_.jpg",
                    "A young boy is raised within the confines of a small shed.",
                    "url"
            )
    )

}