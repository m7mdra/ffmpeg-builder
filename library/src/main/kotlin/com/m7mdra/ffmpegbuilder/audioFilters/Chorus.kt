package com.m7mdra.ffmpegbuilder.audioFilters

import audioFilter.AudioFilter
import com.m7mdra.ffmpegbuilder.audioFilters.model.ChorusSettings

class Chorus(private val settings: ChorusSettings) : AudioFilter {
    override fun build(): String {
        val delaysStr = settings.delays.joinToString(":")
        val decaysStr = settings.decays.joinToString(":")
        return "chorus=in_gain=${settings.inGain}:out_gain=${settings.outGain}:delays=$delaysStr:decays=$decaysStr"
    }
}