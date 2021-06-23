package option

import option.model.OverlayInput

class Overlay(val input: OverlayInput) : Option<OverlayInput>("-filter_complex overlay=", input) {
}