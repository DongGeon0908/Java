
package ex02_persons;

/*
 * [ Persons_InOut_UsingArray ]: 배열을 이용하여 신상정보 입력한 후 저장 및 출력
 * 
 *   o 프로그래밍 스타일 
 *     1) main() 메소드로만 클래스 구성
 *     2) 배열변수의 선언, 입력하여 원소 저장, 원소 출력
 *  
 *   o 신상정보를 저장하는 배열변수를 선언하고 3명의 이름, 나이, 현위치를 입력하여 배열의 원소로 저장
 *     - 배열변수의 선언: 타입[] 배열변명; 
 *         예: String[] names;         // names 배열변수 선언, []은 배열변수임을 나타내는 분리자임
 *         
 *     - 배열 객체를 배열변수에 저장: 배열변수 = new 타입[저장원소개수];
 *         예: names = new String[3]; // 3개의 원소를 저장할 String 배열 객체를 생성하여 names 배열변수에 저장
 *         
 *     - 입력한 신상정보 항목을 배열 원소에 저장: 배열변수[인덱스] = 입력한_신상정보_항목;
 *         예: names[0] = SkScanner.getString(); // 배열 원소의 인덱스는 0부터 시작함 
 *             names[1] = SkScanner.getString();   
 *             names[2] = SkScanner.getString();
 *             
 *   o 타입별로 값을 입력하는 메소드인 SkScanner.getXxx() 
 *     - SkScanner.getString():   엔터키 입력까지의 문자열 값을 입력
 *     - SkScanner.getInt():      정수 값을 입력, 정수가 아닌 것은 모두 무시됨
 *     - SkScanner.getDouble():   실수 값을 입력, 실수가 아닌 것은 모두 무시됨
 *     - SkScanner.getBoolean() : true 또는 false를 boolean 값으로 입력, true 또는 false가 아닌 것은 모두 무시됨
 *         
         
 */ 

class Ex2_5_3_Persons_InOut_UsingArray {

	public static void main(String[] args) {
		/*
		 *  신상정보 항목(이름, 나이, 현위치)을  저장하기 위한 배열변수 선언
		 *  배열변수 이름은 보통 복수형을 이용함
		 */
		String[] names;             // 여러 이름 저장할 문자열 배열변수 
		int[] ages;                 // 여러 나이 저장할 정수 배열변수 
		String[] currentLocations;  // 여러 현위치 저장할 문자열 배열변수

		/*
		 *  신상정보 항목(이름, 나이, 현위치)을 저장할 배열변수에 배열 객체를 저장
		 *  지금 단계에서 이해하기 어렵지만 이 작업을 꼭 해야함
		 */
		names = new String[3];             // 3 개의 이름을 저장할 배열 객체를 names 배열변수에 저장함 
		ages = new int[3];                 // 3 개의 나이를 저장할 배열 객체를 ages 배열변수에 저장함  
		currentLocations = new String[3];  // 3 개의 이름을 저장할 배열 객체를 currentLocations 배열변수에 저장함 

		/*
		 *  3명의 신상정보 항목들을 입력하여 배열변수의 원소에저장
		 */

		System.out.println("\n  **  3명의 신상정보 입력 **");  // 입력을 위한 타이틀 출력
		
		// 첫번째 신상정보 항목 값을 입력하여 배열변수들의 인덱스 0 위치에 원소 저장
		System.out.print("\n  o 첫번째 이름 > "); // System.out.print() 이용하여 프롬프트 메시지 출력   
		names[0] = SkScanner.getString();         // SkScanner.getString()를 이용하여 문자열 입력하여 원소로 저장
		
		System.out.print("           나이 > ");   // 프롬프트 메시지 출력	     
		ages[0] = SkScanner.getInt();             // 정수 입력하여 원소로 저장   
		
		System.out.print("           현위치 > ");    // 프롬프트 메시지 출력	
		currentLocations[0] = SkScanner.getString();  // 문자열 입력하여 원소로 저장
				
		// 두번째 신상정보 항목 값을 입력하여 배열변수들의 인덱스 1 위치에 원소 저장
		System.out.print("\n  o 두번째 이름 > ");  // 프롬프트 메시지 출력   
		names[1] = SkScanner.getString();          // 문자열 입력하여 원소로 저장
		
		System.out.print("           나이 > ");    // 프롬프트 메시지 출력	     
		ages[1] = SkScanner.getInt();              // 정수 입력하여 원소로 저장   
		
		System.out.print("           현위치 > ");     // 프롬프트 메시지 출력	
		currentLocations[1] = SkScanner.getString();  // 문자열 입력하여 원소로 저장		
		
		// 세번째 신상정보 항목 값을 입력하여  배열변수들의 인덱스 2 위치에 원소 저장
		System.out.print("\n  o 세번째 이름 > ");  // 프롬프트 메시지 출력   
		names[2] = SkScanner.getString();          // 문자열 입력하여 원소로 저장
		
		System.out.print("           나이 > ");    // 프롬프트 메시지 출력	     
		ages[2] = SkScanner.getInt();              // 정수 입력하여 원소로 저장   
		
		System.out.print("           현위치 > ");     // 프롬프트 메시지 출력	
		currentLocations[2] = SkScanner.getString();  // 문자열 입력하여 원소로 저장
		

		/*
		 *  입력된 3명의 신상정보(이름, 나이, 현위치) 출력, 
		 *      출력할 여러 값들을 + 로 접속하여 출력함
		 */  
		System.out.println("\n  **  입력된 3명의 신상정보 **\n");  // 출력을 위한 타이틀 출력 
		System.out.println("  * 첫번째 " + names[0] + "의 나이는 " + ages[0] + "세이고 "  + currentLocations[0]  + "에 있음 ");
		System.out.println("  * 두번째 " + names[1] + "의 나이는 " + ages[1] + "세이고 "  + currentLocations[1]  + "에 있음 ");
		System.out.println("  * 세번째 " + names[2] + "의 나이는 " + ages[2] + "세이고 "  + currentLocations[2]  + "에 있음 ");
		
		
		System.out.println("\n  ^^ Well done! Have a good time!!! ^^\n"); // 이 문장은 프로그램의 종료를 나타내는 문장임		
	}

}

