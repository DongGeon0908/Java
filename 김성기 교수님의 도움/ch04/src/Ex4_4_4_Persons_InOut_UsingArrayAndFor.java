/**
 * [ Persons_InOut_UsingArrayAndFor]: 신상정보들 입력한 후 저장 및 출력(배열과 For 문장 이용)
 * 
 *   o 프로그래밍 스타일 
 *     1) main() 메소드로만 클래스 구성
 *     2) 배열변수 선언, for 문장 이용하여 간결하게 입력, 저장, 원소 출력
 *               
 *   o 프롬프트 메시지 출력 후 타입별로 값을 입력하는 메소드인 SkScanner.getXxxWithPrompt() 
 *     - SkScanner.getStringWithPrompt(문자열메시지):  메시지 출력 후 문자열 입력
 *     - SkScanner.getIntWithPrompt(문자열메시지):     메시지 출력 후 정수 입력
 *     - SkScanner.getDoubleWithPrompt(문자열메시지):  메시지 출력 후 실수 입력
 *     - SkScanner.getBooleanWithPrompt(문자열메시지): 메시지 출력 후 boolean 입력         
 */ 

class Ex4_4_4_Persons_InOut_UsingArrayAndFor {

	public static void main(String[] args) {
		int noPersons = 3;

		//  신상정보 항목(이름, 나이, 현위치)들을 저장하기 위한 배열변수 선언
		String[] names = new String[noPersons]; // noPersons 명의 이름 저장할 문자열 배열변수 
		int[] ages = new int[noPersons];        // noPersons 명의  나이 저장할 정수 배열변수 
		String[] currentLocations = new String[noPersons];  // 현위치 저장할 문자열 배열변수

		// 입력을 위한 타이틀 출력
		System.out.println("\n  **  " + noPersons + "명의 신상정보 입력 **");  

		for (int i = 0; i < noPersons; i++) {
			// 신상정보 항목 값을 입력하여 배열변수들의 인덱스 i 위치에 원소 저장
			names[i] = SkScanner.getStringWithPrompt("\n  o " + ( i + 1) + "번째 이름 > ");   
			ages[i] = SkScanner.getIntWithPrompt("                 나이 > ");                      
			currentLocations[i] = SkScanner.getStringWithPrompt("                 현위치 > ");     
		}

		// 출력을 위한 타이틀 출력
		System.out.println("\n  **  입력된 " + noPersons + "명의 신상정보 **\n");  

		for (int i = 0; i < noPersons; i++) {
			System.out.println("  * " + (i + 1) + "번째 " + names[i] + "의 나이는 " + ages[i] 
					+ "세이고 " + currentLocations[i]  + "에 있음 ");
		}		
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *   
 *   1) 주어진 프로그램을 살펴보고 프로그램의 내용을 파악하라.
 *   
 *      - Persons_InOut_UsingArrayFor 클래스가 선언되어 있으며, 클래스 내부에 
 *        main() 메소드가 작성되어 있다. 
 *      
 *      - main() 메소드는 배열변수 선언 및 배열 객체 저장, for 문장을 이용하여 
 *        입력한 신상정보 항목을 배열 원소에 저장, 배열 원소의 출력 등을 수행한다.
 *      
 *      - 특히 프롬프트 메시지 출력 후 타입별로 값을 입력하는 메소드인 
 *        SkScanner.getXxxWithPrompt()를 사용하여 입력에 필요한 문장을 하나로 줄인다. 
 *       
 *   2) 프로그램을 실행하여 항목을 입력하고 결과를 확인하라.
 *     
 *   
 * [ 실습과제 ]
 *
 *   o 모두 5명의 신상정보를 저장하고 출력할 수 있도록 프로그램을 변경하라.
 *     
 *     잘 작성된 프로그램은 요구사항 변경 시 쉽게 프로그램을 변경할 수 있는 프로그램이다.
 *     그러한 관점에서 이 프로그램은 아주 잘 작성된 프로그램이다.               
 */
