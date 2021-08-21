package com.m7mdra.ffmpegbuilder.option

import com.m7mdra.ffmpegbuilder.option.model.FrameSize

class ResizeToPredefined(private val size: FrameSize) : Option{
    override fun build(): String {
        return  "-s ${size.name}"
    }

}
