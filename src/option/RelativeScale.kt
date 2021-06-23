package option

import option.model.RelativeDimension

class RelativeScale(relativeDimension: RelativeDimension) :
    Option<RelativeDimension>("-vf scale=", relativeDimension)
