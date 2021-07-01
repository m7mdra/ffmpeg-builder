package videoFilter

import option.model.RelativeDimension

class RelativeScale(val input: RelativeDimension) : VideoFilter {
    override fun build(): String {
        return "scale=${input.widthWithModifier}:${input.heightWithModifier}"
    }
}
