package me.vponomarenko.trailers.router.base

import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity

/**
 * Author: Valery Ponomarenko
 * Date: 13/02/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

abstract class BaseNavigator<out T: AppCompatActivity>(
        protected val activity: T
) {

    val fragmentManager: FragmentManager
        get() = activity.supportFragmentManager

}