package ex02_persons;

/*
 * [ Persons_Mgmt_UsingMethod ]: 신상정보 추가, 전체 보기, 위치 이동, 나이 변경, 신상정보 삭제 등의 신상정보 관리업무 수행(메소드 이용)
 *
 *   o 프로그래밍 스타일
 *     1) 여러 업무를 수행하는 메소드들로 클래스 구성
 *     2) 메소드들을 이용하여 신상정보 추가, 전체 보기, 위치 이동, 나이 변경, 삭제 등의 신상정보 관리업무를 수행 
 *
 *   o 프로그램 구성
 *     1) 데이터: 신상정보 항목들을 저장하는 배열, 메뉴와 관련된 데이터 등을 필드로 선언함
 *     2) 메소드: 여러 작업 처리를 위한 많은 메소드로 구성됨
 */

class Ex5_1_Persons_Mgmt_UsingMethod {

	/*
	 *   메소드 외부에 선언된 필드들: 이들 변수들은 모든 메소드에서 사용 가능한 전역변수임
	 */

	//  신상정보 항목(이름, 나이, 현위치)을 저장하기 위한 배열변수 선언

	static String names[] = new String[100];		
	static int ages[]= new int[100];
	static String currentLocations[] = new String[100];

	// noPersons: 신상정보 추가된 사람의 인원수를 저장하는 변수, 이 변수를 신상정보 항목을 저장하는 배열변수의 인덱스로 사용함
	static int noPersons = 0;   // 처음에 신상정보 인원수는 0로 초기화해야 함 

	// 업무 전체의 타이틀을 저장하는 변수
	static String workTitle = "\n\n"                              
	               		+     "  **************************************\n"
			            +     "  **        신상정보 관리업무                             **\n"
			            +     "  **************************************\n";

	// 업무에 대한 메뉴 이름을 저장하는 배열변수
	static String nemuNames[] = { "신상정보 전체 보기", "신상정보 추가", "위치 이동", "나이 1 증가", "신상정보 삭제", "종료하기" };	
	static int ENDmenu = nemuNames.length; // 종료메뉴 번호를 저장하는 변수로, nemuNames[] 배열의 원소 개수가 종료 메뉴 번호임

	static String menuPromptMsg = "\n   o 업무를 선택하시오 > ";
	static String menuErrorMsg = "\n\n  ??? 업무가 잘못 선택되었습니다. 다시 올바른 업무를 선택하시오!!!";


	/*
	 * main() 메소드: 초기화 메소드를 호출하고 종료메뉴 선택까지 신상정보 관리업무를 반복하여 수행함
	 */
	public static void main(String[] args) {

		initializePersonsInfo();  // 처음에 신상정보를 초기화하는 메소드를 호출하여 미리 4명의 신상정보를 추가함

		/*
		 *   종료메뉴를 선택할 때까지 신상정보 관리업무를 반복하여 수행함 
		 */ 

		while(true) {

			int menu = selectMenu();  // 메뉴를 선택하여 menu 변수에 저장함

			if (menu == ENDmenu) {   // 종료 메뉴를 선택하면 종료 업무를 수행 후 프로그램을 종료함  		
				doEndMenu();
				return;  // main()에서의 return 문장은 프로그램을 종료시킴, << break; >>도 프로그램을 종료시킴 
			}

			doWorkForMenu(menu);  // 선택된 menu에 대한 업무를 수행하게 함

		}
	}

	// initializePersonsInfo(): 업무를 수행하기 전에 초기화 작업을 수행하는 메소드
	//   4명의 신상정보를 미리 추가함
	static void initializePersonsInfo() {
		addPersonInfo("홍길동", 18, "금강산");
		addPersonInfo("박문수", 35, "한양");
		addPersonInfo("이몽룡", 16, "남원");
		addPersonInfo("성춘향", 14, "남원");
	}

	// addPersonInfo(): 신상정보 항목들이 주어지면 이를 신상정보를 저장하는 배열에 저장하는 메소드
	//   이 메소드가 수행되면 인원수를 저장하는 noPersons 변수를 1 증가한다.
	static void addPersonInfo(String name, int age, String currentLocation) {
		names[noPersons] = name;                       // names[] 배열의 noPersons 위치에 주어진 이름을 저장
		ages[noPersons] = age;                         // ages[] 배열의 noPersons 위치에 주어진 나이를 저장
		currentLocations[noPersons] = currentLocation; //currentLocations[] 배열의 noPersons 위치에 주어진 현위치를 저장

		noPersons++; // 저장된 인원수를 1 증가시킴	
	}

