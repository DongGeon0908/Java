package exercise08;

/**
 * [ 8장 연습문제 2 ]
 * 
 *   2. 다음과 같은 클래스와 인터페이스가 선언되었다. 물음에 답하라.
 *   
 *      1) CS 클래스의 상위 클래스와 상위 인터페이스를 모두 나열하라.
 *      
 *      2) CSS 클래스의 상위 클래스와 상위 인터페이스를 모두 나열하라.
 *      
 *      3) 주어진 클래스와 인터페이스에 대한 클래스 계층과 인터페이스 계층을 그림으로 그려라.
 *      
 *      4) 다음 프로그램의 출력을 구하라.
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