package ex11_4_generic_class;

import java.util.Vector;

/**
 * [ storeString_NotUsingGeneric 클래스 ]: 
 *       제네릭 클래스의 타입매개변수를 생략 가능함 보이는 예제
 *       (Vector의 타입 매개변수 생략하여 원소들 저장하고 꺼내는 작업 보이는 예제)
 *       
 *   o 타입 매개변수 없이 제네릭 클래스 사용하기
 *     - 제네릭 클래스는 JDK 1.5부터 지원되었으므로 이전에는 타입 매개변수 없었음
 *     - 지금도 제네릭 클래스 사용 시 타입 매개변수 생략해도 됨
 *     - 타입 매개변수 생략하면 경고 메시지 나타남
 * 
 *   o Vector 클래스는 여러 데이터 저장 및 검색 제공하는 제네릭 클래스
 *     - 저장할 원소의 최대 크기를 별도로 설정할 필요 없음
 *     - 자체적으로 저장 공간 관리, 필요시 저장 공간 추가로 확보
 *     - 제네릭 클래스이므로 변수 선언 또는 객체 생성자 호출시 원소 클래스가 타입 매개변수로 주어짐
 *     - 타입 매개변수 생략해도 되지만, 권장하지 않음
 *    
 *   o 타입 매개변수를 생략한 Vector 클래스의 객체 생성과 참조
 *     - Vector 클래스는 제네릭 클래스이므로 
 *          << vector<원소클래스> 객체참조변수 = new Vector<원소클래스)() >> 형식으로 사용
 *         
 *     - 타입 매개변수 생략 가능하므로 제네릭 클래스 지원하기 전의 형식인
 *          << Vector 객체참조변수 = new Vector(); >>로도 사용 가능
 *         
 *     - 타입 매개변수 생략하면 
 *          << Vector<Object> 객체참조변수 = new Vector<Object)() >>와 동일한 코드
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
 *          strings.add("홍길동");  // String 객체를 Vector strings에 추가
 *          String s = (String) strings.get(0);  // String 원소를 저장하기 위해 다운캐스팅해야함
 *
 *   o main()에서 타입 매개변수를 생략한 Vector 객체에 문자열을 저장한 후 저장된 원소인 문자열을 검색하여 출력함
 */

class Ex11_4_8_StoreString_NotUsingGeneric { 
	public static void main(String[] args) {   
		// 타입 매개변수 생략하여 모든 객체 저장하는 Vector 객체 생성하여 strings가 참조하게 함 
		Vector strings = new Vector(); 

		strings.add( "홍길동" );     // 홍길동을 strings에 추가
		strings.add( "이몽룡" );     // 이몽룡을 strings에 추가
		strings.add(0, "김철수");    // 김철수 문자열을 strings의 0 위치에 추가 

		for (int i = 0; i < strings.size(); i++) {  // strings에 저장된 원소 개수만큼
			String s = (String) strings.get(i);     //  원소 구하여 String으로 다운캐스팅하여
			System.out.println(s);                  //  출력 
		}   

		strings.add(1, 3);                   // strings의 1의 위치에 3도 저장 가능함
		String s = (String) strings.get(1);  // 1 위치 원소 구하여 String으로 다운캐스팅하면
		                                     //    실행 시 예외 발생함                    
	}
} 

/*
* [ 프로그램의 이해 및 실행 ]
*   
*   1) 이 프로그램은 컴파일 오류는 없지만 경고 메시지가 여러 개 있으며, 
*      << Vector strings = new Vector(); >>에서의 경고 메시지 내용은 다음과 같다.
*      
*      Vector is a raw type. References to generic type Vector<E> should be parameterized
*      
*      - 이 경고 메시지는 Vector 클래스는 제네릭 클래스이므로 타입 매개변수가 주어져야 하지만 
*        주어지지 않았음을 나타냄
*      
*      - 제네릭 타입의 경우 타입 매개변수가 주어지지 않으면 타입 매개변수를 Object로 간주하여 처리 
*      - << Vector persons = new Vector(); >>는 
*        << Vector<Object> persons = new Vector<Object>(); >>와 동일
*   
*   2) << persons.add(1, "홍길동"); >>에서 persons에 String "홍길동"을 추가해도 
*      String은 Object의 하위 클래스이므로 오류 없이 수행된다.
*      
*   3) << strings.add(1, 3); >>에서 문자열이 아닌 3을 strings에 추가하면 
*      3은 Wrapper 클래스 Integer의 객체로 자동 박싱되어 오류 없이 수행된다.
*      
*      만약 strings가 << Vector<String> strings = new Vector<String>(); >>으로 선언되면
*      strings에 3을 추가할 수 없다.
*      
*   4) << s = (String) strings.get(1); >>에서 strings.get(1)의 결과로 Integer 객체가 반환되며, 
*      Integer의 객체를 String 클래스의 객체로 캐스팅하면 실행 시에 오류 발생한다.
*   
*   5) 프로그램을 실행하고 결과를 확인하라.
*/