	// listPersonsInfo(): 신상정보를 저장하는 배열에 저장된 모든 신상정보를 차례로 출력하는 메소드
	//   신상정보 출력시 순번이 먼저 출력됨
	static void listPersonsInfo(String title) {
		System.out.println(title);

		for (int i = 0; i < noPersons; i++) {	
			System.out.println("   " + (i + 1) + ") " + names[i] + "의 신상정보 - 나이: " + ages[i] + "세, 현위치: " + currentLocations[i]);
		}
	}

	// add1ToAgesOfPersonsInfo(): 신상정보에 저장된 모든 나이를 1 증가시키는 메소드
	static void add1ToAgesOfPersonsInfo() {
		for (int i = 0; i < noPersons; i++) {	
			ages[i]++;
		}
	}

	// deletePersonInfo(): 신상정보를 저장하는 배열에 저장된 신상정보 중에서 index 위치의 신상정보를 삭제하는 메소드
	static void deletePersonInfo(int index) {

		// index 위치의 신상정보 항목을 삭제하기 위해서는 index 이후의 모든 신상정보 항목들을 한 위치 앞으로 이동시키면 됨 
		for (int i = index; i < noPersons - 1; i++) {	
			names[i] = names[i + 1];          // 다음 위치의 신상정보 이름을 이전 위치로 차례대로 저장하여  index 위치의 신상정보 이름 항목 삭제 
			ages[i] = ages[i + 1];            // 신상정보 나이에 대해 동일하게 수행 
			currentLocations[i] = currentLocations[i + 1];  // 신상정보 현위치에 대해 동일하게 수행 
		}

		noPersons--; // index 위치의 신상정보를 삭제하였으므로 저장된 신상정보 인원수는 1 감소함 
	}

	// selectMenu(): 메뉴를 출력하고 메뉴를 입력받아 정상적인 메뉴이면 이를 반환하는 메소드	
	static int selectMenu() {

		while (true) { // 올바른 업무에 대한 메뉴가 선택될 때까지 반복하여 업무 메뉴를 선택함 
			displayMenus(workTitle, nemuNames); // 

			int menu = SkScanner.getIntWithPrompt(menuPromptMsg);

			if (menu >=1 && menu <= ENDmenu) {   // 정상적 메뉴 순번을 선택하면 메뉴 선택이 완료되므로 
				return menu;		             //     return 문을 이용하여tjsxorehls 메뉴번호를 반환하고 메소드 종료함
			}
			else { // 잘못된 메뉴 순번을 선택하면 다시 메뉴 순번을 입력하도록 함 
				System.out.println(menuErrorMsg);	
			}
		}
	}

	// displayMenus(): 문자열 배열 menus[]의 메뉴들을 1부터 차례로 순번을 부여하여 출력하는 메소드
	static void displayMenus(String title, String[] menus) {
		System.out.println(title);

		for (int i = 0; i < menus.length; i++)
			System.out.println("    " + (i + 1) + ") " + menus[i]);    	
	}

	/* 
	 * 신상정보 관리업무는 신상정보 추가, 보기, 위치 이동, 나이 1 증가, 신상정보 삭제 등으로 구성됨
	 *   여러 업무 선택된 업무의 내용을 수행하도록 업무별 코드를 작성함
	 */
	static void doWorkForMenu(int menu) {

		/*
		 * 선택한 메뉴에 따라 신상정보 관리업무를 수행 
		 */
		switch (menu)  { 
		case 1:   
			doListPersonsInfoMenu();   // 모든 신상정보 리스트 업무 
			break;

		case 2:
			doAddPersonInfoMenu();  // 신상정보 전체 보기 업무
			break;  				

		case 3:
			doChangeLocationMenu();  // 위치 이동 업무 
			break;  

		case 4:
			doIncreaseAgeMenu();  // 나이 1 증가 업무
			break;  

		case 5:
			doDeletePersonInfoMenu();  // 신상정보 삭제  업무
			break;  				
		}
	}



