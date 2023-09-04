package com.m7mdra.ffmpegbuilder.audioFilters

import audioFilter.AudioFilter
import com.m7mdra.ffmpegbuilder.audioFilters.model.EqualizerSetting

class Equalizer(
    private val equalizerSettings: List<EqualizerSetting>
) : AudioFilter {
    override fun build(): String {
        val settingsString = equalizerSettings.joinToString(":") { it.value() }
        return "equalizer=$settingsString"
    }
}