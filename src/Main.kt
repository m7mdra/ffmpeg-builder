import builder.FFMPEGBuilder
import builder.ffmpeg
import filter.BoxBlur
import filter.SmartBlur


fun main(args: Array<String>) {

    val ffmpeg: FFMPEGBuilder = ffmpeg {

        input("input.mp4")
        output("output.mp4")
        overwriteOutput()
        videoFilter(BoxBlur(5.0,0.8))
    /*
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
/*        videoOption(ResizeToPredefined(FrameSize.qqvga))
        videoOption(FrameRate(10))
        videoOption(BitRate(10))
        videoOption(FileSize(10 * 1024 * 1024))
        videoOption(Scale(200 x 200))
        */
    }
    val build = ffmpeg.build()


}




