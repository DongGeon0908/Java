package ex04_3_patient_mgmt_subclass;

import java.util.Calendar;

//�������� �����ϱ� ���� Ŭ����
class Treatment {
	Patient patient;           // ������� ȯ��
	Calendar dateTreat;        // ���ᳯ¥�� �ð��� �����ϴ� �ʵ�
	Doctor doctor;             // ������ �ǻ縦��Ÿ���� �ʵ�
	Clinic clinic;             // ���Ẵ���� ��Ÿ���� �ʵ�
	String diagnosisOpinion;   // ���� �Ұ��� ����ϴ� �ʵ�
	String prescription;       // ó�� ������ ����ϴ� �ʵ�
	int minutesTreat;          // ����ð�(��)�� ��Ÿ���� �ʵ�
	int medicalFee;            // ����� �����ϴ� �ʵ�

	// ��� �ʵ带 �ʱ�ȭ�� ��ü ������
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

	// ���ᳯ¥�� �־����� �ʴ� ��ü ������: ���ᳯ¥�� ���� ��¥�� �����ϱ� ���� Calendar.getInstance() �޼ҵ� �����
	Treatment(Patient patient, Doctor doctor, String diagnosisOpinion, String prescription, int minutesTreat, int medicalFee) {
		// ���ᳯ¥�� �־����� ������ ���� ��¥�� ���ᳯ¥�� ����: Calendar.getInstance()�� ���� ��¥�� �����Ǵ� Calendar ��ü�� ��ȯ��
		this(patient, Calendar.getInstance(), doctor, diagnosisOpinion, prescription, minutesTreat, medicalFee);
	}

	// �����  �־����� �ʴ� ��ü ������: ������ getPayFor() �޼ҵ带 ����Ͽ� ����
	Treatment(Patient patient, Calendar dateTreat, Doctor doctor, String diagnosisOpinion, String prescription, int minutesTreat) {
		// ���ᳯ¥�� �־����� ������ ���� ��¥�� ���ᳯ¥�� ����: Calendar.getInstance()�� ���� ��¥�� �����Ǵ� Calendar ��ü�� ��ȯ��
		this(patient, Calendar.getInstance(), doctor, diagnosisOpinion, prescription, minutesTreat, getPayFor(minutesTreat));
	}

	// ���ᳯ¥�� �����  �־����� �ʴ� ��ü ������: ������ getPayFor() �޼ҵ带 ����Ͽ� ����
	Treatment(Patient patient, Doctor doctor, String diagnosisOpinion, String prescription, int minutesTreat) {
		this(patient, doctor, diagnosisOpinion, prescription, minutesTreat, getPayFor(minutesTreat));
	}

	// getPayFor(): minutesTreat�� ����� ����ð��� ���� ����� ����Ͽ� ��ȯ�ϴ� �޼ҵ�
	int getPayFor() {
		return getPayFor(minutesTreat);		
	}

	// getPayFor(): �Ű������� �־�����  ����ð��� ���� ����� ����Ͽ� ��ȯ�ϴ� Ŭ���� �޼ҵ�
	static int getPayFor(int minutesTreat) {
		return 2000 + minutesTreat * 300;
	}

	// toString(): �ʵ���� ���ڿ��� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
	public String toString() {
		return "  * �������� - ���ᳯ¥: "+ Date.getDateString(dateTreat) + ", �����ǻ�: " + doctor.name + "(����: " + clinic.clinicName + 
			   "), ����Ұ�: " + diagnosisOpinion + ", ó��: " + prescription +", ����ð�: " + minutesTreat + "(��), �����: " + medicalFee;
	}
}
