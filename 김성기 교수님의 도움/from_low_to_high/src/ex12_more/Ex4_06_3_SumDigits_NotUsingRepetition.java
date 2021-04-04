package ex12_more;
/*
 *  [ SumDigits_NotUsingRepetition ]: 양의 정수를 입력하여 그 정수의 각 자리수의 합을 구하기
 *   
 *      o 스타일 2: 반복문 사용하지 않기
 *                + 각 자릿수를 구하여 합함
 *                + 입력된 수의 10의 나머지를 구하고 10으로 나눈 몫에 대해 반복함
 *                
 *      o 각 자리수의 합 구하기
 *        - 12345인 경우 자리수는 1의 자리 1, 10의 자리 2, 백의 자리 3이므로 자리수 합은 1+2+3 = 6임
 *        - 입력된 정수를 10으로 나눈 나머지가 1 자리의 자리수임
 *        - 이를 이용하여 10으로 나눈 나머지를 구하여 1 자리의 자리수를 확인하고, 
 *        - 그 정수를 10으로 나눈 몫을 구하여 그 몫에 대해 똑같은 작업을 하면
 *          바로 다음 왼쪽 자리의 자리수를 확인할 수 있음
 *        - int 타입의 양의 정수의 최대 자리수는 10자리이므로 10번 반복하면 됨  
 */

class Ex4_63_SumDigits_NotUsingRepetition  {

	public static void main(String[] args)  {
		int n0, n;     // 입력한 값을 저장할 변수
		int sum = 0;   // 각 자리수의 합을 저장할 변수
		int digit;     // 특정 자리수의 디지트를 저장할 변수
		
		System.out.println("\n\n  **** Getting sum of digits of an integer (not using repetition  statement) ****");

		n0 = n = SkScanner.getIntWithPrompt("\n  o Enter a positive number > ");

		digit= n % 10; 	// 1의 자리의 자리수를 구함
		System.out.println("  << 개발과정에서의 확인>> [1] sum = " + sum + ", n = " + n + ", digit = " + digit  + ", next n = " + n / 10);	
		sum += digit;  			// n을 10으로 나눈 나머지를 sum에 누적시킴
		n = n / 10;       		// n을 10으로 나눈 정수 몫으로 저장

		digit= n % 10; 	// 10의 자리의 자리수를 구함
		System.out.println("  << 개발과정에서의 확인>> [2] sum = " + sum + ", n = " + n + ", digit = " + digit  + ", next n = " + n / 10);	
		sum += digit;  			// n을 10으로 나눈 나머지를 sum에 누적시킴
		n = n / 10;       		// n을 10으로 나눈 정수 몫으로 저장
	
		digit= n % 10; 	// 100의 자리의 자리수를 구함
		System.out.println("  << 개발과정에서의 확인>> [3] sum = " + sum + ", n = " + n + ", digit = " + digit  + ", next n = " + n / 10);	
		sum += digit;  			// n을 10으로 나눈 나머지를 sum에 누적시킴
		n = n / 10;       		// n을 10으로 나눈 정수 몫으로 저장
		
		digit= n % 10; 	// 1000의 자리의 자리수를 구함
		System.out.println("  << 개발과정에서의 확인>> [4] sum = " + sum + ", n = " + n + ", digit = " + digit  + ", next n = " + n / 10);	
		sum += digit;  			// n을 10으로 나눈 나머지를 sum에 누적시킴
		n = n / 10;       		// n을 10으로 나눈 정수 몫으로 저장

		digit= n % 10; 	// 10000의 자리의 자리수를 구함
		System.out.println("  << 개발과정에서의 확인>> [5] sum = " + sum + ", n = " + n + ", digit = " + digit  + ", next n = " + n / 10);	
		sum += digit;  			// n을 10으로 나눈 나머지를 sum에 누적시킴
		n = n / 10;       		// n을 10으로 나눈 정수 몫으로 저장

		digit= n % 10; 	// 10만의 자리의 자리수를 구함
		System.out.println("  << 개발과정에서의 확인>> [6] sum = " + sum + ", n = " + n + ", digit = " + digit  + ", next n = " + n / 10);	
		sum += digit;  			// n을 10으로 나눈 나머지를 sum에 누적시킴
		n = n / 10;       		// n을 10으로 나눈 정수 몫으로 저장

		digit= n % 10; 	// 100만의 자리의 자리수를 구함
		System.out.println("  << 개발과정에서의 확인>> [7] sum = " + sum + ", n = " + n + ", digit = " + digit  + ", next n = " + n / 10);	
		sum += digit;  			// n을 10으로 나눈 나머지를 sum에 누적시킴
		n = n / 10;       		// n을 10으로 나눈 정수 몫으로 저장

		digit= n % 10; 	// 1000만의 자리의 자리수를 구함
		System.out.println("  << 개발과정에서의 확인>> [8] sum = " + sum + ", n = " + n + ", digit = " + digit  + ", next n = " + n / 10);	
		sum += digit;  			// n을 10으로 나눈 나머지를 sum에 누적시킴
		n = n / 10;       		// n을 10으로 나눈 정수 몫으로 저장

		digit= n % 10; 	// 1억의 자리의 자리수를 구함
		System.out.println("  << 개발과정에서의 확인>> [9] sum = " + sum + ", n = " + n + ", digit = " + digit  + ", next n = " + n / 10);	
		sum += digit;  			// n을 10으로 나눈 나머지를 sum에 누적시킴
		n = n / 10;       		// n을 10으로 나눈 정수 몫으로 저장

		digit= n % 10; 	// 10억의 자리의 자리수를 구함
		System.out.println("  << 개발과정에서의 확인>> [10] sum = " + sum + ", n = " + n + ", digit = " + digit  + ", next n = " + n / 10);	
		sum += digit;  			// n을 10으로 나눈 나머지를 sum에 누적시킴
		n = n / 10;       		// n을 10으로 나눈 정수 몫으로 저장

		System.out.println("\n  * sum of digits of " + n0 + " is " + sum);

		main(args);   // 이는 가장 쉽게 전체를 반복시키는 방법임
	}
}


/*
 * [ 스스로 생각하고 고민해볼 과제 ]
 * 
 *   o 이 방법은 입력 정수에 대해 10의 나머지를 구하고 다시 10으로 나눈 몫에 대해 
 *     동일한 작업을 10번 수행하므로 방법만 이해하면 프로그램 작성은 아주 쉽다. 
 *     그러나 프로그램의 길이가 매우 길다.
 *        
 *   o 똑같은 내용이 반복되거나 유사한 내용이 반복될 경우 반복문으로 작성해야 한다. 
 *     for 문으로 변경한 프로그램을 스스로 작성해보라.
 *     
 *     아주 간결한 프로그램인 Ex4_6_1_BitCount_UsingFor과 결과를 비교해보라. 
 *     또한 더 좋은 프로그램이 Ex4_6_2_BitCount_Usingwhile이다.
 *      
 */