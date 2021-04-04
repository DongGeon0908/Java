package ex06_temperature;

/*
 * [ TemperatureConversionMany_SwitchMethod ]: switch 문과 메소드를 이용하는 온도 변환 프로그램
 * 
 **
 *   o  온도 종류에는 섭씨 온도, 화씨 온도, 켈빈 온도 등이 있다.
 *      섭씨 온도(단위 C): 어는 온도: 0C, 끓는 온도: 100C (100 등분시킨 온도체계)
 *      화씨 온도(단위 F): 어는 온도: 32F, 끓는 온도: 212F (180 등분시킨 온도체계)
 *      캘빈(Kelvin) 온도(단위 K): -273C를 0K로 설정, 절대온도 0K 이하의 온도가 없는 물리학에서 사용하는 절대 온도체계
 *     
 *    o 이 프로그램은 특정 종류의 온도를 입력하고 다른 종류의 온도로 변환하여 출력하는 것을 반복한다.
 *      1) 반복은 < while(true) { ... } >로 무한 반복하도록 되어 있지만, 
 *         while 블록 내에서 작업 종료가 선택되면 < break; >를 통해 무한 반복을 벗어난다.
 *         
 *      2) 다른 종류의 온도로의 변환 작업은 총 6가지로 주어진다.
 *         (왜 6가지인지 아는가? 고등학교 수학에서 배운 3P2 = 3 * 2 = 6이기 때문이다. 여기에서 P는 순열이다)
 *         6가지의 작업에 대해 선택된 작업을 if 문으로 검사하여 변환을 수행한다.       
 *         
 *    *******************************************************************************************
 *    이전 프로그램에서 개선된 사항
 *    
 *      1) 전체 프로그램이   여러 메소드들로 구성되어 프로그램이 기능적으로 구성됨
 *    
 *   *******************************************************************************************
 *
 *
 */   

class Ex5_2_TemperatureConversionMany_SwitchMethod  {
	
	public static void main(String[] args)  {
		int menu;
	    double temperatureToConvert;
	    double temperatureConverted;

		
		while(true) {			// 종료가 선택될 때까지 반복 수행
			
			menu = displaySelectMenu();
			
			if (menu==7)  {  // 종료 선택시
				System.out.print("\n  종료합니다. Bye!!!");     // 종료 메세지 출력 후
				break;                                          // while 문을 벗어나 종료함(< return; >을 이용하여도 같은 효과임)
			}		
			
			temperatureToConvert = getIntWithPrompt("\n  * 변환 온도 입력 > ");
						
			temperatureConverted = convertTemperature(menu, temperatureToConvert);
			
            outputTemperatureConverted(menu, temperatureToConvert, temperatureConverted);
		}
	}
	
	// 작업사항을 메뉴형식으로 출력하고 메뉴를 입력하여 반환
	static int displaySelectMenu() {
		System.out.println("\n\n\n               **** 온도 변환 프로그램 *** ");
		System.out.println("  1) 섭씨 온도 ==> 화씨 온도    2) 섭씨 온도 ==> 캘빈 온도");
		System.out.println("  3) 화씨 온도 ==> 섭씨 온도    4) 화씨 온도 ==> 캘빈 온도");
		System.out.println("  5) 캘빈 온도 ==> 섭씨 온도    6) 캘빈 온도 ==> 화씨 온도");
		System.out.println("  7) 종료");

		int menu;
		
		while (true) {
			System.out.print("\n  * 작업 선택 > ");

			menu  = SkScanner.getInt();  // SkScanner.getInt()로 메뉴 선택

			if (menu >=1 &&  menu <= 7)  // 메뉴 값은 1부터 7까지임, 올바른 메뉴를 선택한 경우
				return menu;             // 메뉴를 반환

			System.out.print("\n  ?? 오류: 잘못된 선택입니다. 다시 선택하십시오.");   // 오류 메세지 출력 후 메뉴 재입력			                                                                         // 계속 반복
		}
	}
	
