package ex04_1_patient_basic;

/*
* [ Patient_Out ]: 환자 정보와 진료 정보를 위한 변수 선언, 값 저장, 출력
*
*   o 프로그래밍 스타일
*     1) main() 메소드로만 클래스 구성
*     2) 변수 선언하여 값을 저장하고 저장된 변수 값을 출력
*
*   o 변수 선언, 변수에 값 저장, 변수 값 출력을 위한 프로그램 작성 및 수정
*     - 변수는 선언된 후 값을 저장할 수 있음
*     - 변수 선언시 변수 이름과 저장할 값의 종류를 나타내는 타입이 주어짐
*     - 타입으로 String, int, double, char, boolean이 중요함
*     - 선언된 변수는 주어진 타입의 여러 값들 중 하나가 저장 가능함
*
*   o 여러 종류별 값 출력
*     - System.out.println() 메소드를 통해 값 출력
*     - System.out.println() 메소드를 통해 모든 타입의 값과 변수 값을 출력할 수 있음
*
*/

class Ex3_7_1_Patient_Out {
	public static void main(String[] args) {
		/*
		 *  환자 정보(환자ID, 이름, 성별, 생년월일, 주소)와 진료 정보(진료날짜, 진료시간(분))를 저장하기 위한 변수 선언
		 */
		int patientID;   	// 환자ID: 10001부터의 일련번호의 정수로 부여되는 주어짐 
		String patientName; // patientName: 환자 이름 저장하는 문자열 변수 
		String gender;     	// gender : "남", "여"를 저장하는 문자열 변수 
		int dateBirth;      // dateBitrh: yyyymmdd로 표현되는 생년월일 저장하는 int 변수 
		String addr;		// addr:  주소 저장하는  문자열 변수 

		int dateTreat;      // dateTreat: yyyymmdd로 표현되는 진료날짜를 저장하는 int 변수 
		int minitesTreat;   // minitesTreat : 진료시간(단위 분)을 저장하는 int 변수 


		/*
		 *  환자 정보(환자ID, 이름, 성별, 생년월일, 주소)와 진료 정보(진료날짜, 진료시간(분))를
		 *  저장하기 위한 변수 선언하면서  환자ID 10005, 이름 심청, 성별 "여", 생년월일 19940212,
		 *  주소 "서울시 중구 세종로 1"인 환자가  진료날짜 20160328에 30분간의  진료를 받은 사실을
		 *  표현하기 위해 변수에 값을 저장함
		 */
		patientID = 10005;     patientName = "심청";        gender = "여"; 
		dateBirth = 19940212;  addr = "서울시 중구 세종로 1"; 
		dateTreat = 20160328;  minitesTreat = 30;


		/*
		 *  변수들의 값을 결과로 출력
		 */
		System.out.println("\n");         // 공백 라인을 출력하여 줄을 바꿈
		System.out.println("  **** 환자 정보 및 진료 정보 **** \n\n");  // 결과 타이틀 출력
		System.out.println("  ** 환자 정보 \n");
		System.out.println("  * 환자ID: " + patientID + ", 환자이름: " + patientName + "(" + gender + "), 생년월일: " + dateBirth + ", \n    주소: " + addr + " \n\n");	

		System.out.println("  ** 진료 정보 \n");
		System.out.println("  * 환자ID: " + patientID + ", 진료날짜 " + dateTreat + ", 진료시간: " + minitesTreat + "분  \n\n");	

		System.out.println("\n\n  ^^ Well done! Have a good time!!! ^^\n"); // 이 문장은 프로그램의 종료를 나타내는 문장임

	}  // main() 메소드의 끝을 나타내는 중괄호

}
/*
* [ 프로그램의 이해 및 실행 ]
*
*   1) 주어진 프로그램을 살펴보고 프로그램의 구조를 파악하라.
*
*      - Person_Out클래스에 main() 메소드가 작성되어 있다.
*
*      - main() 메소드는 변수 선언, 값 저장, 값 출력 등을 수행하는 여러 문장들로 구성되어 있다.
*
*   2) 자신을 환자로 생각하여 환자 정보와 진료 정보를 저장하여 결과를 확인하라.
*
*
* [ 실습과제 ]
*
*   1) 진료 정보에 진료내역을 저장하는 변수인 medicalRecord, 진료비를 저장하는 변수인
*      medicalFee 추가적으로 선언하고, 이들 변수의 값으로 "감기로 내원하여 감기 치료제를 처방함",
*      3600원을 저장한 후 출력하도록 프로그램을 수정하라.
*
*      수정이 완료되면 환자 정보와 진료 정보를 입력하여 결과를 확인하라.
*
*   2) 남자 100m, 200m, 400m, 800m 달리기 세계신기록은 9.58초, 19.19초, 43.18초, 100.91초이며,
*      기록 보유자는 100m "Usain Bolt", 200m "Usain Bolt", 400m "Michael Johnson",
*      800m "David Rudisha"이다.
*
*     다음의 요구를 만족시키는 프로그램을 Pr3_7_1_WorldRecord_Out 클래스로 작성하라. 
*
*    (1) 이들 세계신기록을 저장하기 위한 변수 worldRecord100m, worldRecord200m, worldRecord400m,
*         worldRecord800m과 세계신기록 보유자를 저장하기 위한 변수 worldRecordHolder100m,
*         worldRecordHolder200m,  worldRecordHolder400m, worldRecordHolder800m를
*         선언하고 각각의 변수에 값을 저장한 후 출력한다 
*       
*    (2) 이들 4명의 세계기록에 대해 m 단위의 초속, 분속, 시속을 다음과 같이 구해 출력한다.
*
*        - 1초당 달리는 거리인 MPS(Meter Per Second: m 단위 초속),
*        - 1분당 달리는 거리인 MPM(Meter Per Minute: m 단위 분속)
*        - 1시간당 달리는 거리인 KPH(Meter Per Hour: m 단위 시속)
*		 
*	  	 o MPS(m 단위 초속) = m_단위의_달린거리 / 초_단위의_소요시간 
*
*	     o MPH(m 단위 분속) = m_단위의_달린거리 / 분_단위의_소요시간 
*		                    = m_단위의_달린거리 / 초_단위의_소요시간 * 60
*
*	     o MPH(m 단위 시속) = m_단위의_달린거리 / 시간_단위의_소요시간 
*		                    = m_단위의_달린거리 / 초_단위의_소요시간 * 3600
*	
*    (3) 입출력은 입출력내용을 잘 나타내면서 가능한 깔끔하고 보기가 좋도록 작성한다. 
*    
*
* [ 참고사항 ]
*
*    1) 실습과제를 할 때에는 이 파일의 프로그래밍 스타일과 동일한 스타일의 프로그램을
*       작성하여야 한다. 예를 들어, 실습과제 2)의 Pr3_7_1_WorldRecord_Out 클래스에서는
*       main() 메소드로만 클래스 구성하고, 변수를 선언하면서  다른 문장에서 값을 저장한 후 
*       출력하여야 한다.
*
*    2) 지난 과제들을 수행하면서 단순히 변수에 값을 저장하고 출력하는 프로그램 작성이 
*       점차적으로 지루하고 흥미가 없어진다고 느낐다면 아주 발전 가능성이 많은 학생이며,
*       과제를 하기에 급급했다면 아직 프로그래밍의 달콤함을 맛보지 못한 학생일 것입니다.
*
*       이번 과제부터는 보다 실제적이며 흥미를 유발하는 결과를 산출하여 출력하는 부분이 과제에 
*       첨가됩니다. 이를 위해서는 수학적 지식과 과학적 지식뿐 아니라 다방면의 많은 지식을 
*       필요로 하며, 복잡한 문제를 해결하려는 의욕이 반드시 필요합니다.
*
*       "나는 할 수 있다.", "어떠한 문제라도 풀기 위해 노력할 것이다."라는 각오를 해보기 바랍니다. 
*    
*/
