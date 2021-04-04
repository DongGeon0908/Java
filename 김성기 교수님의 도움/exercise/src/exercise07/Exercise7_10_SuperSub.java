package exercise07;

/**
 * [ 7장 연습문제  10]:
 *   
 *   10. 하위 클래스 SubC가 다음과 같이 작성되었다. 
 *   
 *     1) SubC 클래스와 main() 메소드를 참조하여 SuperC 클래스를 작성하라.
 *     
 *     2) 작성된 SuperC 클래스와 이미 작성된 SubC 클래스에 의해 main()의 출력을 구하라.
 */

class SuperC {
	// SubC 클래스와 main() 메소드를 참조하여 SuperC 클래스를 작성하라.
}

class SubC extends SuperC {
	int f3, f4; 
	
	SubC(double f1, double f2, int f3, int f4) {
		super(f1, f2);
		this.f3 = f3; this.f4 = f4;
	}
	
	double getSum() {
		return super.getSum() + f3 + f4;
	}

	double getLast() {
		return f4;
	}
}


class Exercise7_10_SuperSub {

	public static void main(String[] args) {
		SuperC o = new SubC(1.0, 2.0, 3, 4);

		System.out.println("\n  * first field: " + o.getFirst() + ", last field: " 
				+ o.getLast() + ", 합: " + o.getSum() );
	}
}