package options

import options.model.DrawTextInput

class DrawText(input: DrawTextInput) : Option<DrawTextInput>("-vf drawtext=", input) {
}