/**
 * [ SumFrom1To100_NotUsingMethod }: 
 *       메소드 사용하지 않고서 1부터 100까지 정수의 합 구하여 출력하기
 * 
 *   o 프로그래밍 스타일 
 *     - 메소드를 작성하지 않고서 main() 메소드에서 합 구하여 출력함
 */

class Ex5_2_1_SumFrom1To100_NotUsingMethod  {
	public static void main(String[] args) {

		int sum = 0;

		for (int i = 1; i <= 100; i++)
			sum = sum + i;

		System.out.println("\n  * 1부터 100까지의 합 = " + sum);

		// 실습과제: 여기에서 실습과제 1) 101부터 200까지의 합을 구하여 출력하는 문장들을 작성하라

		// 실습과제: 여기에서 실습과제 2) 100000000부터 200000000까지의 합을 구하여 출력하는 문장들을 작성하라
	}

}

/*
 * [ 프로그램의 이해 및 실행 ]
 *   
 *   1) 이 프로그램은 메소드 사용하지 않고서 1부터 100까지 정수의 합 구하여 출력한다.
 *   
 *   2) 프로그램을 잘 살펴보고 실행하여 결과를 확인하라.
 *   
 *  
 * [ 실습과제 ]
 * 
 *   1) 101부터 200까지의 합을 구하여 출력하는 문장들을 추가로 작성하라.
 *   
 *   2) 100000000(1억)부터 200000000(2억)까지의 합을 구하여 출력하는 문장들을 추가로 작성하라.
 *      구한 결과를 확인하고 문제점이 무엇인가를 파악하라. 
 *      
 *      그리고 문제를 해결하기 위한 방법을 고안하여 프로그램을 수정하라.
 */
