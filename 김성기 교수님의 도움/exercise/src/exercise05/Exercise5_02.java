package exercise05;

/**
 * [ 5�� ��������  2 ]:
 *   
 *   9. �������� �߸��� �κ��� �����ϰ� �� ������ �����ϰ� �ùٸ��� �����϶�
 */

class Pr5-1 {
	public static int main(string[] args) {    
		double[10] heights;  
		int sum;
		for (i = 1; i <= 10; i++)
			sum = sum + heights[i];
		System.out.println(" * sum = ", sum);
		printNextPrimeNo(12345);
	}  

	static void printNextPrimeNo(int n) {
		while(1) {
			++n;
			if (isPrimeNo(n) == true)
				continue; 
		}  
		System.out.println(' * next prime no = ' + no);
	}
}