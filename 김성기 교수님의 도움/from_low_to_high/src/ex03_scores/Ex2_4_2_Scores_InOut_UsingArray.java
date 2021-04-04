package ex03_scores;

/*
 * [ Scores_InOut_UsingArray ]: 배열을 이용하여 10명의 점수를 입력한 후 저장 및 출력
 * 
 *   o 프로그래밍 스타일
 *     1) main() 메소드로만 클래스 구성
 *     2) 배열변수의 선언, 입력하여 원소에 저장, 원소 출력
 *  
 *   o 10명의 점수를 입력하여 배열변수의 원소에 저장
 *    - 배열변수의 선언: 타입[] 배열변수 = new 타입[저장할_원소_개수];
 *         예: int[] scores = new int[10]; // 10개의 원소를 저장할 int 배열 객체를 생성하여 scores 배열변수에 저장
 *         
 *     - 입력한 값을 배열 원소에 저장: 배열변수[인덱스] = SkScanner.getXxx();
 *         예: scores[0] = SkScanner.getInt();  // 배열 원소의 인덱스는 0부터 시작함 
 *             scores[1] = SkScanner.getInt();  
 *             scores[2] = SkScanner.getInt();
 *             
 *   o SkScanner.getInt(): 정수 값을 입력, 정수가 아닌 것은 모두 무시됨                 
 */ 

class Ex2_4_2_Scores_InOut_UsingArray {

	public static void main(String[] args) {     
		int[] scores = new int[10];    // 10명의 점수를 저장할 배열 객체를 scores 배열변수에 저장함 

		// 10명의 점수를 입력하여 배열변수의 인덱스 0부터 9까지의 원소에 저장
		System.out.println("\n  **  10명의 점수 입력 **");  // 입력을 위한 타이틀 출력
		System.out.print("  o 10명 점수 입력하시오 > ");  // 프롬프트 메시지 출력   
		scores[0] = SkScanner.getInt();   // 정수 값 입력하여 원소로 저장
		scores[1] = SkScanner.getInt();          
		scores[2] = SkScanner.getInt();    
		scores[3] = SkScanner.getInt();      
		scores[4] = SkScanner.getInt();   
		scores[5] = SkScanner.getInt();      
		scores[6] = SkScanner.getInt();     
		scores[7] = SkScanner.getInt();     
		scores[8] = SkScanner.getInt();    
		scores[9] = SkScanner.getInt();     


		//  입력된 10명의 점수를 모두 출력
		System.out.println("\n  **  입력된 10명의 점수 **");  // 출력을 위한 타이틀 출력
		System.out.println("  * " + scores[0] + "  "  + scores[1] + "  "  + scores[2] + "  "
				+ scores[3] + "  "  + scores[4] + "  "  + scores[5] + "  "  + scores[6] + "  "  
				+ scores[7] + "  "  + scores[8] + "  "  + scores[9] ); 


		System.out.println("\n  ^^ Well done! Have a good time!!! ^^\n"); // 이 문장은 프로그램의 종료를 나타내는 문장임
    }

}

/*
 * [ 프로그램의 이해 및 실행 ]
 *    
 *   1) 주어진 프로그램을 살펴보고 프로그램의 구조를 파악하라.
 *       
 *   2) 프로그램을 실행하여 점수들을 입력하고 결과를 확인하라.
 *     
 *   
 * [ 실습과제 ]
 *
 *   1) 20명의 점수를 입력하여 배열 원소에 저장하고 출력하도록 프로그램을 수정하라.
 *      
 *   2) 이 프로그램의 스타일대로 100명의 점수를 입력하여 원소에 저장하고 이를 출력하도록 
 *      프로그램을 수정할 수 있겠는가? 본인이 작성할 수 있는 최대의 점수 개수는 몇개인가? 
 *      최대 개수까지 점수를 입력하여 배열 원소에 저장하고 출력하도록 프로그램을 수정하라. 
 *      이 프로그래밍 작업은 단순하지만 배열에 대한 깊은 이해를 하게 할 것이다.
 *         
 *    
  *          
 *     
 * [ 참고사항 ]
 * 
 *   o 실습과제를 할 때에는 주어진 프로그래밍 스타일을 이용하여 프로그램을 작성하여야 한다. 
 *             
 */


