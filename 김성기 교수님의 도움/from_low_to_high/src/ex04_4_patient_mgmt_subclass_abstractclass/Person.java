package ex04_4_patient_mgmt_subclass_abstractclass;

//Person Ŭ����
//  - ClassForPatientMgmt Ŭ������ ���� Ŭ����
//  - ClassForPatientMgmt Ŭ�������� ��ü ����� ���� output() �޼ҵ带 ��ӹ���
//  - �ʵ� name, age, currentLocation
//  - �޼ҵ� goTo()�� ���� Ŭ����
class Person  extends ClassForPatientMgmt{
	String name;     int age;     String currentLocation;

	// �̸�, ���̰� �־����� �ʵ忡 �����ϴ� ��ü ������
	Person(String name, int age) {
		this.name = name;  this.age = age; 
	}

	// goTo(): ������ ��ü�� Ư�� ��ġ�� �̵��ϴ� ���� ��Ÿ���� �޼ҵ�.
	void goTo(String location) {
		this.currentLocation = location;  // ����ġ�� �־��� ��ҷ� ����
	}

	// goTo(): ������ ��ü�� �������� ���� ���� ��Ÿ���� �޼ҵ�
	void goTo(Clinic clinic) {
		this.currentLocation = clinic.clinicName; // ����ġ�� �־��� ������ �̸����� ����
	}

	void input() {
		this.name = SkScanner.getString("  o �̸� > ");
		this.age = SkScanner.getInt("  o ���� > ");
	}

	// toString(): �ʵ���� ���ڿ��� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
	public String toString() {
		return "�̸�:" + this.name + ", ����:" + this.age + ", ����ġ:" + this.currentLocation;
	}
}


