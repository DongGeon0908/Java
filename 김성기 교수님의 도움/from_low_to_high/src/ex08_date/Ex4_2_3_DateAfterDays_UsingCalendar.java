package ex08_date;

/*
 * [ DateAfterDays_UsingCalendar ]: 날짜를 입력한 후 그 날짜 이후 주어진 날수 후의 날짜 구하여 출력하기
 *   
 *   o 프로그래밍 스타일
 *     1) main() 메소드로만 구성
 *     2) 단순변수와 배열변수 선언, 연도, 월, 일을 입력하여 변수에 저장
 *     3) 날짜와 날수 입력하여 그 날 수 이후의 날짜 구하여 출력하기 
 *  
 */   

import java.util.Calendar;
import java.util.Scanner;

class Ex4_2_3_DateAfterDays_UsingCalendar {
	public static void main(String[] args)  {

		System.out.println("\n\n  **** 날짜와 날수를 입력하여 날수 후의 날짜 출력하기(Using Calendar)  ****\n");

		/*
		 *	날짜를 년도, 월, 일로 입력하여 변수에 저장 
		 */ 
		int year0, year, month0, month, day0, day; // 입력받은 날짜에서 년도, 월, 일을 구하여 저장할 변수 
		int days; // 날수를 입력하여 저장할 변수 

		System.out.print("  o 시작 날짜의 연도 > ");  // 연도를 입력하기 위한 프롬프트 메시지 출력
		year0 = year = SkScanner.getInt();		

		System.out.print("  o      날짜의 월   > ");  // 월을 입력하기 위한 프롬프트 메시지 출력
		month0 = month = SkScanner.getInt();

		System.out.print("  o      날짜의 일   > ");  // 일을 입력하기 위한 프롬프트 메시지 출력
		day0 = day = SkScanner.getInt();

		System.out.print("\n  o      날수   > ");  // 날수를 입력하기 위한 프롬프트 메시지 출력
		days = SkScanner.getInt();



		Calendar c = Calendar.getInstance(); // Calendar 객체 생성하는 방법임!!!

		// Calendar 객체에 년, 월, 일 설정하기
		c.set(Calendar.YEAR, year);      
		c.set(Calendar.MONTH, month - 1);  // Calendar 클래스에서 월은 0부터 시작함
		c.set(Calendar.DATE, day + days);  // 이는 c.set(Calendar.DATE, day);  c.set(Calendar.DATE, c.get(Calendar.DATE) + days);과 동일함 

        // 날수 더해진 날짜를 구해 year, month, day에 저장하기
		year = c.get(Calendar.YEAR);
		month = c.get(Calendar.MONTH) + 1;
		day = c.get(Calendar.DATE); 

		// 입력한 날짜에서 날수 더한 날짜를 구한 결과 출력	 
		System.out.println("\n\n  ** 입력한 날짜부터 날수 후의 날짜 **\n\n");
		System.out.println("  * 날짜: " + year0 + "년 " + month0 + "월 " + day0 + "일\n");
		System.out.println("  * " + days + "일 후의 날짜: " + year + "년 " + month + "월 " + day + "일\n");

		System.out.println("\n  ^^ Well done! Have a good time!!! ^^\n"); // 이 문장은 프로그램의 종료를 나타내는 문장임

		main(args);

	}
}
