package videoFilter

class Scale(val width: Double, val height: Double) : VideoFilter {
    override fun build(): String {
        return "scale=$width:$height"
    }
}