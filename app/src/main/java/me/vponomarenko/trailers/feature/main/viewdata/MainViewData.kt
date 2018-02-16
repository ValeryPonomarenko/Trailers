package me.vponomarenko.trailers.feature.main.viewdata

import me.vponomarenko.trailers.data.model.Trailer

/**
 * Author: Valery Ponomarenko
 * Date: 12/02/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

sealed class MainViewData {

    class Loading : MainViewData()

    data class Error(val message: String) : MainViewData()

    data class Trailers(val trailers: List<Trailer>) : MainViewData()

}