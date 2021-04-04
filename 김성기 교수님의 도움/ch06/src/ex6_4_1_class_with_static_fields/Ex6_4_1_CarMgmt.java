package ex6_4_1_class_with_static_fields;

/**
 * [ car, CarMgmt 클래스 ]: 클래스 필드를 보여주는 예제
 *  
 *   o 클래스 작성 유형 1: 필드만 가지는 클래스 
 *  
 *   o 클래스 필드(static 필드)
 *     - 클래스 필드는 필드에 static 키워드가 붙은 필드
 *     - 클래스 필드는 각 객체마다 기억장소가 할당되지 않고 클래스 마다 하나만 할당
 *     - 클래스 필드는 클래스 전체와 관련된 정보를 저장하는 변수
 *     - 클래스 필드는 객체를 생성하지 않고서도 접근할 수 있으며, 
 *       << 클래스이름.클래스필드 >> 또는 << 객체참조변수.클래스필드 >의 형태로 접근     
 */

class Car {

	static int carCount = 0; // 생성된 Car 객체의 개수 나타내는 클래스 필드로
	                         //   클래스 또는 모든 객체에 의해 참조될 수 있음
	
	int carID;	     // carID, model, yearMade는 객체 필드
	String model;    //   이들은 객체가 생성될 때마다 기억장소가 할당되며
	int yearMade;    //   객체에 의해 참조
}

class Ex6_4_1_CarMgmt {
	public static void main(String[] args) {
		Car aCar = new Car();		// Car 객체 생성
		
		aCar.carID = ++Car.carCount;	// aCar.carID는 객체필드 참조,
		                                // Car.carCount는 클래스 필드 참조
		aCar.model = "소나타";
		aCar.yearMade = 2016;

		System.out.println("\n  * 차 고유번호:" + aCar.carID 
				                             + ", 차종:" + aCar.model + ", 제작년도:" + aCar.yearMade);

		// 클래스 필드는 클래스뿐 아니라 객체에 의해서도 참조될 수 있음
		System.out.println("\n  * 차 대수(클래스에 의해 참조):" + Car.carCount 
			                 + ", 차 대수(객체에 의해 참조):" + aCar.carCount);
	}
}

/*
 * [ 프로그램 이해 및 실행 ]
 * 
 *   1) 이 프로그램은 << static int carCount >>에서 클래스 필드를 선언하고
 *      이 클래스 필드를 참조한다.  
 *      
 *      클래스 필드가 선언된 부분과 참조된 부분을 잘 살펴보라.
 *      
 *   2) 클래스 필드는 클래스뿐 아니라 객체에 의해서도 참조될 수 있음을 확인하라.
 *   
 *   3) 프로그램을 실행하고 결과를 확인하라.
 *   
 *   
 * [ 실습과제 ]
 * 
 *   1) Car 객체를 생성하여 aCar2 변수에 저장하고 필드에 적절한 값을 저장한 후 
 *      aCar2 객체의 필드값과 carCount 값을 출력하는 코드를 추가로 작성하라.
 *      (aCra2 객체의 carID 필드 값은 carCount를 1 증가시킨 값으로 저장)
 *      
 *   2) 1)을 수행한 후의 클래스 필드와 객체 필드를 보여주는 그림을 그려보라.
 */
