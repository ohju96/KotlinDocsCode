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