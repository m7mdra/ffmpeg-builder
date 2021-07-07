package videoFilter

import videoFilter.model.Degree

class Transpose(val input: Degree) : VideoFilter {
    override fun build(): String {
        return "transpose=${input.value}"
    }
}