package ex03_scores;

/*
 *  [ ValidScoreIn_UsingContinue ]: continue 문을 이용하여 1부터의 100 사이의 올바른 점수 입력하기   
 *            
 *    o while 문
 *      - while(반복조건)
	              반복_수행할_문장
	              
 *      - 반복조건이 true인 동안 반복_수행할_문장을 반복
 *	               
 */

class Ex4_5_2_ValidScoreIn_UsingContinue {
	public static void main(String[] args)  {
		System.out.println("\n  ** 1부터의 100 사이의 올바른 점수 입력하기 **\n");

		int score;

		// 0부터 100까지의 점수가 입력될 때까지 반복하여 유효한 점수만 입력하게 함
		while(true) {
			score = SkScanner.getIntWithPrompt("  o 0부터 100까지의 점수 > ");

			if (score < 0 || score > 100)  {     // 잘못된 점수가 입력된 경우 
				System.out.println("  ?? 입력 오류, 잘못된 점수: " + score + "\n"); 
				continue;  // 나머지 반복 부분을 무시하고 반복을 새로이 시작하게 함
			}

			break;   // 올바른 점수 입력시 무한 반복을 벗어남
		}

		System.out.println("  * 입력된 올바른 점수: " + score);
	}
}
