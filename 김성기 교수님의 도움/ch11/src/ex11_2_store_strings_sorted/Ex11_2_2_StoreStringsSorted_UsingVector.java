package ex11_2_store_strings_sorted;

import java.util.Vector;

/**
 * [ StoreStringsSorted_UsingVector 클래스 ]: 
 *       java.util.Vector 이용하여 크기순으로 문자열 저장하기
 * 
 *   o Vector을 이용하여 크기순으로 문자열 저장하기 위한 과정
 *     1) 저장할 문자열의 크기순서에 맞는 저장될 위치 탐색
 *     2) 저장될 위치에 문자열을 add(int n, Object o) 메소드 이용하여 바로 저장
 *     
 *   o Vector 클래스의 void add(int pos, E e) 메소드
 *     - 벡터의 주어진 위치 pos에 원소 e 저장
 *     - 이 때, pos 위치부터 끝까지 원소들을 뒤로 하나씩 이동함
 *     - 
 *      
 *   o 문자열 크기 비교를 위한 메소드 int compareTo(String this, String s)
 *     - 수신자 객체 this와 매개변수에 주어진 s 비교하여 정수 값 반환
 *     - 수신자 객체가 크면 양수 반환
 *     - 수신자 객체와 s가 같으면 0 반환   
 *     - 수신자 객체가 작으면 음수 반환
 */

class Ex11_2_2_StoreStringsSorted_UsingVector { 
	// 문자열을 원소로 저장할 Vector 객체 생성하여 strings가 참조하게 함 
	static Vector<String> strings = new Vector<String>(); 

	// 문자열 s를 Vector 객체 strings에 크기순으로 저장하는 메소드
	static void addStringSorted(String s) {     
		int pos = getPosToAdd(s); // s의 크기순 저장 위치를 탐색하여 저장위치 pos 구함 
		strings.add(pos, s);       // strings의 pos 위치에 s 저장
	}

	// strings에서 s를 이름순으로 저장할 위치를 탐색하여 반환하는 메소드
	// (strings에는 문자열들이 이름 순서대로 저장되어 있음)
	static int getPosToAdd(String s) {
		int i; 
		for (i = 0; i < strings.size(); i++)     // strings의 각 문자열 원소에 대해
			if (strings.get(i).compareTo(s) > 0) //   위치 i의  원소 크기가  s보다 크면   
				return i;                        //   그 위치 i가 s 저장 위치임

		return i; // strings의 원소가 없거나 마지막에 저장될 경우
	}

	public static void main(String[] args) {   
		// 5개의 이름을 크기순으로 저장하기 위해 addStringSorted() 메소드 호출
		addStringSorted("홍길동");
		addStringSorted("박문수");
		addStringSorted("이몽룡");
		addStringSorted("성춘향");
		addStringSorted("심청");

		System.out.print("\n  ** 정렬된 " + strings.size() + "개 이름 **\n\n  * ");
		
		for (int i = 0; i < strings.size(); i++)     // strings.size() 개수의 원소에 대해
			System.out.print(strings.get(i)+ " ");   //  i 위치 원소를 출력
	}
}

/*
 *   
 * [ 프로그램의 이해 및 실행 ]
 *   
 *   1) 프로그램을 실행하여 결과를 확인하라.
 *   
 *   2) 이 프로그램은 이름을 크기 순으로 저장하고 출력하는데, 배열을 사용한 프로그램보다는 훨씬 간단하다.
 *      그 이유가 무엇인가를  파악하라.
 *      
 * [ 실습과제 ]
 *   
 *   1) 주어진 프로그램을 참고하여 여러 정수를 크기 순으로 저장하고 출력하는 프로그램을 
 *      Pr11_2_1_StoreIntsSorted_UsingVector 클래스로 작성하라.
 *      
 *      이를 위하여 Integer 객체를 저장하는 Vector 객체를 생성하여 Vector 참조변수 ints에 저장한 후
 *      정수들을 크기순으로 저장하기 위해 필요한 메소드 addIntSorted(int n)을 작성하라. 
 *      main() 메소드에서 10개의 정수를 크기순으로 저장하도록 작성된 메소드를 호출하고 저장된 결과를 출력하라.
 *      
 *      
 * [ 참고사항 ]
 *  
 *   1) Vector 객체에는 int, double 등 기본타입 값을 저장하지 못하며, 기본 타입의 래퍼 객체들을 저장하여야 한다. 
 *      그러므로 int 값을 저장하기 위해서는 다음과 같은 Vector 객체 생성과 참조변수 선언이 필요하다.
 *           
 *      Vector<Integer> ints = new Vector<Integer>;  // int 값을 원소로 저장하기 위한 참조변수 선언
 *                     
 *   2) Vector에는 Integer 객체가 저장되지만 addIntSorted(int n) 메소드의 매개변수는 int 타입이다.
 *      이 메소드의 매개변수로 주어진 n이 Vector 객체 ints에 저장되어야 한다. 
 *         
 *      Java에서의 자동 박싱(auto-boxing)은 int 타입의 정수 값을 Integer 객체로 자동적으로 변환시키므로  
 *      Vector 클래스의 add() 메소드를 이용하여 int 값 n을 Vector 객체 ints에 추가할 수 있다.    
 */
