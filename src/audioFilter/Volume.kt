package audioFilter

class Volume : AudioFilter {
    private val value: Any

    constructor(value: Double) {
        this.value = value
    }

    constructor(value: String) {
        this.value = value
    }

    override fun build(): String {
        return "volume=$value"
    }
}