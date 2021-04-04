package exercise09;


/**
 *  * [ 9장 연습문제 2]
 * 
 *   2. 다음의 예외 처리 프로그램에서 잘못된 것을 지적하고 올바르게 고쳐라.
 */
     
class A {
	int n;
	void f(int n) { 
		if (n>100) {
			A exception = new A(); 
			cast exception; 
		}
		else 
			this.n = n;
	}
}

class Exercise9_2 {
	public static void main(String[] args) {
		A a = new A();
		try {
			a.f(105);
		}
		catch(A e) { 
			System.out.println("예외가 발생함.");
		}
	}
}