package com.m7mdra.ffmpegbuilder.audioFilters

import audioFilter.AudioFilter
import com.m7mdra.ffmpegbuilder.audioFilters.model.FlangerSettings

class Flanger(private val settings: FlangerSettings) : AudioFilter {
    override fun build(): String {
        return buildString {
            append("flanger=d=")
            append(settings.delay)
            append(":depth=")
            append(settings.depth)
            append(":r=")
            append(settings.regen)
            append(":w=")
            append(settings.width)
            append(":s=")
            append(settings.speed)
        }
    }
}