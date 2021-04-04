/**
 * [ Expressions ]: ���� ������ ����
 *        
 *   o ���α׷��� ��Ÿ�� 
 *     1) main() �޼ҵ�θ� Ŭ���� ����
 *     2) �ۼ��� ���� ������ ��� Ȯ��
 *       
 *   o ������ ���� ������ ���ʷ� �����Ͽ� �ϳ��� ��� ������
 *     1) ������ ���� ���� ��Ģ�� �°� �ۼ��Ǿ�� ��
 *     2) ������ ������ �켱������ ���ռ��� ���� ����� ���� ����
 *     3) ���� ���Ǵ� ������ ������ �����ϰ� �̸� Ȱ���ϴ� �ɷ� ���߾�� ��   
 */

class Ex3_3_1_Expressions  {
	public static void main(String[] args)  {
		
		/*
		 * ��, �ִ�, �ο���, ��� ��� ���õ� ����
		 */
		int sumScores = 894,  maxScore = 99, noStudents = 10;
		double avgScores;
		System.out.println(  "\n ** ��, �ִ�, �ο���, ��� ��� ���õ� ���� **" ); 
		System.out.println(  avgScores = sumScores / (double) noStudents  );
		System.out.println(  avgScores + 10 > maxScore - 10  );

		/*
		 * �Ǹ� ��Ȳ, ���� ��� ��� ���õ� ����
		 */
		int totalPrice = 0, price = 9900, number = 15;
		int amount = 1000000;
		double rate = 0.04;

		System.out.println(  "\n ** �Ǹ� ��Ȳ, ���� ��� ��� ���õ� ���� **" ); 
		System.out.println(  totalPrice += price * number  );          // �Ǹűݾ� ����
		System.out.println(  amount = (int) (amount * (1 + rate))  );  // �����հ� ���ϱ�

		/*
		 * ����, �Ǽ��� ���õ� ���� ���ĵ�
		 */
		int n = 12345, nDividedBy10;
		double pi = 3.141592;    // ������

		System.out.println(  "\n ** ����, �Ǽ��� ���õ� ���� ���ĵ� **" ); 
		System.out.println(  n / 100 * 100  );                       // 100�ڸ����� ���� 
		System.out.println(  (int) ((pi + 0.005) * 100) / 100.0  );  // �Ҽ��� ���� 2�ڸ������ݿø� 

		System.out.println(  n % 2 == 0 || n % 3 == 0 || n % 5 == 0  );
		System.out.println(  n % 10 + n / 10 % 10 + n / 100 % 10 + n / 1000 % 10 + n / 10000 % 10  );           // 6�ڸ����� �� �ڸ��� �� ����
		System.out.println(  n % 10 + n % 100 / 10 + n % 1000 / 100 + n % 10000 / 1000 + n % 100000 / 10000  ); // 6�ڸ����� �� �ڸ��� �� ����

		System.out.println(  n >> 1 + n << 1  );     // ������ �켱������ �߸��Ǿ� �߸��� ��� ������
		System.out.println(  (n >> 1) + (n << 1)  ); // �̴� n * 2 + n / 2�� ������

		System.out.println(  n >= 10 && n <=19 || n >= 30 && n <= 39 || n >= 70 && n <= 79  );          // ���� ���� �˻�
		System.out.println(  (nDividedBy10 = n / 10) == 1 || nDividedBy10 == 3 || nDividedBy10 == 7  ); // ���� ���� �˻�

		/*
		 * �µ� ��ȯ�� ���� ����
		 */
		double F = 50.5;

		System.out.println(  "\n ** �µ� ��ȯ�� ���� ���� **" ); 
		System.out.println(  F - 32 * 5 / 9   );    // ���������� ���� ������ �������� ���� �ִ� ����
		System.out.println(  (F - 32) * 5 / 9   );  // ȭ���µ��� �����µ��� ��ȯ�ϴ� ���� 

		/*
		 * ���� �� ���� ó���� ���� ���� ����
		 */
		int score;
		String grade;
		
		System.out.println(  "\n ** ���� �� ���� ó���� ���� ���� ���� **" ); 
		System.out.print("  o ���� �Է��Ͻÿ� > ");
		System.out.println(  score = SkScanner.getInt() );
		
		System.out.println(  score >= 90 && score <= 100  );  // ������ ���� �˻�
		System.out.println(  grade = score>=95 ? "A+"  : score>=90 ? "A0" : score>=85? "B+"  // ������ �������� ��ȯ�ϴ� ����
			     : score>=80 ? "B0" : score>=75 ? "C+" : score>=70 ? "C0" : score>=65? "D+" 
			     : score>=60 ? "D0" : "F"  );

		System.out.println(  grade.equals("A+") || grade=="A0" || grade.equals("B" + "+")  );  // ���ڿ� ���� ��

		/*
		 * ���ڿ� ���� ����
		 */
		String name = "ȫ�浿";
		int age = 18;

		System.out.println(  "\n ** ���ڿ� ���� ���� **" ); 
		System.out.println(  name + "�� ����: "+ age + ", 10�� �� ����: "  + age + 10  );
		System.out.println(  name + "�� ����: "+ age + ", 10�� �� ����: "  + (age + 10)  );		
	}
}

/*
 * [ ���α׷��� ���� �� ���� ]
 *
 *   o ������ ����� ������ ���غ��� ������ ����� ���� ����.
 *  
 */

