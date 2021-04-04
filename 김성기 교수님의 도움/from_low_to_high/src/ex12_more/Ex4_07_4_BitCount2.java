package ex12_more;
/*
 * [ BitCount2 ]: 양의 정수를 입력하여 그 정수의 1인 비트 개수 구하기
 *   
 *    o 프로그래밍 스타일 
 *      1) main() 메소드로만 클래스 구성
 *      2) 반복문 사용하지 않기
 *         - 입력된 정수와 1비트만 1인 양의 정수 31개(1, 2, 4, 8, 16, ...)에 대해 
 *           비트별 AND를 31번 수행하여 1인 비트의 개수를 구함 
 *   
 *    o 1인 비트수를 구하는 방법:
 *      - 특정 위치의 비트만 1인 정수와 bit-wise & (bit-wise AND) 연산을 수행하여 
 *        결과가 0이 아니면 그 위치의 비트값은 1임
 *        
 *      - 이를 이용하여 입력된 정수와 특정 위치의 비트만 1인 정수 31개를 & 연산을 
 *        수행하여 1인 bit의 개수를 구할 수 있음 
 */

class Ex4_07_4_BitCount2  {
	public static void main(String[] args)  {
		System.out.println("\n\n   ****  Getting count of 1 bits of an integer ****");

		int n;         // 입력된 값을 저장할 변수
			
		System.out.print("\n  o Enter a number less than or equal to "+ 0x7FFF_FFFF + " > ");  // 0x7FFF_FFFF는 int 타입 값 중에서 최고값
		n = SkScanner.getInt();

		int cnt = 0;   // 1인 비트의 개수를 저장할 변수

		if ((n & 1) != 0) cnt++;  // 1은 오른쪽 1번째 비트만 1임, (n & 1)이 0이 아니면 cnt 1 증가
		if ((n & 2) != 0) cnt++;  // 2는 오른쪽 2번째 비트만 1임, (n & 2)가 0이 아니면 cnt 1 증가
		if ((n & 4) != 0) cnt++;  // 4는 오른쪽 3번째 비트만 1임, (n & 4)가 0이 아니면 cnt 1 증가
		if ((n & 8) != 0) cnt++;  // 이하 생략함, 주석을 최대한 작성해보시오. 
		if ((n & 16) != 0) cnt++;    

		if ((n & 32) != 0) cnt++;
		if ((n & 64) != 0) cnt++;
		if ((n & 128) != 0) cnt++;
		if ((n & 256) != 0) cnt++;
		if ((n & 512) != 0) cnt++;

		if ((n & 1024) != 0) cnt++;
		if ((n & 2048) != 0) cnt++;
		if ((n & 4096) != 0) cnt++;
		if ((n & 8192) != 0) cnt++;
		if ((n & 16384) != 0) cnt++;

		if ((n & 32768) != 0) cnt++;
		if ((n & 0x1_0000) != 0) cnt++;  // 0x10000 = 65536, 더이상 십진수로 표시하면 어려우므로 16진수로 표시함
		if ((n & 0x2_0000) != 0) cnt++;
		if ((n & 0x4_0000) != 0) cnt++;
		if ((n & 0x8_0000) != 0) cnt++;

		if ((n & 0x10_0000) != 0) cnt++;
		if ((n & 0x20_0000) != 0) cnt++;
		if ((n & 0x40_0000) != 0) cnt++;
		if ((n & 0x80_0000) != 0) cnt++;
		if ((n & 0x10_00000) != 0) cnt++;
		
		if ((n & 0x200_0000) != 0) cnt++;
		if ((n & 0x400_0000) != 0) cnt++;
		if ((n & 0x800_0000) != 0) cnt++;
		if ((n & 0x100_00000) != 0) cnt++;  // 왼쪽 4번째 비트가 1이면 cnt 1 증가
		if ((n & 0x2000_0000) != 0) cnt++;  // 왼쪽 3번째 비트가 1이면 cnt 1 증가
		
		if ((n & 0x4000_0000) != 0) cnt++;  // 왼쪽 2번째 비트가 1이면 cnt 1 증가		
                                            // 왼쪽 1번째 비트는 부호 비트이므로 양의 정수인 경우 항상 0임
		
		System.out.println("\n  * Count of 1 bits of " + n + " is " + cnt);

		main(args);   // 이는 가장 쉽게 전체를 반복시키는 방법임
	}
}

/*
 *  [ 스스로 생각하고 고민해볼 과제 ]
 *  
 *    o 이 방법은 이해하기는 아주 쉬우나 프로그램의 길이가 길고 전체 32비트 정수에서 
 *      i번째 비트만 1인 정수를 십집수 또는 16진수로 표현해야 하므로 번거롭다.
 *       
 *      특정 비트가 1인가를 체크하는 31개의 문장들은 완전히 같지 않고 약간씩 다르다.  
 *      그러나 이들은 변화하는 양상이 규칙적이다. 그 변화하는 규칙이 무엇인지를 파악해보라.
 *      
 *    o 유사한 문장의 변화규칙이 파악되면 이를 for 문에서 반복 수행되는 동일한 문장으로 통합시킬 수 있다.
 *      이 프로그램의 변화 양상을 보다 알기 쉽도록 표현한 프로그램이 Ex4_7_5_BitCount2_Clear.java이며,
 *      반복되는 문장들을 완전히 동일하게 표현한 프로그램이 Ex4_7_6_BitCount2_ClearSameStmts.java이다.
 *      
 *      그 결과 아주 간결한 프로그램인 BitCount2_UsingFor.java로 작성된다.
 *      
 *    o 반복문을 제대로 이해하려면 반복문으로 작성하지 않은 스타일의 프로그램도 많이 작성해야 한다. 
 *      반복문을 사용하지 않는 프로그램 작성연습은 이전 실습과정에서 많이 이루어졌으며, 
 *      지금 단계에서 다시 한번 해보면 반복문과 관련하여 많은 도움이 된다.
 *      
 *      다시 한번 처음부터 반복문을 사용하지 않는 프로그램의 작성을 복습하기를 바란다.
 */