package options

import options.model.RelativeDimension

class RelativeScale(relativeDimension: RelativeDimension) :
    Option<RelativeDimension>("-vf scale=", relativeDimension)
