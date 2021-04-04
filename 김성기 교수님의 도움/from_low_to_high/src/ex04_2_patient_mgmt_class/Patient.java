package ex04_2_patient_mgmt_class;

import java.util.Calendar;
import java.util.Vector;

// Patient 클래스: Person 클래스의 하위 클래스로 선언하지 않음
class Patient {
	static int nextPid = 1;   // 생성되는 환자 개개마다 pid를 부여하기 위한 클래스 필드, 환자에게 부여된 후 1씩 증가됨

	String name;     int age;     String currentLocation;

	int pid;               // 환자 아이디
	Calendar birthdate;    // 생년월일: Calendar 클래스의 객체에 생년월일 저장
	
    Clinic clinicVisited;  // 마지막 방문한 병원을 저장

	Vector<Treatment> treatmentRecords = new Vector<Treatment>();  // 치료받은 내역을 저장하는 Vector 객체

	// 이름, 나이가 주어지면 필드에 저장하는 객체 생성자
	 Patient(String name, int age) {
		this.name = name;  this.age = age; 
	}

	// 매개변수 이름과 Calendar 객체의 생년월일이 주어지면 이를 필드에 저장하는 객체 생성자: 
	Patient(String name, Calendar birthdate) {
		this(name, Date.getAge(birthdate));    // 이름과 나이 초기화하는 객체 생성자 호출하여 name과 age 초기화
		
		this.setPid();                         // 환자 아이디를 부여하여 pid 필드에 저장
		this.birthdate = birthdate;            // 생년월일 필드에 주어진 생년월일 저장
	}

	// setPid(): 환자 아이디를 부여하여 pid 필드에 저장하는 메소드: 환자 객체에 대해 pid를 부여하므로 항상 이 객체 생성자는 호출되어져야 함
	void setPid() {
		this.pid = Patient.nextPid++;	// 환자에게 환자 아이디를 부여함, nextPid는  다음 환자를 위해 1 증가시킴	  
	}
	
	// thereIsPatient(): 이름, YYYYMMDD 양식의 정수 생년월일이 주어지면 환자 객체를 생성하여 반환하는 클래스 메소드
	static Patient thereIsPatient(String name, int birthdate) {
		return new Patient(name, Date.getCalendar(birthdate));
	}
	
	// thereIsPatient(): 이름, 나이, 면허번호, 전공분야를 입력하여 의사 객체를  생성하여 반환하는 클래스 메소드
	static Patient thereIsPatient () {
		System.out.println("\n\n  ** 환자  생성 ** \n");

		String name = SkScanner.getString("  o 환자 이름 > ");    
		int birthdate = SkScanner.getInt("  o 생년월일 > ");
				
		return thereIsPatient(name, birthdate);
	}
	
	// goTo(): 수신자 객체가 특정 위치로 이동하는 것을 나타내는 메소드.
	void goTo(String location) {
		this.currentLocation = location;  // 현위치를 주어진 장소로 변경
	}

	// goToClinic(): 병원에 가다 나타내는 메소드
	//  - 현위치를 방문한 병원 이름으로 변경하며 방문 병원을 주어진 병원으로 저장함
	void goToClinic(Clinic clinic) {
		this.goTo(clinic.clinicName);
		clinicVisited = clinic;
	}

    // getTreat(): 진료받다를 나타내는 메소드
	//  - 매개변수로 진료 의사, 진료소견, 처방, 진료시간(분), 진료비가 주어짐
	//  - 진료받으면 진료기록을 생성하여 이를 진료기록부인 Vector 객체 treatmentRecords에 저장함
	void getTreat(Doctor doctor, String diagnosisOpinion,  String prescription, int minutes) {
		Treatment treat = new Treatment(this, doctor, diagnosisOpinion, prescription, minutes);

		treatmentRecords.add(treat);
	}

	// input(): 환자 이름과 생년월일을 입력하여 필드에 저장하는 메소드
	void input() {
		this.name = SkScanner.getString("  o 환지 이름 > ");
		int birthdate = SkScanner.getInt("  o 생년월일(YYYYMMDD) > ");

		// 입력받은 YYYYMMDD 정수  양식의 생년월일을 Calendar 객체에 저장하기 위한 코드
		Calendar cal = Calendar.getInstance();  // Calendar 객체 생성
		Date.setYearMonthDate(cal, birthdate);  //  YYYYMMDD 정수  양식의 생년월일을 Calendar 객체에 저장
		
		this.birthdate = cal;	
		System.out.println("  **** 생년월일 = " + cal);

	}

	// toString(): 주어지느 타이틀을 출력한 후 환자 이름과 생년월일을 입력하여 필드에 저장하는 메소드
	void input(String title) {
		System.out.println(title);   // 타이틀 출력
		this.input();                 // 이름과 생년월일을 입력하여 저장하기 위한 input()메소드 호출
	}

	// 필드들을 문자열로 구성하여 반환하는 메소드
	public String toString() {
		String str =  "  * 환자 기본정보 - " + "이름:" + this.name + ", 나이:" + this.age + ", 현위치:" + this.currentLocation
                                         + ", pid: "+pid + ", 생년월일: " + Date.getDateString(birthdate) + "\n\n" ;
		int cnt = this.treatmentRecords.size();
		
		for (int i = 0; i < cnt; i++) {
			Treatment tr = this.treatmentRecords.get(i);
			str = str + tr.toString() + "\n";
		}
		
		return str;
	}	
	
	// output(): 객체 출력 메소드 - 모든 필드 값 출력
	void output() {
		System.out.println(this.toString());
	}

	// output(): 객체 출력 메소드 - 주어진 타이틀을 출력한 후  모든 필드 값 출력
	void output(String title) {
		System.out.print(title);  // 타이틀 출력 - 이때에는 줄바꿈을 하지 않음(줄바꿈을 하려면 title에서 끝에 '\n'을 첨부해야 함)
		this.output();
	}
}