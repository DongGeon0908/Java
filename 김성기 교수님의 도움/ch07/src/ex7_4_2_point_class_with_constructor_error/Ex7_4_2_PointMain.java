package ex7_4_2_point_class_with_constructor_error;

/**
 * [ Point, ColorPoint, PointMain Ŭ���� ] : 
 *       ���� Ŭ������ ��ü ������ ������� ������ �����ִ� ���� 
 *  
 *   o ���� Ŭ�������� ȣ���� ���� Ŭ������ ��ü �����ڰ� ���� Ŭ������ ������� ���� ��쿡�� ������ �߻�
 *    
 *   o ���� Ŭ������ �Ű������� �ִ� ��ü �����ڴ� �����ϸ鼭 �Ű������� ���� ��ü �����ڸ� �������� �ʴ� ���
 *     - ���� Ŭ������ ��ü �����ڿ��� ���� �߻��ϱ� ����Ƿ� �����ؾ� ��
 *     - ���� Ŭ�������� ���������� ȣ��Ǵ� super() ��ü �����ڸ� ���� Ŭ�������� �������� ������ 
 *       ������� ����� ���� �߻� 
 */

// �Ű������� �ִ� ��ü �����ڸ� ������ Ŭ����
class Point {
	int x, y;   // ���� ��ǥ
	
	// ��ǥ�� �ʱ�ȭ�ϴ� �Ű����� �ִ� ��ü ������
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
	
	// ���� �ʱ�ȭ�ϴ� ��ü ������
	//   - �� ��ü �����ڿ����� ������ ������ �߻���: 
	//      Implicit super constructor Point() is undefined. Must explicitly invoke another constructor
	//
	//   - �ٷ� �Ʒ� ������ ���� ���� ǥ�ÿ� ���콺 ��ġ�ϸ� ���� �޽��� ����
	//   - �ܰ��� ��ü ������ ȣ���� ������ ù ������ ��ü ������ ȣ���� �ƴϹǷ� super()�� ���������� ȣ��Ǳ� ������
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
 * [ ���α׷� ���� �� ���� ]
 * 
 *   1) ���α׷��� ���캸�� ���α׷��� �����ϰ� ���� ������ Ȯ���϶�.
 *      
 *   2) ��ü ������ ColorPoint(int color)���� ������ �߻��� ������ ��Ȯ�� �����϶�. 
 *      
 *   3) ��ü ������ ColorPoint(int color)������ �ٸ� ��ü ������ ȣ���� �����Ƿ� 
 *      ù ���忡 super();�� �߰��Ǿ� ���������� ���� Ŭ������ ��ü ������ Point()�� ȣ����� �����϶�.
 *           
 *   4) ���� Ŭ���� Point���� ��ü ������ Point()�� ������� �ʾ����� Ȯ���϶�.
 *   
 *   
 * [ �ǽ� ���� ]
 * 
 *   o ��ü ������ ColorPoint(int color)���� ������ �����ϱ� ���� ����� ������ 2�����̴�. 
 *     �� ������� �����Ͽ� ������ ������� Ȯ���϶�.
 *     
 *     (1) ���� Ŭ������ �Ű����� ���� ��ü �����ڸ� ������ ���� �߰��Ѵ�.
 *     
 *          Point() {}
 *          
 *     (2) ColorPoint(int color)�� ù ���忡�� ���� Ŭ���� ��ü �����ڸ� ȣ���ϵ��� 
 *         ������ ���� �߰��Ѵ�.
 *         
 *          super(0, 0);
 */