import java.io.File

class Main {

}

fun main(args: Array<String>) {

    val ffmpeg: FFMPEGBuilder = ffmpeg {

        input("file.mp4")
        output("file.mvi")
    }
    val build = ffmpeg.build()
    print(build)
}


class FFMPEGBuilder {
    private var input: String? = null
    private var output: String? = null
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

    fun inputOption(key: String, value: String) {

    }

    fun build(): String {

        return "ffmpeg -i $input $output"
    }

}

class FrameRate(rate: Int) : VideoOption<Int>(key = "-r", rate) {}
class BitRate(rate: Int) : VideoOption<Int>(key = "-b:v", rate) {}
class FileSize(rate: Int) : VideoOption<Int>(key = "-b:v", rate) {}
class Resize : VideoOption<Int> {
    constructor(size: FrameSize) : super(key = "-s", size.ordinal)
    constructor(size: Int) : super(key = "-s", size)
}

abstract class ScaleOption<T>(val width: T, val height: T)

class RelativeScaleOption() : ScaleOption<String>("iw", "ih") {


}


class Scale : VideoOption<Any>("-vf scale=") {}

enum class FrameSize(size: Int) {
    sqcif(128 * 96),
    qqvga(160 * 120)
    //TODO list other frameSizes
}

abstract class VideoOption<T>(val key: String, val t: T)

fun ffmpeg(builder: FFMPEGBuilder.() -> Unit): FFMPEGBuilder {
    val ffmpegBuilder = FFMPEGBuilder()
    ffmpegBuilder.builder()
    return ffmpegBuilder
}