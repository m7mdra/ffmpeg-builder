package videoFilter

class CustomVideoFilter(val value:Any) : VideoFilter {
    override fun build(): String {
        return  "filterName=$value"
    }
}