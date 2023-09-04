package com.m7mdra.ffmpegbuilder.audioFilters

import audioFilter.AudioFilter

class LowPass(private val frequency: CutOffFrequency) : AudioFilter {
    override fun build(): String {
        return "lowpass=f=$frequency"
    }
}