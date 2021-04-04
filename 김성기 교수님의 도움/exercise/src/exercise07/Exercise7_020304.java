package exercise07;

/**
 * [ 7장 연습문제  2 ]:
 *   
 *   2. 다음과 같이 클래스 A, B, C가 선언되었을 때 각 클래스의 상속 특성과 고유 특성을 나열하라. 
 *      (Object 클래스에서 상속받는 특성은 제외한다.)
 * 
 * [ 7장 연습문제  3 ]:
 *   
 *   3. 연습문제 2에서 선언된 클래스에 대하여 다음과 같은 객체 참조변수가 선언되었다. 
 *      각 객체 참조변수가 참조할 수 있는 객체의 클래스들을 나열하라.
 *     
 *     1) A a;    2) B b;   3) C c;  4) Object o;
 *     
 * [ 7장 연습문제  4 ]:
 *   
 *   4. 연습문제 2에서 선언된 클래스에 대하여 다음과 같은 프로그램이 작성되었다. 
 *      프로그램의 출력을 구하라.   
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
	
	int f1() { return 9; } // f1()은 A의 f1() 오버라이딩 
	
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


 