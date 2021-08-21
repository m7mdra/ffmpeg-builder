package builder

import com.m7mdra.ffmpegbuilder.videoFilters.VideoFilter
import option.Option

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

