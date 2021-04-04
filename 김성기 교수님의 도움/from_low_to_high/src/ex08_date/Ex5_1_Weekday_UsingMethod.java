package ex08_date;

/*
 * [ Weekday_UsingMethod ]: 메소드 사용하여 년월일을 입력하여 그 날짜의 요일을 출력하기
 *   
 *   o 프로그래밍 스타일
 *     1) 요일을 구하기 위한 여러  메소드들을 작성
 *     2) 단순변수와 배열변수 선언, 연도, 월, 일을 입력하여 변수에 저장
 *     3) 입력된 날짜의 요일을 구해 출력 
 *  
 */   

class Ex5_1_Weekday_UsingMethod {

	int year, month, day;
	String weekday;
	
	// 각 달별로 그 달까지의 날수를 계산하여 저장하는 배열 
	static int daysUntilMonth[] = { 
		0,  31,  31+28,  31+28+31, // 
		31+28+31+30, 31+28+31+30+31, 31+28+31+30+31+30, 31+28+31+30+31+30+31,       
		31+28+31+30+31+30+31+31, 31+28+31+30+31+30+31+31+30, 31+28+31+30+31+30+31+31+30+31, 31+28+31+30+31+30+31+31+30+31+30                
	};

	static String weekdayNames[] = {"월", "화", "수", "목", "금", "토", "일"};

	public static void main(String[] args)  {
		System.out.println("\n\n  **** 날짜 입력하여 그 날짜의 요일 출력하기 ****\n");

		/*
		 *	날짜를 년도, 월, 일로 입력하여 변수에 저장 
		 */ 
		int year, month, day; // 입력받은 날짜에서 년도, 월, 일을 구하여 저장할 변수 

		System.out.print("  o 요일 구할 날짜의 연도 > ");  // 연도를 입력하기 위한 프롬프트 메시지 출력
		year = SkScanner.getInt();		

		System.out.print("  o           날짜의 월   > ");  // 월을 입력하기 위한 프롬프트 메시지 출력
		month = SkScanner.getInt();

		System.out.print("  o           날짜의 일   > ");  // 일을 입력하기 위한 프롬프트 메시지 출력
		day = SkScanner.getInt();

		int weekdayIndex = getWeekday(year, month, day);

		/*
		 *	서기 1년 1월 1일부터의  날수를 7로 나눈 나머지를 이용하여 요일을 구하여 출력 
		 *   - 서기 1년 1월 1일은 월요일
		 *   - 1월 1일 이후 날수의 7로 나눈 나머지가 요일을 구하는  중요한 단서임 
		 */  
		System.out.println("\n  ** 입력한 날짜의 요일 **\n");
		System.out.println("  * 날짜: " + year + "년 " + month + "월 " + day + "일");
		System.out.println("  * 요일: " + weekdayNames[weekdayIndex]);  // 날짜를 요일을 나타내는 weekdayNames[weekdayIndex] 출력


		System.out.println("\n\n  ^^ Well done! Have a good time!!! ^^"); // 이 문장은 프로그램의 종료를 나타내는 문장임

		main(args);

	}

	static int getWeekday(int year, int month, int day) {
		// 서기 1년 1월 1일부터 입력된 날짜까지의 날수를 구함
		int daysFrom00010101 = getDaysFrom00010101(year, month, day); // 1년 1월 1일부터 입력된 날짜까지의 날수를 구하여 저장하는 변수 


		// 1년 1월 1일부터 입력된 날짜까지의 날수를 7로 나눈 나머지를 구함 
		//   이값이 0이면 월, 1이면 화, 2이면 수, 3이면 목, 4이면 금, 5이면 토, 6이면 일요일임 
		int weekdayIndex = daysFrom00010101 % 7;
		System.out.println("  <for debug>  날 수를 7로 나눈 나머지 weekdayIndex = " + weekdayIndex);	

		return weekdayIndex;
	}

	/*
	 *	서기 1년 1월 1일부터 주어진 날짜까지의 날수를 구하는 메소드
	 *   1년 365일과 윤년 회수를 이용하여 전년도까지의 날수를 구하고
	 *   입력 년도가 윤년이고 월이 3월 이후이면 윤달 2월 29일이 지났으므로 1을 더해줌 
	 */
	static int getDaysFrom00010101(int year, int month, int day) {

		int lastYear = year - 1;
		int lastMonth = month - 1;

		int daysFrom00010101 = lastYear * 365 + daysUntilMonth[lastMonth] + day - 1;
		System.out.println("\n  <for debug>  서기 1년 1월 1일부터의 기본 날수 daysFrom00010101 = " + daysFrom00010101);	

		// lastYear까지 윤년 회수만큼 날수를 더해줌	
		int cntLeapYear =  getCountOfLeapYear(lastYear);

		System.out.println("  <for debug>  윤년 회수 cntLeapYear = " + cntLeapYear);	

		daysFrom00010101 = daysFrom00010101 + cntLeapYear;  // 구한 윤년 회수를 더함 
		System.out.println("  <for debug>  윤년회수 더한 후 daysFrom00010101 = " + daysFrom00010101);	

		// 날짜의 연도가 윤년인가를 확인: 윤년은 4의 배수이면수 100의 배수가 아니 경우 또는 400의 배수인 경우 
		boolean isLeap = isLeapYear(year);
		System.out.println("  <for debug>  입력한 년도의 윤년 여부 isLeapYear = " + isLeap);	

		// 입력한 날짜의 달이 3월 이상이고 년도가 윤년이면 윤달인 2월 29일을 지났으므로 1을 더해줌 
		daysFrom00010101 = (month >= 3  && isLeap == true) ? daysFrom00010101 + 1 : daysFrom00010101;
		System.out.println("  <for debug>  입력 연도의 윤년 보정 후 daysFrom00010101 = " + daysFrom00010101);	

		return daysFrom00010101;
	}

	// 서기 1년부터 주어진 년도까지의 윤년 회수를 구해 반환하는 메소드
	//  윤년은 400의 배수이거나 100의 배수가 아닌 4의 배수인 년도가 윤년임
	//  << year / 4 - year / 100 + year / 400 >>은 서기 1년부터 lastYear까지의 윤년 회수를 구하는 수식임 
	static int getCountOfLeapYear(int year) {
		return year / 4 - year / 100 + year / 400; 
	}
	
	// 주어진 년도가 윤년인가를 검사하는 메소드
    //  윤년은 400의 배수이거나 100의 배수가 아닌 4의 배수인 년도가 윤년임
	static boolean isLeapYear(int year) {
		return (year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0);		
	}
}