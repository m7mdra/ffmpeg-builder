import audioFilter.Volume
import builder.FFMPEGBuilder
import builder.ffmpeg
import option.*
import option.model.FrameSize
import option.model.RelativeDimension
import videoFilter.*
import videoFilter.model.DrawBoxInput
import videoFilter.model.DrawTextInput
import videoFilter.model.InterlaceType
import java.awt.Color
import java.io.File


fun main(args: Array<String>) {
    val builder = ffmpeg {
        input("input.mp4")
        output("output.mp4")
        filter(RelativeScale(RelativeDimension.divideBy(2.0,2.0)))
    }


    println(builder.build())
}

