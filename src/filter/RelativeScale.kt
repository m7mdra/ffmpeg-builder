package filter

import option.model.RelativeDimension

class RelativeScale(val input: RelativeDimension) : VideoFilter<RelativeDimension>("scale", input)
