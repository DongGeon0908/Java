package ex10_3_java_util_package;

import java.util.Calendar;      // Calendar Ŭ������ ����ϱ� ���� import
import java.util.Date;          // Date Ŭ������ ����ϱ� ���� import
import java.text.SimpleDateFormat; 

/**
 * [ CalendarMgmt Ŭ���� ]: 
 *        java.util.Calendar Ŭ������ �޼ҵ� ����Ͽ� ��¥ �� �ð� ó��
 *  
 *   o java.util ��Ű���� Calendar Ŭ����
 *     - �⵵, ��, ��, ��, ��, �� ���� ��¥ �� �ð� ������ �����ϰ� ó���ϱ� ���� Ŭ����
 *     - ǥ�ؽð� �ٸ��ų� �޷��� �ٸ� ��� ����ȭ�� ���� ������ �ذ��ϴ� Ŭ���� 
 *     - Calendar Ŭ������ abstract Ŭ�����̹Ƿ� �� Ŭ������ ��ü ���������� ����
 *     - �� ��� ��ǻ�� �ý��ۿ� ������ ǥ�ؽÿ� �޷��� �����Ͽ� ������ ���� Ŭ������ ��ü �����Ͽ� 
 *       Calendar ��ü�� ������
 *       
 *     - ��¥�� �ð��� �����ϰ� ���ϰ� ���� ���� ���� �޼ҵ带 ����
 *     
 *   o Calendar ��ü�� ���ϴ� ������� ����ϱ�   
 *     - Calendar ��ü ����ϴ� �������� ����� �����Ƿ� Calendar ��ü�� Date ��ü��
 *         ��ȯ�Ͽ� ����ؾ� ��
 *     - Calendar ��ü�� Date ��ü�� ��ȯ�ϴ� �޼ҵ�: Date getTime()
 *     - Date ��ü�� SimpleDateFormat Ŭ���� �̿��Ͽ� ���ϴ� ��Ĵ�� ����� �� ����
 *
 *     - Calendar ��ü�� Date ��ü�� ��ȯ�ϰ� Date ��ü�� SimpleDateFormat Ŭ���� 
 *        �̿��Ͽ� ���� ���� ���ڿ��� ������� ����ϱ�
 *        
 *           Calendar cal = Calendar.getInstance(); // Calendar ��ü �����Ͽ� ����
 *           Date d = cal.getTime(); // Calendar ��ü�� Date ��ü�� ��ȯ�Ͽ� d�� ����
 *
 *           // ���� ���� ���ڿ� �����ϴ� SimpleDateFormat ��ü �����Ͽ� sdf�� ����
 *           SimpleDateFormat sdf = new SimpleDateFormat("Y�� M�� d��(E) a h�� m��");
 *           System.out.println("\n ���� ��¥�� �ð�: " + sdf.format(d)); // d�� �����Ͽ� ���
 */

public class Ex10_3_3_CalendarMgmt {
	public static void main(String[] args) {
		Calendar now = Calendar.getInstance(); // ���� ��¥�� �ð� �����ϴ� Ķ���� 
		System.out.println("\n  * now = "  + now);

		// ������ ��¥�� 1945�� 8�� 15���� �����ϴ� Ķ����
		Calendar independenceDay = Calendar.getInstance(); 
		independenceDay.clear();              // ����� ��¥�� �ð��� ��� �ʱ�ȭ��
		independenceDay.set(1945, 7, 15);     // 1945�� 8�� 15���� ����(8���� 7�� ����)

		// ���� 2016 �ø��� ������ ��¥�� �ð��� �����ϴ� Ķ����
		Calendar openRio2016 = Calendar.getInstance(); 
		openRio2016.clear();                 // ����� ��¥�� �ð��� ��� �ʱ�ȭ��
		openRio2016.set(2016, 7, 5, 20, 0);  // ���� �ø��� ����: 2016-8-5 ���� 8:0:0

		// ���� ���� 12�÷� �ð��� �����ϴ� Ķ���� 
		Calendar todayNoon = Calendar.getInstance(); 
		todayNoon.set(Calendar.HOUR_OF_DAY, 12 ); // �ø� 12�÷� ����
		todayNoon.set(Calendar.MINUTE, 0) ;       // ���� 0������ ����
		todayNoon.set(Calendar.SECOND, 0);        // �ʸ� 0�ʷ� ����

		System.out.println("\n  * ���� ��¥: "
				+ now.get(Calendar.YEAR) + "�� " 
				+ (now.get(Calendar.MONTH) + 1) + "�� " 
				+ now.get(Calendar.DATE) + "�� ");

		Calendar calAfter24 = Calendar.getInstance(); // Calendar ��ü ����
		calAfter24.add(Calendar.HOUR, 24);            // 24�ð� �� ��¥, �ð� ����

		Calendar calBefore100 = Calendar.getInstance(); // Calendar ��ü ����
		calBefore100.add(Calendar.DATE, -100);          // 100�� �� ��¥, �ð� ����

		Date nowDate = new Date();                  // Date ��ü �����Ͽ� ����
		Calendar nowCal = Calendar.getInstance();   // Calendar ��ü �����Ͽ� ����
		nowCal.setTime(nowDate);                    // NowCal�� nowDate�� ��¥, �ð� ����
		Date date = nowCal.getTime();               // nowCal�� ��¥, �ð� �����ϴ� date ��ü

		outputCalendar("\n  * ������: ", independenceDay);  
		outputCalendar("  * ���� �ø��� ����: ", openRio2016);  
		outputCalendar("  * ���� ���� 12��: ", todayNoon);  

		outputCalendar("\n  * ���� ��¥�� �ð�: ", now);  
		outputCalendar("  * 24�ð� ��: ", calAfter24);  
		outputCalendar("  * 100�� ��: ", calBefore100);  

		outputDate("\n  * nowDate: ", nowDate);  
		outputCalendar("  * nowDate���� ���� nowCal: ", nowCal);  
		outputDate("  * nowCal���� ���� date: ", date);  
	}

	// ���� ���� ���ڿ��� �����ϴ� SimpleDateFormat ��ü �����Ͽ� sdf�� ����
	static SimpleDateFormat sdf =  
			new SimpleDateFormat("Y�� M�� d��(E) a h�� m��");

	// prompt �޽����� Calendar ��ü�� �־����� �̸� ���� ���ڿ�
	//  "Y�� M�� d�� a h�� m��"�� ������� ����ϴ� �޼ҵ�
	public static void outputCalendar(String prompt, Calendar cal) {
		System.out.println(prompt + sdf.format(cal.getTime()));
	}

	// prompt �޽����� Date ��ü�� �־����� �̸� ���� ���ڿ�
	//  "Y�� M�� d�� a h�� m��"�� ������� ����ϴ� �޼ҵ�
	public static void outputDate(String prompt, Date date) {
		System.out.println(prompt + sdf.format(date));
	}   
}

/*
 * [ ���α׷� ���� �� ���� ]
 * 
 *   1) �� ���α׷��� ���� Calendar ��ü�� �����ϰ� ��¥�� �ð��� ������ ��  ����Ѵ�.
 *      
 *   2) ���α׷��� �����Ͽ� ��� ����� Ȯ���϶�.           
 *   
 *   
 * [ �ǽ� ���� ]
 * 
 *   o Calendar ��ü �����Ͽ� �ڽ��� ��������� ������ �� 100��, 1000�� ��, 10000�� ��,
 *     2000�� ��, 30000�� ���� ��¥�� ���Ͽ� ����϶�.
 */
