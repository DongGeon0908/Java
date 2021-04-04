/**
 * [ ScoresAverage_UsingArray ]: 10명의 점수를 배열 이용하여 입력한 후 합, 평균 구하여 출력 
 * 
 *   o 프로그래밍 스타일
 *     1) main() 메소드로만 클래스 구성
 *     2) 배열변수 선언, 점수 입력하여 원소에 저장
 *     3) 점수의 합, 평균 구하기
 *  
 *   o 10명의 점수 저장하는 10개의 단순변수 선언하고 점수 입력하여 각 원소에 저장
 *     - 10명의 점수 저장하기 위해 단순변수 10개 선언
 *     - 변수 10개에 점수 입력
 *     - 점수 10개의 합과 평균 구하기
 */ 
 
class Ex3_5_2_ScoresAverage_UsingArray {

	public static void main(String[] args) {     
		System.out.println("\n  **** 10명의 점수 입력 및 합과 평균 구하기 ****");  	// 입력을 위한 타이틀 출력      
		
		int noStudents = 10;  // 학생수 저장
		int[] scores = new int[noStudents];    // 10명 점수 저장할 배열 객체를 scores 배열변수에 저장함 

		int sumScores;        // 점수 합 저장
		double avgScores;     // 점수 평균 저장		   
		
		// 10명 점수 입력하여 배열변수의 인덱스 0부터 9까지의 원소에 저장
		System.out.println("\n  **  10명 점수 입력 **");  // 입력을 위한 타이틀 출력
		System.out.print("  o 10명 점수 입력하시오 > ");     // 프롬프트 메시지 출력   
		scores[0] = SkScanner.getInt();                 // 정수 값 입력하여 원소로 저장
		scores[1] = SkScanner.getInt();          
		scores[2] = SkScanner.getInt();    
		scores[3] = SkScanner.getInt();      
		scores[4] = SkScanner.getInt();   
		scores[5] = SkScanner.getInt();      
		scores[6] = SkScanner.getInt();     
		scores[7] = SkScanner.getInt();     
		scores[8] = SkScanner.getInt();    
		scores[9] = SkScanner.getInt();     


		//  입력된 10명 점수를 모두 출력
		System.out.println("\n  **  입력된 10명 점수 **");  // 출력을 위한 타이틀 출력
		System.out.println("  * "   + scores[0] + "  "  + scores[1] + "  "  + scores[2] + "  "
				+ scores[3] + "  "  + scores[4] + "  "  + scores[5] + "  "  + scores[6] + "  "  
				+ scores[7] + "  "  + scores[8] + "  "  + scores[9] ); 

		// 입력된 10명의 점수 합 구함
		sumScores = scores[0] + scores[1] + scores[2] + scores[3] + scores[4] 
		            + scores[5] + scores[6] + scores[7] + scores[8] + scores[9] ; 

		// 점수 합을 학생수로 나누어 점수 평균 구함
		avgScores = sumScores / (double) noStudents;  // 실수 평균을 구하기 위해 noStudents를double로 캐스트

		System.out.println("\n  ** 학생 점수 현황 **");
		System.out.println("  * 총 학생수 = " + noStudents);
		System.out.println("  * " + noStudents + "명 학생 점수 합 = " + sumScores);
		System.out.println("  * " + noStudents + "명 학생 점수 평균 = " + avgScores);

		System.out.println("\n  ^^ Well done! Have a good time!!! ^^\n"); // 이 문장은 프로그램의 종료를 나타내는 문장

    }
}

