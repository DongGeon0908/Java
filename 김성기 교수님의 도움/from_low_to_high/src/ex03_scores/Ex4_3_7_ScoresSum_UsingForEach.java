package ex03_scores;

/*
 *  ScoresSum_UsingForEach.java: for-each 문을 사용하여 10개 점수의 합 구하기   
 *            
 *    o for-each 문
 *      - 사용형식: for (타입 원소_저장할_변수: 배열변수)
	                     반복_수행할_문장  
 *      
 *      - 배열변수의 모든 원소를 한 번씩 사용하여 자동적으로 반복 작업을 수행하는 반복문
 *      - 명시된 원소_저장할_변수에 배열 원소를 자동적으로 저장시켜 원소 개수만큼 자동적으로 반복 수행 
 */

class Ex4_3_7_ScoresSum_UsingForEach {
	public static void main(String[] args)  {
		System.out.println("\n  ** for-each 문을 사용하여 10개 점수의 합 구하기 **\n  ");
		
		int[] scores = { 90, 95, 79, 83, 88, 65, 72, 83, 81, 96 };

		int sum = 0;

		// for-each 문: scores 배열변수의 각 원소에 대해 자동적으로 반복시킴
		for (int score : scores) // scores 배열변수의 원소 하나씩을 score 변수에 저장하여
		    sum = sum + score; 	 //     score 값을 sum에 누적

		System.out.println("  * 점수들의 개수: " + scores.length);    
		System.out.println("  * 점수들의 합: " + sum); 
	}
}
