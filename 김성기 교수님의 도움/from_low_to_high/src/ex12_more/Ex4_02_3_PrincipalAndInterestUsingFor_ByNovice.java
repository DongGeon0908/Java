package ex12_more;
/*
 * [ PrincipalAndInterestUsingFor_ByNovice ]: 0.05 연이율의 복리 이자로 10년까지의 원리합계 구하기 
 *  
 *    o 프로그래밍 스타일 3: 년차마다 같은 변수에 원리합계 구하기 
 *                      + for 문 사용
 *     
 *    o 이 프로그램은 좋은 프로그래밍 스타일을 모르는 초보자가 작성한 난해한 프로그램임
 *      ( 이렇게 프로그램을 작성하면 절대 안됨, 아무리 간단한 프로그래이라 하더라도
 *        변수명, 메소드명, 클래스명 등이 제대로 작명되어야 하며, good styling programmer 
 *        자질을 갖추기 위해 노력해야 함 )  
 */

class Ex4_02_3_PrincipalAndInterestUsingFor_ByNovice  {
	public static void main(String[] args)  {

		int a = 2000000; 
		System.out.println(a);

		for (int i=1; i <= 10; i++) {   
			a = (int) (a * 1.05);
			System.out.println(i + ": " + a);
		}
	}
}
     
 /*
  * [  프로그램의 이해 및 실행]
  *  
  *  o 이 프로그램의 문제점들
  *    1) i는 for 문 제어변수이지만, a 변수가 어떠한 용도로 사용되는지 알 수 없다.
  *    2) < a = 2000000; >에서 a 변수에 2000000을 저장하는 이유를 알기 어렵다.
  *    3) < a * 1.05 >에서 1.05를 곱하는 이유를 알 수 없다.
  *    4) < a = (int) (a * 1.05) >을 10번 반복 수행하여 계속 저장하는 이유가 무엇인지 알기 어렵다.
  *         특히, (int)로 강제 타입변환 cast를 수행하는 이유를 알 수 없다.
  *    5) < System.out.println("  "+ i + ":" + a); >을 출력하는 이유는 무엇인가를 고민해야 한다.
  *    6) 이 프로그램은 단순히 cast, for 등을 연습하는 프로그램으로 보인다.
  *    7) 원금, 이자율, 년수 등을 변경하려 하면 프로그램의 특정 부분으로 찾아가 수정해야 한다.
  *       ( 이 프로그램은 라인수가 많지 않지만, 만약 라인수가 200라인 정도 되는 프로그램이라면
  *         그 부분을 찾기가 쉽지 않을 수 있음 )

  *  o 잘 작성된 프로그램
  *    - 다음의 잘 작성된 다음의 프로그램은 초보자가 작성한 프로그램의 모든 문제점을 해결한다
  *    - 이러한 스타일을 작성하도록 노력해야 함
  *     
    class Ex4_2_4_PrincipalAndInterestUsingFor_Better  {
   	  public static void main(String[] args)  {
   		System.out.print("\n   **** Calculation of Principal and Interest by Compound Interest ****\n");
   		
   		int initPrincipal = 2000000;  // 초기 원금 저장할 변수
   		double ratePercent = 0.05;    // 1년간 이자율을 저장할 변수
   		int yearDuration = 10;        // 연도저장할 변수
   		                                            
   		int amount = initPrincipal;    //  처음 주어진 원금
   
   		System.out.println("\n\n  ** Principal and interest  ** \n");
   		System.out.println("  o Initial principal = " + amount + "(won)\n");
    
   		for (int i=1; i <= yearDuration; i++) {     // 년수만큼 반복하여 원리합계 구하기
   			amount = (int) (amount * (1 + rate));          // 원리합계를 정수로 구하기 위해  실수값을 정수값으로 변환
   			System.out.println("  o Principal and interest after " + i + "  year = " + amount + "(won)");
   	    }
      }
    }
  *  
  */
