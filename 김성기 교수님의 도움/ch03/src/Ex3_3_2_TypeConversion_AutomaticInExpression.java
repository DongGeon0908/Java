/**
 * [ TypeConversion_AutomaticInExpression ]: 수식에서의 자동적 타입변환 확인하기
 *        
 *   o 프로그래밍 스타일 
 *     1) main() 메소드로만 클래스 구성
 *     2) 자동적 타입 변환이 발생하는 수식의 결과 값 출력
 *       
 *   o 자동적 타입 변환이 발생하는 경우
 *     - 산술 연산과 비교 연산에서 피연산자 타입이 다를 경우: 약한 타입의 값이 강한 타입의 값으로 변환
 *     - 대입 연산에서 약한 타입의 값이 강한 타입의 변수에 저장될 경우: 약한 타입의 값이 강한 타입의 값으로 변환
 *     - 문자열 접속 연산에서 문자열과 문자열이 아닌 값을 접속시킬 경우: 문자열이 아닌 값이 문자열로 변환
 *     
 *   o Java에서의 약한 타입과 강한 타입 관계 
 *        byte ≪ char/short ≪ int  ≪  long  ≪  float  ≪  double
 *        
 *   o 수식에서의자동적 타입 변환
 *     - 연산에서의 자동적 타입변환과 동일
 *     - 복잡한 수식인 경우 자동적 타입변환이 여러 번 발생 
 */

class Ex3_3_2_TypeConversion_AutomaticInExpression  {
	public static void main(String[] args)  {

		System.out.println("\n  ** 자동적 타입 변환을 수행하는 수식 **\n");
		
		/*
		 * 산술 연산이 포함된 수식에서의 자동적 타입 변환
		 */		
		int amount = 1000000;
		double rate = 0.04;
		System.out.println("  * 변수 초기값: amount = " + amount + ", rate = " + rate);  
			
		System.out.println("  * amount * (1 + rate) := " + ( amount * (1 + rate) ));  // (1 + rate): 정수값 + 실수값, ( amount * (1 + rate) ): 정수값 * 실수값
		System.out.println();
		
		/*
		 * 대입 연산과 비교 연산이 포함된 수식에서의 자동적 타입 변환
		 */		
		int sumScores = 894,  maxScore = 99, noStudents = 10;
		double avgScores;
		System.out.println("  * 변수 초기값: sumScores = " + sumScores + ", maxScore = " + maxScore + ", noStudents = " + noStudents); 
		
		System.out.println("  * avgScores = sumScores / noStudents := " + ( avgScores = sumScores / noStudents )); // avgScores = sumScores / noStudents: 실수변수 = 정수값
		System.out.println("  * avgScores + 10 > maxScore - 10 := " + ( avgScores + 10 > maxScore - 10 )); // avgScores + 10: 실수값 + 정수값, ( avgScores + 10 > maxScore - 10 ): 실수값 > 정수값 
		System.out.println();
					
		/*
		 * 문자열 접속 연산이 포함된 수식에서의 자동적 타입 변환
		 */	
		int thisYear = 2016;
		System.out.println("  * 변수 초기값: thisYear = " + thisYear); 
		
		System.out.println("  * \"10년 후의 연도는\" + (thisYear + 10) := " + ( "10년 후의 연도는 " + (thisYear + 10) )); // ( "10년 후의 연도는 " + (thisYear + 10): 문자열 + 정수값	
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *
 *   1) 수식의 결과를 손으로 구해보고 수행한 결과와 비교해 보라.
 *   
 *   2) 수식에서 자동적 타입변환이 일어나는 부분을 정확히 파악하라. 
 *  
 */
