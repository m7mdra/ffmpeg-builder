package videoFilter.model

import option.model.TextRelativePosition
import java.io.File

class DrawTextInput(
    val text: String,
    val fontPath: String?,
    val fontSize: Int,
    val boxColor: String = Color.Black.namedWithOpacity(0.5),
    var fontColor: String = Color.White.named(),
    var showBox: Boolean = false,
    var position: TextRelativePosition = TextRelativePosition.Center,
    var boxBorderWidth: Int = 1
)