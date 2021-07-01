package option

class FrameRate(private val rate: Int) : Option {
    override fun build(): String {
        return "-r $rate"
    }
}
