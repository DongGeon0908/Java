package ex08_date;

/*
 * [ Date, Weekday_UsingClass ]: 년월일을 입력하여 그 날짜의 요일을 출력하기(Date 클래스 작성)
 *   
 *   o 프로그래밍 스타일
 *     1) main() 함수 여러 다른 메소드들로  구성
 *     2) 단순변수와 배열변수 선언, 연도, 월, 일을 입력하여 변수에 저장
 *     3) 입력된 날짜의 요일을 구해 출력 
 *  
 */   

class Date {
	int year, month, day;
	String weekday;
	
	Date(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}

	// 각 달별로 그 달까지의 날수를 계산하여 저장하는 배열(달은 0부터 시작함) 
	static int daysUntilMonth[] = { 
		0,  31,  31+28,  31+28+31, // 
		31+28+31+30, 31+28+31+30+31, 31+28+31+30+31+30, 31+28+31+30+31+30+31,       
		31+28+31+30+31+30+31+31, 31+28+31+30+31+30+31+31+30, 31+28+31+30+31+30+31+31+30+31, 31+28+31+30+31+30+31+31+30+31+30                
	};

	static String weekdayNames[] = {"월", "화", "수", "목", "금", "토", "일"};
	
	void input() {
		int year, month, day; // 입력받은 날짜에서 년도, 월, 일을 구하여 저장할 변수 

		System.out.print("  o 요일 구할 날짜의 연도 > ");  // 연도를 입력하기 위한 프롬프트 메시지 출력
		year = SkScanner.getInt();		

		System.out.print("  o        날짜의 월    > ");  // 월을 입력하기 위한 프롬프트 메시지 출력
		month = SkScanner.getInt();

		System.out.print("  o        날짜의 일    > ");  // 일을 입력하기 위한 프롬프트 메시지 출력
		day = SkScanner.getInt();
		
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	static Date inputDate() {
		int year, month, day; // 입력받은 날짜에서 년도, 월, 일을 구하여 저장할 변수 

		System.out.print("  o 요일 구할 날짜의 연도 > ");  // 연도를 입력하기 위한 프롬프트 메시지 출력
		year = SkScanner.getInt();		

		System.out.print("  o        날짜의 월    > ");  // 월을 입력하기 위한 프롬프트 메시지 출력
		month = SkScanner.getInt();

		System.out.print("  o        날짜의 일    > ");  // 일을 입력하기 위한 프롬프트 메시지 출력
		day = SkScanner.getInt();
	
		return new Date(year, month, day);
	}
	
	void setWeekday() {
		this.weekday = this.getWeekday();
	}
	
    String getWeekday() {		
		return Date.getWeekday(this.year, this.month, this.day);
	}
    
    void output(String title) {
		System.out.println(title);
		System.out.println("  * 날짜: " + this.year + "년 " + this.month + "월 " + this.day + "일");  // 날짜 출력
		System.out.println("  * 요일: " + this.weekday);  // 날짜를 요일을 나타내는 weekday 출력   	
    }
	
    static String getWeekday(int year, int month, int day) {
    	int weekdayIndex = Date.getWeekdayIndex(year, month, day);
		return Date.weekdayNames[weekdayIndex];
    }
    
	static int getWeekdayIndex(int year, int month, int day) {

		// 서기 1년 1월 1일부터 입력된 날짜까지의 날수를 구함
		int daysFrom00010101 = Date.getDaysFrom00010101(year, month, day); // 1년 1월 1일부터 입력된 날짜까지의 날수를 구하여 저장하는 변수 


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

		int daysFrom00010101 = lastYear * 365 + Date.daysUntilMonth[lastMonth] + day - 1;
		System.out.println("\n  <for debug>  서기 1년 1월 1일부터의 기본 날수 daysFrom00010101 = " + daysFrom00010101);	

		// lastYear까지 윤년 회수만큼 날수를 더해줌	
		int cntLeapYear =  Date.getCountOfLeapYear(lastYear);

		System.out.println("  <for debug>  윤년 회수 cntLeapYear = " + cntLeapYear);	

		daysFrom00010101 = daysFrom00010101 + cntLeapYear;  // 구한 윤년 회수를 더함 
		System.out.println("  <for debug>  윤년회수 더한 후 daysFrom00010101 = " + daysFrom00010101);	

		// 날짜의 연도가 윤년인가를 확인: 윤년은 4의 배수이면수 100의 배수가 아니 경우 또는 400의 배수인 경우 
		boolean isLeap = Date.isLeapYear(year);
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


class Ex6_1_Weekday_UsingClass {

	public static void main(String[] args)  {
		System.out.println("\n\n  **** 날짜 입력하여 그 날짜의 요일 출력하기 ****\n");

		//	날짜를 년도, 월, 일로 입력하여 Date 객체에 저장 
		Date date = Date.inputDate();
			
		date.setWeekday(); // date 객체에 저장된 년도, 월, 일로 요일을 구하여 weekday 필드에 저장
		date.output("\n  ** 입력한 날짜의 요일 **\n"); // date 객체에 저장된 년도, 월, 일, 요일을 출력

		System.out.println("\n\n  ^^ Well done! Have a good time!!! ^^"); // 이 문장은 프로그램의 종료를 나타내는 문장임

		main(args);

	}
}