package videoFilter.model

enum class Degree(val value: Int) {
    CounterClockWiseVertically(0),
    CloseWise(1),
    CounterCloseWise(2),
    CloseWiseVertically(3)
}