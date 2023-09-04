package com.m7mdra.ffmpegbuilder.audioFilters

import audioFilter.AudioFilter

class VolumeNormalization(
    private val targetLoudness: Double = -16.0,
    private val printStatistics: Boolean = false
) : AudioFilter {
    override fun build(): String {
        val statisticsOption = if (printStatistics) ":print_format=json" else ""
        return "loudnorm=i=${targetLoudness}${statisticsOption}"
    }
}