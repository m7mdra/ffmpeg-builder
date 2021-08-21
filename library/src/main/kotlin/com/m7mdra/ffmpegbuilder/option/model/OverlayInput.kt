package com.m7mdra.ffmpegbuilder.option.model

import java.io.File

class OverlayInput {
    val path: String
    val position: RelativePosition

    constructor(file: File, relativePosition: RelativePosition) {
        this.path = file.path
        this.position = relativePosition
    }

    constructor(path: String, relativePosition: RelativePosition) {
        this.path = path
        this.position = relativePosition
    }

}