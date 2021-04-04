package exercise07;

/**
 * [ 7�� ��������  2 ]:
 *   
 *   2. ������ ���� Ŭ���� A, B, C�� ����Ǿ��� �� �� Ŭ������ ��� Ư���� ���� Ư���� �����϶�. 
 *      (Object Ŭ�������� ��ӹ޴� Ư���� �����Ѵ�.)
 * 
 * [ 7�� ��������  3 ]:
 *   
 *   3. �������� 2���� ����� Ŭ������ ���Ͽ� ������ ���� ��ü ���������� ����Ǿ���. 
 *      �� ��ü ���������� ������ �� �ִ� ��ü�� Ŭ�������� �����϶�.
 *     
 *     1) A a;    2) B b;   3) C c;  4) Object o;
 *     
 * [ 7�� ��������  4 ]:
 *   
 *   4. �������� 2���� ����� Ŭ������ ���Ͽ� ������ ���� ���α׷��� �ۼ��Ǿ���. 
 *      ���α׷��� ����� ���϶�.   
 *
 */

class A {
	int n = 1, m = 2;
	
	int f1() { return 3; }
}

class B extends A {
	int x = 5; 
	
	int f2() { return 6; }
}

final class C extends B {
	int y = 8; 
	
	int f1() { return 9; } // f1()�� A�� f1() �������̵� 
	
	int f3() { return 10; }
}

class Exercise7_020304 {
	public static void main(String[] args) {
		A a1 = new A();
		A a2 = new B();
		A a3 = new C();
		
		B b1 = new B();
		B b2 = new C();
		
		C c = new C();

		System.out.println(" \n  * a1.f1()=" + a1.f1() + ", a2.f1()=" + a2.f1() + ", a3.f1()=" + a3.f1());
		System.out.println(" \n  * b1.f1()=" + b1.f1() + ", b2.f1()=" + b2.f1());
		System.out.println(" \n  * c.f1()=" + c.f1());
	}
}


 