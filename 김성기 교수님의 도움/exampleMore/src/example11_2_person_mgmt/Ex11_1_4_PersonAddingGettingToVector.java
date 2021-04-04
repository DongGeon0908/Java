package example11_2_person_mgmt;

import java.util.Vector;

/**
 * [ PersonAddingGettingToVector ]: Vector 클래스를 사용하여 여러 데이터를 저장하고 꺼내는 작업을 보이는 예
 * 
 *   o Vector 클래스는 여러 데이터를 저장하고 검색하는 편리한 기능을 제공하는 클래스임 
 *     - Vector를 이용하여 원소를 저장할 때에는 저장할 원소의 최대 크기를 별도로 설정할 필요가 없음
 *     - 자체적으로 원소를 저장할 공간을 관리하고, 더 많은 원소가 저장될 필요가 있으면 저장 공간을 추가로 확보함
 *    
 *   o Vector 클래스의 객체 생성과 참조
 *     - Vector<원소_클래스> 객체참조변수 = new Vector<원소_클래스>();
 *     - Vector 클래스는 제네릭 클래스이므로 저장할 객체의 클래스를 선언시 <와 > 사이에 명시함
 *    
 *     - Vector<Person> persons = new Vector<Person>(); // <Person>은 원소 클래스 표시 
 *    
 *   o Vector 클래스의 주요 메소드  
 *     - 원소를 추가하는 메소드로 add(E element)와  add(int index, E element)
 *       1) add(E element) 메소드: 벡터의 마지막 위치에 원소 element를 저장
 *          특히 이때에 저장할 공간이 없으면 자동적으로 공간을 확보하여 원소 저장
 *       2) add(int index, E element) 메소드: Vector의 위치 inex에 원소 element를 추가
 *          추가되는 위치부터의 원소들은 뒤로 하나씩 이동시킴 
 *         
 *     - Vector 객체에 저장된 원소를 제거하기 위한 메소드
 *       1) remove(int index) 메소드: index 위치의 원소를 삭제하고 삭제된 원소를 반환
 *          삭제 위치 이부터의 원소들은 앞으로 하나씩 이동시킴
 *         
 *     - 저장 및 검색을 위한  메소드
 *       1) get(int index) 메소드: Vector에서 위치 inex의 원소를 반환
 *       2) set(int index, E element) 메소드: Vector의 위치 inex의 원소를 element로 대체시킴
 *       3) size() 메소드: 현재 저장된 원소 개수를 반환 
 *      
 *   o main()에서 Person 객체 3개를 생성하여 Vector 객체에 저장한 후 저장된 모든 원소를 출력함 
 */

class Ex11_1_4_PersonAddingGettingToVector {  

	public static void main(String[] args) {	
		// Person 객체를 저장하는 Vector 객체를 생성하여 persons가 참조하게 함
		// <Person>은 원소 클래스 표시 
		Vector<Person> persons = new Vector<Person>(); 

		persons.add( new Person("홍길동", 18) ); // 홍길동 객체를 persons에 추가
		persons.add( new Person("이몽룡", 16) ); // 이몽룡 객체를 persons에 추가
		Person p = new Person("김철수", 23);
		persons.add(0, p);                     // 김철수 Person 객체를 persons의 0 위치에 추가 

		for (int i =0; i < persons.size(); i++) {  // persons에 저장된 원소 개수만큼
			p = persons.get(i);                    //   인덱스 i의 원소 구하여
			p.output();                            //   출력 
		}	
		
		p = new Person("심청", 19);
		persons.add(1, p);		
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *   
 *   1) 프로그램을 실행하여 결과를 확인하라.
 *   
 *   2) 2명의 Person 객체를 생성하여 persons에 추가하고 결과를 확인하라.
 */