/**
 * [ Operation_Assignment ]: 대입 연산의 연습
 *     
 *   o 프로그래밍 스타일 
 *     1) main() 메소드로만 클래스 구성
 *     2) 대입 연산을 수행하여 결과 값 출력
 *     
 *   o 대입 연산은 =, +=, -=, ... 등이 있음
 */

class Ex3_1_07_Operation_Assignment  {
	public static void main(String[] args)  {
								
		int age;
		int balance = 50000, amount = 20000;
		int n = 0x1234_5678;

		System.out.println("\n  ** 대입 연산(=, -=, >>=) **\n");

		System.out.println("  * age = 18          = " + ( age = 18 ));  	    //  ⇒  18
		System.out.println("  * age = age + 1     = " + ( age = age + 1 ));  	//  ⇒  19
		System.out.println();
		
		System.out.println("  * 변수 초기값: balance = " + balance + ", amount = " + amount); 
		System.out.println("  * balance -= amount    := " + ( balance -= amount )); //  ⇒  30000		
		System.out.println();
		
		System.out.printf("  * 변수 초기값: n  = 0x%x \n", ( n ));     //  ⇒ 0x1234_5678;
		System.out.printf("  * n >>= 16  := 0x%x ", ( n >>= 16 ));     //  ⇒  0x1234
		System.out.println();
		
		int thisYear, nextYear;
		System.out.print("\n\n  * 올해 년도 입력(1) > ");
		thisYear = SkScanner.getInt();   // 문장 1) 
		nextYear = thisYear + 1;  		 // 문장 2) 
		
		System.out.println("\n  ** < thisYear = SkScanner.getInt();  nextYear = thisYear + 1; > 수행 후 **");
		System.out.println("  * thisYear := " + thisYear);
		System.out.println("  * nextYear := " + nextYear);
			
		System.out.print("\n\n  * 올해 년도 입력 (2)> ");
		nextYear = (thisYear = SkScanner.getInt()) + 1;  // 이 문장은 위의 문장 1)과 문장 2)의 두 문장을 하나의 문장으로 축약시킨 것임
		System.out.println("\n  ** < nextYear = (thisYear = SkScanner.getInt()) + 1; > 수행 후 **");
		System.out.println("  * thisYear := " + thisYear);
		System.out.println("  * nextYear := " + nextYear);		
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *
 *   o 연산의 결과를 손으로 구해보고 수행한 결과와 비교해 보라.
 *  
 */
