package exercise09;


/**
 *  * [ 9�� �������� 2]
 * 
 *   2. ������ ���� ó�� ���α׷����� �߸��� ���� �����ϰ� �ùٸ��� ���Ķ�.
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
			System.out.println("���ܰ� �߻���.");
		}
	}
}