/**
 * [ ScoresInSum_UsingInfiniteWhile ]: 
 *        반복조건이 true이어서 무한히 반복되는 while문으로 0부터 100 사이의 점수들 입력하여 합 구하기   
 *            
 *   o while 문
 *     - 사용 형식: while(반복조건)
 *	                               반복_수행할_문장                         
 *	              
 *     - 기능: 반복조건이 true인 동안 반복_수행할_문장을 반복하다 조건이 false이면 반복 종료
 *     - 특이사항: 처음 반복조건이 false이면 반복_수행할_문장이 한 번도 수행되지 않음

 *    
 *   o while 문의 무한 반복
 *     - while 문 반복조건이 항상 true가 되는 경우
 *            while(true) ...
 *            
 *     - while(true)는 외관상으로 끝없이 반복하는 무한 루프(infinite loop)
 *      
 *     - while 문 내에서 강제적으로 while 문을 벗어나기 위해 break 문 또는 return 문 사용
 *	               
 */

class Ex4_3_12_ValidScoresInSum_UsingInfiniteWhile {
	public static void main(String[] args)  {
		System.out.println("\n  **** 0부터 100 사이 점수들 입력하여 합 구하기 ****\n");

		int score;
		int sum = 0;

		System.out.println("  ** 0부터 100 사이 점수들 입력(-1 입력 시 종료) **");
		
		while(true) {    // while 문의 반복조건이 true이므로 무한 반복됨
			score = SkScanner.getIntWithPrompt("  o 0부터 100 사이의 점수 > ");

			if (score >= 0 && score <= 100)  // 올바른 점수이면
				sum = sum + score;           //   합에 누적 
			else if (score == -1)            // 점수가 -1이 반복을 종료시킴
				break;                       //    break 문은 반복문을 벗어나게 하는 문장임
			else                             // 점수가 -1 미만 또는 100 초과이면 오류 처리
				System.out.println("  ??? 입력 오류, 잘못된 점수: " + score + "\n");
		}
		
		System.out.println("\n  * sum = " + sum); 
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *   
 *   1) 무한 반복을 이용하여 0부터 100 사이 입력된 점수들 합을 구한다.
 *      - 0부터 100 사이 점수이면 합 구함
 *      - 점수가 -1이면 break 문으로 while 문 벗어남
 *      - -1 미만 또는 100 초과 점수이면 오류 처리
 *      
 *      - while 문 종료 후 누적된 합 출력
 *
 *   2) 입력된 score 값에 따른 프로그램의 실행과정 정확히 이해하라.
 */
