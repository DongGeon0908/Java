package exercise08;

/**
 * [ 8�� �������� 2 ]
 * 
 *   2. ������ ���� Ŭ������ �������̽��� ����Ǿ���. ������ ���϶�.
 *   
 *      1) CS Ŭ������ ���� Ŭ������ ���� �������̽��� ��� �����϶�.
 *      
 *      2) CSS Ŭ������ ���� Ŭ������ ���� �������̽��� ��� �����϶�.
 *      
 *      3) �־��� Ŭ������ �������̽��� ���� Ŭ���� ������ �������̽� ������ �׸����� �׷���.
 *      
 *      4) ���� ���α׷��� ����� ���϶�.
 */

class C {
	int n;
}

interface IF {
	int f1();
}

interface IFS extends IF {
	int f2();
}

class CS extends C implements IF {
	int m = 1;
	
	public int f1() { return 5; }
}

class CSS extends CS implements IFS {
	int m = 2;
	
	public int f1() { return 6; }
	public int f2() { return 7; }
	int f() { return 8; }
}

class Exercise8_2_Interfaces{
	public static void main(String[] args) {
		CS cs1 = new CS();
		CS cs2 = new CSS();
		System.out.println("\n  * cs1.f1() = " + cs1.f1() + ", cs2.f1() = " + cs2.f1());

		IF if1 = new CS();
		IF if2 = new CSS();
		System.out.println("\n  * if1.f1() = " + if1.f1() + ", if2.f1() = " + if2.f1());

		IFS is1 = new CSS();
		System.out.println("\n  * is1.f1() = " + is1.f1());
	}
}