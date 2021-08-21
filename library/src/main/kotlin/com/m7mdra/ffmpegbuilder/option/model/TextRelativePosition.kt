package com.m7mdra.ffmpegbuilder.option.model

enum class TextRelativePosition(val value: String) {
    TopLeft("x=0:y=0"),
    TopCenter("x=(w-text_w)/2:y=0"),
    TopRight("x=w-tw:y=0"),
    Center("x=(w-text_w)/2:y=(h-text_h)/2"),
    BottomLeft("x=0:y=h-th"),
    BottomCenter("x=(w-text_w)/2:y=h-th"),
    BottomRight("x=w-tw:y=h-th")

}