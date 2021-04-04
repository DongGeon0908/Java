package ex04_1_patient_basic;


/*
* [ Patient_InOut ]: 환자 정보와 진료 정보를 위한 변수 선언, 값 입력하여 저장, 수식을 이용한 결과 계산 및 출력
*                        (SkScanner.h의 입력 메소드를 이용)
*
*   o 프로그래밍 스타일
*     1) main() 메소드로만 클래스 구성
*     2) 종류별 값을 입력하여 변수에 저장하고 저장된 변수의 값 출력
*
*   o 여러 종류별 값 입력
*     - 종류별로 값을 입력하는 메소드인 SkScanner 클래스의 getXxx() 메소드
*         getString(): 엔터키가 타이핑될 때까지 타이핑된 모든 문자들을 입력
*         getInt():    타이핑된 문자들 중 첫번째 정수 값을 입력, 정수가 아닌 것은 모두 무시됨
*         getDouble(): 타이핑된 문자들 중 첫번째 실수 값을 입력, 실수가 아닌 것은 모두 무시됨
*         getChar():   문자 하나를 입력
*
*     - 입력된 값은 해당 타입의 변수에 저장 가능
*         String name = SkScanner.getString();      // 문자열 입력하여 String 변수에 저장
*         int age = SkScanner.getInt();             // 정수 입력하여 int 변수에 저장
*         double height = SkScanner.getDouble();    // 실수 입력하여 double 변수에 저장
*         char initialOfName = SkScanner.getChar(); // 문자 입력하여 char 변수에 저장
*
*   o 여러 종류별 값 출력
*     - System.out.println() 메소드를 통해 값 출력
*     - System.out.println() 메소드를 통해 모든 타입의 값과 변수 값을 출력할 수 있음
*/


class Ex5_PatientMgmt_UsingMethod { 
	/*
	 *  환자정보(환자ID, 이름, 성별, 생년월일, 주소)와 진료정보(진료날짜, 진료시간(분))를 저장하기 위한 변수 선언
	 */
	static int patientID;   	// 환자ID: 10001부터의 일련번호의 정수로 부여되는 주어짐
	static String patientName;  // patientName: 환자 이름 저장하는 문자열 변수
	static String gender;     	// gender : "남", "여"를 저장하는 문자열 변수
	static int dateBirth;       // dateBitrh: yyyymmdd로 표현되는 생년월일 저장하는 int 변수
	static String addr;		    // addr:  주소 저장하는  문자열 변수

	static int[] datesTreat = new int[100];    // datesTreat: yyyymmdd로 표현되는 최대 100회의 진료날짜를 저장하는 int 배열변수
	static int[] minitesTreat = new int[100];  // minitesTreat : 최대 100회의 진료시간(단위 분)을 저장하는 int 배열변수
	static int noTreats = 0;  // 진료회수를 저장하는 변수로 datesTreat[]과 minitesTreat[] 배열변수의 인덱스로 사용

	public static void main(String[] args) {

		while(true) { // 종료 메뉴를 선택할 때까지 반복함 
			/*
			 * 환자 관리업무를 위한 메뉴 출력 및 메뉴 선택 
			 */int menu = displaySelectMenu();

			 if (menu == 7) {     // 종료 메뉴를 선택하면  종료 메세지 출력 후 프로그램을 종료함 
				  doExitWork();
				  break;  // main()에서의 break 또는 return 문장은 프로그램을 종료시킴 
			 }
			 
			 doWorkForMenu(menu);
		}
		
		
		System.out.println("\n\n  ^^ Well done! Have a good time!!! ^^\n\n"); // 이 문장은 프로그램의 종료를 나타내는 문장
	}

