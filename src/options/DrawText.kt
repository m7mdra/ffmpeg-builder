package options

import options.model.DrawTextInput

class DrawText(val input: DrawTextInput) : Option<DrawTextInput>("-vf drawtext=", input) {
}