package com.m7mdra.ffmpegbuilder.videoFilters

import com.m7mdra.ffmpegbuilder.videoFilters.model.InterlaceType

class Interlace(private val type: InterlaceType) : VideoFilter {
    override fun build(): String {
        return "setfield=${type.name.toLowerCase()}"
    }
}

