/**
 * [ AutomaticTypeConversion_ArithmeticComparative ]: 사칙 연산과 비교 연산에서의 자동적 타입 변환
 *        
 *     o 프로그래밍 스타일 
 *       1) main() 메소드로만 클래스 구성
 *       2) 자동적 타입변환이 발생하는 사칙 연산과 비교 연산의 결과 값 출력
 *       
 *     o 자동적 타입변환 발생하는 경우
 *       - 산술 연산과 비교 연산에서 피연산자 타입 다를 경우: 약한 타입의 값이 강한 타입의 값으로 자동 변환
 *          (단, byte, char, short 타입의 경우 항상 int 타입 값으로 변환되어 int 결과 생성)
 *       - 대입 연산에서 약한 타입의 값이 강한 타입의 변수에 저장될 경우: 약한 타입의 값이 강한 타입의 값으로 자동 변환
 *       - 문자열 접속 연산에서 문자열과 문자열이 아닌 값을 접속시킬 경우: 문자열이 아닌 값이 문자열로 자동 변환
 *     
 *     o Java에서의 약한 타입과 강한 타입 관계 
 *        byte ≪  char/short ≪  int ≪  long ≪  float ≪  double      
 */

class Ex3_2_1_AutomaticTypeConversion_ArithmeticComparative  {
	public static void main(String[] args)  {

		System.out.println("\n  ** 자동적 타입 변환을 수행하는 사칙 연산과 비교 연산 **\n");
		
		/*
		 * 사칙 연산과 비교 연산에서의 자동적 타입 변환
		 */		
		byte b = 6; 
		short s = -8; 
		float f = 2.5F;
												
		System.out.println("  * 변수 초기값: b = " + b + ", s = " + s + ", f = " + f); 
		System.out.println();
	
		System.out.println("  * 177.7 + 8 := " + ( 177.7 + 8 )); // int 타입의 8이 double 8.0으로 변환
		System.out.println("  * f - 3     := " + ( f - 3 ));     // int 타입의 3이 float 3.0F로 변환
		System.out.println("  * b * 2L    := " + ( b * 2L ));    // b의 byte 6이 long 6L로 변환
		System.out.println("  * s % b     := " + ( s % b ));     // s의 short -8과 b의 byte 6이 모두 int -8과 6으로 변환, 결과 타입 int
		System.out.println();
		
		System.out.println("  * f == 2.5  := " + ( f == 2.5 )); // f의 float 2.5F가 double 2.5로 변환
		System.out.println("  * f >= 2    := " + ( f >= 2 ));   // int 2가 float 2.0F로 변환
		System.out.println("  * s <= -10  := " + ( s < -10 ));  // s의 short -8이 int -8로 변환
		System.out.println("  * s != b    := " + ( s != b ));   // s의 short -8과 b의 byte 6이 모두 int -8과 6으로 변환
		System.out.println();		
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *
 *   o 연산의 결과 손으로 구해보고 수행한 결과와 비교해 보라.
 *   
 *   o 자동적 타입변환이 발생되는 내용 이해하라.
 *  
 */

