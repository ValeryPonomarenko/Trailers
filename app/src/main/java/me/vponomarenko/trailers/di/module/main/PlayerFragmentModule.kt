package me.vponomarenko.trailers.di.module.main

import android.content.Context
import com.google.android.exoplayer2.*
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.trackselection.TrackSelector
import com.google.android.exoplayer2.upstream.BandwidthMeter
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter
import dagger.Module
import dagger.Provides
import me.vponomarenko.trailers.di.scope.FragmentScope

/**
 * Author: Valery Ponomarenko
 * Date: 14/02/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

@Module
class PlayerFragmentModule {

    @Provides
    @FragmentScope
    fun provideBandwidthMeter(): BandwidthMeter = DefaultBandwidthMeter()

    @Provides
    @FragmentScope
    fun provideRenderersFactory(context: Context): RenderersFactory =
            DefaultRenderersFactory(context)

    @Provides
    @FragmentScope
    fun provideTrackSelector(bandwidthMeter: BandwidthMeter): TrackSelector =
            DefaultTrackSelector(AdaptiveTrackSelection.Factory(bandwidthMeter))

    @Provides
    @FragmentScope
    fun provideLoadControl(): LoadControl = DefaultLoadControl()

    @Provides
    @FragmentScope
    fun providePlayer(renderersFactory: RenderersFactory,
                      trackSelector: TrackSelector,
                      loadControl: LoadControl): SimpleExoPlayer =
            ExoPlayerFactory.newSimpleInstance(renderersFactory, trackSelector, loadControl)
                    .apply {
                        playWhenReady = true
                    }


}