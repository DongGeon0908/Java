package ex6_4_3_static_init_block;

/**
 * [ FibonacciNumber Ŭ���� ]: ����ƽ �ʱ�ȭ ����� �����ִ� ����
 * 
 *   o �Ǻ���ġ ��(Fibonacci number): ���� ���� �� �� ���� ������ �̷������ ����
 *      0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, ...
 *       
 *   o ����ƽ �ʱ�ȭ ���
 *     - Ŭ���� �ʵ带 �ܼ��� ���� �ʱ�ȭ�θ����� �ʱ�ȭ�� �� ���� �� �ۼ�
 *     - Ű���� static ������ ��� ���� ����� �۾��� ���      
 *    
 *     - static �ʱ�ȭ ����� Ŭ������ ó�� ���Ǿ� �ε�� �� ����
 */

class FibonacciNumber {
	// 93�� long Ÿ������ ���� �� �ִ� �Ǻ���ġ ���� �ִ� ���� 
	static final int NOFIBONACCIS = 93; 

	// �̸� ���� �Ǻ���ġ ���� �����ϴ� �迭
	static long[] fibonaccis = new long[NOFIBONACCIS]; 

	// �Ǻ���ġ ���� �̸� ���Ͽ� fibonaccis[] �迭�� �����ϴ� ����ƽ �ʱ�ȭ ���
	static { // ����ƽ �ʱ�ȭ ����� ����
		fibonaccis[0] = 0;  // 0��° �Ǻ���ġ ��
		fibonaccis[1] = 1;  // 1��° �Ǻ���ġ ��
		
		// 2��°���� NOFIBONACCIS-1 ��°������ �Ǻ���ġ ���� ���Ͽ� �迭�� ����
		for (int i = 2; i < NOFIBONACCIS; i++) { 
			fibonaccis[i] = fibonaccis[i - 2] + fibonaccis[i - 1];
		}
	} // ����ƽ �ʱ�ȭ ����� ��

	// n ��° �Ǻ���ġ ���� ��ȯ: �迭�� ���س��� ���� ��ȯ��
	public static long getFibonacci(int n) {
		if (n >= 0 && n < NOFIBONACCIS) // 0���� NOFIBONACCIS-1��°�� ��� 
			return fibonaccis[n];       //     �迭���� ��ȯ
		else
			return -1; // ������° �Ǵ� long ������ ����� ��°�̸� -1�� ��ȯ
	}
}

class Ex6_4_4_FiboApp {	
	public static void main(String[] args) {
		System.out.println("\n\n");

		for (int i=-9; i <= 100; i++) {
			System.out.print(" [" + i + "]:" + FibonacciNumber.getFibonacci(i));
			if (i % 5 == 0)
				System.out.println();
		}
	}
}

/*
 * [ ���α׷� ���� �� ���� ]
 * 
 *   1) �� ���α׷��� �̸� ���� �Ǻ���ġ ���� �����ϴ� �迭 fibonaccis�� �ǳ볪ġ �������� static �ʱ�ȭ�� �̿��Ͽ� �����Ѵ�.
 *           
 *   2) long getFibonacci(int n) �޼ҵ�� �迭���� �ʵ� fibonaccis�� ����� n��° �Ǻ���ġ ������ ��ȯ�Ѵ�.
 *   
 *   3) main()���� -9��°���� 100��°���� �Ǻ���ġ ������ ����Ѵ�.
 *   
 *      ���� ��°�� 94��° ���Ĵ� ���� ������� ���ϹǷ� -1�� ����Ѵ�. 
 */
