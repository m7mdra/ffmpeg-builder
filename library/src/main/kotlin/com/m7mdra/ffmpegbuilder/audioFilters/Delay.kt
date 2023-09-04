package com.m7mdra.ffmpegbuilder.audioFilters

import audioFilter.AudioFilter

class Delay(private val delayMilliseconds: Long) : AudioFilter {
    override fun build(): String {
        return "adelay=${delayMilliseconds}|${delayMilliseconds}"
    }
}