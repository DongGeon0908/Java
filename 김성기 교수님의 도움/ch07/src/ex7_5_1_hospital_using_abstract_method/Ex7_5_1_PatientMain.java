package ex7_5_1_hospital_using_abstract_method;

/**
 * [ Patient, OutPatient, InPatient, PatientMain Ŭ���� ] : 
 *       abstract Ŭ������ �ʿ伺�� ���̴� ���� 
 * 
 *   o �ܷ� ȯ�ڿ� �Կ� ȯ�ڸ� ġ���ϴ� ������ ��Ȳ�� ������ ����.
 *     - ȯ�ڴ� �ܷ� ȯ�ڿ� �Կ� ȯ�ڷ� ���е� 
 *     - �ܷ� ȯ�ڴ� ����ð��� ���� ������ �����ϸ�, �Կ� ȯ�ڴ� ����ð��� �Կ��ϼ��� ���� ������ ������
 *     - ���������� �ܷ� ȯ�ڿ� �Կ�ȯ�ڸ� ȯ�� ��ü�� ���������� �ٷ����ϸ�, ���� �и��� ȯ�ڷε� �ٷ� �� �־�� ��
 *     
 *   o Ŭ���� ����
 *     - �̷��� ��Ȳ���� ȯ�ڸ� ���� Patient Ŭ����, ���� Ŭ�������� �ܷ�ȯ�� outPatient Ŭ������  
 *       �Կ�ȯ�� inPatient Ŭ������ ����
 *       
 *   o Patient Ŭ����
 *     - ���� Ŭ�����̸�, abstract Ŭ������ �����Ͽ� ��ü �������� ����
 *     - �Ϲ� ȯ�ڸ� ���� �ʵ�� �޼ҵ� ����
 *     - ������ ����ϴ� getPayFee() �޼ҵ带 abstract �޼ҵ�� �ۼ�
 *     - ���� Ŭ������ OutPatient�� InPatient�� ���� Ŭ������ getPayFee() �޼ҵ带 �ݵ�� �����ؾ� �� 
 *     
 *   o OutPatient Ŭ���� 
 *     - �ܷ� ȯ�ڸ� ���� �ʵ�� �޼ҵ带 �߰��� ���� ���� Ŭ����   
 *        
 *   o InPatient Ŭ���� 
 *     - �Կ� ȯ�ڸ� ���� �ʵ�� �޼ҵ带 �߰��� ���� ���� Ŭ����     
 *     
 *   o �������
 *     - �ܷ�ȯ�ڿ� �Կ�ȯ���� ���� ������ ����� ����, ����, �����, ���� ���, ���� �� óġ � ���� �ٸ�
 *     - ���⿡���� ������ ������� �ܷ� ȯ�ڿ� �Կ� ȯ���� ������ ����� 
 */

/*
 *  Patient Ŭ����: �ܷ�ȯ�ڿ� �Կ�ȯ�� �� ���� Ŭ������ �������� ������ ������ abstract Ŭ���� 
 */
abstract class Patient {
	int pID; String name;  int age;  int minutesTreat;  // ȯ��ID, �̸�, ����, ����ð�

	// ��ü ������
	Patient(int pID, String name, int age) {
		this.pID = pID; this.name = name; this.age = age; 
	}

	// �־��� ����ð�  minutes�� minutesTreat �ʵ忡 �����ϴ� �޼ҵ�
	void takeTreat(int minutes) {  
		this.minutesTreat += minutes;
	} 

	// ������ ����Ͽ� ��ȯ�ϴ� abstract �޼ҵ�	
	//   ���� ������� �ܷ�ȯ�� �Ǵ� �Կ�ȯ�� �� ���� Ŭ������ ��ü�� ���� ���ǹǷ� 
	//   �� Ŭ���������� abstract �޼ҵ�� �ۼ���
	abstract int getPayFee(); 

