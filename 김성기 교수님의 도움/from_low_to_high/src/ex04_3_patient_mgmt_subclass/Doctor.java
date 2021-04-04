package ex04_3_patient_mgmt_subclass;

import java.util.Calendar;

//Doctor 클래스: Person 클래스의 하위 클래스
class Doctor extends Person{
	int licenseNo;            // 의사면허번호
	String major;             // 전공분야
	Clinic workingClinic;     // 근무병원
	
	// 이름, 나이, 면허번호, 전공분야가 주어지면 이를 필드에 저장하는 객체생성자
	Doctor(String name, int age, int licenseNo, String major){
		super(name, age);
		this.licenseNo = licenseNo;
		this.major = major; 
	}

	// 이름, 나이, 면허번호, 전공분야, 근무병원이 주어지면 이를 필드에 저장하는 객체생성자
	Doctor(String name, int age, int licenseNo, String major, Clinic workingClinic ){
		this(name, age, licenseNo, major); 
		this.workingClinic  = workingClinic;
	}
	
	// thereIsDoctor(): 주어진 이름, 나이, 면허번호, 전공분야의 의사 객체를 생성하여 반환하는 클래스 메소드
	static Doctor thereIsDoctor(String name, int age, int licenseNo, String major) {
		return new Doctor(name, age, licenseNo, major);
	}
	
	// thereIsDoctor(): 이름, 나이, 면허번호, 전공분야를 입력하여 의사 객체를  생성하여 반환하는 클래스 메소드
	static Doctor thereIsDoctor() {
		System.out.println("\n\n  ** 의사  생성 ** \n");

		String name = SkScanner.getString("  o 의사 이름 > ");    
		int age = SkScanner.getInt("  o 나이 > ");
		int licenseNo = SkScanner.getInt("  o 의사면허번호 > ");
		String major = SkScanner.getString("  o 전공분야 > ");
				
		return thereIsDoctor(name, age, licenseNo, major);
	}
	
	//  goToWork(): 출근하다를 나타내는 메소드
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
		
		return openClinic(clinicName, dateOpen, telno);  // 병원 객체 생성하여 반환
	}
	
	
	// 근무병원 필드 을 주어진 병원으로 젖아하는 
	void setWorkingClinic(Clinic clinic) {
		this.workingClinic = clinic;		
	}
		
	// 병원에서 일하기 시작하는 것을 나타내는 메소드
	void startWorkAt(Clinic clinic) {
		this.workingClinic = clinic;  // 주어진 병원을 근무병원으로 저장
	}
	
	// 환자를 치료하여   진료소견, 처방, 진료시간 등을  환자 정보로 저장하는 메소드
	void treats(Patient patient, String diagnosisOpinion,  String prescription, int minutes) {
		// 환자내의 진료기록부에 진료내역을 저장하게 하기 위해
		// Patient 클래스의  getTreat() 메소드 호출
		patient.getTreat(this, diagnosisOpinion, prescription, minutes);
	}
	
	void input() {
		super.input();
		
		this.licenseNo = SkScanner.getInt("  o 면허번호 > ");
		this.major = SkScanner.getString("  o 전공분야 > ");
	}
	
	// 필드들을 문자열로 구성하여 반환하는 메소드
	public String toString() {
		return super.toString() + ", 면허번호:" + this.licenseNo + ", 전공분야:" + this.major;
	}
		
	// 의사 이름, 면허번호, 전공분야를 출력하는 메소드
	String getDoctorInfoString() {
		return this.name +  "(면허번호: " + this.licenseNo + ", 전공분야: " + this.major + ")";
	}
}
