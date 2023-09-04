package com.m7mdra.ffmpegbuilder.audioFilters.model

data class ChorusSettings(

    val inGain: Double,
    val outGain: Double,
    val delays: List<Double>,
    val decays: List<Double>
)