	static int displaySelectMenu() {
		
			while (true) { // 올바른 업무에 대한 메뉴가 선택될 때까지 반복하여 업무 메뉴를 선택함 
				System.out.println("\n\n");
				System.out.println("  **************************");
				System.out.println("  **   한신병원 환자 관리업무         **");
				System.out.println("  **************************\n");

				System.out.println("    1) 환자정보 보기");
				System.out.println("    2) 환자정보 등록하기");
				System.out.println("    3) 환자정보 수정하기");
				System.out.println("    4) 환자 진료정보 전체 보기");
				System.out.println("    5) 환자 진료정보 입력하기");
				System.out.println("    6) 진료비 계산하기");
				System.out.println("    7) 종료하기");
				
				int menu = SkScanner.getIntWithPrompt("\n  o 업무를 선택하시오 > ");

				if (menu >=1 && menu <= 7) { // 정상적 메뉴 순번을 선택하면 메뉴 선택이 완료되므로 
					return menu;		                   //     break 문을 이용하여 무한 반복 while(1)을 벗어나게 함
				}

				else { // 잘못된 메뉴 순번을 선택하면 다시 메뉴 순번을 입력하도록 함 
					System.out.println("\n\n  ??? 업무가 잘못 선택되었습니다. 다시 올바른 업무를 선택하시오!!!");	
				}
			}
	}
	
	// 종료 업무를 처리하기 위한 메소드
	static void doExitWork() {
		System.out.println("\n\n  !!!  환자 관리업무를 종료합니다.");
	}
	
	// 메뉴에 따른 업무 처리를 위한 메소드를 호출하기 위한 업무 제어 메소드
	static void doWorkForMenu(int menu) {
		switch (menu) {
		case 1:
			listPatientInfo();
			break;
			
		case 2:
			enrolPatientInfo();
			break;			
			
		case 3:
			updatePatientInfo();
			break;		
			
		case 4:
			listTreatInfos();
			break;
			
		case 5:
			inputTreatInfo();
			break;				
			
		case 6:
			calculateMeducalFee();
			break;		
		}		
	}
	
	// 등록된 환자정보 출력하는 메소드
	static void listPatientInfo() {	
		if (patientID==0) {
			System.out.println("\n   ??? 현재 등록된 환자정보가 없습니다. 환자정보 입력하십시오."); 
			return;
		}
			
		System.out.println("\n\n  ** 환자 정보 \n");
		System.out.println("  * 환자ID: " + patientID + ", 환자이름: " + patientName + "(" + gender + "), 생년월일: " + dateBirth + ", 주소: " + addr + " \n");	
	}
	
	// 환자정보 입력하여 등록하는 메소드
	static void enrolPatientInfo() {
		if (patientID!=0) {
			System.out.println("  o 현재 등록된 환자 정보가 있습니다.");
			int yesOrNo = SkScanner.getInt("    새로운 환자 정보 등록하시겠습니까? (1: 예, 2: 아니오) > ") ; 
			
			if (yesOrNo  != 1)
					return;
		}
		
		/*
		 *  환자정보를 입력하여 필드들의 값으로 저장
		 */

		System.out.println("\n\n  **  환자정보 등록 ** \n");

		System.out.print("  o 환자ID(5자리 정수) > "); // System.out.println() 이용하여 프롬프트 메시지 출력
		patientID = SkScanner.getInt();     	         // SkScanner.h의 getInt()를 이용하여 정수 입력하여 저장

		System.out.print("  o 환자이름 > ");  // System.out.println() 이용하여 프롬프트 메시지 출력
		patientName = SkScanner.getString();  // SkScanner.h의 getString()를 이용하여 문자열 입력하여 저장

		System.out.print("  o 성별(M/F) > ");  // 프롬프트 메시지 출력
		gender = SkScanner.getString();  		 // 문자열 입력하여 저장

		System.out.print("  o 생년월일(yyyymmdd) > "); 	// 날짜를 입력하기 위한 프롬프트 메시지 출력(입력 양식을 알려줌) 
		dateBirth = SkScanner.getInt();  		         // 정수 양식으로 날짜 입력하여 저장

		System.out.print("  o 주소 > "); 	// 프롬프트 메시지 출력
		addr = SkScanner.getString();  		// 문자열 입력하여 저장
		
		System.out.println("\n\n  * 환자 등록 완료 - 환자ID: " + patientID + ", 환자이름: " + patientName + "(" + gender + "), 생년월일: " + dateBirth + ", 주소: " + addr);	

	}
	
