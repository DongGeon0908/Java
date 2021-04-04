/**
 * [ Operation_BitWiseLogical ]: 비트별 논리 연산의 연습
 *   
 *   o 프로그래밍 스타일 
 *     1) main() 메소드로만 클래스 구성
 *     2) 정수 값에 대한 비트별 논리 연산을 수행하여 결과 값 출력
 *     
 *   o 비트별 논리 연산은 boolean 값에 대한 &, |, ^, ~가 있음
 */

class Ex3_1_04_Operation_BitWiseLogical  {
	public static void main(String[] args)  {

		int bits1 = 0b1111_0000_1100_0011;
		int bits2 = 0b1100_0011_0101_1010;

		System.out.println("\n  ** 정수에 대한 비트별 논리 연산(&, |, ^, ~) **\n");
		
		System.out.printf("  * 변수 초기값: bits1 = 0x%x \n", bits1);
		System.out.printf("  * 변수 초기값: bits2 = 0x%x \n", bits2);
		System.out.println();
		
		System.out.printf("  * bits1 & bits2  := 0x%x \n", ( bits1 & bits2 )); 	
		System.out.printf("  * bits1 | bits2  := 0x%x \n", ( bits1 | bits2 )); 	
		System.out.printf("  * bits1 ^ bits2  := 0x%x \n", ( bits1 ^ bits2 )); 
		System.out.println();

		System.out.printf("  * ~ bits1 := 0x%x \n", ( ~ bits1 )); 
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *
 *   o 연산의 결과를 손으로 구해보고 수행한 결과와 비교해 보라.
 *   
 *   
 * [ 참고사항 ]
 *  
 *   o 이 프로그램에서는 System.out.printf() 메소드를 사용하여 연산 결과를 16진수로 출력한다. 
 *   
 *     - printf() 함수는 C 언어에서 사용하는 함수이며, Java에서도 사용할 수 있다. 
 *     
 *     - printf() 메소드는  C 언어에서와 같이 첫번째 문자열 속 % 다음 포맷 문자에 따라 다음 위치에 주어지는 값들을 
 *       포맷 문자가 지정하는 양식으로 출력한다. 
 *     
 *     - 예제 프로그램의 << System.out.printf("  * 변수 초기값: bits1 = 0x%x \n", bits1); >>에서 
 *       첫번째 문자열 속 % 다음 포맷 문자 x는 16진수 양식으로 출력하게 하므로 bits1은 16진수로 출력된다.
 *     
 *     - printf() 메소드의 사용법은 println()에 비해 다소 복잡한데, 사용법은 Java 프로그래밍을 
 *       이해하면 스스로 익힐 수 있으므로 더 이상 설명하지는 않는다.
 */
