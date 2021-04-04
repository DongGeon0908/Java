package ex11_1_need_for_collection;

import java.util.Vector;

/**
 * [ StringsMgmt_NoOutOfBoundsException_UsingVector 클래스 ]: 
 *       java.util.Vector 클래스를 사용하여 인덱스 초과 예외를 방지하기
 * 
 *  o Vector 클래스는 여러 데이터 저장하고 검색하는 편리한 기능을 제공하는 클래스 
 *    - Vector 이용하여 원소 저장할 때 저장할 원소의 최대 크기를 별도로 설정할 필요 없음
 *    - 자체적으로 원소 저장할 공간 관리하고, 더 많은 원소 저장될 필요 있으면 저장공간 추가로 확보
 *    
 *  o Vector 클래스의 객체 생성과 참조
 *    - Vector<원소_클래스> 객체참조변수 = new Vector<원소_클래스>();
 *    - Vector 클래스는 제네릭 클래스이므로 저장할 원소의 클래스 선언 시 <와 > 사이에 명시
 *    
 *    - Vector<String> strings = new Vector<String>(); // <String>은 원소 클래스 표시 
 *    
 *  o Vector 클래스의 주요 메소드  
 *    - 원소 추가하는 메소드
 *      1) add(E element) 메소드: 벡터의 마지막 위치에 원소 element 저장
 *         특히 이때 저장할 공간 없으면 자동적으로 공간 확보하여 원소 저장
 *      2) add(int index, E element) 메소드: Vector의 위치 index에 원소 element 추가
 *         추가되는 위치부터 원소들을 뒤로 하나씩 이동시킴 
 *              
 *    - 저장 및 검색을 위한  메소드
 *      1) get(int index) 메소드: Vector에서 위치 index의 원소 반환
 *      2) set(int index, E element) 메소드: Vector의 위치 index의 원소를 element로 대체시킴
 *      3) size() 메소드: 현재 저장된 원소 개수 반환 
 *      
 *    - Vector 객체에 저장된 원소를 제거하기 위한 메소드
 *      1) remove(int index) 메소드: index 위치의 원소 삭제하고 삭제된 원소 반환
 *         삭제 위치 이부터의 원소들을 앞으로 하나씩 이동시킴     
 *      
 *  o main()에서 문자열 5개를 Vector 객체에 저장한 후 저장된 모든 원소 출력
 *    
 */

class Ex11_1_4_StringsMgmt_NoOutOfBoundsException_UsingVector { 
	public static void main(String[] args) {   
		// 문자열 저장하는 Vector 객체 생성하여 strings가 참조
		// <String>은 원소 클래스 표시 
		Vector<String> strings = new Vector<String>(); 

		strings.add("홍길동");
		strings.add("박문수");
		strings.add("이몽룡");
		strings.add("성춘향");
		strings.add("심청");
		
		System.out.print("\n  ** 저장된 이름들(for 문으로 출력) **\n\n  * ");

		for (int i =0; i < strings.size(); i++) {  // strings에 저장된 원소 개수만큼
			String s = strings.get(i);             //   인덱스 i의 원소 구하여
			System.out.print(s + " ");             //   s 출력 
		}   
		
		System.out.print("\n\n\n  ** 저장된 이름들(Vector 객체 출력) **\n\n  * ");
		System.out.print(strings);		
	}
}

/*
* [ 프로그램 이해 및 실행 ]
*   
*   1) 프로그램을 실행하여 결과를 확인하라.
*   
*   2) 2명의 이름을 strings에 추가하도록 프로그램을 변경하고 결과를 확인하라.
*   
*   3) Vector로 여러 데이터를 관리하는 것이 배열로 관리하는 것보다 훨씬 편리함을 확인하라.
*   
*   
* [ 실습과제 ]
*   
*   1) main() 메소드에 다음과 같이 Integer 객체를 저장하는 Vector 객체 생성하여 참조변수
*     ints에 저장하라.
*     
*       Vector<Integer> ints = new Vector<Integer>();
*       
*   2) 다음의 for 문 이용하여 ints.add() 메소드를 10001번 호출한 후 저장하라. 
*       ( add() 메소드의 매개변수는 Integer 객체이지만 자동 박싱 이루어지므로 정수도 가능)  
*       
*      for (int i = 0;  i < 10001; i++) 
*          ints.add(i);
*
*   3) 다음의 for 문 이용하여 ints에 저장된 원소들을 출력하라. 
*   
*      for ( int i = 0;  i < ints.size(); i++) 
*          System.out.println(ints.get(i) + " ");
*
*   4) int capacity() 메소드는 Vector의 최대 저장 개수 반환한다. 최대 저장 개수 출력하여 
*      확인하라. (초기 최대 저장 개수 10개에서 2배씩 늘어난 결과로 10 * 1024 = 10240임)
*/
