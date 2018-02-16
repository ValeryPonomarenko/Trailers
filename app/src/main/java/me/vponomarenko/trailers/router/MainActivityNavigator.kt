package me.vponomarenko.trailers.router

import android.app.FragmentTransaction
import android.support.v4.view.ViewCompat
import me.vponomarenko.trailers.R
import me.vponomarenko.trailers.data.transition.PlayerTransition
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
                if (data is PlayerTransition) {
                    fragmentManager
                            .beginTransaction()
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                            .addSharedElement(data.imageView, ViewCompat.getTransitionName(data.imageView))
                            .replace(R.id.fragment_container, PlayerFragment.newInstance(data.trailerName))
                            .addToBackStack(PlayerFragment::class.toString())
                            .commit()
                }
            }
        }
    }

    override fun onBackPressed() {
        fragmentManager.popBackStack()
    }

}