package ex04_2_patient_mgmt_class;

import java.util.Calendar;

// ������ ��Ÿ���� Ŭ����
class Clinic {
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

	// output(): ��ü ����ϴ� �޼ҵ� - ��� �ʵ��� ���� ���
	void output() {
		System.out.println(this.toString());
	}

	// output(): ��ü ����ϴ� �޼ҵ� - �־��� Ÿ��Ʋ�� ����� �� ��ü�� ��� �ʵ��� ���� ���
	void output(String title) {
		System.out.print(title);  // Ÿ��Ʋ ��� - �̶����� �ٹٲ��� ���� ����(�ٹٲ��� �Ϸ��� title���� ���� '\n'�� ÷���ؾ� ��)
		this.output();
	}	
}
