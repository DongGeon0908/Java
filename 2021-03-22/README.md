### 📒Contents

- `Objects` 클래스
    + `java.util.Objects`
    + 객체비교, 해시코드 생성, null 여부, 객체 문자열 리턴 등의 연산을 수행하는 정적 메소드들로 구성한 유틸리티 클래스

- `Objects.compare(T a, T b, Comparator<T>c)`
    + 두 객체를 비교자 `Comparator` 로 비교해서 `int` 값을 리턴
    + `java.util.Comparator<T>`는 제네릭 인터페이스 타입으로 두 객체를 비교하는 `compare(T a, T b)`
    + `compare(T a, T b)`
        * 메소드의 리턴 타입은 `int`인데, a가 b보다 작으면 음수, 같으면 0, 크면 양수 리턴
    
- `Objects.equals(Object a, Object b)`
    + 두 객체의 동등을 비교 해서 return
        * a와 b가 모두 null인 경우 true return
        * a와 b가 null이 아닌 경우 a.equals(b)의 결과를 return
    
- `Objects.deepEquals(Object a, Object b)`
    + 두 객체의 동등을 비교
    + a와 b가 서로 다른 배열일 경우 항목 값이 같다면 true 리턴

- `Objects.hash(Object...values)`
    + 매개값으로 주어진 값들을 이용해서 해시 코드를 생성하는 역할

- `Objects.hashCode(Object...values)`
    + 매개값으로 주어진 객체의 해시코드를 리턴
    + 매개값이 null이면 0을 리턴

- `Object.isNull(Object obj)`
    + 매개값이 null일 경우 true 리턴

- `nonNull(Object obj)`
    + 매개값이 not null일 경우 true 리턴

- `requireNonNull()`
    + `requireNonNull(T obj)`
    + `requireNonNull(T obj, String message)`
    + `requireNonNull(T obj, Supplier<String> msgSupplier)`

- 객체 문자 벙보 `toString()`
    + 객체의 문자 정보를 리턴
    + `toString(Object o)`
        * 첫 번째 매개값이 `not null`이면 `toString()`으로 얻은 값을 리턴
        * `null`이면 `null`
    + `toString(Object o, String nullDefault)`
        * 매개값인 `nullDefault`를 리턴

- `java.lang` 패키지에 속하는 `System` 클래스를 이용하면 운영체제의 일부 기능을 이용할 수 있음
    + 프로그램 종료
    + 키보드로부터 입력
    + 모니터로 출력
    + 메모리 정리
    + 현재 시간 읽기
    + 시스템 프로퍼티 읽기
    + 환경 변수 읽기
    + `System` 클래스의 모든 필드와 메소드는 정적 필드와 정적 메소드로 구성

- 프로그램 종료
    + 강제적으로 `JVM` 종료
    + `System` 클래스의 `exit()` 메소드를 호출
    + `exit()`
        * 현재 실행하고 있는 프로세스를 강제 종료시키는 역할
        * `System.exit(0)`
    + 보안 관리자를 직접 설정해서 종료 상태값을 확인
        * `System.exit()`가 실행되면 보안관리자의 `checkExit()` 메소드가 자동 호출
        * 종료 상태값을 조사해서 특정 값이 입력되지 않으면 `SecurityException`을 발생시켜 `System.exit()`를 호출한 곳에서 예외 처리를 할 수 있도록 해줌
        * `checkExit()`가 정상적으로 실행되면 `JVM`은 종료