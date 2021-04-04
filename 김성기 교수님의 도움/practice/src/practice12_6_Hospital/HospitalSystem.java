package practice12_6_Hospital;

import java.util.*;

/**
 *  * [ 12장 실습문제 6번 모범 답안 중 일부 - HospitalSystem 클래스 ] : 
 *       환자들을  Vector 객체 patients에 저장하고 관리하는 클래스
 */

public class HospitalSystem {
	String Hospitalname;
	
	int nextPatientNo =  10001;  // 환자 번호를 부여하기 위한 필드
	
	// Patient 객체들을 저장할 Vector 객체
	Vector<Patient> patients = new Vector<Patient>();
	
	// 객체 생성자
	HospitalSystem(String Hospitalname) {
		this.Hospitalname = Hospitalname;
	}
	
	// 새로운 환자 번호를 반환하는 메소드
	int getNewPatientNo() {
		return nextPatientNo++;  // 환자 번호 반환 후 1 증가
	}
	
	// 외래 환자 기본 정보가 주어지면 환자 객체 생성하여 patients에 저장 
	void enrolOutPatient(int patientNo, String name, int age, Date dateTreat) {
		Patient p = new OutPatient(patientNo, name, age, dateTreat);
		
		patients.add(p);
	}
	
	// 입원 환자 기본 정보가 주어지면 환자 객체 생성하여 patients에 저장 
    void enrolInPatient(int pno, String name, int age, Date dateHospitalization, int roomNo) {
		Patient p = new InPatient(pno, name, age, dateHospitalization, roomNo);
		
		patients.add(p);

	}

	// 주어진 환자 번호의 환자 객체를 찾아 반환하는 메소드
	//    그 번호의 환자가 없으면 null 반환
	Patient getPatient(int pno) {
		for (Patient p : patients)
			if (p.pno== pno)
				return p;
		
		return null;
	}
	
	
	// 모든 환자를 반환하는 메소드
	Vector<Patient> getAllPatients() {
		return patients;
	}
	
	// 주어진 환자번호 pno의 진료시간을 minutes만큼 증가시키고 증가된 진료시간을 반환하는 메소드
	//    그 번호의 환자가 없으면 0 반환
	int addTreatMinutes(int pno, int minutes) {
		for (Patient p : patients)
			if (p.pno == pno) {
				p.minutesTreat += minutes;
				
				return p.minutesTreat;
			}
		
		return 0;
	}
	
	// 병원에 초기 환자를 등록하는 메소드
	void initializeHospital() {
		// 환자ID 10005, 이름 홍길동, 나이 18, 외래 환자 생성하여 patients에 등록
		// 홍길동이 30분간 진료한 후 홍길동 환자의 정보를 출력
		OutPatient hgd = new OutPatient(getNewPatientNo(), "홍길동", 18, new Date() );
		patients.add(hgd);
		
		hgd.takeTreat(30);
		hgd.output("\n  * 홍길동 - ");

		// 환자ID 10001, 이름 심청, 나이 22, 입원실 508의 입원 환자 생성하여 patients에 등록
		// 입원환자 심청이 (3일 동안) 50분, 60분, 40분의 치료받고 3일 후 퇴원함
		InPatient sc = new InPatient(getNewPatientNo(), "심청", 22, new Date(), 508 );
		patients.add(sc);
		
		sc.takeTreat(50);
		sc.takeTreat(60);
		sc.takeTreat(40);
		sc.leaveHospitalAfter(3);
		sc.output("\n  * 심청 - ");	
	}
}
