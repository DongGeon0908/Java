# 📋2021-01-11📋
> 참조 타입

<br>

### ©CopyRight

> Donggeon Kim

> Department of Computer Engineering, Hanshin University

<br>

### 📒Contents

- 기본 타입(원시타입 : primitive type)
	+ 정수, 실수, 문자, 논리 리터럴을 저장하는 타입
	+ `byte, char, short, int, long, float, double, boolean`
- 참조 타입(reference type)
	+ 객체(object)의 번지를 참조하는 타입 -> 번지를 통해 객체 참조
	+ 배열, 열거, 클래스, 인터페이스 타입

> 변수는 스택 영역에 생성되고 객체는 힙 영역에 생성

> `String name = "Benjamin";` name은 힙 영역의 String 객체 주소값을 가지고 주소를 통해 객체를 참조

- 메모리 사용 영역 `Runtime Data Area`
	+ 메소드 영역 `Method`
	+ 힙 영역 `Heap`
	+ JVM 영역 `Stack`

- 메소드 영역
	+ 코드에서 사용되는 클래스(~.class)들을 클래스 로더로 읽음
	+ 런타임 상수풀 `runtime constant pool`, 필드 데이터 `field data`, 메소드 데이터 `method data`, 메소드 코드 `method code`, 생성자 코드 `constructor code` 등을 분류해서 저장
	+ JVM이 시작할 때 생성
	+ 모든 스레드가 공유하는 영역

- 힙 영역
	+ 객체와 배열이 생성되는 영역
	+ JVM 스택 영역의 변수나 다른 객체의 필드에서 참조
	+ `garbage collector`을 이용해 쓰레기 객체를 힙 영역에서 자동으로 제거

- JVM 스택 영역
	+ 각 스레드마다 하나씩 존재하며 스레드가 시작될 때 할당
	+ 메소드를 호출할 때마다 `frame`을 `push`
	+ 메소드가 종료되면 `frame`을 `pop`
	+ 최초로 변수에 값이 저장될 때 생성

- 참조 변수의 연산
	+ 힙 영역의 객체 주소를 비교하는것
	+ 동일한 주소값 == 동일한 객체 참조

- 참조 타입 변수에서 `null`
	+ `null` -> 힙 영역의 객체를 참조하지 않는다
	+ `null`로 초기화된 참조 변수는 스택 영역에 생성

- `Exception`
	+ 프로그램 실행 도중에 발생하는 오류

- `NullPointerException`
	+ 참조 타입 변수를 잘못 사용하면 발생
	+ `null`값을 가지고 있는 참조 타입 변수를 사용하면 발생

- `String`
	+ 문자열은 `String` 객체로 생성되고 변수는 `String` 객체를 참조
	+ 문자열 리터럴이 동일하다면 `String` 객체 공유
	+ `new`
		* 힙 영역에 새로운 객체를 만들 때 생성
		* 객체 생성 연산자
	+ `new`연산자를 통해 직접 `String` 객체 생성 가능
	+ 문자열 리터럴 생성
		* `==`연산 진행시 같은 주소를 참조하기 때문에 'true'
		* 문자열 리터럴이 같으면 주소가 같기 때문
	+ `new 연산자`
		* `==`연산 진행시 같은 주소를 참조하기 때문에 'false'
		* 문자열 리터럴이 같아도 새롭게 객체가 생성 되었기 때문에 주소가 다름
	+ `equals()`
		* `boolean result = str1.equals(str2);`
		* 원본 문자열과 매개값으로 주어진 비교 문자열이 동일한지 비교
		* `true` or `false` 반환
	+ 참조를 잃은 `String` 객체는 `garbage collector`를 통해 메모리에서 자동 제거
	+ 초기값으로 `null`값 대입 가능
	+ [문자열 비교]()