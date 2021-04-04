package ex11_4_generic_class;

// Person Ŭ����
//   �ʵ� name, age, currentLocation
//   �޼ҵ� goTo(), output()�� ���� Ŭ����
class Person {
	String name;     int age;     String currentLocation;

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
	
	// Person ��ü�� ��� �ʵ��� ����  ���ڿ��� �����ϴ� �޼ҵ�
	public String toString() {
		return "�̸�: " + this.name + ", ����: " + this.age + 
				(this.currentLocation != null ? ", ����ġ: " + this.currentLocation : "");
	}
 
	// output(): Person ��ü�� ��� �ʵ��� ���� ����ϴ� �޼ҵ�
	void output() {
		System.out.println("  * ��� - " + toString());
	} 
	
	// input(): Person ��ü�� ��� �ʵ��� ���� �Է��ϴ� �޼ҵ�
	void input(String prompt) {
		System.out.println(prompt);
		name = SkScanner.getString("  o �̸� > ");
		age = SkScanner.getInt("  o ���� > ");
		currentLocation = SkScanner.getString("  o ����ġ > ");
	}	
}

// Person Ŭ������ ���� Ŭ������ Student�� ����
//   ��� Ư��: Person Ŭ������ �ʵ��� name, age, currentLocation, �޼ҵ� goTo()
//   ���� Ư��: �ʵ� schoolname, grade, �޼ҵ� goToSchool(), outputState()
class Student extends Person {
	String schoolname;  // �б���
	int    grade;		// �г�

	// �̸�, ���̰� �־����� �ʵ忡 �����ϴ� ��ü ������
	Student(String name, int age) {
		super(name, age);  // ���� Ŭ���� ��ü ������ �̿��Ͽ� �ʱ�ȭ
	}

	// �̸�, ����, �б���, �г��� �־����� �ʵ忡 �����ϴ� ��ü ������
	Student(String name, int age, String schoolname, int grade) {
		this(name, age);  
		this.schoolname = schoolname;       this.grade = grade;
	}

	// goToSchool(): �л��� ��ϴ� ���� ��Ÿ���� �޼ҵ�
	//    currentLocation�� schoolname���� �����ϱ� ���� goTo() �޼ҵ� ȣ��
	void goToSchool() {
		goTo(this.schoolname); 
	}

	// Person ��ü�� ��� �ʵ��� ����  ���ڿ��� �����ϴ� �޼ҵ�
	public String toString() {
		return super.toString() + ", �б���:" + this.schoolname + ", �г�:" + this.grade;
	}

	// output(): Student ��ü�� ��� �ʵ��� ���� ����ϴ� �޼ҵ�
	void output() {
		System.out.println("  * �л� - " + toString());
	}
}
