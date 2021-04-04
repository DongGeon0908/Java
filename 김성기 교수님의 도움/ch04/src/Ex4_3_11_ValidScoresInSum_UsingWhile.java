/**
 * [ ValidScoresInSum_UsingWhile ]: while 문으로 0부터 100 사이 점수들 입력하여 합 구하기   
 *            
 *   o while 문
 *     - 사용 형식: while(반복조건)
 *	                               반복_수행할_문장
 *	              
 *     - 기능: 반복조건이 true인 동안 반복_수행할_문장을 반복하다 조건이 false이면 반복 종료
 *     - 특이사항: 처음 반복조건이 false이면 반복_수행할_문장이 한 번도 수행되지 않음
 *     
 *   o 반복 수행할 문장이 여러 문장이면 반드시 이를 블록으로 만들어야 함
 *	                    
 *        while(반복조건) {
 *              반복_수행할_문장1
 *              반복_수행할_문장2
 *                  ...
 *              반복_수행할_문장n
 *        }
 */

class Ex4_3_11_ValidScoresInSum_UsingWhile {
	public static void main(String[] args)  {
		System.out.println("\n  **** 0부터 100 사이 점수들 입력하여 합 구하기 ****\n");

		int score;
		int sum = 0;

		System.out.println("  ** 0부터 100 사이 점수들 입력(-1 입력 시 종료) **");

		score = SkScanner.getInt("  o 0부터 100 사이 점수 > ");     // 점수 입력

		while(score != -1) {                           // 점수가 -1이 아닌 동안 반복
			if (score >= 0 && score <= 100)            //   점수가 0부터 100 사이의 올바른 점수이면
				sum = sum + score;                     //     합에 누적
			else                                       //   점수가 -1 미만 또는 100 초과인 경우임
				System.out.println("  ??? 입력 오류, 잘못된 점수: " + score + "\n");

			score = SkScanner.getInt("  o 0부터 100 사이 점수 > ");  // 점수 입력
		}

		System.out.println("\n  * sum = " + sum); 
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *   
 *   1) 예제 4-3-11은 0부터 100 사이 입력된 점수들 합을 구한다.
 *      - 점수가 -1이면 반복조건이 false 되어 while 문 종료
 *      - 0부터 100 사이의 점수이면 합 구함
 *      - 점수가 -1 미만 또는 100 초과인 경우 오류 처리
 *      
 *      - while 문 종료 후 누적된 합 출력
 *         
 *   2) 입력된 score 값에 따른 프로그램의 실행과정 정확히 이해하라. 
 */
