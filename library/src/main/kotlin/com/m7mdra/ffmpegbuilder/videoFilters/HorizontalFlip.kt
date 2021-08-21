package com.m7mdra.ffmpegbuilder.videoFilters


class HorizontalFlip : VideoFilter {
    override fun build(): String {
        return "hflip"
    }
}