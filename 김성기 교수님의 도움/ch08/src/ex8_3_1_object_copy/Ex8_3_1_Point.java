package ex8_3_1_object_copy;

/**
 * [ Point Ŭ���� ] : Cloneable �������̽��� �����ϴ� Point Ŭ������ �̿��� ��ü ���� ����
 * 
 *   o �������̽�
 *     - public static final �ʵ�� ��������  �޼ҵ常 ������ Ư���� Ŭ����
 *     - ��ü ������ �� ������, �����ϴ� ���� Ŭ�������� ��ü ���� ����
 *     - �������̽� �����ϴ� ���� Ŭ������ �ݵ��  abstract �޼ҵ� �����ؾ� ��
 *     - �������̽��� Ÿ������ ���Ǿ� �������̽� ��ü �������� ������ �� ������,
 *       �������̽� ��ü ���������� ���� Ŭ������ ��ü ����
 *     - �������̽� �����ϴ� ���� ���� Ŭ���� ��ü�� �������̽� ��ü�� �ǹǷ� ���������� ������ �� ����
 *     
 *   o Cloneable �������̽�
 *     - ��ü�� �����ϱ� ���� Object Ŭ������ clone() �޼ҵ� ȣ���Ϸ��� �ݵ�� �����ؾ� �ϴ� �������̽�
 *     - C Ŭ������ ��ü�� �����Ϸ��� ������ ���� �ۼ��ؾ� ��
 *     
 *        class C implements Cloneable {
 *        
 *           ....
 *           
 *        }
 *        
 *     - ��ü�� ������ Ŭ������ Cloneable �������̽��� �����ϰ� clone() �޼ҵ带 �������̵��ϴ� ���� ��Ģ 
 */

// (x, y) �� ���� ��ǥ�� ��Ÿ���� �ʵ�� �����Ǵ� Point Ŭ����
//    �� Ŭ������ Cloneable �������̽��� �����ϹǷ� Object Ŭ������ clone() �޼ҵ带 �̿��Ͽ�
//    ��ü�� ������ �� ����
class Ex8_3_1_Point implements Cloneable { 
	int x, y;	// (x, y) ��ǥ

	Ex8_3_1_Point(int x, int y) {  // ��ü ������
		this.x = x;
		this.y = y;
	}
	
	// Object Ŭ������ clone() �޼ҵ� �������̵� 
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}

	public String toString() {
		return "(" + this.x + ", " + this.y + ")";
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		Ex8_3_1_Point p1 = new Ex8_3_1_Point(5, 20);   // p1�� �����ϴ� Point ��ü ����

		// p1�� ����� Point ��ü�� �����Ͽ� p2�� ����
		Ex8_3_1_Point p2 = (Ex8_3_1_Point) p1.clone(); // clone() �޼ҵ�� ��ü ���� �޼ҵ���, ����� ��ü�� Object ���� Ŭ������ �ٿ�ĳ����

		// p1�� p2�� �ʵ� �� Ȯ��: ����Ǿ����Ƿ� ���ƾ� ��
		System.out.println("  * p1 = " + p1);
		System.out.println("  * p2 = " + p2);
	}
}

/*
 * [ ���α׷� ���� �� ���� ]
 * 
 *   1) clone() �޼ҵ� ȣ���Ϸ��� �ݵ�� Cloneable �������̽��� �����Ͽ��� �Ѵ�.
 *      Point Ŭ������ Cloneable �������̽��� �����Ͽ����� Ȯ���϶�.
 *      
 *   2) �� ���α׷��� clone() �޼ҵ带 �̿��Ͽ� Point ��ü�� �����Ͽ���. 
 *      ���α׷� �����Ͽ� Point ��ü p1�� p2�� �ʵ� ���� �������� Ȯ���϶�.      
 *   
 *   
 * [ �ǽ� ���� ]
 * 
 *   o << class Ex8_3_1_Point implements Cloneable >>���� << implements Cloneable >>�� �����ϸ�
 *      �����Ͽ����� ������ �߻����� ������ ���� �ÿ� ������ �߻����� Ȯ���϶�.
 */
