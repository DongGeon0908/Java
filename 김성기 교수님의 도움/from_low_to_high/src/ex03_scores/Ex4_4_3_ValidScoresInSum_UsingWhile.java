package ex03_scores;

/*
 *  [ ScoresInSum_UsingWhile2 ]: while 문으로 0부터 100 사이의 점수들 입력하여 합 구하기   
 *            
 *    o while 문
 *      - while(반복조건)
	              반복_수행할_문장
	              
 *      - 반복조건이 true인 동안 반복_수행할_문장을 반복
 *	               
 */

class Ex4_4_3_ValidScoresInSum_UsingWhile {
	public static void main(String[] args)  {
		System.out.println("\n  **** 0부터 100 사이의 점수들 입력하여 합 구하기 ****\n");
		
		int score;
		int sum = 0;

		System.out.println("  ** 0부터 100 사이의 점수들 입력(-1 입력시 종료) **");
		score = SkScanner.getInt("  o 0부터 100 사이의 점수 > ");     // 점수 입력

		while(true) {
		  if (score == -1)
			  break;
		  
		   if (score > 0 && score <= 100)  // 점수가 0부터 100사이의 올바른 점수이면
		      sum = sum + score;           //   합에 누적

		   score = SkScanner.getInt("  o 0부터 100 사이의 점수 > ");  // 점수 입력
		}

		System.out.println("\n  * sum = " + sum); 
	}
}
