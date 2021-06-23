package option

import option.model.DrawTextInput
import option.model.RelativeDimension

abstract class VideoFilter<T>(val name: String, input: T) {
}

class DrawText1(val input: DrawTextInput) : VideoFilter<DrawTextInput>("drawtext", input)
class RelativeScale1(val input: RelativeDimension) : VideoFilter<RelativeDimension>("scale", input)