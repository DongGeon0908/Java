package exercise07;

/**
 * [ 7�� ��������  11 ]:
 *   
 *   11. ���� Ŭ���� Point3D�� ������ ���� �ۼ��Ǿ���.
 *   
 *     1) 1) Point3D Ŭ������ main() �޼ҵ带 �����Ͽ� Point Ŭ������ �ۼ��϶�.
 *     
 *     2) main() �޼ҵ��� << Point3D p3D = new Point3D(1, 2, 3); >>�� ����Ǵ� 
 *        ������ ������ �����϶�.
 *        
 *     3) main() �޼ҵ���  << p2D.getSquareSum() >> �� ����Ǵ� ������ ������ �����϶�.
 *     
 *     4) main() �޼ҵ��� ��°���� ���϶�.
 */

// 2���� ���� ��Ÿ���� Ŭ����
class Point {
	// Point3D Ŭ������ main() �޼ҵ带 �����Ͽ� Point Ŭ������ �ۼ��϶�.
	
}

// 3���� ���� ��Ÿ���� Ŭ����
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

		Point p2D = p3D;  // Point3D ��ü�� Point ��ü ���������� ����

		System.out.println("\n  * x:" + p2D.x + ", y:" + p2D.y + ", ���� ��: "
				+ p2D.getSquareSum() );
	}
}

