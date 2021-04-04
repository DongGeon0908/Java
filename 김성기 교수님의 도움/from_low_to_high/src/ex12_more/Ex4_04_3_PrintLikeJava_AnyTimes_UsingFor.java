package ex12_more;
/*
 *  [ PrintLikeJava_AnyTimes_UsingFor ]: 출력회수를 입력하여 "I like Java "를 회수만큼 출력하기
 *  
 *    o 스타일 2: 반복문 사용하여 아주 쉽게 작성하기
 *             
 *    o 반복문(repetition statement)
 *      - 똑같은 문장들 또는 유사한 문장들이 반복적으로 나열되는 경우 
 *        이를 하나의 문장으로 통합적으로 구성하여 반복시킴
 *      - for 문, while 문, do-while문 등의 반복문     
 *      
 *    o for 문
 *      - 반복 제어변수를 이용하여 반복 회수를 제어함
 *      - 반복 제어변수는 for 문 외부 또는 내부에서 선언 가능
 *      - for 문 외부에서 선언한 반복 제어변수는 for 문 내와 for 문이 종료된 후에도 사용 가능함 
 *      - for 문 내부에서 선언한 반복 제어변수는 for 문 내에서만 사용 가능함 
 */

class Ex4_04_3_PrintLikeJava_AnyTimes_UsingFor {
	public static void main(String[] args)  {
		System.out.print("\n  **** Print \"I like Java\" many times using for statement ****\n");

		// 반복 출력할 회수를 cnt에 입력
		int cnt = SkScanner.getIntWithPrompt("\n  o Enter count to print > ");     

		System.out.println("\n  o print \"I like Java \" " + cnt + " times\n");

		for (int i = 0; i < cnt; i++)        // i가 0부터 cnt 값보다 작을 동안 반복
			System.out.print("I like Java ");  // 반복 문장이 1개이므로 블록({...}) 불필요		
		
	}
}

