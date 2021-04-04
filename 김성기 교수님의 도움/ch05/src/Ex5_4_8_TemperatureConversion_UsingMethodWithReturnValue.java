/**
 * [ TemperatureConversion_UsingMethodWithReturnValue ]: 
 *        화씨온도와 섭씨온도간의 온도 변환(대체 메소드, 매개변수 및 반환값 갖는 메소드 사용)
 *   
 *   o 프로그래밍 스타일 
 *     - 대체 메소드, 매개변수 및 반환값 갖는 메소드를 작성하고 작성한 메소드 호출
 *       
 *   o 작성한 대체 메소드
 *     - static void convertTemperature(): 변환 종류 입력하여 해당 변환에 따른 작업 수행하도록 제어하는 메소드
 *     - static void displayMenus()
 *     - static void inputConvertOutputDegree_FtoC(): 화씨온도 입력하여 섭씨로 변환하여 출력하는 메소드
 *     - static void inputConvertOutputDegree_CtoF(): 섭씨온도 입력하여 화씨로 변환하여 출력하는 메소드
 *       
 *   o 작성한 매개변수 및 반환값 갖는 메소드
 *     - static int getMenu(int min, int max, String promptMsg, String errorMsg)
 *       
 *   o 온도 체계
 *     1) 섭씨온도(Centigrade temperature: 단위 C)
 *        어는 온도: 0, 끓는 온도: 100 (100 등분시킨 온도체계)
 *        
 *     2) 화씨온도(Fahrenheit temperature: 단위 F)
 *        어는 온도: 32, 끓는 온도: 212 (180 등분시킨 온도체계)
 *        
 *     3) 캘빈온도(Kelvin temperature: 단위 K): 
 *          -273.15C를 0K로 설정, 캘빈온도 0K 이하의 온도가 없는 물리학에서 사용하는 절대 온도체계
 *        
 *   o 온도 변환 공식
 *     - 화씨온도에서 섭씨온도로 변환
 *         C = (F - 32) * 5 / 9
 *       
 *     - 섭씨온도에서 화씨온도로 변환
 *     	   F = C * 9 / 5 + 32
 *     
 *     - 섭씨온도에서 캘빈온도로 변환
 *     	   K = F + 273.15  
 */

class Ex5_4_8_TemperatureConversion_UsingMethodWithReturnValue  {
	public static void main(String[] args)  {		
		convertTemperature();  // 온도 변환 메소드 호출
	}

	static void convertTemperature() {	
		while(true) {
			displayMenus();  // 메뉴 출력
			int menu = getMenu(1, 3, "\n  * Choose which > ", "\n  ??? Wrong task selected. Try again");

			if (menu == 1) 
				inputConvertOutputTemperature_FtoC();
			else if (menu == 2) 
				inputConvertOutputTemperature_CtoF();
			else if (menu == 3)
				break; 
		}
	}

	// 작업을 위한 메뉴들 출력하는 메소드
	static void displayMenus() {
		System.out.println("\n\n  ** Conversion of Temperature **");

		System.out.println("    1) Fahrenheit Temperature to Centigrade Temperature");
		System.out.println("    2) Centigrade Temperature to Fahrenheit Temperature");
		System.out.println("    3) End");
	}

	// promptMsg 출력한 후 min과 max 사이의 정수 입력하여 반환하는 메소드
	// min과 max 사이의 정수가 아닌 경우 errorMsg 출력하고 다시 입력 받음
	static int getMenu(int min, int max, String promptMsg, String errorMsg) {
		while(true) {
			int menu = SkScanner.getIntWithPrompt(promptMsg);
			if (menu >= min &&menu <= max)     //  min과 max 사이의 정수 입력하면 
				return menu;                   //    입력한 정수 반환
			else                               // min과 max 사이의 정수가 아닌 경우 
				System.out.println(errorMsg);  //    errorMsg를 출력하고 while 문 반복
		}

	}

	static void inputConvertOutputTemperature_FtoC() {
		double F, C;   // 화씨온도와 섭씨온도 저장할 변수: 메소드 내에서 변수 선언함 

		F = SkScanner.getDoubleWithPrompt("\n  o Input Fahrenheit degree > ");

		C = (F - 32) * 5 / 9;

		double C1 = (int) ((C + ((C>0) ? 0.05 : -0.05)) * 10) / 10.0; // 소수점 이하 2자리에서 반올림
		System.out.println("\n  * " + F + "F = " + C + "C = " + C1 + "C"); 
	}

	static void inputConvertOutputTemperature_CtoF() {
		// 이 메소드를 작성하라. 
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *  
 *   1) 이 프로그램은 예제 5-2-9의 프로그램을 개선한 프로그램이다.
 *   
 *      5-2-9의 프로그램과 이 프로그램을 비교해보면서 매개변수를 갖는 메소드와
 *      반환값 갖는 메소드의 장점을 이해하라.
 *      
 *   2) 화씨온도 32, 55.2, 180.5, 212에 대해 섭씨온도를 구하고
 *      섭씨온도 0, 22, 30, 100에 대해 화씨온도를 구하라.    
 *        
 *
 *  [ 실습과제 ] 
 *  
 *   1) inputConvertOutputDegree_CtoF() 메소드가 미완성이다. 이를 완성하라.
 *      
 *   2) 섭씨온도를 캘빈온도로 변환하고 캘빈온도를 섭씨온도로 변환하는 작업을 메뉴 3번과 4번으로 추가하고 
 *      inputConvertOutputTemperature_CtoK()와 inputConvertOutputTemperature_KtoC() 메소드를 
 *      추가 작성하라.
 */