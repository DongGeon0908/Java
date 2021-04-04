package ex09_draw_diamond;
/*
 * [ PrintDiamond_WidthAny_CharAny ]: 바뀌는 문자로 입력된 폭의 다이아몬드 모양 출력하기
 *  
 *    o 스타일 4: 중첩된 반복문 사용하여 작성하기
 *               + 다이아몬드의 다음 라인이 다음 순번의 문자들로 출력 
 */

class Ex4_4_PrintDiamond_WidthAny_CharAny {
	public static void main(String[] args) {
	
		
		System.out.print("\n  **** Print diamond of given width varing char ****\n");
		char cToPrint = SkScanner.getCharWithPrompt(" \n  o Input character to draw > ");               // 그릴 떄 사용될 문자
		int widthDiamond = SkScanner.getIntWithPrompt(" \n  o Input odd width of diamond to draw > ");  // 다이아몬드 최대 폭
		
		
		if (widthDiamond % 2 == 0)  // 다이아몬드 폭이 짝수이면 1 작은 홀수로 재설정
			widthDiamond--;
		
		int cntStarInit = 1;  // 첫 라인에 출력할 * 개수 저장
		int cntBlankInit = widthDiamond / 2; // 첫 라인에 출력할 blank의 개수 저장
		
		int cntStar, cntBlank; // 한 라인에 출력하는 *와 blank의 개수 저장
		System.out.print("\n  ** Diamond of width " + widthDiamond + " with starting '" + cToPrint +"' **\n");
		
		// 다이아몬드 * 증가부분: 라인마다 * 2개 증가, blank 1개 감소 
		cntStar = cntStarInit;
		for (cntBlank = cntBlankInit  ; cntBlank >= 0; cntBlank--) {
			int i;

			for (i = 0; i < cntBlank; i++) System.out.print(' '); // blank를  출력
			for (i = 0; i < cntStar; i++)  System.out.print(cToPrint); // *를 출력
			System.out.println();
			
			cntStar += 2;
			cToPrint++;  // 다음 라인은 다음 순번의 문자로 그리도록 함			
		}

		// 다이아몬드 * 감소부분: 라인마다 * 2개 감소, blank 1개 증가 
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

/*
 *
 * [ 실습과제 ]
 * 
 *   1) 이 프로그램을 메소드를 이용하는 프로그래으로 변경하라.
 *   
 *   
 * [ 스스로 생각하고 고민해볼 과제: ]  
 *    1) 이 프로그램은 3개의 문장이 다이아몬드 한 라인을 그리는 작업을 수행한다
 *       3개의 문장은 유사성과 규칙성을 가지고 있다. 규칙성에 대해 파악하라.
 *       
 *    2) 유사성과 규칙성을 가지는 문장은 반복문을 통해 간결하게 변환될 수 있다.
 *       이 프로그램을 간결하게 바꿀 수 있는 방안을 강구해보라.
 *        
 *    3) 다음은 유사한 문장들을 for 문을 이용하여 간결하게 변환하는 원리를 설명한다.
 *       a), b), c)와 같이 완전히 동일하지 않은 유사한 문장들을 a"), b"), c")와 같이
 *       하나의 for 문으로 통합하기 위해서는 a'), b'), c')와 같은 변환된 중간 과정이 필요하다.
  *        
 *       a)      ===========> a') int i = 1;     ===========>  a")  for (int i = 1; i <= 3; i++) 
 *        sum = sum + 1;          sum = sum + i;  i++;                  sum = sum + i;
 *        sum = sum + 2;          sum = sum + i;  i++; 
 *        sum = sum + 3;          sum = sum + i;  i++;
 *        (더해 주는 값이 1, 2, 3으로 1씩 증가함)
 *     
 *       b)     ===========>  b') int i = 7;     ===========>  b")  for (int i = 7; i <= 11; i=i+2) 
 *        sum = sum + 7;          sum = sum + i;  i=i+2;                sum = sum + i;
 *        sum = sum + 9;          sum = sum + i;  i=i+2; 
 *        sum = sum + 11;         sum = sum + i;  i=i+2;
 *        (더해 주는 값이 7, 9, 11로 2씩 증가함)
 *                                                                  
 *       c)    ===========>  c')  int i = 0;     ===========>  c")  int sum[] = { no0, no1, no2 };
 *        sum = sum + no0;        sum = sum + no[i];  i++;          sum = sum + no[i];
 *        sum = sum + no1;        sum = sum + no[i];  i++;          for (int i = 0; i < 3; i++) 
 *        sum = sum + no2;        sum = sum + no[i];  i++;               sum = sum + no[i];
 *        (더해 주는 값이 규칙성이 없는 경우 배열에 저장한 후 배열 원소를 차례로 더해줌))
 *        
 *      여러 문장들이 완전히 동일하지 않지만 아주 유사하거나 규칙적으로 변할 경우 
 *      반복문을 사용하기 위하여 통합된 문장으로 작성하는 원리에 대해 생각해보시오. 
 */
