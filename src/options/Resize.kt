package options

import options.model.Dimension

class Resize(size: Dimension) : Option<Dimension>(key = "-s", size)
