package ex03_scores;

/*
 * [ ScoresAverage_NotUsingArray ]: 10명의 점수를 단순변수에 저장하여 합, 평균을 구하여 출력
 * 
 * 
 *   o 프로그래밍 스타일
 *     1) main() 메소드로만 클래스 구성
 *     2) 단순변수 선언, 점수 입력하여 각 변수에 저장
 *     3) 점수의 합, 평균을 구하기
 *  
 *   o 10명의 점수를 저장하는 단순변수를 선언하고 점수를 입력하여 각 변수에 저장
 *     - 10명의 점수를 저장하기 위해 score1부터 score10까지 10개의 변수 선언
 *     - 10개 변수에 값 입력
 *     - 10개 변수의 합과 평균 구하기
 */ 

class Ex3_4_1_ScoresAverage_NotUsingArray {

	public static void main(String[] args) {   
		System.out.println("\n  **** 10명의 점수 입력 및 합과 평균 구하기 ****");  	// 입력을 위한 타이틀 출력      
		
		// 10명의 점수를 저장할 단순변수 10개 선언
		int score1, score2, score3, score4, score5, score6, score7, score8, score9, score10; 
		
		int noStudents = 10;  // 학생수 저장
		int sumScores;        // 점수 합 저장
		double avgScores;     // 점수 평균 저장		   
		
		// 10명의 점수를 입력하여 score1부터 score10까지의 변수에 저장
		System.out.println("\n  **  10명의 점수 입력 **");  	// 입력을 위한 타이틀 출력      
		System.out.print("  o 10명 점수 입력하시오 > ");       	// 프롬프트 메시지 출력   
		
		score1 = SkScanner.getInt();   // 정수 값 입력하여 각 변수에 차례로 저장
		score2 = SkScanner.getInt();          
		score3 = SkScanner.getInt();    
		score4 = SkScanner.getInt();      
		score5 = SkScanner.getInt();   
		score6 = SkScanner.getInt();      
		score7 = SkScanner.getInt();     
		score8 = SkScanner.getInt();     
		score9 = SkScanner.getInt();    
		score10 = SkScanner.getInt();     

		// 입력된 10명의 점수를 모두 출력 
		System.out.println("\n  **  입력된 10명의 점수 **");  // 출력을 위한 타이틀 출력
		System.out.println("  * " + score1 + "  "  + score2 + "  "  + score3 + "  "
			     + score4 + "  "  + score5 + "  "  + score6 + "  "  + score7 + "  "  
				 + score8 + "  "  + score9 + "  "  + score10 ); 

		// 입력된 10명의 점수 합을 구함
		sumScores = score1 + score2 + score3 + score4 + score5 
				    + score6 + score7 + score8 + score9 + score10; 

		// 점수 합을 학생수로 나누어 점수 평균을 구함
		avgScores = sumScores / (double) noStudents;  // 실수 평균을 구하기 위해 noStudents를 double로 캐스트시킴

		System.out.println("\n  ** 학생 점수 현황 **");
		System.out.println("  * 총 학생수 = " +noStudents);
		System.out.println("  * " +noStudents + " 학생 점수 합 = " + sumScores);
		System.out.println("  * " +noStudents + " 학생 점수 평균 = " + avgScores);
	}

}

/*
 * [ 프로그램의 이해 및 실행 ]
 *
 *   1) 주어진 프로그램을 살펴보고 프로그램의 내용를 파악하라.
 *   
 *      10명의 학생 점수를 저장할 변수들을 선언하여 점수 입력하여 
 *      합과 평균을 구하여 출력한다
 *      
 *   2) 프로그램을 실행하여 결과를 확인하라.
 *
 *
 * [ 실습과제 ]
 *
 *   1) 30명의 점수를 입력하여 단순변수에 저장하고 합과 평균을 구하여 출력하는 프로그램을 
 *      Pr3_4_1_Scores30Average_NotUsingArray 클래스로 작성하라.     
 *      (Ex3_4_1_ScoresAverage_NotUsingArray.java를 Pr3_4_1_Scores30Average_NotUsingArray.java로 
 *       복사한 후 수정할 것)        
 *
 *
 * [ 참고사항 ]
 * 
 *   o 실습과제를 할 때에는 주어진 프로그래밍 스타일을 이용하여 프로그램을 작성하여야 한다. 
 *            
 */

