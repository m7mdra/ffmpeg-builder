class Equalizer(
    private val equalizerSettings: List<EqualizerSetting>
) : AudioFilter {
    override fun build(): String {
        // Combine equalizer settings into a comma-separated string
        val settingsString = equalizerSettings.map{ it.value() }.joinToString(":")
        
        // Build the FFmpeg filter string
        return "equalizer=$settingsString"
    }
}