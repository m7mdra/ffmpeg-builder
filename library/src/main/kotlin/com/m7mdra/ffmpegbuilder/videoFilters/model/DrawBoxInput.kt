package com.m7mdra.ffmpegbuilder.videoFilters.model

import com.m7mdra.ffmpegbuilder.option.model.Color

data class DrawBoxInput(
    val x: Int = 0,
    val y: Int = 0,
    val height: Int,
    val width: Int,
    // greeting your thicness [https://www.youtube.com/watch?v=zBcu1g0an5o]
    val thickness: Int = 4,
    val color: String = Color.Red.named()

)