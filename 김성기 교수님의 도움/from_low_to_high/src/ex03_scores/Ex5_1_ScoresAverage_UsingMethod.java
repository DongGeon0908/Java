package ex03_scores;

/*
 * [ ScoresAverage_UsingMethod ]: 메소드를 이용하여  점수를 입력하여 평균 및 평균 이상 인원수 출력
 * 
 *   o 프로그래밍 스타일 
 *     1) main() 메소드 외에 특정 작업을 수행하는 메소드를 작성하여 전체 작업을 수행함
 *     2) 배열변수의 선언, For 문장을 이용한 간결한 입출력 및 원소 접근
 *  
 *   o 학생 수만큼의 점수를 입력하여 배열변수의 원소에 저장            
 *     - 배열변수의 선언: 타입[] 배열변수 = new 타입[저장할_원소_개수];
 *         예: int[] scores = new int[noStudents]; // noStudents개의 원소를 저장할 int 배열 객체를 생성하여 scores 배열변수에 저장
 *         
 *     - 입력한 값을 배열 원소에 저장: 배열변수명[인덱스] = SkScanner.getXxx();
 *         예: scores[0] = SkScanner.getInt();  // 배열 원소의 인덱스는 0부터 시작함 
 *             scores[1] = SkScanner.getInt();  
 *             scores[2] = SkScanner.getInt();
 *             
 *   o 배열을 매개변수로 전달하는 메소드
 *     - 호출된 곳에서 배열 원소가 변경되면 호출한 곳에서도 변경된 결과를 가짐
 *   
 *   O 배열을 반환값으로 반환하는 메소드
 *      - 호출된 메소드에서 배열 객체 생성하여 원소 저장하여 반환
 *      - C 언어에서는 호출된 함수에서 배열 선언한 후 원소 저장한 후 반환하면 안됨
 *        (C의 배열변수는 시스템 스택에 할당되기 때문에 함수가 종료되면 배열변수의 기억장소가 없어지기 때문임)                                   
 */ 

class Ex5_1_ScoresAverage_UsingMethod {
	
	public static void main(String[] args) {   

		System.out.println("\n  ** 점수 현황을 위한 학생수 입력 **");  
		int  noStudents = SkScanner.getInt("  o 학생수 입력 > ");  // 학생 수를 입력하여 noStudents 변수에 저장
		
		int[] scores = getScores(noStudents);  // noStudents 명의 점수를 입력하여 저장할 배열 객체를 scores 배열변수에 저장 

		int sumScores = getSum(scores);        // 점수들의 합을 구하여 sumScores 변수에 저장		
		double avgScores = getAverage(sumScores, noStudents); // 실수 점수 평균 구하여 avgScores 변수에 저장		
		int cntGeAverage = getCountGE(scores, avgScores);  // 평균 이상 인원수를 구하여 cntGeAverage 변수에 저장

		outputScores(scores, "\n  **  입력된 " + noStudents + "명의 점수 **");	
		outputScoresInfo(noStudents, sumScores, avgScores, cntGeAverage);

	}
	
	// 주어진 n개의 점수를 입력하여 배열에 저장한 후 배열을 반환
	static int[] getScores(int n) {
		int[] scores = new int[n]; // n개의 정수를 저장할 배열 객체를 생성하여 scores 배열변수에 저장

		/*
		 *  n개의 점수 입력하여 scores 배열변수에 저장하고 합 누적
		 */
		System.out.println("\n  **  " + n + "개의 점수 입력 **");  	

		// n 개의 점수들을 10개씩 한 라인에 입력하여 원소에 저장하고 합을 누적
		for (int i = 0; i < n; i++) {
			if (i % 10 == 0)
				System.out.print("  o " + ( i + 1) +"번째부터 " + 
						((n - i) >= 10 ? 10 : (n - i)) + "개 점수 입력 > ");

			scores[i] = SkScanner.getInt(); // 정수 값 입력하여 scores[i]에 저장    
		}
		
		return scores;
	}
	
	// scores 배열의 모든 원소들을  타이틀과 함께 출력
	static void outputScores(int[] scores, String title) {
		System.out.print(title);  
		
		int n = scores.length;
		
		for (int i = 0; i < n; i++) {
			if (i % 10 == 0)
				System.out.print("\n  * " + (i + 1) + "번째부터 " + 
						((n - i) >= 10 ? 10 : (n - i))  + "개의 점수: " );

			System.out.print(scores[i] + "  ");
		}
	}	

	// 주어진 정수배열 ints[]의 모든 원소의 합을 구하여 반환
	static int getSum(int[] ints) {
		int sum = 0;        // 합을 구하기 위해 sum 변수는 반드시 0으로 초기화해야 함

		for (int n : ints)  // 정수배열 ints[]의 모든 원소가 자동적으로 n에 한번씩 저장되어 
			sum += n;       //   sum = sum + n;이 반복 수행됨

		return sum;
	}
	
	// 합과 개수가 주어지면 실수 평균을 구해 반환하는 메소드
	static double getAverage(int sum, int n) {
		return sum / (double) n; // 실수 평균 구하여 반환
	}
	
	// 정수 배열과 점수가 주어지면 점수 이상인 원소 개수를 구하여 반환
	static int getCountGE(int[] ints, double score){	
		int cnt = 0;

		for (int i = 0; i < ints.length; i++) 
			if (ints[i] >= score)
				cnt++;       // 원소가 score 이상이면 cnt 1 증가시킴
		
		return cnt;
	}

	static void outputScoresInfo(int no, int sum, double avg, int cntGeAverage) {

		System.out.println("\n\n  ** 학생 점수 현황 **");
		System.out.println("  * 총 학생수 = " + no);
		System.out.println("  * " + no + "명 점수 합 = " + sum);
		System.out.println("  * " + no + "명 점수 평균 = " + avg);
		System.out.println("  * 전체 " + no + "명 중 평균 이상 인원수: " + cntGeAverage);  
	}

}

/*
 * [ 프로그램의 이해 및 실행 ]
 *   
 *   1) 이 프로그램은 정수 배열과 관련된 메소드를 사용하여 배열변수를 다루는 프로그램이다.
 *      배열변수, 반복문, 메소드 등이 결합된 좋은 스타일의 
 *      프로그램을 작성하기 위한 노력이 필요하다.      
 *      
 *   2) 프로그램을 실행하여 점수들을 입력하고 결과를 확인하라.
 *   
 *   3) 이 프로그램은 입력하는 데이터의 개수를 아주 쉽게 변경할 수 있도록 잘 작성된
 *      좋은 프로그램이다.
 */
