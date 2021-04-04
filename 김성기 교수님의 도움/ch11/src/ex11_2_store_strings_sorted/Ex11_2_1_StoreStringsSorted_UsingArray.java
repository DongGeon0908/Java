package ex11_2_store_strings_sorted;

/**
 * [ StoreStringsSorted_UsingArray 클래스 ]: 
 *        배열 이용하여 크기순으로 문자열 저장하기
 * 
 *   o 배열 이용하여 크기순으로 문자열 저장하기 위한 과정
 *     1) 저장할 문자열의 크기 순서에 맞는 저장 위치 탐색
 *     2) 저장 위치부터의 문자열들 하나씩 뒤로 자리 이동하여 저장공간 확보
 *     3) 저장할 문자열을 확보된 위치에 저장
 *    
 *   o 문자열 크기 비교를 위한 메소드 int compareTo(String this, String s)
 *     - 수신자 객체 this와 매개변수에 주어진 s를 비교하여 정수 값 반환
 *     - 수신자 객체가 크면 양수 반환
 *     - 수신자 객체와 s가 같으면 0 반환   
 *     - 수신자 객체가 작으면 음수 반환
 */

class Ex11_2_1_StoreStringsSorted_UsingArray { 
	static int MAXSTRINGS = 10;    // 저장 가능한 최대 원소 개수를 나타내는 변수
	static String[] strings = new String[MAXSTRINGS];  
	static int cntStrings = 0;     // 배열변수에 저장된 원소개수를 나타내는 변수

	// 문자열 s를 String 배열 strings[]에 크기순으로 저장하는 메소드
	static void addStringSorted(String s) {     
		int pos = getPosToAdd(s);  // s의 크기순 저장 위치 탐색하여 저장위치 pos 구함           
		shiftBack(pos);            // pos 위치부터 한 자리씩 뒤로 위치 이동시킴
		storeStringTo(pos, s) ;    // 공간 확보된 pos 위치에 s 저장
	}

	// strings[] 배열에서 s를 크기순으로 저장할 위치 탐색하여 반환하는 메소드
	// (strings[]에는 문자열들이 크기 순서대로 이미 저장되어 있는 상태임)
	static int getPosToAdd(String s) {
		int i; 
		for (i = 0; i < cntStrings; i++)     // strings[]의 각 원소에 대해
			if (strings[i].compareTo(s) > 0) //   위치 i의 원소 크기가 처음으로 s보다 크면                    
				return i;                    //     그 위치 i가 s 저장 위치임

		return i;    // strings의 원소가 없거나 마지막 위치에 저장될 경우 i 반환
	}   

	// 위치 n부터의 원소들을 뒤로 하나씩 이동시키는 메소드
	static void shiftBack(int n) {
		for (int i = cntStrings; i > n; i--) // 마지막 위치부터 위치 n까지
			strings[i] = strings[i-1];       //   한 자리씩 뒤로 이동시킴
	}

	// n 위치에 문자열 저장하고 cntStrings 1 증가시키는 메소드
	static void storeStringTo(int n, String s) {
		strings[n] = s;
		cntStrings++;
	} 

	public static void main(String[] args) {   
		// 5개의 이름을 크기순으로 저장하기 위해 addStringSorted() 메소드 호출
		addStringSorted("홍길동");
		addStringSorted("박문수");
		addStringSorted("이몽룡");
		addStringSorted("심청");

		System.out.print("\n  ** 정렬된 이름들 **\n\n  * ");
		
		for (int i =0; i < cntStrings; i++) { // strings에 저장된 원소 개수만큼
			String s = strings[i];            //    인덱스 i의 원소 구하여
			System.out.print(s + " ");        //    s 출력 
		}   
	}
}
  
/*
 * [ 프로그램의 이해 및 실행 ]
 *   
 *   1) 프로그램을 실행하여 결과를 확인하라.
 *   
 *   2) 이 프로그램은 이름을 크기순으로 저장하고 출력한다. 이를 위하여 
 *      int getPosToAdd(String s), void shiftBack(int n), 
 *      void storeStringTo(int n, String s) 등의 메소드가 작성되어 있다.
 *      
 *      각 메소드의 기능을 정확히 파악하라.
 *     
 *     
 * [ 실습과제 ]
 *   
 *   o 주어진 프로그램을 참고하여 여러 정수를 크기순으로 저장하는 프로그램을 
 *     Pr11_2_1_StoreIntsSorted_UsingArray 클래스로 작성하라.
 *      
 *     이를 위하여 최대 정수 20개 저장하는 int 배열객체를 생성하여 배열변수 ints[]에 저장하고
 *     정수들을 크기순으로 저장하기 위해 필요한 메소드를 추가로 작성하라.
 *     
 *     main() 메소드에서 10개의 정수를 크기순으로 저장하도록 작성된 메소드를 호출하고 저장된 결과를 출력하라.
 */