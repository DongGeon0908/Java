package ex8_3_5_student_emp_mgmt;

class Person {
	String name;    		// �̸�
	int    age;				// ����
	String currentLocation;	// ����ġ

	// �Ű����� ���� ��ü ������
	Person() {
	}

	// �̸�, ����, ��Ұ� �־����� �ʵ忡 �����ϴ� ��ü ������
	Person(String name, int age) {
		this.name = name;  this.age = age; 
	}
	
	// goTo(): ������ ��ü�� Ư�� ��ġ�� �̵��ϴ� ���� ��Ÿ���� �޼ҵ�.
	void goTo(String location) {
		this.currentLocation = location;
	}

	// toString(): ��ü�� �ʵ���� ���ڿ��� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
	//   �� �޼ҵ�� Object Ŭ������ �޼ҵ带 �������̵�
	public String toString() {
		return "�̸�:" + this.name + ", ����: " + this.age 
				+ ", ����ġ: " + this.currentLocation;  
	}

	// ��ü�� �ʵ���� ����ϴ� �޼ҵ�
	void output() {
		System.out.println("  * ��� - " + this.toString());
	}
}
