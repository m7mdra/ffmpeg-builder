package videoFilter

import videoFilter.model.DrawTextInput

class DrawText(private val input: DrawTextInput) : VideoFilter {
    override fun build(): String {
        //TODO
        val buildString = buildString {
            append("drawtext=")
            if (input.fontPath != null) {
                append("fontfile=")
                append(input.fontPath)
                append(":")
            }
            append("text=")
            append("\'")
            append(input.text)
            append("\'")
            append(":")
            append("fontcolor=")
            append(input.fontColor)
            append(":")
            append("fontsize=")
            append(input.fontSize)
            if (input.showBox) {
                append(":")
                append("box=1")
                append(":")
                append("boxcolor=")
                append(input.boxColor)
                append(":")
                append("boxborderw=")
                append(input.boxBorderWidth)

            }
            append(":")
            append(input.position.value)

        }
        println(buildString)
        return buildString
    }
}
