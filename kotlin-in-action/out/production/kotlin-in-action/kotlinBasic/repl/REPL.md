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



