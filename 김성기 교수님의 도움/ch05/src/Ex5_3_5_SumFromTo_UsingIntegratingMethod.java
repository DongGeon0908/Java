/**
 * [ SumFromTo_UsingIntegratingMethod] : 여러 구간의 정수 합 출력
 * 
 *   o 프로그래밍 스타일 
 *     - 대체 메소드를 통합하여 매개변수 갖는 통합 메소드 작성
 *     - 작성한 통합 메소드를 main()에서 호출하여 여러 구간의 정수 합 출력
 *       
 *   o 작성한  메소드
 *     - printSum_FromTo(int from, int to): from에서 to까지의 정수 합 구해 출력
 */

class Ex5_3_5_SumFromTo_UsingIntegratingMethod  {
	public static void main(String[] args) {
		printSum_FromTo(1, 100);
		printSum_FromTo(1, 100000);
		
        int i = 1, j = 1;
        while ( i <= 100 ) {
             printSum_FromTo(i, j);
             
             i = i + (int) (Math.random() * 10);  // i에 0과 9 사이의 임의 정수를 더함 
             j = i + (int) (Math.random() * 100); // j에 0과 99 사이의 임의 정수를 더함 
        }
	}

	// 매개변수로 주어지는 from부터 to까지의 합 구하여 출력하는 통합 메소드, 
	//   printSum1To100(), printSum101To200(), printSum100To2000() 등  
	//   수많은 대체 메소드를 통합한 메소드임 
	static void printSum_FromTo(int from, int  to) {
		int sum = 0;

		for (int i = from; i <= to; i++)
			sum = sum + i;

		System.out.println("\n  * " + from + "부터 " + to + "까지의 합 = " + sum);
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *   
 *   1) main() 메소드에서 사용된 Math.random() 메소드는 0과 1 사이의 임의의 난수를 구해 반환하는 
 *      라이브러리 메소드이다.
 *     
 *      - 값을 하나 구해주는 점에서 값을 입력해주는 SkScanner.getDouble() 메소드와 유사한 면이 있다. 
 *     
 *   2) Java에서는 이러한 라이브러리 메소드가 많이 제공되므로 이들을 잘 활용하면 
 *      프로그래밍이 한층 쉬워진다.
 *   
 *   
 * [ 실습과제 ]
 * 
 *   1) 1억부터 2억까지의 합을 구해 출력하는 코드를 추가로 작성하라.
 *   
 *   2) 100000000(1억)부터 200000000(2억)까지의 합을 구하여 출력하는 결과가 제대로 출력되었는가?
 *      
 *      구한 결과를 확인하고 문제점이 무엇인가를 파악하라. 
 *      그리고 문제를 해결하기 위한 방법을  고안하여 프로그램을 수정하라.
 */
