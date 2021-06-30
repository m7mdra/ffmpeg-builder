package filter

class BoxBlur(val radius:Double,val power:Double) :VideoFilter<Unit>("boxblur",Unit) {
    override fun build(): String {
        return "$name=$radius:$power"
    }
}