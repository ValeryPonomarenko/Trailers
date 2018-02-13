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
                    "https://redirector.googlevideo.com/videoplayback?fvip=6&sparams=dur%2Cei%2Cid%2Cinitcwndbps%2Cip%2Cipbits%2Citag%2Clmt%2Cmime%2Cmm%2Cmn%2Cms%2Cmv%2Cpl%2Cratebypass%2Crequiressl%2Csource%2Cexpire&ip=2001%3A19f0%3A5%3A1de%3A5400%3Aff%3Afe4f%3A2207&ratebypass=yes&ipbits=0&expire=1518579621&lmt=1494121815999007&signature=A518C2B896ED5ACF40EF0263A8259A3ADC647B42.A1740516386BFD3035E7C1900EB9CE29E738B9F8&initcwndbps=7430000&c=WEB&ei=RVuDWsj6L6eo8gSou5ugDQ&mime=video%2Fmp4&source=youtube&key=yt6&itag=22&mt=1518557943&mv=m&ms=au%2Crdu&mm=31%2C29&pl=51&mn=sn-ab5l6nzd%2Csn-ab5szn7y&id=o-ADZ26gINR44tVkiLgSCI2KJazzRmvXRqHjXLAZDfeeyE&dur=162.214&requiressl=yes"
            ),
            TrailerFullInfo(
                    "Lego: The Movie",
                    "http://www.joblo.com/posters/images/full/Lego-Batman-Movie-character-poster-2.jpg",
                    "An ordinary LEGO construction worker, thought to be the prophesied as \"special\", is recruited to join a quest to stop an evil tyrant from gluing the LEGO universe into eternal stasis.",
                    "https://redirector.googlevideo.com/videoplayback?signature=B0C4A6CF68E70FA1C7F4EC206C99E1AF03DD4832.6FDF55863D312A1BDFEA5A5CEA7FF5B531C83BF9&lmt=1471391198614360&c=WEB&ratebypass=yes&fvip=5&ei=5FyDWomNOYrmqAH-3qeoDg&requiressl=yes&ipbits=0&initcwndbps=2966250&ip=2400%3A8902%3A%3Af03c%3A91ff%3Afe2d%3Ab374&key=yt6&dur=180.233&itag=22&pl=64&source=youtube&mv=m&ms=au%2Conr&mm=31%2C26&mn=sn-n4v7knlz%2Csn-a5mekn7d&id=o-AM7VxLeieGz_7lsmoc3ZIY53nOlK5L8YwlywI-xZPGML&sparams=dur%2Cei%2Cid%2Cinitcwndbps%2Cip%2Cipbits%2Citag%2Clmt%2Cmime%2Cmm%2Cmn%2Cms%2Cmv%2Cpl%2Cratebypass%2Crequiressl%2Csource%2Cexpire&expire=1518580037&mt=1518558291&mime=video%2Fmp4"
            ),
            TrailerFullInfo(
                    "Coco",
                    "https://images-na.ssl-images-amazon.com/images/M/MV5BYjQ5NjM0Y2YtNjZkNC00ZDhkLWJjMWItN2QyNzFkMDE3ZjAxXkEyXkFqcGdeQXVyODIxMzk5NjA@._V1_SY1000_CR0,0,699,1000_AL_.jpg",
                    "Aspiring musician Miguel, confronted with his family's ancestral ban on music, enters the Land of the Dead to find his great-great-grandfather, a legendary singer.",
                    "https://redirector.googlevideo.com/videoplayback?id=o-AGMUSbSnMFXzsLU08nfxdnPLqDtSL8SvXbrr8wA8Zcdc&dur=130.240&pl=64&source=youtube&sparams=dur%2Cei%2Cid%2Cinitcwndbps%2Cip%2Cipbits%2Citag%2Clmt%2Cmime%2Cmm%2Cmn%2Cms%2Cmv%2Cpl%2Cratebypass%2Crequiressl%2Csource%2Cexpire&mv=m&initcwndbps=2453750&fvip=6&ms=au%2Conr&ip=2400%3A8902%3A%3Af03c%3A91ff%3Afe2d%3Ab374&key=yt6&mn=sn-n4v7sne7%2Csn-a5meknes&mime=video%2Fmp4&expire=1518580064&mm=31%2C26&ipbits=0&signature=7F4CB45C0666061E0D6E9E5D4AD9DCD18A24D431.B4B4D6C142E563214AC77C87D7563B9EA23737B7&mt=1518558291&requiressl=yes&lmt=1510003712415776&ratebypass=yes&itag=22&c=WEB&ei=_1yDWtnRNZLC4wLp86CoCg"
            ),
            TrailerFullInfo(
                    "Logan",
                    "https://images-na.ssl-images-amazon.com/images/M/MV5BMjQwODQwNTg4OV5BMl5BanBnXkFtZTgwMTk4MTAzMjI@._V1_.jpg",
                    "In the near future, a weary Logan cares for an ailing Professor X, somewhere on the Mexican border. However, Logan's attempts to hide from the world, and his legacy, are upended when a young mutant arrives, pursued by dark forces.",
                    "https://redirector.googlevideo.com/videoplayback?ms=au%2Crdu&mt=1518558408&mv=m&pl=51&requiressl=yes&signature=860BDD2511BAF2D2F2DF2A9F5A495E4134215D5E.A8AB412426CF72C4916E787F01267E65BB7636F5&lmt=1515309279974164&ratebypass=yes&initcwndbps=3942500&dur=107.531&mm=31%2C29&mn=sn-ab5l6n6l%2Csn-ab5sznl7&id=o-ALeek2hFjOMvYk9PO9baxJ70DZqD9vucpNfcwKN1L_tC&ei=HV2DWq24Is-H8wSo6q24Bw&sparams=dur%2Cei%2Cid%2Cinitcwndbps%2Cip%2Cipbits%2Citag%2Clmt%2Cmime%2Cmm%2Cmn%2Cms%2Cmv%2Cpl%2Cratebypass%2Crequiressl%2Csource%2Cexpire&expire=1518580093&itag=22&ipbits=0&ip=2001%3A19f0%3A5%3A1de%3A5400%3Aff%3Afe4f%3A2207&mime=video%2Fmp4&c=WEB&source=youtube&fvip=1&key=yt6"
            ),
            TrailerFullInfo(
                    "La La Land",
                    "https://images-na.ssl-images-amazon.com/images/M/MV5BMzUzNDM2NzM2MV5BMl5BanBnXkFtZTgwNTM3NTg4OTE@._V1_SY1000_SX675_AL_.jpg",
                    "While navigating their careers in Los Angeles, a pianist and an actress fall in love while attempting to reconcile their aspirations for the future.",
                    "https://www.youtube.com/watch?v=0pdqf4P9MB8"
            ),
            TrailerFullInfo(
                    "Room",
                    "https://images-na.ssl-images-amazon.com/images/M/MV5BMjE4NzgzNzEwMl5BMl5BanBnXkFtZTgwMTMzMDE0NjE@._V1_SY1000_SX675_AL_.jpg",
                    "A young boy is raised within the confines of a small shed.",
                    "https://redirector.googlevideo.com/videoplayback?ip=2001%3A19f0%3A7402%3A95%3A5400%3Aff%3Afe6a%3Ad50a&key=yt6&signature=A6383B76EADD283311583D11BFF9B3BC75C4D67A.3004DC091D25F77C7ECB922B146E223E42ED7334&sparams=dur%2Cei%2Cid%2Cip%2Cipbits%2Citag%2Clmt%2Cmime%2Cmm%2Cmn%2Cms%2Cmv%2Cpl%2Cratebypass%2Crequiressl%2Csource%2Cexpire&ipbits=0&c=WEB&itag=22&id=o-AIz5j98g7qS1fvcmMjdFB5XbOTEVckatd4HW4xf1wyUS&ei=RF2DWtLwNcS9WLOrpJAB&lmt=1518196526903269&fvip=1&mime=video%2Fmp4&requiressl=yes&mm=31%2C26&mn=sn-ab5sznl7%2Csn-p5qlsns7&ratebypass=yes&mt=1518557982&mv=u&ms=au%2Conr&source=youtube&pl=53&dur=150.209&expire=1518580133"
            )
    )

}