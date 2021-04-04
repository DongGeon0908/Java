package ex12_more;
/*
 *  PrintDiamond_WidthAny_CharVarying: 바뀌는 문자로 입력된 폭의 다이아몬드 모양 출력하기
 *  
 *    o 스타일 4: 중첩된 반복문 사용하여 작성하기
 *              + 다이아몬드의 다음 라인을 다음 순번의 문자들로 출력
 *                (다이아몬드의 각 라인을 다른 문자로 그림) 
 */

class Ex4_08_4_PrintDiamond_WidthAny_CharVarying {
	public static void main(String[] args) {
	
		
		System.out.print("\n  **** Print diamond of given width varing char ****\n");
		int widthDiamond = SkScanner.getIntWithPrompt(" \n  o Input odd width of diamond to draw > ");
		char cToPrint = SkScanner.getCharWithPrompt(" \n  o Input char of first line to draw > ");   // 첫 라인 그릴 떄 사용될 문자
		
		
		if (widthDiamond % 2 == 0)  // 다이아몬드 폭이 짝수이면 1 작은 홀수로 재설정
			widthDiamond--;
		
		int cntStarInit = 1;  // 첫 라인에 출력할 * 개수 저장
		int cntBlankInit = widthDiamond / 2; // 첫 라인에 출력할 blank의 개수 저장
		
		int cntStar, cntBlank; // 한 라인에 출력하는 *와 blank의 개수 저장
		System.out.print("\n  ** Diamond of width " + widthDiamond + " with starting '" + cToPrint +"' **\n");
		
		// 다이아몬드 증가부분: 라인마다 blank 1개 감소, 그릴 문자 2개 증가 
		cntStar = cntStarInit;
		for (cntBlank = cntBlankInit; cntBlank >= 0; cntBlank--) {
			int i;

			for (i = 0; i < cntBlank; i++) System.out.print(' '); // blank를  출력
			for (i = 0; i < cntStar; i++)  System.out.print(cToPrint); // *를 출력
			System.out.println();
			
			cntStar += 2;
			cToPrint++;  // 다음 라인은 다음 순번의 문자로 그리도록 함			
		}

		// 다이아몬드 감소부분: 라인마다  blank 1개 증가, 그릴 문자 2개 감소 
		cntStar = widthDiamond - 2; 
		for (cntBlank = 1; cntBlank <= cntBlankInit; cntBlank++) {
			int i;

			for (i = 0; i < cntBlank; i++) System.out.print(' '); // blank를  출력
			for (i = 0; i < cntStar; i++)  System.out.print(cToPrint); // *를 출력
			System.out.println();
			
			cntStar -= 2;
			cToPrint++; // 다음 라인은 다음 순번의 문자로 그리도록 함
		}
		
		main(args);
	}
}  


