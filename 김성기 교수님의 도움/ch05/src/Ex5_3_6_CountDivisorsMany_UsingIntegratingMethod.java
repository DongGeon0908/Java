/**
 * [ CountDivisors_UsingMethodWithReturnValue ]: 
 *       �־��� ������ ������ ��� ���� ����ϱ�(���� �޼ҵ� ���)   
 *            
 *   o ���α׷��� ��Ÿ�� 
 *     - �־��� ������ ������ ��� ���� ����ϴ� ���� �޼ҵ��
 *       �־��� ������ ��� ���� ���Ͽ� ��ȯ�ϴ� �޼ҵ� �ۼ�    
 *     - main() �޼ҵ忡�� ���յ� �޼ҵ� ȣ��    
 *     
 *   o ���
 *     - ���� ���� n�� ����� 1�� n ������ ���� �� n�� ������ ���� ������ ��
 *     - 6�� ���: 1, 2, 3, 6
 *     - 12�� ���: 1, 2, 3, 4, 6, 12   
 *     - ����� 2���� ����: 2, 3, 5, 7, 11, 13, 17, ...      
 *    
 *   o �ۼ��� �޼ҵ�
 *     - printCountDivisors_FromTo(): �־��� ������ �����鿡 ���� ��� ���� ���Ͽ� ���
 *     - getCountDivisors(): �־��� ������ ��� ���� ���Ͽ� ��ȯ
 *      
 *   o main() �޼ҵ忡�� printCountDivisors_FromTo()�� 2�� ȣ��   
 */

class Ex5_3_6_CountDivisorsMany_UsingIntegratingMethod {
	public static void main(String[] args) {
		printCountDivisors_FromTo(1, 100); 
		printCountDivisors_FromTo(10000, 10100);  		
	} 

	// ���� �޼ҵ� �ۼ�: �Ű������� ���� �޼ҵ�� �ۼ��� 
	// printCountDivisors_FromTo(): �־��� ������ �������� ��� ���� ����ϴ� �޼ҵ�
	static void printCountDivisors_FromTo(int from, int to){ 	
        System.out.println("\n\n ** " + from + "���� " + to + "���� ���� ��� ���� ����ϱ� **\n ");           

        for (int n = from; n <= to; n++) {           // n�� from���� to���� �ݺ��ϸ鼭 
           int cntDivisors = getCountDivisors(n);    // �޼ҵ� ȣ���Ͽ� ��� ���� ����             
           System.out.println(" * " + n + "�� ��� ����: " + cntDivisors); 
        }
    }
	
	// ��ȯ�� ���� �޼ҵ� �ۼ�: ȣ���� �޼ҵ�� ������� �����ϴ� �޼ҵ�� �ۼ��� 
	// getCountDivisors(): �־��� ������ ��� ���� ���Ͽ� ��ȯ��
    static int getCountDivisors(int n) { 
        int cntDivisors = 0;   // n�� ��� ������ 0���� �ʱ�ȭ
        
        for (int i = 1; i <= n; i++)    // ���� for ��: i�� 1���� n���� �ݺ�
            if (n % i == 0) 	        //    n�� i�� ������ �������� 0�̸� 
                cntDivisors++;          //       i�� n�� ����̹Ƿ� ��� ���� 1 ����	
        
        return cntDivisors;             // ���� ��� ������ ��ȯ
    }
}

/*
 * [ ���α׷��� ���� �� ���� ]
 *    
 *   1) ���� ������ ��� ���� ����ϴ� �κ��� �޼ҵ�� �ۼ��ϰ� �̸� main()���� ȣ���Ѵ�.
 *   
 *   2) ��� ������ ���Ͽ� ��ȯ�ϴ� �޼ҵ��� int getCountDivisors(int n)�� �ۼ��ϰ�
 *      printCountDivisors_FromTo()���� ȣ���Ѵ�.
 *      
 *        
 * [ �ǽ����� ]
 * 
 *   1) from���� to ���̿��� ��� ������ 4�� ������ ��� ����ϴ� �޼ҵ�
 *      static void printIfCountDivisorsEq4_FromTo(int from, int to)��
 *      �ۼ��϶�.
 *      
 *   2) main()���� 1���� 1000���̿��� ��� ������ 4�� ������ ��� ����ϱ� ����  
 *      1)���� �ۼ���  �޼ҵ带 ȣ���ϴ� �ڵ带  �߰� �ۼ��϶�.     
 */