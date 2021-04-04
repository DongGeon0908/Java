package ex04_4_patient_mgmt_subclass_abstractclass;

import java.util.Calendar;

// 병원을 나타내는 클래스
//  - ClassForPatientMgmt 클래스의 하위 클래스
//  - ClassForPatientMgmt 클래스에서 객체 출력을 위한 output() 메소드를 상속받음
class Clinic extends ClassForPatientMgmt {
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
}
