package ex10_2_java_lang_package;

import java.lang.Math; // 이 import 문장은 생략해도 됨

/** [ Ex10_2_2_Math 클래스 ]: java.lang.Math 클래스의 여러 클래스 메소드 활용하기
 * 
 *   o java.lang 패키지의 Math 클래스
 *     - 절대값, 올림, 버림, 반올림, 지수 및 로그, 제곱근, 삼각함수, 난수 등에서 
 *       요구되는 연산을 수행하기 위한 여러 메소드를 포함하는 클래스
 *     - Math 클래스의 모든 필드와 메소드는 클래스 필드와 클래스 메소드임
 *     - Math 클래스의 객체를 생성할 수 없음
 */ 

public class Ex10_2_2_Math {
	public static void main(String[] args) {
		
		System.out.println("\n  ** java.lang.Math 클래스의 클래스 필드와 메소드 **\n");
		
		// Math 클래스에 정의된 필드는 E와 PI 2개임
		double e = Math.E; // 자연 로그의 밑수를 e에 저장 
		double pi = Math.PI; // 원주율을 pi에 저장 
		System.out.println("  * e = " + e);
		System.out.println("  * pi = " + pi);

		// abs(), sqrt(), cbrt(), pow(), exp() 메소드를 호출하는 예
		System.out.println("\n  * 절대값: abs(-123) = " + Math.abs(-123) );   // -123의 절대값
		System.out.println("  * 제곱근: sqrt(50) = " + Math.sqrt(50) );       // 50의 제곱근
		System.out.println("  * 세제곱근: cbrt(9) = " + Math.cbrt(9) );        // 9의 세제곱근
		System.out.println("  * 2의 8승: pow(2, 8) = " + Math.pow(2, 8) );       // 2의 8제곱(2**8)
		System.out.println("  * e의 8승: exp(8) = " + Math.exp(8) );           // e의 8제곱(e**8)

		// floor(), ceil(), rint(), min(), max() 메소드를 호출하는 예
		System.out.println("\n  * 내림: floor(1.99) = " + Math.floor(1.99) ); // 1.99의 내림
		System.out.println("  * 올림: ceil(1.01) = " + Math.ceil(1.01) );     // 1.01의 올림
		System.out.println("  * 반올림: rint(1.49) = " + Math.rint(1.49) );    // 1.49의 반올림
		System.out.println("  * 최소: min(1, 2) = " + Math.min(1, 2) );       // 1과 2의 최소값
		System.out.println("  * 최대: max(1, 2) = " + Math.max(1, 2) );       // 1과 2의 최대값

		// random() 메소드를 이용하여 0과 100 사이의 점수 10개 구하여 출력
		int[] scores = new int[10];
		for (int i = 0; i < 10; i++) {
			int score = (int) (Math.random() * 101); // 0과 100 사이 난수 생성하여 
			scores[i] = score;                       // scores 배열 원소에 저장
		}

		System.out.print("\n  * 난수로 구한 10개 점수: ");	  		     
		for (int score: scores)             // scores 배열에 저장된 원소들을
			System.out.print(score + " ");  //  하나씩 출력

		// 삼각함수와 관련된 메소드 사용하기
		double angle = SkScanner.getDouble(" \n\n  o 각도 입력 > ");  // 각도 입력
		double radian = angle * (Math.PI / 180);                 // 각도를 라디안으로 변경하기
		System.out.println("  * sin("+angle+"°) = sin("+radian+"라디안) = "+Math.sin(radian) );
		System.out.println("  * cos("+angle+"°) = cos("+radian+"라디안) = "+Math.cos(radian) );  
		System.out.println("  * tan("+angle+"°) = tan("+radian+"라디안) = "+Math.tan(radian) ); 
	}
}

/*
 * [ 프로그램 이해 및 실행 ]
 * 
 *   1) 이 프로그램은 Math 클래스의 여러 클래스 메소드를 호출하여 필요한 연산을 수행한다.
 *   
 *   2) 프로그램을 실행하여 출력 결과를 확인하라.   
 */
