package options

import options.model.OverlayInput

class Overlay(val input: OverlayInput) : Option<OverlayInput>("-filter_complex overlay=", input) {
}