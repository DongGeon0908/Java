package ex8_3_1_object_copy;

/**
 * [ Point 클래스 ] : Cloneable 인터페이스를 구현하는 Point 클래스를 이용한 객체 복사 예제
 * 
 *   o 인터페이스
 *     - public static final 필드와 제한적인  메소드만 가지는 특별한 클래스
 *     - 객체 생성할 수 없으며, 구현하는 하위 클래스에서 객체 생성 가능
 *     - 인터페이스 구현하는 하위 클래스는 반드시  abstract 메소드 구현해야 함
 *     - 인터페이스는 타입으로 사용되어 인터페이스 객체 참조변수 선언할 수 있으며,
 *       인터페이스 객체 참조변수는 하위 클래스의 객체 참조
 *     - 인터페이스 구현하는 여러 하위 클래스 객체는 인터페이스 객체도 되므로 통합적으로 관리될 수 있음
 *     
 *   o Cloneable 인터페이스
 *     - 객체를 복사하기 위한 Object 클래스의 clone() 메소드 호출하려면 반드시 구현해야 하는 인터페이스
 *     - C 클래스의 객체를 복사하려면 다음과 같이 작성해야 함
 *     
 *        class C implements Cloneable {
 *        
 *           ....
 *           
 *        }
 *        
 *     - 객체를 복사할 클래스는 Cloneable 인터페이스를 구현하고 clone() 메소드를 오버라이딩하는 것이 원칙 
 */

// (x, y) 두 점의 좌표를 나타내는 필드로 구성되는 Point 클래스
//    이 클래스는 Cloneable 인터페이스를 구현하므로 Object 클래스의 clone() 메소드를 이용하여
//    객체를 복사할 수 있음
class Ex8_3_1_Point implements Cloneable { 
	int x, y;	// (x, y) 좌표

	Ex8_3_1_Point(int x, int y) {  // 객체 생성자
		this.x = x;
		this.y = y;
	}
	
	// Object 클래스의 clone() 메소드 오버라이딩 
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}

	public String toString() {
		return "(" + this.x + ", " + this.y + ")";
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		Ex8_3_1_Point p1 = new Ex8_3_1_Point(5, 20);   // p1이 참조하는 Point 객체 생성

		// p1이 복사된 Point 객체를 생성하여 p2가 참조
		Ex8_3_1_Point p2 = (Ex8_3_1_Point) p1.clone(); // clone() 메소드는 객체 복사 메소드임, 복사된 객체를 Object 하위 클래스로 다운캐스팅

		// p1과 p2의 필드 값 확인: 복사되었으므로 같아야 함
		System.out.println("  * p1 = " + p1);
		System.out.println("  * p2 = " + p2);
	}
}

/*
 * [ 프로그램 이해 및 실행 ]
 * 
 *   1) clone() 메소드 호출하려면 반드시 Cloneable 인터페이스를 구현하여야 한다.
 *      Point 클래스가 Cloneable 인터페이스를 구현하였음을 확인하라.
 *      
 *   2) 이 프로그램은 clone() 메소드를 이용하여 Point 객체를 복사하였다. 
 *      프로그램 실행하여 Point 객체 p1과 p2의 필드 값이 동일함을 확인하라.      
 *   
 *   
 * [ 실습 과제 ]
 * 
 *   o << class Ex8_3_1_Point implements Cloneable >>에서 << implements Cloneable >>를 제거하면
 *      컴파일에서는 오류가 발생하지 않지만 실행 시에 오류가 발생함을 확인하라.
 */
