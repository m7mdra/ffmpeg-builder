import audioFilter.Volume
import builder.FFMPEGBuilder
import builder.ffmpeg
import option.*
import videoFilter.DrawBox
import videoFilter.DrawText
import videoFilter.Interlace
import videoFilter.NoiseReduction
import videoFilter.model.DrawBoxInput
import videoFilter.model.DrawTextInput
import videoFilter.model.InterlaceType
import java.awt.Color


fun main(args: Array<String>) {

    val ffmpeg: FFMPEGBuilder = ffmpeg {

        input("input.mp4")
        output("output.mp4")
        overwriteOutput()
        filter(DrawBox(DrawBoxInput(height = 200, width = 200)))

    }
    val build = ffmpeg.build()
    println(build)
}


fun changeAlpha(origColor: Int, userInputedAlpha: Int): String {

    return (origColor and 0x00ffffff or (userInputedAlpha shl 24)).toUInt().toString(16)
}
