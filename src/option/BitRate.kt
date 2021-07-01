package option

class BitRate : Option {
    private val rate: Any

    constructor(rate: Int) {
        this.rate = rate
    }


    constructor(rate: String) {
        this.rate = rate
    }

    override fun build(): String {
        return "-b $rate"
    }

}
