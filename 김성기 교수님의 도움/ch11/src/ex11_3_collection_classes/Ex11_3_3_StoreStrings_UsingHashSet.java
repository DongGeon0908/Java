package ex11_3_collection_classes;

import java.util.*;

/**
 * [ StoreStrings_UsingHashSet 클래스 ]: 
 *      java.util.HashSet 클래스의 객체에 원소 저장하고 원소들 출력하기
 *      
 *  o HashSet 클래스
 *    - 중복되지 않는 여러 데이터 저장하고 검색하는 편리한 기능 제공하는 클래스 
 *    - HashSet 이용하여 원소 저장할 때에는 저장할 원소의 최대 크기를 별도로 설정할 필요가 없음
 *    - 자체적으로 원소 저장할 공간 관리하고, 더 많은 원소가 저장될 필요가 있으면 저장 공간 추가로 확보함
 *    - 저장된 위치 지정할 수 없으며 중복된 원소 저장할 수 없는 집합을 구현하는 클래스
 *         
 *  o HashSet 클래스의 주요 메소드
 *     - boolean add(E element) 메소드: 원소 element 저장
 *         특히 이때 저장할 공간이 없으면 자동적으로 공간 확보하여 원소 저장
 *     - boolean contains(Object o)  메소드: 객체 o가 원소에 포함되면 true 반환, 
 *         그렇지 않으면 false 반환
 *     - size() 메소드: 현재 저장된 원소 개수 반환     
 *     - remove(Object o) 메소드: 객체 o가 원소에 포함되면 이를 삭제하고 true 반환, 
 *         그렇지 않으면 false 반환   
 *      
 *  o main()에서 이름 5개를 HashSet 객체에 저장한 후 출력
 */

class Ex11_3_3_StoreStrings_UsingHashSet {  
	public static void main(String[] args) {   
		// 문자열을 원소로 저장할 HashSet 객체 생성하여  strings가 참조하게 함 
		HashSet<String> strings = new HashSet<String>(); 

		// 5개 이름 6번 저장하기 
		strings.add("홍길동");
		strings.add("박문수");
		strings.add("이몽룡");
		strings.add("성춘향");
		strings.add("심청");
		strings.add("심청");

		System.out.print("\n  ** HashSet의 모든 원소 출력하기(for each 문 사용) **\n\n  * "); 

		for (String s : strings)          // strings의 각 원소인 문자열 s에 대해
			System.out.print(s + " ");    //   s 출력  
				
		System.out.print("\n\n\n  ** HashSet의 모든 원소 출력하기(iterator() 메소드 사용) **\n\n  * "); 

		Iterator<String> it = strings.iterator(); // hashSet 객체를 Iterator 객체로 변환하여 
		while(it.hasNext())                       // 다음 원소가 있으면 
			System.out.print(it.next() + " ");    //   다음 원소 출력  
	}
}

/*
* [ 프로그램의 이해 및 실행 ]
*   
*   1) 프로그램을 실행하여 결과를 확인하라.
*   
*   2) 2명의 이름을 strings에 추가하여 저장하도록 프로그램을 변경하고 결과를 확인하라.
*   
*   3) 출력된 결과를 잘 살펴보고 저장된 순서와 출력되는 순서가 상관관계가 없음을 확인하라.
*   
*   4) 심청이 2번 저장되었지만 출력이 한번만 되어 동일한 원소는 한번만 저장됨을 확인하라.
*/