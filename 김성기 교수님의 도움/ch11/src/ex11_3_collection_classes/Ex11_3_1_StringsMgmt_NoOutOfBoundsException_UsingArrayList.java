package ex11_3_collection_classes;

import java.util.ArrayList;

/**
 * [ StringsMgmt_NoOutOfBoundsException_UsingArrayList 클래스 ]: 
 *       java.util.ArrayList 클래스 사용하여 인덱스 초과 예외 방지하기
 * 
 *   o UsingArrayList 클래스는 여러 데이터 저장하고 검색하는 편리한 기능 제공하는 클래스
 *     - ArrayList 이용하여 원소 저장할 때 저장할 원소의 최대 크기를 별도로 설정할 필요 없음
 *     - 자체적으로 원소 저장할 공간 관리하고, 더 많은 원소가 저장될 필요가 있으면 저장공간 추가로 확보
 *     - Vector 클래스와 기능이나 메소드 등이 유사하지만 Vector는 동기화 지원하는 반면
 *       ArrayList는 동기화 지원하지 않음
 *    
 *   o ArrayList 클래스의 객체 생성과 참조
 *     - ArrayList<원소_클래스> 객체참조변수 = new ArrayList<원소_클래스>();
 *     - ArrayList 클래스는 제네릭 클래스이므로 저장할 원소의 클래스를 선언 시 <와 > 사이에 명시
 *    
 *     - ArrayList<String> strings = new ArrayList<String>(); // <String>은 원소 클래스 표시 
 *    
 *   o ArrayList 클래스의 주요 메소드  
 *     - 원소 추가하는 메소드
 *       1) add(E element) 메소드: 벡터의 마지막 위치에 원소 element 저장
 *          특히 이때 저장할 공간 없으면 자동적으로 공간 확보하여 원소 저장
 *       2) add(int index, E element) 메소드: ArrayList의 위치 index에 원소 element를 추가
 *          추가되는 위치부터의 원소들을 하나씩 뒤로 이동시킴 
 *              
 *     - 저장 및 검색 위한  메소드
 *       1) get(int index) 메소드: ArrayList에서 위치 index의 원소 반환
 *       2) set(int index, E element) 메소드: ArrayList의 위치 index의 원소를 element로 대체시킴
 *       3) size() 메소드: 현재 저장된 원소 개수 반환 
 *      
 *     - ArrayList 객체에 저장된 원소 제거하기 위한 메소드
 *       1) remove(int index) 메소드: index 위치의 원소 삭제하고 삭제된 원소 반환
 *          삭제 위치 이부터의 원소들을 하나씩 앞으로 이동시킴     
 *      
 *   o main()에서 문자열 5개를 ArrayList 객체에 저장한 후 저장된 모든 원소 출력
 */

class Ex11_3_1_StringsMgmt_NoOutOfBoundsException_UsingArrayList { 
	public static void main(String[] args) {   
		// 문자열을 저장하는 ArrayList 객체를 생성하여 strings가 참조하게 함
		// <String>은 원소 클래스 표시 
		ArrayList<String> strings = new ArrayList<String>(); 

		// 5개의 이름 저장하기 
		strings.add("홍길동");
		strings.add("박문수");
		strings.add("이몽룡");
		strings.add("성춘향");
		strings.add("심청");

		System.out.print("\n  ** ArrayList의 모든 원소 출력하기(for 문 사용) **\n\n  * "); 
		
		for (int i = 0; i < strings.size(); i++) {  // strings에 저장된 원소 개수만큼
			String s = strings.get(i);              // 인덱스 i의 원소 구하여
			System.out.print(s + " ");              //   s 출력 
		}   
		
		System.out.print("\n\n\n  ** ArrayList의 모든 원소 출력하기(for each 문 사용)\n\n  * ");   
		
		for (String s : strings)                    // strings에 저장된 각 원소 s에 대해
			System.out.print(s + " ");              //   s 출력 
		
		System.out.print("\n\n\n  ** ArrayList의 모든 원소 출력하기(ArrayList 객체 출력)\n\n  * ");   
		System.out.print(strings);              //   strings 출력 

	}
}

/*
* [ 프로그램의 이해 및 실행 ]
*   
*   1) 프로그램을 실행하여 결과를 확인하라.
*   
*   2) 2명의 이름을 strings에 추가하도록 프로그램을 변경하고 결과를 확인하라.
*   
*   3) ArrayList로 여러 데이터를 관리하는 것이 배열로 관리하는 것보다 훨씬 편리함을 확인하라.
*   
*   4) Vector로 데이터를 관리하는 것과 ArrayList로 데이터를 관리하는 것이 거의 유사함을 확인하라.  
*/