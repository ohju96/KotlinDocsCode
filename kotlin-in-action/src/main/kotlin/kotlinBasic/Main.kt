import kotlinBasic.`when`.Color
import kotlinBasic.`when`.Color.*
import kotlinBasic.`when`.Expr
import kotlinBasic.`when`.Expr.*

fun main(args: Array<String>) {
//    println("Hello, World!")
//    println(createRandomRectangle().isSquare)
//    println(Color.BLUE.rgb())
//    println(getMnemonic(Color.YELLOW))
//    println(getMnemonic(Color.BLUE))
//    println(getMnemonic(Color.RED))

//    println(mix(BLUE, YELLOW))
//    println(mix(BLUE, RED))

//    println(mixOptimized(RED, YELLOW))
//    println(mixOptimized(YELLOW, RED))
//    println(mixOptimized(BLUE, RED))

    println(evalWithLogging(Sum(Sum(Num(1), Num(2)), Num(4))))
}

//fun eval(e: Expr): Int {
//    if (e is Num) {
//        val n = e as Num
//        return n.value
//    }
//
//    if (e is Sum) {
//        return eval(e.right) + eval(e.left)
//    }
//
//    throw java.lang.IllegalArgumentException("Unknown expression")
//}

//fun eval(e: Expr): Int =
//    if (e is Num) {
//        e.value
//    } else if (e is Sum) {
//        eval(e.right) + eval(e.left)
//    } else {
//        throw java.lang.IllegalArgumentException("Unknown expression")
//    }

//fun eval(e: Expr): Int =
//    when (e) {
//        is Num -> e.value
//        is Sum -> eval(e.right) + eval(e.left)
//    }

fun evalWithLogging(e: Expr) : Int =
    when (e) {

        is Num -> {
            println("num: ${e.value}")
            e.value
        }

        is Sum -> {
            val left = evalWithLogging(e.left)
            val right = evalWithLogging(e.right)
            println("sum: $left + $right")
            left + right
        }

        else -> throw java.lang.IllegalArgumentException("Unknown expression")
    }

fun getMnemonic(color: Color) = when (color) {
    BLUE -> "파랑"
    GREEN -> "초록"
    INDIGO -> 3
    ORANGE -> 2
    VIOLET -> "Violet"
    YELLOW, Color.RED -> 1
}

fun mix(c1: Color, c2: Color) =
    when (setOf(c1, c2)) {
        setOf(RED, YELLOW) -> ORANGE
        setOf(YELLOW, BLUE) -> GREEN
        setOf(BLUE, VIOLET) -> INDIGO
        else -> throw Exception("Dirty color")
    }

fun mixOptimized(c1: Color, c2: Color) =
    when {
        (c1 == RED && c2 == YELLOW) || (c1 == YELLOW && c2 == RED)
        -> ORANGE
        else -> throw Exception("Dirty color")
    }