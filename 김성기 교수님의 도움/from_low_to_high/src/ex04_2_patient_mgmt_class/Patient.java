package ex04_2_patient_mgmt_class;

import java.util.Calendar;
import java.util.Vector;

// Patient Ŭ����: Person Ŭ������ ���� Ŭ������ �������� ����
class Patient {
	static int nextPid = 1;   // �����Ǵ� ȯ�� �������� pid�� �ο��ϱ� ���� Ŭ���� �ʵ�, ȯ�ڿ��� �ο��� �� 1�� ������

	String name;     int age;     String currentLocation;

	int pid;               // ȯ�� ���̵�
	Calendar birthdate;    // �������: Calendar Ŭ������ ��ü�� ������� ����
	
    Clinic clinicVisited;  // ������ �湮�� ������ ����

	Vector<Treatment> treatmentRecords = new Vector<Treatment>();  // ġ����� ������ �����ϴ� Vector ��ü

	// �̸�, ���̰� �־����� �ʵ忡 �����ϴ� ��ü ������
	 Patient(String name, int age) {
		this.name = name;  this.age = age; 
	}

	// �Ű����� �̸��� Calendar ��ü�� ��������� �־����� �̸� �ʵ忡 �����ϴ� ��ü ������: 
	Patient(String name, Calendar birthdate) {
		this(name, Date.getAge(birthdate));    // �̸��� ���� �ʱ�ȭ�ϴ� ��ü ������ ȣ���Ͽ� name�� age �ʱ�ȭ
		
		this.setPid();                         // ȯ�� ���̵� �ο��Ͽ� pid �ʵ忡 ����
		this.birthdate = birthdate;            // ������� �ʵ忡 �־��� ������� ����
	}

	// setPid(): ȯ�� ���̵� �ο��Ͽ� pid �ʵ忡 �����ϴ� �޼ҵ�: ȯ�� ��ü�� ���� pid�� �ο��ϹǷ� �׻� �� ��ü �����ڴ� ȣ��Ǿ����� ��
	void setPid() {
		this.pid = Patient.nextPid++;	// ȯ�ڿ��� ȯ�� ���̵� �ο���, nextPid��  ���� ȯ�ڸ� ���� 1 ������Ŵ	  
	}
	
	// thereIsPatient(): �̸�, YYYYMMDD ����� ���� ��������� �־����� ȯ�� ��ü�� �����Ͽ� ��ȯ�ϴ� Ŭ���� �޼ҵ�
	static Patient thereIsPatient(String name, int birthdate) {
		return new Patient(name, Date.getCalendar(birthdate));
	}
	
	// thereIsPatient(): �̸�, ����, �����ȣ, �����о߸� �Է��Ͽ� �ǻ� ��ü��  �����Ͽ� ��ȯ�ϴ� Ŭ���� �޼ҵ�
	static Patient thereIsPatient () {
		System.out.println("\n\n  ** ȯ��  ���� ** \n");

		String name = SkScanner.getString("  o ȯ�� �̸� > ");    
		int birthdate = SkScanner.getInt("  o ������� > ");
				
		return thereIsPatient(name, birthdate);
	}
	
	// goTo(): ������ ��ü�� Ư�� ��ġ�� �̵��ϴ� ���� ��Ÿ���� �޼ҵ�.
	void goTo(String location) {
		this.currentLocation = location;  // ����ġ�� �־��� ��ҷ� ����
	}

	// goToClinic(): ������ ���� ��Ÿ���� �޼ҵ�
	//  - ����ġ�� �湮�� ���� �̸����� �����ϸ� �湮 ������ �־��� �������� ������
	void goToClinic(Clinic clinic) {
		this.goTo(clinic.clinicName);
		clinicVisited = clinic;
	}

    // getTreat(): ����޴ٸ� ��Ÿ���� �޼ҵ�
	//  - �Ű������� ���� �ǻ�, ����Ұ�, ó��, ����ð�(��), ����� �־���
	//  - ��������� �������� �����Ͽ� �̸� �����Ϻ��� Vector ��ü treatmentRecords�� ������
	void getTreat(Doctor doctor, String diagnosisOpinion,  String prescription, int minutes) {
		Treatment treat = new Treatment(this, doctor, diagnosisOpinion, prescription, minutes);

		treatmentRecords.add(treat);
	}

	// input(): ȯ�� �̸��� ��������� �Է��Ͽ� �ʵ忡 �����ϴ� �޼ҵ�
	void input() {
		this.name = SkScanner.getString("  o ȯ�� �̸� > ");
		int birthdate = SkScanner.getInt("  o �������(YYYYMMDD) > ");

		// �Է¹��� YYYYMMDD ����  ����� ��������� Calendar ��ü�� �����ϱ� ���� �ڵ�
		Calendar cal = Calendar.getInstance();  // Calendar ��ü ����
		Date.setYearMonthDate(cal, birthdate);  //  YYYYMMDD ����  ����� ��������� Calendar ��ü�� ����
		
		this.birthdate = cal;	
		System.out.println("  **** ������� = " + cal);

	}

	// toString(): �־����� Ÿ��Ʋ�� ����� �� ȯ�� �̸��� ��������� �Է��Ͽ� �ʵ忡 �����ϴ� �޼ҵ�
	void input(String title) {
		System.out.println(title);   // Ÿ��Ʋ ���
		this.input();                 // �̸��� ��������� �Է��Ͽ� �����ϱ� ���� input()�޼ҵ� ȣ��
	}

	// �ʵ���� ���ڿ��� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
	public String toString() {
		String str =  "  * ȯ�� �⺻���� - " + "�̸�:" + this.name + ", ����:" + this.age + ", ����ġ:" + this.currentLocation
                                         + ", pid: "+pid + ", �������: " + Date.getDateString(birthdate) + "\n\n" ;
		int cnt = this.treatmentRecords.size();
		
		for (int i = 0; i < cnt; i++) {
			Treatment tr = this.treatmentRecords.get(i);
			str = str + tr.toString() + "\n";
		}
		
		return str;
	}	
	
	// output(): ��ü ��� �޼ҵ� - ��� �ʵ� �� ���
	void output() {
		System.out.println(this.toString());
	}

	// output(): ��ü ��� �޼ҵ� - �־��� Ÿ��Ʋ�� ����� ��  ��� �ʵ� �� ���
	void output(String title) {
		System.out.print(title);  // Ÿ��Ʋ ��� - �̶����� �ٹٲ��� ���� ����(�ٹٲ��� �Ϸ��� title���� ���� '\n'�� ÷���ؾ� ��)
		this.output();
	}
}