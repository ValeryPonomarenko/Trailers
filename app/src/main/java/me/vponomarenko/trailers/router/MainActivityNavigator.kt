package me.vponomarenko.trailers.router

import me.vponomarenko.trailers.R
import me.vponomarenko.trailers.router.base.BaseNavigator
import me.vponomarenko.trailers.router.base.INavigator
import me.vponomarenko.trailers.ui.Screens
import me.vponomarenko.trailers.ui.activity.MainActivity
import me.vponomarenko.trailers.ui.fragment.PlayerFragment
import javax.inject.Inject

/**
 * Author: Valery Ponomarenko
 * Date: 13/02/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

class MainActivityNavigator @Inject constructor(
        activity: MainActivity
) : BaseNavigator<MainActivity>(activity), INavigator {

    override fun navigatorTo(screenName: String, data: Any) {
        when (screenName) {
            Screens.Player -> {
                if (data is String) {
                    fragmentManager
                            .beginTransaction()
                            .replace(R.id.player_container, PlayerFragment.newInstance(data))
                            .commit()
                }
            }
        }
    }

    override fun onBackPressed() {
        val playerFragment = fragmentManager.findFragmentById(R.id.player_container)
        if (playerFragment != null) {
            fragmentManager
                    .beginTransaction()
                    .remove(playerFragment)
                    .commit()
        } else {
            activity.finish()
        }
    }

}