	static void doListPersonsInfoMenu() {

		if (noPersons == 0) {
			System.out.println("\n\n  ??? 신상정보가 하나도 없습니다. 신상정보 추가 후 수행하십시오.");
		}
		else { // 배열에 저장된 noPersons 명의 신상정보 항목들을 모두 출력
			listPersonsInfo("\n\n  *** 신상정보 전체 보기: 이름, 나이, 현위치 출력 ***\n");

			System.out.println("\n  [ 신상정보 보기 완료 ] 모두 " + noPersons + "명의 신상정보가 있습니다.");
		}		
	}



	// doAddPersonInfoMenu(): 신상정보 추가 업무처리 메소드
	static void doAddPersonInfoMenu() {

		System.out.println("\n\n  ** 신상정보 추가: 이름, 나이, 현위치 입력하여 신상정보에 추가 ** \n");

		// 신상정보 항목 값을 입력하여 addPersonInfo() 메소드를 이용하여 신상정보를 추가함
		String name = SkScanner.getStringWithPrompt("   o 이름 > ");
		int age = SkScanner.getIntWithPrompt("   o 나이 > ");
		String currentLocation = SkScanner.getStringWithPrompt("   o 현위치 > ");

		addPersonInfo(name, age, currentLocation);

		listPersonsInfo("\n  ** 추가된 신상정보 **\n");

		System.out.println("\n  [ 신상정보 추가 완료 ] " + name + "의 신상정보가 추가되었습니다.");
	}

	static void doChangeLocationMenu() { // 위치 이동 업무 
		if (noPersons == 0) {
			System.out.println("\n\n  ??? 신상정보가 하나도 없습니다. 신상정보 추가 후 수행하십시오.");
		}
		else { // 배열에 저장된 noPersons 명의 신상정보 항목들을 출력 후 특정인 선택하여 선택된 사람의 이동 위치 입력하여 현위치 변경 
			System.out.println("\n\n  *** 위치 이동: 선택된 특정인의 현위치 변경하기 ***\n");

			listPersonsInfo("  ** 저장된 신상정보 **\n");


			int no; // 현 위치 이동할 사람의 순서번호를 저장할 변수 

			no = getValidInt(1, noPersons, "\n   o 위치 이동할 사람의 순번 선택 > ", 
					"\n   ??? 순번 잘못 선택되었습니다. 1부터 " + noPersons + " 사이의 순번을 선택하시오!!!");

			int index = no - 1;  // 신상정보를 저장하는 배열에서의 인덱스는 순번보다 1 작으므로 no - 1 

			String name = names[index];
			System.out.println("\n  ** " + name + "의 위치 이동하기 ** \n");

			String currentLocation = currentLocations[index];
			System.out.println("   * " + name + "의 현위치: " + currentLocation);

			String newLocation = SkScanner.getStringWithPrompt("   o 이동할 위치 > ");
			currentLocations[index] = newLocation;  // no번째 신상정보의 현위치를 입력한 이동 위치로 변경시킴 

			listPersonsInfo("\n  ** 위치 이동된 신상정보 **\n");

			System.out.println("\n  [ 위치 이동 완료 ] " + name + "의 현위치가 " + currentLocation + "에서 " + newLocation + "(으)로 변경되었습니다.");
		}
	}


	static void doIncreaseAgeMenu() {  // 나이 1 증가 업무
		if (noPersons == 0) {
			System.out.println("\n\n  ??? 신상정보가 하나도 없습니다. 신상정보 추가 후 수행하십시오.");
		}
		else { 
			// 모든 나이를 1 증가하는 것에 대한 예 또는 아니오를 확인한 후 예이면 모든 나이를 1 증가시킴

			System.out.println("\n\n  *** 모든 나이 1 증가: 나이 증가 확인 후 나이 1 증가하기 ***\n");

			listPersonsInfo("  ** 저장된 신상정보 **\n");


			int YesOrNo; // 예 또는 아니오에 대한 정수값을 저장할 변수 

			YesOrNo = SkScanner.getIntWithPrompt("\n   o 모든 신상정보의 나이를 1 나이를 1 증가하겠습니까? (예:1, 아니오:0) > ");

			if (YesOrNo == 1) 
				add1ToAgesOfPersonsInfo();

			listPersonsInfo("\n\n  ** 나이 1 증가된 신상정보 **\n");

			System.out.println("\n  [ 나이 1 증가 완료 ] 모두 " + noPersons + "명의 나이가 1 증가되었습니다. ");
		}
	}



