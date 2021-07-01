package filter

class CustomFilter : VideoFilter {
    override fun build(): String {
        return  "filterName=value"
    }
}