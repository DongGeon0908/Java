package ex04_1_patient_basic;


/*
* [ Patient_Initailizaion_Out ]: 환자 정보와 진료 정보을 위한 변수 선언 및 초기화, 출력
*
*   o 프로그래밍 스타일
*     1) main() 메소드로만 클래스 구성
*     2) 변수 선언과 동시에 초기화하여 저장된 변수 값을 출력
*
*   o 변수 선언 및 초기화, 출력을 위한 프로그램 작성 및 수정
*     - 변수는 선언된 후 값을 저장할 수 있음
*     - 변수 선언시 변수 이름과 저장할 값의 종류를 나타내는 타입이 주어짐
*
*     - 변수를 선언하면서 동시에 바로 값 저장하는 초기화 가능
*         String name = "홍길동";  // 변수 선언 및 초기화, 이는 < String name; name = "홍길동"; >과 동일함
*
*   o 여러 종류별 값 출력
*     - System.out.println() 메소드를 통해 값 출력
*     - System.out.println() 메소드를 통해 모든 타입의 값과 변수 값을 출력할 수 있음
*/


class Ex3_7_2_Patient__Initialization_Out { 
	public static void main(String[] args) {

		/*
		 *  환자 정보(환자ID, 이름, 성별, 생년월일, 주소)와 진료 정보(진료날짜, 진료시간(분))를 
		 *  저장하기 위한 변수 선언하면서  환자ID 10005, 이름 심청, 성별 "여", 생년월일 19940212, 
		 *  주소 "서울시 중구 세종로 1"인 환자가  진료날짜 20160328에 30분간의  진료를 받은 사실을 
		 *  표현하기 위해 변수를 선언하면서 초기화함
		 */
		int patientID  = 10005;   		// 환자ID: 10001부터의 일련번호의 정수로 부여되는 주어짐
		String patientName = "심청"; 	// patientName: 환자 이름 저장하는 문자열 변수
		String gender = "여";     		// gender : "남", "여"를 저장하는 문자열 변수
		int dateBirth = 19940212;      	// dateBitrh: yyyymmdd로 표현되는 생년월일 저장하는 int 변수
		String addr = "서울시 중구 세종로 1";	// addr:  주소 저장하는  문자열 변수 

		int dateTreat = 20160328;      	// dateTreat: yyyymmdd로 표현되는 진료날짜를 저장하는 int 변수
		int minitesTreat = 30;   		// minitesTreat : 진료시간(단위 분)을 저장하는 int 변수

		/*
		 *  변수들의 값을 결과로 출력
		 */
		System.out.println("\n");         // 공백 라인을 출력하여 줄을 바꿈
		System.out.println("  **** 환자 정보 및 진료 정보 **** \n\n");  // 결과 타이틀 출력
		System.out.println("  ** 환자 정보 \n");
		System.out.println("  * 환자ID: " + patientID + ", 환자이름: " + patientName + "(" + gender + "), 생년월일: " + dateBirth + ", \n    주소: " + addr + " \n\n");	

		System.out.println("  ** 진료 정보 \n");
		System.out.println("  * 환자ID: " + patientID + ", 진료날짜 " + dateTreat + ", 진료시간: " + minitesTreat + "분");	

		System.out.println("\n\n  ^^ Well done! Have a good time!!! ^^\n"); // 이 문장은 프로그램의 종료를 나타내는 문장임

	}  // main() 메소드의 끝을 나타내는 중괄호

}

/*
* [ 프로그램의 이해 및 실행 ]

*   1) 주어진 프로그램을 살펴보고 프로그램의 내용를 파악하라.
*
*      - Patient_Initailizaion_Out 클래스에 main() 메소드가 작성되어 있다.
*
*      - 환자 정보와 진료 정보를 장하기 위한 변수 선언을 하면서 변수들을 초기화한 후 출력한다.
*
*   2) 자신을 환자로 생각하여 환자 정보와 진료 정보를 저장하여 결과를 확인하라.
*
*
* [ 실습과제 ]
*
*   1) 진료 정보에 진료내역을 저장하는 변수인 medicalRecord, 진료비를 저장하는 변수인
*      medicalFee 추가적으로 선언하면서 변수의 값으로 "감기로 내원하여 감기 치료제를 처방함",
*      3600원을 초기화한 후 출력하도록 프로그램을 수정하라.
*
*      수정이 완료되면 수행하여 출력된 환자 정보와 진료 정보를 확인하라.
*
*   2) 남자 100m, 200m, 400m, 800m 달리기 세계신기록은 9.58초, 19.19초, 43.18초, 100.91초이며,
*      기록 보유자는 100m "Usain Bolt", 200m "Usain Bolt", 400m "Michael Johnson",
*      800m "David Rudisha"이다.
*
*      다음의 요구를 만족시키는 프로그램을 Pr3_7_2_WorldRecord_Initialization_Out 클래스로 작성하라.
*
*    (1) 이들 세계신기록을 저장하기 위한 변수 worldRecord100m, worldRecord200m, worldRecord400m,
*      worldRecord800m과 세계신기록 보유자를 저장하기 위한 변수 worldRecordHolder100m,
*      worldRecordHolder200m, worldRecordHolder400m, worldRecordHolder800m를
*      선언하면서 변수의 값으로 각각의 변수에 값을 초기화한 후 출력 각각의 변수에 값을 저장한 후 출력한다 
*       
*    (2) 이들 4명의 세계기록에 대해 km 단위의 초속, 분속, 시속을 다음과 같이 구해 출력한다.
*         (주의사항: Pr3_7_1_WorldRecord_Out 클래스에서는 m 단위이지만 여기서는 km 단위임)
 
*        - 1초당 달리는 거리인 KPS(Kilometer Per Second: km 단위 초속),
*        - 1분당 달리는 거리인 KPM(Kilometer Per Minute: km 단위 분속)
*        - 1시간당 달리는 거리인 KPH(Kilometer Per Hour: km 단위 시속)
*		 
*	  	 o KPS(km 단위 초속) = km_단위의_달린거리 / 초_단위의_소요시간 
*		                      = m_단위의_달린거리  / 1000 / 초_단위의_소요시간
*
*	     o KPH(km 단위 분속) = km_단위의_달린거리 / 분_단위의_소요시간 
*		                     = m_단위의_달린거리  / 1000 / 초_단위의_소요시간 * 60
*
*	     o KPH(km 단위 시속) = km_단위의_달린거리 / 시간_단위의_소요시간 
*		                     = m_단위의_달린거리  / 1000 /  초_단위의_소요시간 * 3600
*		
*    (3) 입출력은 입출력내용을 잘 나타내면서 가능한 깔끔하고 보기가 좋도록 작성하며, 
*	     Pr3_7_1_WorldRecord_Out 클래스의 입출력양식과 다르게 구성하여야 한한다.
*
*
* [ 참고사항 ]
*
*    실습과제를 할 때에는 이 클래스의 프로그래밍 스타일과 동일한 스타일의 프로그램을
*    작성하여야 한다. 예를 들어, 실습과제 2)의 Pr3_7_2_WorldRecord_Initailizaion_Out 클래스에서
*    main() 메소드로만 클래스 구성하고, 변수를 선언하면서 초기화한 후
*    출력하여야 한다.
*/

