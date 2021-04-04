package ex10_3_java_util_package;

import java.util.Calendar;      // Calendar 클래스를 사용하기 위해 import
import java.util.Date;          // Date 클래스를 사용하기 위해 import
import java.text.SimpleDateFormat; 

/**
 * [ CalendarMgmt 클래스 ]: 
 *        java.util.Calendar 클래스의 메소드 사용하여 날짜 및 시간 처리
 *  
 *   o java.util 패키지의 Calendar 클래스
 *     - 년도, 월, 일, 시, 분, 초 등의 날짜 및 시간 정보를 저장하고 처리하기 위한 클래스
 *     - 표준시가 다르거나 달력이 다른 경우 국제화에 따른 문제를 해결하는 클래스 
 *     - Calendar 클래스는 abstract 클래스이므로 이 클래스의 객체 생성하지는 못함
 *     - 그 대신 컴퓨터 시스템에 설정된 표준시와 달력을 참고하여 적절한 하위 클래스의 객체 생성하여 
 *       Calendar 객체로 관리함
 *       
 *     - 날짜와 시간을 설정하고 더하고 빼는 등의 편리한 메소드를 제공
 *     
 *   o Calendar 객체의 원하는 양식으로 출력하기   
 *     - Calendar 객체 출력하는 직접적인 방법은 없으므로 Calendar 객체를 Date 객체로
 *         변환하여 출력해야 함
 *     - Calendar 객체를 Date 객체로 변환하는 메소드: Date getTime()
 *     - Date 객체를 SimpleDateFormat 클래스 이용하여 원하는 양식대로 출력할 수 있음
 *
 *     - Calendar 객체를 Date 객체로 변환하고 Date 객체를 SimpleDateFormat 클래스 
 *        이용하여 포맷 패턴 문자열의 양식으로 출력하기
 *        
 *           Calendar cal = Calendar.getInstance(); // Calendar 객체 생성하여 저장
 *           Date d = cal.getTime(); // Calendar 객체를 Date 객체로 변환하여 d에 저장
 *
 *           // 포맷 패턴 문자열 저장하는 SimpleDateFormat 객체 생성하여 sdf에 저장
 *           SimpleDateFormat sdf = new SimpleDateFormat("Y년 M월 d일(E) a h시 m분");
 *           System.out.println("\n 현재 날짜와 시간: " + sdf.format(d)); // d를 포맷하여 출력
 */

public class Ex10_3_3_CalendarMgmt {
	public static void main(String[] args) {
		Calendar now = Calendar.getInstance(); // 현재 날짜와 시간 저장하는 캘린더 
		System.out.println("\n  * now = "  + now);

		// 광복절 날짜인 1945년 8월 15일을 저장하는 캘린더
		Calendar independenceDay = Calendar.getInstance(); 
		independenceDay.clear();              // 저장된 날짜와 시간을 모두 초기화함
		independenceDay.set(1945, 7, 15);     // 1945년 8월 15일을 저장(8월은 7로 저장)

		// 리우 2016 올림픽 개막식 날짜와 시간을 저장하는 캘린더
		Calendar openRio2016 = Calendar.getInstance(); 
		openRio2016.clear();                 // 저장된 날짜와 시간을 모두 초기화함
		openRio2016.set(2016, 7, 5, 20, 0);  // 리우 올림픽 개막: 2016-8-5 오후 8:0:0

		// 오늘 정오 12시로 시간을 저장하는 캘린더 
		Calendar todayNoon = Calendar.getInstance(); 
		todayNoon.set(Calendar.HOUR_OF_DAY, 12 ); // 시를 12시로 저장
		todayNoon.set(Calendar.MINUTE, 0) ;       // 분을 0분으로 저장
		todayNoon.set(Calendar.SECOND, 0);        // 초를 0초로 저장

		System.out.println("\n  * 현재 날짜: "
				+ now.get(Calendar.YEAR) + "년 " 
				+ (now.get(Calendar.MONTH) + 1) + "월 " 
				+ now.get(Calendar.DATE) + "일 ");

		Calendar calAfter24 = Calendar.getInstance(); // Calendar 객체 생성
		calAfter24.add(Calendar.HOUR, 24);            // 24시간 후 날짜, 시간 구함

		Calendar calBefore100 = Calendar.getInstance(); // Calendar 객체 생성
		calBefore100.add(Calendar.DATE, -100);          // 100일 전 날짜, 시간 구함

		Date nowDate = new Date();                  // Date 객체 생성하여 저장
		Calendar nowCal = Calendar.getInstance();   // Calendar 객체 생성하여 저장
		nowCal.setTime(nowDate);                    // NowCal에 nowDate의 날짜, 시간 저장
		Date date = nowCal.getTime();               // nowCal의 날짜, 시간 저장하는 date 객체

		outputCalendar("\n  * 광복절: ", independenceDay);  
		outputCalendar("  * 리우 올림픽 개막: ", openRio2016);  
		outputCalendar("  * 오늘 정오 12시: ", todayNoon);  

		outputCalendar("\n  * 현재 날짜와 시간: ", now);  
		outputCalendar("  * 24시간 후: ", calAfter24);  
		outputCalendar("  * 100일 전: ", calBefore100);  

		outputDate("\n  * nowDate: ", nowDate);  
		outputCalendar("  * nowDate에서 구한 nowCal: ", nowCal);  
		outputDate("  * nowCal에서 구한 date: ", date);  
	}

	// 포맷 패턴 문자열을 저장하는 SimpleDateFormat 객체 생성하여 sdf에 저장
	static SimpleDateFormat sdf =  
			new SimpleDateFormat("Y년 M월 d일(E) a h시 m분");

	// prompt 메시지와 Calendar 객체가 주어지면 이를 패턴 문자열
	//  "Y년 M월 d일 a h시 m분"의 양식으로 출력하는 메소드
	public static void outputCalendar(String prompt, Calendar cal) {
		System.out.println(prompt + sdf.format(cal.getTime()));
	}

	// prompt 메시지와 Date 객체가 주어지면 이를 패턴 문자열
	//  "Y년 M월 d일 a h시 m분"의 양식으로 출력하는 메소드
	public static void outputDate(String prompt, Date date) {
		System.out.println(prompt + sdf.format(date));
	}   
}

/*
 * [ 프로그램 이해 및 실행 ]
 * 
 *   1) 이 프로그램은 여러 Calendar 객체를 생성하고 날짜와 시간을 설정한 후  출력한다.
 *      
 *   2) 프로그램을 실행하여 출력 결과를 확인하라.           
 *   
 *   
 * [ 실습 과제 ]
 * 
 *   o Calendar 객체 생성하여 자신의 생년월일을 저장한 후 100일, 1000일 후, 10000일 후,
 *     2000일 후, 30000일 후의 날짜를 구하여 출력하라.
 */
