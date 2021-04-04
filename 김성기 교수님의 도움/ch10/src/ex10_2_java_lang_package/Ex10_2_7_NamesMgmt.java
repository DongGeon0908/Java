package ex10_2_java_lang_package;

/**
 * [ Names, NamesMgmt 클래스 ]: 
 *        여러 문자열을 배열에 저장하고 문자열 비교 및 탐색
 *        
 *   o 여러 이름들에 대한 5가지 관리 작업을 수행하는 관리 프로그램  
 *     - 관리 작업 메뉴
 *       1) 모든 이름 보기
 *       2) 이름 추가
 *       3) 이름 찾기
 *       4) 성으로 이름 찾기
 *       5) 큰 이름 찾기  
 *       
 *   o 관리 프로그램 많이 읽고 작성하면서 프로그래밍 능력을 향상해야 함
 */

class Names {
	String[] names = new String[100];  // 최대 100개 이름 저장하는 배열변수 names
	int cntNames = 0;                  // names[] 배열에 저장된 원소 개수

	// 저장된 모든 이름을 출력하는 작업 처리 메소드
	void doList() {
		System.out.print("\n  ** 모든 이름들 **\n  * ");  

	    if (cntNames == 0)  
	        System.out.println("이름이 하나도 없음 ");
	    else 
	         for (int i = 0; i < cntNames; i++)   // 이름 저장된 원소 모두에 대해         
	           System.out.print(names[i] + "  ");
	}

	// 이름을 입력하여 입력된 이름을 저장하고 저장된 위치를 출력하는 작업 처리 메소드
	void doAdd() {
		System.out.println("\n  ** 이름 추가하기 **");  
		String name = SkScanner.getString("  o 추가할 이름 > ");
		int n = add(name);
		System.out.println("\n  * " + name + ": " + ( n + 1) + "번째 이름으로 추가됨");
	}

	// 주어진 이름을 names[] 배열의 마지막 원소 다음에 저장하고 위치 반환하는 메소드
	int add(String name) {

		names[cntNames] = name; // 마지막 다음 위치 names[cntNames]에 name 저장
		cntNames++;             // names[] 배열에 저장된 원소 개수 1 증가

		return cntNames - 1;    // 저장 위치 반환
	}

	// 이름을 입력하여 입력된 이름과 동일한 이름의 개수를 출력하는 작업 처리 메소드
	void doSearchName() {
		System.out.println("\n  ** 이름 찾기 **");  
		String name = SkScanner.getString("  o 찾을 이름 > ");
		int cnt = 0;

		for (int i = 0; i < cntNames; i++)
			if (names[i].equals(name))  // names[i]가 name과 같으면 
				cnt++;
		if (cnt == 0)
			System.out.println("\n  * " + name + "인 이름이 없음.");  
		else 
			System.out.println("\n  * " + name + "인 이름이 " + cnt +"개 있음");  
	}

	// 성을 입력하여 입력된 성으로 시작하는 이름과 개수를 출력하는 작업 처리 메소드
	void doSearchFirstname() {
		System.out.println("\n  ** 성으로 이름 찾기 **");  
		String fname = SkScanner.getString("  o 찾을 성 > ");

		int cnt = 0;
		String namesMatch = "";

		for (int i = 0; i < cntNames; i++)
			if (names[i].startsWith(fname)) {  // names[i]가 fname으로 시작하면
				cnt++;
				namesMatch += names[i] + " ";
			}

		if (cnt == 0)
			System.out.println("\n  * 성이 " + fname + "인 이름이 없음");  
		else 
			System.out.println("\n  * 성이 " + fname + "인 이름 " + cnt +"개: " +
					namesMatch);  
	}

	// 이름을 입력하여 입력된 이름보다 큰 이름과 개수를 출력하는 작업 처리 메소드
	void doSearchNameGT() {
		System.out.println("\n  ** 큰 이름 찾기 **");  
		String name = SkScanner.getString("  o 찾을 이름 > ");
		int cnt = 0;
		String namesGT = "";

		for (int i = 0; i < cntNames; i++)
			if (names[i].compareTo(name) > 0) {  // names[i]가 name보다 크면
				cnt++;
				namesGT += names[i] + " ";
			}

		if (cnt == 0)
			System.out.println("\n  * " + name + "보다 큰 이름이 없음");  
		else 
			System.out.println("\n  * " + name + "보다 큰 이름 " + cnt +"개: " 
					+ namesGT);  
	}    
}

