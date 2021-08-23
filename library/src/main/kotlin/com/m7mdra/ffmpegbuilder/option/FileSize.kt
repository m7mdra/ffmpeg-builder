package com.m7mdra.ffmpegbuilder.option

class FileSize : Option {
    private val size: Any

    constructor(size: Int) {
        this.size = size
    }
    constructor(size: String) {
        this.size = size
    }

    override fun build(): String {
        return "-fs $size"
    }

}
