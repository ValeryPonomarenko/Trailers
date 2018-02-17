package me.vponomarenko.trailers.feature.main.view

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_main.*
import me.vponomarenko.trailers.R
import me.vponomarenko.trailers.base.BaseFragment
import me.vponomarenko.trailers.di.module.ViewModelFactory
import me.vponomarenko.trailers.extension.installToolbar
import me.vponomarenko.trailers.extension.observe
import me.vponomarenko.trailers.feature.listoftrailers.TrailersRVAdapter
import me.vponomarenko.trailers.feature.main.viewdata.MainViewData
import me.vponomarenko.trailers.feature.main.viewmodel.MainViewModel
import me.vponomarenko.trailers.interactor.playerevents.PlayerEvent
import javax.inject.Inject

/**
 * Author: Valery Ponomarenko
 * Date: 03/02/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */
 
class MainFragment : BaseFragment() {

    companion object {
        private const val NUMBER_OF_COLUMNS = 2

        fun newInstance() = MainFragment()
    }

    @Inject
    protected lateinit var viewModelFactory: ViewModelFactory

    @Inject
    protected lateinit var trailersAdapter: TrailersRVAdapter

    private val viewModel by lazy {
        ViewModelProviders.of(activity!!, viewModelFactory).get(MainViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
            inflater.inflate(R.layout.fragment_main, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        installToolbar(toolbar, R.string.main_fragment_title)

        rv_trailers.layoutManager = GridLayoutManager(context, NUMBER_OF_COLUMNS)
        rv_trailers.adapter = trailersAdapter
        trailersAdapter.onClickListener = {
            viewModel.onTrailerClick(it)
        }

        observeTrailers()
        observePlayerEvents()

        view_video_preview.init()
        view_video_preview.startPlaying("http://178.162.205.104/download/?title=la+la+land+-+trailer&url=https%3A%2F%2Fcs510606.vkuservideo.net%2F8%2Fu20274712%2Fvideos%2Fe112b70490.720.mp4%3Fextra%3DCBg9YHFeN1eSPW_k0yRLxPa0WxJhdY_dixoR-kUF7YkP_VLDqTSPdsAsYmiTZgYCCUC8uszB6fI8m0DBuTONrqpGRoZQbvnikdh0VzRlr5Ckg8hz809y1BN9KQz2GckSAQ")
    }

    override fun onResume() {
        super.onResume()
        view_video_preview.resume()
    }

    override fun onPause() {
        super.onPause()
        view_video_preview.pause()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        view_video_preview.pause()
    }

    override fun onDestroy() {
        super.onDestroy()
        view_video_preview.release()
    }

    private fun observeTrailers() {
        viewModel.trailers.observe(this) {
            when (it) {
                is MainViewData.Loading -> progress_bar.visibility = View.VISIBLE
                is MainViewData.Trailers -> {
                    progress_bar.visibility = View.GONE
                    trailersAdapter.trailers = it.trailers
                }
            }
        }
    }

    private fun observePlayerEvents() {
        viewModel.playerEvent.observe(this) {
            when (it) {
                is PlayerEvent.Clear -> view_video_preview.visibility = View.GONE
                is PlayerEvent.PlayingInPreview -> {
                    view_video_preview.visibility = View.VISIBLE
                    view_video_preview.startPlaying(it.mediaSource, it.seekPosition)
                }
            }
        }
    }

}