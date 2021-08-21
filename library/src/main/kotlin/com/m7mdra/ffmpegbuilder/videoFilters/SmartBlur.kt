package com.m7mdra.ffmpegbuilder.videoFilters

import com.m7mdra.ffmpegbuilder.videoFilters.VideoFilter

class SmartBlur(val radius: Double, val strength: Double, val threshold: Double) :
    VideoFilter {
    override fun build(): String {
        return "smartblur=$radius:$strength:$threshold"
    }
}