/*
 * [ 프로그램의 이해 및 실행 ]
 *   
 *   1) 주어진 프로그램을 살펴보고 프로그램의 구조를 파악하라.
 *   
 *      - Ex2_5_3_Persons_InOut_UsingArray 클래스가 선언되어 있으며, 클래스 내부에 
 *        main() 메소드가 작성되어 있다. 
 *      
 *      - main() 메소드는 배열변수 선언 및 배열 객체 저장, 입력한 신상정보 항목을 
 *        배열 원소에 저장, 배열 원소의 출력 등을 수행하는 여러 문장들로 구성되어 있다.
 *       
 *   2) 프로그램을 실행하여 신상 항목을 입력하고 결과를 확인하라.
 *      
 *  
 * [ 실습과제 ]
 *
 *   1) 2명을 추가하여 모두 5명의 신상정보를 입력하여 저장하고 출력할 수 있도록 프로그램을 수정하라.
 *      (추가되는 2명 중 한명은 외국인으로 할 것)
 *      
 *   2) 키, 패스워드, 한국인여부를 저장할 배열변수인 double[] heights, String[] passwords, 
 *      boolean[] areKoreans을 추가적으로 선언하고 5명에 대한 데이터를 입력하여 배열 원소로 
 *      저장한 후 이를 출력하도록 프로그램을 수정하라. 수정이 완료되면 실행하여 결과를 
 *      확인하라. 
 *  
 *   3) 책 5권에 대해 제목, 저자, 출판사, 가격, 페이지수 등의 책 정보를 저장하기 위한  
 *      배열변수들을 각각 선언하고 책 정보 항목을 입력하여 배열 원소에 저장하고  
 *      출력하는 프로그램을 Pr2_5_3_Books_InOut_UsingArray 클래스로 작성하라.
 *      (5권의 책 정보 항목은 자유롭게 정해도 됨)
 *      
 *   4) 책 20권에 대해 실습과제 3)의 작업을 수행하는 프로그램을 Pr2_5_3_Books20_InOut_UsingArray 
 *      클래스로 작성한다고 할 때 Pr2_5_3_Books20_InOut_UsingArray 클래스의 문장 개수를 
 *      계산해서 제출하라. (문장은 main() 메소드에서 ;으로 끝나는 부분이 하나의 문장이며, 
 *      계산 결과는 Pr2_5_3_Books_InOut_UsingArray 클래스의 아래 쪽에 기술하여 제출하며, 
 *      계산 근거도 보여야 함)
 *      
 *
 * [ 참고사항 ]
 * 
 *   o 실습과제를 할 때에는 주어진 프로그래밍 스타일을 이용하여 프로그램을 작성하여야 한다. 
 *     예를 들어, Pr2_5_3_Books_InOut_UsingArray 클래스를 작성할 때에는 main() 메소드로만 
 *     클래스 구성하고, 5권의 책 정보 항목들을 저장하기 위한 배열변수들을 선언하고 입력된 
 *     값을 배열 원소에 저장해야 한다. 
 *      
 *    
 * [ 스스로 생각하고 고민할 과제 ]  
 *   
 *   o 실습 과제 4)에서 책 20권의 정보를 입력하고 출력하기 위해 필요한 문장의 개수를 
 *     계산하면 최소한 100개가 넘을 것이며, 이는 100 라인이 넘는 긴 프로그램을 작성해야 
 *     한다는 뜻이다. 이렇게 긴 프로그램을 작성할 수 있을 것인지를 생각해보라.
 *       
 *     도전의식이 있는 학생은 20권의 책 정보를 배열에 입력하여 출력하는 프로그램인 
 *     Pr2_5_3_Books20_InOut_UsingArray 클래스를 작성해보기 바란다. 
 *     
 *     이 프로그래밍 작업은 Ex2_5_3_Books_InOut_UsingArray 클래스의 문장을 복사하여  
 *     붙이고 수정하는 단순하고 반복적인 작업이지만 많은 것을 생각하게 할 것이다.
 *     
 *       
 *   o 나중에 while 문, for 등의 복합문을 배우게 되면 지금의 단순하며 지겨운 작업이 
 *     스마트한 작업으로 바뀌어 프로그래밍 작업이 엄청 쉬워진다.           
 */
