package ex7_4_2_point_class_with_constructor_error;

/**
 * [ Point, ColorPoint, PointMain 클래스 ] : 
 *       상위 클래스의 객체 생성자 선언되지 않음을 보여주는 예제 
 *  
 *   o 하위 클래스에서 호출한 상위 클래스의 객체 생성자가 상위 클래스에 선언되지 않은 경우에는 오류가 발생
 *    
 *   o 상위 클래스에 매개변수가 있는 객체 생성자는 선언하면서 매개변수가 없는 객체 생성자를 선언하지 않는 경우
 *     - 하위 클래스의 객체 생성자에서 오류 발생하기 쉬우므로 주의해야 함
 *     - 하위 클래스에서 내부적으로 호출되는 super() 객체 생성자를 상위 클래스에서 선언하지 않으면 
 *       디버깅이 어려운 오류 발생 
 */

// 매개변수가 있는 객체 생성자만 가지는 클래스
class Point {
	int x, y;   // 점의 좌표
	
	// 좌표를 초기화하는 매개변수 있는 객체 생성자
	Point(int x, int y) {
		this.x = x; this.y = y;
	}
	
	void output(String msg) {
		System.out.println(msg + " (x, y) = (" + x + ", " + y + ")" );
		
	}
}

class ColorPoint extends Point {
	int color;

	ColorPoint(int x, int y) {
		super(x, y);
	}
	
	ColorPoint(int x, int y, int color) {
		super(x, y);
		this.color = color;
	}
	
	// 색상만 초기화하는 객체 생성자
	//   - 이 객체 생성자에서는 다음의 오류가 발생함: 
	//      Implicit super constructor Point() is undefined. Must explicitly invoke another constructor
	//
	//   - 바로 아래 왼쪽의 붉은 오류 표시에 마우스 위치하면 오류 메시지 보임
	//   - 외관상 객체 생성자 호출이 없지만 첫 문장이 객체 생성자 호출이 아니므로 super()가 내부적으로 호출되기 때문임
	ColorPoint(int color) {
		this.color = color;
	}
	
	void output(String msg) {
		System.out.println(msg + " (x, y) = (" + x + ", " + y + ") of color " + this.color);		
	}
}

public class Ex7_4_2_PointMain {
	public static void main(String[] args) {

		ColorPoint p1 = new ColorPoint(3, 5);
		p1.output("\n  * p1: ");
		
		ColorPoint p2 = new ColorPoint(0xFF0000);
		p2.output("\n  * p2: ");
	}
}

/*
 * [ 프로그램 이해 및 실행 ]
 * 
 *   1) 프로그램을 살펴보고 프로그램을 이해하고 오류 사항을 확인하라.
 *      
 *   2) 객체 생성자 ColorPoint(int color)에서 오류가 발생한 원인을 정확히 이해하라. 
 *      
 *   3) 객체 생성자 ColorPoint(int color)에서는 다른 객체 생성자 호출이 없으므로 
 *      첫 문장에 super();가 추가되어 내부적으로 상위 클래스의 객체 생성자 Point()가 호출됨을 이해하라.
 *           
 *   4) 상위 클래스 Point에는 객체 생성자 Point()가 선언되지 않았음을 확인하라.
 *   
 *   
 * [ 실습 과제 ]
 * 
 *   o 객체 생성자 ColorPoint(int color)에서 오류를 제거하기 위한 방법은 다음의 2가지이다. 
 *     각 방법으로 수정하여 오류가 사라짐을 확인하라.
 *     
 *     (1) 상위 클래스에 매개변수 없는 객체 생성자를 다음과 같이 추가한다.
 *     
 *          Point() {}
 *          
 *     (2) ColorPoint(int color)의 첫 문장에서 상위 클래스 객체 생성자를 호출하도록 
 *         다음과 같이 추가한다.
 *         
 *          super(0, 0);
 */