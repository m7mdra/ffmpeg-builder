package com.m7mdra.ffmpegbuilder.videoFilters

class CustomVideoFilter(val value:Any) : VideoFilter {
    override fun build(): String {
        return  "filterName=$value"
    }
}