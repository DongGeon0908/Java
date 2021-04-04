package ex08_date;

/*
 * [ Weekday_UsingMethod ]: �޼ҵ� ����Ͽ� ������� �Է��Ͽ� �� ��¥�� ������ ����ϱ�
 *   
 *   o ���α׷��� ��Ÿ��
 *     1) ������ ���ϱ� ���� ����  �޼ҵ���� �ۼ�
 *     2) �ܼ������� �迭���� ����, ����, ��, ���� �Է��Ͽ� ������ ����
 *     3) �Էµ� ��¥�� ������ ���� ��� 
 *  
 */   

class Ex5_1_Weekday_UsingMethod {

	int year, month, day;
	String weekday;
	
	// �� �޺��� �� �ޱ����� ������ ����Ͽ� �����ϴ� �迭 
	static int daysUntilMonth[] = { 
		0,  31,  31+28,  31+28+31, // 
		31+28+31+30, 31+28+31+30+31, 31+28+31+30+31+30, 31+28+31+30+31+30+31,       
		31+28+31+30+31+30+31+31, 31+28+31+30+31+30+31+31+30, 31+28+31+30+31+30+31+31+30+31, 31+28+31+30+31+30+31+31+30+31+30                
	};

	static String weekdayNames[] = {"��", "ȭ", "��", "��", "��", "��", "��"};

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

		int weekdayIndex = getWeekday(year, month, day);

		/*
		 *	���� 1�� 1�� 1�Ϻ�����  ������ 7�� ���� �������� �̿��Ͽ� ������ ���Ͽ� ��� 
		 *   - ���� 1�� 1�� 1���� ������
		 *   - 1�� 1�� ���� ������ 7�� ���� �������� ������ ���ϴ�  �߿��� �ܼ��� 
		 */  
		System.out.println("\n  ** �Է��� ��¥�� ���� **\n");
		System.out.println("  * ��¥: " + year + "�� " + month + "�� " + day + "��");
		System.out.println("  * ����: " + weekdayNames[weekdayIndex]);  // ��¥�� ������ ��Ÿ���� weekdayNames[weekdayIndex] ���


		System.out.println("\n\n  ^^ Well done! Have a good time!!! ^^"); // �� ������ ���α׷��� ���Ḧ ��Ÿ���� ������

		main(args);

	}

	static int getWeekday(int year, int month, int day) {
		// ���� 1�� 1�� 1�Ϻ��� �Էµ� ��¥������ ������ ����
		int daysFrom00010101 = getDaysFrom00010101(year, month, day); // 1�� 1�� 1�Ϻ��� �Էµ� ��¥������ ������ ���Ͽ� �����ϴ� ���� 


		// 1�� 1�� 1�Ϻ��� �Էµ� ��¥������ ������ 7�� ���� �������� ���� 
		//   �̰��� 0�̸� ��, 1�̸� ȭ, 2�̸� ��, 3�̸� ��, 4�̸� ��, 5�̸� ��, 6�̸� �Ͽ����� 
		int weekdayIndex = daysFrom00010101 % 7;
		System.out.println("  <for debug>  �� ���� 7�� ���� ������ weekdayIndex = " + weekdayIndex);	

		return weekdayIndex;
	}

	/*
	 *	���� 1�� 1�� 1�Ϻ��� �־��� ��¥������ ������ ���ϴ� �޼ҵ�
	 *   1�� 365�ϰ� ���� ȸ���� �̿��Ͽ� ���⵵������ ������ ���ϰ�
	 *   �Է� �⵵�� �����̰� ���� 3�� �����̸� ���� 2�� 29���� �������Ƿ� 1�� ������ 
	 */
	static int getDaysFrom00010101(int year, int month, int day) {

		int lastYear = year - 1;
		int lastMonth = month - 1;

		int daysFrom00010101 = lastYear * 365 + daysUntilMonth[lastMonth] + day - 1;
		System.out.println("\n  <for debug>  ���� 1�� 1�� 1�Ϻ����� �⺻ ���� daysFrom00010101 = " + daysFrom00010101);	

		// lastYear���� ���� ȸ����ŭ ������ ������	
		int cntLeapYear =  getCountOfLeapYear(lastYear);

		System.out.println("  <for debug>  ���� ȸ�� cntLeapYear = " + cntLeapYear);	

		daysFrom00010101 = daysFrom00010101 + cntLeapYear;  // ���� ���� ȸ���� ���� 
		System.out.println("  <for debug>  ����ȸ�� ���� �� daysFrom00010101 = " + daysFrom00010101);	

		// ��¥�� ������ �����ΰ��� Ȯ��: ������ 4�� ����̸�� 100�� ����� �ƴ� ��� �Ǵ� 400�� ����� ��� 
		boolean isLeap = isLeapYear(year);
		System.out.println("  <for debug>  �Է��� �⵵�� ���� ���� isLeapYear = " + isLeap);	

		// �Է��� ��¥�� ���� 3�� �̻��̰� �⵵�� �����̸� ������ 2�� 29���� �������Ƿ� 1�� ������ 
		daysFrom00010101 = (month >= 3  && isLeap == true) ? daysFrom00010101 + 1 : daysFrom00010101;
		System.out.println("  <for debug>  �Է� ������ ���� ���� �� daysFrom00010101 = " + daysFrom00010101);	

		return daysFrom00010101;
	}

	// ���� 1����� �־��� �⵵������ ���� ȸ���� ���� ��ȯ�ϴ� �޼ҵ�
	//  ������ 400�� ����̰ų� 100�� ����� �ƴ� 4�� ����� �⵵�� ������
	//  << year / 4 - year / 100 + year / 400 >>�� ���� 1����� lastYear������ ���� ȸ���� ���ϴ� ������ 
	static int getCountOfLeapYear(int year) {
		return year / 4 - year / 100 + year / 400; 
	}
	
	// �־��� �⵵�� �����ΰ��� �˻��ϴ� �޼ҵ�
    //  ������ 400�� ����̰ų� 100�� ����� �ƴ� 4�� ����� �⵵�� ������
	static boolean isLeapYear(int year) {
		return (year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0);		
	}
}