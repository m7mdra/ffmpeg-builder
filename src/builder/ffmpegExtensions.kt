package builder

import filter.VideoFilter
import option.Option

fun ffmpeg(builder: FFMPEGBuilder.() -> Unit): FFMPEGBuilder {
    val ffmpegBuilder = FFMPEGBuilder()
    ffmpegBuilder.builder()
    return ffmpegBuilder
}

operator fun FFMPEGBuilder.plus(filter: VideoFilter<*>) {
    videoFilter(filter)
}

operator fun FFMPEGBuilder.plus(option: Option<*>) {
    videoOption(option)
}

