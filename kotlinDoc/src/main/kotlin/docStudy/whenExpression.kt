package docStudy

// when은 표현식이라고 한다.
fun describe(obj: Any): String =
    when (obj) {
        "문자를 알맞게 입력하면?" -> "정상적으로 출력이 된다.."
        else -> "Unknown"
    }

fun main() {
    println(describe("문자를 알맞게 입력하면?"))
    println(describe("다른 문자를 입력하면?"))
}