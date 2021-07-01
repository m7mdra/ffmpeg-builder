package option

import option.model.FrameSize

class ResizeToPredefined(private val size: FrameSize) : Option{
    override fun build(): String {
        return  "-s ${size.name}"
    }

}
