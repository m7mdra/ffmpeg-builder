package com.m7mdra.ffmpegbuilder.audioFilters

import audioFilter.AudioFilter

class ChannelManipulation(private val channelLayout: String) : AudioFilter {
    override fun build(): String {
        // Build the FFmpeg filter string for channel manipulation
        return "aformat=channel_layouts=$channelLayout"
    }
}