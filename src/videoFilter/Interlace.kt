package videoFilter

import videoFilter.model.InterlaceType

class Interlace(private val type: InterlaceType) : VideoFilter {
    override fun build(): String {
        return "setfield=${type.name.toLowerCase()}"
    }
}

