package builder

import filter.VideoFilter
import option.*
import java.io.File

class FFMPEGBuilder {
    private var input: String? = null
    private var output: String? = null
    private val options = mutableListOf<Option<*>>()
    private var overWriteOutput = false
    private var abortIfOutputExists = false
    private val videoFilters = mutableListOf<VideoFilter>()

    fun input(path: String) {
        this.input = path
    }

    fun output(path: String) {
        this.output = path
    }

    fun overwriteOutput() {
        overWriteOutput = true
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

    fun videoFilter(filter: VideoFilter) {
        videoFilters.add(filter)
    }

    fun videoOption(option: Option<*>) {
        options.add(option)
    }


    fun build(): String {
        val stringBuilder = StringBuilder("/usr/local/bin/ffmpeg -i $input")
        options.forEach {
            when (it) {
                is Overlay -> {
                    stringBuilder.append(" -i ${it.input.path} ${it.key}${it.value.position.value}")
                }
                is FrameRate -> stringBuilder.append(" ${it.key} ${it.value}")
                is BitRate -> stringBuilder.append(" ${it.key} ${it.value}")
                is Resize -> stringBuilder.append(" ${it.key} ${it.value.width}x${it.value.height}")
                is ResizeToPredefined -> stringBuilder.append(" ${it.key} ${it.value.name}")
                is Scale -> stringBuilder.append(" ${it.key} ${it.value.width}x${it.value.height}")
                is FileSize -> stringBuilder.append(" ${it.key} ${it.value}")

            }
        }
        if (videoFilters.isNotEmpty()) {
            val buildFilters = videoFilters.map { it.build() }
            stringBuilder.append(" -vf \"")



            if (buildFilters.size < 1) {
                stringBuilder.append(buildFilters.joinToString { "," })
            } else {
                stringBuilder.append(buildFilters.joinToString())
            }
            stringBuilder.append("\"")
        }
        if (overWriteOutput) {
            stringBuilder.append(" -y ")
        }
        stringBuilder.append(" $output")

        return stringBuilder.toString()
    }

}
