/**
 *  �� ��Ű���� 10�� ��������  2���� ���� ��Ű����
 */
package p1.p2.p3;

public class C {
	public void output() {
		System.out.println(" * " + this);		
	}
	
	public static void main(String[] args) {
		C c = new C();
		C c1 = new C1();
		C c2 = new C2();
		
		c.output();
		c1.output();
		c2.output();
		
	}
}
