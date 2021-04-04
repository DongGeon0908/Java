package ex04_4_patient_mgmt_subclass_abstractclass;

import java.util.Calendar;

// ������ ��Ÿ���� Ŭ����
//  - ClassForPatientMgmt Ŭ������ ���� Ŭ����
//  - ClassForPatientMgmt Ŭ�������� ��ü ����� ���� output() �޼ҵ带 ��ӹ���
class Clinic extends ClassForPatientMgmt {
	String clinicName;  // ���� �̸�
	Doctor doctor;      // ��� �ǻ�
	Calendar dateOpen;  // ���� ��¥
	String telno;       // ��ȭ��ȣ
	
	// �Ű����� ���� ��ü ������
	Clinic() {		
	}
	
	// ���� ������ �־����� �̸� �ʵ忡 �����ϴ� ��ü ������
	Clinic(String clinicName, Doctor doctor, Calendar dateOpen, String telno) {
		setupClinic(clinicName, doctor, dateOpen, telno);
	}
	
	// setupClinic(): ���� ������ �־����� �̸� �ʵ忡 �����ϴ� Ŭ���� �޼ҵ�
	void setupClinic(String clinicName, Doctor doctor, Calendar dateOpen, String telno) {
		this.clinicName = clinicName;
		this.doctor = doctor;
		this.dateOpen = dateOpen;
		this.telno = telno;
	}
	
	// toString(): �ʵ���� ���ڿ��� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
	public String toString() {
		return "�����̸�:" + this.clinicName + ", �����ǻ�:" + this.doctor.getDoctorInfoString() 
			   + ", ������¥:" + Date.getDateString(this.dateOpen) + ", ��ȭ��ȣ:" + this.telno;
	}
}
