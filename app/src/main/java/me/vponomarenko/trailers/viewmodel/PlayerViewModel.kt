package me.vponomarenko.trailers.viewmodel

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
import me.vponomarenko.trailers.data.model.Trailer
import me.vponomarenko.trailers.data.model.TrailerFullInfo
import me.vponomarenko.trailers.data.repository.ITrailersRepository
import me.vponomarenko.trailers.data.transition.PlayerTransition
import me.vponomarenko.trailers.data.viewdata.PlayerViewData
import me.vponomarenko.trailers.router.base.INavigator
import me.vponomarenko.trailers.ui.Screens
import javax.inject.Inject

/**
 * Author: Valery Ponomarenko
 * Date: 12/02/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */
 
class PlayerViewModel @Inject constructor(
        private val repository: ITrailersRepository,
        private val navigator: INavigator
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

    private fun buildMediaSource(uri: Uri): MediaSource {
        return ExtractorMediaSource
                .Factory(DefaultHttpDataSourceFactory("exoplayer-codelab"))
                .createMediaSource(uri)
    }

}
