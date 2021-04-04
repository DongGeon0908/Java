package ex6_5_2_class_with_modifiers;

/**
 * [ car 클래스 ]: 접근 범위를 나타내는 수식어의 예를 보여주는 예
 *  
 *   o 클래스 작성 유형 3: 객체 생성자를 갖는  클래스 
 *  
 *   o 접근 범위를 상세하게 지정한 프로그램
 *     - 접근 범위에 따른 필드와 메소드 접근이 달라짐
 *    
 *     - public: 다른 클래스의 메소드에서도 접근 가능 
 *     - package: 같은 패키지의 클래스의 메소드에서만 접근 가능
 *     - private: 클래스 내의 메소드에서만 접근 가능 , 다른 클래스에서는 접근 불능
 */

// public 클래스인 경우 반드시 별도의  .java 파일에 작성되어야 함
public class Car {
	// 모든 객체가 공유하는 값을 저장하는 공유용 클래스 필드: 자동차 색깔을 나타냄
	// public이므로 다른 클래스의 메소드에서도 접근 가능 
	public static int RED=0, BLUE=1, GREEN=2, YELLOW=3, WHITE=4, BLACK=5;

	// 디폴트 값을 저장하는 디폴트용 클래스 필드: defaultNoDoors의 디폴트 값은 4	
	// public이므로 다른 클래스의 메소드에서도 접근 가능 
	public static final int defaultNoDoors = 4;    

	// 객체마다 부여될 값을 저장하는 객체 관리용 클래스 필드: 객체 생성되면 1씩 증가
	// private이므로 클래스 내의 메소드에서만 접근 가능, 다른 클래스에서는 접근 불능
	private static int carCount = 0;  

	int carID;		// 자동차 ID
	String maker;	// 제조회사
	String model;	// 차종
	int    color;	// 색깔
	int    noDoors;	// 문 개수

	// 매개변수 없는 객체 생성자: carID 초기화시킴
	// private이므로 클래스 내의 메소드에서만 호출 가능, 다른 클래스에서 호출 불능
	private Car() { 
		// 클래스 필드 carCount를 증가시켜 carID에 저장
		this.carID = ++Car.carCount;  	
	}

	// 제조회사, 차종, 색깔이 주어지면 필드를 초기화하는 객체 생성자, 문 개수는 디폴트 개수로 초기화
	public Car(String maker, String model, int color) {
		this(); // 매개변수 없는 객체 생성자 호출

		this.maker = maker;
		this.model = model;
		this.color = color;
		this.noDoors = Car.defaultNoDoors;  // 문 개수는 디폴트 개수로 초기화
	}

	// 제조회사, 차종, 색깔, 문 개수가 주어지면 필드를 초기화하는 객체 생성자
	public Car(String maker, String model, int color, int noDoors) {
		this(maker, model, color); // 매개변수 있는 객체 생성자 호출하여 제조회사, 차종, 색깔 초기화

		this.noDoors = noDoors;    // 문 개수를 주어진 개수로 초기화
	}

	public String toString() {
		return "carID:" + carID + ", maker:" + maker + ", model:" + model +
				", color:" + color + ", noDoors:" + noDoors; 
	}
}

/*
 * [ 프로그램 이해 및 실행 ]
 * 
 *   1) 이 프로그램은 6-4-2에 대해 접근 범위를 상세하게 지정한 프로그램이다  
 *      접근 범위에 따른 필드와 메소드 접근이 달라짐을 확인 한 후 프로그램을 잘 살펴보라.
 *      
 *   2) Public과  private 멤버의 차이를 이해하라.
 */
