package com.m7mdra.ffmpegbuilder.videoFilters

import com.m7mdra.ffmpegbuilder.videoFilters.VideoFilter

class VerticalFlip : VideoFilter {
    override fun build(): String {
        return  "vflip"
    }
}