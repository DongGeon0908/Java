/**
 *  [ TemperatureConversion_FandC__UsingSubstitutingMethod ]: 
 *         화씨온도와 섭씨온도간의 온도 변환(대체 메소드 사용)
 *   
 *    o 프로그래밍 스타일 
 *      - 대체 메소드 작성하고 작성한 대체 메소드 호출
 *       
 *    o 작성한 대체 메소드
 *      - static void convertDegree_FandC(): 변환 종류를 입력하여 해당 변환에 따른 작업을 수행하도록 제어하는 메소드
 *      - static void inputConvertOutputDegree_FtoC(): 화씨온도 입력하여 섭씨로 변환하여 출력하는 메소드
 *      - static void inputConvertOutputDegree_CtoF(): 섭씨온도 입력하여 화씨로 변환하여 출력하는 메소드
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

class Ex5_2_9_TemperatureConversion_FandC_UsingSubstitutingMethod  {
	public static void main(String[] args)  {		
		convertDegree_FandC();  // 온도 변환 메소드 호출
		
		main(args); // 이 문장은 반복시키기 위한 문장임
	}
	
	static void convertDegree_FandC() {
		int menu;

		System.out.println("\n\n  ** Conversion of Temperature **");

		System.out.println("    1) Fahrenheit temperature to Centigrade");
		System.out.println("    2) Centigrade temperature to Fahrenheit degree\n");	
		
		menu = SkScanner.getIntWithPrompt("  * Choose which > ");

		if (menu == 1) 
			inputConvertOutputTemperature_FtoC();
		else
			inputConvertOutputTemperature_CtoF();
	}	
	
	static void inputConvertOutputTemperature_FtoC() {
		// 예제 4-2-2 참조하여 이 메소드를 작성하라.
	}
	
	static void inputConvertOutputTemperature_CtoF() {
		// 예제 4-2-2 참조하여 이 메소드를 작성하라. 
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *  
 *   1) 이 프로그램은 예제 4-2-2의 프로그램을 대체 메소드로 변환한 프로그램이다.
 *      다음의 예제 4-2-2의 프로그램과 이 프로그램을 비교해보면서 대체 메소드의 원리인 
 *      대체 추상화에 대해 이해해보라.       
 *     
       ================= [예제 4-2-2] 메소드 사용하지 않은 온도 변환 프로그램 ===============   
        
       class Ex4_2_2_TemperatureConversion_FandC_UsingIf  {
	      public static void main(String[] args)  {
		    int menu;
		    System.out.println("\n\n  ** Conversion of Temperature **");

		    System.out.println("    1) Fahrenheit temperature to Centigrade");
		    System.out.println("    2) Centigrade temperature to Fahrenheit\n");	
		
		    menu = SkScanner.getIntWithPrompt("  * Choose which > ");

		    if (menu == 1) {
			   double F, C;   // 화씨온도와 섭씨온도 저장할 변수

		       F = SkScanner.getDoubleWithPrompt("\n  * Input Fahrenheit degree > ");

			   C = (F - 32) * 5 / 9;
      
			   double C1 = (int) ((C + 0.05) * 10) / 10.0; // 소수점 이하 2자리에서 반올림
			   System.out.println("\n  o " + F + "F = " + C + "C = " + C1 + "C"); 
		    }
		    else {		
		       double F, C;   // 화씨온도와 섭씨온도 저장할 변수

			   C = SkScanner.getDoubleWithPrompt("\n  * Input Centigrade degree > ");					
			   F = C * 9 / 5 + 32;
			   System.out.println("\n  o " + C + "C = " + F + "F"); 
		    }

		    main(args); 
	      }	
        }     
      
        =========================================================================================
      
 *    2) 화씨온도 32, 55.2, 180.5, 212에 대해 섭씨온도를 구하고
 *       섭씨온도 0, 22, 30, 100에 대해 화씨온도를 구하라.      
 *      
 *
 * [ 실습과제 ] 
 *  
 *   1) 이 프로그램에서 inputConvertOutputTemperature_FtoC()와 
 *      inputConvertOutputTemperature_CtoF() 메소드가 미완성이다. 이를 완성하라.
 *      
 *      프로그램이 완성되면 화씨온도 32, 55.2, 180.5, 212에 대해 섭씨온도를 구하고
 *      섭씨온도 0, 22, 30, 100에 대해 화씨온도를 구하라.      
 *      
 *   2) main() 메소드는 자신을 호출하여 온도 변환 작업을 반복한다. 이를 while 문을 이용하여
 *      반복하도록 작성하라. (참고: 무한 반복하도록 작성할 것임)
 *     
 *     
 * [ 참고사항 ]
 * 
 *   1) 대부분의 프로그램은 한번 실행된 후 종료된다. 주어진 프로그램을 계속 반복하는 가장 쉬운 방법이 
 *      main() 메소드의 끝에 문장 << main(args); >> 을 추가하는 것이다.
 *      
 *      이 경우 프로그램은 무한 반복하여 실행된다. 
 */
