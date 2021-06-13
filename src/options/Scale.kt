package options

import options.model.Dimension

class Scale(dimension: Dimension) : Option<Dimension>("-s", dimension)
