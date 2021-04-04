package ex12_more;
/*
 *  [ PrintDiamond_WidthAny ]: 임의의 폭을 갖는 다이아몬드 모양 출력하기
 *  
 *    o 스타일 3: 중첩된 반복문 사용하여 간결하게 작성하기
 *     
 *    o 다이아몬드 그리기 
 *      - 다이아몬드는 *가 증가하는 부분과 감소하는 부분으로 나누어짐
 *      - 다이아몬드 폭이 n이면 처음 라인은 blank가 n / 2개, *가 1개임
 *      - 다음 라인부터 blank가 1개씩 감소, *가 2개씩 증가하는 부분임
 *      - blank가 0이되면 다시 blank가 1개씩 증가, *가 2개씩 감소하는 부분임
*/

class Ex4_08_3_PrintDiamond_WidthAny {
	public static void main(String[] args) {

		int i;
		char cToDraw = '*';  // 다이아몬드를 그릴 문자를 저장

		int widthDiamond = 9;       // 다이아몬드 폭을 저장하는 변수, 이 변수 값은 홀수이어야 함
		if (widthDiamond % 2 == 0)  // 다이아몬드 폭이 짝수이면 1 작은 홀수로 재설정
			widthDiamond--;
	
		int cntStarInit = 1;  // 첫 라인에 출력할 문자 개수 저장
		int cntBlankInit = widthDiamond / 2; // 첫 라인에 출력할 blank의 개수 저장		
		
		int cntStar, cntBlank; // 한 라인에 출력하는 문자와 blank의 개수 저장
		
		System.out.print("\n  **** Print diamond of width " + widthDiamond + " (style 3) ****\n\n");

		// 다이아몬드 문자 증가 부분: 라인마다 blank 1개 감소, 그릴 문자 2개 증가  
		cntStar = cntStarInit;  // 증가 부분의 *는 1개부터 시작함
		for (cntBlank = cntBlankInit  ; cntBlank >= 0; cntBlank--) { // 각 라인의 blank 개수로 반복문 제어

			for (i = 0; i < cntBlank; i++) System.out.print(' ');     // blank 출력
			for (i = 0; i < cntStar; i++)  System.out.print(cToDraw); // 그릴 문자 출력
			System.out.println();
			
			cntStar += 2;  // * 개수를 2개 증가
		}

		// 다이아몬드 문자 감소 부분: 라인마다 blank 1개 증가, 그릴 문자 2개 감소
		cntStar = widthDiamond - 2;  // 감소 부분의 *는 (폭 - 2)개부터 시작함
		for (cntBlank = 1; cntBlank <= cntBlankInit; cntBlank++) { // 각 라인의 blank 개수로 반복문 제어

			for (i = 0; i < cntBlank; i++) System.out.print(' ');     // blank 출력
			for (i = 0; i < cntStar; i++)  System.out.print(cToDraw); // 그릴 문자 출력
			System.out.println();
			
			cntStar -= 2;  // * 개수를 2개 감소
		}
	}
}  

/*
 *  [ 실습과제 ]
 *  
 *    1) 이 프로그램은 '*'를 이용하여 폭이 9인 다이아몬드를 그려준다. 
 *    
 *       이 프로그램 스타일로 '$'를 이용하여 폭이 15인 다이아몬드를 그리는 프로그램을
 *       Pr4_8_3_PrintDiamond_Width 클래스로  작성하라. 
 *       
 *    2) 이 프로그램 스타일로 폭이 121인 다이아몬드 또는 폭이 1221인 다이아몬드를 
 *       프로그램을 작성할 수 있겠는가? 
 *       
 *       이 역시 할 수는 있지만 엄청 수고스러운 작업인가? 
 * 
 * 
 *  [ 스스로 생각하고 고민해볼 과제 ]  
 * 
 *    1) 이 프로그램은 Ex4_8_2_PrintDiamond_Width9 클래스에서 반복되는 문장 부분들을 통합한
 *       프로그램이다.
 *       
 *       폭이 9인 다이아몬드만 그리는 것뿐만 아니라 어떠한 폭인 다이아몬드도
 *       간단하게 변경하여 그릴 수 있는 유용성이 높은 프로그램이다.
 *       
 *       프로그램을 작성하고 이해하기는 쉽지 않지만 이 정도 수준의 프로그램을 작성할 수 있도록
 *       많은 연습을 해야 한다.
 */
