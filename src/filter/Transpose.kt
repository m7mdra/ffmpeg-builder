package filter

import filter.model.Degree

class Transpose(val input: Degree) : VideoFilter<Degree>("transpose", input)
