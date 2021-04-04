package ex04_2_patient_mgmt_class;

//Person Ŭ����
//�ʵ� name, age, currentLocation
//�޼ҵ� goTo(), output()�� ���� Ŭ����
class Person {
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

	// output(): ��ü ��� �޼ҵ� - toString() �޼ҵ� �̿��Ͽ� ��� �ʵ� ���� ���
	void output() {
		System.out.println(this.toString());
	}

	// output(): ��ü ��� �޼ҵ� - �־��� Ÿ��Ʋ�� ����� �� output() �޼ҵ�� ��� �ʵ� �� ���
	void output(String title) {
		System.out.print(title);  // Ÿ��Ʋ ��� - �̶����� �ٹٲ��� ���� ����(�ٹٲ��� �Ϸ��� title���� ���� '\n'�� ÷���ؾ� ��)
		this.output();
	}
}


