/**
 * [ ValidScoresInSum_UsingDoWhile ]: while 문으로 0부터 100 사이의 점수들 입력하여 합 구하기   
 *            
 *   o do-while 문
 *     - 사용 형식
 *      
 *        do {
 *	                  반복_수행할_문장
 *	      } while(반복조건);
 *	           
 *     - 기능: 반복_수행할_문장을 수행하고 반복조건이 true이면 다시 반복문장을 수행
 *     - 특이사항: 반복_수행할_문장이 최소한 한번은  수행            
 */

class Ex4_3_13_ValidScoresInSum_UsingDoWhile {
	public static void main(String[] args)  {
		System.out.println("\n  **** 0부터 100 사이 점수들 입력하여 합 구하기 ****\n");

		int score;
		int sum = 0;

		System.out.println("  ** 0부터 100 사이 점수들 입력(-1 입력 시 종료) **");

		do {
			score = SkScanner.getIntWithPrompt("  o 0부터 100 사이의 점수 > ");
			if (score >= 0 && score <= 100)
				sum = sum + score;
			else if (score < -1 || score > 100)
				System.out.println("  ??? 입력 오류, 잘못된 점수: " + score + "\n");      
		} while (score != -1);   // score가 -1이 아닌 동안 반복

		System.out.println("\n  * sum = " + sum); 
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *   
 *   1) do-while 문 사용하여  0부터 100 사이 입력된 점수들 합을 구한다.
 *      - 입력된 점수가 0부터 100 사이 올바른 점수이면 이를  출력하고 합에 누적
 *      - 잘못된 점수 입력되면 오류 메시지 출력
 *      - do-while 문의 반복조건이 n != -1이므로 -1이 입력되면 do-while 문 종료
 *      
 *      - do-while 문 종료 후 누적된 합 출력
 *
 *   2) 입력된 score 값에 따른 프로그램의 실행과정을 정확히 이해하라.
 */
