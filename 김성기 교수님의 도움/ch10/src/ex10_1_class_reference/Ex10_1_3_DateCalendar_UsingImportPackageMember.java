package ex10_1_class_reference;

/**
 * [ DateCalendarUsingImportPackageMember Ŭ���� ]: 
 *       ��Ű�� ��� import�ϰ� Ŭ���� �̸������� ����
 * 
 *   o ��Ű���� ���ԵǴ� Ŭ���� �����ϱ�
 *     1) ����ȭ�� �̸����� ��Ű�� ��� ����: ��Ű�� ����� << ��Ű���̸�.Ŭ�����̸� >>�� ���� 
 *        ��Ű�� �̸��� Ŭ���� �̸��� ��Ʈ�� �����Ų ����ȭ�� �̸����� ǥ���Ͽ� ����
 *     2) ��Ű�� ��� import�ϰ� Ŭ���� �̸����� ����: ��Ű�� ����� ����ȭ�� �̸����� import�ϰ� 
 *        Ŭ���� �̸��� ǥ���Ͽ� ����
 *     3) ��Ű�� ��ü import�ϰ� Ŭ���� �̸����� ����: ��Ű�� ����� ���Ե� ��Ű�� ��ü�� import�ϰ� 
 *        Ŭ���� �̸��� ǥ���Ͽ� ����
 *        
 *   o  ��Ű�� ��� import�ϰ� Ŭ���� �̸����� �����ϱ�
 *     - Date Ŭ������ Calendar Ŭ������ �����ϱ� ���� ��Ű�� ��� import�ϰ� Ŭ���� �̸������� ����
 *     - << import java.util.Date; >>, << import java.util.Calendar; >>�� ����� Ŭ������ import
 *     - ��Ű�� �̸��� �����ϰ� Ŭ���� �̸������� Ŭ������ ���� ����
 *   
 *   o Date�� Calendar Ŭ���� �̿��Ͽ� ���� ��¥�� �ð� ���
 *     - java.util ��Ű���� Date Ŭ������ Calendar Ŭ������ ��¥�� �ð� �ٷ�� ���� Ŭ����
 *     - ��¥�� �ð� �ٷ�� ���� Calendar Ŭ������ Date Ŭ�������� �� ���� �޼ҵ� ����
 *     - �ֱٿ��� Date Ŭ������ ������� ���� �߼�
 */

import java.util.Date;       // java.util ��Ű���� Date Ŭ������ import
import java.util.Calendar;   // java.util ��Ű���� Calendar Ŭ������ import

class Ex10_1_3_DateCalendar_UsingImportPackageMember {  
	public static void main(String[] args) {

		// java.util.Date import�����Ƿ� Ŭ���� �̸� Date������ ���� ������
		Date nowDate = new Date(); // Date() ��ü �����Ͽ� nowDate�� ����

		System.out.println("\n  * ���� ��¥�� �ð�: " + nowDate);  // nowDate ���

		// java.util.Calendar import�����Ƿ� Ŭ���� �̸� Calendar������ ���� ������
		Calendar nowCal = Calendar.getInstance();  // Calendar ��ü �����Ͽ� nowCal�� ����

		System.out.println("\n  * ���� ��¥�� �ð�: "
				+ nowCal.get(Calendar.YEAR) + "�� " 
				+ (nowCal.get(Calendar.MONTH) + 1) + "�� " 
				+ nowCal.get(Calendar.DATE) + "�� " 
				+ nowCal.get(Calendar.HOUR_OF_DAY) + "�� " 
				+ nowCal.get(Calendar.MINUTE) + "�� "
				+ nowCal.get(Calendar.SECOND) + "�� " );
	}
}

/*
 * [ ���α׷� ���� �� ���� ]
 * 
 *   1) �� ���α׷��� Date ��ü�� Calendar ��ü�� �����Ͽ� ��ü ���������� ������ �� 
 *      �⵵, ��, ��, ��, ��, �ʸ� ���
 *   
 *      o import ���忡�� Date Ŭ������ Calendar Ŭ������ ��Ű���� ��õ�
 *      
 *      o �̵� Ŭ������ ������ ������ ��Ű�� �̸��� �����ص� ��
 *      
 *      o �� ���, ���α׷��� ���� �����ϰ� �ۼ���
 *      
 *   2) ���α׷��� �����Ͽ� ��� ����� Ȯ���϶�.
 *      ������ ������ ��, ��, �ʰ� ��ȭ���� �ݵ�� Ȯ���϶�. 
 *      
 *   
 * [ �ǽ� ���� ]
 * 
 *   1) ���ѹα��� ������ ��¥��  �ð��� 1945�� 8�� 15�� ���� 12�� 0�� 0�ʸ� �����ϰ� �̸� ����Ϸ� �Ѵ�.
 *   
 *      o Calendar Ŭ������ ��ü�� ��¥�� �ð��� �����ϱ� ���� �޼ҵ�� set()
 *      
 *        - ������ set() �޼ҵ��  Calendar ��ü  now�� ���� ���� 8�� 15�� ����     
 *           now.set(Calendar.MONTH, 8-1); // ���� ���� ������ 1 ���� ���� ����
 *           now.set(Calendar.DATE, 15);   // ���� ���� ���� ���� ����
 *        
 *        - ��, �ϻ� �ƴ϶� ��, ��, ��, ��, �ʵ� set() �޼ҵ带 �̿��Ͽ� ���� ����
 *      
 *      o Calendar Ŭ������ ��ü���� ��¥�� �ð��� �������� ���� �޼ҵ�� get()
 *      
 *        - ������ get() �޼ҵ��  Calendar ��ü  now�� ����� ���� ���� ������
 *           int month = now.get(Calendar.MONTH); // ���� ���� ������ 1 ���� ���� ����Ǿ� ����
 *           int date = now.get(Calendar.DATE);   // ���� ���� ���� �� ����Ǿ� ����
 *                  
 *        -  ��, �ϻ� �ƴ϶� ��, ��, ��, ��, �ʵ� get() �޼ҵ带 �̿��Ͽ� ������ �� ����
 *      
 *      (1) �����ϰ� �ð��� �����ϱ� ����  Calendar ��ü�� �����ϰ� 
 *         �̸�  Calendar ��ü�������� indepandenceDate�� �����϶�.
 *          
 *      (2) indepandenceDate�� ���� ��¥�� ���� �ð��� ������ �� �̸� ����ϴ� �ڵ带 �߰��� �ۼ��϶�. 
 *      
 *     
 *   2) java.util ��Ű������ ����(random number)�� ������ �� �ִ� Random Ŭ������ �ִ�.
 *   
 *      o Random Ŭ������ Random()�� ��ü �������̸�, ��ü �޼ҵ� double nextDouble()�� 
 *        0�� 1 ������ �Ǽ� ������ ��ȯ�ϴ� �޼ҵ��̴�.
 *       
 *      (1) Random Ŭ������ import�ϱ� ���� import ���� �ۼ��϶�.
 *      
 *      (2) Random Ŭ������ ��ü�� �����Ͽ� ��ü�������� rd�� �����ϴ� ������ �ۼ��϶�.
 *        
 *      (3) for ���� �̿��Ͽ� rd ��ü���� 20���� 0�� 1 ������ ������ �����Ͽ� ����ϴ� �ڵ带 �ۼ��϶�.      
 */
