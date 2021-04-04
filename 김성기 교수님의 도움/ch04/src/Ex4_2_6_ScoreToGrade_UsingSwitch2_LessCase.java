/**
 * [ ScoreToGrade_UsingSwitch2_LessCase ]: 
 *        Switch 문 사용하여 점수를 성적등급으로 바꾸어 출력(case 상수수식 개수 줄임)
 *
 *   o 프로그래밍 스타일 
 *     1) main() 메소드로만 클래스 구성
 *     2) 점수 입력하여 switch 문 사용하여 성적등급 구함
 *
 *   o 점수 구간별 성적등급
 *       95~100: A+, 90~94: A0, 85~90: B+, 80~84: B0, 
 *       75~80 : C+, 70~74: C0, 65~70: D+, 60~65: D0, 
 *       60 미만: F 
 *
 *   o if 문 사용하지 않고 switch 사용하여 점수를 성적등급으로 변환
 *    
 *   o switch 문
 *     - switch 수식과 case 상수수식이 일치하면 case 문장 수행
 *     - break 문을 만나면 switch 문 벗어남
 *     
 *     - case 상수수식은 상수와 연산자로만 구성되는 수식
 *     - case 상수수식은 여러 개 나열될 수 있음
 *     
 *     - switch 수식에 일치하는 case 상수수식이 없으면 default: 다음 문장 수행
 *          
 *   o switch 문의 case 상수수식의 개수 줄이기 위해 < switch(score / 5) >에서 
 *     score를 5로 나눈 몫에 대해 case 상수수식과 비교함 
 *     
 *     그리하면 case 상수수식의 개수가 1/5로 줄어듦
 *      
 *   o 또한 이 프로그램에서는 100점보다 큰 점수 또는 0점보다 작은 점수가 입력되면 
 *     입력된 점수 무시하고 다시 점수 입력받도록 함  
 */

class Ex4_2_6_ScoreToGrade_UsingSwitch2_LessCase {
	public static void main(String[] args)  {
		int score;      // 점수 입력 변수
		String grade;   // 성적등급 저장 변수

		System.out.println("\n  ** 점수를 성적등급으로 변환 ** \n");

		while(true) {
			score = SkScanner.getInt("  o 0부터 100까지의 점수 입력  > ");  // 점수를 문자열로 입력

			if (score > 100 || score < 0) {
				System.out.println("    ?? 잘못된 점수입니다. 다시 입력하시오.\n");
			}
			else
			   break;
		}

		switch(score / 5 ) {   // score를 5로 나눈 몫에 대해
		case 19: case 20:          // 점수가 95, 96, 97, 98, 99, 100, 101, 102, 103, 104이면(몫이 19, 20이면)
			grade = "A+";          //   성적등급에 A+ 저장
			break;

		case 18:                   // 점수가 90, 91, 92, 93, 94이면(몫이 18이면)
	         grade = "A0";         //   성적등급에 A0 저장
		     break;
	 
		case 17:                   // 점수가 85, 86, 87, 88, 89이면(몫이 17이면)
	         grade = "B+";         //   성적등급에 B+ 저장
		     break;
		     
		case 16:                   // 점수가 80, 81, 82, 83, 84이면(몫이 16이면)
	         grade = "B0";         //   성적등급에 B0 저장
		     break;
		     
		case 15:                   // 점수가 75, 76, 77, 78, 79이면(몫이 15이면)
	         grade = "C+";         //   성적등급에 C+ 저장
		     break;
		     
		case 14:                   // 점수가 70, 71, 72, 73, 74이면(몫이 14이면)
	         grade = "C0";         //   성적등급에 C0 저장
		     break;
	 
		case 13:                   // 점수가 65, 66, 66, 67, 68, 69이면(몫이 13이면)
	         grade = "D+";         //   성적등급에 D+ 저장
		     break;
		     
		case 12:                   // 점수가 60, 61, 62, 63, 64이면(몫이 12이면)
	         grade = "D0";         //   성적등급에 D0 저장
		     break;

		default:                  //    기타 점수이면
			grade = "F";          //    성적등급에 F 저장
		}
			
		System.out.println("  * 입력 점수 " + score + "의 성적등급: " + grade);
		
		main(args);  // main() 메소드를 반복하는 가장 쉬운 방법(꼭 알아둘 것!!!!!!)
                     // 이 경우 끝없이 main() 메소드가 수행된다. 왜 그런지 생각해보고 연구해볼 것
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *  
 *   1) 주어진 프로그램 살펴보고 프로그램의 내용 파악하라.     
 *      - switch 문 위에 while(true) { ... } 문장이 있는데,
 *         이 문장은 다음에 배울 반복문이다.
 *         
 *      - switch 문의 구성에 대해 자세히 살펴보고 자세히 이해하라.
 *      
 *   2) 각 성적등급에 해당되는 점수 입력하여 출력되는 성적등급 확인하라.
 *   
 *   3) 점수 150, -10을 입력하여 출력되는 성적등급 확인하라.  
 *
 * 
 * [ 실습과제 ]
 * 
 *   o 성적등급(grade)에 대해 다음과 같이 평점(grade point)이 지정되어 있다.
 *      A+: 4.5, A0: 4.0, B+: 3.5, B0: 3.0, 
 *      C+: 2.5  C0: 2.0, D+: 1.5, D0: 1.0, f: 0
 *      
 *      구해진 성적등급에 대해 switch 문 이용하여 평점 구하여 출력하도록 프로그램 변경하라.
 *      
 *      Java의 switch 문에는 문자열을 switch 수식으로 사용할 수 있으며, case 상수수식에 문자열을 사용할 수 있다.
 *      
 *       switch(grade) {
 *          case "A+":
 *            ...
 *            
 *         case "A0": 
 *            ...
 *       }  
 */
