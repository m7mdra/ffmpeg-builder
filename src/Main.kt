import options.*
import options.model.*
import java.io.File

class Main {

}

fun main(args: Array<String>) {

    val ffmpeg: FFMPEGBuilder = ffmpeg {
        videoOption(Overlay(OverlayInput(File("overlay.jpg"), RelativePosition.TopRightCorner)))

        input("file.mp4")
        output("file.mvi")
        videoOption(Resize(110 x 300))
        videoOption(ResizeToPredefined(FrameSize.qqvga))
        videoOption(FrameRate(10))
        videoOption(BitRate(10))
        videoOption(FileSize(10 * 1024 * 1024))
        videoOption(RelativeScale(RelativeDimension("iw/2", "ih/2")))
        videoOption(Scale(200 x 200))
    }
    val build = ffmpeg.build()
    print(build)
}


class FFMPEGBuilder {
    private var input: String? = null
    private var output: String? = null
    private val options = mutableListOf<Option<*>>()
    fun input(path: String) {
        this.input = path
    }

    fun output(path: String) {
        this.output = path

    }

    fun input(input: File) {

    }

    fun output(input: File) {

    }

    fun videoOption(option: Option<*>) {
        options.add(option)
    }


    fun build(): String {
        val stringBuilder = StringBuilder("ffmpeg -i $input")
        options.forEach {
            when (it) {
                is Overlay -> {
                    stringBuilder.append(" -i ${it.input.path} ${it.key} ${it.value.position.value}")
                }
                is FrameRate -> stringBuilder.append(" ${it.key} ${it.value}")

            }
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



