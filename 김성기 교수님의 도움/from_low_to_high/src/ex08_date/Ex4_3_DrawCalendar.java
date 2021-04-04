package ex08_date;

/*
 * [ DrawCalendar.c ]: 년과 월을 입력하여 달력 출력
 *   
 *   o 프로그래밍 스타일
 *     1) main() 메소드로만 구성
 *     2) 단순변수와 배열변수 선언, 년과 월을 입력하여 변수에 저장
 *     3) 입력된 년과 월의 1일 요일, 마지막 날짜 등을 구해 달력 출력 
 *  
 */ 

class Ex4_3_DrawCalendar {
	public static void main(String[] args)  {
		final boolean DEBUG = true;  // 이 값을 true로 하면  <for debug>가 출력되며, false으로 하면 <for debug>가 출력되지 않음 

		System.out.println("\n\n\n  **** 년월을 입력하여 달력 출력하기 ****\n");

		/*
		 *	년도, 월 입력하여 변수에 저장 
		 */ 
		int year, month; // 입력한 년도, 월을 저장할 변수 

		year = SkScanner.getIntWithPrompt("  o 년 > "); // 년 입력 
		month = SkScanner.getIntWithPrompt("  o 월 > "); // 월 입력

		/*
		 *	서기 1년 1월 1일부터 입력된 년월의 1일까지의 날수를 구함
		 *   1년 365일과 윤년 회수를 이용하여 전년도까지의 날수를 구하고
		 *   입력 년도가 윤년이고 월이 3월 이후이면 윤달 2월 29일이 지났으므로 1을 더해줌 
		 */ 		
		int lastYear = year - 1;
		int lastMonth = month - 1;

		// 각 달별로 마지막 날짜를 저장하는 배열 
		// 만약 입력한 년이 윤년이면 2월은 28이 아니라 29일임 
		int daysOfMonth[] = { 
				0,  31,  28,  31,  30,  31, 30, 
				31,  31,  30,  31,  30, 31                
		};

		// 각 달별로 이전 달까지의 날수를 계산하여 저장하는 배열 
		int daysUntilMonth[] = { 
				0,  31,  31+28,  31+28+31, // 
				31+28+31+30, 31+28+31+30+31, 31+28+31+30+31+30, 31+28+31+30+31+30+31,       
				31+28+31+30+31+30+31+31, 31+28+31+30+31+30+31+31+30, 31+28+31+30+31+30+31+31+30+31, 31+28+31+30+31+30+31+31+30+31+30                
		};

		int daysFrom00010101; // 1년 1월 1일부터 입력된 년월의 1일까지 날수를 구하여 저장하는 변수 


		daysFrom00010101 = lastYear * 365 + daysUntilMonth[lastMonth] ;
		if (DEBUG)
			System.out.printf("\n\n  <for debug>  서기 1년 1월 1일부터의 기본 날수 daysFrom00010101 = %d일\n", daysFrom00010101);	

		// lastYear까지 윤년 회수만큼 날수를 더해줌	
		// << lastYear / 4 - lastYear / 100 + lastYear / 400 >>은 서기 1년부터 lastYear까지의 윤년 회수를 구하는 수식임 
		int cntLeapYear =  lastYear / 4 - lastYear / 100 + lastYear / 400;
		if (DEBUG)
			System.out.printf("  <for debug>  윤년 회수 cntLeapYear = %d일\n", cntLeapYear);	

		daysFrom00010101 += cntLeapYear;  // 구한 윤년 회수를 더함 
		if (DEBUG)
			System.out.printf("  <for debug>  윤년회수 더한 후 daysFrom00010101 = %d일\n", daysFrom00010101);	

		// 연도가 윤년인가를 확인: 윤년은 4의 배수이면수 100의 배수가 아니 경우 또는 400의 배수인 경우 
		boolean isLeapYear = (year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0);
		if (DEBUG)
			System.out.println("  <for debug>  입력한 년도의 윤년 여부 isLeapYear = " + isLeapYear);	

		// 입력한 달이 3월 이상이고 년도가 윤년이면 윤달인 2월 29일을 지났으므로 1을 더해줌 
		daysFrom00010101 = (month >= 3  && isLeapYear == true) ? daysFrom00010101 + 1 : daysFrom00010101;
		if (DEBUG)
			System.out.printf("  <for debug>  입력 연도의 윤년 보정 후 daysFrom00010101 = %d일\n", daysFrom00010101);	

		/*
		 *	입력된 년월의 말일을 구함 
		 *   - 2월을 제외하고 말일은 항상 동일함 
		 *   - 평년의 2월 말일은 28일이지만 윤년의 2월 말일은 29일임 
		 */ 	
		int lastday;  // 입력된 년월의 말일을 구하여 저장하는 변수 
		lastday = daysOfMonth[month];  // 평년의 말일을 구함 
		if (isLeapYear && month == 2)  // 입력한 연도가 윤년이고 월이 2월이면 
			lastday = 29;               //    윤년이므로 말일은 29일임 

		/*
		 *	구한 날수를 7로 나눈 나머지를 이용하여 입력한 년월의 1일의 요일을 구함 
		 *   - 서기 1년 1월 1일은 월요일
		 *   - 1월 1일 이후 날수의 7로 나눈 나머지가 그 달의 시작 요일을 구하는 중요한 단서임 
		 *   - 1월 1일 이후 날수에 1을 더한 값의 7의 나머지가 시작 요일을 나타냄
		 *   - 나머지가 0이면 시작요일이 일, 1이면 월, 2이면 화, 3이면 수, 4이면 목, 5이면 금, 6이면 토요일임 
		 */
		int weekdayStart; // 입력한 년월의 시작 요일을 저장하는 변수; 
		weekdayStart = (daysFrom00010101 + 1 ) % 7;  // 1을 더한 값의 7로 나눈 나머지가 0이면 일요일 

		String weekdayNames[] = {"일", "월", "화", "수", "목", "금", "토"};

		if (DEBUG)
			System.out.printf("  <for debug>  %d년 %d월의 시작요일: %s: \n", year, month, weekdayNames[weekdayStart]);	

		System.out.println("\n\n");
		System.out.println("        " + year + "년 " + month + "월");
		System.out.println("  ======================");
		System.out.println("       일   월   화   수   목   금   토");
		System.out.println("  ======================");
		System.out.print("   ");
 
		int wd;  // 요일을 나타내는 변수로, 0이면 일, 1이면 월, ...  

		for(wd = 0; wd < weekdayStart ; wd++)	// 일요일부터 그 달의 시작 요일 전까지  
			System.out.print("   ");		        	    // 공백 출력

		int day;
		for(day = 1; day <= lastday ; day++) { // 1일부터 말일까지 일을 해당 요일에 출력 

			if( wd > 1 && wd % 7 == 0 ) {	
				System.out.print("\n   "); // 일요일이면 줄바꿈을 출력
			}

			wd++;
			System.out.printf("%2d ", day);		// 일을 출력
		}
		System.out.println("\n  ======================\n");

		main(args);
	}
}