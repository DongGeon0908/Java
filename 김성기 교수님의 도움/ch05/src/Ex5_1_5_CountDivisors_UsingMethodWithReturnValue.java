/**
 * [ CountDivisors_UsingMethodWithReturnValue ]
 *         100�� ��� ����, 1237�� �Ҽ� ���� ���(�Ű����� �� ��ȯ�� ���� �޼ҵ� ���)   
 *            
 *   o ���α׷��� ��Ÿ�� 
 *     - �־��� �Ű������� ���� ��� ������ �Ҽ� ���� ����ϴ� �Ű����� ���� ���� �޼ҵ� �ۼ�
 *     - �־��� �Ű������� ���� ��� ������ ���Ͽ� ��ȯ�ϴ� ��ȯ�� ���� �޼ҵ� �ۼ�
 *     - main() �޼ҵ忡��  ���� �޼ҵ� ȣ��    
 *       
 *   o ���(divisor)�� �Ҽ�(prime number)
 *     - ���: ���� ���� n�� ����� 1�� n ������ ���� �� n�� ������ ���� ������ ��
 *     - 6�� ���: 1, 2, 3, 6
 *     - 12�� ���: 1, 2, 3, 4, 6, 12   
 *     - ����� 2���� ����: 2, 3, 5, 7, 11, 13, 17, ...       
 *     - �Ҽ�: ����� ������ 2���� ���� ����      
 *    
 *   o �ۼ��� ���� �޼ҵ�
 *     - printCountDivisorsOf(int n): n�� ��� ���� ����ϴ� �޼ҵ�
 *     - printWhetherPrimeNo(int n): n�� �Ҽ� ���� ����ϴ� �޼ҵ�
 *      
 *   o �ۼ��� ��ȯ�� ���� �޼ҵ�
 *     - int getCountDivisors(int n): n�� ��� ������ ���Ͽ� ��ȯ�ϴ� �޼ҵ�
 */

class Ex5_1_5_CountDivisors_UsingMethodWithReturnValue {

	public static void main(String[] args) {
		printCountDivisorsOf( 100 );           
		printWhetherPrimeNo( 1237 );     
	}

	// �Ű������� �־����� n�� ��� ���� ����ϴ� �޼ҵ�
	static  void  printCountDivisorsOf(int n) {
		int cntDivisors =  getCountDivisors( n ); // n�� ��� ���� ���� ��ȯ�ϴ� �޼ҵ� ȣ��	
		
		System.out.println("\n  * " + n + "�� ��� ����: "+ cntDivisors); 
	}

	// �Ű������� �־����� n�� �Ҽ� ���� ����ϴ� �޼ҵ�
	static void printWhetherPrimeNo(int n) {
		int cntDivisors =  getCountDivisors( n ); // n�� ��� ���� ���� ��ȯ�ϴ� �޼ҵ� ȣ��		
		
		if (cntDivisors == 2) 
			System.out.println("\n  * " + n  + ": �Ҽ���" ); 
		else 
			System.out.println(" \n  * " + n + ": �Ҽ� �ƴ�" );           
	}

	// �Ű������� �־����� n�� ��� ������ ���Ͽ� ��ȯ�ϴ� �޼ҵ�
	static int getCountDivisors(int n)  {
		int cntDivisors = 0;  
		
		for (int i = 1; i <= n; i++)  
			if (n % i == 0) 	 
				cntDivisors++;  
		
		return cntDivisors;  // ���� ��� ���� ��ȯ
	}
}

/*
 * [ ���α׷��� ���� �� ���� ]
 *   
 *   1) �� ���α׷��� ������ �ߺ��Ǿ��� ��� ���� ���ϴ� �ڵ带 ��ȯ�� ���� �޼ҵ�� �ۼ��� �� 
 *      ��� ������ �ʿ��ϸ� ȣ���Ѵ�.
 *      
 *      - �̷� ���Ͽ� ��ȯ�� ���� �޼ҵ� ȣ����  ������ �� �κ����� ��� �����ϹǷ� Ȱ�뼺�� ������
 *   
 *   2) �Ű������� �����鼭 ��ȯ���� ���� ���� �޼ҵ带 ��������� �ۼ��ϴ� �ɷ��� 
 *      Java ���α׷��ӿ��� ���� �䱸�Ǵ� �ɷ� ���� �ϳ��̹Ƿ�  �޼ҵ���� 
 *      ������� �ۼ��� �� �ִ� ������ �Ǿ�� �Ѵ�.
 *         
 *   3) �Ű������� ���� ���� �޼ҵ�� ��ȯ�� ���� �޼ҵ��� �������� �������°�?
 */
