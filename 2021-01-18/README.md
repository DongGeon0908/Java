# 📋2021-01-18📋
> `class`

<br>

### ©CopyRight

> Donggeon Kim

> Department of Computer Engineering, Hanshin University

<br>

### 📒Contents

- 객체 지향 프로그래밍 `OOP: Object Oriented Programming`
	+ 소프트웨어를 개발할 떄에도 부품에 해당하는 개체들을 먼저 만들고, 이것들을 하나씩 조립해서 완성된 프로그램을 만드는 기법
	+ 완성품인 객체를 모델링하고, 집합 관계에 있는 부품 객체와 사용 관계에 있는 객체를 하나씩 설계한 후 조립하는 방식

- 객체 `Object`
	+ 물리적으로 존재하거나 추상적으로 생각할 수 있는 것 중에서 자신의 속성을 가지고 있는 다른 것과 식별 가능한 것
	+ 속성과 동작으로 구성

- 객체 모델링 `Object Modeling`
	+ 현실 세계의 객체를 소프트웨어 객체로 설계하는 것
	+ 현실 세계 객체의 속성과 동작을 추려내어 소프트웨어 객체의 필드와 메소드로 정의하는 과정

- 메소드
	+ 객체들 사이의 상호작용 수단

- 메소드 호출
	+ 객체가 다른 객체의 기능을 이용하는 것
	+ 객체에 도트 `.` 연산자를 붙이고 메소드 이름을 기술

- 객체의 상호작용
	+ 객체 간의 메소드 호출을 의미
	+ 매개값과 리턴값을 통해서 데이터를 주고 받음

- 객체 간의 관계
	+ 집합 관계
		* 객체는 하나의 부품이고 하나는 완성품에 해당
	+ 사용 관계
		* 객체 간의 상호작용
		* 객체는 다른 객체의 메소드를 호출해 원하는 결과를 얻음
	+ 상속 관계
		* 상쉬(부모) 개체를 기반으로 하위(자식) 개체를 생성하는 관계

- 캡슐화 `Encapsulation`
	+ 객체의 필드, 메소드를 하나로 묶고, 실제 구현 내용을 감추는 것
	+ 외부 객체는 내부의 구조를 알지 못함
	+ 객체가 노출해서 제공하는 필드와 메소드만 이용 가능

- 접근 제한자 `Access Modifier`
	+ 객체의 필드와 메소드의 사용 범위를 제한함으로써 외부로부터 보호

- 상속 `Inheritance`
	+ 상위 개체는 자기가 가지고 있는 필드의 메소드를 하위 객체에게 물려주어 하위 객체가 사용할 수 있도록 함
	+ 하위 객체를 쉽고 빨리 설계
	+ 반복된 코드의 중복을 줄임
	+ 상위 개체의 수정으로 모든 하위 객체들의 수정 효과를 가져옴
	+ 유지 보수 시간 최소화

- 다형성 `PolyMorPhism`
	+ 같은 타입이지만 실행 결과가 다양한 객체를 이용할 수 있는 성질
	+ 하나의 타입에 여러 객체를 대입함으로써 다양한 기능 이용할 수 있음
	+ 객체는 부품화 가능

- 클래스 `clas`
	+ 객체를 생성하기 위한 필드와 메소드 정의

- 인스턴스 `instance`
	+ 클래스로부터 객체를 만드는 과정

- 객체 지향 프로그래밍 개발 단계
	1. 클래스 설계
	2. 섫계된 클래스를 가지고 사용할 객체 생성
	3. 생성된 객체를 이용하는 것