/**
 * [ Scores_InOut ]: 10명의 점수를 입력한 후 저장 및 출력
 *        (java.util.Scanner 클래스의 nextInt() 메소드 이용)
 * 
 *   o 프로그래밍 스타일
 *     1) main() 메소드로만 클래스 구성
 *     2) 유사한 여러 단순변수 선언, 여러 값 입력하여 변수에 저장, 출력
 *  
 *   o 10명의 점수 저장하는 단순변수들 선언하고 점수 입력하여 각 변수에 저장
 *     - 10명의 점수 저장하기 위해 score1부터 score10까지 10개의 변수 선언
 *     - 10개의 변수에 점수 입력하여 출력
 *             
 *   o java.util.Scanner 클래스의 메소드 이용하여 정수와 실수 입력 
 *      - java.util.Scanner 클래스: Java에서 자체적으로 제공하는 문자열 입력을 위한 클래스 
 *      - Scanner 클래스 객체 생성 후 참조 변수에 저장한 후 입력 가능
 *          java.util.Scanner scanner = new new java.util.Scanner(System.in);        
 *          
 *      - nextInt(), nextDouble() 사용하여 정수와 실수 입력
 *        (1) 정수 입력: int score = scanner.nextInt();        
 *        (2) 실수 입력: double rate = scanner.nextDouble();         
 */ 

class Ex2_4_2_Scores_InOut {

	public static void main(String[] args) {  
		// nextInt() 메소드 사용하여 정수 입력하기 위해 Scanner 객체 생성하여 저장
		java.util.Scanner scanner = new java.util.Scanner(System.in); 
	
		// 10명 점수 저장할 단순변수 10개 선언
		int score1, score2, score3, score4, score5, score6, score7, score8, score9, score10; 

		System.out.println("\n\n  **** 10명의 점수 입력하여 출력 ****\n");  // 프로그램 타이틀 출력

		// 10명 점수 입력하여 score1부터 score10까지의 변수에 저장
		System.out.println("\n  **  10명의 점수 입력 **\n");       // 입력을 위한 타이틀 출력   
		
		System.out.print("  o 10명 점수를 차례로 입력하시오 > ");    // 프롬프트 메시지 출력   
		score1 = scanner.nextInt();   // 정수 값 입력하여 각 변수에 차례로 저장
		score2 = scanner.nextInt();          
		score3 = scanner.nextInt();  
		score4 = scanner.nextInt();    
		score5 = scanner.nextInt();
		score6 = scanner.nextInt();     
		score7 = scanner.nextInt();   
		score8 = scanner.nextInt();   
		score9 = scanner.nextInt(); 
		score10 = scanner.nextInt();

		// 입력된 10명의 점수를 모두 출력 
		System.out.println("\n\n  **  입력된 10명의 점수**\n");  // 출력을 위한 타이틀 출력
		
		System.out.println("  * " + score1 + "  " + score2 + "  " + score3 + "  "
				                  + score4 + "  " + score5 + "  " + score6 + "  "
				                  + score7 + "  " + score8 + "  " + score9 + "  " + score10 ); 
		
		System.out.println("\n\n  ^^ Well done! Have a good time!!! ^^\n"); // 이 문장은 프로그램의 종료를 나타내는 문장
	}

}

/*
 * [ 프로그램의 이해 및 실행 ]
 *   
 *   1) 주어진 프로그램 살펴보고 프로그램의 내용 파악하라.
 *   
 *      Ex2_4_2_Scores_InOut_NotUsingArray 클래스가 선언되어 있으며, 클래스 내부에 
 *      main() 메소드가 작성되어 있다. 
 *      
 *      main() 메소드는 단순변수 선언 및 변수에 값 입력하여 저장, 
 *      변수의 출력 등을 수행하는 여러 문장들로 구성되어 있다.
 *        
 *   2) 프로그램을 실행하여 점수들을 입력하고 결과를 확인하라.
 *   
 *  
 * [ 실습과제 ]
 *   
 *   1) 20명의 점수를 입력하여 변수에 저장하고 출력하도록 프로그램을 변경하라. 
 *      반드시 10명의 점수마다 새로운 프롬프트 메시지를 출력하도록 하라.  
 *         
 *      (프로그램 부분을 복사하고 붙여넣기하여 변경하면 작업시간이 단축되며, 이러한 요령도 숙지해야 함)
 *      
 *   2) 50명의 점수를 입력하여 50개의 변수에 저장하고 출력하는 프로그램을 Pr2_4_2_Scores50_InOut
 *      클래스로 작성하고 실행하라. 반드시 10명의 점수마다 새로운 프롬프트 메시지를 출력하도록 하라.
 *
 *     (Ex2_4_2_Scores_InOut.java를 Pr2_4_2_Scores50_InOut.java로 
 *      복사한 후 변경하면 작업시간 단축됨)
 *     
 *   3) 이 프로그램의 스타일대로 100명 또는 1000명의 점수를 입력하여 저장하고 이를 출력하는 프로그램을 
 *      작성한다고 하면 할 수 있겠는가? 
 *
 *      본인이 작성할 수 있는 최대 점수 개수는 몇 개인가? 최대 개수까지 점수 저장하고 출력하는 프로그램을  
 *      Pr2_4_2_ScoresMax_InOut 클래스로 작성하라. 
 *
 *      이 프로그래밍 작업은 단순하지만 많은 것을 생각하고 이해하게 할 것이다.
 *              
 *   4) 이 프로그램은 Java에서 제공하는 입력 수단인 java.util.Scanner 클래스의 nextInt()를 이용하여 
 *      정수를 입력한다.
 *      
 *     SkScanner.getInt() 메소드를 이용하도록 프로그램을 변경하라.
 *      
 *      이를 위하여 main() 메소드의 첫 부분에 있는 
 *      << java.util.Scanner scanner = new java.util.Scanner(System.in); >>을 제거하고
 *      <<scanner.nextInt() >> 대신에 << SkScanner.getInt() >>를 사용한다. 
 *      
 *   
 * [ 참고사항 ]
 * 
 *   1) 실습과제를 할 때에는 주어진 프로그래밍 스타일을 이용하여 프로그램을 작성하여야 한다. 
 *   
 *   2) Pr2_4_2_Scores50_InOut 클래스를 작성할 때에는 처음부터 새로운 클래스를 생성하여
 *      main() 메소드가 공백인 상태에서 문장들을 작성하여도 된다.
 *       
 *      그러나, Pr2_4_2_Scores50_InOut 클래스는 이미 작성된 Ex2_4_2_Scores_InOut 클래스와 
 *      내용이 유사한 부분이 많다. 이러한 경우에는 Pr2_4_2_Scores_InOut 클래스를 
 *      복사(Copy)하고 붙여넣기(Paste)를 하여 작성하면 편리하고 시간도 절약된다.
 *      
 *      Eclipse에서도 복사 및 붙여넣기 기능을 제공하며, 붙여넣기한 클래스는 새로운 
 *      클래스 이름으로 저장하면 된다.
 *      
 *      클래스 붙여넣기 과정은 다음과 같다.
 *     
 *      (default package)에서 복사할 클래스를 클릭 -> 마우스 오른쪽 버튼 클릭 
 *        -> Copy -> (default package) 클릭 -> 마우스 오른쪽 버튼 클릭 -> Paste
 *        -> 붙여넣기할 클래스에 대한 새로운 이름 입력 -> OK 버튼 클릭
 *        -> (default package)에 새로운 붙여넣기한 클래스가 생성
 *        -> 생성된 클래스 더블 클릭 -> 클래스의 내용 확인 후 변경   
 *            
*/
