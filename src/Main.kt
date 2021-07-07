import audioFilter.Volume
import builder.FFMPEGBuilder
import builder.ffmpeg
import option.*
import videoFilter.DrawText
import videoFilter.NoiseReduction
import videoFilter.model.DrawTextInput
import java.awt.Color


fun main(args: Array<String>) {

    val ffmpeg: FFMPEGBuilder = ffmpeg {

        input("input.mp4")
        output("output.mp4")
        overwriteOutput()
        filter(DrawText(DrawTextInput("Hello bros", "font.otf", 100,showBox = true)))

    }
    val build = ffmpeg.build()
    println(build)
}


fun changeAlpha(origColor: Int, userInputedAlpha: Int): String {

    return (origColor and 0x00ffffff or (userInputedAlpha shl 24)).toUInt().toString(16)
}
