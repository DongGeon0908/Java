 /**
 * [ ScoresAverage_NotUsingArray ]: 10명의 점수를 단순변수 이용하여 입력한 후 합, 평균 구하여 출력 
 * 
 *   o 프로그래밍 스타일
 *     1) main() 메소드로만 클래스 구성
 *     2) 10개의 단순변수 선언, 점수 입력하여 원소에 저장
 *     3) 점수의 합, 평균 구하기
 *  
 *   o 10명의 점수 저장하는 10개의 단순변수 선언하고 점수 입력하여 각 원소에 저장
 *     - 10명의 점수 저장하기 위해 단순변수 10개 선언
 *     - 변수 10개에 점수 입력
 *     - 점수 10개의 합과 평균 구하기
 */ 

class Ex3_5_1_ScoresAverage_NotUsingArray {

	public static void main(String[] args) {   
		System.out.println("\n  **** 10명의 점수 입력 및 합과 평균 구하기 ****");  	// 입력을 위한 타이틀 출력      
		
		// 10명의 점수를 저장할 단순변수 10개 선언
		int score1, score2, score3, score4, score5, score6, score7, score8, score9, score10; 
		
		int noStudents = 10;  // 학생수 저장
		int sumScores;        // 점수 합 저장
		double avgScores;     // 점수 평균 저장		   
		
		// 10명의 점수를 입력하여 score1부터 score10까지의 변수에 저장
		System.out.println("\n  **  10명 점수 입력 **");  	// 입력을 위한 타이틀 출력      
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

		// 입력된 10명 점수를 모두 출력 
		System.out.println("\n  **  입력된 10명 점수 **");  // 출력을 위한 타이틀 출력
		System.out.println("  * " + score1 + "  "  + score2 + "  "  + score3 + "  "
			     + score4 + "  "  + score5 + "  "  + score6 + "  "  + score7 + "  "  
				 + score8 + "  "  + score9 + "  "  + score10 ); 

		// 입력된 10명의 점수 합 구함
		sumScores = score1 + score2 + score3 + score4 + score5 
				    + score6 + score7 + score8 + score9 + score10; 

		// 점수 합을 학생수로 나누어 점수 평균 구함
		avgScores = sumScores / (double) noStudents;  // 실수 평균 구하기 위해 noStudents를 double로 캐스트

		System.out.println("\n  ** 학생 점수 현황 **");
		System.out.println("  * 총 학생수 = " +noStudents);
		System.out.println("  * " +noStudents + " 학생 점수 합 = " + sumScores);
		System.out.println("  * " +noStudents + " 학생 점수 평균 = " + avgScores);
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *
 *   1) 주어진 프로그램 살펴보고 프로그램의 내용 파악하라.
 *   
 *      10명의 학생 점수 저장할 변수들을 선언하여 점수 입력하고  합과 평균 구하여 출력한다.
 *      
 *   2) 프로그램 실행하여 결과 확인하라.
 *
 *
 * [ 실습과제 ]
 *
 *   1) 20명의 점수 입력하여 단순변수에 저장하고 합과 평균 구하여 출력하는 프로그램을 
 *      Pr3_1_1_ScoresAverage_NotUsingArray 클래스로 작성하라.   
 *        
 *      (Ex3_8_1_ScoresAverage_NotUsingArray.java를 Pr3_1_1_ScoresAverage_NotUsingArray.java로 
 *       복사한 후 변경할 것)        
 *
 *
 * [ 참고사항 ]
 * 
 *   1) 실습과제를 할 때에는 이 클래스의 프로그래밍 스타일과 동일한 스타일의 프로그램을 
 *      작성하여야 한다. 
 *      
 *   2) Pr3_1_1_ScoresAverage_NotUsingArray 클래스 작성할 때에는 처음부터 새로운 클래스 생성하여
 *      main() 메소드가 공백인 상태에서 문장들 작성하여도 된다.
 *       
 *      그러나, Pr3_1_1_ScoresAverage_NotUsingArray 클래스는 이미 작성된 
 *      Ex3_1_1_ScoresAverage_NotUsingArray 클래스와 내용이 유사한 부분이 많다. 
 *      
 *      이러한 경우에는 Pr3_1_1_ScoresAverage_NotUsingArray 클래스를  
 *      복사(Copy)하고 붙여넣기(Paste)로 작성하는 것이 편리하고 시간도 절약된다.
 *      
 *      Eclipse에서도 복사 및 붙여넣기 기능을 제공하며, 붙여넣기한 클래스를 새로운 
 *      클래스 이름으로 저장하면 된다.
 *      
 *      클래스 붙여넣기 과정은 다음과 같다.
 *     
 *      (default package)에서 복사할 클래스를 클릭 -> 마우스 오른쪽 버튼 클릭 
 *        -> Copy -> (default package) 클릭 -> 마우스 오른쪽 버튼 클릭 -> Paste
 *        -> 붙여넣기할 클래스에 대한 새로운 이름 입력 -> OK 버튼 클릭
 *        -> (default package)에 새로운 붙여넣기한 클래스가 생성됨
 *        -> 생성된 클래스 더블 클릭 -> 클래스의 내용 확인 후 변경                   
 */
