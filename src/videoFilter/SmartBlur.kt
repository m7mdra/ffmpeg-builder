package videoFilter

class SmartBlur(val radius: Double, val strength: Double, val threshold: Double) :
    VideoFilter {
    override fun build(): String {
        return "smartblur=$radius:$strength:$threshold"
    }
}