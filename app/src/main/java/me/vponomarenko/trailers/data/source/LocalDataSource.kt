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
                    "http://178.162.205.104/download/?title=WONDER+WOMAN+–+Rise+of+the+Warrior+%5BOfficial+Final+Trailer%5D&url=https%3A%2F%2Fcs632103.vkuservideo.net%2F8%2Fu2318349%2Fvideos%2Fc50ff03b4a.720.mp4%3Fextra%3Dh4THkG1XJcPZT0H-wSDd-Ul2PTGP_W-ZzqxVl_RBK-IktkDCMTFtzJIRy_Y235ASamiyEe1iRx5einjKw2RZ9PRcbpp4x69EmfHpTqupnXF_3RbvJAErLVmw7p7NFC--RA"
            ),
            TrailerFullInfo(
                    "Coco",
                    "https://images-na.ssl-images-amazon.com/images/M/MV5BYjQ5NjM0Y2YtNjZkNC00ZDhkLWJjMWItN2QyNzFkMDE3ZjAxXkEyXkFqcGdeQXVyODIxMzk5NjA@._V1_SY1000_CR0,0,699,1000_AL_.jpg",
                    "Aspiring musician Miguel, confronted with his family's ancestral ban on music, enters the Land of the Dead to find his great-great-grandfather, a legendary singer.",
                    "http://178.162.205.104/download/?title=Коко%2FCoco%2C+2017+Official+US+Teaser+Trailer%3B+vk.com%2Fcinemaiview&url=https%3A%2F%2Fcs632205.vkuservideo.net%2F7%2Fu13818768%2Fvideos%2Fa6bda4b562.720.mp4%3Fextra%3D0jv6LmNqznPO_y0q2EXr3dqaPM9CACR4TXZAmi4stOF6F0J4Ew-nVTrqvfhiX3_-0k1OSlsqtTQhJ6BV2-qR9AyhTz5FjiZ15Q6o219D1TObMrnRuNnL-9oHXstcatyB0A"
            ),
            TrailerFullInfo(
                    "Logan",
                    "https://images-na.ssl-images-amazon.com/images/M/MV5BMjQwODQwNTg4OV5BMl5BanBnXkFtZTgwMTk4MTAzMjI@._V1_.jpg",
                    "In the near future, a weary Logan cares for an ailing Professor X, somewhere on the Mexican border. However, Logan's attempts to hide from the world, and his legacy, are upended when a young mutant arrives, pursued by dark forces.",
                    "http://178.162.205.104/download/?title=«Логан»+%28Официальный+%7C+АНГ+%7C+Трейлер%29+_+Logan+-+Official+Trailer+%5B2017%5D&url=https%3A%2F%2Fcs510605.vkuservideo.net%2F0%2Fu105448317%2Fvideos%2F0a09ccf180.720.mp4%3Fextra%3DJ_q-DfDbwt_WKINxRaqqxXRRjVcZUZgf_iXDr7AxJf_XsCSbFk4EFpW3-aTNnC4u66rdnILnmnlkUxlggrA6F-J3GYzjcD9_8SpLuYnwQQb-miF6W9DL6jzvacPk0psfow"
            ),
            TrailerFullInfo(
                    "La La Land",
                    "https://images-na.ssl-images-amazon.com/images/M/MV5BMzUzNDM2NzM2MV5BMl5BanBnXkFtZTgwNTM3NTg4OTE@._V1_SY1000_SX675_AL_.jpg",
                    "While navigating their careers in Los Angeles, a pianist and an actress fall in love while attempting to reconcile their aspirations for the future.",
                    "http://178.162.205.104/download/?title=La+La+Land+Trailer&url=https%3A%2F%2Fcs510502.vkuservideo.net%2F6%2Fu816950%2Fvideos%2F155a71ba93.720.mp4%3Fextra%3DqSLer5uHM1mMWqUA1Ucoexlt5oD0mCE3amkLagizlRF_6VvWEY_fQ6Nyi1fjq2qJstiUYblEmvw4_hCbmuJeo3-czdBEvhRDHGKu2uqLH2vwGtsyiXS3ch-npltmx0Tn"
            )
            ,
            TrailerFullInfo(
                    "The Greatest Showman",
                    "https://shyfyy.files.wordpress.com/2017/12/greatestshowman-8.jpg",
                    "Celebrates the birth of show business, and tells of a visionary who rose from nothing to create a spectacle that became a worldwide sensation.",
                    "http://178.162.205.104/download/?title=The+Greatest+Showman+↑+Official+Trailer&url=https%3A%2F%2Fcs640201.vkuservideo.net%2F5%2Fu12869897%2Fvideos%2F8c8bf08517.720.mp4%3Fextra%3Dj3IhLOsdB_w99gZO8740v2JfjuzuH0fBKjABjyT_t-glF8uiZBNP_nHRodcqqtKF5smjRbxJ16-c3HZNTIZtLH61-NE0cjfVKuMUhN6fB0TG-wb6ZL9LeItQuwNQM5i_sA"
            )
    )

}