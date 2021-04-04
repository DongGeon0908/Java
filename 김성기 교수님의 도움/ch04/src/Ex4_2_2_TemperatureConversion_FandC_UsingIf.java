/**
 * [ TemperatureConversion_FandC_UsingIf ]: 화씨온도와 섭씨온도간의 온도 변환
 * 
 *   o 프로그래밍 스타일 
 *     1) main() 메소드로만 클래스 구성
 *     2) 변환 종류 입력하고 if 문을 사용하여 종류별 온도 변환
 *        - 화씨온도와 섭씨온도간의 변환 공식 이용
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
 *     
 *    o if 문
 *      - 형식: 
 *         if (조건)
 *            조건_true일_때_수행할_문장
 *          else
 *            조건_false일_때_수행할_문장
 *            
 *      - else 부분은 생략 가능     
 */

class Ex4_2_2_TemperatureConversion_FandC_UsingIf  {
	public static void main(String[] args)  {
		int menu;

		System.out.println("\n\n  ** Conversion of Temperature **");

		System.out.println("    1) Fahrenheit temperature to Centigrade temperature");
		System.out.println("    2) Centigrade temperature to Fahrenheit temperature\n");	
		
		menu = SkScanner.getIntWithPrompt("  o Choose which > ");

		if (menu == 1) {
			double F, C;   // 화씨온도와 섭씨온도 저장할 변수: 블록 내에서 변수 선언함 

			F = SkScanner.getDoubleWithPrompt("\n  o Input Fahrenheit degree > ");

			C = (F - 32) * 5 / 9;
      
			double C1 = (int) ((C + ((C>0) ? 0.05 : -0.05)) * 10) / 10.0; // 소수점 이하 2자리에서 반올림
			System.out.println("\n  * " + F + "F = " + C + "C = " + C1 + "C"); 
		}
		else if (menu == 2) {		
			double C, F;   // 화씨온도와 섭씨온도 저장할 변수: 블록 내에서 변수 선언함 

			C = SkScanner.getDoubleWithPrompt("\n  o Input Centigrade degree > ");					
			F = C * 9 / 5 + 32;
			System.out.println("\n  * " + C + "C = " + F + "F"); 
		}

		main(args); 
	}	
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *  
 *   1) 주어진 프로그램 살펴보고 프로그램의 내용 파악하라.     
 *       
 *   2) 화씨온도 32, 55.2, 180.5, 212에 대해 섭씨온도 구하고
 *      섭씨온도 0, 22, 30, 100에 대해 화씨온도 구하라.      
 *      
 *   3) 이 프로그램에서는 변수 F와 C가 if 문의 각 블록 내에서 선언되어 있다.
 *      Java의 블록에서는 그 블록에서만 사용할 변수를 선언할 수 있음을 보여 준다. 
 *      
 * 
 * [ 실습과제 ]
 * 
 *   1) 섭씨온도 입력하여 캘빈온도로 변환하여 출력하는 작업을 메뉴 3)으로,
 *      캘빈온도를 입력하여 섭씨온도로 변환하여 출력하는 작업을 메뉴 4)로 추가하는 프로그램을 
 *      Pr4_2_2_TemperatureConversion_FandCandK_UsingIf 클래스로 작성하라.
 *      
 *   2) 온도 체계는 화씨온도, 섭씨온도, 캘빈온도 등 3가이다. 
 *   
 *      이들 사이의 온도 변환을 모두 할 수 있는 온도 변환 프로그램을 
 *      Pr4_2_2_TemperatureConversionAny 클래스로 작성하라.
 *      (3가지 온도체계간의  변환 가능한 개수는 3개 중 2개를 선택하는 순열(permutation)이므로 3P2 = 3*2 = 6 가지)
 *      
 *      이 프로그램에서는 6가지 작업을 위한 메뉴 출력하고 메뉴 선택한 후 변환할 온도 입력하고 이를 변환하여  출력한다.
 *     
 *     
 * [ 참고사항 ]
 * 
 *   1) 실수를 SkScanner.getDoubleWithPrompt() 메소드로 입력할 때는
 *      정수, 소수형 실수, 지수형 실수 모두 입력이 가능하다. 
 *      
 *      그러므로 77, 77.7, 77.7e10 등도 화씨온도로 입력할 수 있다. 
 *      
 *   2) 프로그램은 한번 실행된 후 종료된다. 
 *   
 *      주어진 프로그램을 계속 반복하는 가장 쉬운 방법이  main() 메소드의 끝에 
 *      문장 << main(args); >>을 추가하는 것이다. 
 *      
 *      이 경우 프로그램은 계속 반복하여 실행된다. 
 *      
 *   3) 이 프로그램은 화씨에서 섭씨로, 섭씨에서 화씨로 온도변환 등의 2가지 작업 수행하며, 
 *      여러 작업을 수행하는 첫 프로그램이다.
 *      
 *      여러 작업 수행하는 프로그램은 작업선택 부분, 제어부분, 특정 작업 수행부분 등 3가지 부분으로 구성된다.
 *      
 *      (1) 작업선택 부분: 작업 선택을 위한 메뉴를 출력하고 메뉴 중 하나 선택하게 함
 *      (2) 제어 부분: 메뉴 선택에 따른 작업 수행하기 위해 if 문이나 switch 문으로 제어 부분 작성함
 *      (3) 특정 작업 수행 부분: 작업별로 수행할 문장들 작성함      
 */
