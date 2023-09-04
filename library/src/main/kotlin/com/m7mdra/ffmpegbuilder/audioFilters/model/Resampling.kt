package com.m7mdra.ffmpegbuilder.audioFilters.model

import audioFilter.AudioFilter

class Resampling(private val sampleRate: Int) : AudioFilter {
    override fun build(): String {
        return "aresample=resampler=soxr:precision=33:osr=$sampleRate"
    }
}