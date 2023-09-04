package com.m7mdra.ffmpegbuilder.audioFilters.model


data class CompressorSettings(
    val threshold: Double, // Threshold in dB
    val ratio: Double, // Compression ratio
    val attackTime: Double, // Attack time in milliseconds
    val releaseTime: Double // Release time in milliseconds
)