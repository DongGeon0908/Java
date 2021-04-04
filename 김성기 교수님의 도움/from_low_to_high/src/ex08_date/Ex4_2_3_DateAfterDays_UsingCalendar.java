package ex08_date;

/*
 * [ DateAfterDays_UsingCalendar ]: ��¥�� �Է��� �� �� ��¥ ���� �־��� ���� ���� ��¥ ���Ͽ� ����ϱ�
 *   
 *   o ���α׷��� ��Ÿ��
 *     1) main() �޼ҵ�θ� ����
 *     2) �ܼ������� �迭���� ����, ����, ��, ���� �Է��Ͽ� ������ ����
 *     3) ��¥�� ���� �Է��Ͽ� �� �� �� ������ ��¥ ���Ͽ� ����ϱ� 
 *  
 */   

import java.util.Calendar;
import java.util.Scanner;

class Ex4_2_3_DateAfterDays_UsingCalendar {
	public static void main(String[] args)  {

		System.out.println("\n\n  **** ��¥�� ������ �Է��Ͽ� ���� ���� ��¥ ����ϱ�(Using Calendar)  ****\n");

		/*
		 *	��¥�� �⵵, ��, �Ϸ� �Է��Ͽ� ������ ���� 
		 */ 
		int year0, year, month0, month, day0, day; // �Է¹��� ��¥���� �⵵, ��, ���� ���Ͽ� ������ ���� 
		int days; // ������ �Է��Ͽ� ������ ���� 

		System.out.print("  o ���� ��¥�� ���� > ");  // ������ �Է��ϱ� ���� ������Ʈ �޽��� ���
		year0 = year = SkScanner.getInt();		

		System.out.print("  o      ��¥�� ��   > ");  // ���� �Է��ϱ� ���� ������Ʈ �޽��� ���
		month0 = month = SkScanner.getInt();

		System.out.print("  o      ��¥�� ��   > ");  // ���� �Է��ϱ� ���� ������Ʈ �޽��� ���
		day0 = day = SkScanner.getInt();

		System.out.print("\n  o      ����   > ");  // ������ �Է��ϱ� ���� ������Ʈ �޽��� ���
		days = SkScanner.getInt();



		Calendar c = Calendar.getInstance(); // Calendar ��ü �����ϴ� �����!!!

		// Calendar ��ü�� ��, ��, �� �����ϱ�
		c.set(Calendar.YEAR, year);      
		c.set(Calendar.MONTH, month - 1);  // Calendar Ŭ�������� ���� 0���� ������
		c.set(Calendar.DATE, day + days);  // �̴� c.set(Calendar.DATE, day);  c.set(Calendar.DATE, c.get(Calendar.DATE) + days);�� ������ 

        // ���� ������ ��¥�� ���� year, month, day�� �����ϱ�
		year = c.get(Calendar.YEAR);
		month = c.get(Calendar.MONTH) + 1;
		day = c.get(Calendar.DATE); 

		// �Է��� ��¥���� ���� ���� ��¥�� ���� ��� ���	 
		System.out.println("\n\n  ** �Է��� ��¥���� ���� ���� ��¥ **\n\n");
		System.out.println("  * ��¥: " + year0 + "�� " + month0 + "�� " + day0 + "��\n");
		System.out.println("  * " + days + "�� ���� ��¥: " + year + "�� " + month + "�� " + day + "��\n");

		System.out.println("\n  ^^ Well done! Have a good time!!! ^^\n"); // �� ������ ���α׷��� ���Ḧ ��Ÿ���� ������

		main(args);

	}
}
