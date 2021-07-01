import audioFilter.Volume
import builder.FFMPEGBuilder
import builder.ffmpeg
import option.*
import videoFilter.NoiseReduction


fun main(args: Array<String>) {

    val ffmpeg: FFMPEGBuilder = ffmpeg {

        input("input.mp4")
        output("output.mp4")
        overwriteOutput()

        videoOption(FrameRate(30))
        videoOption(BitRate(1.5.MB))
        filter(Volume((-10).dB))
        filter(NoiseReduction())

    }
    val build = ffmpeg.build()
    print(build)

}