class Ex10_2_7_NamesMgmt {  
	public static void main(String[] args) {
		Names names = new Names();  // 여러 이름들을 저장하고 관리하는 names 객체 생성 및 저장

		// 홍길동, 홍길서, 홍길남, 홍길북을 미리 추가함
		names.add("홍길동"); names.add("홍길서"); 
		names.add("홍길남"); names.add("홍길북");

		while(true) {
			System.out.println("\n\n  **** 이름 관리 ****\n");
			System.out.println("  1) 모든 이름 보기   \t2) 이름 추가     \t  3) 이름 찾기 ");
			System.out.println("  4) 성으로 이름 찾기 \t5) 큰 이름 찾기  \t  6) 종료");

			int menu = getMenu(1, 6, "\n  o 작업 선택하시오 > ", "  !!! 올바른 작업을 선택하시오\n");    
			
			switch(menu) {
			case 1: names.doList();             break;
			case 2: names.doAdd();              break; 
			case 3: names.doSearchName();       break;
			case 4: names.doSearchFirstname();  break;
			case 5: names.doSearchNameGT();     break;
			case 6: exit();                   return;
			}
		}
	}

	static void exit() {
		System.out.println("\n\n ** 이름 관리 종료합니다 \n\n");
	}
	
	static int getMenu(int min, int max, String prompt, String errMsg) {
		while(true) {
			int menu = SkScanner.getIntWithPrompt(prompt);
			
			if (menu >= min && menu <= max)
				return menu;
			
			System.out.print(errMsg);			
		}
	}
}

/*
 * [ 프로그램 이해 및 실행 ]
 * 
 *   1) 이 프로그램은 이름들에 대한 5가지 관리 작업을 수행한다.
 *      - 작업 처리를 위한 메소드는 앞에 do를 붙여 작업처리임을 표시한다.
 *      - doList() 메소드는 이름 출력 작업을 수행한다.
 *      - 나머지 4개의 작업처리 메소드는 주어진 작업을 처리한다.
 *      
 *   
 *   2) getMenu(int min, int max, String prompt, String errorMsg) 메소드
 *      - main()의 << int menu = getMenu(1, 6, ...  >>에서 사용되는 메소드
 *      - 주어진 범위의 정수를 입력하는 클래스 메소드
 *      - 프롬프트 메시지 prompt를 출력한 후 주어진 min과 max 사이의 정수만을 입력하여 반환
 *      - 범위 밖의 정수가 입력되면 오류 메시지 errorMsg를 출력한 후 다시 입력을 시도
 *      
 *   3) 프로그램을 실행하여 메뉴 선택한 후 작업을 수행하고 결과를 확인하라.   
 *   
 *   
 * [ 실습 과제 ]
 * 
 *   o 이름을 입력하여 입력된 이름과 같은 이름을 삭제하는 메뉴를 3번 메뉴로 작성하려 한다.
 *       
 *     (1) Names 클래스에 void delete() 메소드를 작성하라.
 *     (2) main()에서 기존의 3번부터의 메뉴를 4번 부터의 메뉴로 변경하고 << 3) 이름 삭제 >> 메뉴를 추가하라. 
 *     (3) main()에서 메뉴 선택하고 선택된 메뉴에 대해 해당 메소드를 호출하는 부분을 변경하라.
 *     
 *   o getMenu() 메소드는 입력된 메뉴 번호가 min보다 작거나 max보다 크면 main()에서 전달되는 오류 메시지를 
 *     출력하여 오류를 처리한다.
 *     
 *     getMenu() 메소드에서 오류 상황이 발생하면 예외 객체를 던지고 main()에서 예외 탐지하고 처리하도록 
 *     프로그램을 변경하라.
 *     
 *     이 때, getMenu() 메소드의 마지막 매개변수 String errorMsg는 삭제한다.
 */
