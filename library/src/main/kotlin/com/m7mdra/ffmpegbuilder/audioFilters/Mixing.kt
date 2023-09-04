package com.m7mdra.ffmpegbuilder.audioFilters

import audioFilter.AudioFilter

class Mixing(private val inputs: List<String>) : AudioFilter {
    override fun build(): String {
        val inputsStr = inputs.joinToString("|")
        return "amix=inputs=$inputsStr"
    }
}
