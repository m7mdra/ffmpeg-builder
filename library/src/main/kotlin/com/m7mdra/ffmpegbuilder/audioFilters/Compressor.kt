package com.m7mdra.ffmpegbuilder.audioFilters

import audioFilter.AudioFilter
import com.m7mdra.ffmpegbuilder.audioFilters.model.CompressorSettings

class Compressor(private val settings: CompressorSettings) : AudioFilter {
    override fun build(): String {
        // Build the FFmpeg filter string for the compressor effect
        val threshold = settings.threshold
        val ratio = settings.ratio
        val attackTime = settings.attackTime
        val releaseTime = settings.releaseTime

        return "acompressor=threshold=${threshold}:ratio=${ratio}:attack=${attackTime}:release=${releaseTime}"
    }
}