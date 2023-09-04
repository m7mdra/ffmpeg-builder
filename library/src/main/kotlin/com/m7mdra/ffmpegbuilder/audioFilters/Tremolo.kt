package com.m7mdra.ffmpegbuilder.audioFilters

import audioFilter.AudioFilter

class Tremolo(
    private val frequency: Double, // Frequency in Hz
    private val depth: Double // Depth (0.0 to 1.0)
) : AudioFilter {
    override fun build(): String {
        // Build the FFmpeg filter string for the tremolo effect
        return "tremolo=f=$frequency:d=$depth"
    }
}
