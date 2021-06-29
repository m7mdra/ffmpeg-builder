package filter

import option.model.RelativeDimension

class RelativeScale(val input: RelativeDimension) : VideoFilter<RelativeDimension>("scale", input) {
    override fun build(): String {
        return "$name=${input.widthWithModifier}:${input.heightWithModifier}"
    }
}
