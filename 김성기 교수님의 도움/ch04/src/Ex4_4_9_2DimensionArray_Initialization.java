/**
 * [ 2DimensionArray_Initialization ]: 2차원 배열의 초기화
 * 
 *   o 프로그래밍 스타일 
 *     1) main() 메소드로만 클래스 구성
 *     2) 2차원 배열변수 선언과 초기화 이용한 2차원 배열 원소 저장 및 원소 접근
 *  
 *   o 2차원 배열변수 선언 및 배열 객체 저장
 *     - 원소타입[][] 배열변수명 = new 원소타입[행개수][열개수];
 *     
 *     - int[][] scores = new int[4][6];   // 4명 학생의 6 과목 점수 저장하는 2차원 배열
 *     - String][] name = new String[3][3] // 3개 소설의 주인공 이름 3개씩 저장하는 2차원 배열
 *     
 *   o 2차원 배열 초기화
 *     - 2차원 배열은 1차원 배열의 배열이라는 관점
 *     - 2차원 배열 초기화는 1차원 배열 초기화를 반복함
 *      
 *     - int[][] scores =  
 *                {  { 90, 92, 88, 95, 92, 88 },    // 첫 번째 학생 점수들 초기화
 *                   { 75, 77, 67, 89, 68, 72 },    // 두 번째 학생 점수들 초기화
 *                   { 91, 78, 69, 85, 76, 66 },    // 세 번째 학생 점수들 초기화
 *                   { 88, 82, 79, 82, 85, 89 }  }; // 네 번째 학생 점수들 초기화
 *                     
 *     - String[][] names =  
 *             {  { "성춘향", "이몽룡", "변학도", "방자" },     // 춘향전 주인공들 3명
 *                { "심청", "심학규", "뺑덕어미" },            // 심청전 주인공들 3명
 *                { "로미오", "줄리엣" }                 };   // 로미오와 줄리엣 주인공들 2명
 */ 

class Ex4_4_9_2DimensionArray_Initialization {
	public static void main(String[] args) {   
		String[] stNames = { "김철수", "김영희", "박문수", "감자바" };
		String[] coNames = { "국어", "영어", "수학", "한국사", "윤리", "물리" };
		
		// 여러 학생의 여러 점수를 저장할 2차원 배열
		//   2차원 배열 초기화는 1차원 배열 초기화의 반복으로 이루어짐
		int[][] scores = {
				  { 90, 92, 88, 95, 92, 88 },   // 첫 번째 학생 점수들 초기화
                  { 75, 77, 67, 89, 68, 72 },   // 두 번째 학생 점수들 초기화
                  { 91, 78, 69, 85, 76, 66 },   // 세 번째 학생 점수들 초기화
                  { 88, 82, 79, 82, 85, 89 } }; // 네 번째 학생 점수들 초기화

		int[] sumStudent = { 0, 0, 0, 0 };       // 학생별 6 과목의 점수 합을 저장할 변수
		int[] sumCourse = { 0, 0, 0, 0, 0, 0 };  // 과목별 4 학생의 점수 합을 저장할 변수

		for (int i = 0; i < stNames.length; i++) {
			for (int j = 0; j < scores[i].length; j++) {
				sumStudent[i] += scores[i][j]; // (i+1) 학생 (j+1) 점수를 학생 점수합에 누적 
				sumCourse[j] += scores[i][j];  // (i+1) 학생 (j+1) 점수를 과목 점수합에 누적 
			}
		}

		System.out.println("\n ** " + stNames.length + "명 학생의 " + coNames.length + "개 점수 합과 평균 **");
		for (int i = 0; i < stNames.length; i++)  
			System.out.println("  * " + stNames[i] + " 학생 - 점수합: " +  sumStudent[i]  
					+ ", 점수 평균: " +  sumStudent[i] / coNames.length);

		System.out.println("\n  ** " + coNames.length + "개 점수의 합과 평균 **");
		for (int i = 0; i < coNames.length; i++) 
			System.out.println("  * " + coNames[i] + " 과목 - 점수합: " +  sumCourse[i]  
					+ ", 점수 평균: " +  sumCourse[i] / stNames.length);

		// 3 소설 이름들 저장할 배열 
		String[] novel = { "춘향전", "심청전", "로미오와 줄리엣" };
		
		// 여러 소설의 주인공 이름들 저장할 2차원 배열 
		//   2차원 배열의 초기화는 1차원 배열 초기화의 반복으로 이루어짐
		String[][] names = {  
	              { "성춘향", "이몽룡", "변학도", "방자" },   // 춘향전 주인공들
	              { "심청", "심학규", "뺑덕어미" },          // 심청전 주인공들
	              { "로미오", "줄리엣" }                 }; 

		System.out.println("\n  **** " + novel.length + "개 소설의 주인공 ****");
		for (int i = 0; i < novel.length; i++) {
			System.out.print("  * " + novel[i] + "의 주인공 " + names[i].length + "명: ");
			
			for (String name: names[i]) {
				System.out.print(name + " "); 
			}
			
			System.out.println();
		}
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *    
 *   1) 이 프로그램은 2차원 배열의 선언 및 초기화, 중첩된 for 문을 모든 원소 접근 등을 보여준다.
 *      
 *   2) 프로그램을 실행하고 결과를 확인하라.
 *   
 *   
 * [ 실습과제 ]
 * 
 *   1) 고등학생 4명에 대해 1학년부터 3학년까지 키를 측정한 데이터를 초기화를 이용하여 저장하려 한다.
 *      (1) 이를 위한 2차원 배열변수를 선언하고 초기화를 이용하여 원소들을 저장하라.
 *      
 *      (2) 2차원 배열에 저장된 값을 출력하는 프로그램 코드를 작성하라
 *      
 *   2) scores[4][0], scores[3][6] 등 인덱스 범위를 벗어나는 원소를 접근하면 
 *      어떠한 일이 발생하는가를  확인하라.
 *      (배열의 인덱스 범위는 0부터 (개수-1)까지임)  
 */
