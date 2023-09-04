package com.m7mdra.ffmpegbuilder.audioFilters

import audioFilter.AudioFilter

typealias Strength = Double
class Reverb(private val strength: Strength) : AudioFilter {
    override fun build(): String {
        return "areverse,areverb=g=$strength"
    }
}