/**
 * [ PrincipalAndInterest_InOut ]: 5년 동안의 복리 원리합계 구하기
 * 
 *   o 프로그래밍 스타일
 *     1) 변수 사용 스타일 1: 년차마다 다른 변수에 원리합계 구하기
 *     2) 원금과 이자율 입력하여 5년 동안 원리합계 구하여 출력
 *  
 *   o 원리합계의 계산 
 *     - 원리합계: 원금과 이자를 더한 금액
 *     - 복리: 이자에 대해서도 이자가 붙는 이자 지급방식
 *            (참조 - 단리: 원금에 대해서만 이자가 붙는 방식)
 *     - 다음 연도의 원리합계   = 이전 연도의 원리합계  + (이전 연도의 원리합계 * 1년간 이자율)   
 *                       = 이전 연도의 원리합계  * (1 + 1년간 이자율)
*/

class Ex3_4_2_PrincipalAndInterest_InOut {
   public static void main(String[] args) {

	   System.out.println("\n  **** Calculation of Principal and Interest " +
	   		"by Compound Interest ****\n");  	// 전체  타이틀 출력      

	   int amount0;         //  초기 원금
	   int amount1, amount2, amount3, amount4, amount5;  // 매년 원리합계 저장 변수
	   double ratePercent;  // 퍼센트 이자율
	   double rate;         // 이자율

	   System.out.print("  o Input initial principal > ");
	   amount0 = SkScanner.getInt();            // 초기 원금 입력받음

	   System.out.print("  o Input interest rate per year (%) > ");  
	   ratePercent = SkScanner.getDouble();     // 1년간 퍼센트 이자율을 입력받음
	   rate = ratePercent / 100;

	   amount1 = (int) ( amount0  + amount0 * rate );  // double 값을 int 변수에 저장하기 위해 반드시 캐스트시켜야함
	   amount2 = (int) ( amount1  + amount1 * rate );  //   amount1 * rate는 double 타입의 값  
	   amount3 = (int) ( amount2  + amount2 * rate );  //   amount2  + amount2 * rate도 double 타입의 값
	   amount4 = (int) ( amount3  + amount3 * rate );  //   double 타입의 값은 int 변수에 저장되지 못함
	   amount5 = (int) ( amount4  + amount4 * rate );  //   ⇒ 캐스트 필요함

	   System.out.println("\n  * Initial Principal = " + amount0 + "(won)");
	   System.out.println("  * Interest Rate     = " + rate + "\n");

	   System.out.println("  * Principal and Interest after 1 year  = " + amount1 + "(won)");
	   System.out.println("  * Principal and Interest after 2 years = " + amount2 + "(won)");
	   System.out.println("  * Principal and Interest after 3 years = " + amount3 + "(won)");
	   System.out.println("  * Principal and Interest after 4 years = " + amount4 + "(won)");
	   System.out.println("  * Principal and Interest after 5 years = " + amount5 + "(won)");
   }
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *
 *   1) 주어진 프로그램 살펴보고 프로그램의 내용 파악하라.
 *       
 *   2) 프로그램 실행하여 결과 확인하라.
 *
 *
 * [ 실습과제 ]
 *
 *   1) 이 프로그램은 원금과 이자율을 한번만 입력받아 원리합계 출력하고 종료한다.
 *      원금과 이자율 입력, 원리합계의 출력을 여러 번 반복하여 프로그램을 실행할 수 있도록 변경하라. 
 *   
 *   2) 이 프로그램은 매년 마다의 원리합계만 출력한다. 
 *      원리합계뿐 아니라 이전 년도와 다음 년도의 원리합계 차이도 출력하도록 프로그램으로 변경하라.
 *      
 *   3) 10년 동안 매년마다 복리 이자를 더한 원리합계 구하여 출력하는 프로그램으로  변경하라. 
 *   
 *      만약 50년 동안 또는 100년 동안의 원리합계를 구하는 프로그램으로 변경한다면 
 *      쉽게 할 수 있겠는가? 할 수 있다고 생각되는 것까지 변경해보라.
 *      
 *      (변경을 정확하고 쉽게 할 수 있는 요령을 반드시 터득해야 함)
 *      
 * 
 * [ 참고사항 ]
 *
 *   o 실습과제를 할 때에는 주어진 프로그래밍 스타일을 이용하여 프로그램을 작성하여야 한다. 
 *            
 */
