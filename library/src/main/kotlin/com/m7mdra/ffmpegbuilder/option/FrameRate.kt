package com.m7mdra.ffmpegbuilder.option

class FrameRate(private val rate: Int) : Option {
    override fun build(): String {
        return "-r $rate"
    }
}
