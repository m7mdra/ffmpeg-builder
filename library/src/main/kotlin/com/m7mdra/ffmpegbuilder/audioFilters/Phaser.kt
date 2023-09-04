package com.m7mdra.ffmpegbuilder.audioFilters

import audioFilter.AudioFilter

class Phaser(
    private val delay: Double, // Delay in milliseconds
    private val decay: Double, // Decay factor (0.0 to 1.0)
    private val speed: Double // Speed in Hz
) : AudioFilter {
    override fun build(): String {
        return "aphaser=s=$speed:d=$delay:f=$decay"
    }
}