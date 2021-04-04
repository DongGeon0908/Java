package exercise05;

/**
 * [ 5장 연습문제  2 ]:
 *   
 *   9. 다음에서 잘못된 부분을 지적하고 그 원인을 설명하고 올바르게 수정하라
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