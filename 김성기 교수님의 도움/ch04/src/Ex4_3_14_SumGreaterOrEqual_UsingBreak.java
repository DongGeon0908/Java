/**
 * [ SumGreaterOrEqual_UsingBreak ]: break 문을 이용하여 1부터의 합이 100000 이상인 정수 구하기   
 *            
 *   o for 문
 *     - 반복 제어변수 이용하여 반복 회수 제어함
 *     - 반복 제어변수는 for 문 외부 또는 내부에서 선언 가능
 *      
 *     - 반복 수행할 문장이 2개 이상인 경우에는 반드시 여러 문장을 블록으로 만들어야 함
 *     - 반복조건이 true인 동안 블록 내의 여러 문장들을 반복 수행함
 *      
 *   o break 문  
 *     - 반복문 내에서  반복 벗어나게 함               
 */

class Ex4_3_14_SumGreaterOrEqual_UsingBreak {
	public static void main(String[] args)  {
		System.out.println("\n  ** 1부터의 합이 100000 이상인 정수 구하기 **\n");
		
		int n, sum = 0;
		
		for (n = 1; ; n++)	 {      // n이 1부터 증가하며 무한히 반복하는 중에 
		    sum += n;           	//   sum에 1부터 n까지의 합을 누적하여
		    if (sum >= 100000)	 	//   sum이 100000보다 크거나 같으면
		       break;		        //     break 문을 이용하여 for 문을 벗어남	
		}

		System.out.println("  * 1부터의 합이 100000 이상인 첫 정수: " + n + ", 합: " + sum);
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *   
 *   1) break 문의 예를 보인다.
 *     - sum이 100000보다 크거나 같으면 break 문을 사용하여 for 문을 벗어난다.
 *        
 *   2) 프로그램의 실행과정을 정확히 이해하라.    
 */
