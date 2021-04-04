package example11_2_person_mgmt;

import java.lang.Comparable;
 
// Person Ŭ����
//  �ʵ� name, age, currentLocation
//  �޼ҵ� goTo(), output()�� ���� Ŭ����
class Person implements Comparable<Person> {
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
	
	// �� �޼ҵ�� java.lang.Comparable Ŭ������ �߻� �޼ҵ带
	// �����ϴ� �޼ҵ�μ�, �̸� ������ ���� Person ��ü�� �����ϰ� ��
	public int compareTo(Person p) {
		return this.name.compareTo(p.name);
	}
		
	// Person ��ü�� ��� �ʵ��� ����  ���ڿ��� �����ϴ� �޼ҵ�
	public String toString() {
		return "�̸�:" + this.name + ", ����:" + this.age + 
			", ����ġ:" + this.currentLocation;
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
