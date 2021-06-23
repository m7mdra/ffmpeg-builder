class Color(name: String, private val hex: Int, var opacity: Double = 1.0) {
    companion object {
        val black = Color(name = "black", hex = 0x000000)
    }

    fun hexValue(): Double {
        return opacity+ hex
    }
}

fun Color.withOpacity(value: Double): Color {
    opacity = value
    return this
}