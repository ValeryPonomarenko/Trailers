package me.vponomarenko.trailers.router.base

/**
 * Author: Valery Ponomarenko
 * Date: 13/02/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

interface INavigator {

    fun navigatorTo(screenName: String, data: Any)

    fun onBackPressed()

}