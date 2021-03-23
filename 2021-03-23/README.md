### 📒Contents

- 쓰레기 수집기 실행
    + `gc()`
    + `JVM`은 메모리가 부족할 때와 `CPU`가 한가할 때에 쓰레기 수집기를 실행시켜 사용하지 않는 객체를 자동제거
    + 개발자가 직접 코드로 실행시킬 수 없고, `JVM`에게 가능한한 빨리 실행해 달라고 요청할 수 있음
    + `System.gc()`
        * `JVM`은 빠른 시간 내에 실행시키기 위해 노력
    
- 현재 시간 읽기
    + `currentTimeMillis()`
    + `nanoTime()`
    + 컴퓨터의 시계로부터 현재 시간을 읽어서 밀리세컨드 단위와 나노 세컨드 단위의 `long` 값을 리턴
    + 프로그램의 실행 소요 시간 측정에 사용

- 시스템 프로퍼티 읽기 `getProperty()`
    + `JVM`이 시작할 때 자동 설정되는 시스템의 속성값
        * 운영체제의 종류
        * 자바 프로그램을 실행시킨 사용자 아이디
        * `JVM` 버전
        * 운영체제에서 사용되는 파일 경로 구분자
    + `key`와 `value`로 구성
    + `System.getProperty()`
        * 시스템 프로퍼티의 키 이름을 매개값으르 받고, 해당 키에 대한 값을 문자열로 리턴
    + `keySet()`
        * `key`만으로 구성된 `Set` 객체를 얻음

- 환경 변수
    + 실행되는 프로그램들에게 유용한 정보를 제공할 목적으로 사용
    + 운영체제에서 이름과 값으로 관리되는 문자열 정보
    + 운영체제가 설치될 때 기본적인 내용이 설정
    + 사용자가 직접 설정하거나 응용 프로그램이 설치될 때 자동적으로 추가
    ```
    String value = System.getenv("JAVA_HOME");
    ```

- `Class` 클래스
    + 클래스와 인터페이스의 메타 데이터를 관리
        * 이름, 생성자 정보, 필드 정보, 메소드 정보 등
    + `getClass()`
        * 해당 클래스로 객체를 생성했을 때 사용 가능
        * 객체를 생성하기 전에 직접 `Class` 객체 얻을 수 있음
    + `forName()`
        * 클래스 전체 이름을 매개값으로 받고 `Class` 객체를 리턴
        * 매개값으로 주어진 클래스를 찾지 못하면 `ClassNotFoundException` 예외 발생
    ```
    try{
        Class clazz = Class.forName(String className);
    } catch (classNotFoundException e){}
    ```

- 리플렉션 `Reflection`
    + 클래스의 생성자, 필드, 메소드 정보를 확인
        * `getDeclaredConstructors()` -> `Constructor` 배열 return
        * `getDeclaredFields()` -> `Field` 배열 return
        * `getDeclaredMethods()` -> `Method` 배열 return

- 동적 객체 생성 `newInstance()`
    + `Class`객체를 이용해 `new`연산자 없이 동적으로 객체 생성 가능
    + 기본 생성자를 호출해서 객체를 생성하기 때문에 반드시 클래스에 기본 생성자 필요
    + `InstantiationException`
        * 해당 클래스가 추상 클래스이거나 인터페이스일 경우에 발생
    + `IllegalAccessException`
        * 클래스나 생성자가 접근 제한자로 인해 접근할 수 없을 경우에 발생
