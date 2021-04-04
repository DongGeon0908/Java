package ex03_scores;

/*
 * [ Scores_InOut_NotUsingArray ]: 배열변수 이용 않고서 10명의 점수를 입력한 후 저장 및 출력
 * 
 *   o 프로그래밍 스타일
 *     1) main() 메소드로만 클래스 구성
 *     2) 단순변수 선언, 입력하여 변수에 저장, 출력
 *  
 *   o 10명의 점수를 저장하는 단순변수를 선언하고 점수를 입력하여 각 변수에 저장
 *     - 10명의 점수를 저장하기 위해 score1부터 score10까지 10개의 변수 선언
 *     - 10개의 변수에 점수 입력하여 출력
 *             
 *     - SkScanner.getInt(): 정수 값을 입력, 정수가 아닌 것은 모두 무시됨                 
 */ 

class Ex2_4_1_Scores_InOut_NotUsingArray {

	public static void main(String[] args) {   
		// 10명의 점수를 저장할 단순변수 10개 선언
		int score1, score2, score3, score4, score5, score6, score7, score8, score9, score10; 

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
		
		System.out.println("\n\n  ^^ Well done! Have a good time!!! ^^\n"); // 이 문장은 프로그램의 종료를 나타내는 문장임
	}

}

/*
 * [ 프로그램의 이해 및 실행 ]
 *   
 *   1) 주어진 프로그램을 살펴보고 프로그램의 구조를 파악하라.
 *   
 *      Ex2_4_1_scores_Out 클래스가 선언되어 있으며, 클래스 내부에 
 *      main() 메소드가 작성되어 있다. 
 *      
 *      main() 메소드는 단순변수 선언 및 변수에 값 입력하여 저장, 
 *      변수의 출력 등을 수행하는 여러 문장들로 구성되어 있다.
 *     
 *       
 *   2) 프로그램을 실행하여 점수들을 입력하고 결과를 확인하라.
 *     
 *  
 * [ 실습과제 ]
 *   
 *   1) 20명의 점수를 입력하여 변수에 저장하고 출력하는 프로그램을 Pr2_4_1_Scores20_InOut 
 *      클래스로 작성하라. 나머지 10명의 점수는 자유롭게 결정하라.     
 *      (Ex2_4_1_Scores_Out.java를 Pr2_4_1_Scores20_Out.java로 복사한 후 수정하면 작업시간이 단축됨)
 *      
 *   2) 이 프로그램의 스타일대로 100명의 점수를 저장하고 이를 출력하는 프로그램을 작성한다고 
 *      하면 할 수 있겠는가? 본인이 작성할 수 있는 최대의 점수 개수는 몇개인가? 최대 개수까지 
 *      점수를 저장하고 출력하는 프로그램을 작성해보라. 이 프로그래밍 작업은 단순하지만 
 *      많은 것을 이해하게 할 것이다.
 *              
 * 
 * [ 참고사항 ]
 * 
 *   1) 실습과제를 할 때에는 주어진 프로그래밍 스타일을 이용하여 프로그램을 작성하여야 한다. 
 *            
*/
