import filter.*
import filter.model.Degree
import filter.model.DrawTextInput
import option.*
import option.model.RelativeDimension
import option.model.TextRelativePosition
import option.model.x
import java.io.File

fun main(args: Array<String>) {

    val ffmpeg: FFMPEGBuilder = ffmpeg {

        input("input.mp4")
        output("output.mp4")
/*        overwriteOutput()
        this + VerticalFlip()
        this + HorizontalFlip()
        videoFilter(NoiseReduction())


        videoFilter(
            DrawText(
                DrawTextInput(
                    "Site 14564545641564",
                    File("font.otf"),
                    100,
                    "#000",
                    "#fff",
                    TextRelativePosition.Center,
                    5
                )
            )
        )
        videoFilter(RelativeScale(RelativeDimension("iw/2", "ih/2")))
        videoFilter(Transpose(Degree.CounterCloseWise))*/
/*        videoOption(ResizeToPredefined(FrameSize.qqvga))
        videoOption(FrameRate(10))
        videoOption(BitRate(10))
        videoOption(FileSize(10 * 1024 * 1024))
        videoOption(Scale(200 x 200))
        */
    }
    val build = ffmpeg.build()
    println(build)
    println(100.k)
    println(100.MB)
    println(100.GB)
    println(100.T)

}


class FFMPEGBuilder {
    private var input: String? = null
    private var output: String? = null
    private val options = mutableListOf<Option<*>>()
    private var overWriteOutput = false
    private var abortIfOutputExists = false
    private val videoFilters = mutableListOf<VideoFilter<*>>()

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

    }

    fun output(input: File) {

    }

    fun videoFilter(filter: VideoFilter<*>) {
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


fun ffmpeg(builder: FFMPEGBuilder.() -> Unit): FFMPEGBuilder {
    val ffmpegBuilder = FFMPEGBuilder()
    ffmpegBuilder.builder()
    return ffmpegBuilder
}

operator fun FFMPEGBuilder.plus(filter: VideoFilter<*>) {
    videoFilter(filter)
}

operator fun FFMPEGBuilder.plus(option: Option<*>) {
    videoOption(option)
}

var Number.k: String
    get() {
        return "${this}k"
    }
    set(value) {
        this.k = value
    }
var Number.MB: String
    get() {
        return "${this}k"
    }
    set(value) {
        this.MB = value
    }
var Number.GB: String
    get() {
        return "${this}GB"
    }
    set(value) {
        this.GB = value
    }
var Number.T: String
    get() {
        return "${this}T"
    }
    set(value) {
        this.T = value
    }
