import filter.*
import option.*
import java.io.File

fun main(args: Array<String>) {

    val ffmpeg: FFMPEGBuilder = ffmpeg {

        input("input.mp4")
        output("output.mp4")
        overwriteOutput()
        videoFilter(VerticalFlip())
        videoFilter(NoiseReduction())
//        videoOption(Overlay(OverlayInput(File("overlay.png"), RelativePosition.TopRightCorner)))
//        videoOption(FrameRate(60))
//        videoOption(BitRate(100000))
//        videoOption(RelativeScale(RelativeDimension("iw/2", "ih/2")))
//        videoOption(Scale(200 x 200))

//         videoOption(RelativeScale(RelativeDimension("iw/2", "ih/2")))
//        videoFilter(
//            DrawText(
//                DrawTextInput(
//                    "Site 14564545641564",
//                    File("font.otf"),
//                    100,
//                    "#000",
//                    "#fff",
//                    TextRelativePosition.Center,
//                    5
//                )
//            )
//        )
//        videoFilter(RelativeScale(RelativeDimension("iw/2", "ih/2")))
//        videoFilter(Transpose(Degree.CounterCloseWise))
/*        videoOption(ResizeToPredefined(FrameSize.qqvga))
        videoOption(FrameRate(10))
        videoOption(BitRate(10))
        videoOption(FileSize(10 * 1024 * 1024))
        videoOption(Scale(200 x 200))
        */
    }
    val build = ffmpeg.build()
    println(build)
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
            val videoFilterBuild = mutableListOf<String>()
            stringBuilder.append(" -vf \"")

            videoFilters.forEach { filter ->
                val filterName = filter.name
                if (filter is DrawText) {
                    val textInput = filter.input
                    videoFilterBuild.add(
                        "$filterName=fontfile=${textInput.fontPath}:" +
                                "text='${textInput.text}':fontcolor=white:fontsize=${textInput.fontSize}:box=1:boxcolor=black@0.5:" +
                                "boxborderw=5:${textInput.position.value}"
                    )
                }
                if (filter is RelativeScale) {
                    videoFilterBuild.add("$filterName=${filter.input.widthWithModifier}:${filter.input.heightWithModifier}")
                }
                if (filter is Transpose) {
                    videoFilterBuild.add("$filterName=${filter.input.value}")
                }
                if (filter is VerticalFlip) {
                    videoFilterBuild.add(filterName)
                }
                if(filter is NoiseReduction){
                    videoFilterBuild.add(filterName)
                }
            }
            println(videoFilterBuild)
            if (videoFilterBuild.size < 1) {
                stringBuilder.append(videoFilterBuild.joinToString { "," })
            } else {
                stringBuilder.append(videoFilterBuild.joinToString())
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



