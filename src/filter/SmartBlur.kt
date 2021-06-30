package filter

class SmartBlur(val radius: Double, val strength: Double, val threshold: Double) :
    VideoFilter<Unit>("smartblur", Unit) {
    override fun build(): String {
        return "$name =$radius:$strength:$threshold"
    }
}