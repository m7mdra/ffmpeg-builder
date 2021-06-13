package options.model

class Dimension(val width: Int, val height: Int)

infix fun Int.x(height: Int): Dimension {
    return Dimension(this, height)
}