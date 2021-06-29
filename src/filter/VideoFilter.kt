package filter

abstract class VideoFilter<T>(val name: String, input: T) {
    abstract fun build(): String
}

