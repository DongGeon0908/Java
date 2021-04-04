package ex06_temperature;

/*
 * 
 * [ DegreeConversionMany_MethodMultiLang ]: 온도 변환 프로그램  다국어 버전
 * 
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
 *      1) 데이터 부분과 데이터를 처리하는 부분이 분리되어 있음
 *      2) 한국어 외에 영어, 일본어 지원이 가능하도록 작성됨
 *    
 *   *******************************************************************************************
 *
 * 
 */   

class Ex5_3_DegreeConversionMany_MethodMultiLang  {
	static final int langKOR = 0;
	static final int langENG = 1;
	static final int langJAP = 2;
	
	static int lang = langKOR;  // 이 변수의 값을 langKOR, langENG, langJAP 화면의 언어가 변경됨
	
	static String title[]  = { "\n\n\n               **** 온도 변환 프로그램 **** \n",
		                       "\n\n\n               **** Temperature Conversion Program **** \n", 
		    	               "\n\n\n               **** おんど  コンバージョン プログラム **** \n"
                             };

	static String degreeNameC[] = { "섭씨 온도", "Centigrade Degree", "せっしおんど     " };
	static String degreeNameF[] = { "화씨 온도", "Fahrenheit Degree", "カしおんど         " };	
	static String degreeNameK[] = { "캘빈 온도", "Kelvin Degree    ", "カルビンおんど  " };	

	static String menuExit[]  = { "종료                   ", "Exit                   ", "終了                   " };

	static String degreeFrom[][] = { { degreeNameC[0], degreeNameC[0], degreeNameF[0], degreeNameF[0], degreeNameK[0], degreeNameK[0] },
									{ degreeNameC[1], degreeNameC[1], degreeNameF[1], degreeNameF[1], degreeNameK[1], degreeNameK[1] },
									{ degreeNameC[2], degreeNameC[2], degreeNameF[2], degreeNameF[2], degreeNameK[2], degreeNameK[2] }
								  };
	
	static String degreeTo[][] = { { degreeNameF[0], degreeNameK[0], degreeNameC[0], degreeNameK[0], degreeNameC[0], degreeNameF[0] },
									{ degreeNameF[1], degreeNameK[1], degreeNameC[1], degreeNameK[1], degreeNameC[1], degreeNameF[1] },
									{ degreeNameF[2], degreeNameK[2], degreeNameC[2], degreeNameK[2], degreeNameC[2], degreeNameF[2] }
								  };

	static int noMenus = degreeFrom[0].length;

	static String menuPrompt[] = { "\n  o 작업 선택 > ", "\n  o choose what > ", "\n  o 作業 選ぶこと > " };
	static String inputDegreePrompt[] = { "\n  o 변환 온도 입력 > ", "\n  o input degree to convert > ", "\n  o コンバージョン おんど1" +
			" インプット > " };
 

	static String menuErrorMsg[] =  { "\n  ?? 오류: 잘못된 선택입니다. 다시 선택하십시오.", 
									  "\n  ?? Error: wrong chiose. choose agian.", 
									  "\n  ?? エラー: 誤った 選択せんたくですね. また 選択せよ." 
									};

	static String exitMsg[] =  { "\n  종료합니다. Bye!!!",  "\n  Exiting. Bye!!!", "\n  終了する. Bye!!!" };
	
	public static void main(String[] args)  {
		int menu;
	    double degreeToConvert;
	    double degreeConverted;

		
		while(true) {			// 종료가 선택될 때까지 반복 수행
			
			menu = displaySelectMenu();
			
			if (menu==7)  {  // 종료 선택시
				System.out.print(exitMsg[lang]);     // 종료 메세지 출력 후
				break;                                          // while 문을 벗어나 종료함(< return; >을 이용하여도 같은 효과임)
			}		
			
			degreeToConvert = inputDegreeToConvert(menu);
						
			degreeConverted = convertDegree(menu, degreeToConvert);
			
            outputDegreeConverted(menu, degreeToConvert, degreeConverted);
            
            lang++;
            if (lang > 2)
            	lang = 0;
		}
	}
	

	
	// 작업사항을 메뉴형식으로 출력하고 메뉴를 입력하여 반환
	static int displaySelectMenu() {
		System.out.println(title[lang]);
		
		for (int i=0; i < noMenus; i++) {
			System.out.print("    " + (i + 1) + ") " + degreeFrom[lang][i] + " ==> " + degreeTo[lang][i]);
			
			if (i % 2 == 1)
				System.out.println();
		}
		
		System.out.println("    " + (noMenus + 1) + ") " + menuExit[lang]);

		int menu;
		
		while (true) {
			System.out.print(menuPrompt[lang]);

			menu  = SkScanner.getInt();  // SkScanner.getInt()로 메뉴 선택

			if (menu >=1 &&  menu <= (noMenus + 1))  // 메뉴 값은 1부터 7까지임, 올바른 메뉴를 선택한 경우
				return menu - 1;             // 메뉴를 배열 인덱스로 사용하기 위해 1을 감소하여 반환

			System.out.println(menuErrorMsg[lang]);   // 오류 메세지 출력 후 메뉴 재입력			                                                                         // 계속 반복
		}
	}
	
