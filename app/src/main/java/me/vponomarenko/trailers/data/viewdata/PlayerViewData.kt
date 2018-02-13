package me.vponomarenko.trailers.data.viewdata

import me.vponomarenko.trailers.data.model.TrailerFullInfo

/**
 * Author: Valery Ponomarenko
 * Date: 13/02/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */
 
sealed class PlayerViewData {

    class Loading : PlayerViewData()

    data class Info(val trailerFullInfo: TrailerFullInfo) : PlayerViewData()

    data class Error(val message: String) : PlayerViewData()

}