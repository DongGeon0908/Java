/**
 * [ ScoreToGrade_UsingSwitch ]: Switch 문 사용하여 점수를 성적등급으로 바꾸어 출력
 *
 *   o 프로그래밍 스타일 
 *     1) main() 메소드로만 클래스 구성
 *     2) 점수 입력하고 switch 문 사용하여 성적등급 구함
 *       
 *   o 점수 구간별 성적등급
 *       95~100: A+, 90~94: A0, 85~90: B+, 80~84: B0, 
 *       75~80 : C+, 70~74: C0, 65~70: D+, 60~65: D0, 
 *       60 미만: F 
 *
 *   o if 문 사용하지 않고 switch 문 사용하여 점수를 성적등급으로 변환
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
 *   o 이 예제에서는 case 상수수식의 예를 보이기 위해 많은 case 상수수식 작성했음
 *     
 */

class Ex4_2_5_ScoreToGrade_UsingSwitch {
	public static void main(String[] args)  {
		int score;           // 점수 입력 변수
		String grade = "";   // 성적등급 저장 변수

		System.out.println("\n\n  ** switch 문 사용하여 점수를 성적등급으로 변환 ** \n");

		score = SkScanner.getIntWithPrompt("  o 점수 입력 > "); 

		switch(score) {      // score에 대해
		case 95: case 95+1: case 95+1+1: case 95+3: case 95+4:  case 100: // 점수가 95, 96, 97, 98, 99, 100이면
			grade = "A+";         // 성적등급에 A+ 저장
			break;                // switch 문 벗어남

		case 90: case 91: case 92: case 93: case 94:  // 점수가 90, 91, 92, 93, 94이면
			grade = "A0";         // 성적등급에 A0 저장
			break;                // switch 문 벗어남

		case 85: case 86: case 87: case 88: case 89:  // 점수가 85, 86, 87, 88, 89이면
			grade = "B+";         // 성적등급에 B+ 저장
			break;                // switch 문 벗어남

		case 80: case 81: case 82: case 83: case 84:  // 점수가 80, 81, 82, 83, 84이면
			grade = "B0";         // 성적등급에 B0 저장
			break;                // switch 문 벗어남

		case 75: case 76: case 77: case 78: case 79:  // 점수가 75, 76, 77, 78, 79이면
			grade = "C+";         // 성적등급에 C+ 저장
			break;                // switch 문 벗어남

		case 70: case 71: case 72: case 73: case 74:  // 점수가 70, 71, 72, 73, 74이면
			grade = "C0";         // 성적등급에 C0 저장
			break;                // switch 문 벗어남

		case 65: case 66: case 67: case 68: case 69:  // 점수가 65, 66, 66, 67, 68, 69이면
			grade = "D+";         // 성적등급에 D+ 저장
			break;                // switch 문 벗어남

		case 60: case 61: case 62: case 63: case 64:  // 점수가 60, 61, 62, 63, 64이면
			grade = "D0";         // 성적등급에 D0 저장
			break;                // switch 문 벗어남

		default:                 // 기타 점수이면
			grade = "F";         //    성적등급에 F 저장       
			                     // 마지막엔 자동적으로 switch 문 벗어남
		}    

		System.out.print("  * 입력된 점수 " + score + "의 성적등급: " + grade );

		main(args);  // main() 메소드를 반복해서 수행시키는 가장 쉬운 방법(꼭 알아둘 것!!!!!!)
		             // 이 경우 끝없이 main() 메소드가 수행된다. 왜 그런지 생각해보고 연구해볼 것
	}
}

 /*
  * [ 프로그램의 이해 및 실행 ]
  *  
  *   1) 주어진 프로그램 살펴보고 프로그램의 내용 파악하라.     
  *      - switch 문의 구성에 대해 유심히 살펴보고 개략적으로 이해해야 한다.
  *      
  *   2) 각 성적등급에 해당되는 점수 입력하여 출력되는 성적등급 확인하라.
  *   
  *   3) 점수 150, -10을 입력하여 출력되는 성적등급 확인하라.
  *      문제점이 무엇인지 생각해보라     
  *
  * 
  * [ 실습과제 ]
  * 
  *   1) 이 프로그램의 switch 문에는 < case 90: >, < case 91: > 등 case 상수수식이 너무 많다.
  *      case 상수수식 줄일 수 있는 방안 모색하여 Pr4_2_5_ScoreToGrade_UsingSwitch 클래스로 작성하라.
  *       
  *      참고: Pr4_2_5_ScoreToGradeSwitch 클래스는 case 상수수식 개수 감소시키고 
  *           잘못된 점수(예를 들어, 음수인 점수 또는 200점 등)에 대한 처리를 포함하여야 한다.
  * 
  *   2) 모든 입력 데이터에 대해 완벽하게 작동하는 프로그램 작성은 쉽지 않다.
  *      특히 잘못된 데이터가 입력된 경우 이에 대한 처리가 제대로 되지 않으면 잘못된 결과가
  *      생성될 수 있다.
  *       
  *      이 프로그램도 잘못된 데이터가 입력되면 문제가 발생한다. 문제가 무엇인지를 찾아 설명하라.
  *   
  *   3) 본인이 작성한 Pr4_2_5_ScoreToGrade_UsingSwitch 클래스와 실습자료에 제시된  
  *      Ex4_2_6_ScoreToGrade_UsingSwitch2_LessCase 클래스를 비교하여 보라.
  */
