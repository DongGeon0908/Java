package example11_2_person_mgmt;

/**
 * [ PersonMgmt3 ]: 더 많은 원소를 저장하는 저장공간 확보하여 인덱스 범위 초과 오류 방지하기
 * 
 *   o 배열의 최대 저장 가능 원소보다 더 많은 원소를 저장하려 하면 인덱스 범위 초과 오류인
 *     ArrayIndexOutOfBoundsException이 발생하므로 이를 방지할 수 있도록 조치하는 예제
 *    
 *   o 저장된 배열 원소 개수를 추적하여 더 이상 저장할 공간이 없으면 새로운 배열객체 할당하여 저장 
 *     - 배열에 저장 가능한 최대 원소 개수를 저장하는 변수: MAXPERSONS = 3;
 *     - 배열에 원소를 저장하면 저장된 원소 개수를 추적하는 변수: cntPersons
 *     - 원소를 저장할 배열객체 참조할 참조변수: persons
 *     
 *     - 저장할 공간이 있으면(cntPersons < MAXPERSONS) 저장함 
 *     - 더 이상 저장할 공간이 없으면(cntPersons == MAXPERSONS) 추가적인 저장공간 할당하여 저장       
 *       1) 더 많은 원소 저장 가능한 배열객체 생성
 *       2) 기존의 원소들을 새로운 배열객체에 복사
 *       3) persons가 새로운 객체 참조하게 함
 *       4) 최대 저장 개수를 증가된 최대 개수로 변경
 *    
 *   o 저장 가능한 최대 원소 개수는 3인데 main()에서 5개 원소를 저장하려 함
 *     - 4번째 원소를 persons[3]에 저장하려 하면 현재 저장된 원소 개수가 최대 원소 개수와 같으므로 
 *       새로운 배열공간 확보하여 저장함 
 */

class Ex11_1_3_PersonMgmt3 {  
	static int MAXPERSONS = 3;   // 저장 가능한 최대 원소 개수를 나타내는 변수
	static Person[] persons = new Person[MAXPERSONS];  // Person 객체 저장할 배열변수
	static int cntPersons = 0;   // 배열변수에 저장된 원소개수를 나타내는 변수

	// Person 객체 p를 Person 배열 persons[]에 저장하는 메소드
	static void addPerson(Person p) {     
		if (cntPersons >= MAXPERSONS) {  // 원소 저장할 공간이 없으면       
			int maxNew = MAXPERSONS * 2;              // 원소 최대 개수 2배의 
			Person[] personsNew = new Person[maxNew]; //      저장공간 확보

			copyPersons(persons, personsNew); // 새로운 공간에 기존 원소들 복사
			persons = personsNew;             // persons[]가 새로운 저장공간 참조
			MAXPERSONS = maxNew;              // 최대 원소 개수를 변경
		}

		// 이제는 원소 저장할 공간이 항상 있게 되므로 
		persons[cntPersons++] = p;  // p를 persons[]에 저장, 원소개수 1 증가
	}

	// Person 배열 src[]의 원소들을 모두 Person 배열 dest[]에 복사하는 메소드
	static void copyPersons(Person[] src, Person[] dest) {
		for (int i = 0; i< src.length; i++)  // src[]의 원소 개수만큼
			dest[i] = src[i];                //   src[]의 원소를 dest[]의 원소로 저장
	}

	// n명의 Person 객체 생성하고 신상정보 입력하여 Person 배열 persons[]에 저장하는 메소드
	static void inputPersons(int n) {
		System.out.println("\n\n  **** " + n +"명 신상정보 입력 ****");
		for (int i = 1; i <= n; i++) {
			Person p = new Person();	  // Person 객체를 생성	 	
			p.input("\n  ** " + i + "번째 신상정보(이름, 나이, 현위치) 입력 **");
			addPerson(p);                 // p를 persons에 저장
		}
	}

	// 신상정보 인원수 입력하여 그 인원수만큼의 신상정보 입력하여 persons에 저장하는 메소드
	static void inputPersons() {
		System.out.println("\n\n  **** 신상정보 입력 ****");
		int no = SkScanner.getInt("\n  o 입력할 신상정보 인원수 > ");
		
		inputPersons(no);
	}
	
	// Person 배열 persons[]에 저장된 모든 Person 객체를 출력하는 메소드
	static void outputAllPersons() {
		System.out.println("\n\n  ** " + cntPersons + "명 신상정보 **");
		for (int i = 0; i < cntPersons; i++)    // persons.size() 개수의 원소에 대해
			persons[i].output();	            //    인덱스 i인 원소를 출력
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
 *   3) 저장 가능한 최대 원소 개수를 출력하여 변화된 값을 확인하라.
 *   
 *   
 * [ 실습과제 ]
 *   
 *   1) 다음과 같이 정수 10개를 저장하는 int 배열객체를 생성하여  배열변수 ints[]에 저장하라.
 *   
 *   	static int MAXINTS = 10;   // 저장 가능한 최대 원소 개수를 나타내는 변수
 *	    static ints[] ints = new int[MAXINTS];  // int 값 저장할 배열변수
 *	    static int cntInts = 0;   // 배열변수에 저장된 원소 개수를 나타내는 변수
 *
 *   2) 여러 정수를 입력하여 ints[]에 저장하고 출력하도록 다음의 메소드를 추가로 작성하라.
 *      
 *        static void addInts(int n)   // n을 ints[]의 끝에 저장하는 메소드로, 저장된 원소 개수가 최대 원소 개수와 같으면 추가 저장공간을 확보함
 *        static void copyInts(int[] src, int[] dest)   // int 배열 src[]의 원소들을 모두 int 배열 dest[]에 복사하는 메소드
 *        static void inputInts(int n) // n개의 정수를 입력하여 int[]에 저장하는 메소드 
 *        static void inputInts()      // 정수 개수를 입력하여 그 개수의 정수를 입력해 int[]에 저장하는 메소드        
 *        static void outputAllInts()  // ints[]에 저장된 모든 정수를 출력하는 메소드 
 *        
 *   3) main()에서 다음을 호출하여 프로그램을 실행하여 결과를 확인하라.
 *   
 *        inputInts();   // 여기에서 11개 이상 입력하도록 함
 *        outputAllInts();      
 */