package com.m7mdra.ffmpegbuilder.option

class FileSize(private val size: Int) : Option {
    override fun build(): String {
        return "-fs $size"
    }

}
