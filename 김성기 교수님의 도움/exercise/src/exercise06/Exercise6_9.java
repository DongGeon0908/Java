package exercise06;

/**
 * [ 6�� ��������  9 ]:
 *   
 *   9. ���� ���α׷��� �ʵ�� �޼ҵ忡 ���� ���� �߸��� �����Ѵ�. 
 *   
 *      ���α׷����� �߸��� �κ��� �����ϰ� �ùٸ� ���α׷����� ���Ķ�. 
 *      (������ ���α׷��� ������� ���鼭 ������ Ȯ���ϰ� �����϶�)
 */

class A {
	static int i1;
	int i2;
	
	static void m1(int i) {
		this.i1 = i;
	}
	
	void m2(int i) {
		this.i1 = i;
	}
}

class Exercise6_9 {
	public static void main(String[] args) {
		A a;
		a.i1 = 3;
		a.m1(4);
		A.i2 = 5;
		A.m2(6);
	}
}