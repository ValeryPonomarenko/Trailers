package me.vponomarenko.trailers.extension

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Author: Valery Ponomarenko
 * Date: 17/02/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */
 
operator fun CompositeDisposable.plusAssign(disposable: Disposable) {
    this.add(disposable)
}