package example11_2_person_mgmt;

import java.util.Vector;

/**
 * [ storePerson_NotUsingGeneric ]: 
 *      제네릭 클래스의 타입매개변수 생략 가능함 보이는 예제(Vector의 타입 매개변수를 생략하여 원소들을 저장하고 꺼내는 작업을 보이는 예)
 * 
 *   o 타입 매개변수를 생략한 Vector 클래스의 객체 생성과 참조
 *     - Vector 클래스는 제네릭 클래스이므로 
 *         << vector<원소클래스> 객체참조변수 = new Vector<원소클래스)() >> 형식으로 사용
 *         
 *     - 타입 매개변수 생략 가능하므로 제네릭 클래스 지원하기 전의 형식인
 *         << Vector 객체참조변수 = new Vector(); >>로도 사용 가능
 *         
 *     - 타입 매개변수 생략하면 
 *         << Vector<Object> 객체참조변수 = new Vector<Object)() >>와 동일한 코드
 *         
 *     - 이 경우 Vector에 모든 클래스의 객체 저장할 수 있으며, 특정 클래스의 객체만 저장할 수 없음
 *        
 *     - 타입 매개변수를 생략한 예: Vector strings = new Vector(); 
 *       이는 << Vector<Object> strings = new Vector<Object>(); >>와 동일함
 *    
 *     - Vector 객체에 저장된 객체를 get() 메소드로 검색하면 Object 클래스의 객체 반환되므로
 *       하위 클래스의 객체로 사용하기 위해서는 다운캐스팅해야 함
 *      
 *     - 다운 캐스팅 예
 *         strings.add("홍길동");  // String 객체를 Vector strings에 추가
 *         String s = (String) strings.get(0);  // String 원소를 저장하기 위해 다운캐스팅해야함
 *
 *  o main()에서 타입 매개변수를 생략한 Vector 객체에 문자열을 저장한 후 저장된 원소인 문자열을 검색하여 출력함
 *    
 */

class Ex11_4_8_StorePerson_NotUsingGeneric {  

	public static void main(String[] args) {	
		// Vector 객체를 생성하여 persons가 참조하게 함(의도는 Person 객체를 저장하기 위함임)
		Vector persons = new Vector(); 

		persons.add( new Person("홍길동", 18) ); // 홍길동 객체를 persons에 추가
		persons.add( new Person("이몽룡", 16) ); // 이몽룡 객체를 persons에 추가
		Person p = new Person("김철수", 23);
		persons.add(0, p);                     // 김철수 Person 객체를 persons의 0 위치에 추가 

		for (int i =0; i < persons.size(); i++) {  // persons에 저장된 원소 개수만큼
			p = (Person) persons.get(i);           //   인덱스 i의 원소 구하여 Person으로 다운캐스팅하여
			p.output();                            //   출력 
		}	
		
	    persons.add(1, "홍길동");      // persons에 문자열 "홍길동"도 1의 위치에 저장 가능함
	    p = (Person) persons.get(1); // 1 위치의 원소 구하여 Person으로 캐스트  - String을 Person으로 캐스팅하므로 예외 발생함		
	}
}

/*
* [ 프로그램의 이해 및 실행 ]
*   
*   1) 이 프로그램은 컴파일 오류는 없지만 경고 메시자가 여러 개 있으며, 경고 메시지 내용은 다음과 같다.
*   
*      Vector is a raw type. References to generic type Vector<E> should be parameterized
*      
*      이 경고 메시지는 Vector 클래스는 제네릭 클래스이므로 타입 매개변수가 주어져야 하지만 주어지지 않았다는 것을 나타낸다.
*      
*      제네릭 타입의 경우 타입 매개변수가 주어지지 않으면 타입 매개변수를 Object로 간주하여 처리하므로 
*      << Vector persons = new Vector(); >>는 << Vector<Object> persons = new Vector<Object>(); >>와 동일하다.
*   
*   2) 변수 이름 persons는  Persons 객체를 저장하는 것으로 명명되었지만
*      << persons.add(1, "홍길동"); >>에서 persons에 String "홍길동"을 추가해도 
*      String은 Object의 하위 클래스이므로 오류 없이 수행된다.
*      
*   3) << p = (Person) persons.get(1); >>의 persons.get(1)의 결과로 String "홍길동"이 반환되며,
*      Person 객체가 아닌 String "홍길동"을 Person 클래스의 객체로 다운캐스팅하면 
*      오류가 발생한다.  
*/
