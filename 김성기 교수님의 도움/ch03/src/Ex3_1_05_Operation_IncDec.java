/**
 * [ Operation_IncDec ]: 증가 및 감소 연산의 연습 
 *     
 *   o 프로그래밍 스타일 
 *     1) main() 메소드로만 클래스 구성
 *     2) 정수 또는 실수에 대한 증가 및 감소 연산을 수행하여 결과 값 출력
 *     
 *   o 증가 및 감소 연산은 정수 변수 또는 실수 변수에 대해서만 적용 가능함
 *   
 *   o 증가 및 감소 연산자는   ++. --가 있으며 변수 앞에, 또는 변수 뒤에 연산자 위치 가능
 *     - 변수 앞에 연산자 위치: 변수의 값을 먼저 증가 또는 감소시킨 후 변경된 변수 값으로 연산 결과 생성
 *     - 변수 뒤에 연산자 위치: 변수의 값으로 연산결과를 생성한 후 변수의 값을  증가 또는 감소시킴
 */

class Ex3_1_05_Operation_IncDec  {
	public static void main(String[] args)  {

		int count = 1;

		System.out.println("\n  ** 증가 및 감소 연산(++, --) **\n");
		System.out.println("  * 증가 및 감소 연산(++, --)은 연산의 결과와 변수의 결과가 다를 수 있음(++ 또는  --가 변수 뒤에 있는 경우)\n");

		
		System.out.println("  * 변수 초기값: count = " + count + " (모든 연산은 << count = 1; >> 수행한 후 수행)");  
		System.out.println();

		/*
		 *  증가 및 감소 연산에 대한 예
		 */
		count = 1;
		System.out.println("  * ++count := " + ( ++count ) + "   ⇒ count := " + (count));  // ⇒ 연산 결과 : 2, count 변수 값: 2

		count = 1;
		System.out.println("  * count++ := " + ( count++ ) + "   ⇒ count := " + (count));  // ⇒ 연산 결과 : 1, count 변수 값: 2

		count = 1;
		System.out.println("  * --count := " + ( --count ) + "   ⇒ count := " + (count));  // ⇒ 연산 결과 : 0, count 변수 값: 0

		count = 1;
		System.out.println("  * count-- := " + ( count-- ) + "   ⇒ count := " + (count));  // ⇒ 연산 결과 : 1, count 변수 값: 0
		System.out.println();

		/*
		 *  증가 및 감소 연산이 비교 연산과 함께 사용된 예
		 */
		count = 1;
		System.out.println("  * ++count  > 1 := " + ( ++count > 1 ) + "   ⇒ count := " + (count));  // ⇒ 연산 결과 : true, count 변수 값: 2

		count = 1;
		System.out.println("  * count++  > 1 := " + ( count++ > 1 ) + "  ⇒ count := " + (count));  // ⇒ 연산 결과 : false, count 변수 값: 2

		count = 1;
		System.out.println("  * --count == 0 := " + ( --count  == 0) + "   ⇒ count := " + (count));  // ⇒ 연산 결과 : true, count 변수 값: 0

		count = 1;
		System.out.println("  * count-- == 0 := " + ( count-- == 0) + "  ⇒ count := " + (count));  // ⇒ 연산 결과 : false, count 변수 값: 0
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *
 *   o 연산의 결과를 손으로 구해보고 수행한 결과와 비교해 보라.
 *   
 *   o 증가 및 감소 연산(++, --)은 for 문, while 문 등의 반복문에서
 *     반복 제어를 위해 많이 사용되므로 연산 결과와 변수 값을 정확히 계산할 수 있어야 한다. 
 */
