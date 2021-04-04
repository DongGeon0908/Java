package ex10_2_java_lang_package;

import java.lang.Math; // �� import ������ �����ص� ��

/** [ Ex10_2_2_Math Ŭ���� ]: java.lang.Math Ŭ������ ���� Ŭ���� �޼ҵ� Ȱ���ϱ�
 * 
 *   o java.lang ��Ű���� Math Ŭ����
 *     - ���밪, �ø�, ����, �ݿø�, ���� �� �α�, ������, �ﰢ�Լ�, ���� ��� 
 *       �䱸�Ǵ� ������ �����ϱ� ���� ���� �޼ҵ带 �����ϴ� Ŭ����
 *     - Math Ŭ������ ��� �ʵ�� �޼ҵ�� Ŭ���� �ʵ�� Ŭ���� �޼ҵ���
 *     - Math Ŭ������ ��ü�� ������ �� ����
 */ 

public class Ex10_2_2_Math {
	public static void main(String[] args) {
		
		System.out.println("\n  ** java.lang.Math Ŭ������ Ŭ���� �ʵ�� �޼ҵ� **\n");
		
		// Math Ŭ������ ���ǵ� �ʵ�� E�� PI 2����
		double e = Math.E; // �ڿ� �α��� �ؼ��� e�� ���� 
		double pi = Math.PI; // �������� pi�� ���� 
		System.out.println("  * e = " + e);
		System.out.println("  * pi = " + pi);

		// abs(), sqrt(), cbrt(), pow(), exp() �޼ҵ带 ȣ���ϴ� ��
		System.out.println("\n  * ���밪: abs(-123) = " + Math.abs(-123) );   // -123�� ���밪
		System.out.println("  * ������: sqrt(50) = " + Math.sqrt(50) );       // 50�� ������
		System.out.println("  * ��������: cbrt(9) = " + Math.cbrt(9) );        // 9�� ��������
		System.out.println("  * 2�� 8��: pow(2, 8) = " + Math.pow(2, 8) );       // 2�� 8����(2**8)
		System.out.println("  * e�� 8��: exp(8) = " + Math.exp(8) );           // e�� 8����(e**8)

		// floor(), ceil(), rint(), min(), max() �޼ҵ带 ȣ���ϴ� ��
		System.out.println("\n  * ����: floor(1.99) = " + Math.floor(1.99) ); // 1.99�� ����
		System.out.println("  * �ø�: ceil(1.01) = " + Math.ceil(1.01) );     // 1.01�� �ø�
		System.out.println("  * �ݿø�: rint(1.49) = " + Math.rint(1.49) );    // 1.49�� �ݿø�
		System.out.println("  * �ּ�: min(1, 2) = " + Math.min(1, 2) );       // 1�� 2�� �ּҰ�
		System.out.println("  * �ִ�: max(1, 2) = " + Math.max(1, 2) );       // 1�� 2�� �ִ밪

		// random() �޼ҵ带 �̿��Ͽ� 0�� 100 ������ ���� 10�� ���Ͽ� ���
		int[] scores = new int[10];
		for (int i = 0; i < 10; i++) {
			int score = (int) (Math.random() * 101); // 0�� 100 ���� ���� �����Ͽ� 
			scores[i] = score;                       // scores �迭 ���ҿ� ����
		}

		System.out.print("\n  * ������ ���� 10�� ����: ");	  		     
		for (int score: scores)             // scores �迭�� ����� ���ҵ���
			System.out.print(score + " ");  //  �ϳ��� ���

		// �ﰢ�Լ��� ���õ� �޼ҵ� ����ϱ�
		double angle = SkScanner.getDouble(" \n\n  o ���� �Է� > ");  // ���� �Է�
		double radian = angle * (Math.PI / 180);                 // ������ �������� �����ϱ�
		System.out.println("  * sin("+angle+"��) = sin("+radian+"����) = "+Math.sin(radian) );
		System.out.println("  * cos("+angle+"��) = cos("+radian+"����) = "+Math.cos(radian) );  
		System.out.println("  * tan("+angle+"��) = tan("+radian+"����) = "+Math.tan(radian) ); 
	}
}

/*
 * [ ���α׷� ���� �� ���� ]
 * 
 *   1) �� ���α׷��� Math Ŭ������ ���� Ŭ���� �޼ҵ带 ȣ���Ͽ� �ʿ��� ������ �����Ѵ�.
 *   
 *   2) ���α׷��� �����Ͽ� ��� ����� Ȯ���϶�.   
 */
