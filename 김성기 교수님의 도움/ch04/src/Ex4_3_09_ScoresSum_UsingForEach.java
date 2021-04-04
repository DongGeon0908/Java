/**
 * [ ScoresSum_UsingForEach.java ]: for-each 문 사용하여 점수 10개 합 구하기   
 *            
 *  o for-each 문
 *    - 사용형식: for (타입 원소_저장할_변수: 배열변수)
 *	                      반복_수행할_문장  
 *      
 *    - 기능: 배열변수의 모든 원소를 한 번씩 사용하여 자동적으로 반복 작업 수행하는 반복문
 *    - 수행방법: 명시된 원소_저장할_변수에 배열 원소를 자동적으로 하나씩 저장시켜 원소 개수만큼 반복 수행 
 */

class Ex4_3_09_ScoresSum_UsingForEach {
	public static void main(String[] args)  {
		
		int[] scores = { 90, 95, 79, 83, 88, 65, 72, 83, 81, 96 };

		int sum = 0;

		// for-each 문: scores 배열변수의 각 원소에 대해 자동적으로 반복하여 합 구함
		for (int score : scores) // scores 배열변수의 원소 하나씩을 score 변수에 저장하여
		    sum = sum + score; 	 //    score 값을 sum에 누적
		
		System.out.println("\n  ** for-each 문 사용하여 점수 10개 합 구하기 **\n  ");
		System.out.println("  * 점수들 개수: " + scores.length);    
		System.out.println("  * 점수들 합: " + sum); 
				
		// for (int score : scores) 
		//    sum = sum + score; 
		//
		//    ==> for 문으로 변환하기: scores 배열의 원소 개수만큼 직접 반복시킴
		
		sum = 0;

		for (int i = 0; i < scores.length; i++) {	// i를 0부터 (원소 개수 - 1)까지 반복하여 합 구함
		    int score = scores[i];                  //   i번째 원소를 score에 저장
		    sum = sum + score;; 	                //   score 값을 sum에 누적
		}
		
		System.out.println("\n\n  ** for 문 사용하여 점수 10개 합 구하기 **\n  ");
		System.out.println("  * 점수들 개수: " + scores.length);    
		System.out.println("  * 점수들 합: " + sum); 
				
		// 이 부분에 실습 과제 작성하라.
	}
}

/*
 * 
 * [ 실습과제 ]
 * 
 *   o 여러 사람의 이름을 저장하는 문자열 배열 names를 다음과 같이 선언하고 초기화 한 후 
 *     for 문과 for-each 문을 각각 이용하여 출력하는 코드를 추가로 작성하라.
 *      
 *       String[] names = { "홍길동",  "이몽룡", "감자바" };  // 여러 이름 저장하는 배열
 *      
 * 
 * [ 참고사항 ]
 * 
 *   o 초보자일 때 for-each 문 사용하지 않는 것 권유
 *   
 *   o 그 이유는 for 문을 완전히 익히면 for-each 문은 아주 쉽게 익혀지기 때문이며
 *     지금은 for 문 익히는 것이 훨씬 중요하기 때문임
*/
