package filter

class NoiseReduction : VideoFilter<Unit>("hqdn3d", Unit) {
    override fun build(): String {
        return name
    }
}