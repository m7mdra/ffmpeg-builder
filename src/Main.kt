import builder.ffmpeg
import option.*
import option.model.RelativeDimension
import videoFilter.*


fun main(args: Array<String>) {
    val builder = ffmpeg {
        input("input.mp4")
        output("output.mp4")
        option(Bitrate(10.MB))
        filter(RelativeScale(RelativeDimension.divideBy(2.0,2.0)))
    }


    println(builder.build())
}

