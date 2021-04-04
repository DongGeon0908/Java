package ex8_3_5_student_emp_mgmt;

// Person Ŭ������ ���� Ŭ������ Student�� ����
class Student extends Person {
	String schoolname;  // �б���
	int    grade;		// �г�

	// �Ű����� ���� ��ü ������
	Student() {
	}

	// �̸�, ����, �б���, �г�, ��Ұ� �־����� �ʵ忡 �����ϴ� ��ü ������
	//  ���⿡�� ��ӹ��� �ʵ��� �̸�, ���̸� �ʱ�ȭ�ϱ� ���� ���� Ŭ������ ��ü ������ ȣ��
	Student(String name, int age, String schoolname, int grade) {
		super(name, age);     // Person�� ��ü ������ ȣ���Ͽ� ��� �ʵ� �ʱ�ȭ 
		this.schoolname = schoolname;  this.grade = grade;
	}
	
	// goToSchool(): �л��� ��ϴ� ���� ��Ÿ���� �޼ҵ�
	//    currentLocation�� schoolname���� �����ϱ� ���� goTo() �޼ҵ� ȣ��
	void goToSchool() {
		goTo(this.schoolname); 
	}

	// toString(): ��ü�� �ʵ���� ���ڿ��� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
	//   �� �޼ҵ�� Person Ŭ������ �޼ҵ带 �������̵�
	//   ����ʵ��� name, age, cuurentLocation�� ���� �ʵ���� ���ڿ��� �����ϱ� ����  
	//   super.toString()�� �̿��Ͽ� ���� Ŭ������ toString() �޼ҵ� ȣ��
	public String toString() {
		return  super.toString() + 
				", �б���:" + this.schoolname + ", �г�:" + this.grade;  
	}

	// ��ü�� �ʵ���� ����ϴ� �޼ҵ�
	//   �� �޼ҵ�� Person Ŭ������ �޼ҵ带 �������̵�
	void output() {
		System.out.println("  * �л� - " + this.toString());
	}
}
