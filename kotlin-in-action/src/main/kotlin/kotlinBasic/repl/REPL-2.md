`22.07.14`

### while과 for
- 코틀린 특성 중 자바와 가장 비슷한 것이 이터레이션이다.
- while과 do-while이다.
- 특별할 게 없다.

### 범위와 수열
- 코틀린은 자바의 for 루프에 해당하는 요소가 없다. 대신 범위(range)를 사용한다.`val onToTen = 1..10`이런식이다. 
- 이런 식으로 범위에 속한 값을 일정한 순서로 이터레이션 하는 경우를 수열(progression)이라고 한다.

```kotlin
fun fizzBuzz(i: Int) = when {
        i % 15 == 0 -> "FizzBuzz"
        i % 3 == 0 -> "Fizz"
        i % 5 == 0 -> "Buzz"
        else -> "$i"
    }
```
- 간단한 게임이다.

```kotlin
    for(i in 1..100) {
        println(KotlinWhile().fizzBuzz(i))
    }

    for(i in 100 downTo 1 step 2) {
        println(KotlinWhile().fizzBuzz(i))
    }
```
- 위에 for문은 1부터 100까지 돈다.
- 아래 for문은 100부터 세고 짝수만 체크한다.
- `100 downTo 1`은 역방향 수열을 만든다.
- `step 2`는 증가 값의 절댓값이 2로 바뀌게 된다.

### 맵에 대한 이터레이션, for
- for는 자바와 비슷하게 작동한다. 
```kotlin
val binaryReps = TreeMap<Char, String>()

    for (c in 'A'..'F') {
        val binary = Integer.toBinaryString(c.toInt())
        binaryReps[c] = binary
    }

    for ((letter, binary) in binaryReps) {
        println("$letter = $binary")
    }
```
- Key에 대해 정렬하기 위해 TreeMap을 사용한다.
- A부터 F까지 문자의 범위를 사용해 이터레이션한다.
- 아스키 코드를 2진 코드로 바꾼다.
- C를 키로 c의 2진 표현을 맵에 넣는다.
- 맵에 대해 이터레이션한다. 맵의 키와 값을 두 변수에 각각 대입한다.
- `..`연산자를 숫자 뿐만 아니라 문자 또한 사용 가능하다. 
- get과 put을 사용하는 대신 `map[key]`나 `map[key] = value`를 사용해 값을 가져오고 설정할 수 있다.
- `binaryReps[c] = binary`는 자바의 `binaryReps.put(c,binary)`코드와 같다.

```kotlin
    val list = arrayListOf("10", "11", "1001")
    for ((index, element) in list.withIndex()) {
        println("$index: $element")
    }
```
- 인덱스와 함께 컬렉션을 이터레이션한다.
- 인덱스를 저장하기 위한 변수를 별도로 선언하고 루프에서 매번 그 변수를 증가 시킬 필요가 없어진다.

### in으로 컬렉션이나 범위의 원소 검사
 - `in`으로 어떤 값이 범위에 속하는지 검사할 수 있고 `!in`으로 속하지 않는지 검사할 수 있다. 
```kotlin
    fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'
    fun isNotDigit(c: Char) = c !in '0'..'9'
```
- 이때, `c in 'a'.. 'z'`는 `'a' <= c && c <= 'z'`로 변환이 된다.
- `in`과 `!in` 연산자는 when 식에서 사용해도 된다.

```kotlin
fun recognize(c: Char) = when (c) {
        in '0'..'9' -> "It's a digit!"
        in 'a'..'z', in 'A'..'Z' -> "It's a letter!"
        else -> "I don't know.."
    }
```
- when에서 in을 사용한 예제이다. 
- 범위는 문자에만 국한되지 않는다.
- `"Kotlin" in "Java".."Scala"`와 같이 in 검사에서 문자열을 알파뱃 순서로 비교한다.
  - `"Kotlin" in setOf("Java", "Scala")`처럼 컬렉션도 마찬가지로 in 연산자 사용이 가능하다.