	// 주어진 프롬프트 메세지를 출력한 후 정수를 읽어 반환
	static int getIntWithPrompt(String promptMsg) {
		System.out.print(promptMsg);    // 프롬프트 메세지를 출력한 후 
		
		return SkScanner.getInt();  	// SkScanner.getInt()로 정수 입력하고 반환시킴
	}
	
	
	static double convertTemperature(int menu, double temperatureToConvert) {
		
		switch (menu) {
		case 1:  // 1) 섭씨 온도 ==> 화씨 온도
			return temperatureToConvert * 9 / 5 + 32;

		case 2:  // 2) 섭씨 온도 ==> 캘빈 온도
			return temperatureToConvert + 273;  // 캘빈 온도는 섭씨 온도에 273을 더해줌

		case 3:  // 3) 화씨 온도 ==> 섭씨 온도
			return (temperatureToConvert -32) * 5 / 9;  // 화씨 온도를 섭씨 온도로 바꾸는 공식

		case 4:  // 4) 화씨 온도 ==> 캘빈 온도
			return (temperatureToConvert -32) * 5 / 9   +   273;  // 화씨 온도를 섭씨 온도로 바꾼 후 273을 더해줌

		case 5:  // 5) 캘빈 온도 ==> 섭씨 온도    
			return temperatureToConvert - 273;                    // 섭씨 온도는 캘빈 온도에서 273을 빼줌

		case 6:  // 6) 캘빈 온도 ==> 화씨 온도
			return (temperatureToConvert - 273) * 9 / 5 + 32;    // 캘빈 온도를 섭씨 온도로 바꾼 후 화씨로 바꿈
		}
		
		return 0;
	}
	
	static void outputTemperatureConverted(int menu, double temperatureToConvert, double temperatureConverted) {
		String msgOutput = "";
		
		switch (menu) {
		case 1:  // 1) 섭씨 온도 ==> 화씨 온도
			msgOutput = "\n    섭씨 온도 " + temperatureToConvert +"C ==> 화씨 온도 " + temperatureConverted + "F";
			break;

		case 2:  // 2) 섭씨 온도 ==> 캘빈 온도
			msgOutput = "\n    섭씨 온도 " + temperatureToConvert +"C ==> 캘빈 온도 " + temperatureConverted + "K";	    	
			break;
			
		case 3:  // 3) 화씨 온도 ==> 섭씨 온도
			msgOutput = "\n    화씨 온도 " + temperatureToConvert +"F ==> 섭씨 온도 " + temperatureConverted + "C";	    	
			break;

		case 4:  // 4) 화씨 온도 ==> 캘빈 온도
			msgOutput = "\n    화씨 온도 " + temperatureToConvert +"F ==> 캘빈 온도 " + temperatureConverted + "K";		

		case 5:  // 5) 캘빈 온도 ==> 섭씨 온도    
			msgOutput = "\n    캘빈 온도 " + temperatureToConvert +"K ==> 섭씨 온도 " + temperatureConverted + "C";	    	
			break;

		case 6:  // 6) 캘빈 온도 ==> 화씨 온도
			msgOutput = "\n    캘빈 온도 " + temperatureToConvert +"K ==> 화씨 온도 " + temperatureConverted + "F";		
			break;
		}	
		
		System.out.print(msgOutput);
	}
}

/*
 * 실습과제:
 *       
 * 스스로 생각하고 고민해볼 과제:  
 *      
 *       C 프로그래밍에서도 이 문제는 당연히 제기되었을 것이며 해결책이 제시되었으며, 
 *       그 해결책은 바로 추상화(abstraction)이다. 
 *       추상화가 무엇이고, 프로그래밍에서 어떻게 활용되는가를 이해하는 것이 프로그래밍을 잘하기 위에 가장 중요한
 *       요소 중 하나이다. 이는 C에서는 함수이며, java에서는 메소드, 클래스, 객체 등이 여기에 해당된다.   
 *       
 *       
 */
