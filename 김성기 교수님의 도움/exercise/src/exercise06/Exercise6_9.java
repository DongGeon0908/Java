package exercise06;

/**
 * [ 6장 연습문제  9 ]:
 *   
 *   9. 다음 프로그램은 필드와 메소드에 대한 여러 잘못을 포함한다. 
 *   
 *      프로그램에서 잘못된 부분을 지적하고 올바른 프로그램으로 고쳐라. 
 *      (실제로 프로그램을 수행시켜 보면서 오류를 확인하고 수정하라)
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