package ex04_4_patient_mgmt_subclass_abstractclass;

import java.util.Calendar;
import java.util.Vector;

// Patient Ŭ����: ȯ�ڸ� ��Ÿ���� Ŭ����
//  - Person Ŭ������ ���� Ŭ����
//  - Person Ŭ�������� �ʵ�� �޼ҵ带 ��ӹ���
class Patient extends Person {
	static int nextPid = 1;   // �����Ǵ� ȯ�� ���Ը��� pid�� �ο��ϱ� ���� Ŭ���� �ʵ�, ȯ�ڿ��� �ο��� �� 1�� ������

	int pid; 
	Calendar birthdate;  
	
    Clinic clinicVisited;

	Vector<Treatment> treatmentRecords = new Vector<Treatment>();  // ġ����� ������ �����ϴ� Vector ��ü

	// �Ű����� �̸��� Calendar ��ü�� ��������� �־����� �̸� �ʵ忡 �����ϴ� ��ü ������: 
	Patient(String name, Calendar birthdate) {
		super(name, Date.getAge(birthdate));    // ���� Ŭ������ ��ü ������ ȣ���Ͽ� name�� age �ʱ�ȭ
		
		this.setPid();                     // ȯ�� ���̵� �ο��Ͽ� pid �ʵ忡 ����
		this.birthdate = birthdate;   // ������� �ʵ忡 �־��� ������� ����
	}

	// ȯ�� ���̵� �ο��Ͽ� pid �ʵ忡 �����ϴ� �޼ҵ�: ȯ�� ��ü�� ���� pid�� �ο��ϹǷ� �׻� �� ��ü �����ڴ� ȣ��Ǿ����� ��
	void setPid() {
		this.pid = Patient.nextPid++;	// ȯ�ڿ��� ȯ�� ���̵� �ο���, nextPid��  ���� ȯ�ڸ� ���� 1 ������Ŵ	  
	}
	
	// �̸�, YYYYMMDD ����� ���� ��������� �־����� ȯ�� ��ü�� �����Ͽ� ��ȯ�ϴ� Ŭ���� �޼ҵ�
	static Patient thereIsPatient(String name, int birthdate) {
		return new Patient(name, Date.getCalendar(birthdate));
	}
	
	// �̸�, ����, �����ȣ, �����о߸� �Է��Ͽ� �ǻ� ��ü��  �����Ͽ� ��ȯ�ϴ� Ŭ���� �޼ҵ�
	static Patient thereIsPatient () {
		System.out.println("\n\n  ** ȯ��  ���� ** \n");

		String name = SkScanner.getString("  o ȯ�� �̸� > ");    
		int birthdate = SkScanner.getInt("  o ������� > ");
				
		return thereIsPatient(name, birthdate);
	}

	// ������ ���� ��Ÿ���� �޼ҵ�
	//  - ����ġ�� �湮�� ���� �̸����� �����ϸ� �湮 ������ �־��� �������� ������
	void goToClinic(Clinic clinic) {
		this.goTo(clinic.clinicName);
		clinicVisited = clinic;
	}

    // ����޴ٸ� ��Ÿ���� �޼ҵ�
	//  - �Ű������� ���� �ǻ�, ����Ұ�, ó��, ����ð�(��), ����� �־���
	//  - ��������� �������� �����Ͽ� �̸� �����Ϻ��� Vector ��ü treatmentRecords�� ������
	void getTreat(Doctor doctor, String diagnosisOpinion,  String prescription, int minutes) {
		Treatment treat = new Treatment(this, doctor, diagnosisOpinion, prescription, minutes);

		treatmentRecords.add(treat);
	}

	// ȯ�� �̸��� ��������� �Է��Ͽ� �ʵ忡 �����ϴ� �޼ҵ�
	void input() {
		this.name = SkScanner.getString("  o ȯ�� �̸� > ");
		int birthdate = SkScanner.getInt("  o �������(YYYYMMDD) > ");

		// �Է¹��� YYYYMMDD ����  ����� ��������� Calendar ��ü�� �����ϱ� ���� �ڵ�
		Calendar cal = Calendar.getInstance();  // Calendar ��ü ����
		Date.setYearMonthDate(cal, birthdate);  //  YYYYMMDD ����  ����� ��������� Calendar ��ü�� ����
		
		this.birthdate = cal;	
		System.out.println("  **** ������� = " + cal);

	}

	// �־����� Ÿ��Ʋ�� ����� �� ȯ�� �̸��� ��������� �Է��Ͽ� �ʵ忡 �����ϴ� �޼ҵ�
	void input(String title) {
		System.out.println(title);   // Ÿ��Ʋ ���
		this.input();                 // �̸��� ��������� �Է��Ͽ� �����ϱ� ���� input()�޼ҵ� ȣ��
	}

	// �ʵ���� ���ڿ��� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
	public String toString() {
		String str =  "  * ȯ�� �⺻���� - " + super.toString() + ", pid: "+pid + ", �������: " + Date.getDateString(birthdate) + "\n\n" ;
		int cnt = this.treatmentRecords.size();
		
		for (int i = 0; i < cnt; i++) {
			Treatment tr = this.treatmentRecords.get(i);
			str = str + tr.toString() + "\n";
		}
		
		return str;
	}	
}