	// 환자정보 변경하여 저장하는 메소드
	static void updatePatientInfo() {
		if (patientID==0) {
			System.out.println("\n   ??? 현재 등록된 환자정보가 없습니다. 환자정보 입력하십시오."); 
			return;
		}
		
		/*
		 *  환자정보 중 변경할 항목을 선택하여 변경하는 메소드
		 */
		int item = chooseUpdateItem();
		
		String[] itemNames = { "",  "이름", "성별", "생년월일", "주소"};   
		System.out.println("\n  **  환자정보 중 " + itemNames[item] + " 변경 ** \n");

		switch(item) {
		case 1: 
			String nameOld = patientName;

			System.out.print("  o 환자이름 > ");  // System.out.println() 이용하여 프롬프트 메시지 출력
			patientName = SkScanner.getString();  // SkScanner.h의 getString()를 이용하여 문자열 입력하여 저장
			System.out.println("\n\n  * 환자정보 변경 완료 - " + nameOld + " 환자의 이름이 " + patientName + "(으)로 변경되었습니다");
			break;

		case 2:
			String genderOld = gender;
			
			System.out.print("  o 성별(M/F) > ");  // 프롬프트 메시지 출력
			gender = SkScanner.getString();  		 // 문자열 입력하여 저장
			System.out.println("\n\n  * 환자정보 변경 완료 - " + patientName + " 환자의 기존 " + genderOld + " 성별이 " + gender + "(으)로 변경되었습니다");
			break;

		case 3:
			int dateBirthOld = dateBirth;
			
			System.out.print("  o 생년월일(yyyymmdd) > "); 	// 날짜를 입력하기 위한 프롬프트 메시지 출력(입력 양식을 알려줌) 
			dateBirth = SkScanner.getInt();  		         // 정수 양식으로 날짜 입력하여 저장
			System.out.println("\n\n  * 환자정보 변경 완료 - " + patientName + " 환자의 기존 " + dateBirthOld + " 생년월일이 " + dateBirth + "(으)로 변경되었습니다");
			break;

		case 4:
			String addrOld = addr;
			
			System.out.print("  o 주소 > "); 	// 프롬프트 메시지 출력
			addr = SkScanner.getString();  		// 문자열 입력하여 저장
			System.out.println("\n\n  * 환자정보 변경 완료 - " + patientName + " 환자의 기존 " + addrOld + " 주소가 " + addr + "(으)로 변경되었습니다");
		}
	}
	
	// 환자정보 항목 중 변경할 항목을 선택하여 반환하는 메소드
	static int chooseUpdateItem() {
		while (true) { // 올바른 변경 항목을 선택될 때까지 반복하여 변경 항목를 선택함 
			System.out.println("\n\n  **   변경할 환자정보 항목 선택 **\n");
			System.out.println("    1) 환자 이름    2) 성별     3) 생년월일     4) 주소   ");

			int choise = SkScanner.getIntWithPrompt("\n  o 변경할 항목을 선택하십시오 > ");

			if (choise >=1 && choise <= 4) { // 정상적 메뉴 순번을 선택하면 메뉴 선택이 완료되므로 
				return choise;		                   //     break 문을 이용하여 무한 반복 while(1)을 벗어나게 함
			}
			else { // 잘못된 항목을 선택하면 다시 변경할 항목을 입력하도록 함 
				System.out.println("\n\n  ??? 변경할 항목이 잘못 선택되었습니다. 다시 올바른 항목을 선택하시오!!!");	
			}
		}
	}

