/**
 * [ RecursiveMethod ]: ��� �޼ҵ��� �ۼ��� ȣ��
 *  
 *   o 1���� n������ ���� ���ϴ� �޼ҵ� getSum(int n)�� 
 *     n ���丮���� ���ϴ� getFactorial(int n)�� ��� �޼ҵ�� �ۼ�
 *     
 *   o ��� �޼ҵ�
 *     - �޼ҵ� �������� �ڽ��� ȣ���ϴ� �޼ҵ�
 *     - ��� �޼ҵ� ȣ��Ǹ� Ư�� ���� ������ ������ ���������� ��� �޼ҵ� ȣ���
 *     - Ư�� ���ǿ� �����ϸ� ���������� ȣ��� �޼ҵ� ��ȯ��
 *     
 *   o 1���� n������ �� sum(n)�� �ݺ��� ǥ���� ����� ǥ������ ����
 *     - ����� ǥ��: sum(n) = 1 + 2 + 3 + ... + n 
 *     - �ݺ��� ǥ��: sum(n) = sum(n-1) + n (�� n�� 1�̸� sum(1) = 1) 
 *     
 *     - �̸� ��� �޼ҵ�� �ۼ��� ���� int getSum(int n) �޼ҵ�
 *         
 *   o main() �޼ҵ忡�� getSum(5) ȣ�� �� �������
 *     - �޼ҵ� ȣ��� ��ȯ�� ���������� �̷����
 *     
 *     - getSum(5) ȣ��Ǹ� getSum(4), getSum(3), getSum(2), getSum(1)�� ���������� ȣ��
 *     - getSum(1)���� 1�� getSum(2)�� ��ȯ(Ư�����ǿ� �ش�)
 *     - �ٽ� getSum(2)���� 1(��ȯ��) + 2 = 3�� getSum(3)���� ��ȯ
 *     - �ٽ� getSum(3)���� 3(��ȯ��) + 3 = 6�� getSum(4)�� ��ȯ
 *     - �ٽ� getSum(4)���� 6(��ȯ��) + 4 = 10�� getSum(5)�� ��ȯ
 *     - ���������� getSum(5)���� 10(��ȯ��) + 5 = 15��  main()����  ��ȯ
 *   
 */

public class Ex5_6_1_RecursiveMethod {
	
	// getSum(int n): 1���� n���� ���� ���Ͽ� ��ȯ�ϴ� �޼ҵ�
	static int getSum(int n) {
		if (n == 1)                   // n�� Ư�� ������ 1�̸�  
			return 1;                 // 1������ ������ 1�� ��ȯ
		else
			return getSum(n - 1) + n; // n���� ������ (n - 1)���� �� + n�� ��ȯ
	}

	// getFactorial(int n): n ���丮���� ���Ͽ� ��ȯ�ϴ� �޼ҵ�
	static int getFactorial(int n) {
		if (n == 0)                          // n�� Ư�������� 0�̸�
			return  1;                       // 0!�� 1�� ��ȯ
		else
			return getFactorial(n - 1) * n;  // n!�� (n - 1)! * n ��ȯ
	}

	public static void main(String[] args) {
		int sum = getSum(5);
		int fact = getFactorial(4);

		System.out.println("\n  o 1���� 5������ �� = " + sum);
		System.out.println("\n  o 4! = " + fact);
	}
}

/*
 * [ ���α׷��� ���� �� ���� ]
 * 
 *   1)  getSum(int n) �޼ҵ�� getFactorial(int n) �޼ҵ带 ��� �޼ҵ�� �ۼ��Ѵ�.
 *      - main() �޼ҵ忡�� �̵��� ȣ���Ͽ� ����� ���
 *      - ��� �޼ҵ� ȣ��Ǹ� Ư�� ������ ������ ������ ���������� ��� �޼ҵ� ȣ��
 *      - Ư�� ���ǿ� �����ϸ� ȣ��� �޼ҵ尡 ���������� ��ȯ
 *     
 *   2) ���α׷��� �����Ͽ� ����� Ȯ���϶�. 
 */
