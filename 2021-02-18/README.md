### 📒Contents

- 상속 `Inheritance`
    + 부모 클래스의 멤버를 자식 클래스에게 물려줌
    + 부모 클래스
        * 상위 클래스
    + 자식 클래스
        * 하위 클래스
        * 파생 클래스
    + 코드의 중복을 줄여줌
    + 상속 불가
        * 부모 클래스에서 `private` 접근 제한을 갖는 필드와 메소드
        * 부모 클래스와 자식 클래스가 서로 다른 패키지인 상태에서 `default` 접근 제한 갖는 필드와 메소드
    + 상속 이점
        * 클래스의 수정 최소화
        * 유지 보수 시간 최소화
    + 자바에서는 다중 상속 불가능
    + 부모 생성자는 자식 생성자에 숨어서 가장 먼저 호출됨
        * 부모가 생성되고 자식이 생성됨