package filter

import filter.model.DrawTextInput

class DrawText(val input: DrawTextInput) : VideoFilter<DrawTextInput>("drawtext", input)
