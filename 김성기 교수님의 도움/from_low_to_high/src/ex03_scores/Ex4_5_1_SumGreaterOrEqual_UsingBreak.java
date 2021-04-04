package ex03_scores;

/*
 *  [ SumGreaterOrEqual_UsingBreak ]: break 문을 이용하여 1부터의 합이 100000 이상인 정수 구하기   
 *            
 *    o while 문
 *      - while(반복조건)
	              반복_수행할_문장
	              
 *      - 반복조건이 true인 동안 반복_수행할_문장을 반복
 *	               
 */

class Ex4_5_1_SumGreaterOrEqual_UsingBreak {
	public static void main(String[] args)  {
		System.out.println("\n  ** 1부터의 합이 100000 이상인 정수 구하기 **\n");
		
		int n, sum = 0;
		for (n = 1; ; n++)	 {      // n이 1부터 증가하면서 무한히 반복하는 중에 
		    sum += n;           	//     sum에 1부터 n까지의 합을 누적하여
		    if (sum >= 100000)	 	//     sum이 100000보다 크거나 같으면
		       break;		        //        break 문을 이용하여 for 문을 벗어남	
		}

		System.out.println("  * 1부터의 합이 100000 이상인 첫 정수: " + n + ", 합: " + sum);
	}
}
