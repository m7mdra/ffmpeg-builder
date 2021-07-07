package videoFilter


class EQ(val contrast: Int = 1, val brightness: Double = 0.0, val saturation: Double = 1.0, val gamma: Double = 1.0) :
    VideoFilter {
    override fun build(): String {
        return "eq=contrast=$contrast:brightness=$brightness:saturation=$saturation:gamma=$gamma"
    }
}