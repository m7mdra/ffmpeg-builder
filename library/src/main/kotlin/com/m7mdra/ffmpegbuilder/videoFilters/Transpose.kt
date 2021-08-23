package com.m7mdra.ffmpegbuilder.videoFilters

import videoFilter.model.Degree

class Transpose(private val input: Degree) : VideoFilter {
    override fun build(): String {
        return "transpose=${input.value}"
    }
}
