package com.m7mdra.ffmpegbuilder.option.model

enum class RelativePosition(val value:String) {
    TopLeftCorner(""),
    TopRightCorner("W-w"),
    BottomLeftCorner("0:H-h"),
    BottomRightCorner("W-w:H-h")
}
