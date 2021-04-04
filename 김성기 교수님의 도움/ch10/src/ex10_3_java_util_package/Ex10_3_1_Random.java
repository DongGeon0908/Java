package ex10_3_java_util_package;

import java.util.Random;           // Vector Ŭ������ ����ϱ� ���� import
import java.util.stream.IntStream; // IntStream Ŭ������ ����ϱ� ���� import

/**
 * [ Random Ŭ���� ]: 
 *        java.util.Random Ŭ���� �̿��Ͽ� ���� ������ ���� �����ϱ�
 *  
 *   o ����(random number) 
 *     - �������� ����Ǵ� �Ϸ��� ���ڵ�μ� ���, ����, ���� ��� �߿��ϰ� ���
 *     - Java������ java.lang.Math Ŭ������ random() �޼ҵ� �̿��Ͽ� 0�� 1 ������ �Ǽ� ������ ���� ����
 *     - ���� �پ��ϰ� ���� �����ϱ� ���� java.util ��Ű���� Random Ŭ���� ����
 *    
 *   o Random Ŭ����
 *     - 48 bit�� ���ڰ�(seed) ����Ͽ� �ǻ糭��(pseudorandom) �����ϴ� ���� �޼ҵ� ����
 *     - Random ��ü�� ���� ������ ���� ������ �� �ִ� ���� ������μ��� ���� ����
 *     - int nextInt(int bound): 0���� (bound - 1)������ ���� ���� ��ȯ
 *     - double nextDouble(): 0���� 1 �̸��� �Ǽ� ���� ��ȯ  
 */

public class Ex10_3_1_Random {
	public static void main(String[] args) {

		// Random ��ü ����
		Random rd1 = new Random();          // ���ڰ� ���� Random ��ü ����
		Random rd2 = new Random(1234567);   // ���ڰ� 1234567�� Random ��ü ����

		// 0�� 100 ���� ������ ���� ���� 10�� ���Ͽ� ���
		int[] scores = new int[10];
		for (int i = 0; i < 10; i++) {
			int score = rd1.nextInt(101);  // 0�� 100 ���� ���� �����Ͽ� score�� ����
			scores[i] = score;             // scores �迭 ���ҿ� ����
		}	
		
		System.out.print("\n  * ������ ���� 10�� ����: ");	  		   
		for (int score: scores)            // scores �迭�� ����� ���ҵ��� 
			System.out.print(score + " "); //  �ϳ��� ���

		// 150�� 190 ���� ������ �Ǽ� Ű 8�� ���Ͽ� ���
		double[] heights = new double[8];
		for (int i = 0; i < 8; i++) {
			double height = 150 + rd2.nextDouble() * 40;    // 150�� 190 ���� ���� ���� 
			heights[i] = (int) (height * 100 + 5) / 100.0 ; // �Ҽ� 2�ڸ� �ݿø��Ͽ� ����
		}
		
		System.out.print("\n\n  * ������ ���� 8�� Ű: ");	     
		for (double height: heights)         // heights �迭�� ����� ���ҵ���
			System.out.print(height + " ");  //  �ϳ��� ���

		// Java 1.8���� IntStream Ŭ������ java.util.stream ��Ű���� ������
		// Random Ŭ������ ints() �޼ҵ�� ���� ������ ���Ͽ� IntStream���� ��ȯ
		// ints() �޼ҵ�� 10�� 19 ���� ������ ���� ���� 15�� ���Ͽ� ���
		IntStream strm = rd1.ints(15, 10, 20);   // ���� ���� 15�� �����Ͽ� strm�� ���� 
		
		System.out.print("\n\n  * ������ ���� 15�� ����: ");	     
		for (int age: strm.toArray())            // strm�� �迭�� ��ȯ�Ͽ� �� ���� age�� ����
			System.out.print(age + " ");         //  age ���
	}
}

/*
 * [ ���α׷� ���� �� ���� ]
 * 
 *   1) �� ���α׷��� ���� ������ ������ �����Ͽ� ����Ѵ�.
 *      
 *   2) ���α׷��� �����Ͽ� ��� ����� Ȯ���϶�.           
 */
