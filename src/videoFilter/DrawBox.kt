package videoFilter

import videoFilter.model.DrawBoxInput
import java.lang.StringBuilder

class DrawBox(private val input: DrawBoxInput) : VideoFilter {
    override fun build(): String {
        //drawbox=x=150:w=600:h=400:c=yellow ship1.avi
        return buildString {
            append("drawbox=")
            append("x=${input.x}")
            append(":")
            append("y=${input.y}")
            append(":")
            append("h=${input.height}")
            append(":")
            append("w=${input.width}")
            append(":")
            append("t=${input.thickness}")
            append(":")
            append("c=${input.color}")

        }
    }
}

