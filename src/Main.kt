import java.io.File

class Main {

}

fun main(args: Array<String>) {

    val ffmpeg: FFMPEGBuilder = ffmpeg {

        input("file.mp4")
        output("file.mvi")
        videoOption(Resize(110 x 300))
        videoOption(ResizeToPredefined(FrameSize.qqvga))
        videoOption(FrameRate(10))
        videoOption(BitRate(10))
        FileSize(10 * 1024 * 1024)

        RelativeScale(RelativeDimension("iw/2", "ih/2"))
        Scale(200 x 200)
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

        return "ffmpeg -i $input $output"
    }

}

class FrameRate(rate: Int) : Option<Int>(key = "-r", rate) {}
class BitRate(rate: Int) : Option<Int>(key = "-b:v", rate) {}
class FileSize(size: Int) : Option<Int>(key = "-fs", size) {}
class ResizeToPredefined(size: FrameSize) : Option<FrameSize>(key = "-s", size)
class Resize(size: Dimension) : Option<Dimension>(key = "-s", size)


class Scale(dimension: Dimension) : Option<Dimension>("-s", dimension)
class RelativeScale(relativeDimension: RelativeDimension) :
    Option<RelativeDimension>("-vf scale=", relativeDimension)

enum class FrameSize(size: Dimension) {

    sqcif(128 x 96),
    qqvga(160 x 120)
    //TODO list other frameSizes
}

abstract class Option<T>(val key: String, val t: T)

fun ffmpeg(builder: FFMPEGBuilder.() -> Unit): FFMPEGBuilder {
    val ffmpegBuilder = FFMPEGBuilder()
    ffmpegBuilder.builder()
    return ffmpegBuilder
}

class Dimension(val width: Int, val height: Int)
class RelativeDimension(val widthWithModifier: String, val heightWithModifier: String)

infix fun Int.x(height: Int): Dimension {
    return Dimension(this, height)
}