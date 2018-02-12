package me.vponomarenko.trailers.viewmodel

import android.arch.lifecycle.ViewModel
import me.vponomarenko.trailers.data.repository.ITrailersRepository
import javax.inject.Inject

/**
 * Author: Valery Ponomarenko
 * Date: 12/02/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */
 
class PlayerViewModel @Inject constructor(
        private val trailersRepository: ITrailersRepository
) : ViewModel()
