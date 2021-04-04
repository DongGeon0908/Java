package ex12_more;
/*
 *  [ PrincipalAndInterestUsingFor_Better ]: 입력된 원금, 년수, 이자율에 따라 주어진 년수 동안의 연이율의 복리 이자로 원리합계 구하기
 *  
 *    o 프로그래밍 스타일 4: 년차마다 같은 변수에 원리합계 구하기 
 *                      + for 문 사용
 *                      + 초기원금, 이자률, 년수 등을 입력받음
 */

class Ex4_02_4_PrincipalAndInterestUsingFor_Better   {

	public static void main(String[] args)  {
		System.out.print("\n   **** Calculation of Principal and Interest by Compound Interest ****\n");

		int initPrincipal = 2000000;  // 초기 원금 저장할 변수
		double rate = 0.05;           // 1년간 이자율을 저장할 변수
		int yearDuration = 10;        // 연도저장할 변수
			                                            
		int amount = initPrincipal;    //  처음 주어진 원금
		
		System.out.println("\n\n  ** Principal and interest  ** \n");
		System.out.println("  o Initial principal = " + amount + "(won)\n");
		
		for (int i=1; i <= yearDuration; i++) {     // 년수만큼 반복하여 원리합계 구하기
		    amount = (int) (amount * (1 + rate));       // 원리합계를 정수로 구하기 위해  실수값을 정수값으로 변환
		    System.out.println("  o Principal and interest after " + i + "  year = " + amount + "(won)");
		}
	}
}


/*
 * [ 프로그램의 이해 및 실행  ]
 * 
 *   o 이 프로그램은 주어진 초기 원금, 연이률, 년수에 대하여  주어진 년수까지의 원리합계를 구한다.
 *   
 *   o Ex4_2_3_PrincipalAndInterestUsingFor_ByNovice 프로그램보다 변수 이름이 잘 작명되어 
 *     프로그램의 이해나 변경이 용이하다.
 */


