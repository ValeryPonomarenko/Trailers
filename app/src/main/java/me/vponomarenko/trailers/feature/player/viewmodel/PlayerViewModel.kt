package me.vponomarenko.trailers.feature.player.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.net.Uri
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers
import me.vponomarenko.trailers.base.Screens
import me.vponomarenko.trailers.data.model.Trailer
import me.vponomarenko.trailers.data.model.TrailerFullInfo
import me.vponomarenko.trailers.data.repository.ITrailersRepository
import me.vponomarenko.trailers.feature.player.viewdata.PlayerTransition
import me.vponomarenko.trailers.feature.player.viewdata.PlayerViewData
import me.vponomarenko.trailers.interactor.playerevents.IPlayerEventsInteractor
import me.vponomarenko.trailers.interactor.playerevents.PlayerEvent
import me.vponomarenko.trailers.router.base.INavigator
import javax.inject.Inject

/**
 * Author: Valery Ponomarenko
 * Date: 12/02/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */
 
class PlayerViewModel @Inject constructor(
        private val repository: ITrailersRepository,
        private val navigator: INavigator,
        private val playerEventsInteractor: IPlayerEventsInteractor
) : ViewModel() {

    val trailerFullInfo = MutableLiveData<PlayerViewData>()

    fun loadTrailerFullInfo(trailerName: String) {
        Single
                .zip(
                        repository.trailerFullInfo(trailerName),
                        repository.loadTrailers(),
                        BiFunction { fullInfo: TrailerFullInfo, seeAlso: List<Trailer> ->
                            return@BiFunction fullInfo to seeAlso
                        }
                )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { trailerFullInfo.value = PlayerViewData.Loading() }
                .subscribe({ (fullInfo, seeAlso) ->
                    trailerFullInfo.value = PlayerViewData.Info(
                            fullInfo,
                            buildMediaSource(Uri.parse(fullInfo.sourceUrl)),
                            seeAlso
                    )
                }, {
                    trailerFullInfo.value = PlayerViewData.Error(it.message
                            ?: "Something went wrong")
                })
    }

    fun onSeeAlsoTrailerClick(playerTransition: PlayerTransition) {
        navigator.navigatorTo(Screens.Player, playerTransition)
    }

    fun playInPreview(seekPosition: Long) {
        trailerFullInfo.value?.takeIf { it is PlayerViewData.Info }?.let {
            playerEventsInteractor
                    .publicPlayerEvent(
                            PlayerEvent.PlayingInPreview(
                                    (it as PlayerViewData.Info).mediaSource,
                                    seekPosition
                            )
                    )
        }
    }

    private fun buildMediaSource(uri: Uri): MediaSource {
        return ExtractorMediaSource
                .Factory(DefaultHttpDataSourceFactory("exoplayer-codelab"))
                .createMediaSource(uri)
    }

}
