package ex04_2_patient_mgmt_class;

import java.util.Calendar;

//Doctor 클래스: Person 클래스의 하위 클래스로 선언하지 않음
class Doctor {
	String name;     int age;     String currentLocation;

	int licenseNo;            // 의사면허번호
	String major;             // 전공분야
	Clinic workingClinic;     // 근무병원
	

	// 이름, 나이가 주어지면 필드에 저장하는 객체 생성자
	Doctor (String name, int age) {
		this.name = name;  this.age = age; 
	}

    // 이름, 나이, 면허번호, 전공분야가 주어지면 이를 필드에 저장하는 객체생성자
	Doctor(String name, int age, int licenseNo, String major){
		this(name, age);               // 이름과 나이 초기화하는 객체 생성자 호출하여 name과 age 초기화
		this.licenseNo = licenseNo;
		this.major = major; 
	}

	// 이름, 나이, 면허번호, 전공분야, 근무병원이 주어지면 이를 필드에 저장하는 객체생성자
	Doctor(String name, int age, int licenseNo, String major, Clinic workingClinic ){
		this(name, age, licenseNo, major); 
		this.workingClinic  = workingClinic;
	}
	
	// thereIsDoctor() : 주어진 이름, 나이, 면허번호, 전공분야의 의사 객체를 생성하여 반환하는 클래스 메소드
	static Doctor thereIsDoctor(String name, int age, int licenseNo, String major) {
		return new Doctor(name, age, licenseNo, major);
	}
	
	// thereIsDoctor() : 이름, 나이, 면허번호, 전공분야를 입력하여 의사 객체를  생성하여 반환하는 클래스 메소드
	static Doctor thereIsDoctor() {
		System.out.println("\n\n  ** 의사  생성 ** \n");

		String name = SkScanner.getString("  o 의사 이름 > ");    
		int age = SkScanner.getInt("  o 나이 > ");
		int licenseNo = SkScanner.getInt("  o 의사면허번호 > ");
		String major = SkScanner.getString("  o 전공분야 > ");
				
		return thereIsDoctor(name, age, licenseNo, major);
	}
	
	// goTo(): 수신자 객체가 특정 위치로 이동하는 것을 나타내는 메소드.
	void goTo(String location) {
		this.currentLocation = location;  // 현위치를 주어진 장소로 변경
	}
	
	// goToWork(): 출근하다를 나타내는 메소드
	//  - 출근하면 근무병원으로 가므로 this.workingClinic.clinicName으로 goTo() 메소드 호출
	void goToWork() {
		this.goTo(this.workingClinic.clinicName);
	}
	
	// openClinic(): 의사가 병원을 개원하는 것을 나타내는 메소드
	//  - 병원이름, 개원날짜, 전화번호 등을 입력받아 병원 개원을 위한 병원 객체 생성하여 반환
	Clinic openClinic() {
	
		System.out.println("\n\n  ** 병원 개원 ** \n");
		System.out.println("  * 개원 의사: " + getDoctorInfoString() + "\n" );
  
		return  this.inputOpenClinic();  // 병원 정보를 입력하여 병원 객체 생성하여 반환된 병원 객체 반환
	}
	
	// openClinic(): 의사가 병원을 개원하는 것을 나타내는 메소드
	//   - 병원이름, Calendar 객체의 개원날짜, 전화번호를 매개변수로 가짐
	//   - 병원 객체 생성하고 의사의 근무병원을 생성된 병원 객체로 설정
	Clinic openClinic(String clinicName, Calendar openDate, String telno) {
		Clinic clinic = new Clinic(clinicName, this, openDate, telno);  // 병원 객체 생성
		
		this.setWorkingClinic(clinic);	// 병원을 개원한 의사는 그 병원에서 근무하므로 근무병원을 개원한 병원으로 저장
		
		return clinic;
		
	}

	// openClinic(): 의사가 병원을 개원하는 것을 나타내는 메소드
	//   - 병원이름, 개원날짜, 전화번호를 매개변수로 가짐
	//   - 개원날짜가 YYYYMMDD 양식의 8자리 정수로 주어짐
	Clinic openClinic(String clinicName, int openDate, String telno) {
		
		Calendar cal = Date.getCalendar(openDate);  //  YYYYMMDD 양식의 8자리 정수로 주어지는 날짜를 Calendar 객체로 변환
		 
		Clinic clinic = this.openClinic(clinicName, cal, telno);  // 병원이름, Calendar 객체의 개원날짜, 전화번호를 매개변수로 갖는 메소드 호출  
		
		return clinic;		
	}

	// inputOpenClinic(): 병원 정보를 입력하여 입력된 정보의 병원 객체 생성하여 반환하는 메소드
	//   - 병원이름, 개원날짜, 전화번호를 입력받음
	Clinic inputOpenClinic() {
		String clinicName = SkScanner.getString("  o 병원 이름 > ");    
		int dateOpen = SkScanner.getInt("  o 개원 연월일(YYYYMMDD) > ");
		String telno = SkScanner.getString("  o 전화번호 > ");
		
		return openClinic(clinicName, dateOpen, telno);   // 병원 객체 생성하여 반환
	}
	
	
	// setWorkingClinic(): 근무병원 필드 을 주어진 병원으로 젖아하는 
	void setWorkingClinic(Clinic clinic) {
		this.workingClinic = clinic;		
	}
		
	// startWorkAt(): 병원에서 일하기 시작하는 것을 나타내는 메소드
	void startWorkAt(Clinic clinic) {
		this.workingClinic = clinic;  // 주어진 병원을 근무병원으로 저장
	}
	
	// treats(): 환자를 치료하여   진료소견, 처방, 진료시간 등을  환자 정보로 저장하는 메소드
	void treats(Patient patient, String diagnosisOpinion,  String prescription, int minutes) {
		// 환자내의 진료기록부에 진료내역을 저장하게 하기 위해
		// Patient 클래스의  getTreat() 메소드 호출
		patient.getTreat(this, diagnosisOpinion, prescription, minutes);
	}
	
	
	// input(): 이름, 나이, 면허번호, 전공분야 등 의사 정보를 입력하여 의사 객체의 필드에 저장하는 메소드
	void input() {
		this.name = SkScanner.getString("  o 이름 > ");
		this.age = SkScanner.getInt("  o 나이 > ");
		
		this.licenseNo = SkScanner.getInt("  o 면허번호 > ");
		this.major = SkScanner.getString("  o 전공분야 > ");
	}
	
	// toString(): 필드들을 문자열로 구성하여 반환하는 메소드
	public String toString() {
		return  "이름:" + this.name + ", 나이:" + this.age + ", 현위치:" + this.currentLocation
				                   + ", 면허번호:" + this.licenseNo + ", 전공분야:" + this.major;
	}
		
	// getDoctorInfoString(): 의사 이름, 면허번호, 전공분야를 문자열로 구하여 반환하는 메소드
	String getDoctorInfoString() {
		return this.name +  "(면허번호: " + this.licenseNo + ", 전공분야: " + this.major + ")";
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
