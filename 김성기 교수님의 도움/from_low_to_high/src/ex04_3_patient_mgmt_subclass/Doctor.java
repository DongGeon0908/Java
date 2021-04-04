package ex04_3_patient_mgmt_subclass;

import java.util.Calendar;

//Doctor Ŭ����: Person Ŭ������ ���� Ŭ����
class Doctor extends Person{
	int licenseNo;            // �ǻ�����ȣ
	String major;             // �����о�
	Clinic workingClinic;     // �ٹ�����
	
	// �̸�, ����, �����ȣ, �����о߰� �־����� �̸� �ʵ忡 �����ϴ� ��ü������
	Doctor(String name, int age, int licenseNo, String major){
		super(name, age);
		this.licenseNo = licenseNo;
		this.major = major; 
	}

	// �̸�, ����, �����ȣ, �����о�, �ٹ������� �־����� �̸� �ʵ忡 �����ϴ� ��ü������
	Doctor(String name, int age, int licenseNo, String major, Clinic workingClinic ){
		this(name, age, licenseNo, major); 
		this.workingClinic  = workingClinic;
	}
	
	// thereIsDoctor(): �־��� �̸�, ����, �����ȣ, �����о��� �ǻ� ��ü�� �����Ͽ� ��ȯ�ϴ� Ŭ���� �޼ҵ�
	static Doctor thereIsDoctor(String name, int age, int licenseNo, String major) {
		return new Doctor(name, age, licenseNo, major);
	}
	
	// thereIsDoctor(): �̸�, ����, �����ȣ, �����о߸� �Է��Ͽ� �ǻ� ��ü��  �����Ͽ� ��ȯ�ϴ� Ŭ���� �޼ҵ�
	static Doctor thereIsDoctor() {
		System.out.println("\n\n  ** �ǻ�  ���� ** \n");

		String name = SkScanner.getString("  o �ǻ� �̸� > ");    
		int age = SkScanner.getInt("  o ���� > ");
		int licenseNo = SkScanner.getInt("  o �ǻ�����ȣ > ");
		String major = SkScanner.getString("  o �����о� > ");
				
		return thereIsDoctor(name, age, licenseNo, major);
	}
	
	//  goToWork(): ����ϴٸ� ��Ÿ���� �޼ҵ�
	//  - ����ϸ� �ٹ��������� ���Ƿ� this.workingClinic.clinicName���� goTo() �޼ҵ� ȣ��
	void goToWork() {
		this.goTo(this.workingClinic.clinicName);
	}
	
	// openClinic(): �ǻ簡 ������ �����ϴ� ���� ��Ÿ���� �޼ҵ�
	//  - �����̸�, ������¥, ��ȭ��ȣ ���� �Է¹޾� ���� ������ ���� ���� ��ü �����Ͽ� ��ȯ
	Clinic openClinic() {
	
		System.out.println("\n\n  ** ���� ���� ** \n");
		System.out.println("  * ���� �ǻ�: " + getDoctorInfoString() + "\n" );
  
		return  this.inputOpenClinic();  // ���� ������ �Է��Ͽ� ���� ��ü �����Ͽ� ��ȯ�� ���� ��ü ��ȯ
	}
	
	// openClinic(): �ǻ簡 ������ �����ϴ� ���� ��Ÿ���� �޼ҵ�
	//   - �����̸�, Calendar ��ü�� ������¥, ��ȭ��ȣ�� �Ű������� ����
	//   - ���� ��ü �����ϰ� �ǻ��� �ٹ������� ������ ���� ��ü�� ����
	Clinic openClinic(String clinicName, Calendar openDate, String telno) {
		Clinic clinic = new Clinic(clinicName, this, openDate, telno);  // ���� ��ü ����
		
		this.setWorkingClinic(clinic);	// ������ ������ �ǻ�� �� �������� �ٹ��ϹǷ� �ٹ������� ������ �������� ����
		
		return clinic;
		
	}

	// openClinic(): �ǻ簡 ������ �����ϴ� ���� ��Ÿ���� �޼ҵ�
	//   - �����̸�, ������¥, ��ȭ��ȣ�� �Ű������� ����
	//   - ������¥�� YYYYMMDD ����� 8�ڸ� ������ �־���
	Clinic openClinic(String clinicName, int openDate, String telno) {
		
		Calendar cal = Date.getCalendar(openDate);  //  YYYYMMDD ����� 8�ڸ� ������ �־����� ��¥�� Calendar ��ü�� ��ȯ
		 
		Clinic clinic = this.openClinic(clinicName, cal, telno);  // �����̸�, Calendar ��ü�� ������¥, ��ȭ��ȣ�� �Ű������� ���� �޼ҵ� ȣ��  
		
		return clinic;		
	}

	// inputOpenClinic(): ���� ������ �Է��Ͽ� �Էµ� ������ ���� ��ü �����Ͽ� ��ȯ�ϴ� �޼ҵ�
	//   - �����̸�, ������¥, ��ȭ��ȣ�� �Է¹���
	Clinic inputOpenClinic() {
		String clinicName = SkScanner.getString("  o ���� �̸� > ");    
		int dateOpen = SkScanner.getInt("  o ���� ������(YYYYMMDD) > ");
		String telno = SkScanner.getString("  o ��ȭ��ȣ > ");
		
		return openClinic(clinicName, dateOpen, telno);  // ���� ��ü �����Ͽ� ��ȯ
	}
	
	
	// �ٹ����� �ʵ� �� �־��� �������� �����ϴ� 
	void setWorkingClinic(Clinic clinic) {
		this.workingClinic = clinic;		
	}
		
	// �������� ���ϱ� �����ϴ� ���� ��Ÿ���� �޼ҵ�
	void startWorkAt(Clinic clinic) {
		this.workingClinic = clinic;  // �־��� ������ �ٹ��������� ����
	}
	
	// ȯ�ڸ� ġ���Ͽ�   ����Ұ�, ó��, ����ð� ����  ȯ�� ������ �����ϴ� �޼ҵ�
	void treats(Patient patient, String diagnosisOpinion,  String prescription, int minutes) {
		// ȯ�ڳ��� �����Ϻο� ���᳻���� �����ϰ� �ϱ� ����
		// Patient Ŭ������  getTreat() �޼ҵ� ȣ��
		patient.getTreat(this, diagnosisOpinion, prescription, minutes);
	}
	
	void input() {
		super.input();
		
		this.licenseNo = SkScanner.getInt("  o �����ȣ > ");
		this.major = SkScanner.getString("  o �����о� > ");
	}
	
	// �ʵ���� ���ڿ��� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
	public String toString() {
		return super.toString() + ", �����ȣ:" + this.licenseNo + ", �����о�:" + this.major;
	}
		
	// �ǻ� �̸�, �����ȣ, �����о߸� ����ϴ� �޼ҵ�
	String getDoctorInfoString() {
		return this.name +  "(�����ȣ: " + this.licenseNo + ", �����о�: " + this.major + ")";
	}
}
