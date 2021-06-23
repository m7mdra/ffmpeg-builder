package option

import option.model.FrameSize

class ResizeToPredefined(size: FrameSize) : Option<FrameSize>(key = "-s", size)
