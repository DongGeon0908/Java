/**
 * [ Operation_Conditional: 조건 연산의 연습 ]
 *     
 *   o 프로그래밍 스타일 
 *     1) main() 메소드로만 클래스 구성
 *     2) 조건 연산을 수행하여 결과 값 출력
 *      
 *   o 조건 연산
 *     - 연산자는 ? : 
 *     - 형식: 조건 ? 값1 : 값2
 *     - 조건이 true이면 연산 결과로 값1을 생성하고 false이면 값2를 결과로 생성 
 */

class Ex3_1_10_Operation_Conditional   {
	public static void main(String[] args)  {

		int score1 = 94;
		int score2 = 89;
		
		System.out.println("\n  ** 조건 연산 ( ? : ) **\n");

		System.out.println("  * 변수 초기값: score1 = " + score1 + ", score2 = " + score2); 
		System.out.println(); 

		System.out.println("  * score1 >= 90 ? \"A\" : \"not A\"        := " + ( score1 >= 90 ? "A" : "not A" )); 
		System.out.println("  * score1 > score2 ? score1 : score2   := " + ( score1 > score2 ? score1 : score2 )); 
		System.out.println("  * score2 < 60 ? \"fail\" : \"not fail\"   := " + ( score2 < 60 ? "fail" : "not fail" )); 
		System.out.println(); 
		
		String grade;
		int maxScore;
		System.out.println("  * grade = score1 >= 90 ? \"A\" : \"not A\"         := " + ( grade = score1 >= 90 ? "A" : "not A" )); 
		System.out.println("  * maxScore = score1 > score2 ? score1 : score2 := " + ( maxScore = score1 > score2 ? score1 : score2 )); 
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *
 *   o 연산의 결과를 손으로 구해보고 수행한 결과와 비교해 보라.
 *  
 */