	// ȯ�� ������ ���ڿ��� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
	public String toString() {
		return "ID:" + pID + ", name:" + name +
				", age:" + age + ", minutes of treat:" + minutesTreat;
	}

	//  ȯ�� ������ ����ϴ� �޼ҵ�
	void output(String msg) {
		System.out.println(msg + toString());
	}
}

/*
 *  OutPatient Ŭ����: Patient Ŭ������ ����  Ŭ������ abstract �޼ҵ��� getPayFee()�� �����ϴ�  Ŭ���� 
 */
class OutPatient extends Patient { // Patient Ŭ������ ���� Ŭ����
	String dateTreatment; // (ġ�ᳯ¥) 

	OutPatient(int pID, String name, int age, String dateTreatment) {
		super(pID, name, age);
		this.dateTreatment = dateTreatment;
	}

	// Patient Ŭ������ abstract �޼ҵ带 ������ �޼ҵ�� ������ ����Ͽ� ��ȯ
	//    �ܷ� ȯ�� ������ = �⺻�����(6000��) + �д������(500��) * ����ð�
	int getPayFee() { 
		return 6000 + minutesTreat * 500; 
	}

	public String toString() {
		return super.toString() + ", date of Treatment:" + dateTreatment + 
				", pay fee:" + getPayFee();
	}
}

/*
 *  InPatient Ŭ����: Patient Ŭ������ ����  Ŭ������ abstract �޼ҵ��� getPayFee()�� �����ϴ�  Ŭ���� 
 */
class InPatient extends Patient { // Patient Ŭ������ ���� Ŭ����

	String dateHospitalization; // (�Կ���¥)
	int roomNo; 				// (�Կ��� ��ȣ)
	int daysHospitalization; 	// (�Կ��ϼ�) �ʵ带 �߰��� ����

	InPatient(int pID, String name, int age, String dateHospitalization, int roomNo) {
		super(pID, name, age);
		this.dateHospitalization = dateHospitalization;
		this.roomNo = roomNo;
	}

	// ����� ó���ϱ� ���� �־��� days�� daysHospitalization �ʵ忡 �����ϴ� �޼ҵ�
	void leaveHospitalAfter(int days) { 
		daysHospitalization = days;
	}

	// Patient Ŭ������ abstract �޼ҵ带 ������ �޼ҵ�� ������ ����Ͽ� ��ȯ
	//    �Կ�ȯ�� ������ = �⺻�����(1����) + �д������(500��) * ����ð�  + �Կ��ϼ� * 1�� �Կ���(2����)
	int getPayFee() { 
		return 10000 + minutesTreat * 500 + daysHospitalization * 20000 ;
	}

	public String toString() {
		return super.toString() + ", date of hospitalization:" + dateHospitalization +
				", room No:" + roomNo + ", days of Hospitalization:" +
				daysHospitalization + ", pay fee:" + getPayFee();
	}
}

class Ex7_5_1_PatientMain {
	public static void main(String[] args)  {
		// ȯ��ID 10005, �̸� ȫ�浿, ���� 18, ���ᳯ¥ "2019-12-08"�� �ܷ� ȯ��
		// ȫ�浿�� 30�а� ������ �� ȫ�浿 ȯ���� ������ ���
		OutPatient hgd = new OutPatient(10005, "ȫ�浿", 18, "2019-12-08" );
		hgd.takeTreat(30);
		hgd.output("\n  * ȫ�浿 - ");

		// ȯ��ID 10001, �̸� ��û, ���� 22, �Կ���¥ "2019-12-02", �Կ��� 508��
		// �Կ�ȯ�� ��û�� (3�ϵ���) 50��, 60��, 40���� ġ��ް� 3�� �� �����
		InPatient sc = new InPatient(10001, "��û", 22, "2019-12-01", 508 );
		sc.takeTreat(50);
		sc.takeTreat(60);
		sc.takeTreat(40);
		sc.leaveHospitalAfter(3);
		sc.output("\n  * ��û - ");
	}
}
