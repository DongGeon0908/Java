package ex04_3_patient_mgmt_subclass;

import java.util.Calendar;

//날짜와 시간에 관한 메소드를 갖는 클래스

class Date {
	
	// getCalendar(): yyyymmdd 양식의 8자리 정수로 년, 월, 일이 주어지면 이를  저장하는 Calendar 객체를 반환하는 클래스 메소드
	static Calendar getCalendar(int date) {
		
		Calendar cal = Calendar.getInstance();  // Calendar 객체를 생성하여 cal에 저장		
		Date.setYearMonthDate(cal, date);        // Calendar 객체  cal에 정수로 년, 월, 일을 저장
		
		return cal;  // Calendar 객체  cal 반환
	}

	// setYearMonthDate(): yyyymmdd 양식의 8자리 정수로 년, 월, 일이 주어지면 이를  Calendar 객체 cal에 저장하는 클래스 메소드
	static void setYearMonthDate(Calendar cal, int date) {
		if (date < 10000)  // 날짜에서 년도가 입력되지 않으면 20170101로 설정함
			date = 20170101;
				
		cal.set(Calendar.YEAR, date / 10000);            // 8자리중 10000으로 나눈 몫이 년
		cal.set(Calendar.MONTH, date % 10000 / 100 - 1); // 8자리중 10000으로 나눈 나머지 중 100으로 나눈 몫이 월(참고: Calendar 객체에서 월은 0부터 시작하므로 1을 뺌)
		cal.set(Calendar.DATE, date % 100);              // 8자리중 100으로 나눈 나머지 중 100으로 나눈 몫이 일
	} 
	
	// getAge(): 주어진 매개변수 Calendar 객체 date에 저장된 날짜와 현재 날짜 사이의 년수(나이)를 구하여 반환하는 메소드
	static int getAge(Calendar date) {
		int yearDate = date.get(Calendar.YEAR);
		int monthDate = date.get(Calendar.MONTH);
		int dateDate = date.get(Calendar.DATE);
		
		Calendar today = Calendar.getInstance();  // Calendar 객체를 생성하여 today에 저장		

		int yearToday = today.get(Calendar.YEAR);
		int monthToday = today.get(Calendar.MONTH);
		int dateToday = today.get(Calendar.DATE);
		
		int years = yearToday - yearDate;
		
		if (monthDate > monthToday || monthDate == monthToday && dateDate > dateToday)
			years--;
		
		return years;
	}
	
	// getDateString(): 주어진 매개변수 Calendar 객체 cal에서 년, 월, 일을 구하여 문자열로 반환하는 클래스 메소드
	static String getDateString(Calendar cal) {              
     // 직접 년, 월, 일을 구하여 문자열로 구성하여 반환((참고: Calendar 객체에서 월은 0부터 시작하므로 월을 구할 때에는 1을 더해줌)
		return cal.get(Calendar.YEAR) + "년 " + (cal.get(Calendar.MONTH) + 1) + "월 " + cal.get(Calendar.DATE) + "일";
		
		// Calendar 객체에서 년, 월, 일 등을 추출하는 다름  방법으로 DateFormat 클래스를 이용할 수 있음
		// 포맷 패턴 문자열을 저장하는 SimpleDateFormat 객체 생성하여 sdf에 저장
		//    java.text.SimpleDateFormat sdf =  
		//                  new java.text.SimpleDateFormat("Y년 M월 d일");
        //    return sdf.format(cal.getTime());
	}
	
}
