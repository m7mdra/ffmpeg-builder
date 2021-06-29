package filter

import filter.model.DrawTextInput

class DrawText(val input: DrawTextInput) : VideoFilter<DrawTextInput>("drawtext", input) {
    override fun build(): String {
        return "$name=fontfile=${input.fontPath}:" +
                "text='${input.text}':fontcolor=white:fontsize=${input.fontSize}:box=1:boxcolor=black@0.5:" +
                "boxborderw=5:${input.position.value}"
    }
}