	static int inputDegreeToConvert(int menu) {
		String msgOutput = "\n\n  ** " + degreeFrom[lang][menu] + " ==> " + degreeTo[lang][menu] + " **\n";				
		System.out.print(msgOutput);
		
		return getIntWithPrompt(inputDegreePrompt[lang]);

	}
	
	// 주어진 프롬프트 메세지를 출력한 후 정수를 읽어 반환
	static int getIntWithPrompt(String promptMsg) {
		System.out.print(promptMsg);    // 프롬프트 메세지를 출력한 후 
		
		return SkScanner.getInt();  	// SkScanner.getInt()로 정수 입력하고 반환시킴
	}
	
	
	static double convertDegree(int menu, double degreeToConvert) {
		
		// 여기에서는 menu 변수의 값을 직접 0인지, 1인지를 비교하지 않는다. 그대신
		// 변환전 온도종류와 변환 후 온도종류를 비교하여 해당되는 변환을 실시함
		if ( degreeFrom[lang][menu].equals(degreeNameC[lang]) && degreeTo[lang][menu].equals(degreeNameF[lang]) )
			return degreeToConvert * 9 / 5 + 32;  // 섭씨 온도 ==> 화씨 온도
		else if ( degreeFrom[lang][menu].equals(degreeNameC[lang]) && degreeTo[lang][menu].equals(degreeNameK[lang]) )
			return degreeToConvert + 273;  // 섭씨 온도 ==> 캘빈 온도: 캘빈 온도는 섭씨 온도에 273을 더해줌
		else if ( degreeFrom[lang][menu].equals(degreeNameF[lang]) && degreeTo[lang][menu].equals(degreeNameC[lang]) )
			return (degreeToConvert -32) * 5 / 9;  // 화씨 온도 ==> 섭씨 온도: 화씨 온도를 섭씨 온도로 바꾸는 공식
		else if ( degreeFrom[lang][menu].equals(degreeNameF[lang]) && degreeTo[lang][menu].equals(degreeNameK[lang]) )
			return (degreeToConvert -32) * 5 / 9   +   273;  // 화씨 온도 ==> 캘빈 온도: 화씨 온도를 섭씨 온도로 바꾼 후 273을 더해줌
		else if ( degreeFrom[lang][menu].equals(degreeNameK[lang]) && degreeTo[lang][menu].equals(degreeNameC[lang]) )
			return degreeToConvert - 273;                    // 캘빈 온도 ==> 섭씨 온도: 섭씨 온도는 캘빈 온도에서 273을 빼줌
		else if ( degreeFrom[lang][menu].equals(degreeNameK[lang]) && degreeTo[lang][menu].equals(degreeNameF[lang]) )				
			return (degreeToConvert - 273) * 9 / 5 + 32;    // 캘빈 온도 ==> 화씨 온도: 캘빈 온도를 섭씨 온도로 바꾼 후 화씨로 바꿈
				
		return 0;
	}
	
	static void outputDegreeConverted(int menu, double degreeToConvert, double degreeConverted) {
		String msgOutput;
		
		msgOutput = "\n    * " + degreeFrom[lang][menu] + " " + degreeToConvert +" ==> " + degreeTo[lang][menu] + " " + degreeConverted;		
		
		System.out.print(msgOutput);
	}
}

/*
 * 
 *       
 * [ 스스로 생각하고 고민해볼 과제  ] 
 *      
 *   o 이 프로그램은 3개국 언어를 지원한다. 중국어를 지원할 수 있도록 프로그램을 수정하기 위해 
 *     무엇을 해야 할 것인지를  살펴보고, 할수 있으면 수정해보라.
 *     
 *     % 참고: 이를 위해서는 langCHA 변수를 선언하고 중국어를 위한 여러 문자열 데이터를 해당 배열변수에
 *             저장하면 된다.
 *      
 *       
 */
