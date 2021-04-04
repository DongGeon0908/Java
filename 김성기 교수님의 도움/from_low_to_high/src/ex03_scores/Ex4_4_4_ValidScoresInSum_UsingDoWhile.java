package ex03_scores;

/*
 *  [ ValidScoresInSum_UsingDoWhile ]: while 문으로 0부터 100 사이의 점수들 입력하여 합 구하기   
 *            
 *    o do-while 문
 *      - do {
	           반복_수행할_문장
	      } while(반복조건);
	           
 *      - 반복_수행할_문장을 수행하고 반복조건이 true이면 다시 반복문장을 수행
 *	               
 */

class Ex4_4_4_ValidScoresInSum_UsingDoWhile {
	public static void main(String[] args)  {
		System.out.println("\n  **** 0부터 100 사이의 점수들 입력하여 합 구하기 ****\n");
		
		int score;
		int sum = 0;

		System.out.println("  ** 0부터 100 사이의 점수들 입력(-1 입력시 종료) **");

		do {
			   score = SkScanner.getIntWithPrompt("  o 0부터 100 사이의 점수 > ");
			   if (score > 0 && score <= 100)
			      sum = sum + score;
			   else if (score < -1 || score > 100)
			      	System.out.println("  ?? 입력 오류, 잘못된 점수: " + score + "\n");      
			} while (score != -1);   

		System.out.println("\n  * sum = " + sum); 
	}
}
