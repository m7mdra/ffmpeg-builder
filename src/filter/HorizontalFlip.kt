package filter

class HorizontalFlip : VideoFilter<Unit>("hflip", Unit) {
    override fun build(): String {
        return name
    }
}