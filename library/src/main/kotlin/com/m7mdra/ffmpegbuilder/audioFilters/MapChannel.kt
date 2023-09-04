package com.m7mdra.ffmpegbuilder.audioFilters

import audioFilter.AudioFilter

class MapChannel(private val channelLayout: String) : AudioFilter {
    override fun build(): String {
        return "aformat=channel_layouts=$channelLayout"
    }
}