package com.m7mdra.ffmpegbuilder.videoFilters

class BoxBlur(private val radius: Double, private val power: Double) : VideoFilter {
    override fun build(): String {
        return "boxblur=$radius:$power"
    }
}