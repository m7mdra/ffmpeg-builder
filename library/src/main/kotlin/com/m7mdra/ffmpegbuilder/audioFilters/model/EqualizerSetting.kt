package com.m7mdra.ffmpegbuilder.audioFilters.model

data class EqualizerSetting(val frequency: Double, val gain: Double) {
    fun value(): String = "f:$frequency:g:$gain"
}
