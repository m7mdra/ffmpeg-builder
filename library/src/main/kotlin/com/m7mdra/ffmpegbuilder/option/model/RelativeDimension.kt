package com.m7mdra.ffmpegbuilder.option.model

class RelativeDimension private constructor(val widthWithModifier: String, val heightWithModifier: String) {
    companion object {
        fun multiplyBy(width: Double, height: Double): RelativeDimension {
            return RelativeDimension("iw*$width", "ih*$height")
        }

        fun divideBy(width: Double, height: Double): RelativeDimension {
            return RelativeDimension("iw*$width", "ih*$height")
        }

    }
}
