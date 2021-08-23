package com.m7mdra.example

import builder.FFMPEGBuilder
import com.m7mdra.ffmpegbuilder.MB
import com.m7mdra.ffmpegbuilder.audioFilters.Volume
import com.m7mdra.ffmpegbuilder.builder.ffmpeg
import com.m7mdra.ffmpegbuilder.option.FileSize
import com.m7mdra.ffmpegbuilder.option.model.RelativeDimension
import com.m7mdra.ffmpegbuilder.videoFilters.NoiseReduction
import com.m7mdra.ffmpegbuilder.videoFilters.RelativeScale
import com.m7mdra.ffmpegbuilder.videoFilters.Transpose
import videoFilter.model.Degree


fun main() {
    val builder = ffmpeg {
        input("testdata/input.mp4")
        output("testdata/output.mp4")
        filter(RelativeScale(RelativeDimension.divideBy(2.0, 2.0)))
        filter(NoiseReduction())
        filter(Transpose(Degree.CloseWise))
        filter(Volume(1.5))
        option(FileSize(100.MB))

    }
    val cmd = builder.build()
    println(cmd)
}