package com.m7mdra.ffmpegbuilder.audioFilters

import audioFilter.AudioFilter

class Pitch(private val pitch: Double) : AudioFilter {
    override fun build(): String {
        return "asetrate=r=$pitch*44100"
    }
}