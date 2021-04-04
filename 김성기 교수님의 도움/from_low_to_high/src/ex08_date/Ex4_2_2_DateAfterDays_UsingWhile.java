package ex08_date;

/*
 * [ DayAfter.c ]: ��¥�� �Է��� �� �� ��¥ ���� �־��� ���� ���� ��¥ ���Ͽ� ����ϱ�
 *   
 *   o ���α׷��� ��Ÿ��
 *     1) main() �޼ҵ�θ� ����
 *     2) �ܼ������� �迭���� ����, ����, ��, ���� �Է��Ͽ� ������ ����
 *     3) ��¥�� ���� �Է��Ͽ� �� �� �� ������ ��¥ ���Ͽ� ����ϱ� 
 *  
 */   
class Ex4_2_2_DateAfterDays_UsingWhile {
	public static void main(String[] args)  {
		System.out.println("\n\n  **** ��¥�� ������ �Է��Ͽ� ���� ���� ��¥ ����ϱ�(Using while) ****\n");

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

		/*
		 *  ��¥�� �Ͽ� ������ ���� ���� �ش� ���� �ϼ����� ���� ������ month�� 1��  ���ϰ� 
		 *   ������ ���� �ϼ���ŭ ������
		 *   ���� 13��ehlaus year�� 1 �����ϰ� month�� 1�� �缳���Ͽ� �ٽ� �ݺ���
		 */


		// �� ���� �� ���� �����ϴ� �迭 
		int daysOfMonths[] = { 
				0,  
				31,  28,  31,  30,  31,  30, 
				31,  31,  30,  31,  30,  31               
		};

		day = day + days; // ��¥�� �Ͽ� ������ ����	

		while(true) {
			int daysOfThisMonth = daysOfMonths[month];

			if (month == 2 && ( (year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) )
				daysOfThisMonth++;  // ���� 2���̸鼭 �� �ذ� �����̸� ���� �ϼ��� 1 ���� ��Ŵ

			if (day <= daysOfThisMonth)
				break;

			day = day - daysOfThisMonth;  // �� ���� �ϼ���ŭ �ϼ��� ���� 

			month++;              // ���� 1 ������Ŵ 
			if (month > 12)  {    // ���� 13�̵Ǹ� 
				month = 1;        //     ���� 1�� �����Ѱ� 
				year++;           //      ���� ������Ŵ 
			}
		}

		// �Է��� ��¥�� ���� ������ ���	 
		System.out.println("\n\n  ** �Է��� ��¥���� ���� ���� ��¥ **\n");
		System.out.println("  * ��¥: " + year0 + "�� " + month0 + "�� " + day0 + "��\n");
		System.out.println("  * " + days + "�� ���� ��¥: " + year + "�� " + month + "�� " + day + "��\n");

		System.out.println("\n  ^^ Well done! Have a good time!!! ^^\n"); // �� ������ ���α׷��� ���Ḧ ��Ÿ���� ������

		main(args);
	}
}
