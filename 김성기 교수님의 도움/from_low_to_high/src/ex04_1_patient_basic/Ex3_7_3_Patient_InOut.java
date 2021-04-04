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

class Ex3_7_3_Patient_InOut { 
	public static void main(String[] args) {

		/*
		 *  환자정보(환자ID, 이름, 성별, 생년월일, 주소)와 진료정보(진료날짜, 진료시간(분))를 저장하기 위한 변수 선언
		 */
		int patientID;   	// 환자ID: 10001부터의 일련번호의 정수로 부여되는 주어짐
		String patientName; // patientName: 환자 이름 저장하는 문자열 변수
		String gender;     	// gender : "남", "여"를 저장하는 문자열 변수
		int dateBirth;      // dateBitrh: yyyymmdd로 표현되는 생년월일 저장하는 int 변수
		String addr;		// addr:  주소 저장하는  문자열 변수

		int dateTreat;      // dateTreat: yyyymmdd로 표현되는 진료날짜를 저장하는 int 변수
		int minitesTreat;   // minitesTreat : 진료시간(단위 분)을 저장하는 int 변수


		/*
		 *  환자정보와 진료정보를 입력하여 변수들의 값으로 저장
		 */

		System.out.println("\n  **  환자정보 입력 ** \n");

		System.out.print("  o 환자ID(5자리 정수) > "); // System.out.println() 이용하여 프롬프트 메시지 출력
		patientID = SkScanner.getInt();     	         // SkScanner.h의 getInt()를 이용하여 정수 입력하여 저장

		System.out.print("  o 환자이름 > ");  // System.out.println() 이용하여 프롬프트 메시지 출력
		patientName = SkScanner.getString();  // SkScanner.h의 getString()를 이용하여 문자열 입력하여 저장

		System.out.print("  o 성별(남/여) > ");  // 프롬프트 메시지 출력
		gender = SkScanner.getString();  		 // 문자열 입력하여 저장

		System.out.print("  o 생년월일(yyyymmdd) > "); 	// 날짜를 입력하기 위한 프롬프트 메시지 출력(입력 양식을 알려줌) 
		dateBirth = SkScanner.getInt();  		         // 정수 양식으로 날짜 입력하여 저장

		System.out.print("  o 주소 > "); 	// 프롬프트 메시지 출력
		addr = SkScanner.getString();  		// 문자열 입력하여 저장


		System.out.println("\n  **  진료정보 입력 ** \n");

		System.out.print("  o 진료날짜(yyyymmdd) > ");  // 날짜를 입력하기 위한 프롬프트 메시지 출력(입력 양식을 알려줌) 
		dateTreat = SkScanner.getInt();  				// 정수 양식으로 날짜 입력하여 저장

		System.out.print("  o 진료시간(분) > "); // System.out.println() 이용하여 프롬프트 메시지 출력
		minitesTreat = SkScanner.getInt();       // SgetInt()를 이용하여 정수 입력하여 저장


		/*
		 *  변수들의 값을 결과로 출력
		 */
		System.out.println("\n\n  **** 환자 정보 및 진료 정보 **** \n");  // 결과 타이틀 출력
		System.out.println("  ** 환자 정보 \n");
		System.out.println("  * 환자ID: " + patientID + ", 환자이름: " + patientName + "(" + gender + "), 생년월일: " + dateBirth + ", \n    주소: " + addr + " \n");	

		System.out.println("  ** 진료 정보 \n");
		System.out.println("  * 환자ID: " + patientID + ", 진료날짜 " + dateTreat + ", 진료시간: " + minitesTreat + "분");	

		System.out.println("\n\n  ^^ Well done! Have a good time!!! ^^\n\n"); // 이 문장은 프로그램의 종료를 나타내는 문장임


		main(args); // 이 문장은 전체 프로그램을 계속 반복하여 실행하기 위해 작성된 것임
	}
}

