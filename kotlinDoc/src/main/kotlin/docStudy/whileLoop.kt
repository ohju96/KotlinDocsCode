package docStudy

fun main() {
    val items = listOf("사과", "바나나", "키위")
    var index = 0
    println("바구니의 총 개수 = " + items.size)
    while (index < items.size) {
        println("${index}번째 바구니에 들어있는 과일은 ${items[index]}입니다.")
        index++
        // index++를 하지 않으면 사과만 출력하는 무한루프가 된다.
    }
}