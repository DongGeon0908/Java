// ������ Ŭ�������� ex6_3_2_class_with_method_storing_field ��Ű���� ���ԵǴ� Ŭ�������� ��Ÿ��
package ex6_3_2_class_with_method_storing_field;

/**
 * [ Person, Book, PersonMgmt Ŭ���� ] :
 *       "23���� ��ö���� ���������� �����翡�� ������ ���� 10000���� 
 *       ȫ�浿���� �����Ͽ���"��� ��Ȳ�� ��Ÿ���� �ʺ����� Java ���α׷�
 *     
 *   o Ŭ���� ���� 2: �ʵ� �� ���� �޼ҵ� ���� Ŭ����
 *     - �ʵ� �� ���� �޼ҵ�� �ʵ� �� �ʱ�ȭ �޼ҵ�� setter �޼ҵ尡 ����
 *     - ��ü ���� �� �ʵ� �� ���� �޼ҵ带 �̿��Ͽ� ���ϰ� �ʵ忡 �� ���� 
 *     
 *   o �ʵ� �ʱ�ȭ �޼ҵ�
 *     - ��ü ���� ���� �Ű������� �־����� ������ �ʵ尪��� �����ϴ� �޼ҵ�
 *     - initialize �Ǵ� initializePerson �� �ʱ�ȭ ��Ÿ���� �޼ҵ� �̸� ���
 *     - �� Ŭ�������� ���� �ʵ� �ʱ�ȭ �޼ҵ� �ۼ� ����
 *   
 *   o setter �޼ҵ�
 *     - �Ű������� �־����� �ϳ��� ���� �ʵ尪���� �����ϴ� �޼ҵ�
 *     - setName, setAge ��� ���� �� set+�ʵ�� ���� �޼ҵ� �̸� ���
 *     - ����, setter �޼ҵ��� �ݴ� ����� �ʵ� �� ��ȯ�ϴ� getter �޼ҵ嵵 ����
 *     - ��� �ʵ忡 ���� setter �޼ҵ� �ۼ��� �� �� ������, Ư�� �ʵ忡 ���ؼ���
 *       setter �޼ҵ� �ۼ��� ���� ����
 */

class Person {
	String 	name;    	     // �̸��� ������ �ʵ�
	int    	age;		     // ���̸� ������ �ʵ�
	String 	currentLocation; // ����ġ�� ������ �ʵ�
	Book  	bookBuying;      // ������ å �����ϴ� �ʵ�: Book ��ü�� �����ϴ� �ʵ�

	// �̸�, ����, ��Ұ� �Ű������� �־����� �̸� 
	//   �ʵ� name, age, currentLocation�� �����ϴ�  �ʵ� �� ���� �޼ҵ�, �ʵ� �ʱ�ȭ �޼ҵ���
	void initializePerson(Person this, String name, int age, String location) {
		this.name = name;  // �Ű����� name�� this ��ü�� name �ʵ忡 ����
		this.age = age;    // �Ű����� age�� this ��ü�� age �ʵ忡 ����
		this.currentLocation = location; // location�� currentLocation �ʵ忡 ����
	}

	// Book Ŭ������ ��ü�� �Ű������� �־����� �̸� 
	//   �ʵ� bookBuying�� �����ϴ� �ʵ� �� ���� �޼ҵ�, setter �޼ҵ��� 
	void setBookBuying(Book book) {
		this.bookBuying = book;   // �Ű����� book ��ü�� this ��ü�� book �ʵ忡 ����
	}
}

class Book {
	String		title;  // ������ ������ �ʵ�
	String 	author;    	// ���ڸ� ������ �ʵ�
	String 	publisher;  // ���ǻ���� ������ �ʵ�
	int    	price;		// ������ ������ �ʵ�

