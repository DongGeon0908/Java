package ex03_scores;

/*
 * [ ScoresAverage_UsingClass]: 클래스를 이용하여 20명의 점수를 입력하여 평균 및 평균 이상 인원수 출력
 * 
 *   o 프로그래밍 스타일 
 *     1) Score 클래스: 여러 점수를 저장하고 합, 평균 등을 구해 출력하는 메소드를 갖는 클래스
 *     
 *     2) main() 메소드 외에 특정 작업을 수행하는 메소드를 작성하여 전체 작업을 수행함
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
 *            scores[1] = SkScanner.getInt();  
 *            scores[2] = SkScanner.getInt();
 *             
 *   o for 문에서 배열을 사용하면 간결하고 스마트한 코드가 작성됨   
 *             
 *   o SkScanner.getInt(): 정수 값을 입력, 정수가 아닌 것은 모두 무시됨                                  
 */ 
class Scores {
	int[] scores;   // 점수들을 저장하는 배열 필드
	int noScores;   // 점수 개수를 저장하는 필드
	
	// 매개변수 없는 객체 생성자: 처음에는 최대 점수 10개 저장할 배열 객체 생성하여 scores에 저장
	Scores() {
		scores = new int[10];
		noScores = 0;
	}
	
	
	// noScores 필드에 저장된 개수만큼의 점수를 scores 배열 필드에 입력하는 메소드
	void getScores(int n) {
		if (n > scores.length) {
			scores = new int[n]; // n개의 정수를 저장할 배열 객체를 생성하여 scores 배열변수에 저장
		}
		
		noScores = n;

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
	}
	
	// scores 배열 필드에 저장된 noScores 개수의 점수를 출력하는 메소드
	void outputScores(String title) {

		System.out.print(title);  
		
		int n = noScores;
		
		for (int i = 0; i < n; i++) {
			if (i % 10 == 0)
				System.out.print("\n  * " + (i + 1) + "번째부터 " + 
						((n - i) >= 10 ? 10 : (n - i))  + "개의 점수: " );

			System.out.print(scores[i] + "  ");
		}
	}	

	// scores 배열 필드에 저장되어진 점수들의  합을 구하여 반환하는 메소드
	int getSum() {
		int sum = 0;        // 합을 구하기 위해 sum 변수는 반드시 0으로 초기화해야 함

		for (int i = 0; i < noScores; i++)
			sum += scores[i]; // 정수배열  필드 scores[]의  원소들의 합을 구함

		return sum;
	}
	
	// scores 배열 필드에 저장되어진 점수들의  평균을 구해 반환하는 메소드
	double getAverage() {
		int sum = getSum();
		
		return sum / (double) noScores; // 실수 평균 구하여 반환
	}
	
	// scores 배열 필드에 저장되어진 점수들 중 점수가 주어진 score 이상인 원소 개수를 구하여 반환하는 메소드
	int getCountGE(double score){	
		int cnt = 0;

		for (int i = 0; i < noScores; i++) 
			if (scores[i] >= score)
				cnt++;       // 원소가 score 이상이면 cnt 1 증가시킴
		
		return cnt;
	}
	
	
}
class Ex6_ScoresAverage_UsingClass {
	
	public static void main(String[] args) {   

		Scores scores = new Scores();
		
		System.out.println("\n  ** 점수 현황을 위한 학생수 입력 **\n");  
		int  noStudents = SkScanner.getInt("  o 학생수 입력 > ");  // 학생 수를 입력하여 noStudents 변수에 저장
		
		scores.getScores(noStudents);  // noStudents 명의 점수를 입력하여 저장할 배열 객체를 scores 배열변수에 저장 

		int sumScores = scores.getSum();        // 점수들의 합을 구하여 sumScores 변수에 저장
		
		double avgScores = scores.getAverage(); // 실수 점수 평균 구하여 avgScores 변수에 저장
		
		int cntGeAverage = scores.getCountGE(avgScores);  // 평균 이상 인원수를 구하여 cnt 변수에 저장	

		scores.outputScores("\n  **  입력된 " + noStudents + "명의 점수 **");
		
		outputScoresInfo(noStudents, sumScores, avgScores, cntGeAverage);

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
 *   1) 이 프로그램은 여러 점수를 저장하고 이를 관리하기 위한 메소드를 갖는 클래스를 작성함
 *   
 *   2) 배열 필드를 객체 내부에 저장하므로 메소드의 매개변수에는 배열이 나타나지 않음을 확인하라.        
 *      
 *   3) 프로그램을 실행하여 점수들을 입력하고 결과를 확인하라.
 *   
 *   4) 이 프로그램은 입력하는 데이터의 개수를 아주 쉽게 변경할 수 있도록 잘 작성된
 *      좋은 프로그램이다.
 */
