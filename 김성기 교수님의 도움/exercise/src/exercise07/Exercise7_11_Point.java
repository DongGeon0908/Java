package exercise07;

/**
 * [ 7장 연습문제  11 ]:
 *   
 *   11. 하위 클래스 Point3D가 다음과 같이 작성되었다.
 *   
 *     1) 1) Point3D 클래스와 main() 메소드를 참조하여 Point 클래스를 작성하라.
 *     
 *     2) main() 메소드의 << Point3D p3D = new Point3D(1, 2, 3); >>이 수행되는 
 *        과정과 내용을 설명하라.
 *        
 *     3) main() 메소드의  << p2D.getSquareSum() >> 이 수행되는 과정과 내용을 설명하라.
 *     
 *     4) main() 메소드의 출력결과를 구하라.
 */

// 2차원 점을 나타내는 클래스
class Point {
	// Point3D 클래스와 main() 메소드를 참조하여 Point 클래스를 작성하라.
	
}

// 3차원 점을 나타내는 클래스
class Point3D extends Point {
	double  z; 
	
	Point3D(double x, double y, double z) {
		super(x, y);
		this.z = z;
	}
	
	void add(double x, double y, double z) {
		add(x, y);
		this.z = this.z + z;
	}

	double getSquareSum() {
		return super.getSquareSum() + z * z;
	}
}

class Exercise7_11_Point {
	public static void main(String[] args) {
		Point3D p3D = new Point3D(1, 2, 3);
		p3D.add(1, 0, 1);

		Point p2D = p3D;  // Point3D 객체를 Point 객체 참조변수에 저장

		System.out.println("\n  * x:" + p2D.x + ", y:" + p2D.y + ", 제곱 합: "
				+ p2D.getSquareSum() );
	}
}

