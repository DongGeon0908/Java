/**
 * 
 * [ Sort_UsingRecursiveMethod ] 재귀 메소드를 이용하여 배열 원소들 정렬하기
 * 
 *   o 여러 정수를 입력하여 크기순으로 정렬하여 출력하기 위한 프로그램 작성
 *     - n개의 원소 갖는 배열을 정렬하는 메소드와 n개의 원소 갖는 배열에서 최대값의 인덱스 반환하는 메소드를
 *       재귀 메소드로 작성
 *     
 *   o 재귀 메소드
 *     - 메소드 구현에서 자신을 호출하는 메소드
 *     - 재귀 메소드 호출되면 특수 조건 만족할 때가지 연속적으로 재귀 메소드 호출
 *     - 특수 조건에 도달하면 연쇄적으로 호출된 메소드 반환    
 *     
 *   o void sort(int[] ints, int n): n개의 원소 갖는 배열을 정렬하는 재귀 메소드 
 *     - 정렬할 원소 개수가 1개이면 정렬할 필요 없음
 *     - 정렬할 원소 개수 n이 2개 이상이면
 *       (1) n-1개 중 최대 원소 위치 구함
 *       (2) n-1개 중 최대 원소가 n번째 원소보다 크면 이들 위치 교환(가장 큰 값이 n번째에 위치함)
 *       (3) n-1개의 원소에 대해 sort() 메소드로 동일한 방법으로 정렬 
 *           
 *   o int getMax(int[] ints, int n): n개의 원소 갖는 배열에서 최대값의 인덱스 반환하는 재귀 메소드
 *     - 최대값 구할 원소 개수가 1개이면 0 위치의 원소가 최대값이므로 이를 반환
 *     - 최대값 구할 원소 개수 n이 2개 이상이면
 *       (1) n-1 개의 원소들 중의 최대 원소의 인덱스를 getMax() 메소드로 구함
 *       (2) n-1 개의 원소들 중의 최대 원소와 n번째 원소 중 큰 원소의 인덱스를 반환(가장 큰 원소의 인덱스가 구해짐)
 */

public class Ex5_6_2_Sort_UsingRecursiveMethod {
	public static void main(String[] args) { 
		System.out.println("\n  ** 배열을 이용한 15개 정수의 정렬 **");

		// inputInts()에서 입력된 원소들이 저장된 배열을 반환받아 출력
		int[] scores = inputInts(15);  
		outputInts(scores, "\n  * scores 배열에 저장된 점수들 : ");  

		// 배열에 저장된 원소들을 크기순으로 정렬하여 출력
		sort(scores);
		outputInts(scores, "\n  * 오름차순으로 정렬된 점수들: ");  
	}

	// n개의 정수를 저장할 배열 객체를 생성하고 원소들을 입력하여 배열에 저장하여 배열을 반환
	static int[] inputInts(int n) {
		int[] ints = new int[n];          // n개 정수 저장할 배열객체 생성하여 ints 배열에 저장

		for (int i = 0; i < n; i++) {
			if (n > 10 && i % 10 == 0)    // 한 라인에 10개씩 입력받게 함
				System.out.print((n - i >= 10) ? "\n  o 10개 정수 입력 > " : "  o " + n % 10 + "개 정수 입력 > "); 
 
			ints[i] = SkScanner.getInt(); // 정수 입력하여 ints 배열 원소로 저장
		}

		return ints;  // 배열을 반환
	}

	// title과 정수 배열변수 ints에 저장된 모든 원소를 한 라인에 출력하는 메소드
	static void outputInts(int[] ints, String title) {
		System.out.print(title);                 // title 출력
 
		for (int i = 0; i < ints.length; i++) 
			System.out.print(ints[i]  + "  ");   // ints 배열의 각 원소를 출력

		System.out.println();     
	}

	// ints[] 배열의 원소들을 정렬시킴, sort(int[] ints, int n) 메소드 이용
	static void sort(int[] ints) {
		sort(ints, ints.length);
	}

	// ints[] 배열의 앞쪽 n개 원소들을 정렬시킴, 자신을 호출하는 재귀 메소드로 작성
	static void sort(int[] ints, int n) {
		if (n == 1)  // 정렬할 원소가 1개이면(특수 조건 만족하면) 
			return;  // 정렬할 필요가 없음

		int maxPos = getMax(ints, n - 1); // 앞쪽 n-1개 중 최대 원소 인덱스 구함
		
		if (ints[maxPos] > ints[n-1]) {   // 앞쪽 n-1개 원소 중 최대 원소가 n번째 원소보다 크면
			int temp = ints[maxPos];  	  //   n-1개의 최대 원소와 n번째 원소 교환 
			ints[maxPos] = ints[n-1];     //   ==> n번째 원소가 최대 원소가 되게 함
			ints[n-1] = temp;
		}

		sort(ints, n - 1);  // 앞쪽 n-1개를 다시 정렬시킴
	}

	// ints[] 배열 n개의 원소들 중 최대 원소 인덱스를 반환, 재귀 메소드로 작성
	static int getMax(int[] ints, int n) {
		if (n == 1)       // 원소가 1개이면(특수 조건 만족하면)
			return 0;     // 그 원소가 최대이므로 0을 반환

		int maxPos = getMax(ints, n - 1); // 앞쪽 n-1개 중 최대 원소의 인덱스 maxPos 구함 

		if (ints[n-1] > ints[maxPos])     // n번째 원소가 앞쪽 (n-1)개 최대 원소보다 크면
			return n - 1;        	      //   n번째 원소가 최대 원소이므로 인덱스 n-1 반환
		else
			return maxPos;      	      //   아니면 n-1개 원소 중 최대 원소의 인덱스 maxPos 반환
	}
}



/*
 * [ 프로그램의 이해 및 실행 ]
 * 
 *   1) 재귀 메소드를 이용하여 배열 원소들을 정렬하기 위한 프로그램이다.
 *     
 *     - void sort(int[] ints, int n): n개 원소 갖는 배열을 정렬하는 재귀 메소드 
 *     - int getMax(int[] ints, int n): n개 원소 갖는 배열에서 최대값의 인덱스 반환하는 재귀 메소드
 *     
 *   2) 여기에 작성된 재귀 메소드를 이해하도록 노력하라.
 */
