package com.m7mdra.ffmpegbuilder.builder

import builder.FFMPEGBuilder
import com.m7mdra.ffmpegbuilder.option.Option
import com.m7mdra.ffmpegbuilder.videoFilters.VideoFilter

fun ffmpeg(builder: FFMPEGBuilder.() -> Unit): FFMPEGBuilder {
    val ffmpegBuilder = FFMPEGBuilder()
    ffmpegBuilder.builder()
    return ffmpegBuilder
}

operator fun FFMPEGBuilder.plus(filter: VideoFilter) {
    filter(filter)
}

operator fun FFMPEGBuilder.plus(option: Option) {
    option(option)
}

