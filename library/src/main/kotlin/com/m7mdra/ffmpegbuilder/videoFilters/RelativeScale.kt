package com.m7mdra.ffmpegbuilder.videoFilters

import com.m7mdra.ffmpegbuilder.option.model.RelativeDimension
import com.m7mdra.ffmpegbuilder.videoFilters.VideoFilter

class RelativeScale(val input: RelativeDimension) : VideoFilter {
    override fun build(): String {
        return "scale=${input.widthWithModifier}:${input.heightWithModifier}"
    }
}
