### Hello World
```kotlin
println("Hello, World")
```
- Hello World 출력

### 함수
```kotlin
fun max(a:Int, b:Int): Int {
     return if (a>b) a else b
 }
 
 println(max(1,2))
```
- `max`는 함수 이름
- `(a:Int, b:Int)`는 파라미터 목록
- `: Int {}`는 반환 타입
- `{}`안에 내용은 함수 본문이다.

### 식이 본문인 함수
```kotlin
fun max(a: Int, b: Int) = if (a>b) a else b
println(max(1,2))
```
- 위 코드와 똑같이 동작한다.
- Kotlin에서 if는 문이 아니라 식이다.
- 이때, 반환 타입을 생략할 수 있는 이유는 타입 추론을 지원하기 때문이다.

### 변수
```kotlin
val name = "오주현"
val age = 27
val age: Int = 27
```
- Kotlin에서 타입을 생략해도 타입 추론으로 해결해준다.
- 타입 표기를 원한다면 해도 상관은 없다.

### 변경 가능한 변수, 불가능한 변수
- `val`은 변경 불가능한 참조를 저장하는 변수이다. Java의 final 변수에 해당한다.
- `var`은 변경 가능한 참조다. Java의 일반 변수에 해당한다.

### 문자열 템플릿
```kotlin
val name = "kotlin"
 println("Hello, $name!")
```
- 문자열 리터럴의 필요한 곳에 변수를 넣고 앞에 `$`를 붙여주면 된다.

---

`22.07.12`

### 프로퍼티
- 클래스 개념의 목적은 데이터 캡슐화에 있다.
  - 데이터 캡슐화를 통해 캡슐화한 데이터를 다루는 코드를 한 주체에 가두는 것이다.
- 자바에서는 데이터를 필드에 저장하고 자신을 사용하는 클라이언트가 그 데이터에 접근하는 통로를 접근자 메서드로 통제한다.
- 필드를 읽기 위해 getter를 제공하고 필드 변경 허용을 하는 경우 setter를 제공한다.
- 자바에서는 이런 필드와 접근자를 묶어 프로퍼티(Property)라고 부른다.
- 코틀린의 프로퍼티는 자바의 필드의 접근자 메서드를 완전 대신한다.
- `val`이나 `var`를 사용하는데 `val`은 읽기 전용, `var`로 선언한 프로퍼티는 변경이 가능하다.

```kotlin
class Person {
    val name: String,
    var isMarried: Boolean
}
```

### enum과 when
- 코틀린의 when은 자바의 switch를 대신할 수 있으면서 더 강력하다. 그리고 앞으로 더 자주 사용할 요소이다.
- when에 대해 설명하는 과정에서 enum을 선언하는 방법과 smart cast에 대해서도 살펴본다.

### enum 클래스 정의
```kotlin
package kotlinBasic

enum class Color {
    RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
}
```
- enum은 자바 선언보다 코틀린 선언에 더 많은 키워드를 써야 하는 흔치 않은 예이다.
- 코틀린에서는 enum class, 자바에서는 enum을 사용한다.
- 코틀린에서 enum은 soft keyword라고 부른다.
- 자바와 마찬가지로 단순 값만 열거하지 않고 enum 클래스 안에 프로퍼티나 메서드를 정의할 수 있다.

프로퍼티와 메서드가 있는 enum 클래스
```kotlin
package kotlinBasic

enum class Color(val r: Int, val g: Int, val b: Int) {

    RED(255, 0, 0), ORANGE(255, 165, 0),
    YELLOW(225, 225, 0), GREEN(0, 255, 0),
    BLUE(0, 0, 255), INDIGO(75, 0, 130),
    VIOLET(238, 130, 238);

    fun rgb() = (r * 256 + g) * 256 + b
}
```
- enum에서도 생성자와 프로퍼티를 선언한다.
- enum 클래스 안에 메서드를 정의해야 하는 경우 반드시 enum 상수 목록과 메서드 정의 사이에 세미콜론을 넣어야 한다.

### when으로 enum 클래스 다루기
- Java의 switch문에 해당하는 Kotlin의 구성 요소는 when이다.
- if와 마찬가지로 when도 문이 아닌 식이다. 때문에 식이 본문인 함수에 when을 바로 사용 가능하다.
```kotlin
fun getMnemonic(color: Color) = when (color) {
    Color.RED -> "빨강"
    Color.BLUE -> "파랑"
    Color.GREEN -> "초록"
    Color.INDIGO -> 3
    Color.ORANGE -> 2
    Color.VIOLET -> "Violet"
    Color.YELLOW -> 1
}
```
- color로 전달된 값과 같은 분기를 찾는다.
- 각 분기 끝에 break를 넣지 않아도 된다.
- 분기 안에서 여러 값을 매치 패턴으로 사용 가능한데 그럴 경우 값 사이에 ,를 넣어 분리한다.
- `Color.YELLOW, Color.RED -> 1`
- 조금 더 코드를 짧게 하기 위해
- `import kotlinBasic.`when`.Color.*` 스타 임포트를 넣어준다. 짧은 이름을 사용하기 위해 enum 상수를 모두 임포트 한 것이다.
```kotlin
fun getMnemonic(color: Color) = when (color) {
    BLUE -> "파랑"
    GREEN -> "초록"
    INDIGO -> 3
    ORANGE -> 2
    VIOLET -> "Violet"
    YELLOW, Color.RED -> 1
}
```
- 확실히 짧아진 코드를 볼 수 있다. 임포트한 enum 상수를 이름만으로 사용한다.
---
`22.07.13`

