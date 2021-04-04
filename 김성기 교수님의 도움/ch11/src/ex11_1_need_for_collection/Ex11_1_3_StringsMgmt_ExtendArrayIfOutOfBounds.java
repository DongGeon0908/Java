package ex11_1_need_for_collection;

/**
 * [ StringsMgmt_ExtendArrayIfOutOfBounds 클래스 ]: 
 *       더 많은 원소 저장하는 저장공간 확보하여 인덱스 범위 초과 예외 방지하기
 * 
 *   o 배열의 최대 저장 가능 원소보다 더 많은 원소 저장하면 인덱스 범위 초과 예외인
 *     ArrayIndexOutOfBoundsException이 발생하므로 이를 방지할 수 있도록 조치하는 예제
 *    
 *   o 저장된 배열 원소 개수 추적하여 더 이상 저장할 공간이 없으면 더 큰 배열객체 할당하여 저장 
 *     - 배열에 저장 가능한 최대 원소 개수를 저장하는 변수: MAXSTRINGS = 3;
 *     - 배열에 원소를 저장하면 저장된 원소 개수를 추적하는 변수: cntStrings
 *     - 원소를 저장할 배열객체 참조할 참조변수: strings
 *     
 *     - 저장할 공간이 있으면(cntStrings < MAXSTRINGS) 저장함 
 *     - 더 이상 저장할 공간이 없으면(cntStrings == MAXSTRINGS) 추가적인 저장공간 할당하여 저장       
 *       1) 2배의 더 많은 원소 저장 가능한 배열객체 생성
 *       2) 기존의 원소들을 새로운 배열객체에 복사
 *       3) strings가 새로운 객체 참조하게 함
 *       4) 최대 저장 개수를 증가된 최대 개수로 변경
 *    
 *   o 저장 가능한 최대 원소 개수는 3인데 main()에서 5개 원소 저장하려 함
 *     - 4번째 원소를 strings[3]에 저장하려 하면 현재 저장된 원소 개수가 최대 원소 개수와 같으므로 
 *       새로운 배열공간 확보하고 기존의 원소들을 복사한 후 저장
 */

class Ex11_1_3_StringsMgmt_ExtendArrayIfOutOfBounds {  
	static int MAXSTRINGS = 3;       // 저장 가능한 최대 원소 개수를 나타내는 변수
	static String[] strings = new String[MAXSTRINGS]; // 배열객체 생성하여 배열변수에 저장 
	static int cntStrings = 0;       // 배열변수에 저장된 원소개수를 나타내는 변수

	// 문자열 s를 String 배열 strings[]에 저장하는 메소드   
	static void addString(String s) {     
		if (cntStrings >= MAXSTRINGS) {               // 원소 저장할 공간이 없으면       
			int maxNew = MAXSTRINGS * 2;              //   원소 최대 개수 2배의 
			String[] stringsNew = new String[maxNew]; //   저장공간 확보

			copyStrings(strings, stringsNew); // 새로운 공간에 기존 원소들 복사
			
			strings = stringsNew;             // strings가 새로운 공간 참조하게 함
			MAXSTRINGS = maxNew;              // 최대 원소 개수 변경
		}

		// 이제는 원소 저장할 공간이 항상 있게 되므로 
		strings[cntStrings++] = s;           // s를 strings[]에 저장, 원소개수 1 증가
	}

	// String 배열 src[]의 모든 원소들을 String 배열 dest[]에 복사하는 메소드
	static void copyStrings(String[] src, String[] dest) {
		for (int i = 0; i< src.length; i++)  // src[]의 원소 개수만큼
			dest[i] = src[i];                //   src[]의 원소를 dest[]의 원소로 저장
	}

	public static void main(String[] args) {   
		addString("홍길동");
		addString("박문수");
		addString("이몽룡");
		addString("성춘향");
		addString("심청");
		
		System.out.print("\n  ** 저장된 이름들 **\n\n  * ");

		for (String s : strings)             // strings 배열의 모든 원소 s에 대해
			if (s != null)                   //    s null이 아니면
				System.out.print(s + "  ");  //       s 출력    
		
		System.out.println("\n\n  * MAXSTRINGS = " + MAXSTRINGS + ", cntStrings = " + cntStrings);
	}
}

/*
* [ 프로그램의 이해 및 실행 ]
*   
*   o 프로그램을 실행하여 결과를 확인하라.
*   
*   o 이 프로그램은 예외를 발생시키지는 않으며, 5개의 문자열이 모두 저장됨을 확실히 확인하라.
*   
*   o 저장 가능한 최대 원소 개수가 변경된 것을 확인하라.
*   
*   
* [ 실습과제 ]
*   
*   1) 다음과 같이 정수 10개를 저장하는 int 배열객체를 생성하여  배열변수 ints[]에 저장하라.
*   
*   	static int MAXINTS = 10;   // 저장 가능한 최대 원소 개수를 나타내는 변수
*	    static int[] ints = new int[MAXINTS];  // int 값 저장할 배열변수
*	    static int cntInts = 0;   // 배열변수에 저장된 원소 개수를 나타내는 변수
*
*   2) 여러 정수를 ints[]에 저장하고 출력하도록 다음의 메소드를 추가로 작성하라.
*      
*        static void addInts(int n)      // n을 ints[]의 끝에 저장하는 메소드로, 저장된 원소 개수가 최대 원소 개수와 같으면 
*                                        //   추가 저장공간을 확보한 후 기존 원소들을 복사한 후 ints가 참조하게 하고 n을 저장
*        static void copyInts(int[] src, int[] dest)   // int 배열 src[]의 원소들을 모두 int 배열 dest[]에 복사하는 메소드
*        
*   3) main()에서 addInt() 메소드를 11번 호출한 후 저장된 값들을 출력하고
*      MAXINTS와 cntInts 값을 출력하라.      
*/