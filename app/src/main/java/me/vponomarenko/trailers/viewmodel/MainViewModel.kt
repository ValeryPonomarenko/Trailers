package me.vponomarenko.trailers.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import me.vponomarenko.trailers.data.repository.ITrailersRepository
import me.vponomarenko.trailers.data.viewdata.MainViewData
import javax.inject.Inject

/**
 * Author: Valery Ponomarenko
 * Date: 12/02/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

class MainViewModel @Inject constructor(
        private val repository: ITrailersRepository
) : ViewModel() {

    val trailers = MutableLiveData<MainViewData>()

    init {
        loadTrailers()
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