### when과 임의의 객체 함께 사용
- 분기 조건에 상수만 사용할 수 있는 자바와 달리 코틀린은 임의의 객체를 허용하기 때문에 자바의 switch보다 훨씬 강력하다.
```kotlin
fun mix(c1: Color, c2: Color) =
    when (setOf(c1, c2)) {
        setOf(RED, YELLOW) -> ORANGE
        setOf(YELLOW, BLUE) -> GREEN
        setOf(BLUE, VIOLET) -> INDIGO
        else -> throw Exception("Dirty color")
    }
```
- 인자로 전달 받은 여러 객체를 그 객체들을 포함하는 집합인 `Set`객체로 만드는 `setOf`라는 함수가 있다.
- 집합(set)은 원소가 모여있는 컬렉션으로 각 원소의 순서는 중요하지 않다.
- when은 문이 아닌 식이기 때문에 `=`를 통해 분기 조건에 식을 넣을 수 있게 된다.

### 인자 없는 when 사용
- 위에서 사용한 예시는 비효율적, set 인스턴스를 여러개 생성하기 때문에
```kotlin
fun mixOptimized(c1: Color, c2:Color) =
  when {
    (c1 == RED && c2 == YELLOW) || (c1 == YELLOW && c2 == RED)
    -> ORANGE
    else -> throw Exception("Dirty color")
  }
```
- 대안으로 이렇게 사용할 수 있다.
- 하지만 이 방법 역시 별로다, 추가 객체를 만들지 않지만, 가독성이 떨어진다.
- 스마트 캐스트를 활용하면 좋다.

### 스마트 캐스트 : 타입 검사와 타입 캐스트를 조합
- (1+2) + 4 와 같은 간단한 산술식을 계산하는 함수를 만든다.
- 식을 인코딩 해야 하는데 트리 구조로 저장한다.
```kotlin
fun eval(e: Expr): Int {
    if (e is Num) {
        val n = e as Num
        return n.value
    }

    if (e is Sum) {
        return eval(e.right) + eval(e.left)
    }

    throw java.lang.IllegalArgumentException("Unknown expression")
}
```
- 코틀린에서는 is를 사용해 변수를 검사한다. 자바의 instanceof와 비슷하다.
- 자바는 어떤 변수의 타입을 instanceof로 확인하고 그 타입에 속한 멤버에 접근하기 위해 명시적으로 변수 타입을 캐스팅해야 한다.
- 코틀린은 컴파일러가 캐스팅을 해준다. is로 타입을 검사하고 나면 굳이 변수를 원하는 타입으로 캐스팅하지 않아도 컴파일러가 캐스팅을 수행한다. 
- 이것을 스마트 캐스트,smart cast라고 한다.
- 위에서는 eval 함수에서 e의 타입이 Num인지 Sum인지 검사한다. 
- 스마트 캐스팅을 한 부분은 배경색을 바꿔서 표현해줘서 변환이 자동으로 이루어진 것을 확인할 수 있다. 
- 단, 스마트 캐스트는 is로 변수의 든 값의 타입을 검사한 다음 그 값이 바뀔 수 없는 경우에만 작동한다. 즉, 프로퍼티가 반드시 val이어야 하고 커스텀 접근자를 사용한 것도 안 된다.
- 만약, 원하는 타입으로 명시적으로 타입 캐스팅을 원하면 `as` 키워드를 사용해야 한다. `val n = e as Num`이런 식으로 말이다.

### 리팩토링 : if를 when으로 변경
```kotlin
fun eval(e: Expr): Int =
    if (e is Num) {
        e.value
    } else if (e is Sum) {
        eval(e.right) + eval(e.left)
    } else {
        throw java.lang.IllegalArgumentException("Unknown expression")
    }
```
- if를 사용하면 코드를 더 줄일 수 있다.
- if가 값을 만들기 때문에 따로 3항 연산자 같은 게 없다. 
- 특성을 통해 중괄호를 없애고 if식을 본문으로 활용 가능하다.

### if 중첩 대신 when 사용
```kotlin
fun eval(e: Expr): Int =
    when (e) {
        is Num -> e.value
        is Sum -> eval(e.right) + eval(e.left)
        else -> throw java.lang.IllegalArgumentException("Unknown expression")
    }
```
- if와 마찬가지로 타입을 검사하며 스마트 캐스트가 이루어진다.

### if와 when의 분기에서 블록 사용 
```kotlin
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
```
- 블록의 마지막 식이 블록의 결과는 블록이 값을 만들어야 하는 경우 항상 성립
- 식이 본문인 함수는 블록을 본문으로 가질 수 없고, 블록이 본문인 함수는 내부에 return문이 반드시 있어야 한다. 