	// 환자 진료정보 입력하여 저장하는 메소드
	static void inputTreatInfo() {
		if (patientID==0) {
			System.out.println("\n   ??? 현재 등록된 환자정보가 없습니다. 환자정보 등록하십시오."); 
			return;
		}

		System.out.println("\n  **  " + patientName + " 환자의 진료정보 입력 ** \n");

		System.out.print("  o 진료날짜(yyyymmdd) > ");  // 날짜를 입력하기 위한 프롬프트 메시지 출력(입력 양식을 알려줌) 
		datesTreat[noTreats] = SkScanner.getInt();  	// 정수 양식으로 날짜 입력하여 저장

		System.out.print("  o 진료시간(분) > ");        // System.out.println() 이용하여 프롬프트 메시지 출력
		minitesTreat[noTreats] = SkScanner.getInt();    // getInt()를 이용하여 정수 입력하여 저장
		
		noTreats++; // 진료정보가 입력되면 진료회수를 1 증가시킴

	}
		
	// 환자 진료정보 입력하여 저장하는 메소드
	static void listTreatInfos() {
		if (noTreats < 1) {
			System.out.println("\n   ??? 현재 진료정보가 없습니다. 진료정보 입력하십시오."); 
			return;
		}
		
		System.out.println("\n  **  진료정보 리스트 ** \n");

	    for (int i=0; i < noTreats; i++) {
	    	System.out.println("  * 환자ID: " + patientID + ", 진료날짜 " + datesTreat + ", 진료시간: " + minitesTreat + "분");	
	    }
	}
	
	// 진료비 계산하여 출력하는 메소드
	static void calculateMeducalFee() {
		if (noTreats < 1) {
			System.out.println("\n   ??? 현재 진료정보가 없습니다. 진료정보 입력 후 진료비 계산하십시오."); 
			return;
		}
			
		System.out.println("\n  **  진료비 계산 ** \n");

	    System.out.println("  * 환자ID: " + patientID + ", 진료날짜 " + datesTreat[noTreats-1] + ", 진료시간: " + minitesTreat[noTreats-1] + "분");	
	    System.out.println("  * 진료비: " + (3000 + minitesTreat[noTreats-1] * 200) + "원");	

		
	}
}

/*
* [ 프로그램의 이해 및 실행 ]
*
*   1) 주어진 프로그램을 살펴보고 프로그램의 구조를 파악하라.
*
*      - 한명의 환자에 대해 환자정보와 여러 진료정보를 관리할 수 있는 메소드들이 작성되어 있다.
*
*   2) 자신을 환자로 생각하여 환자정보와 진료정보를 입력하여 결과를 확인하라.
*
*
* [ 실습과제 ]
*
*   1) 총 진료회수, 총 진료시간, 총 진료비, 진료비 평균 등을 구하여 출력하는 메뉴를 7번 "진료 종합정보 보기" 메뉴로
*      첨가하도록 프로그램을 변경하라.
*      
*      이를 위하여 static void listTotalTreatInfo() 메소드를 작성하고, main(), displaySelectMenu(), doWorkForMenu() 메소드를 수정하라.
*
*
* [ 스스로 생각하고 고민해볼 과제 ]
*
*   o 이 프로그램은 전역변수인 필드를 이용하므로 여러 메소드에서 필드를 접근할 수 있다. 
*     그 결과 메소드를 호출할 때 매개변수로 이용하여 정보를 전달할 필요가 없으므로
*     대부분의 메소드가 매개변수가 없는 메소드로 작성되었다.
*
*     그러나 doWork() 메소드는 매개변수를 가지며, displaySelectMenu() 메소드, chooseUpdateItem() 메소드는 
*     반환값을 갖는 메소드로 작성되었다.이들 메소드가 매개변수 또는 반환값을 갖게되는 이유를 곰곰히 생각해보라. 
*/
