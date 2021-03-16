### 📒Contents

- 메소드 재정의
    + `@Override`
        * 상소된 메소드의 내용이 자식 클래스에 맞지 않을 경우, 자식 클래스에서 동일한 메소드 재정의하는 것
        * 부모의 메소드와 동일한 시그니처`리턴 타입, 메소드 이름 매개변수 리스트`
        * 접근 제한을 더 강하게 오버라이딩할 수 없음
            + 이 뜻은 접근 제한자를 더 강하게 설정 불가능하다는 뜻!
        * 새로운 예외를 `throws`할 수 없음
    + 부모 메소드 호출 `super`
        * `super`는 부모 객첼들 참조하고 있기 때문에 부모 메소드에 직접 접근 가능

- `final`
    + 해당 선언이 최종 상태이고, 수정될 수 없음을 의미
    + `final` 필드
        * 초기값 설정 후, 더 이상 값을 변경할 수 없음
    + `final` 클래스
        * 최종적인 클래스
        * 부모 클래스가 될 수 없음
    + `final` 메소드
        * 최종적인 메소드
        * `Overriding`할 수 없는 메소드
        * 재정의 불가한 메소드를 의미 
    
- `protected`
    + 같은 패키지에서는 선언 가능
    + 다른 패키지에서는 직접 호출은 불가능
        * 자식 생성자에서 `super()`로 생성자를 호출할 수 있음
    
- 다형성  
    + 같은 타입이지만 실행 결과가 다양한 객체를 이용할 수 있는 성질
        * 다양한 기능을 이용할 수 있도록 해줌
        * 부모 클래스로 타입 변환을 허용해 모든 자식 객체가 대입될 수 있음

- 타입 변환
    + 타입을 다른 데이터 타입으로 변환하는 행위
    + 클래스 타입 변환
        * 상속 관꼐에 있는 클래스 사이에서 발생
        * 자식 타입은 부모 타입으로 자동 타입 변환 가능

- 자동 타입 변환 `Promotion`
    + 프로그램 실행 도중에 자동적으로 타입 변환이 일어나는 것
        * 자식은 부모의 특징과 기능을 상속받기 때문에 부모와 동일하게 취급 가능 
        * 부모 클래스에 선언된 필드와 메소드만 접근 가능
            + 메소드가 자식 클래스에서 오버라이딩되었다면 자식 클래스의 메소드가 대신 호출됨

- 필드의 다형성
    + 다형성
        * 동일한 타입을 사용하지만 다양한 결과가 나오는 성질
    + 필드의 타입은 변함이 없지만, 실행 도중에 어떤 객체를 필드로 저장하느냐에 따라 실행 결과가 달라질 수 있음

- 매개 변수의 다형성
    + 매개값을 다양화하기 위해 매개 변수에 자식 타입 객체를 지정
    + 매개 변수의 타입이 클래스일 경우, 해당 클래스의 객체뿐만 아니라 자식 객체까지도 매개값으로 사용할 수 있음
        * 매개값의 자동 타입 변환과 메소드 오버라이딩을 이용해서 매개변수의 다형성을 구현할 수 있음

- 강제 타입 변환 `Casting`
    + 부모 타입을 자식 타입으로 변환하는 것
        * 자식 타입이 부모 타입으로 자동 변환한 후, 다시 자식 타입으로 변환할 때 사용 가능 

- 객체 타입 확인 `instanceof`
    + 어떤 객체가 어떤 클래스의 인스턴스인지 확인하는 연산자
    + 매개값의 타입을 조사할 때 사용
        * 강제 타입 변환 전에 해당 객체가 매개값으로 적절한지 안전하게 조사할 수 있음

- 실체 클래스
    + 객체를 직접 생성할 수 있는 클래스

- 추상 클래스 `abstract class`
    + 실체 클래스들의 공통적인 특성을 추출해서 선언한 클래스
    + 실체 클래스와 상속의 관계
    + 추상 클래스 == 부모
        * 실체 클래스 == 자식
    + `new` 연산자를 사용해서 인스턴스를 생성시키지 못함
    + 결과적 추상 클래스는 앞으로 만들 클래스들이 어떤 형태를 갖고, 어떤 클래스가 필요한지 미리 알려주는 기능을 함
    + 실체 클래스가 공통적으로 가져야 할 필드와 메소드들을 정의해 놓은 추상적인 클래스
        * 실체 클래스의 멤버를 통일하는데 목적
        * 추상 클래스는 추상 메서드를 선언할 수 잇음