package me.vponomarenko.trailers.feature.main.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import me.vponomarenko.trailers.base.Screens
import me.vponomarenko.trailers.data.repository.ITrailersRepository
import me.vponomarenko.trailers.extension.plusAssign
import me.vponomarenko.trailers.feature.main.viewdata.MainViewData
import me.vponomarenko.trailers.feature.player.viewdata.PlayerTransition
import me.vponomarenko.trailers.interactor.playerevents.IPlayerEventsInteractor
import me.vponomarenko.trailers.interactor.playerevents.PlayerEvent
import me.vponomarenko.trailers.router.base.INavigator
import javax.inject.Inject

/**
 * Author: Valery Ponomarenko
 * Date: 12/02/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

class MainViewModel @Inject constructor(
        private val repository: ITrailersRepository,
        private val navigator: INavigator,
        private val playerEventsInteractor: IPlayerEventsInteractor
) : ViewModel() {

    private val subscriptions = CompositeDisposable()

    val trailers = MutableLiveData<MainViewData>()

    val playerEvent = MutableLiveData<PlayerEvent>()

    init {
        loadTrailers()
        observePlayInPreview()
    }

    override fun onCleared() {
        super.onCleared()
        subscriptions.clear()
    }

    fun onTrailerClick(playerTransition: PlayerTransition) {
        navigator.navigatorTo(Screens.Player, playerTransition)
    }

    private fun loadTrailers() {
        subscriptions += repository.loadTrailers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { trailers.value = MainViewData.Loading() }
                .subscribe({
                    trailers.value = MainViewData.Trailers(it)
                }, {
                    trailers.value = MainViewData.Error(it.message ?: "Something went wrong")
                })
    }

    private fun observePlayInPreview() {
        subscriptions += playerEventsInteractor.playerEventsObserver
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { playerEvent.value = PlayerEvent.Clear() }
                .filter { it !is PlayerEvent.Loading || it !is PlayerEvent.Paused }
                .subscribe({
                    playerEvent.value = it
                }, {
                    playerEvent.value = PlayerEvent.Clear()
                })
    }

}