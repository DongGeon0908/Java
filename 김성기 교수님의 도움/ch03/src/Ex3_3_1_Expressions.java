/**
 * [ Expressions ]: 여러 수식의 연습
 *        
 *   o 프로그래밍 스타일 
 *     1) main() 메소드로만 클래스 구성
 *     2) 작성된 여러 수식의 결과 확인
 *       
 *   o 수식은 여러 연산을 차례로 수행하여 하나의 결과 생성함
 *     1) 수식은 수식 구성 규칙에 맞게 작성되어야 함
 *     2) 수식은 연산자 우선순위와 결합성에 의해 수행될 순서 결정
 *     3) 자주 사용되는 수식의 패턴을 이해하고 이를 활용하는 능력 갖추어야 함   
 */

class Ex3_3_1_Expressions  {
	public static void main(String[] args)  {
		
		/*
		 * 합, 최대, 인원수, 평균 등과 관련된 수식
		 */
		int sumScores = 894,  maxScore = 99, noStudents = 10;
		double avgScores;
		System.out.println(  "\n ** 합, 최대, 인원수, 평균 등과 관련된 수식 **" ); 
		System.out.println(  avgScores = sumScores / (double) noStudents  );
		System.out.println(  avgScores + 10 > maxScore - 10  );

		/*
		 * 판매 현황, 이자 계산 등과 관련된 수식
		 */
		int totalPrice = 0, price = 9900, number = 15;
		int amount = 1000000;
		double rate = 0.04;

		System.out.println(  "\n ** 판매 현황, 이자 계산 등과 관련된 수식 **" ); 
		System.out.println(  totalPrice += price * number  );          // 판매금액 누적
		System.out.println(  amount = (int) (amount * (1 + rate))  );  // 원리합계 구하기

		/*
		 * 정수, 실수와 관련된 여러 수식들
		 */
		int n = 12345, nDividedBy10;
		double pi = 3.141592;    // 원주율

		System.out.println(  "\n ** 정수, 실수와 관련된 여러 수식들 **" ); 
		System.out.println(  n / 100 * 100  );                       // 100자리에서 내림 
		System.out.println(  (int) ((pi + 0.005) * 100) / 100.0  );  // 소수점 이하 2자리에서반올림 

		System.out.println(  n % 2 == 0 || n % 3 == 0 || n % 5 == 0  );
		System.out.println(  n % 10 + n / 10 % 10 + n / 100 % 10 + n / 1000 % 10 + n / 10000 % 10  );           // 6자리까지 각 자리수 합 구함
		System.out.println(  n % 10 + n % 100 / 10 + n % 1000 / 100 + n % 10000 / 1000 + n % 100000 / 10000  ); // 6자리까지 각 자리수 합 구함

		System.out.println(  n >> 1 + n << 1  );     // 연산자 우선순위가 잘못되어 잘못된 결과 산출함
		System.out.println(  (n >> 1) + (n << 1)  ); // 이는 n * 2 + n / 2와 동일함

		System.out.println(  n >= 10 && n <=19 || n >= 30 && n <= 39 || n >= 70 && n <= 79  );          // 값의 범위 검사
		System.out.println(  (nDividedBy10 = n / 10) == 1 || nDividedBy10 == 3 || nDividedBy10 == 7  ); // 값의 범위 검사

		/*
		 * 온도 변환을 위한 수식
		 */
		double F = 50.5;

		System.out.println(  "\n ** 온도 변환을 위한 수식 **" ); 
		System.out.println(  F - 32 * 5 / 9   );    // 구문적으로 문제 없으나 논리적으로 문제 있는 수식
		System.out.println(  (F - 32) * 5 / 9   );  // 화씨온도를 섭씨온도로 변환하는 수식 

		/*
		 * 점수 및 성적 처리를 위한 관련 수식
		 */
		int score;
		String grade;
		
		System.out.println(  "\n ** 점수 및 성적 처리를 위한 관련 수식 **" ); 
		System.out.print("  o 점수 입력하시오 > ");
		System.out.println(  score = SkScanner.getInt() );
		
		System.out.println(  score >= 90 && score <= 100  );  // 점수의 범위 검사
		System.out.println(  grade = score>=95 ? "A+"  : score>=90 ? "A0" : score>=85? "B+"  // 점수를 성적으로 변환하는 수식
			     : score>=80 ? "B0" : score>=75 ? "C+" : score>=70 ? "C0" : score>=65? "D+" 
			     : score>=60 ? "D0" : "F"  );

		System.out.println(  grade.equals("A+") || grade=="A0" || grade.equals("B" + "+")  );  // 문자열 동등 비교

		/*
		 * 문자열 접속 수식
		 */
		String name = "홍길동";
		int age = 18;

		System.out.println(  "\n ** 문자열 접속 수식 **" ); 
		System.out.println(  name + "의 나이: "+ age + ", 10년 후 나이: "  + age + 10  );
		System.out.println(  name + "의 나이: "+ age + ", 10년 후 나이: "  + (age + 10)  );		
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *
 *   o 수식의 결과를 손으로 구해보고 수행한 결과와 비교해 보라.
 *  
 */

