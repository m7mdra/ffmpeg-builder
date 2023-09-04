data class EqualizerSetting(
    val frequency: Double, // Frequency in Hertz (Hz)
    val gain: Double       // Gain in decibels (dB)
){
    fun value(): String = "f:$frequency:g:$gain"
}
