package ex03_scores;

/*
 *  ScoresSum_NotUsingForEach.java: for-each 문으로 작성된 프로그램을 for 문으로 변경하기   
 *            
 *    o for-each 문으로 작성된 프로그램을 for 문으로 변경 방법 
 *      - for (타입 원소_저장할_변수: 배열변수)
 *	           반복_수행할_문장 
 *	            
 *	      ==>
 *	      
 *	      for (int i = 0; i < 배열변수.length; i++) {
 *	           타입 원소_저장할_변수 = 배열변수[i];
 *	           반복_수행할_문장;
 *	      }
 *	               
 */

class Ex4_3_8_ScoresSum_NotUsingForEach {
	public static void main(String[] args)  {
		System.out.println("\n  ** for-each 문으로 작성된 프로그램을 for 문으로 변경하기 **\n  ");
		
		int[] scores = { 90, 95, 79, 83, 88, 65, 72, 83, 81, 96 };

		int sum = 0;

		// for (int score : scores) 
		//    sum = sum + score; 	 
		// ==> for 문으로 변환하기: scores 배열의 원소 개수만큼 반복시킴
		for (int i = 0; i < scores.length; i++) {	// i를 0부터 (원소 개수 - 1)까지 반복하여 
		    int score = scores[i];  // i번째 원소를 score에 저장
		    sum = sum + score;; 	// score 값을 sum에 누적
		}
		
		System.out.println("  * 점수들의 개수: " + scores.length);    
		System.out.println("  * 점수들의 합: " + sum); 
	}
}
