package ex7_4_1_call_superclass_overrinding_method;

// Student Ŭ������ ���� Ŭ������ �ʵ��л��� ��Ÿ���� PrimaryStudent Ŭ����
class PrimaryStudent extends Student {
	int classNo;    // ��
	int noInClass;  // �ݿ����� ��ȣ

	// �ʵ��л� ������ �־����� �ʵ忡 �����ϴ� ��ü ������
	PrimaryStudent(String name, int age, String schoolname, int grade, int classNo, int noInClass) {
		this.name = name;  this.age = age;                       
		this.schoolname = schoolname;       this.grade = grade;
		this.classNo = classNo;  this.noInClass = noInClass;
	}
	
	// output(): ������ ��ü�� ��� �ʵ� ���� ����ϴ� �޼ҵ�
	void output() {
		System.out.println("\n  * �ʵ��л�-  �̸�:" + this.name + ", ����:" + this.age + 
				", ����ġ:" + this.currentLocation +
				", �б���:" + this.schoolname + ", �г�:" + this.grade + 
				", ��:" + this.classNo + ", ��ȣ:" + this.noInClass);
	}
}