import builder.FFMPEGBuilder
import builder.ffmpeg
import builder.plus
import filter.*
import filter.model.Degree
import filter.model.DrawTextInput
import option.*
import option.model.FrameSize
import option.model.RelativeDimension
import option.model.TextRelativePosition
import option.model.x
import java.io.File


fun main(args: Array<String>) {

    val ffmpeg: FFMPEGBuilder = ffmpeg {

        input("input.mp4")
        output("output.mp4")
        overwriteOutput()
/*        videoFilter(EQ())
        videoFilter(CustomFilter())
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
//        videoOption(ResizeToPredefined(FrameSize.qqvga))
        videoOption(FrameRate(60))
        videoOption(BitRate(10.MB))
//        videoOption(FileSize(10 * 1024 * 1024))
//        videoOption(Scale(200 x 200))
    }
    val build = ffmpeg.build()
    print(build)

}




