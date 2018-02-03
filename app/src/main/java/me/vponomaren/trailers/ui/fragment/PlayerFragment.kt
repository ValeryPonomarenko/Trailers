package me.vponomaren.trailers.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import me.vponomaren.trailers.R

/**
 * Author: Valery Ponomarenko
 * Date: 03/02/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

class PlayerFragment : Fragment() {

    companion object {

        fun newInstance() = PlayerFragment()

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
            inflater.inflate(R.layout.fragment_player, container, false)
}