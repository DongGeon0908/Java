package ex08_date;

/*
 * [ DrawCalendar.c ]: ��� ���� �Է��Ͽ� �޷� ���
 *   
 *   o ���α׷��� ��Ÿ��
 *     1) main() �޼ҵ�θ� ����
 *     2) �ܼ������� �迭���� ����, ��� ���� �Է��Ͽ� ������ ����
 *     3) �Էµ� ��� ���� 1�� ����, ������ ��¥ ���� ���� �޷� ��� 
 *  
 */ 

class Ex4_3_DrawCalendar {
	public static void main(String[] args)  {
		final boolean DEBUG = true;  // �� ���� true�� �ϸ�  <for debug>�� ��µǸ�, false���� �ϸ� <for debug>�� ��µ��� ���� 

		System.out.println("\n\n\n  **** ����� �Է��Ͽ� �޷� ����ϱ� ****\n");

		/*
		 *	�⵵, �� �Է��Ͽ� ������ ���� 
		 */ 
		int year, month; // �Է��� �⵵, ���� ������ ���� 

		year = SkScanner.getIntWithPrompt("  o �� > "); // �� �Է� 
		month = SkScanner.getIntWithPrompt("  o �� > "); // �� �Է�

		/*
		 *	���� 1�� 1�� 1�Ϻ��� �Էµ� ����� 1�ϱ����� ������ ����
		 *   1�� 365�ϰ� ���� ȸ���� �̿��Ͽ� ���⵵������ ������ ���ϰ�
		 *   �Է� �⵵�� �����̰� ���� 3�� �����̸� ���� 2�� 29���� �������Ƿ� 1�� ������ 
		 */ 		
		int lastYear = year - 1;
		int lastMonth = month - 1;

		// �� �޺��� ������ ��¥�� �����ϴ� �迭 
		// ���� �Է��� ���� �����̸� 2���� 28�� �ƴ϶� 29���� 
		int daysOfMonth[] = { 
				0,  31,  28,  31,  30,  31, 30, 
				31,  31,  30,  31,  30, 31                
		};

		// �� �޺��� ���� �ޱ����� ������ ����Ͽ� �����ϴ� �迭 
		int daysUntilMonth[] = { 
				0,  31,  31+28,  31+28+31, // 
				31+28+31+30, 31+28+31+30+31, 31+28+31+30+31+30, 31+28+31+30+31+30+31,       
				31+28+31+30+31+30+31+31, 31+28+31+30+31+30+31+31+30, 31+28+31+30+31+30+31+31+30+31, 31+28+31+30+31+30+31+31+30+31+30                
		};

		int daysFrom00010101; // 1�� 1�� 1�Ϻ��� �Էµ� ����� 1�ϱ��� ������ ���Ͽ� �����ϴ� ���� 


		daysFrom00010101 = lastYear * 365 + daysUntilMonth[lastMonth] ;
		if (DEBUG)
			System.out.printf("\n\n  <for debug>  ���� 1�� 1�� 1�Ϻ����� �⺻ ���� daysFrom00010101 = %d��\n", daysFrom00010101);	

		// lastYear���� ���� ȸ����ŭ ������ ������	
		// << lastYear / 4 - lastYear / 100 + lastYear / 400 >>�� ���� 1����� lastYear������ ���� ȸ���� ���ϴ� ������ 
		int cntLeapYear =  lastYear / 4 - lastYear / 100 + lastYear / 400;
		if (DEBUG)
			System.out.printf("  <for debug>  ���� ȸ�� cntLeapYear = %d��\n", cntLeapYear);	

		daysFrom00010101 += cntLeapYear;  // ���� ���� ȸ���� ���� 
		if (DEBUG)
			System.out.printf("  <for debug>  ����ȸ�� ���� �� daysFrom00010101 = %d��\n", daysFrom00010101);	

		// ������ �����ΰ��� Ȯ��: ������ 4�� ����̸�� 100�� ����� �ƴ� ��� �Ǵ� 400�� ����� ��� 
		boolean isLeapYear = (year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0);
		if (DEBUG)
			System.out.println("  <for debug>  �Է��� �⵵�� ���� ���� isLeapYear = " + isLeapYear);	

		// �Է��� ���� 3�� �̻��̰� �⵵�� �����̸� ������ 2�� 29���� �������Ƿ� 1�� ������ 
		daysFrom00010101 = (month >= 3  && isLeapYear == true) ? daysFrom00010101 + 1 : daysFrom00010101;
		if (DEBUG)
			System.out.printf("  <for debug>  �Է� ������ ���� ���� �� daysFrom00010101 = %d��\n", daysFrom00010101);	

		/*
		 *	�Էµ� ����� ������ ���� 
		 *   - 2���� �����ϰ� ������ �׻� ������ 
		 *   - ����� 2�� ������ 28�������� ������ 2�� ������ 29���� 
		 */ 	
		int lastday;  // �Էµ� ����� ������ ���Ͽ� �����ϴ� ���� 
		lastday = daysOfMonth[month];  // ����� ������ ���� 
		if (isLeapYear && month == 2)  // �Է��� ������ �����̰� ���� 2���̸� 
			lastday = 29;               //    �����̹Ƿ� ������ 29���� 

		/*
		 *	���� ������ 7�� ���� �������� �̿��Ͽ� �Է��� ����� 1���� ������ ���� 
		 *   - ���� 1�� 1�� 1���� ������
		 *   - 1�� 1�� ���� ������ 7�� ���� �������� �� ���� ���� ������ ���ϴ� �߿��� �ܼ��� 
		 *   - 1�� 1�� ���� ������ 1�� ���� ���� 7�� �������� ���� ������ ��Ÿ��
		 *   - �������� 0�̸� ���ۿ����� ��, 1�̸� ��, 2�̸� ȭ, 3�̸� ��, 4�̸� ��, 5�̸� ��, 6�̸� ������� 
		 */
		int weekdayStart; // �Է��� ����� ���� ������ �����ϴ� ����; 
		weekdayStart = (daysFrom00010101 + 1 ) % 7;  // 1�� ���� ���� 7�� ���� �������� 0�̸� �Ͽ��� 

		String weekdayNames[] = {"��", "��", "ȭ", "��", "��", "��", "��"};

		if (DEBUG)
			System.out.printf("  <for debug>  %d�� %d���� ���ۿ���: %s: \n", year, month, weekdayNames[weekdayStart]);	

		System.out.println("\n\n");
		System.out.println("        " + year + "�� " + month + "��");
		System.out.println("  ======================");
		System.out.println("       ��   ��   ȭ   ��   ��   ��   ��");
		System.out.println("  ======================");
		System.out.print("   ");
 
		int wd;  // ������ ��Ÿ���� ������, 0�̸� ��, 1�̸� ��, ...  

		for(wd = 0; wd < weekdayStart ; wd++)	// �Ͽ��Ϻ��� �� ���� ���� ���� ������  
			System.out.print("   ");		        	    // ���� ���

		int day;
		for(day = 1; day <= lastday ; day++) { // 1�Ϻ��� ���ϱ��� ���� �ش� ���Ͽ� ��� 

			if( wd > 1 && wd % 7 == 0 ) {	
				System.out.print("\n   "); // �Ͽ����̸� �ٹٲ��� ���
			}

			wd++;
			System.out.printf("%2d ", day);		// ���� ���
		}
		System.out.println("\n  ======================\n");

		main(args);
	}
}