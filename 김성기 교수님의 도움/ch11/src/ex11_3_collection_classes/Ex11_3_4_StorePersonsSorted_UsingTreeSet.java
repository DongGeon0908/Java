package ex11_3_collection_classes;

import java.util.TreeSet;

/**
 * [ StorePersonsSorted_UsingTreeSet 클래스 ]: 
 *       java.util.TreeSet 클래스의 객체에 원소를 저장하고 정렬된 원소들을 출력하기

 *   o TreeSet 클래스
 *     - 중복되지 않는 여러 데이터를 미리 정해진 크기 순서대로 저장하고 검색하는 편리한 기능 제공하는 클래스 
 *     - TreeSet 이용하여 원소를 저장할 때 저장할 원소의 최대 크기 별도로 설정할 필요가 없음
 *     - 자체적으로 원소 저장할 공간 관리하고, 더 많은 원소가 저장될 필요가 있으면 저장 공간 추가로 확보함
 *     - 저장된 위치 지정할 수 없으며 중복된 원소 저장할 수 없는 집합을 구현
 *    
 *   o TreeSet에 저장되는 원소들의 크기 순으로 저장하는 방법
 *     - TreeSet 객체에 원소 저장하기 위해 원소 클래스는 java.lang.Comparable 인터페이스를 구현하는 클래스여야함
 *     - Comparable 인터페이스의 abstract 메소드인 compareTo() 메소드를 반드시 구현해야 함  
 *     - 수신자 원소와 저장된 원소의 비교를 통해 수신자 원소의 크기 순서상 저장 위치가 결정됨   
 *     
 *     - name 필드의 오름차 순으로 저장하기
 *     
 *     	   public int compareTo(PersonComparable p) {  
 *             // 수신자 원소 name 필드와 저장된 원소의 name 필드 비교하여 오름차 순으로 저장하게 함
 *	          return this.name.compareTo(p.name);  
 *         }
 *         
 *    - age 필드의 내림차 순으로 저장하기
 *     
 *     	   public int compareTo(PersonComparable p) {  
 *            // 수신자 원소 필드와 저장된 원소의 age 필드 비교하여 내림차 순으로 저장하게 함
 *	          return p.age - this.age;  
 *         }
 *       
 *   o TreeSet 클래스의 주요 메소드
 *     - boolean add(E element) 메소드: 크기 순으로 정렬하여 원소 element 저장
 *                                     특히 이때에 저장할 공간이 없으면 자동적으로 공간을 확보하여 원소 저장
 *    - boolean contains(Object o) 메소드: 객체 o가 원소에 포함되면 true 반환, 그렇지 않으면 false 반환
 *    - size() 메소드: 현재 저장된 원소 개수 반환     
 *    - remove(Object o) 메소드: 객체 o가 원소에 포함되면 이를 삭제하고 true 반환, 
 *                             그렇지 않으면 false 반환 
 *          
 *  o main()에서 TreeSet 객체에 이름 5개 저장한 후 출력함
 */

// PersonComparable 클래스: TreeSet의 원소로 저장하기 위한 Person 클래스의 하위 클래스
//  - TreeSet의 원소로 저장하기 위해서는 반드시 Comparable 인터페이스 구현해야 하므로
//    이 클래스는 << class PersonComparable implements Comparable<PersonComparable> >>로 정의됨
//  - 필드 name, age, currentLocation, 메소드 goTo(), output()을 갖는 클래스
class PersonComparable extends Person implements Comparable<PersonComparable> {

	// 이름, 나이, 장소가 주어지면 필드에 저장하는 객체 생성자
	//   상위 클래스인 객체 생성자 Person(String name, int age) 호출
	PersonComparable(String name, int age) {
		super(name, age);
	}
	
	// java.lang.Comparable 클래스의 추상 메소드 compareTo()를 구현하는 메소드 
	//  name 필드의 오름차 순으로 순서를 결정하기 위해
	//  this와 매개변수 p의 name 크기 비교하여 크면 양수, 같으면 0, 작으면 음수 반환
	public int compareTo(PersonComparable p) {  
		return this.name.compareTo(p.name);  
	}
}

class Ex11_3_4_StorePersonsSorted_UsingTreeSet {  
	public static void main(String[] args) {   
		// PersonComparable 객체를 원소로 저장할 TreeSet 객체 생성하여  persons가 참조하게 함 
		TreeSet<PersonComparable> persons = new TreeSet<PersonComparable>(); 

		// 5개의 PersonComparable 객체를 persons에 저장 
		persons.add( new PersonComparable("홍길동", 18));
		persons.add( new PersonComparable("박문수", 23));
		persons.add( new PersonComparable("이몽룡", 16));
		persons.add( new PersonComparable("성춘향", 14));
		persons.add( new PersonComparable("심청", 20));

		System.out.print("\n  ** TreeSet의 모든 원소 출력하기 **\n\n  * "); 

		for (PersonComparable p : persons)      // persons의 각 원소인 p에 대해
			System.out.print("[ " + p + " ] "); //   p 출력 
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *   
 *   1) PersonComparable클래스의 compareTo() 메소드의 반환값  
 *      << return this.name.compareTo(p.name); >>에 의해 
 *      정렬 순서가 결정되므로 name 필드의 크기순으로 TreeSet에서 정렬된다.
 *      
 *   2) 프로그램을 실행하여 결과를 확인하라.
 *      
 *   3) 2명의 PersonComparable 객체를 persons에 추가하여 저장하도록 프로그램을 변경하고 결과를 확인하라.
 *   
 *   4) 출력된 결과를 잘 살펴보고 TreeSet에 저장되는 순서와 관계 없이 이름순으로 정렬되어 출력됨을 확인하라.
 *   
 *   
 * [ 실습과제 ]
 *   
 *   1) PersonComparable 객체의 compareTo() 메소드에 의해 이름의 오름차 순으로 객체를 저장한다.
 *      이름의 내림차 순으로 객체를 저장하도록  int compareTo(Comparable p) 메소드를  
 *      다음과 같이 변경하고 결과를  확인하라.  
 *      
 *         return p.name.compareTo(this.name);
 *      
 *   
 *   2) PersonComparable 객체의 compareTo() 메소드는 이름의 크기를 비교하여 결과를 반환하므로 
 *      TreeSet에 저장되는 순서는 이름 크기 순이 된다.
 *      
 *      TreeSet에 저장되는 순서를 나이 순으로 하기 위해서 int compareTo(Comparable p) 메소드를  
 *      다음과 같이 변경하고 결과를  확인하라.  
 *      
 *         return this.age - p.age;  // this와 매개변수 p의 age 필드의 크기를 비교하여 크면 양수, 같으면 0, 작으면 음수를 반환
 *      
 *      이렇게 변경하면 나이 순으로 결과가 출력된다.
 */