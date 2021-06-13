package options

import options.model.FrameSize

class ResizeToPredefined(size: FrameSize) : Option<FrameSize>(key = "-s", size)