/*
 * [프로그램의 이해 및 실행]
 *   
 *   1) 주어진 프로그램 살펴보고 배열변수의 선언, 배열원소 접근 등을 파악하라.
 *        
 *   2) 프로그램 실행하여 점수들 입력하고 결과 확인하라.
 *     
 *   
 * [ 실습과제 ]
 * 
 *   1) 20명의 점수 배열에 입력 및 출력
 *   
 *      20명의 점수 입력하여 배열변수에 저장하고 합과 평균 구하여 출력하는 프로그램을 
 *      Pr3_5_2_scoresAverage_UsingArray 클래스로 작성하라.     
 *      
 *      (Ex3_5_2_scoresAverage_UsingArray.java를 Pr3_5_2_scoresAverage_UsingArray로 
 *       복사한 후 변경할 것)
 *       
 *   2) 입력된 점수의 최저 점수와 최고 점수 구하기
 *   
 *      5명 학생의 점수를 입력하여 점수의 최저 점수와 최고 점수를 구하여 출력하는 프로그램을 
 *      요구하는 프로그래밍 스타일을 이용하여 다음의 사용자 인터페이스로 작성하시오. 
 *      (최저 점수와 최고 점수를 찾기 위해서는 비교 연산인 ? : 사용할 것이며, 
 *      <<  max = (n1 > n2 ? n1: n2); >>는 n1과 n2중 큰 값을 max 변수에 저장함)
 *
 *     ***************** 작성할 프로그램의 입출력 디자인 (시작) ******************* 
 * 
 *      ** 5명의 점수 입력하여 최고 점수 구하여 출력하기 **
 *
 *      o 1번째 점수 입력 > 90
 *      o 2번째 점수 입력 > 95
 *      o 3번째 점수 입력 > 79
 *      o 4번째 점수 입력 > 83
 *      o 5번째 점수 입력 > 88
 *
 *      * 최저 점수 = 79
 *      * 최고 점수 = 95
 *      
 *     ***************** 작성할 프로그램의 입출력 디자인 (끝) ******************* 
 *     
 *     (프로그래밍  스타일 1) 단순변수 사용, 반복문 미사용: 5개의 서로 다른 변수에 점수 입력하여 
 *                       최저 점수와 최고 점수 구하고 출력하는 프로그램을 
 *                       Pr3_5_2_scoresMinMax_NotUsingArray_Style1 클래스로 작성하라
 *                            
 *     (프로그래밍  스타일 2) 배열변수 사용, 반복문 미사용: 5개 원소를 저장하는 배열에 점수 입력하여 
 *                       최저 점수와 최고 점수 구하고 출력하는 프로그램을 
 *                       Pr3_5_2_scoresMinMax_UsingArray_Style2 클래스로 작성하라
 *                            
 *     (프로그래밍  스타일 3) 단순변수 사용, 반복문 미사용: 1개의 변수에만 점수 입력하여 
 *                       최저 점수와 최고 점수 구하고 출력하는 프로그램을 
 *                       Pr3_5_2_scoresMinMax_UsingMonoVar_Style3 클래스로 작성하라                            
 *                            
 *                                        
 * [ 스스로 생각하고 고민할 과제 ]  
 * 
 *   1) 아직까지 유용한 Java 프로그래밍 기법을 배우지 않았기 때문에 데이터의 개수가 늘어나면
 *      이에 따라 문장의 개수가 비례하여 늘어나게 된다. 나중에 for 문, while 문 등의 복합문을
 *      배우게 되면 지금의 단순하며 지겨운 작업이 스마트한 작업으로 바뀌어 프로그래밍 작업이 
 *      엄청 쉬워진다.
 *      
 *      for 문, while 문 등에 대해 조사하여 보라.
 *            
 *   
 * [ 참고사항 ]
 *
 *   1) 실습과제를 할 때에는 이 클래스의 프로그래밍 스타일과 동일한 스타일의 프로그램을  작성하여야 한다. 
 *      
 *   2) Pr3_5_2_scoresAverage_UsingArray 클래스 작성할 때에는 처음부터 새로운 클래스 생성하여
 *      main() 메소드가 공백인 상태에서 문장들 작성하여도 된다.
 *       
 *      그러나, Pr3_5_2_scoresAverage_UsingArray 클래스는 이미 작성된 
 *      Ex3_5_2_scoresAverage_UsingArray 클래스와 내용이 유사한 부분이 많다. 
 *      이러한 경우에는 Pr3_5_2_scoresAverage_UsingArray 클래스를  
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

