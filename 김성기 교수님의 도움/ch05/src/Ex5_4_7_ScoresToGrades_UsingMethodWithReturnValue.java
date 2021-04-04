/**
 *  [ ScoresToGrades_UsingMethodWithReturnValue ]: 
 *         반환값 갖는 메소드를 이용하여 여러 점수(score)를 입력하여 
 *         대응되는 성적 등급(grade)과 평점(grade point) 출력하고 평균 평점 계산하여 출력
 *
 *    o 프로그래밍 스타일 
 *       - 반환값 갖는 메소드를 이용
 *       - 복잡한 작업을 수행하는 프로그램이 기능적으로 잘 작성되어 좋은 스타일의 프로그램 
 *             
 *    o 반환값을 반환하는 메소드
 *      - int getIntBtw(int min, int max, String promptMsg): 
 *          프롬프트 메시지 promptMsg를 출력한 후  min과 max 사이의 정수를 입력하여 반환 
 *      - String getGrade(int score): 점수 score를 성적 등급으로 변환하여 반환
 *      - double getGradePoint(String grade): 성적등급 grade를 평점으로  변환하여 반환
 *       
 *    o 점수 구간별 성적 등급
 *        95~100: A+, 90~94: A0, 85~90: B+, 80~84: B0, 
 *        75~80 : C+, 70~74: C0, 65~70: D+, 60~65: D0, 
 *        60 미만: F 
 *     
 *    o 성적 등급에 대해 평점
 *        A+: 4.5, A0: 4.0, B+: 3.5, B0: 3.0, 
 *        C+: 2.5  C0: 2.0, D+: 1.5, D0: 1.0, f: 0
 *
 *    o if 문의 조건을 여러 번 사용하여 점수를 성적 등급으로 변환
 *    
 *    o switch 문을 이용하여 성적 등급을 평점으로 변환
 */

class Ex5_4_7_ScoresToGrades_UsingMethodWithReturnValue {
	public static void main(String[] args)  {
		int noScores = 0;       // 입력한 점수 개수 저장하는 변수 
		int score;              // 점수 입력하여 저장하는 변수
		String grade;           // 성적 등급 저장하는 변수
		double gradePoint;      // 평점 저장하는 변수
		double sumGradePoint = 0;  // 평점의 합을 저장하는 변수

		System.out.println("\n\n  **** 점수를 성적 등급으로 변환하고 평균 평점 구하기 **** ");

		while(true) {
			score = getIntBtw(-1, 100, "\n  o 0과 100 사이의 점수 입력 (-1이면 종료) > "); 
			if (score == -1)
				break;

			noScores++;                         // 점수 개수를 1 증가시킴
			grade = getGrade(score);            // 점수의 성적등급을 구함
			gradePoint = getGradePoint(grade);  // 성적등급의 평점을 구함

			sumGradePoint = sumGradePoint + gradePoint;  // 평점을 누적

			System.out.println("  * 입력 점수 " + score + "의 성적 등급: " + grade + ", 평점: " + gradePoint);
		}

		double avgGradePoint = sumGradePoint / noScores;  // 평점 평균을 구함

		System.out.print("\n\n  ** 입력한 점수 " + noScores + "개 점수의 평점 합 = " + sumGradePoint + ", 평균 평점 = " + avgGradePoint);
	}

	// 주어진 프롬프트 메시지 promptMsg를 출력한 후  min과  max 사이의 정수를 입력하여 반환하는  메소드
	// 입력한 정수가 min과  max 사이의 정수가 아니면 계속 반복 입력함
	static int getIntBtw(int min, int max, String promptMsg)  {
		while(true) {
			int n = SkScanner.getIntWithPrompt(promptMsg);  // 프롬프트 메시지 promptMsg를 출력
			if (n >= min && n <= max)                       // min과  max 사이의 정수를 입력하면
				return n;                                   //  이를 반환
		}
	}

	// 주어진 점수 score를 성적 등급으로 변환하여 반환하는  메소드
	static String getGrade(int score)  {
		if (score >= 95 && score <= 100) 	 // 점수가 95 ~ 100이면
			return "A+";                     //   A+ 반환 
		else if (score >= 90 && score <= 94) // 점수가 90 ~ 94이면
			return "A";                      //   A 반환        
		else if (score >= 85 && score <= 89) // 점수가 85 ~ 89이면
			return "B+";                     //   B+ 반환
		else if (score >= 80 && score <= 84) // 점수가 80 ~ 84이면
			return "B0";                     //   B0  반환
		else if (score >= 75 && score <= 79) // 점수가 75 ~ 79이면
			return "C+";                     //   B+ 반환
		else if (score >= 70 && score <= 74) // 점수가 70 ~ 74이면
			return  "C0";                    //   B+ 반환
		else if (score >= 65 && score <= 69) // 점수가 65 ~ 69이면
			return "D+";                     //   B+ 반환
		else if (score >= 60 && score <= 64) // 점수가 60 ~ 64이면
			return "D0";                     //   D0 반환  
		else                                 // 기타 점수이면
			return "F";                      //   F 반환
	}

	// 주어진 성적등급 grade를 평점으로  변환하여 반환하는  메소드
	static double getGradePoint(String grade)  {
		switch(grade) {
		case "A+": 
			return 4.5;
		case "A": 
			return  4;
		case "B+": 
			return 3.5;
		case "B": 
			return 3;
		case "C+": 
			return 2.5;
		case "C": 
			return  2;
		case "D+": 
			return 1.5;	
		case "D": 
			return 1;
		case "F": 
			return  0;

		default:
			return 0;
		}
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 * 
 *   1) 이 프로그램은 예제 5-4-6 프로그램을 반환값 갖는 메소드를 이용하여 재구성한 프로그램이다.
 *      - main() 메소드가  메소드 호출로 작성되어져 기능적인 프로그램으로 잘 작성됨
 *      - 프로그래밍 스타일이 아주 좋은 프로그램임 
 *     
 *   2) 프로그램을 실행하기 전 프로그램 읽기 수행하여 기능을 이해한 후 프로그램을 실행하여 결과를 확인하라.
 */