/*
* [ 프로그램의 이해 및 실행 ]
*
*   1) 주어진 프로그램을 살펴보고 프로그램의 구조를 파악하라.
*
*      - Patient_InOut에 main() 메소드가 작성되어 있다.
*
*      - main() 메소드는 변수 선언, 값 입력 및 저장, 값 출력 등을 수행하는
*         여러 문장들로 구성되어 있다.
*
*      - main() 메소드의 끝에는 < main(); > 문장이 있으며, 이 문장은 전체 프로그램을 
*        계속 반복하여 실행하도록 한다.
*
*   2) 자신을 환자로 생각하여 환자정보와 진료정보를 입력하여 결과를 확인하라.
*
*
* [ 실습과제 ]
*
*   1) 진료비는 기본진료비와 진료시간에 비레하여 부과되는 진료시간 진료비로 구성된다.
       기본진료비는 20000원, 1분당 진료비가 200원인 경우 진료시간이 10분이면
       
	   진료비 = 2000원(기본진료비 ) + 200원(1분당 진료비) * 10분(진료시간) = 2000원 + 2000원 = 4000원이다.
	    
*      진료비를 나타내는 변수 medicalFee 추가적으로 선언하고 진료비를 구하여 출력하도록
*      프로그램을 수정하라.
*
*      수정이 완료되면 환자정보와 진료정보를 입력하여 결과를 확인하라.
*
*   2) 이 프로그램에서는 생년월일과 진료날짜를 등의 날짜를 yyyymmdd 형식의 8자리 정수로 입력받는다.
*      날짜를 생년, 생월, 생일 등 3가지로 나누어 입력받아  dateBirth 변수와  dateTreat 변수에 저장하도록
*      수정한 프로그램을 Pr3_7_3_Patient_InOut로 작성하라. 
*	   
*	   이를 위해 생년월일 입력의 경우, birthYear, birthMonth, birthDay 변수를 선언하고 
*      이들 변수에 생년, 생월, 생일을 입력받은 후 
*       << birthDate = birthYear * 10000 + birthMonth * 100 + birthDay; >>을 수행한다.
*
*
*   3) 남자 100m, 200m, 400m, 800m 달리기 세계신기록은 9.58초, 19.19초, 43.18초, 100.91초이며,
*      기록 보유자는 100m "Usain Bolt", 200m "Usain Bolt", 400m "Michael Johnson",
*      800m "David Rudisha"이다.
*
*      다음의 요구를 만족시키는 프로그램을 Pr3_7_3_WorldRecord__InOut 클래스로 작성하라.
*
*    (1)이들 세계신기록을 저장하기 위한 변수 worldRecord100m, worldRecord200m, worldRecord400m,
*         worldRecord800m과 세계신기록 보유자를 저장하기 위한 변수 worldRecordHolder100m,
*        worldRecordHolder200m, worldRecordHolder400m, worldRecordHolder800m를
*       선언하고 각각의 변수에 값을 입력하여 저장한 후 출력한다 
*       
*    (2) 이들 4명의 세계기록에 대해 m 단위의 초속, m 단위의 분속, km 단위의 시속을 
*        해 출력한다.
*		
*    (3) 입출력양식은 Pr3_7_1_WorldRecord_Out의 입출력양식과 Pr3_7_2_WorldRecord_Initialization_Out의 
*        입출력양식 중에서 더 좋은 것을 선택한다.
*
*
* [ 참고사항 ]
*
*   1) 실습과제를 할 때에는 이 클래스의 프로그래밍 스타일과 동일한 스타일의 프로그램을
*      작성하여야 한다. 
*
*   2) 프로그램은 한번 실행된 후 종료된다. 주어진 프로그램을 계속 반복하는 가장 쉬운 방법이
*      main() 메소드의 끝에 문장 << main(); >> 을 추가하는 것이다.
*      이 경우 프로그램을 계속 반복하여 실행되게 된다. 또 다른 방법은 다음에 소개될 것이다.
*
*/
