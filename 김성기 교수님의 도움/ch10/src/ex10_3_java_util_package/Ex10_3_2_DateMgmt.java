package ex10_3_java_util_package;

import java.util.Date;              // Date 클래스를 사용하기 위해 import
import java.text.SimpleDateFormat;  // 날짜와 시간을 원하는 양식으로 출력하기 위해 import

/**
 * [ DateMgmt 클래스  ]: 
 *        java.util.Date 클래스의 메소드 사용하여 날짜 및 시간 처리
 *  
 *   o java.util 패키지의 Date 클래스
 *     - Java 초기에 년도, 월, 일, 시, 분, 초 등의 날짜 및 시간 정보를 저장하고 처리하기 위한 클래스
 *     - 그러나 Date 클래스의 메소드들이 국제화에 적합하지 않았기 때문에 Date 클래스는 JDK 1.1 버전부터 
 *       Calendar 클래스와 이의 하위 클래스로 대체됨
 *     - Date 클래스의 많은 메소드들은 사용하지 않도록 권고되는(deprecated) 메소드
 *     
 *   o Date 객체의 날짜와 시간을 원하는 양식으로 출력하기
 *     - java.text 패키지의 SimpleDateFormat 클래스 이용
 *     - SimpleDateFormat: Date 객체를 원하는 양식으로 출력하기 위해 포매팅시키는 클래스
 *     - 날짜와 시간 패턴 문자열(date and time pattern string) 이용하여 원하는 양식으로 
 *       Date 객체 포매팅한 문자열 구함 
 *     - 패턴 문자열에 날짜 요소 또는 시간 요소 지정하기 위한 패턴 문자가 사용
 *         Y, y: 년도        M: 월                d: 일
 *         E: 요일              a: 오전/오후      
 *         H:0에서 23까지의 시                     h: 1에서 12까지의 시
 *         m: 분                s: 초
 *             
 *     - 패턴 문자열에 따른 포매팅 결과(Date 객체의 날짜 시간: 2016년 8월 5일 20시 0분 0초일 때)
 *        "y-M-d H:m:s"        ==> "2016-8-5 20:0:0" 
 *        "y/MM/dd HH:mm:ss"   ==> "2016/08/05 20:00:00" 
 *        "y-M-d(E) a h:m:s"   ==> "2016-8-5(수) 오후 8:0:0" 
 *        "y년 M월 d일 a h시 m분"  ==> "2016년 8월 5일 오후 8시 0분"      
 */

public class Ex10_3_2_DateMgmt {
	public static void main(String[] args) {

		Date now = new Date();         // 현재 날짜와 시간을 갖는 Date 객체 생성
		System.out.println("\n  * 현재 날짜와 시간: " + now); // 기본적 양식으로 출력

		// 저장된 시간에서 1900년 1월 1일 0시 0분 0초 후의 milliseconds로 구함
		long msNow = now.getTime(); 
		System.out.println("  * 현재의 밀리초 = " + msNow);  // 현재의 밀리초 출력

		long ms24H = 24 * 60 * 60 * 1000;           // 하루 24시간의 밀리초
   
		long msAfter24H = msNow + ms24H;            // 현재부터 24시간 후의 밀리초 구하기
		Date dAfter24H = new Date(msAfter24H);      // 24시간 후 Date 객체 생성
		System.out.println("\n  * 24시간 후 날짜와 시간: " + dAfter24H);
		System.out.println("  * 24시간 후 밀리초 = " + msAfter24H);

		long msAfter1000D = msNow + 1000 * ms24H;   // 1000일 후의 밀리초 구하기
		Date dAfter1000D = new Date(msAfter1000D);  // 1000일 후 Date 객체 생성
		System.out.println("\n  * 1000일 후 날짜와 시간: " + dAfter1000D);
		System.out.println("  * 1000일 후 밀리초 = " + msAfter1000D);

		long msBefore100D = msNow - 100 * ms24H;    // 100일 전의 밀리초 구하기
		Date dBefore100D = new Date(msBefore100D);  // 100일 전 Date 객체 생성
		System.out.println("\n  * 100일 전 날짜와 시간: " + dBefore100D);
		System.out.println("  * 100일 전 밀리초 = " + msBefore100D);

		// now와 dBefore100D의 전후 관계를 출력
		if (now.compareTo(dBefore100D) < 0)
			System.out.println("\n  * " + now + ": " + dBefore100D + " 이전임");
		else
			System.out.println("\n  * " + now + ": " + dBefore100D + " 이후임");

		// 포맷 패턴 문자열을 저장하는 SimpleDateFormat 객체 생성하여
		// 깔끔한 양식으로 now 출력
		SimpleDateFormat sdf =  
				new SimpleDateFormat("Y년 M월 d일 a h시 m분");
		String nowString = sdf.format(now);    // now를 포매팅한 문자열 반환
		System.out.println("\n  * 현재 날짜와 시간: " + nowString); 
	}
}

/*
 * [ 프로그램 이해 및 실행 ]
 * 
 *   1) 이 프로그램은 여러 Date 객체를 생성하여 출력한다.
 *      
 *   2) 프로그램을 실행하여 출력 결과를 확인하라.           
 */