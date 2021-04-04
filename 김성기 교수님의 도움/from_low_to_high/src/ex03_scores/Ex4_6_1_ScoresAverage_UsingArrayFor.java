package ex03_scores;

/*
 * [ ScoresAverage_UsingArrayFor ]: 배열과 for 문장을 이용하여 점수를 입력하여 평균 및 평균 이상 인원수 출력
 * 
 *   o 프로그래밍 스타일 
 *     1) main() 메소드로만 클래스 구성
 *     2) 배열변수의 선언, for 문장을 이용한 간결한 입출력 및 원소 접근
 *  
 *   o 학생 수만큼의 점수를 입력하여 배열변수의 원소에 저장
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

class Ex4_6_1_ScoresAverage_UsingArrayFor {
	public static void main(String[] args) {   

		int noStudents; // 학생 수를 저장하는 변수
		System.out.println("\n  ** 점수 현황을 위한 학생수 입력 **");  
		noStudents = SkScanner.getInt("  o 학생수 입력 > ");

		// noStudents 명의 점수를 저장할 배열 객체를 scores 배열변수에 저장 
		int[] scores = new int[noStudents]; 

		/*
		 *  noStudents 명의 점수 입력하여 scores 배열변수에 저장하고 합 누적
		 */
		System.out.println("\n  **  " + noStudents + "명의 점수 입력 **");  	

		int sumScores = 0;   // 점수의 합을 저장하는 변수

		// noStudents 명 점수들을 10개씩 한 라인에 입력하여 원소에 저장하고 합을 누적
		for (int i = 0; i < noStudents; i++) {
			if (i % 10 == 0)
				System.out.print("  o " +( i + 1) +"번째부터 " + 
						((noStudents - i) >= 10 ?10 : (noStudents - i)) + "명의 점수 입력 > ");

			scores[i] = SkScanner.getInt(); // 정수 값 입력하여 scores[i]에 저장    
			sumScores += scores[i];       // 입력한 scores[i]를 sum에 누적시킴
		}

		double avgScores = sumScores / (double) noStudents; // 실수 점수 평균 구함
		int cnt = 0;  // 평균 이상 인원수를 저장하는 변수

		/*
		 *  입력된 noStudents 명의 점수를 모두 출력 
		 */
		System.out.print("\n  **  입력된 " + noStudents + "명의 점수 **");  
		for (int i = 0; i < noStudents; i++) {
			if (i % 10 == 0)
				System.out.print("\n  * " + (i + 1) + "번째부터 " + 
						((noStudents - i) >= 10 ? 10 : (noStudents - i))  + "명의 점수: " );

			System.out.print(scores[i] + "  ");

			if (scores[i] >= avgScores)
				cnt++;      // 점수가 평균 이상이면 cnt 1 증가시킴
		}

		/*
		 *  점수에 대한 현황 출력 
		 */
		System.out.println("\n\n  ** 학생 점수 현황 **");
		System.out.println("  * 총 학생수 = " + noStudents);
		System.out.println("  * " + noStudents + "명 점수 합 = " + sumScores);
		System.out.println("  * " + noStudents + "명 점수 평균 = " + avgScores);
		System.out.println("  * 전체 " + noStudents + "명 중 평균 이상 인원수: " +
				cnt);  
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *   
 *   1) 이 프로그램은 for 문장을 사용하여 배열변수의 장점을 보여주기 위해 작성된 것이다. 
 *      배열변수와 반복문이 결합된 좋은 스타일의 프로그램을 작성하기 위한 노력이 필요하다.      
 *      
 *   2) 프로그램을 실행하여 점수들을 입력하고 결과를 확인하라.
 *   
 *   3) 이 프로그램은 입력하는 데이터의 개수를 아주 쉽게 변경할 수 있도록 잘 작성된
 *      좋은 프로그램이다.
 */
