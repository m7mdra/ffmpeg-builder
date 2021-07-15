
# ffmpeg-builder
A humble interface to generate ffmpeg commands with options and filters and more built kotlin language with DSL support
> Note: this is under development but it's useable to some extent
# Usage

### The boring way
```kotlin
val builder = FFMPEGBuilder()
builder.input("input.mp4")
// OR
// builder.input(File("input.mp4"))
builder.output("output.mp4")
//builder.output(File("output.mp4"))
// -b 10MB
builder.option(BitRate(10.MB))
// -s hd720
builder.option(ResizeToPredefined(FrameSize.hd720))
// -vf "vflip"
builder.filter(VerticalFlip())
// -vf "smartblur=radius:strength:threshold"
builder.filter(SmartBlur(radius = 5.0,strength = 4.0,threshold = 1.0))
// -vf "hqdn3d"
builder.filter(NoiseReduction())
```
### DSL

```kotlin
val builder = ffmpeg {
    input("input.mp4")
    // OR
    // input(File("input.mp4"))
    output("output.mp4")
    //output(File("output.mp4"))
    // -b 10MB
    option(BitRate(10.MB))
    // -s hd720
    option(ResizeToPredefined(FrameSize.hd720))
    // -vf "vflip"
    filter(VerticalFlip())
    // -vf "smartblur=radius:strength:threshold"
    filter(SmartBlur(radius = 5.0, strength = 4.0, threshold = 1.0))
    // -vf "hqdn3d"
    filter(NoiseReduction())
}
```

then call
```kotlin
builder.build()
```
to generate the command and thats it.

The above code generates the following:

```bash
/usr/local/bin/ffmpeg -i input.mp4 -b 10MB -s hd720 -vf "vflip, smartblur=5.0:4.0:1.0, hqdn3d" output.mp4
```

For now the library supports only a subset of options,video filter, audio filters.

### Supported options:

| name | option |
|--|--|
| Bitrate | `-b` |
| FileSize | `-fs` |
| Framerate | `-r` |
| Resize/scale | `-s` |
| Bitrate | `-b` |

### Supported Video filters:
| name | filter |
|--|--|
| BoxBlur | `boxblur` |
| DrawBox | `drawbox` |
| DrawText | `drawtext` |
| EQ | `eq` |
| HorizontalFlip | `hflip` |
| VerticalFlip | `vflip` |
| Interlace | `setfield` |
| NoiseReduction | `hqdn3d` |
|RelativeScale| `scale`|
|SmartBlur| `smartblur`|
|Transpose| `transpose` | 

### Supported audio filters:

| name | filter |
|--|--|
| Volume | `volume` |


### Add New Option, VideoFilter or AudioFilter?
Simply implement the one of theses 'Option','VideoFilter','AudioFilter' interfaces depending on your usecase

Custom Video Filter
``` kotlin
class CustomVideoFilter(val value:Any) : VideoFilter {
    override fun build(): String {
        return  "filterName=$value"
    }
}
```
Custom Audio Filter
``` kotlin
class CustomAudioFilter(val value:Any) : AudioFilter {
    override fun build(): String {
        return  "filterName=$value"
    }
}
```
Custom Option
``` kotlin
class CustomOption(val value:Any) : Option {
    override fun build(): String {
        return  "filterName=$value"
    }
}
```
they look identical but how they handled differs in generating the commands.

And thats it.
### TODO

 - Support more Options
 - Support more video/audio filters
 - Support filter-complex filters
 - Add example project
 - Testing
 - Distribute binaries


PR are welcome. 

