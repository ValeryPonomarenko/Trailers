package me.vponomarenko.trailers.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import me.vponomarenko.trailers.data.repository.ITrailersRepository
import me.vponomarenko.trailers.data.viewdata.PlayerViewData
import javax.inject.Inject

/**
 * Author: Valery Ponomarenko
 * Date: 12/02/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */
 
class PlayerViewModel @Inject constructor(
        private val repository: ITrailersRepository
) : ViewModel() {

    val trailerFullInfo = MutableLiveData<PlayerViewData>()

    fun loadTrailerFullInfo(trailerName: String) {
        repository.trailerFullInfo(trailerName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { trailerFullInfo.value = PlayerViewData.Loading() }
                .subscribe({
                    trailerFullInfo.value = PlayerViewData.Info(it)
                }, {
                    trailerFullInfo.value = PlayerViewData.Error(it.message ?: "Something went wrong")
                })
    }

}
