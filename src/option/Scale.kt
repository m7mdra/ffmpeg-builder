package option

import option.model.Dimension

class Scale(private val dimension: Dimension) : Option {
    override fun build(): String {
        return "-s ${dimension.width}x${dimension.height}"

    }
}