	static void doDeletePersonInfoMenu() {  // 신상정보 삭제  업무
		if (noPersons == 0) {
			System.out.println("\n\n  ??? 신상정보가 하나도 없습니다. 신상정보 추가 후 수행하십시오.");
		}
		else { 
			// 배열에 저장된 noPersons 명의 신상정보 항목들을 출력 후 특정 신상정보 선택하여 선택된 신상정보를 신상정보 항목 배열에서 삭제
			System.out.println("\n\n  *** 신상정보 삭제:  선택된 신상정보를 삭제 ***\n");

			listPersonsInfo("  ** 저장된 신상정보 **\n");

			int no; // 삭제할 신상정보의 순서번호를 저장할 변수 

			no = getValidInt(1, noPersons, "\n   o 삭제할 신상정보의 순번 선택 > ",
					"\n   ??? 순번 잘못 선택하였습니다. 1부터 " + noPersons + " 사이의 순번을 선택하시오!!!\n");	

			int index = no - 1;  // 신상정보를 저장하는 배열에서의 인덱스는 순번보다 1 작으므로 no - 1 

			String name = names[index];  // 삭제할 사람의 이름을 name에 저장

			deletePersonInfo(index);     // 신상정보 배열에서 index 위치의 신성정보를 삭제하는 메소드 호출

			listPersonsInfo("\n  ** 삭제한 후의 신상정보 **\n");

			System.out.println("\n  [ 신상정보 삭제 완료 ] " + no + "번째 " + name + "의 신상정보를 삭제하였습니다. ");
		}
	}


	// doEndMenu(): 종료 처리 메소드
	static void doEndMenu() {
		System.out.println("\n\n  !!!  신상정보 관리업무를 종료합니다.");

		System.out.println("\n\n  ^^ Well done! Have a good time!!! ^^"); // 이 문장은 프로그램의 종료를 나타내는 문장임
	}

	// getvalidInt(): min과 max 사이의 올바른 정수를 입력할 때까지 반복하여 입력하게 함
	//   입력할 때 프롬프트 메시지 promptMsg를 출력하며, 잘못된 정수 입력시 오류 메시지 errorMsg를 출력함
	static int getValidInt(int min, int max, String promptMsg, String errorMsg) {

		while(true) {	
			int n = SkScanner.getIntWithPrompt(promptMsg);

			if (n < min || n > max) { // 잘못된 정수를 입력하면 오류 메세지 출력 후 다시 입력하게 함 
				System.out.println(errorMsg);	
			}
			else                      // 올바른 정수를 입력하면
				return n;             //   return 문을 이용하여 입력된 정수를 반환함
		}
	}
}



/*
 * [ 프로그램의 이해 및 실행 ]
 *
 *   1) 주어진 프로그램을 살펴보고 프로그램의 구조를 파악하라.
 *
 *      - main() 메소드는 초기화 메소드를 호출하고 종료메뉴 선택까지 신상정보 관리업무를 반복하여 수행한다.
 *
 *      - 프로그램이 기능적으로 작성되어 있으므로 전체적 파악, 기능 추가를 위한 변경 등이 용이하다..
 *
 *   2) 프로그램을 실행하여 메뉴를 선택하고 필요한 업무를 수행하여 결과를 확인하라.
 *
 *
 * [ 실습과제 ]
 * 
 *   1) 신상정보 항목에 키와 전화번호를 추가하도록 프로그램을 변경하라. 
 *
 *   2) 최고령자와 최연소자와 최고령자의 이름과 나이를 출력하는 메뉴를 새로운 메뉴 6)으로 추가하려 한다.
 *      이를 위해 "최고령자 및 최연소자 정보보기" 메뉴를 추가하도록 프로그램을 수정하라. 
 *       (참고사항: doListYoungestOldestMenu() 메소드를 작성하라. nameOldest, ageOldest, nameYoungest, ageYoungest 변수를 선언하고 
 *          모든 나이 중에서 가장 큰 값과 작은 값을 찾고 그 때의 이름을 nameOldest와 nameYoungest에 
 *          저장한다.) 
 *      
 */