	// ����, ����, ���ǻ��, ������ �Ű������� �־�����  
	//   �̸� �ʵ� title, author, publisher, price�� �����ϴ� �ʵ� �� ���� �޼ҵ�, �ʵ� �ʱ�ȭ �޼ҵ���
	void initializeBook(String	 title, String 	author, String 	publisher, int price) {
		this.title = title;    // �Ű����� title�� title �ʵ忡 ����
		this.author = author;  // �Ű����� author�� author �ʵ忡 ����
		this.publisher = publisher; // �Ű����� publisher�� publisher �ʵ忡 ����
		this.price = price;    // �Ű����� price�� price �ʵ忡 ����
	}
}

class Ex6_3_2_PersonMgmt {
	public static void main(String[] args) {
		
		// Person ��ü �����Ͽ� p�� �����ϰ� �ϰ� ���� �ʵ� �� ����
		Person p = new Person(); 
		p.initializePerson("��ö��", 23, "��������");

		// Book ��ü �����Ͽ� b�� �����ϰ� �ϰ� ���� �ʵ� �� ����
		Book b = new Book();     
		b.initializeBook("ȫ�浿��", "���", "������", 10000);  

		// setBookBuying() �޼ҵ带 �̿��Ͽ� ��ö���� ������ ȫ�浿�� Book ��ü�� 
		//   p�� bookBuying �ʵ忡 ����
		p.setBookBuying(b);         

		System.out.println("\n  * Person ��ü - �̸�: " + p.name + ", ����: " + p.age
				+ ", ����ġ: " + p.currentLocation + ", ������ å: " + p.bookBuying.title);
		System.out.println("\n  * Book ��ü - ����: " + b.title + ", ����: " + b.author
				+ ", ���ǻ�: " + b.publisher + ", ����: " + b.price);
	}
}

/*
 * [ ���α׷� ���� �� ���� ]
 * 
 *   1) ������ Person Ŭ������ Book Ŭ������ �ʵ� �ʱ�ȭ �޼ҵ�� setter �޼ҵ常 ����au,
 *      �ٸ� �޼ҵ�� ����.
 *   
 *   2) �� ��� �̵� Ŭ������ ��ü�� ������ �̵� �ʵ尪 ���� �޼ҵ带 �̿��Ͽ� �ʵ忡 ���� ������ �� �ִ�.
 *   
 *   3) ���α׷��� �����ϰ� ����� Ȯ���϶�.
 *   
 *   
 * [ �ǽ����� ]
 *   
 *   1) Person Ŭ������ Ű�� �ܱ��� ���θ� ��Ÿ���� �ʵ带 ÷���ϰ� �ʵ� �ʱ�ȭ �޼ҵ�� main() �޼ҵ带 �����϶�.
 *    
 *   2) ȯ������(ȯ��ID, �̸�, ����, �������, �ּ�) ������ ���� Patient Ŭ����, 
 *      ��������(���ᳯ¥, ����ð�(��), �����) ������ ���� Treat Ŭ������ �ۼ��϶�.
 *       
 *      main() �޼ҵ带 ���� PatientMgmt Ŭ������ �ۼ��Ͽ� Patient Ŭ���� ��ü�� Treat Ŭ���� ��ü�� �����ϰ� 
 *      �ʵ� �� ���� �޼ҵ带 �̿��Ͽ� �ʵ� �� ������ �� ����϶�.
 *  
 *   3) �߱� ���� �� Ÿ���� �Ҽ�����, �̸�, ���, ��� ��Ÿ�� ���� �ʵ带 ���� Hitter Ŭ������ 
 *      Ư�� ��⿡���� Ÿ�� ����� �����ִ� ��⳯¥, Ÿ����, Ÿ����, ��Ÿ��, ���� ȸ��, ���� ���� �� ȸ��, �ƿ� ȸ��, 
 *      ��� �ö��� ȸ�� ���� �ʵ�� ���� GameRecord Ŭ������ �ۼ��϶�.
 *       
 *      main() �޼ҵ带 ���� RecordMgmt Ŭ������ �ۼ��Ͽ� �߽ż� ������ �ں�ȣ ������ ���� �ֱٻ�Ȳ�� ��Ÿ���� 
 *      �ڵ带 �ۼ��ϰ� ����� ����϶�.
 */
