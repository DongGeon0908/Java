package ex12_more;
/*
 *  [ BitCount2_UsingFor.java ]: 비트 연산자 &를 이용하여 양의 정수를 입력하여 그 정수의 1인 비트수를 구하기
 *   
 *   o 프로그래밍 스타일 
 *     1) main() 메소드로만 클래스 구성
 *     2) 반복문 사용하기
 *        - 1비트만 1인 양의 정수 31개(1, 2, 4, 8, 16, ...)와 비트별 AND를 
 *          31번 수행하여 1인 비트의 개수를 구함 
 *   
 *    o 1인 비트수를 구하는 방법:
 *      - 특정 위치의 비트만 1인 정수와 bit-wise & (bit-wise AND) 연산을 수행하여 
 *        결과가 0이 아니면 그 위치의 비트값은 1임
 *        
 *      - 이를 이용하여 입력된 정수와 특정 위치의 비트만 1인 정수 31개를 & 연산을 
 *        수행하여 1인 bit의 개수를 구할 수 있음  
 *        
 *      - 1은 가장 오른쪽 비트가 1인 수이다. 1을 (i - 1) 비트 왼쪽 쉬프트시키면 오른쪽에서
 *        i번째 비트만 1인 수이므로 이를 이용하여 1비트만 1인 수를 구함   
 */

class Ex4_07_7_BitCount2_UsingFor  {
	public static void main(String[] args)  {
		int n;         // 입력된 값을 저장할 변수

		System.out.println("\n\n  ****  Getting count of 1 bits of an integer (using for stmt)****");
		n = SkScanner.getIntWithPrompt("\n  o Enter a positive number > ");

		int cnt = 0;   // 1인 비트의 개수를 저장할 변수

		for (int i = 0; i < 31; i++) {
			if ((n & (1 << i)) != 0) // n을 오른쪽 i번째 비트만 1인 (1 << i)와 비트별 &를 수행하여 0이 아니면
				cnt++;               //   n의 오른쪽 i번째 비트가 1이므로 cnt 1 증가시킴
		}

		System.out.println("\n  * Count of 1 bits of " + n + " is " + cnt);

		main(args);   // 이는 가장 쉽게 전체를 반복시키는 방법임
	}
}

/*
 * [ 스스로 생각하고 고민해볼 과제 ]
 * 
 *   1)  이 프로그램은 반복문을 사용하지 않은 BitCount2, BitCount2_Clear, BitCount2_ClearSameStmts 클래스를  
 *       for 문으로 작성한 것이다. for 문을 사용하는 프로그램으로 변경된 원리를 생각해보라.
 *       
 *   2) 모든 입력 데이터에 대해 완벽하게 작동하는 프로그램을 작동하는 것은 쉽지 않다.
 *      특히 잘못된 데이터가 입력된 경우 이에 대한 처리가 제대로 되지 않으면 잘못된 결과가
 *      생성될 수 있다.
 *       
 *      이 프로그램도 잘못된 데이터가 입력되면 문제가 발생한다. 그 문제가 무엇인지를 
 *      찾아보고, 문제를 해결하기 위한 방안을 생각해보라.
 */
