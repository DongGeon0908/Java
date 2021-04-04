package ex12_more;
/*
 *  [ PrincipalAndInterestAny ]: 입력된 원금, 년수, 이자율에 따라 주어진 년수 동안의 연이율의 복리 이자로 원리합계 구하기
 *    
 *     o 스타일 5: 년차마다 같은 변수에 원리합계 구하기 
 *               + for 문 사용
 *               + 초기원금, 이자률, 년수 등을 입력받음
 */

class Ex4_02_5_PrincipalAndInterestAny   {

	public static void main(String[] args)  {
		System.out.print("\n   **** Calculation of Principal and Interest by Compound Interest ****\n");
		
		int initPrincipal;  // 초기 원금 저장할 변수
		int ratePercent;    // 1년간 이자율을 %로 저장할 변수
		int yearDuration;   // 연도저장할 변수
		
		initPrincipal = SkScanner.getIntWithPrompt("\n   o Input initil Principal > ");  // 초기 원금 입력받음
        ratePercent = SkScanner.getIntWithPrompt("   o Input interest rate per year(%) > ");  // 1년간 이자율을 %로 입력받음
        yearDuration = SkScanner.getInt("   o Input year duration > ");   // 연도를 입력받음

		double rate = (100 + ratePercent) / 100.0;  // 퍼센트로 주어진 이자 연이율을 1년 후의 원리합계 이율로 변경(왜 100.0로 나누는가?) 
		                                            
		int amount = initPrincipal;    //  처음 주어진 원금

		System.out.println("\n\n  ** Principal and interest  ** \n");
		System.out.println("  * Initial principal = " + amount + "(won)");
		System.out.println("  * Interest rate     = " + rate);
		System.out.println("  * Year duration     = " + yearDuration + "\n");

		for (int i=1; i <= yearDuration; i++) {     // 년수만큼 반복하여 원리합계 구하기
			amount = (int) (amount * rate);         // 원리합계를 정수로 구하기 위해  실수값을 정수값으로 변환
			System.out.println("  * Principal and interest after " + i + "  year = " + amount + "(won)");
		}
	}
}

/*
 * [ 실습과제 ]
 *   
 *   o 이 프로그램은 초기 원금, 연이률, 년수를 입력하여 주어진 년수까지의 원리합계를 구한다.
 *   
 *   o 초기원금, 이자률, 그리고 원하는 금액을 입력하여 원하는 금액을 받을 수 있는 것이 
 *     최소 몇년 후인가를 출력하도록 이 프로그램을 수정한 프로그램인 
 *     Pr4_2_5__PrincipalAndInterestHowLongYears 클래스를  작성하라.
 *    
 */


