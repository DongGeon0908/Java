package practice12_6_Hospital;

import java.util.*;

/**
 *  * [ 12�� �ǽ����� 6�� ��� ��� �� �Ϻ� - HospitalSystem Ŭ���� ] : 
 *       ȯ�ڵ���  Vector ��ü patients�� �����ϰ� �����ϴ� Ŭ����
 */

public class HospitalSystem {
	String Hospitalname;
	
	int nextPatientNo =  10001;  // ȯ�� ��ȣ�� �ο��ϱ� ���� �ʵ�
	
	// Patient ��ü���� ������ Vector ��ü
	Vector<Patient> patients = new Vector<Patient>();
	
	// ��ü ������
	HospitalSystem(String Hospitalname) {
		this.Hospitalname = Hospitalname;
	}
	
	// ���ο� ȯ�� ��ȣ�� ��ȯ�ϴ� �޼ҵ�
	int getNewPatientNo() {
		return nextPatientNo++;  // ȯ�� ��ȣ ��ȯ �� 1 ����
	}
	
	// �ܷ� ȯ�� �⺻ ������ �־����� ȯ�� ��ü �����Ͽ� patients�� ���� 
	void enrolOutPatient(int patientNo, String name, int age, Date dateTreat) {
		Patient p = new OutPatient(patientNo, name, age, dateTreat);
		
		patients.add(p);
	}
	
	// �Կ� ȯ�� �⺻ ������ �־����� ȯ�� ��ü �����Ͽ� patients�� ���� 
    void enrolInPatient(int pno, String name, int age, Date dateHospitalization, int roomNo) {
		Patient p = new InPatient(pno, name, age, dateHospitalization, roomNo);
		
		patients.add(p);

	}

	// �־��� ȯ�� ��ȣ�� ȯ�� ��ü�� ã�� ��ȯ�ϴ� �޼ҵ�
	//    �� ��ȣ�� ȯ�ڰ� ������ null ��ȯ
	Patient getPatient(int pno) {
		for (Patient p : patients)
			if (p.pno== pno)
				return p;
		
		return null;
	}
	
	
	// ��� ȯ�ڸ� ��ȯ�ϴ� �޼ҵ�
	Vector<Patient> getAllPatients() {
		return patients;
	}
	
	// �־��� ȯ�ڹ�ȣ pno�� ����ð��� minutes��ŭ ������Ű�� ������ ����ð��� ��ȯ�ϴ� �޼ҵ�
	//    �� ��ȣ�� ȯ�ڰ� ������ 0 ��ȯ
	int addTreatMinutes(int pno, int minutes) {
		for (Patient p : patients)
			if (p.pno == pno) {
				p.minutesTreat += minutes;
				
				return p.minutesTreat;
			}
		
		return 0;
	}
	
	// ������ �ʱ� ȯ�ڸ� ����ϴ� �޼ҵ�
	void initializeHospital() {
		// ȯ��ID 10005, �̸� ȫ�浿, ���� 18, �ܷ� ȯ�� �����Ͽ� patients�� ���
		// ȫ�浿�� 30�а� ������ �� ȫ�浿 ȯ���� ������ ���
		OutPatient hgd = new OutPatient(getNewPatientNo(), "ȫ�浿", 18, new Date() );
		patients.add(hgd);
		
		hgd.takeTreat(30);
		hgd.output("\n  * ȫ�浿 - ");

		// ȯ��ID 10001, �̸� ��û, ���� 22, �Կ��� 508�� �Կ� ȯ�� �����Ͽ� patients�� ���
		// �Կ�ȯ�� ��û�� (3�� ����) 50��, 60��, 40���� ġ��ް� 3�� �� �����
		InPatient sc = new InPatient(getNewPatientNo(), "��û", 22, new Date(), 508 );
		patients.add(sc);
		
		sc.takeTreat(50);
		sc.takeTreat(60);
		sc.takeTreat(40);
		sc.leaveHospitalAfter(3);
		sc.output("\n  * ��û - ");	
	}
}
