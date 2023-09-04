package com.m7mdra.ffmpegbuilder.audioFilters

import audioFilter.AudioFilter

typealias CutOffFrequency = Double

class Highpass(private val frequency: CutOffFrequency) : AudioFilter {
    override fun build(): String {
        return "highpass=f=$frequency"
    }
}