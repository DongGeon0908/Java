package ex6_4_2_class_with_static_fields;

/**
 * [ car, CarMgmt 클래스 ]: 여러 클래스 필드의 용도를 보여주는 예제
 *  
 *   o 클래스 작성 유형 3: 객체 생성자를 갖는 클래스 
 *  
 *   o 클래스 필드(static 필드)
 *     - 클래스 필드는 필드에 static 키워드가 붙은 필드
 *     - 클래스 필드는 각 객체마다 기억장소가 할당되지 않고 클래스마다 하나만 할당됨
 *     - 클래스 필드는 클래스 전체와 관련된 정보 저장하는 변수
 *     - 클래스 필드는 객체를 생성하지 않고서도 접근할 수 있으며, 
 *         << 클래스이름.클래스필드 >> 또는 << 객체참조변수.클래스필드 >>의 형태로 접근
 *         
 *   o 클래스 필드의 용도
 *     - 클래스 필드는 크게 모든 객체가 공유할 값 저장, 디폴트 값 저장, 생성된 객체 관리 등의 용도로 사용
 *     
 *     1) 모든 객체가 공유할 값 저장: 최대 인원수, 색상, 파일명 등을 저장하며 주로 상수 변수로 선언함
 *     2) 디폴트 값 저장: 객체 생성 시 필드 값이 주어지지 않을 경우 설정할 값 저장
 *     3) 생성된 객체 관리: 생성된 객체 개수, 객체 저장할 배열 등 객체가 생성될 때 필요한 정보 저장 
 */

class Car {
	// 모든 객체가 공유하는 값을 저장하는 공유용 클래스 필드: 자동차 색깔을 나타냄
	static int RED=0, BLUE=1, GREEN=2, YELLOW=3, WHITE=4, BLACK=5;

	// 디폴트 값 저장하는 디폴트용 클래스 필드: defaultNoDoors의 디폴트 값은 4	
	static final int defaultNoDoors = 4;    

	// 객체마다 부여될 값 저장하는 객체 관리용 클래스 필드: 객체 생성되면 1씩 증가
	static int carCount = 0;  

	int carID;		// 자동차 ID
	String maker;	// 제조회사
	String model;	// 차종
	int    color;	// 색깔
	int    noDoors;	// 문 개수

	// 매개변수 없는 객체 생성자: carID를 초기화시킴
	Car() { 
		// 클래스 필드 carCount를 증가시켜 carID에 저장
		this.carID = ++Car.carCount;  	
	}

	// 제조회사, 차종, 색깔이 주어지면 필드를 초기화하는 객체 생성자, 문 개수는 디폴트 개수로 초기화
	Car(String maker, String model, int color) {
		this(); // 매개변수 없는 객체 생성자 호출

		this.maker = maker;
		this.model = model;
		this.color = color;
		this.noDoors = Car.defaultNoDoors;  // 문 개수는 디폴트 개수로 초기화
	}

	// 제조회사, 차종, 색깔, 문 개수가 주어지면 필드를 초기화하는 객체 생성자
	Car(String maker, String model, int color, int noDoors) {
		this(maker, model, color); // 매개변수 있는 객체 생성자 호출하여 제조회사, 차종, 색깔 초기화

		this.noDoors = noDoors;    // 문 개수를 주어진 개수로 초기화
	}

	public String toString() {
		return "carID:" + carID + ", maker:" + maker + ", model:" + model +
				", color:" + color + ", noDoors:" + noDoors; 
	}
}

class Ex6_4_2_CarMgmt {
	// 생성된 Car 객체들 저장하여 관리하기 위한 객체 관리용 클래스 필드
	static Car[] cars = new Car[100]; // 100대의 Car 객체를 조장할 수 있는 배열

	public static void main(String[] args) {
		// Car 객체를 생성하여 cars[] 배열에 저장
		cars[0] = new Car("현대자동차", "소나타", Car.WHITE);
		cars[1] = new Car("기아자동차", "포르테", Car.YELLOW, 5);

		System.out.println("\n  * 클래스 필드 - YELLOW:" + Car.YELLOW + 
				", defaultNoDoors:" + Car.defaultNoDoors + 
				", carCount:" + Car.carCount );
		System.out.println("\n  * car[0] - " + cars[0].toString());
		System.out.println("\n  * car[1] - " + cars[1].toString()); 
	}
}
	
/*
 * [ 프로그램 이해 및 실행 ]
 * 
 *   1) 이 프로그램은 여러 용도의  클래스 필드를 선언하고 이 클래스 필드를 참조한다.  
 *      클래스 필드가 선언된 부분과 참조된 부분을 잘 살펴보라.
 *      
 *   2) 여러 용도의 클래스 필드가 필요에 따라 사용됨을 확인하라.
 *   
 *   3) 프로그램을 실행하고 결과를 확인하라.
 *   
 *   
 * [ 실습과제 ]
 * 
 *   1) Car 객체를 추가로 생성하여 cars[2]에 저장하고 생성된 car 객체를 출력하라.
 *      
 *   2) 1)을 수행한 후의 클래스, 배열객체, 생성된 car 객체를 보여주는 그림을 그려라.
 */
