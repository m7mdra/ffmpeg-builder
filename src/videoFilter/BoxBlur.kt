package videoFilter

class BoxBlur(val radius:Double,val power:Double) :VideoFilter {
    override fun build(): String {
        return "boxblur=$radius:$power"
    }
}