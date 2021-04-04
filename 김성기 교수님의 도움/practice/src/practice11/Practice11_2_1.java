package practice11;

/**
 * [ 11장 실습과제 2의 소스 프로그램 ]
 * 
 *   2. 배열과 벡터 활용하기
 *   
 *      다음은 학생 점수를 addInt() 메소드를 이용하여 ints 필드에 저장하고 출력한다.
 *   
 *      1) 이 프로그램을 살펴보고 문제점이 무엇인지 설명하라..
 *         
 *      2) ints 배열변수가 참조하는 배열객체에 저장할 수 있는 최대 원소개수보다 더 많은 원소가
 *         저장될 수 있도록 addInt(int n) 메소드를 변경한 클래스를  Practice11_2_2로 작성하라. 
 *         
 *         이를 위해 ints 배열변수가 참조하는 배열객체를 더 많은 원소를 저장할 수 있는 배열객체로 변경하고 
 *         기존의 배열객체의 원소를 새로운 배열객체의 원소로 복사한다.
 *         
 *      3) ints 배열에 원소를 저장하지 않고 Vector 객체에 원소들을 저장하도록 변경한 클래스를
 *         Practice11_2_3으로 작성하라. 
 */

class Practice11_2_1 { 
	static int MAXINTS = 5;  				// 저장 가능한 최대 원소 개수 나타내는 변수
	static int[] ints = new int[MAXINTS];	// 정수 저장 배열변수
	static int cntInts = 0;       			// 배열변수에 저장된 원소개수를 나타내는 변수

	// n을 int 배열 ints[]에 저장하는 메소드        
	static void addInt(int n) {
		// 첨가할 원소 공간이 있으면 저장하고 없으면 저장하지 않음
		if (cntInts < MAXINTS)
			ints[cntInts++] = n;			// n을 배열에 저장하고 원소개수 1 증가
	}

	public static void main(String[] args) {   
		int[] scores = { 90, 91, 88, 87, 83, 78, 99, 76, 45, 67, 88, 12 };

		for (int i = 0; i < scores.length; i++)
			addInt(scores[i]);

		for (int n : ints)          		// ints 배열의 모든 원소 n에 대해
			System.out.print(n + " ");		//    n 출력    
	}
}
