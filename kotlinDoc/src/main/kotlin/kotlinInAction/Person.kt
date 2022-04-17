package kotlinInAction

data class Person(
    val name: String,
    val age: Int? = null
)

fun main(args: Array<String>) {

    val persons = listOf(
        Person("영희", age = 44),
        Person("철수", age = 29)
    )

    val oldset = persons.maxByOrNull {it.age ?: 0}

    println("나이가 제일 많은 사람: $oldset")
}
