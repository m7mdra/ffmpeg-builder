package com.m7mdra.ffmpegbuilder.videoFilters


class Scale(val width: Double, val height: Double) : VideoFilter {
    override fun build(): String {
        return "scale=$width:$height"
    }
}