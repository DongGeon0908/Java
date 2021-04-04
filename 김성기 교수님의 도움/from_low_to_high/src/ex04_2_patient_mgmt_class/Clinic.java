package ex04_2_patient_mgmt_class;

import java.util.Calendar;

// 병원을 나타내는 클래스
class Clinic {
	String clinicName;  // 병원 이름
	Doctor doctor;      // 담당 의사
	Calendar dateOpen;  // 개원 날짜
	String telno;       // 전화번호
	
	// 매개변수 없는 객체 생성자
	Clinic() {		
	}
	
	// 병원 정보가 주어지면 이를 필드에 저장하는 객체 생성자
	Clinic(String clinicName, Doctor doctor, Calendar dateOpen, String telno) {
		setupClinic(clinicName, doctor, dateOpen, telno);
	}
	
	// setupClinic(): 병원 정보가 주어지면 이를 필드에 저장하는 클래스 메소드
	void setupClinic(String clinicName, Doctor doctor, Calendar dateOpen, String telno) {
		this.clinicName = clinicName;
		this.doctor = doctor;
		this.dateOpen = dateOpen;
		this.telno = telno;
	}
	
	// toString(): 필드들을 문자열로 구성하여 반환하는 메소드
	public String toString() {
		return "병원이름:" + this.clinicName + ", 개원의사:" + this.doctor.getDoctorInfoString() 
			   + ", 개원날짜:" + Date.getDateString(this.dateOpen) + ", 전화번호:" + this.telno;
	}

	// output(): 객체 출력하는 메소드 - 모든 필드의 값을 출력
	void output() {
		System.out.println(this.toString());
	}

	// output(): 객체 출력하는 메소드 - 주어진 타이틀을 출력한 후 객체의 모든 필드의 값을 출력
	void output(String title) {
		System.out.print(title);  // 타이틀 출력 - 이때에는 줄바꿈을 하지 않음(줄바꿈을 하려면 title에서 끝에 '\n'을 첨부해야 함)
		this.output();
	}	
}
