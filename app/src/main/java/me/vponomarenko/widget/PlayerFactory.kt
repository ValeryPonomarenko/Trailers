package me.vponomarenko.widget

import android.content.Context
import com.google.android.exoplayer2.*
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.trackselection.TrackSelector
import com.google.android.exoplayer2.upstream.BandwidthMeter
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter

/**
 * Author: Valery Ponomarenko
 * Date: 17/02/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

object PlayerFactory {

    fun create(context: Context,
               bandwidthMeter: BandwidthMeter = provideBandwidthMeter(),
               renderersFactory: RenderersFactory = provideRenderersFactory(context),
               trackSelector: TrackSelector = provideTrackSelector(bandwidthMeter),
               loadControl: LoadControl = provideLoadControl()) =
            ExoPlayerFactory.newSimpleInstance(renderersFactory, trackSelector, loadControl)

    fun provideBandwidthMeter(): BandwidthMeter = DefaultBandwidthMeter()

    fun provideLoadControl(): LoadControl = DefaultLoadControl()

    fun provideTrackSelector(bandwidthMeter: BandwidthMeter): TrackSelector =
            DefaultTrackSelector(AdaptiveTrackSelection.Factory(bandwidthMeter))

    fun provideRenderersFactory(context: Context): RenderersFactory =
            DefaultRenderersFactory(context)

}