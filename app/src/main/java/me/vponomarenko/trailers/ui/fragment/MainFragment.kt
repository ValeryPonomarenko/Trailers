package me.vponomarenko.trailers.ui.fragment

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_main.*
import me.vponomarenko.trailers.R
import me.vponomarenko.trailers.data.viewdata.MainViewData
import me.vponomarenko.trailers.di.module.ViewModelFactory
import me.vponomarenko.trailers.extension.installToolbar
import me.vponomarenko.trailers.extension.observe
import me.vponomarenko.trailers.utils.adapter.TrailersRVAdapter
import me.vponomarenko.trailers.viewmodel.MainViewModel
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

        viewModel.trailers.observe(this) { data: MainViewData? ->
            when (data) {
                is MainViewData.Loading -> progress_bar.visibility = View.VISIBLE
                is MainViewData.Trailers -> {
                    progress_bar.visibility = View.GONE
                    trailersAdapter.trailers = data.trailers
                }
            }
        }
    }

}