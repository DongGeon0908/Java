### 📒Contents

- 에러 `error`
    + 컴퓨터 하드웨어의 오동작 또는 고장으로 인해 응용프로그램 실행 오류가 발생하는 것
    + `JVM` 실행에 문제가 생겼다는 것

- 예외 `exception`
    + 사용자의 잘못된 조작 또는 개발자의 잘못된 코딩으로 인해 발생하는 프로그램 오류
    + 예외는 에러와 다르게 예외처리를 통해 프로그램이 종료되지 않고 정상 실행 상태를 유지시킬 수 있음

- 일반 예외 `Exception`
    + 컴파일러 체크 예외
    + 자바 소스를 컴파일하는 과정에서 예외 처리 코드가 필요한지 검사

- 실행 예외 `Runtime Exception`
    + 컴파일하는 과정에서 예외 처리 코드를 검사하지 않은 예외
    + 개발자의 경험에 의해서 예외 처리 코드를 삽입

- 예외 종류
    + `NullPointerException`
        * 객체 참조가 없는 상태
        * `null` 값을 갖는 참조 변수로 객체 접근 연산자인 `.` 를 사용했을 때 발생
        * 객체가 없는 상태에서 객체를 사용하려 했으니 예외 발생
    + `ArrayIndexOutOfBoundsException`
        + 배열에서 인덱스 범위를 초과하여 사용할 경우 발생
    + `NumberFormatException`
        + 자료형의 변환이 될수없는 문자가 포함되어 있다면 발생
    + `ClassCastException`
        + 타입 변환이 불가능한 클래스를 억지로 타입 변환을 시도할 경우 발생

- 예외 처리 코드
    + 프로그램에서 예외가 발생했을 경우 프로그램의 갑작스러운 종료를 막음
    + 정상 실행을 유지할 수 있도록 처리하는 코드
    + `try-catch-finally` 블록을 이용

- 다중 `catch`
    + 다양한 예외에 대한 처리가 가능

- `catch` 순서
    + 상위 예외 클래스가 하위 예외 클래스보다 아래쪽에 위치해야함
        * 하위 예외는 상위 예외를 상속했기 때문에 상위 예외 타입도 되기 때문!!

- 멀티 `catch`
    + 하나의 `catch` 블록에서 여러 개의 예외 처리 가능