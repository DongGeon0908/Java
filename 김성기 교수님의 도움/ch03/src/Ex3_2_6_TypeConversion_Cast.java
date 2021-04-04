/**
 * [ TypeConversion_Cast ] : 강제적 타입 변환
 *        
 *   o 프로그래밍 스타일 
 *     1) main() 메소드로만 클래스 구성
 *     2) 강제적 타입 변환시키고 결과 확인
 *       
 *   o 강제적 타입변환의 필요성
 *     1) 산술 연산자를 특정 타입에 대한 연산자로 작동시키기
 *        - +, -, *, /, % 등의 산술 연산은 피연산자 타입에 따라 다른 연산으로 작동하여 결과가 달라짐
 *        - 피연산자 타입을 무시하고 특정 타입의 연산으로 작동시키기 위하여 피연산자를 캐스트시킴 
 *          
 *     2) 의도적인 정보 손실 유발하기
 *        - 대입 연산에서 강한 타입의 값을 약한 타입의 변수에 저장할 때에는 반드시 강제적 타입변환이 필요하며, 
 *          이 때 정보 손실이 발생함
 *        - 정보 손실을 이용한 계산이 필요한 경우 캐스트시킴
 *        
 *   o 약한 타입과 강한 타입 관계 
 *        byte ≪  char/short ≪ int ≪  long ≪  float ≪  double       
 */

class Ex3_2_6_TypeConversion_Cast  {
	public static void main(String[] args)  {

		int sum = 894;
		int n = 10;
		double avg = 89.4;

		/*
		 * 캐스트의 예
		 */
		System.out.println("\n  ** 강제적 타입 변환시키고 결과 확인 **\n");
		System.out.println("  * 변수 선언: int sum = 894;  int n = 10;  double d = 89.4;");					
				
		System.out.println("  * 캐스트: (double) n  := " + (  (double) n ));  // n의 int 값을 double 값으로  변환
		System.out.println("  * 캐스트: (int) avg   := " + ( (int) avg ));    // avg의 double 값을 int 값으로  변환
		System.out.println();
		
		/*
		 * 특정 연산자로 작동시키기 위한 캐스트의 예
		 */
		System.out.println("\n  ** 산술 연산자를 특정 타입에 대한 연산자로 작동시키기 **\n");
		
		System.out.println("  * 정수 나누기: sum / n           := " + (  sum / n ));  	         // 정수 나누기가 수행되어 정수 결과가 구해짐
		System.out.println("  * 실수 나누기: sum / (double) n  := " + (  sum / (double) n ));  // n의 int 값을 double 값으로 변환하면 실수 나누기가 수행되어 실수 결과 구해짐	
		
		/*
		 *  의도적인 정보 손실을 유발하여 계산하는, 정보 손실을 이용한 예 
		 */
		double pi = 3.14;  
		System.out.println("\n  ** 의도적인 정보 손실 유발하기: 정보 손실을 이용하여  필요한 계산을 수행 **\n");
		System.out.println("  * 변수 선언: double pi = 3.14;");					

		System.out.println("  * pi의 정수 부분 구하기: (int) pi := " + ( (int) pi) );            // pi의 정수 부분 구하기 위해 정보 손실 유발함
		System.out.println("  * pi의 소수 부분 구하기: pi - (int) pi := " + ( pi - (int) pi ));  // pi의 소수 부분 구하기 위해 정보 손실 유발함


		int amount = 12345; double rate = 0.01; // 원금과 이자율
		System.out.println("\n  * 변수 선언: int amount = 12345; double rate = 0.01;  // 원금과 이자율");					

		System.out.println("  * 1년 후 이자  구하기 : (amount * rate) := " + ( (amount * rate) ));                   // 이자를 실수로 구하기	
		System.out.println("  * 1년 후 이자 정수로 구하기 : (int) (amount * rate) := " + ( (int) (amount * rate) ));  // 이자를 정수로 구하기 위한 의도적 정보 손실		
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *
 *   o 캐스트의 결과를 손으로 구해보고 실행한 결과와 비교해 보라.
 *   
 *   o 강제적 타입변환인 캐스트의 필요성을 확인하라.
 *  
 */

