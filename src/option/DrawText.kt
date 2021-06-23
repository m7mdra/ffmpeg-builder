package option

import option.model.DrawTextInput

class DrawText(input: DrawTextInput) : Option<DrawTextInput>("-vf drawtext=", input) {
}