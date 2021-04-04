package ex04_3_patient_mgmt_subclass;

import java.util.Calendar;

//진료기록을 저장하기 위한 클래스
class Treatment {
	Patient patient;           // 진료받은 환자
	Calendar dateTreat;        // 진료날짜와 시간을 저장하는 필드
	Doctor doctor;             // 진료한 의사를나타내는 필드
	Clinic clinic;             // 진료병원을 나타내는 필드
	String diagnosisOpinion;   // 진료 소견을 기록하는 필드
	String prescription;       // 처방 내역을 기록하는 필드
	int minutesTreat;          // 진료시간(분)을 나타내는 필드
	int medicalFee;            // 진료비를 저장하는 필드

	// 모든 필드를 초기화는 객체 생성자
	Treatment(Patient patient, Calendar dateTreat, Doctor doctor, String diagnosisOpinion, String prescription, int minitsTreat, int medicalFee) {
		this.patient = patient;
		this.dateTreat = dateTreat;
		this.doctor = doctor;
		this.clinic = doctor.workingClinic;
		this.diagnosisOpinion = diagnosisOpinion;
		this.prescription = prescription;
		this.minutesTreat = minitsTreat;
		this.medicalFee = medicalFee;
	}

	// 진료날짜가 주어지지 않는 객체 생성자: 진료날짜를 현재 날짜로 설정하기 위해 Calendar.getInstance() 메소드 사용함
	Treatment(Patient patient, Doctor doctor, String diagnosisOpinion, String prescription, int minutesTreat, int medicalFee) {
		// 진료날짜가 주어지지 않으면 현재 날짜로 진료날짜를 설정: Calendar.getInstance()는 현재 날짜로 설정되는 Calendar 객체를 반환함
		this(patient, Calendar.getInstance(), doctor, diagnosisOpinion, prescription, minutesTreat, medicalFee);
	}

	// 진료비가  주어지지 않는 객체 생성자: 진료비는 getPayFor() 메소드를 사용하여 구함
	Treatment(Patient patient, Calendar dateTreat, Doctor doctor, String diagnosisOpinion, String prescription, int minutesTreat) {
		// 진료날짜가 주어지지 않으면 현재 날짜로 진료날짜를 설정: Calendar.getInstance()는 현재 날짜로 설정되는 Calendar 객체를 반환함
		this(patient, Calendar.getInstance(), doctor, diagnosisOpinion, prescription, minutesTreat, getPayFor(minutesTreat));
	}

	// 진료날짜와 진료비가  주어지지 않는 객체 생성자: 진료비는 getPayFor() 메소드를 사용하여 구함
	Treatment(Patient patient, Doctor doctor, String diagnosisOpinion, String prescription, int minutesTreat) {
		this(patient, doctor, diagnosisOpinion, prescription, minutesTreat, getPayFor(minutesTreat));
	}

	// getPayFor(): minutesTreat에 저장된 진료시간에 따라 진료비를 계산하여 반환하는 메소드
	int getPayFor() {
		return getPayFor(minutesTreat);		
	}

	// getPayFor(): 매개변수로 주어지는  진료시간에 따라 진료비를 계산하여 반환하는 클래스 메소드
	static int getPayFor(int minutesTreat) {
		return 2000 + minutesTreat * 300;
	}

	// toString(): 필드들을 문자열로 구성하여 반환하는 메소드
	public String toString() {
		return "  * 진료정보 - 진료날짜: "+ Date.getDateString(dateTreat) + ", 진료의사: " + doctor.name + "(병원: " + clinic.clinicName + 
			   "), 진료소견: " + diagnosisOpinion + ", 처방: " + prescription +", 진료시간: " + minutesTreat + "(분), 진료비: " + medicalFee;
	}
}
