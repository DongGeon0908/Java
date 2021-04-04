/**
 * [ TypeConversion_CastInExpression ]: 수식에서의 강제적 타입 변환
 *        
 *   o 프로그래밍 스타일 
 *     1) main() 메소드로만 클래스 구성
 *     2) 강제적 타입 변환을 수행하는 수식의 결과 값 출력
 *       
 *   o 강제적 타입 변환이 필요한 경우
 *     - 연산자를 특정 타입에 대한 연산자로 작동시킬 경우 
 *     - 의도적인 정보 손실을 유발하는 경우(강한 타입의 값을 약한 타입 값으로, 의도적 소수점 이하 버림 등)
 *     
 *   o Java에서의 약한 타입과 강한 타입 관계 
 *       byte ≪ char/short ≪ int  ≪  long  ≪  float  ≪  double      
 *       
 *   o 수식에서도 강제적 타입변환 
 *     - 강제적 타입변환 필요한 경우 종종 발생
 *     - 이 경우 캐스트 집적 명시하여 타입변환 실시
 */

class Ex3_3_3_TypeConversion_CastInExpression  {
	public static void main(String[] args)  {

		System.out.println("\n  ** 강제적 타입 변환을 수행하는 수식 **\n");
		
		/*
		 * 연산자를 특정 타입에 대한 연산자로 작동시킬 경우의 캐스트 예
		 */
		int sum = 894;
		int n = 10;
		double avg;
		System.out.println("  * 변수 초기값: sum = " + sum + ", n = " + n); 
		System.out.println("  * avg = sum / (double) n  := " + (  avg = sum / (double) n ));      // n의 int 값을 double 값으로 변환하여 실수 나누기 수행
		System.out.println();
		
		/*
		 * 의도적인 정보 손실을 유발하는 경우의 캐스트 예
		 */
		int amount = 1000000;
		double rate = 0.04;   
		System.out.println("  * 변수 초기값: amount = " + amount + ", rate = " + rate); 

		System.out.println("  * amount = (int) ( amount * (1 + rate) )     := " + ( amount = (int) ( amount * (1 + rate) ) ));      // 실수 값을 정수 변수에 저장하기
		System.out.println("  * amount = amount + (int) ( amount * rate )) := " + ( amount = amount + (int) ( amount * rate ) ));   //   위해 의도적 정보 손실 유도
		System.out.println();

		double pi = 3.141592;		
		System.out.println("  * 변수 초기값: pi = " + pi); 

		System.out.println("  * (int) ( (pi + 0.005) * 100 ) / 100.0   := " + ( (int) ( (pi + 0.005) * 100 ) / 100.0 ));  // 반올림 위해 의도적 정보 손실 유도
		System.out.println();
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *
 *   1) 수식의 결과를 손으로 구해보고 수행한 결과와 비교해 보라.
 *   
 *   2) 수식에서 강제적 타입 변환의 필요성을 이해하라.
 *  
 */
