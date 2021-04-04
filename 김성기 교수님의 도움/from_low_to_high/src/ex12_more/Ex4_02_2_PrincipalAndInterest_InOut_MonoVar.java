package ex12_more;
/*
 * [ PrincipalAndInterest_InOut_MonoVar ]: 5년 동안의 복리 원리합계 구하기
 * 
 *   o 프로그래밍 스타일 2
 *     1) 변수 사용 스타일: 년차마다 원리합계를 저장할 변수 하나만 사용
 *     2) 원금과 이자율을 입력하여 5년동안 원리합계 구하여 출력
 *    
 *  
 *   o  원리합계의 계산 
 *      - 원리합계: 원금과 이자를 더한 금액
 *      - 복리: 이자에 대해서도 이자가 붙는 이자 지급방식
 *              (참조 - 단리: 원금에 대해서만 이자가 붙는 방식)
 *      - 다음 연도의 원리합계 = 이전 연도의 원리합계 + (이전 연도의 원리합계 * 1년간 이자율)   
*/

class Ex4_02_2_PrincipalAndInterest_InOut_MonoVar {
   public static void main(String[] args)  {

	   System.out.println("\n  **** Calculation of Principal and Interest by Compound Interest ****\n");  	// 입력을 위한 타이틀 출력      

	   int amount;        // 초기 원금과 매 년말의 원리합계를 저정하는 변수
	   int ratePercent;   // % 이자율
	   double rate;       // 이자율 = % 이자율 / 100.0

	   System.out.print("  o Input initial Principal > ");
	   amount = SkScanner.getInt();  // 초기 원금 입력받음

	   System.out.print("\n  o Input interest rate per year(%) > ");  
	   ratePercent = SkScanner.getInt();  // 1년간 이자율을 %로 입력받음
	   rate = ratePercent / 100.0;        // % 이자율을 실수 이자율로 변환

	   System.out.println("\n  * Initial Principal = " + amount + "(won)");
	   System.out.println("  * Interest Rate     = " + rate + "\n");

	   amount = (int) ( amount  + amount * rate );  // double 값을 int 변수에 저장하기 위해 반드시 캐스트시켜야함
	   System.out.println("  * Principal and Interest after 1 year  = " + amount + "(won)");

	   amount = (int) ( amount  + amount * rate );  
	   System.out.println("  * Principal and Interest after 2 years = " + amount + "(won)");

	   amount = (int) ( amount  + amount * rate );  
	   System.out.println("  * Principal and Interest after 3 years = " + amount + "(won)");

	   amount = (int) ( amount  + amount * rate ); 
	   System.out.println("  * Principal and Interest after 4 years = " + amount + "(won)");

	   amount = (int) ( amount  + amount * rate ); 
	   System.out.println("  * Principal and Interest after 5 years = " + amount + "(won)");

   }
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *
 *   1) 주어진 프로그램을 살펴보고 프로그램의 내용를 파악하라.
 *      
 *   2) 프로그램을 실행하여 원금과 이자율을 입력하여 결과를 확인하라.
 *   
 *   3) 새로운 원리합계와 이자율에 대해 여러 번 반복하여 프로그램을 실행할 수 있도록 변경하라.
 *
 *
 * [ 실습과제 ]
 *
 *   1) 이 프로그램은 원금과 이자율을 한번만 입력받아 원리합게를 출력하고 종료한다.
 *      원금과 이자율 입력, 원리합계의 출력을 여러 번 반복하여 프로그램을 실행할 수 있도록 변경하라. 
 *   
 *   2) 이 프로그램은 매년 마다의 원리합계만을 출력한다. 그런데 원리합계뿐 아니라
 *      이전 년도와 다음 년도의 원리합계 차이도 출력하도록  프로그램으로 변경하라.
 *      
 *      이를 위해서는 다음 년도의 원리합게를 구하기 전에 이전 년도의 원리합계를 다른 변수에 저장하여야 한다. 
 *      
 *   3) 15년 동안 매년마다 복리 이자를 더한 원리합계 구하여 출력하는 프로그램으로 
 *      변경하라. 
 *   
 *      만약 50년 동안 또는 100년 동안의 원리합계를 구하는 프로그램으로 변경한다면 
 *      쉽게 할 수 있겠는가? 할 수 있다고 생각되는 것까지 변경해보라.
 *      
 *      (변경을 정확하면서 쉽게 할 수 있는 요령을 반드시 터득해야 함)
 * 
 *      
 * [ 참고사항 ]
 * 
 *   o 실습과제를 할 때에는 주어진 프로그래밍 스타일을 이용하여 프로그램을 작성하여야 한다. 
 *   
 *   
 *  [ 스스로 생각하고 고민해볼 과제 ] 
 *  
 *    o 이 프로그램에서는 원금, 이자율, 년도 등을 입력받기 위한 부분이 모두 
 *      (1) 프롬프트 메시지를 출력하는 문장 (2) getInt() 메소드로 입력하여 변수에 저장하는 문장 
 *      등 2개의 문장으로 작성되어 있다. 즉, 필요한 값을 입력하기 위해서는 항상 2 문장을 작성해야 한다.
 *     
 *      만약 프롬프트 메시지 출력하는 문장을 생략하는 것으로 간소화시키면 어떻게 되겠는가?
 *        
 *    o  이러한 입력 작업을 보다 편리하게 할 수 있는 방법이 있겠는가?  그 방안을 고민해보시오.(이것은 과제가 아님)
 *       좋은 해결책이 있으면 다른 프로그램에서도 이를 활용 여부를 고민해보시오.
 *          
 *            
 */


    