/**
 * [ 2DimensionArray_RowCountColumnCount ]: 2차원 배열의 행 개수와 특정 행의 열 개수 구하기
 * 
 *   o 프로그래밍 스타일 
 *     1) main() 메소드로만 클래스 구성
 *     2) 2차원 배열변수의 선언, 2차원 배열 원소 저장 및 원소 접근
 *  
 *   o 2차원 배열변수의 선언 및 배열 객체 저장
 *     - 원소타입[][] 배열변수명 = new 원소타입[행개수][열개수];
 *     
 *     - int[][] scores = new int[4][6];     // 4명 학생의 6 과목 점수 저장하는 2차원 배열
 *     - String][] names = new String[3][3]  // 3개 소설의 주인공 이름 3개씩 저장하는 2차원 배열
 *     
 *   o 2차원 배열의 행 개수 구하기: length 필드 사용
 *     - 2차원배열.length: 이차원 배열에서의 행 개수 구함
 *     - 예) scores.length ==> 4
 *            names.length ==> 3
 *     
 *   o 2차원 배열의 특정 행의 열 개수 구하기: length 필드 사용          
 *     - 2차원배열[row].length: 이차원 배열에서 특정 행인 row의 열 개수 구함
 *     - 예) scores[0].length ==> 인덱스 0인 행의 열 개수인 6
 *           names[2].length ==> 인덱스 2인 행의 열 개수인 3
 */ 

class Ex4_4_8_2DimensionArray_RowCountColumnCount {
	public static void main(String[] args) {   
		int[] prices = new int[6];         // prices는 원소 개수가 6개인 1차원 배열
		String[] novels = new String[3];   // novels는 원소 개수가 3개인 1차원 배열

		int no = novels.length;            // 1차원 배열 novels의 원소 개수 구하여 no에 저장

		System.out.println("  * prices 원소 개수 = " + prices.length);
		System.out.println("  * novels의 원소 개수 = " + no);

		
		int[][] scores = new int[4][6];      // scores는 행 개수 4, 열 개수 6인 이차원 배열
		String[][] names = new String[3][3]; // names는 행 개수 3, 열 개수 3인 이차원 배열
		no = names.length;                   // names 이차원 배열의 행 개수 구해 저장

		System.out.println("\n  * scores 행 개수 = " + scores.length
		                     + ", names의 행 개수 = " + no);

		
		int noCol0 = scores[0].length;  // 첫번째 행의 열 개수 구해 저장
		int noCol1 = scores[1].length;  // 두번째 행의 열 개수 구해 저장

		System.out.println("\n  * scores 첫 번째 행의 열 개수 = " + noCol0 
		                 + "\n  * scores 두 번째 행의 열 개수 = " + noCol1
		                 + "\n  * names의 첫 번째 행의 열 개수 = " + names[0].length);
		
		System.out.println();
		for (int i=0; i < scores.length; i++)
			System.out.println("  * scores " + (i + 1) + "번째 행의 열 개수 = " + scores[i].length);
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *     
 *   1) 이 프로그램은 1차원 배열과 2차원 배열을 선언하고 행과 열의 개수를 구하는 것을 보여준다.
 *      
 *   2) 프로그램을 실행하고 결과를 확인하라.
 *   
 *   
 * [ 실습과제 ]
 * 
 *   o 한국, 중국, 일본 3개국의 2010년부터 2019년까지 10년간 경제 성장률을 이차원 배열 growthRate에 저장하려 한다.
 *     - 한국의 2010년 경제 성장률은 growthRate[0][0]에, 2011년 성장률은 growthRate[0][1]에 저장
 *     - 중국의 2010년 경제 성장률은 growthRate[1][0]에, 2011년 성장률은 growthRate[1][1]에 저장     
 *   
 *     (1) 이를 위한 2차원 배열변수 growthRate를 선언하고 배열객체를 생성하여 배열변수에 저장하라.
 *      
 *     (2) 배열의 행 개수와 모든 행의 열 개수를 출력하는 코드를 작성하라.     
 */
