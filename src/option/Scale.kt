package option

import option.model.Dimension

class Scale(dimension: Dimension) : Option<Dimension>("-s", dimension)
