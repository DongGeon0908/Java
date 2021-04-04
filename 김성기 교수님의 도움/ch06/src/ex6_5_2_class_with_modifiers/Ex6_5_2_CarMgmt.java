package ex6_5_2_class_with_modifiers;

/**
 * [ CarMgmt 클래스 ]: 클래스 필드의 용도를 보여주는 예제
 *  
 *   o 클래스 작성 유형 1: 필드만 갖는  클래스 
 *  
 *   o 접근 범위를 상세하게 지정한 프로그램
 *     - 접근 범위에 따른 필드와 메소드 접근이 달라짐
 *    
 *     - public: 다른 클래스의 메소드에서도 접근 가능 
 *     - package: 같은 패키지의 클래스의 메소드에서만 접근 가능
 *     - private: 클래스 내의 메소드에서만 접근 가능 , 다른 클래스에서는 접근 불능
 */

class Ex6_5_2_CarMgmt {
	// 생성된 Car 객체들을 저장하여 관리하기 위한 객체 관리용 클래스 필드
	static Car[] cars = new Car[100]; // 100대의 Car 객체를 조장할 수 있는 배열

	public static void main(String[] args) {
		// Car 객체를 생성하여 cars[] 배열에 저장
		
		cars[0] = new Car();  // 오류 원인을 파악하라
		
		cars[1] = new Car("현대자동차", "소나타", Car.WHITE);
		cars[2] = new Car("기아자동차", "포르테", Car.YELLOW, 5);

		System.out.println("\n  * 클래스 필드 - YELLOW:" + Car.YELLOW + 
				", defaultNoDoors:" + Car.defaultNoDoors + 
				", carCount:" + Car.carCount ); // 오류 원인을 파악하라
		
		System.out.println("\n  * car[0] - " + cars[0].toString());
		System.out.println("\n  * car[1] - " + cars[1].toString()); 
	}
}

/*
 * [ 프로그램 이해 및 실행 ]
 * 
 *   1) 이 프로그램은 6-4-2에 대해 접근 범위를 상세하게 지정한 프로그램이다  
 *      접근 범위에 따른 필드와 메소드 접근이 달라짐을 확인 한 후 프로그램을 잘 살펴보라.
 *      
 *   2) 이 프로그램의 main() 메소드에는 오류가 표시된다.
 *      - 오류 부분의 원인이 무엇인지 확인하라.
 *      - 오류를 제거하기 위한 조치를 취하라.
 *   
 *   3) 오류 제거 후 프로그램을 실행하고 결과를 확인하라.
 */
