package videoFilter

import videoFilter.model.DrawTextInput

class DrawText(val input: DrawTextInput) : VideoFilter {
    override fun build(): String {
        //TODO
        return "drawtext=fontfile=${input.fontPath}:" +
                "text='${input.text}':fontcolor=white:fontsize=${input.fontSize}:box=1:boxcolor=black@0.5:" +
                "boxborderw=5:${input.position.value}"
    }
}
