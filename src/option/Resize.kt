package option

import option.model.Dimension

class Resize(size: Dimension) : Option<Dimension>(key = "-s", size)
