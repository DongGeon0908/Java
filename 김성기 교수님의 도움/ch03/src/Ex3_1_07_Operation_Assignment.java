/**
 * [ Operation_Assignment ]: ���� ������ ����
 *     
 *   o ���α׷��� ��Ÿ�� 
 *     1) main() �޼ҵ�θ� Ŭ���� ����
 *     2) ���� ������ �����Ͽ� ��� �� ���
 *     
 *   o ���� ������ =, +=, -=, ... ���� ����
 */

class Ex3_1_07_Operation_Assignment  {
	public static void main(String[] args)  {
								
		int age;
		int balance = 50000, amount = 20000;
		int n = 0x1234_5678;

		System.out.println("\n  ** ���� ����(=, -=, >>=) **\n");

		System.out.println("  * age = 18          = " + ( age = 18 ));  	    //  ��  18
		System.out.println("  * age = age + 1     = " + ( age = age + 1 ));  	//  ��  19
		System.out.println();
		
		System.out.println("  * ���� �ʱⰪ: balance = " + balance + ", amount = " + amount); 
		System.out.println("  * balance -= amount    := " + ( balance -= amount )); //  ��  30000		
		System.out.println();
		
		System.out.printf("  * ���� �ʱⰪ: n  = 0x%x \n", ( n ));     //  �� 0x1234_5678;
		System.out.printf("  * n >>= 16  := 0x%x ", ( n >>= 16 ));     //  ��  0x1234
		System.out.println();
		
		int thisYear, nextYear;
		System.out.print("\n\n  * ���� �⵵ �Է�(1) > ");
		thisYear = SkScanner.getInt();   // ���� 1) 
		nextYear = thisYear + 1;  		 // ���� 2) 
		
		System.out.println("\n  ** < thisYear = SkScanner.getInt();  nextYear = thisYear + 1; > ���� �� **");
		System.out.println("  * thisYear := " + thisYear);
		System.out.println("  * nextYear := " + nextYear);
			
		System.out.print("\n\n  * ���� �⵵ �Է� (2)> ");
		nextYear = (thisYear = SkScanner.getInt()) + 1;  // �� ������ ���� ���� 1)�� ���� 2)�� �� ������ �ϳ��� �������� ����Ų ����
		System.out.println("\n  ** < nextYear = (thisYear = SkScanner.getInt()) + 1; > ���� �� **");
		System.out.println("  * thisYear := " + thisYear);
		System.out.println("  * nextYear := " + nextYear);		
	}
}

/*
 * [ ���α׷��� ���� �� ���� ]
 *
 *   o ������ ����� ������ ���غ��� ������ ����� ���� ����.
 *  
 */
