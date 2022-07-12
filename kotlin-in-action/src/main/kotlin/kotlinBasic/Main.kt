import kotlinBasic.Color
import kotlinBasic.createRandomRectangle
import kotlinBasic.Color.*

fun main(args: Array<String>) {
    println("Hello, World!")
    println(createRandomRectangle().isSquare)
    println(Color.BLUE.rgb())
    println(getMnemonic(Color.YELLOW))
    println(getMnemonic(Color.BLUE))
    println(getMnemonic(Color.RED))
}

fun getMnemonic(color: Color) = when (color) {
    BLUE -> "파랑"
    GREEN -> "초록"
    INDIGO -> 3
    ORANGE -> 2
    VIOLET -> "Violet"
    YELLOW, Color.RED -> 1
}