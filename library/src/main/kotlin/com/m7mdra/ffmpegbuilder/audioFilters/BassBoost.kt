package com.m7mdra.ffmpegbuilder.audioFilters

import audioFilter.AudioFilter

class BassBoost(private val gain: Double) : AudioFilter {
    override fun build(): String {
        return "bass=g=$gain"
    }
}