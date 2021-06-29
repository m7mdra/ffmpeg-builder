package filter

class VerticalFlip : VideoFilter<Unit>("vflip", Unit) {
    override fun build(): String {
        return  name
    }
}