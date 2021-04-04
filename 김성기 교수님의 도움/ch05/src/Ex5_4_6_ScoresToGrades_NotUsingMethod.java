/**
 *  [ ScoresToGrades_NotUsingMethod ]: 
 *        여러 점수(score) 입력하여 대응되는 성적 등급(grade)과 평점(grade point) 출력하고
 *        평균 평점 계산하여 출력
 *
 *    o 프로그래밍 스타일 
 *      - 점수 입력받고 중첩된 if 문 사용하여 성적 등급과 평점 구함
 *     
 *    o 중첩된 if 문
 *      - if 문 내에 또 다른 if 문이 내포된다든지 else 부분이 연속적으로 반복되어지는 if 문
 *      - else 부분이 생략 가능하므로 정확히 작성해야 함
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

class Ex5_4_6_ScoresToGrades_NotUsingMethod {
	public static void main(String[] args)  {
		int noScores = 0;          // 입력한 점의 개수 저장하는 변수 
		int score;                 // 점수 입력하여 저장하는 변수
		String grade;              // 성적 등급 저장하는 변수
		double gradePoint;         // 평점 저장하는 변수
		double sumGradePoint = 0;  // 평점의 합 저장하는 변수
		
		System.out.println("\n\n   **** 점수를 성적 등급으로 변환하고 평균 평점 구하기 **** ");

		while(true) {
			while(true) {
				score = SkScanner.getIntWithPrompt("\n  o 0과 100 사이 점수 입력(-1 입력 시 종료) > "); 
				if (score >= -1 && score <= 100)    // -1과 100 사이 점수 입력되면
					break;                          //     break 문으로 내부 while 문 벗어남
			}
			
			if (score == -1)
				break;  // -1이 입력되면 break 문 이용하여 외부 while 문 반복 벗어남
			
			noScores++;   // 점수 개수 1 증가시킴

			if (score >= 95 && score <= 100)     // 점수가 95 ~ 100이면
				grade = "A+";                    //   성적등급에 A+ 저장
			else if (score >= 90 && score <= 94) // 점수가 90 ~ 94이면
				grade = "A0";                    //   성적등급에 A0 저장
			else if (score >= 85 && score <= 89) // 점수가 85 ~ 89이면
				grade = "B+";                    //   성적등급에 B+ 저장
			else if (score >= 80 && score <= 84) // 점수가 80 ~ 84이면
				grade = "B0";                    //   성적등급에 B0 저장
			else if (score >= 75 && score <= 79) // 점수가 75 ~ 79이면
				grade = "C+";                    //   성적등급에 C+ 저장
			else if (score >= 70 && score <= 74) // 점수가 70 ~ 74이면
				grade = "C0";                    //   성적등급에 C0 저장
			else if (score >= 65 && score <= 69) // 점수가 65 ~ 69이면
				grade = "D+";                    //   성적등급에 D+ 저장
			else if (score >= 60 && score <= 64) // 점수가 60 ~ 64이면
				grade = "D0";                    //   성적등급에 D0 저장		
			else                                 // 기타 점수이면
				grade = "F";                     //   성적등급에 F 저장           
			
			switch(grade) {
			case "A+": 
				gradePoint = 4.5;
				break;
			case "A0": 
				gradePoint = 4;
				break;
			case "B+": 
				gradePoint = 3.5;
				break;
			case "B0": 
				gradePoint = 3;
				break;
			case "C+": 
				gradePoint = 2.5;
				break;
			case "C0": 
				gradePoint = 2;
				break;
			case "D+": 
				gradePoint = 1.5;
				break;	
			case "D0": 
				gradePoint = 1;
				break;
			case "F": 
				gradePoint = 0;
				break;	
			default:
					gradePoint = 0;
					
			}
			
			sumGradePoint = sumGradePoint + gradePoint;
			
			System.out.println("  * 입력 점수 " + score + "의 성적 등급: " + grade + ", 평점: " + gradePoint);
		}

		double avgGradePoint = sumGradePoint / noScores;
		
		System.out.print("\n\n  ** 입력한 점수 " + noScores + "개 점수의 평점 합 = " + sumGradePoint + ", 평균 평점 = " + avgGradePoint);
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 * 
 *   1) 이 프로그램은 복잡한 작업을 main() 메소드에서 모두 처리하므로 매우 복잡하게 프로그램이 구성된다.
 *      - 프로그램의 기능을 쉽게 파악하기가 다소 어려움
 *   
 *   2) 프로그램을 실행한 후 프로그램을 기능을 이해하도록 노력해보라.
 */
