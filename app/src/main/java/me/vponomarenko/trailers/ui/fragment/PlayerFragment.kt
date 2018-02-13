package me.vponomarenko.trailers.ui.fragment

import android.arch.lifecycle.ViewModelProviders
import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.MediaSource
import kotlinx.android.synthetic.main.fragment_player.*
import kotlinx.android.synthetic.main.item_trailer_small_card.*
import me.vponomarenko.trailers.R
import me.vponomarenko.trailers.data.model.TrailerFullInfo
import me.vponomarenko.trailers.data.viewdata.PlayerViewData
import me.vponomarenko.trailers.di.module.ViewModelFactory
import me.vponomarenko.trailers.extension.observe
import me.vponomarenko.trailers.viewmodel.PlayerViewModel
import javax.inject.Inject

/**
 * Author: Valery Ponomarenko
 * Date: 03/02/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

class PlayerFragment : BaseFragment() {

    companion object {
        private const val EXTRA_TRAILER_NAME = "me.vponomarenko.trailers.ui.fragment.trailer_name"

        fun newInstance(trailerName: String) = PlayerFragment().apply {
            val args = Bundle()
            args.putString(EXTRA_TRAILER_NAME, trailerName)

            arguments = args
        }
    }

    @Inject
    protected lateinit var viewModelFactory: ViewModelFactory

    @Inject
    protected lateinit var player: SimpleExoPlayer

    private val viewModel by lazy {
        ViewModelProviders.of(activity!!, viewModelFactory).get(PlayerViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
            inflater.inflate(R.layout.fragment_player, container, false)

    override fun onDestroy() {
        super.onDestroy()
        player.release()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view_player.player = player
        viewModel.loadTrailerFullInfo(
                arguments?.getString(EXTRA_TRAILER_NAME)
                        ?: throw Resources.NotFoundException())
        viewModel.trailerFullInfo.observe(this) {
            when (it) {
                is PlayerViewData.Info -> {
                    showTrailerInfo(it.trailerFullInfo)
                    startPlaying(it.mediaSource)
                }
            }
        }
    }

    private fun showTrailerInfo(info: TrailerFullInfo) {
        Glide.with(this).load(info.imageUrl).into(image_trailer_logo)
        text_trailer_title.text = info.title
        text_trailer_description.text = info.description
    }

    private fun startPlaying(source: MediaSource) {
        player.prepare(source, true, false)
    }

}