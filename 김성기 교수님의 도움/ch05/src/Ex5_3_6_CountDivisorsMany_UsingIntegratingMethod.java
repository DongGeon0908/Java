/**
 * [ CountDivisors_UsingMethodWithReturnValue ]: 
 *       주어진 구간의 정수들 약수 개수 출력하기(통합 메소드 사용)   
 *            
 *   o 프로그래밍 스타일 
 *     - 주어진 구간의 정수들 약수 개수 출력하는 통합 메소드와
 *       주어진 정수의 약수 개수 구하여 반환하는 메소드 작성    
 *     - main() 메소드에서 통합된 메소드 호출    
 *     
 *   o 약수
 *     - 양의 정수 n의 약수는 1과 n 사이의 정수 중 n을 나머지 없이 나누는 수
 *     - 6의 약수: 1, 2, 3, 6
 *     - 12의 약수: 1, 2, 3, 4, 6, 12   
 *     - 약수가 2개인 정수: 2, 3, 5, 7, 11, 13, 17, ...      
 *    
 *   o 작성된 메소드
 *     - printCountDivisors_FromTo(): 주어진 구간의 정수들에 대한 약수 개수 구하여 출력
 *     - getCountDivisors(): 주어진 정수의 약수 개수 구하여 반환
 *      
 *   o main() 메소드에서 printCountDivisors_FromTo()를 2번 호출   
 */

class Ex5_3_6_CountDivisorsMany_UsingIntegratingMethod {
	public static void main(String[] args) {
		printCountDivisors_FromTo(1, 100); 
		printCountDivisors_FromTo(10000, 10100);  		
	} 

	// 통합 메소드 작성: 매개변수를 갖는 메소드로 작성함 
	// printCountDivisors_FromTo(): 주어진 구간의 정수들의 약수 개수 출력하는 메소드
	static void printCountDivisors_FromTo(int from, int to){ 	
        System.out.println("\n\n ** " + from + "부터 " + to + "까지 정수 약수 개수 출력하기 **\n ");           

        for (int n = from; n <= to; n++) {           // n이 from부터 to까지 반복하면서 
           int cntDivisors = getCountDivisors(n);    // 메소드 호출하여 약수 개수 구함             
           System.out.println(" * " + n + "의 약수 개수: " + cntDivisors); 
        }
    }
	
	// 반환값 갖는 메소드 작성: 호출한 메소드로 결과값을 전달하는 메소드로 작성함 
	// getCountDivisors(): 주어진 정수의 약수 개수 구하여 반환함
    static int getCountDivisors(int n) { 
        int cntDivisors = 0;   // n의 약수 개수를 0으로 초기화
        
        for (int i = 1; i <= n; i++)    // 내부 for 문: i가 1부터 n까지 반복
            if (n % i == 0) 	        //    n을 i로 나누어 나머지가 0이면 
                cntDivisors++;          //       i는 n의 약수이므로 약수 개수 1 증가	
        
        return cntDivisors;             // 구한 약수 개수를 반환
    }
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *    
 *   1) 임의 구간의 약수 개수 출력하는 부분을 메소드로 작성하고 이를 main()에서 호출한다.
 *   
 *   2) 약수 개수를 구하여 반환하는 메소드인 int getCountDivisors(int n)를 작성하고
 *      printCountDivisors_FromTo()에서 호출한다.
 *      
 *        
 * [ 실습과제 ]
 * 
 *   1) from에서 to 사이에서 약수 개수가 4인 정수를 모두 출력하는 메소드
 *      static void printIfCountDivisorsEq4_FromTo(int from, int to)를
 *      작성하라.
 *      
 *   2) main()에서 1부터 1000사이에서 약수 개수가 4인 정수를 모두 출력하기 위해  
 *      1)에서 작성한  메소드를 호출하는 코드를  추가 작성하라.     
 */