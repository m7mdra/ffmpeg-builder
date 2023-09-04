package com.m7mdra.ffmpegbuilder.audioFilters.model

class FlangerSettings(
    val delay: Double, // Delay in milliseconds
    val depth: Double, // Depth (0.0 to 1.0)
    val regen: Double, // Regeneration (0.0 to 1.0)
    val width: Double, // Width (0.0 to 1.0)
    val speed: Double // Speed in Hz
) {

}
