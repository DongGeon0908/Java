package ex10_3_java_util_package;

import java.util.Random;           // Vector 클래스를 사용하기 위해 import
import java.util.stream.IntStream; // IntStream 클래스를 사용하기 위해 import

/**
 * [ Random 클래스 ]: 
 *        java.util.Random 클래스 이용하여 여러 종류의 난수 생성하기
 *  
 *   o 난수(random number) 
 *     - 무작위로 추출되는 일련의 숫자들로서 통계, 게임, 보안 등에서 중요하게 사용
 *     - Java에서는 java.lang.Math 클래스의 random() 메소드 이용하여 0과 1 사이의 실수 난수들 추출 가능
 *     - 보다 다양하게 난수 추출하기 위해 java.util 패키지의 Random 클래스 제공
 *    
 *   o Random 클래스
 *     - 48 bit의 종자값(seed) 사용하여 의사난수(pseudorandom) 생성하는 여러 메소드 제공
 *     - Random 객체는 여러 종류의 난수 생성할 수 있는 난수 생성기로서의 역할 수행
 *     - int nextInt(int bound): 0에서 (bound - 1)까지의 정수 난수 반환
 *     - double nextDouble(): 0에서 1 미만의 실수 난수 반환  
 */

public class Ex10_3_1_Random {
	public static void main(String[] args) {

		// Random 객체 생성
		Random rd1 = new Random();          // 종자값 없이 Random 객체 생성
		Random rd2 = new Random(1234567);   // 종자값 1234567로 Random 객체 생성

		// 0과 100 사이 임의의 정수 점수 10개 구하여 출력
		int[] scores = new int[10];
		for (int i = 0; i < 10; i++) {
			int score = rd1.nextInt(101);  // 0과 100 사이 난수 생성하여 score에 저장
			scores[i] = score;             // scores 배열 원소에 저장
		}	
		
		System.out.print("\n  * 난수로 구한 10개 점수: ");	  		   
		for (int score: scores)            // scores 배열에 저장된 원소들을 
			System.out.print(score + " "); //  하나씩 출력

		// 150과 190 사이 임의의 실수 키 8개 구하여 출력
		double[] heights = new double[8];
		for (int i = 0; i < 8; i++) {
			double height = 150 + rd2.nextDouble() * 40;    // 150과 190 사이 난수 생성 
			heights[i] = (int) (height * 100 + 5) / 100.0 ; // 소수 2자리 반올림하여 저장
		}
		
		System.out.print("\n\n  * 난수로 구한 8개 키: ");	     
		for (double height: heights)         // heights 배열에 저장된 원소들을
			System.out.print(height + " ");  //  하나씩 출력

		// Java 1.8부터 IntStream 클래스가 java.util.stream 패키지에 지원됨
		// Random 클래스의 ints() 메소드는 여러 난수를 구하여 IntStream으로 반환
		// ints() 메소드로 10과 19 사이 임의의 정수 나이 15개 구하여 출력
		IntStream strm = rd1.ints(15, 10, 20);   // 정수 난수 15개 생성하여 strm에 저장 
		
		System.out.print("\n\n  * 난수로 구한 15개 나이: ");	     
		for (int age: strm.toArray())            // strm을 배열로 변환하여 각 원소 age에 대해
			System.out.print(age + " ");         //  age 출력
	}
}

/*
 * [ 프로그램 이해 및 실행 ]
 * 
 *   1) 이 프로그램은 여러 종류의 난수를 생성하여 출력한다.
 *      
 *   2) 프로그램을 실행하여 출력 결과를 확인하라.           
 */
