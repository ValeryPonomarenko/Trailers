package me.vponomarenko.trailers.base

import android.content.Context
import android.support.v4.app.Fragment
import dagger.android.support.AndroidSupportInjection

/**
 * Author: Valery Ponomarenko
 * Date: 12/02/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

abstract class BaseFragment : Fragment() {

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

}