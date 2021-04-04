/**
 * [ Operation_Shift ]: 쉬프트 연산의 연습 
 * 
 *   o 쉬프트 연산은 정수 값에 대한 >>, <<, >>>가 있음
 *     
 *   o 프로그래밍 스타일 
 *     1) main() 메소드로만 클래스 구성
 *     2) 정수 값에 대한 쉬프트 연산을 수행하여 결과 값 출력 
 */

class Ex3_1_06_Operation_Shift  {
	public static void main(String[] args)  {
						
		int bits1 = 0b1111_0000_1100_0011;  // 0xF0C3 
		int bits2 = 0xFFFF_FFFF;   // 32비트 모두가 1인 정수로 -1임

		System.out.println("\n  ** 쉬프트 연산(<<, >>, >>>) **\n");

		System.out.printf("  * 변수 초기값: bits1 = 0x%x = %d \n", bits1, bits1);
		System.out.printf("  * 변수 초기값: bits2 = 0x%x = %d\n", bits2, bits2);
		System.out.println();
		
		System.out.printf("  * bits1 << 1  := 0x%x = %d \n",
				( bits1 << 1 ), ( bits1 << 1 )); // 1비트 왼쪽으로 이동 후 오른쪽 1비트 0으로 채움
		System.out.printf("  * bits1 << 4  := 0x%x = %d \n", 
				( bits1 << 4 ), ( bits1 << 4 )); // 4비트 왼쪽으로 이동 후 오른쪽 4비트 0으로 채움	
		System.out.printf("  * bits1 << 8  := 0x%x = %d \n", 
				( bits1 << 8 ), ( bits1 << 8 )); // 8비트 왼쪽으로 이동 후 오른쪽 8비트 0으로 채움	
		System.out.printf("  * bits2 << 8  := 0x%x = %d \n", 
				( bits2 << 8 ), ( bits2 << 8 )); // 8비트 왼쪽으로 이동 후 오른쪽 8비트 0으로 채움		
		System.out.printf("  * bits2 << 16 := 0x%x = %d \n", 
				( bits2 << 16 ), ( bits2 << 16 )); // 16비트 왼쪽으로 이동 후 오른쪽 16비트 0으로 채움		
		System.out.println();
		
		System.out.printf("  * bits1 >> 4  := 0x%x = %d \n",
				( bits1 >> 4 ), ( bits1 >> 4 )); // 4비트 오른쪽으로 이동 후 왼쪽 4비트 부호비트 0으로 채움	
		System.out.printf("  * bits1 >> 8  := 0x%x = %d \n",
				( bits1 >> 8 ), ( bits1 >> 8 )); // 8비트 오른쪽으로 이동 후 왼쪽 8비트 부호비트 0으로 채움	

		System.out.println();
		System.out.printf("  * bits2 >> 8  := 0x%x  = %d\n", 
				( bits2 >> 8 ),  ( bits2 >> 8 )); // 8비트 오른쪽으로 이동 후 왼쪽 8비트 부호비트 0으로 채움		
		System.out.printf("  * bits2 >>> 8 := 0x%x = %d\n", 
				( bits2 >>> 8 ), ( bits2 >>> 8 ));// 8비트 오른쪽으로 이동 후 왼쪽 8비트 무조건 0으로 채움 
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *
 *   o 연산의 결과를 손으로 구해보고 수행한 결과와 비교해 보라.
 *  
 */
