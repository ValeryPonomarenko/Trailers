package me.vponomarenko.widget

import android.content.Context
import android.net.Uri
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory
import kotlinx.android.synthetic.main.view_preview_video.view.*
import me.vponomarenko.trailers.R

/**
 * Author: Valery Ponomarenko
 * Date: 17/02/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

class VideoPreviewView @JvmOverloads constructor(
        context: Context,
        attributeSet: AttributeSet? = null
) : FrameLayout(context, attributeSet) {

    private var player: SimpleExoPlayer? = null

    init {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.view_preview_video, this, true)
    }

    fun init() {
        player = PlayerFactory.create(context)
        view_player.player = player
    }

    fun pause() {
        player?.playWhenReady = false
    }

    fun resume() {
        player?.playWhenReady = true
    }

    fun release() {
        player?.release()
        player = null
    }

    fun startPlaying(mediaSource: MediaSource, seekTo: Long = 0) {
        player?.prepare(mediaSource)
        player?.seekTo(seekTo)
        player?.playWhenReady = true
    }

    fun startPlaying(url: String, seekTo: Long = 0) {
        startPlaying(buildMediaSource(Uri.parse(url)), seekTo)
    }

    private fun buildMediaSource(uri: Uri): MediaSource {
        return ExtractorMediaSource
                .Factory(DefaultHttpDataSourceFactory("exoplayer-codelab"))
                .createMediaSource(uri)
    }

}