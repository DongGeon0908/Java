package ex03_scores;

/*
 * [ Scores_InOut_UsingArrayFor ]: 배열과 For 문장을 이용하여 20명의 점수를 입력한 후 저장 및 출력
 * 
 *   o 프로그래밍 스타일 
 *     1) main() 메소드로만 클래스 구성
 *     2) 배열변수의 선언, For 문장을 이용한 간결한 입력, 저장, 원소 출력
 *  
 *   o 학생 수만큼의 점수를 입력하여 배열변수의 원소에 저장
 *       - 학생수를 변수에 저장
 *            int noStudents = 20;   // 학생 수를 저장하는 변수
 *            
 *     - 배열변수의 선언: 타입[] 배열변수 = new 타입[저장할_원소_개수];
 *         예: int[] scores = new int[noStudents]; // noStudents개의 원소를 저장할 int 배열 객체를 생성하여 scores 배열변수에 저장
 *         
 *     - 입력한 값을 배열 원소에 저장: 배열변수명[인덱스] = SkScanner.getXxx();
 *         예: scores[0] = SkScanner.getInt();  // 배열 원소의 인덱스는 0부터 시작함 
 *             scores[1] = SkScanner.getInt();  
 *             scores[2] = SkScanner.getInt();
 *             
 *   o for 문에서 배열을 사용하면 간결하고 스마트한 코드가 작성됨   
 *             
 *   o SkScanner.getInt(): 정수 값을 입력, 정수가 아닌 것은 모두 무시됨                                  
 */ 

class Ex2_4_3_Scores_InOut_UsingArrayFor {
	
	public static void main(String[] args) {   
		int noStudents = 20;   // 학생 수를 저장하는 변수, 학생 수만큼 점수가 배열에 입력되어 저장됨 
		
		int[] scores = new int[noStudents]; // noStudents 명의 점수를 저장할 배열 객체를 scores 배열변수에 저장 

		// noStudents 명의 점수를 입력하여 배열변수의 인덱스 0부터 noStudents - 1까지의 원소에 저장
		System.out.println("\n  **  " + noStudents + "명의 점수 입력 **\n");  	// 입력을 위한 타이틀 출력      

		// noStudents 명 점수를 10개씩 한 라인에 입력하여 배열변수 원소에 저장
		for (int i = 0; i < noStudents; i++) {
			if (i % 10 == 0)
				System.out.print("  o " +(i + 1) +"번째부터 " + (i + 1) + "번째부터 " + 
			                     ((noStudents - i) >= 10 ? 10 : (noStudents - i))  + "명의 점수 입력하시오 > "); // 프롬프트 메시지 출력			

			scores[i] = SkScanner.getInt();   // 정수 값 입력하여 scores[i] 원소에 저장      
		}

		// 입력된 noStudents 명의 점수를 모두 출력 
		System.out.println("\n  **  입력된 " + noStudents + "명의 점수 **");  // 출력을 위한 타이틀 출력
		for (int i = 0; i < noStudents; i++) {
			if (i % 10 == 0)
				System.out.print("\n  * " + (i + 1) + "번째부터 " + (i + 1) + "번째부터 " +
			                    ((noStudents - i) >= 10 ? 10 : (noStudents - i))  + "명의 점수: " );
			
			System.out.print(scores[i] + "  ");
		}
		
		// 입력된 10명의 점수 합을 구함
		int sumScores = scores[0] + scores[1] + scores[2] + scores[3] + scores[4] 
		            + scores[5] + scores[6] + scores[7] + scores[8] + scores[9] ; 

		// 점수 합을 학생수로 나누어 점수 평균을 구함
		double avgScores = sumScores / (double) noStudents;  // 실수 평균을 구하기 위해 noStudents를double로 캐스트시킴

		System.out.println("\n  ** 학생 점수 현황 **");
		System.out.println("  * 총 학생수 = " + noStudents);
		System.out.println("  * " + noStudents + "명 학생 점수 합 = " + sumScores);
		System.out.println("  * " + noStudents + "명 학생 점수 평균 = " + avgScores);
		

		System.out.println("\n\n  ^^ Well done! Have a good time!!! ^^\n"); // 이 문장은 프로그램의 종료를 나타내는 문장임
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *   
 *   1) 이 프로그램은 아직 배우지 않은 for 문장을 사용하여 배열변수의 장점을 
 *      보여주기 위해 작성된 것이다. 배열변수와 반복문이 결합된 좋은 스타일의 
 *      프로그램을 작성하기 위한 노력이 필요하다.      
 *      
 *   2) 프로그램을 실행하여 점수들을 입력하고 결과를 확인하라.
 *   
 *   3) main() 함수의 위에 있는 << #define NOSTUDENTS 20 >>에서의 20을 10으로 변경하여 컴파일한 후 수행해보라.
 *      또한 20을 30으로 변경하여 컴파일한 후 수행해보라. 
 *    
 *      이 프로그램은 입력하는 데이터의 개수를 아주 쉽게 변경할 수 있도록 잘 작성된
 *      좋은 프로그램이다.
 */
