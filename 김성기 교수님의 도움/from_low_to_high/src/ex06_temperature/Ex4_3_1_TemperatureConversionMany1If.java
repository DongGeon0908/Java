package ex06_temperature;

/*
 *   온도 종류에는 섭씨온도, 화씨온도, 켈빈온도 등이 있다.
 *     섭씨온도(단위 C): 어는 온도: 0C, 끓는 온도: 100C (100 등분시킨 온도체계)
 *     화씨온도(단위 F): 어는 온도: 32F, 끓는 온도: 212F (180 등분시킨 온도체계)
 *     캘빈(Kelvin) 온도(단위 K): -273C를 0K로 설정, 절대온도 0K 이하의 온도가 없는 물리학에서 사용하는 절대 온도체계
 *     
 *   이 프로그램은 특정 종류의 온도를 입력하고 다른 종류의 온도로 변환하여 출력하는 것을 반복한다.
 *      1) 반복은 < while(true) { ... } >로 무한 반복하도록 되어 있지만, 
 *         while 블록 내에서 작업 종료가 선택되면 < break; >를 통해 무한 반복을 벗어난다.
 *         
 *      2) 다른 종류의 온도로의 변환 작업은 총 6가지가이다.
 *         (왜 6가지인지 아는가? 고등학교 수학에서 배운 3P2 = 3 * 2 = 6이기 때문이다. 여기에서 P는 순열이다)
 *         6가지의 작업에 대해 선택된 작업을 if 문으로 검사하여 변환을 수행한다.    
 *         
 *      3) 메뉴는 모두 7가지(6가지 변환작업 메뉴와 종료작업 메뉴)로 구성되며 
 *         잘못된 메뉴가 입력되면 다시 메뉴를 입력한다.  
 *         
 *    이 프로그램의 문제점
 *    ************************************************************************************************************
 *    1) 작업을 반복하기 위한 while 문을 통한 반복과 올바른 메뉴 선택을 위한 while 문이 중접되어 프로그램이 복잡하다.
 *    
 *    2) 이 프로그램에서는 여러 if 문의 true 부분에서 변환 전 온도와 변환 후 온도 모두를 출력하는 문장이 
 *       포함되어 있고 출력을 위한 스트링 구성작업이 다소 복잡하여 프로그램이 지저분해 보이는 경향이 있다.
 *       
 *    3) 이 프로그램의 경우 점점 수행하는 작업이 많아져 main() 메소드의 라인수(전체 약 60여 라인)가 많아지고 
 *       한번에 프로그램의 기능을 이해하기 어려워진다. 
 *       
 *    ===> 
 *    
 *       C 프로그래밍에서도 이 문제는 당연히 제기되었을 것이며 해결책이 제시되었으며, 
 *       그 해결책은 바로 추상화(abstraction)이다. 
 *       추상화가 무엇이고, 프로그래밍에서 어떻게 활용되는가를 이해하는 것이 프로그래밍을 잘하기 위에 가장 중요한
 *       요소 중 하나이다. 이는 C에서는 함수이며, Java에서는 메소드, 클래스, 객체 등이 여기에 해당된다.   
 *   *************************************************************************************************************
 */

class Ex4_3_1_TemperatureConversionMany1If  {
	public static void main(String[] args)  {
		int menu;              // 선택된 메뉴를 저장하는 변수
		double temperatureToConvert;   // 변환전 온도를 저장할 변수
		double temperatureConverted;   // 변환된 온도를 저장할 변수
				
		while(true) {			// 종료가 선택될 때까지 반복 수행
			System.out.println("\n\n\n               **** 온도 변환 프로그램 *** ");
			System.out.println("  1) 섭씨온도 ==> 화씨온도    2) 섭씨온도 ==> 캘빈온도");
			System.out.println("  3) 화씨온도 ==> 섭씨온도    4) 화씨온도 ==> 캘빈온도");
			System.out.println("  5) 캘빈온도 ==> 섭씨온도    6) 캘빈온도 ==> 화씨온도");
			System.out.println("  7) 종료");

			// 1부터 7까지의 메뉴가 선택될 때까지 반복
			while(true) {
				System.out.print("\n  * 작업 선택 > ");

				menu  = SkScanner.getInt();   // SkScanner.getInt()로 메뉴 선택

				if (menu < 1  || menu > 7)  { // 메뉴 값은 1부터 7까지임, 잘못된 메뉴를 선택한 경우
					System.out.print("\n  ?? 오류: 잘못된 선택입니다. 다시 선택하십시오.");     // 오류 메세지 출력 후
					continue;                 // < continue; >를 통해 나머지 반복 부분을 무시하고 반복을 새로이 시작하게 함
				}
				break;
			}
			
			if (menu==7)  {  // 종료 선택시
				System.out.print("\n  종료합니다. Bye!!!");     // 종료 메세지 출력 후
				break;                                          // while 문을 벗어나 종료함(< return; >을 이용하여도 같은 효과임)
			}		
			
			System.out.print("\n  * 변환  온도 입력 > ");
			temperatureToConvert  = SkScanner.getDouble();  	// SkScanner.getDouble()로 변환할 온도 입력
			
		    if (menu==1) {       // 1) 섭씨온도 ==> 화씨온도 
		    	temperatureConverted = temperatureToConvert * 9 / 5 + 32;              // 섭씨온도를 화씨온도로 바꾸는 공식
				System.out.println("\n    섭씨온도 " + temperatureToConvert +"C ==> 화씨온도 " + temperatureConverted + "F");
		    }
     	    else if (menu==2) {  // 2) 섭씨온도 ==> 캘빈온도
		    	temperatureConverted = temperatureToConvert + 273;                    // 캘빈온도는 섭씨온도에 273을 더해줌
				System.out.println("\n    섭씨온도 " + temperatureToConvert +"C ==> 캘빈온도 " + temperatureConverted + "K");	    	
		    }
    	    else if (menu==3) {  // 3) 화씨온도 ==> 섭씨온도
		    	temperatureConverted = (temperatureToConvert -32) * 5 / 9;            // 화씨온도를 섭씨온도로 바꾸는 공식
				System.out.println("\n    화씨온도 " + temperatureToConvert +"F ==> 섭씨온도 " + temperatureConverted + "C");	    	
		    }
    	    else if (menu==4) {  // 4) 화씨온도 ==> 캘빈온도
		    	temperatureConverted = (temperatureToConvert -32) * 5 / 9   +   273;  // 화씨온도를 섭씨온도로 바꾼 후 273을 더해줌
				System.out.println("\n    화씨온도 " + temperatureToConvert +"F ==> 캘빈온도 " + temperatureConverted + "K");		
		    }
    	    else if (menu==5) {  // 5) 캘빈온도 ==> 섭씨온도    
    	    	temperatureConverted = temperatureToConvert - 273;                    // 섭씨온도는 캘빈온도에 273을 빼줌
    	    	System.out.println("\n    캘빈온도 " + temperatureToConvert +"K ==> 섭씨온도 " + temperatureConverted + "C");	    	
    	    }
    	    else if (menu==6) {  // 6) 캘빈온도 ==> 화씨온도
    	    	temperatureConverted = (temperatureToConvert - 273)  * 9 / 5 + 32;    // 캘빈온도를 섭씨온도로 바꾼 후 화씨로 바꿈
    	    	System.out.println("\n    캘빈온도 " + temperatureToConvert +"K ==> 화씨온도 " + temperatureConverted + "F");		
    	    }
		}
	}
}

