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

