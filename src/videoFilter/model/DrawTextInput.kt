package videoFilter.model

import option.model.TextRelativePosition
import java.io.File

class DrawTextInput {
    val text: String
    val fontPath: String
    val fontSize: Int
    val fontColor: String
    val backgroundColor: String
    val position: TextRelativePosition
    val boxBorderWidth :Int

    constructor(
        text: String,
        fontPath: String,
        fontSize: Int,
        fontColor: String,
        backgroundColor: String,
        position: TextRelativePosition,
        boxBorderWidth: Int
    ) {
        this.text = text
        this.fontPath = fontPath
        this.fontSize = fontSize
        this.fontColor = fontColor
        this.backgroundColor = backgroundColor
        this.position = position
        this.boxBorderWidth = boxBorderWidth
    }
    constructor(
        text: String,
        fontPath: File,
        fontSize: Int,
        fontColor: String,
        backgroundColor: String,
        position: TextRelativePosition,
        boxBorderWidth: Int
    ) {
        this.text = text
        this.fontPath = fontPath.path
        this.fontSize = fontSize
        this.fontColor = fontColor
        this.backgroundColor = backgroundColor
        this.position = position
        this.boxBorderWidth = boxBorderWidth

    }

}