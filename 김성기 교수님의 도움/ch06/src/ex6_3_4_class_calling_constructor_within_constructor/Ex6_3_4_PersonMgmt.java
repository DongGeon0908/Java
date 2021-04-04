// ������ Ŭ�������� ex6_3_4_class_calling_constructor_within_constructor ��Ű���� ���ԵǴ� Ŭ�������� ��Ÿ��
package ex6_3_4_class_calling_constructor_within_constructor;

/**
 * [ Person, PersonMgmt Ŭ���� ] :
 *       ��ü ������ ������ ��ü ������ ȣ���� �����ִ� ���α׷�
 *         
 *   o Ŭ���� ���� 3: ��ü ������ ���� Ŭ����
 *     - ��ü ������: ��ü �����ϸ� ����Ǵ� Ư���� �޼ҵ�
 *     - ��ü ������ ��ü �ʵ� �� ������ �ϳ��� �������� �̷�����Ƿ� 
 *       ���α׷��� ���� �������� 
 *     
 *   o ��ü ������ ������ �ٸ� ��ü ������ ȣ��
 *     - ��ü ������ ������ ��ü �����ڸ� ȣ���� �� ����
 *     - ��ü ������ ������ ��ü �����ڸ� ȣ���� �� new �����ڸ� ������� ����
 *     - ��ü ������ ������ ���� Ŭ������ �ٸ� ��ü �����ڸ� ȣ���� �� << this(...); >>�� ȣ����
 */
 
class Person {
	String 	name;    	      // �̸��� ������ �ʵ�
	int    	  age;		      // ���̸� ������ �ʵ�
	String 	currentLocation;  // ����ġ�� ������ �ʵ�

	// �̸��� �Ű������� �־����� �̸� �ʵ� name�� �����ϴ� ��ü ������
	Person(String name) {
		this.name = name;  	// �Ű����� name�� this ��ü�� name �ʵ忡 ����
	}

	// �̸�, ���̰� �Ű������� �־����� �̸� �ʵ� name, age�� �����ϴ� ��ü ������
	Person(String name, int age) {
		this(name);      // �̸��� �����ϴ� ��ü �����ڸ� ȣ���Ͽ� name ����
		this.age = age;  // �Ű����� age�� this ��ü�� age �ʵ忡 ����
	}

	// �̸�, ����, ��Ұ� �Ű������� �־����� �̸� �ش� �ʵ忡 �����ϴ� ��ü ������
	Person(String name, int age, String location) {
		this(name, age);   // �̸��� ���̸� �����ϴ� ��ü �����ڸ� ȣ��
		this.currentLocation = location; // location�� currentLocation �ʵ忡 ����
	}
}

class Ex6_3_4_PersonMgmt {
	public static void main(String[] args) {
		// �̸��� �����ϴ� ��ü ������ ȣ���Ͽ� Person ��ü ����
		Person p1 = new Person("ȫ�浿");

		// �̸�, ���̸� �����ϴ� ��ü ������ ȣ���Ͽ� Person ��ü ����
		Person p2 = new Person("�̸���", 20);

		// �̸�, ����, ����ġ�� �����ϴ� ��ü ������ ȣ���Ͽ� Person ��ü ����
		Person p3 = new Person("��ö��", 23, "��������");      

		System.out.println("\n  * p1 ��ü - �̸�: " + p1.name + ", ����: " + p1.age
				+ ", ����ġ: " + p1.currentLocation );
		System.out.println("\n  * p2 ��ü - �̸�: " + p2.name + ", ����: " + p2.age
				+ ", ����ġ: " + p2.currentLocation );
		System.out.println("\n  * p3 ��ü - �̸�: " + p3.name + ", ����: " + p3.age
				+ ", ����ġ: " + p3.currentLocation );
	}
}

/*
 * [ ���α׷� ���� �� ���� ]
 * 
 *   1) �� ���α׷��� ��ü �����ڿ��� ��ü ������ ȣ���� ���캸��.
 *   
 *      - �� ��, ��ü ������ �̸��� Ŭ���� �̸��� �ƴ϶� this���� Ȯ���϶�.
 *      
 *   2) ���α׷��� �����ϰ� ����� Ȯ���϶�.  
 *   
 *  
 * [ �ǽ����� ]
 * 
 *   o �̸�, ����ġ�� �־����� �̸� �ʵ忡 �ʱ�ȭ�ϴ� Person Ŭ������ ��ü �����ڸ� �ۼ��϶�.
 *     �� ��, �̹� ������ ��ü �����ڸ� �ݵ�� ȣ���ؾ� �Ѵ�.
 */
