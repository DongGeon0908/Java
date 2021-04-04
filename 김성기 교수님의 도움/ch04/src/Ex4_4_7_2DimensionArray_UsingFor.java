/**
 * [ 2DimensionArray_UsingFor ]: 중첩된 for 문 사용하여 2차원 배열 다루기
 * 
 *   o 프로그래밍 스타일 
 *     1) main() 메소드로만 클래스 구성
 *     2) 2차원 배열변수의 선언, 2차원 배열 원소 저장 및 원소 접근
 *  
 *   o 2차원 배열변수의 선언 및 배열 객체 저장
 *     - 원소타입[][] 배열변수명 = new 원소타입[행개수][열개수];
 *     
 *     - int[][] scores = new int[4][6];      // 4명 학생의 6 과목 점수 저장하는 2차원 배열
 *     - String[][] name = new String[3][3]   // 3개 소설의 주인공 이름 3개씩 저장하는 2차원 배열
 *     
 *   o 행 개수 noRow, 열 개수 noCol인 2차원 배열 array2D의 모든 원소에 값 저장하고 접근하기
 *   
 *     for (int i = 0; i < noRow; i++) {
 *       for (int j = 0; j < noCol; j++) {
 *          array2D[i][j] = 저장할_값;         // 인덱스 (i, j)인 원소에 값 저장
 *          변수 = array2D[i][j];              // 인덱스 (i, j)인 원소의 값을 변수에 저장
 *       }
 *     }                                        
 */ 

class Ex4_4_7_2DimensionArray_UsingFor {
	public static void main(String[] args) {   
		int[][] scores = new int[4][6];

		System.out.println("\n  ** 4명 학생의 점수 6개 입력 **");
		
		for (int i = 0; i < 4; i++) {
			System.out.print("  o "  + (i + 1) + "번째 학생의 점수 6개 입력하시오 > ");
			
			for (int j = 0; j < 6; j++) 
				scores[i][j] = SkScanner.getInt();
			
		}

		int[] sumStudents = { 0, 0, 0, 0 };       // 학생별 6 과목의 점수 합을 저장할 변수
		int[] sumCourses = { 0, 0, 0, 0, 0, 0 };  // 과목별 4 학생의 점수 합을 저장할 변수

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 6; j++) {
				sumStudents[i] += scores[i][j]; // (i+1) 학생 (j+1) 점수를 학생 점수합에 누적 
				sumCourses[j] += scores[i][j];  // (j+1) 과목 (j+1) 점수를 과목 점수합에 누적 
			}
		}

		System.out.println("\n  ** 4명 학생의 점수 6개 합과 평균 **");
		
		for (int i = 0; i < 4; i++)  
			System.out.println("  * " + (i + 1) + "번째 학생 - 점수합: " +  sumStudents[i]  
					+ ", 점수 평균: " +  sumStudents[i] / 6.0);

		System.out.println("\n  ** 점수 6개 합과 평균 **");
		
		for (int i = 0; i < 6; i++) 
			System.out.println("  * " + (i + 1) + "번째 과목 - 점수합: " +  sumCourses[i]  
					+ ", 점수 평균: " +  sumCourses[i] / 4.0);	
		
		
		// 3개의 소설과 각 소설의 주인공 3명 이름을 저장할 배열들 
		String[] novels = { "춘향전", "심청전", "로미오와 줄리엣" };
		String[][] names = new String[3][3];

		System.out.println("\n\n  **** 3개 소설의 주인공 3명 입력 ****");
		
		for (int i = 0; i < 3; i++) {
			System.out.println("\n  ** " + novels[i] + "의 주인공 3명 입력 **");
			
			for (int j = 0; j < 3; j++)
				names[i][j] = SkScanner.getString("  * 주인공 " + ( j + 1) + " > "); 
		}

		System.out.println("\n  **** 3개 소설의 주인공 ****");
		for (int i = 0; i < 3; i++) {
			System.out.print("  * " + novels[i] + "의 주인공: ");
			
			for (String name: names[i]) 
				System.out.print(name + " "); 
			
			System.out.println();
		}
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *     
 *   1) 이 프로그램은 2차원 배열의 선언, 중첩된 for 문을 이용한 모든 원소에 값 저장, 모든 원소 접근 등을 보여준다.
 *      
 *   2) 프로그램을 실행하고 결과를 확인하라.
 *   
 *   
 * [ 실습과제 ]
 * 
 *   o 중학생 4명에 대해 1학년부터 3학년까지 3년 동안의 키를 측정한 데이터를 저장하려 한다.
 *   
 *     (1) 이를 위한 2차원 배열변수를 선언하고 배열객체를 생성하여 배열변수에 저장하라.
 *      
 *     (2) 4명 학생의 3개 키를  입력하여 2차원 배열에 저장하는 프로그램 코드를 작성하라.
 *      
 *     (3) 2차원 배열에 저장된 키를  출력하는 프로그램 코드를 작성하라.
 *     
 *     (4) 학생별로 1년 동안  키가 자란 성장치 2개를 구하여 출력하는 코드를 작성하라.
 *     
 *     (5) 키 성장치의 최고값과 평균값을 구하여 출력하라.
 */
