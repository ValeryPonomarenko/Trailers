package me.vponomarenko.trailers.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import me.vponomarenko.trailers.data.repository.ITrailersRepository
import me.vponomarenko.trailers.data.transition.PlayerTransition
import me.vponomarenko.trailers.data.viewdata.MainViewData
import me.vponomarenko.trailers.router.base.INavigator
import me.vponomarenko.trailers.ui.Screens
import javax.inject.Inject

/**
 * Author: Valery Ponomarenko
 * Date: 12/02/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

class MainViewModel @Inject constructor(
        private val repository: ITrailersRepository,
        private val navigator: INavigator
) : ViewModel() {

    val trailers = MutableLiveData<MainViewData>()

    init {
        loadTrailers()
    }

    fun onTrailerClick(playerTransition: PlayerTransition) {
        navigator.navigatorTo(Screens.Player, playerTransition)
    }

    private fun loadTrailers() {
        repository.loadTrailers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { trailers.value = MainViewData.Loading() }
                .subscribe({
                    trailers.value = MainViewData.Trailers(it)
                }, {
                    trailers.value = MainViewData.Error(it.message ?: "Something went wrong")
                })
    }

}