package ex04_3_patient_mgmt_subclass;

import java.util.Calendar;

//��¥�� �ð��� ���� �޼ҵ带 ���� Ŭ����

class Date {
	
	// getCalendar(): yyyymmdd ����� 8�ڸ� ������ ��, ��, ���� �־����� �̸�  �����ϴ� Calendar ��ü�� ��ȯ�ϴ� Ŭ���� �޼ҵ�
	static Calendar getCalendar(int date) {
		
		Calendar cal = Calendar.getInstance();  // Calendar ��ü�� �����Ͽ� cal�� ����		
		Date.setYearMonthDate(cal, date);        // Calendar ��ü  cal�� ������ ��, ��, ���� ����
		
		return cal;  // Calendar ��ü  cal ��ȯ
	}

	// setYearMonthDate(): yyyymmdd ����� 8�ڸ� ������ ��, ��, ���� �־����� �̸�  Calendar ��ü cal�� �����ϴ� Ŭ���� �޼ҵ�
	static void setYearMonthDate(Calendar cal, int date) {
		if (date < 10000)  // ��¥���� �⵵�� �Էµ��� ������ 20170101�� ������
			date = 20170101;
				
		cal.set(Calendar.YEAR, date / 10000);            // 8�ڸ��� 10000���� ���� ���� ��
		cal.set(Calendar.MONTH, date % 10000 / 100 - 1); // 8�ڸ��� 10000���� ���� ������ �� 100���� ���� ���� ��(����: Calendar ��ü���� ���� 0���� �����ϹǷ� 1�� ��)
		cal.set(Calendar.DATE, date % 100);              // 8�ڸ��� 100���� ���� ������ �� 100���� ���� ���� ��
	} 
	
	// getAge(): �־��� �Ű����� Calendar ��ü date�� ����� ��¥�� ���� ��¥ ������ ���(����)�� ���Ͽ� ��ȯ�ϴ� �޼ҵ�
	static int getAge(Calendar date) {
		int yearDate = date.get(Calendar.YEAR);
		int monthDate = date.get(Calendar.MONTH);
		int dateDate = date.get(Calendar.DATE);
		
		Calendar today = Calendar.getInstance();  // Calendar ��ü�� �����Ͽ� today�� ����		

		int yearToday = today.get(Calendar.YEAR);
		int monthToday = today.get(Calendar.MONTH);
		int dateToday = today.get(Calendar.DATE);
		
		int years = yearToday - yearDate;
		
		if (monthDate > monthToday || monthDate == monthToday && dateDate > dateToday)
			years--;
		
		return years;
	}
	
	// getDateString(): �־��� �Ű����� Calendar ��ü cal���� ��, ��, ���� ���Ͽ� ���ڿ��� ��ȯ�ϴ� Ŭ���� �޼ҵ�
	static String getDateString(Calendar cal) {              
     // ���� ��, ��, ���� ���Ͽ� ���ڿ��� �����Ͽ� ��ȯ((����: Calendar ��ü���� ���� 0���� �����ϹǷ� ���� ���� ������ 1�� ������)
		return cal.get(Calendar.YEAR) + "�� " + (cal.get(Calendar.MONTH) + 1) + "�� " + cal.get(Calendar.DATE) + "��";
		
		// Calendar ��ü���� ��, ��, �� ���� �����ϴ� �ٸ�  ������� DateFormat Ŭ������ �̿��� �� ����
		// ���� ���� ���ڿ��� �����ϴ� SimpleDateFormat ��ü �����Ͽ� sdf�� ����
		//    java.text.SimpleDateFormat sdf =  
		//                  new java.text.SimpleDateFormat("Y�� M�� d��");
        //    return sdf.format(cal.getTime());
	}
	
}
