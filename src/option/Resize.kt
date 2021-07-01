package option

import option.model.Dimension

class Resize(private val size: Dimension) : Option {
    override fun build(): String {
        return "-s ${size.width}x${size.height}"
    }
}
