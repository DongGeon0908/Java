package example11_2_person_mgmt;
import java.util.Stack;

/**
 * [ PersonMgmt6 ]: Stack 클래스를 이용하여  여러 신상정보 저장과 출력
 *    
 *   o Stack 클래스는 여러 데이터를 저장하고 검색하는 편리한 기능을 제공하는 클래스임 
 *     - Stack을 이용하여 원소를 저장할 때에는 저장할 원소의 최대 크기를 별도로 설정할 필요가 없음
 *     - 자체적으로 원소를 저장할 공간을 관리하고, 더 많은 원소가 저장될 필요가 있으면 저장 공간을 추가로 확보함
 *    
 *   o push(), pop() 메소드를 이용하여 원소 추가 및 추출을 간단하게 수행할 수 있음
 *     - push(): 주어진 원소를 탑 위치에 추가함
 *     - pop(): 스택의 탑 위치의 원소를 제거하고 제거한 원소를 반환함
 *    
 */

class Ex11_3_3_PersonMgmt6_UsingStack {  

	// Person 객체를 원소로 저장할 Stack 객체 생성하여 persons가 참조하게 함 
	static Stack<Person> persons = new Stack<Person>(); 

	// 주어진 Person 객체 p를 Stack 객체 persons에 추가하는 메소드
	static void addPerson(Person p) {     
		persons.push(p); // p를 persons에 푸시(내부적으로 저장한 원소 개수 1 증가)
	}

	// n명의 Person 객체 생성하고 신상정보 입력하여 persons에 저장하는 메소드
	static void inputPersons(int n) {
		System.out.println("\n\n  **** " + n +"명 신상정보입력 ****");
		for (int i = 1; i <= n; i++) {
			Person p = new Person();  // Person 객체를 생성       
			p.input("\n  ** " + i + "번째 신상정보(이름, 나이, 현위치) 입력 **");
			addPerson(p);              // p를 persons에 저장
		}
	}
	
	// 신상정보 인원수 입력하여 그 인원수만큼의 신상정보 입력하여 persons에 저장하는 메소드
	static void inputPersons() {
		System.out.println("\n\n  **** 신상정보 입력 ****");
		int no = SkScanner.getInt("\n  o 입력할 신상정보 인원수 > ");
		
		inputPersons(no);
	}

	// Stack 객체 persons에 저장된 모든 Person 객체를 출력하는 메소드
	static void outputAllPersons() {
		int n = persons.size();       // persons에 저장된 원소 개수를 n에 저장 
		System.out.println("\n\n  ** " + n + "명 신상정보 **\n");
		for (int i = 0; i < n; i++)    // persons.size() 개수의 원소에 대해
			persons.pop().output();  //   팝시킨 후 팝한 원소를 출력
	}

	public static void main(String[] args) {   
		inputPersons(5);
		outputAllPersons();      
	}
}    

/*
 * [ 프로그램의 이해 및 실행 ]
 *   
 *   1) 프로그램을 실행하여 결과를 확인하라.
 *   
 *   2) 이 프로그램은 예외를 발생시키지는 않으며, 5개의 Person 객체가 모두 저장됨을 확실히 확인하라.
 *   
 *   
 * [ 실습과제 ]
 *   
 *   1) 다음과 같이 Integer 객체를 저장할 수 있는 Stack 객체를 생성하여 참조변수 ints가 참조하도록 하라.
 *      
 *       static Stack<Integer> ints = new Stack<Integer>(); // Integer 객체를 저장할 Stack 객체를 생성하여  ints가 참조하게 함
 *       
 *   2) 여러 정수를 입력하여 ints에 저장하도록 추가로 작성하기 위해 다음의 메소드를 작성하라.
 *      
 *        static void addInts(int n)   // n을 Stack 객체 ints에 푸시하는 메소드
 *        static void inputInts(int n) // n개의 정수를 입력하여 Stack 객체 ints에 저장하는 메소드 
 *        static void inputInts()      // 정수 개수를 입력하여 그 개수의 정수를 입력해 ints에 저장하는 메소드        
 *        static void outputAllInts()  // Stack 객체 ints에 저장된 모든 정수를 팝시키면서 출력하는 메소드 
 *        
 *   3) main()에서 다음을 호출하여 프로그램을 실행하여 결과를 확인하라.
 *   
 *         inputInts();
 *         outputAllInts();    
 */