/**
 * [ Scores_InOut_UsingArrayNotUsingFor ]: 
 *        점수 10개를 배열 이용하여 입력한 후 출력하기 
 * 
 *   o 배열을 사용하기 위한 작업 과정
 *     1) 배열변수 선언
 *     2) 배열 원소에 값 저장
 *     3) 배열 원소 출력하기
 *  
 *   o 점수 10개를 입력하여 배열변수에 저장 후 출력하기
 *     - 점수 10개를 저장하기 위해 배열변수 선언
 *     - 10개 원소에 점수 입력
 *     - 점수 10개 출력
 */ 

class Ex4_4_1_Scores_InOut_UsingArrayNotUsingFor {
	public static void main(String[] args) { 

		// 점수 10개 저장할 배열변수 선언하고 배열 객체를 배열변수 scores에 저장함
		int[] scores = new int[10];   // 배열변수 선언은 항상 이렇게 할 것!!!

		// 점수 10개 입력하여 배열변수 인덱스 0부터 9까지의 원소에 저장
		System.out.println("\n  ** 점수 10개 입력 **");    // 입력 타이틀 출력 
		System.out.print("  o 점수 10개 입력하시오 > ");   // 프롬프트 메시지 출력 

		scores[0] = SkScanner.getInt();   // 정수 값 입력하여 배열 원소 scores[0]부터 차례로 저장
		scores[1] = SkScanner.getInt(); 
		scores[2] = SkScanner.getInt(); 
		scores[3] = SkScanner.getInt(); 
		scores[4] = SkScanner.getInt(); 
		scores[5] = SkScanner.getInt(); 
		scores[6] = SkScanner.getInt(); 
		scores[7] = SkScanner.getInt(); 
		scores[8] = SkScanner.getInt(); 
		scores[9] = SkScanner.getInt(); 

		// 입력된 점수 10개를 모두 출력 
		System.out.println("\n ** 입력된 점수 10개 **");   // 출력 타이틀 출력
		System.out.println("  * " + scores[0] + " " + scores[1] + " " + scores[2] + " " 
				+ scores[3] + " " + scores[4] + " " + scores[5] + " " + scores[6] + " "  
				+ scores[7] + " " + scores[8] + " " + scores[9] ); 
	}
}

/*
 * [ 프로그램의 이해 및 실행]
 *   
 *   1) 이 프로그램은 배열변수 사용하지만 for 문 사용 않고 10개의 점수 입력하고 출력한다.
 *      - 변수 선언에서 간단해 졌지만 입력 및 출력에서는  아주 불편함
 *      - 처리할 점수 개수가 10개에서 20개로 변경되면 많은 부분이 변경되어야 함
 *      - 프로그램의 요구가 변경될 때 프로그램의 변경이 많이 필요한 프로그램은 좋은 프로그램이 아님
 *        
 *   2) 프로그램을 실행하여 점수들을 입력하고 결과를 확인하라.
 *     
 *   
 * [ 실습과제 ]
 * 
 *   1) 점수 개수가 13개로 변경되었다. 13개의 점수를 입력하여 출력하도록 변경하라.
 *      (주석을 포함하여 변경될 모든 부분을 찾아 변경하라)
 *
 *   2) 20개 점수를 배열에 입력하고 합과 평균을 출력하라.
 *   
 *      20개의 점수를 입력하여 배열변수에 저장하고 합과 평균을 구하여 출력하는 프로그램을 
 *      Pr4_4_1_scoresAverage_UsingArrayNotUsingFor 클래스로 작성하라.     
 *      (반드시 이 프로그램의 스타일대로 for 문을 사용하지 말아야 함)
 *            
 *   
 * [ 참고사항 ]
 * 
 *   o 실습과제를 할 때에는 주어진 프로그래밍 스타일을 이용하여 프로그램을 작성하여야 한다.       
 */

