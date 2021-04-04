package ex08_date;

/*
 * [ Weekday.c ]: ������� �Է��Ͽ� �� ��¥�� ������ ����ϱ�
 *   
 *   o ���α׷��� ��Ÿ��
 *     1) main() �Լ��θ� ����
 *     2) �ܼ������� �迭���� ����, ����, ��, ���� �Է��Ͽ� ������ ����
 *     3) �Էµ� ��¥�� ������ ���� ��� 
 *  
 */    
class Ex4_2_1_Weekday {
	public static void main(String[] args)  {
		System.out.println("\n\n  **** ��¥ �Է��Ͽ� �� ��¥�� ���� ����ϱ� ****\n");

	    /*
		 *	��¥�� �⵵, ��, �Ϸ� �Է��Ͽ� ������ ���� 
		*/ 
	    int year, month, day; // �Է¹��� ��¥���� �⵵, ��, ���� ���Ͽ� ������ ���� 
	    
		System.out.print("  o ���� ���� ��¥�� ���� > ");  // ������ �Է��ϱ� ���� ������Ʈ �޽��� ���
		year = SkScanner.getInt();		

		System.out.print("  o           ��¥�� ��   > ");  // ���� �Է��ϱ� ���� ������Ʈ �޽��� ���
		month = SkScanner.getInt();

		System.out.print("  o           ��¥�� ��   > ");  // ���� �Է��ϱ� ���� ������Ʈ �޽��� ���
		day = SkScanner.getInt();
			
	    /*
		 *	���� 1�� 1�� 1�Ϻ��� �Էµ� ��¥������ ������ ����
		 *   1�� 365�ϰ� ���� ȸ���� �̿��Ͽ� ���⵵������ ������ ���ϰ�
		 *   �Է� �⵵�� �����̰� ���� 3�� �����̸� ���� 2�� 29���� �������Ƿ� 1�� ������ 
		*/ 		
		int lastYear = year - 1;
		int lastMonth = month - 1;
		
		// �� �޺��� ���� �ޱ����� ������ �Ի��Ͽ� �����ϴ� �迭 
		int daysUntilLastMonth[] = { 
		     0,  31,  31+28,  31+28+31, // 
		     31+28+31+30, 31+28+31+30+31, 31+28+31+30+31+30, 31+28+31+30+31+30+31,       
			 31+28+31+30+31+30+31+31, 31+28+31+30+31+30+31+31+30, 31+28+31+30+31+30+31+31+30+31, 31+28+31+30+31+30+31+31+30+31+30                
		};
		
		int daysFrom00010101; // 1�� 1�� 1�Ϻ��� �Էµ� ��¥������ ������ ���Ͽ� �����ϴ� ���� 
		

		daysFrom00010101 = lastYear * 365 + daysUntilLastMonth[lastMonth] + day - 1;
		System.out.println("\n  <for debug>  ���� 1�� 1�� 1�Ϻ����� �⺻ ���� daysFrom00010101 = " + daysFrom00010101);	
		
		// lastYear���� ���� ȸ����ŭ ������ ������	
		// << lastYear / 4 - lastYear / 100 + lastYear / 400 >>�� ���� 1����� lastYear������ ���� ȸ���� ���ϴ� ������ 
		int cntLeapYear =  lastYear / 4 - lastYear / 100 + lastYear / 400;
		System.out.println("  <for debug>  ���� ȸ�� cntLeapYear = " + cntLeapYear);	

		daysFrom00010101 = daysFrom00010101 + cntLeapYear;  // ���� ���� ȸ���� ���� 
		System.out.println("  <for debug>  ����ȸ�� ���� �� daysFrom00010101 = " + daysFrom00010101);	
		
		// ��¥�� ������ �����ΰ��� Ȯ��: ������ 4�� ����̸�� 100�� ����� �ƴ� ��� �Ǵ� 400�� ����� ��� 
		boolean isLeapYear = (year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0);
		System.out.println("  <for debug>  �Է��� �⵵�� ���� ���� isLeapYear = " + isLeapYear);	

		// �Է��� ��¥�� ���� 3�� �̻��̰� �⵵�� �����̸� ������ 2�� 29���� �������Ƿ� 1�� ������ 
		daysFrom00010101 = (month >= 3  && isLeapYear == true) ? daysFrom00010101 + 1 : daysFrom00010101;
		System.out.println("  <for debug>  �Է� ������ ���� ���� �� daysFrom00010101 = " + daysFrom00010101);	
		
	    /*
		 *	���� ������ 7�� ���� �������� �̿��Ͽ� ������ ���Ͽ� ��� 
		 *   - ���� 1�� 1�� 1���� ������
		 *   - 1�� 1�� ���� ������ 7�� ���� �������� ������ ���ϴ�  �߿��� �ܼ��� 
		*/ 
	    String weekdayNames[] = {"��", "ȭ", "��", "��", "��", "��", "��"};
	    

		// 1�� 1�� 1�Ϻ��� �Էµ� ��¥������ ������ 7�� ���� �������� ���� 
		//   �̰��� 0�̸� ��, 1�̸� ȭ, 2�̸� ��, 3�̸� ��, 4�̸� ��, 5�̸� ��, 6�̸� �Ͽ����� 
		int weekdayIndex = daysFrom00010101 % 7;
		System.out.println("  <for debug>  �� ���� 7�� ���� ������ weekdayIndex = " + weekdayIndex);	
		
		// �Է��� ��¥�� ���� ������ ���	 
		System.out.println("\n  ** �Է��� ��¥�� ���� **\n");
		System.out.println("  * ��¥: " + year + "�� " + month + "�� " + day + "��");
		System.out.println("  * ����: " + weekdayNames[weekdayIndex]);  // ��¥�� ������ ��Ÿ���� weekdayNames[weekdayIndex] ���


		System.out.println("\n\n  ^^ Well done! Have a good time!!! ^^"); // �� ������ ���α׷��� ���Ḧ ��Ÿ���� ������
		
		main(args);
	}
}
