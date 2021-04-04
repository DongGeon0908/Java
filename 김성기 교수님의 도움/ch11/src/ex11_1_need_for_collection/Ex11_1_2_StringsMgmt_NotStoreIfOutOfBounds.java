package ex11_1_need_for_collection;

/**
 * [ StringsMgmt_NotStoreIfOutOfBounds 클래스 ]: 
 *       배열의 저장 가능한 최대 원소 개수보다 더 많은 원소 저장하지 않도록 하여 인덱스 범위 초과 오류 방지하기
 * 
 *   o 배열의 저장 가능한 최대 원소 개수보다 더 많은 원소 저장하려 하면 인덱스 범위 초과 예외인
 *     ArrayIndexOutOfBoundsException이 발생하므로 이를 방지할 수 있도록 조치하는 예제
 *    
 *   o 저장된 배열 원소 개수를 추적하여 더 이상 저장할 공간 없으면 저장하지 않고 무시함 
 *     - 배열에 저장 가능한 최대 개수를 저장하는 변수: MAXSTRINGS = 3;
 *     - 원소 저장할 배열객체 참조할 참조변수: strings
 *     - 배열에 원소 저장하면 저장된 원소 개수 추적하는 변수: cntStrings
 *     
 *     - 저장할 공간이 있으면(cntStrings < MAXSTRINGS) 저장
 *     - 더 이상 저장할 공간이 없으면(cntStrings >= MAXSTRINGS) 저장하지 않음    
 *    
 *   o 저장 가능한 최대 원소 개수는 3인데 main()에서 5개 원소 저장하려 함
 *     - 이 예에서 최대 저장 가능 원소 개수는 3인데 5개의 원소 저장하려 함
 *     - 4번째 원소와 5번째 원소를 strings[3]에 저장하려 하면 현재 저장된 원소 개수가 최대 원소 개수와 같으므로 
 *       배열에 저장하지 않음
 */

class Ex11_1_2_StringsMgmt_NotStoreIfOutOfBounds {  
	static int MAXSTRINGS = 3;             // 저장 가능한 최대 원소 개수 나타내는 변수
	static String[] strings = new String[MAXSTRINGS]; // String 저장 배열변수
	static int cntStrings = 0;             // 배열변수에 저장된 원소개수 나타내는 변수

	// 문자열 s를 String 배열 strings[]에 저장하는 메소드   
	static void addString(String s) {
		// 원소 저장할 공간 있으면 저장하고 없으면 저장하지 않음
		if (cntStrings < MAXSTRINGS)
			strings[cntStrings++] = s;     // s를 strings[]에 저장하고 원소개수 1 증가
	}

	public static void main(String[] args) {   
		addString("홍길동");
		addString("박문수");
		addString("이몽룡");
		addString("성춘향");
		addString("심청");

		System.out.print("\n  ** 저장된  이름들 **\n\n  * ");
		
		for (String s : strings)            // strings 배열의 모든 원소 s에 대해
			if (s != null)                  //  s가 null이 아니면
				System.out.print(s + " ");  //   s 출력    
	}
}

/*
* [ 프로그램의 이해 및 실행 ]
*   
*   1) 프로그램을 실행하여 결과를 확인하라.
*   
*   2) 이 프로그램은 예외를 발생시키지는 않지만 5개의 String 객체 중에서 3개만 저장되고 2개는 저장되지
*      않음을 확실히 확인하라.
*      
*   3) 이 프로그램은 예외를 발생시키지는 않지만 5개의 문자열 중에서 3개만 저장되고 2개는 저장되지
*      않는다. 
*      
*      이로 인한 문제가 무엇인지 생각하여 보라.
*
*   
* [ 실습과제 ]
*   
*   1) 다음과 같이 정수 10개를 저장하는 int 배열객체를 생성하여 배열변수 ints[]에 저장하라.
*      
*         static int MAXINTS = 10;       // 저장 가능한 최대 원소 개수를 나타내는 변수
*         static int[] ints = new int[MAXINTS];  // int 값 저장할 배열변수
*         static int cntInts = 0;        // 배열변수에 저장된 원소 개수를 나타내는 변수
*  
*   2) 여러 정수를 ints[]에 저장하고 출력하도록 다음의 메소드를 추가로 작성하라.
*          
*         static void addInt(int n)     // n을 ints[]의 끝에 저장하는 메소드로 원소 개수가 
*                                       // 최대 원소 개수와 같으면 더 이상 저장하지 않음
*           
*   3) main()에서 addInt() 메소드를 11번 호출한 후 저장된 값들을 출력하고 MAXINTS와 cntInts 값을 출력하라.        
*/