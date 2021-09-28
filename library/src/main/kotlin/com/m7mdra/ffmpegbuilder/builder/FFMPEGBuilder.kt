package builder

import audioFilter.AudioFilter
import com.m7mdra.ffmpegbuilder.option.Option
import com.m7mdra.ffmpegbuilder.videoFilters.VideoFilter
import java.io.File

class FFMPEGBuilder {
    private var input: String? = null
    private var output: String? = null
    private val options = mutableListOf<Option>()
    private var overWriteOutput = false
    private var abortIfOutputExists = false
    private var addPrefixFfmpeg = false
    private val videoFilters = mutableListOf<VideoFilter>()
    private val audioFilters = mutableListOf<AudioFilter>()

    fun input(path: String) {
        this.input = path
    }

    fun output(path: String) {
        this.output = path
    }

    fun overwriteOutput() {
        overWriteOutput = true
    }
    fun prefixFfmpeg(){
        addPrefixFfmpeg = true
    }

    fun abortIfOutputExists() {
        abortIfOutputExists = true
    }

    fun input(input: File) {
        this.input = input.path
    }

    fun output(output: File) {
        this.output = output.path

    }

    fun filter(filter: VideoFilter) {
        videoFilters.add(filter)
    }
    fun filter(filter: AudioFilter) {
        audioFilters.add(filter)
    }

    fun option(option: Option) {
        options.add(option)
    }


    fun build(): String {
        val stringBuilder = StringBuilder()
        if(addPrefixFfmpeg){
            stringBuilder.append("ffmpeg")
        }
        stringBuilder.append("-i $input")
        val optionList = options.map { it.build() }
        stringBuilder.append(optionList.joinToString (separator = " ",prefix = " "))
        if (videoFilters.isNotEmpty()) {
            val buildFilters = videoFilters.map { it.build() }
            stringBuilder.append(" -vf \"")
            stringBuilder.append(buildFilters.joinToString())
            stringBuilder.append("\"")
        }
        if(audioFilters.isNotEmpty()){
            val buildFilters = audioFilters.map { it.build() }
            stringBuilder.append(" -af \"")
            stringBuilder.append(buildFilters.joinToString())
            stringBuilder.append("\"")
        }
        if (overWriteOutput) {
            stringBuilder.append(" -y ")
        }
        stringBuilder.append(" $output")
        return stringBuilder.toString()
    }

}
