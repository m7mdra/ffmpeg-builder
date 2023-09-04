package com.m7mdra.ffmpegbuilder.audioFilters

import audioFilter.AudioFilter

class TrebleBoost(private val gain: Double) : AudioFilter {
    override fun build(): String {
        return "treble=g=$gain"
    }
}
