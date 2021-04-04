package ex6_3_6_class_with_method_for_behavior2;

/** 
 * [ Person, Book, PersonMgmt Ŭ���� ] :
 *      "23���� ��ö���� �������� ���� ���ǻ簡 �������̰� ������ 1������ 
 *      ����� ȫ�浿���� �����Ͽ���."��� ��Ȳ�� ��Ÿ����Java ���α׷�
 *                 
 *   o Ŭ���� ���� 4: �ൿ�� ������ �޼ҵ带 ���� Ŭ����
 *     - ��ü�� �ൿ�� �������� �ൿ�� ����� ��ü�� ���°� ��ȭ��
 *     - �ൿ�� ������ �޼ҵ�� ���� �۾��� �����Ͽ� ��������� �ʵ� ���� ������
 *     - �޼ҵ尡 �� �ۼ��Ǹ� ��ü�� �ൿ�� �ڿ������� ��Ÿ�� �� ���� 
 *
 *   o �ൿ�� ������ �޼ҵ�
 *     - goTo(String location) : �Ű������� ��ҷ� �̵��� ó��
 *     - buyBook(String title, String author, String publisher, int price) : 
 *         �Ű������� å ������� å ��ü �����Ͽ� ������ ���� ó��
 *
 *   o ��ü�� ����� ���� �޼ҵ�
 *     - public String toString() : ��ü�� �ʵ��� �ʵ尪���� ���ڿ��� �����Ͽ� ��ȯ
 *     - output(String msg) : msg�� toString()�� ����� ���
 *     - outputBookBuying(String msg) : msg�� ������ å ������ ���
 *   
 *   o �ൿ�� ������ �޼ҵ尡 �� �ۼ��Ǹ� main() �޼ҵ� �ۼ��� ������
 */

class Person {
	String 	name;    	       
	int    	age;		         
	String 	currentLocation;  
	Book  	bookBuying;     	 

	// �̸�, ���̰� �Ű������� �־����� �̸� �ʵ� name, age�� �����ϴ� ��ü ������
	Person(String name, int age) {
		this.name = name;  	 
		this.age = age;    	 
	}

	// goTo(): "����" �ൿ�� �����ϴ� �޼ҵ�
	//   �־��� ��ҷ� ���� �� ��Ұ� ����ġ�� �ǹǷ� 
	//   �Ű����� location�� �ʵ� currentLocation�� ����
	void goTo(String location)  {
		this.currentLocation = location;  // �� ��ġ�� �־��� location���� ����
	}

	// buyBook(): "å�� �����ϴ�" �ൿ�� �����ϴ� �޼ҵ�
	//   �Ű������� å �����׸��� Book ��ü �����Ͽ� bookBuying �ʵ忡 ����
	void buyBook(String  title,  String   author,  String   publisher,  int  price) {
		Book book = new Book(title, author, publisher, price); // å �����׸�����  Book ��ü ����, book�� ����
		this.bookBuying = book;                                // ������  book ��ü�� bookBuying �ʵ忡 ����
	}


	// toString(): ��ü�� �ʵ��� �ʵ尪�� ���ڿ��� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
	//    �� �޼ҵ�� �ݵ�� �ۼ��Ǿ�� �ϴ� �޼ҵ� ���� �ϳ���
	public String toString() {
		return "�̸�:" + this.name + ", ����:" + this.age + "��, ����ġ:"
				+ this.currentLocation + ", ������ å ����:" + this.bookBuying.title;
	}

	// output(): ��ü�� �ʵ��� �ʵ尪�� �־��� msg�� �Բ� ����ϴ� �޼ҵ�
	void output(String msg) {
		System.out.println(msg + this.toString());
	}

	// bookBuying �ʵ��� ������ å�� msg�� �Բ� ����ϴ� �޼ҵ�: �ۼ��� ������ ������ å ��ü ��� ������
	void outputBookBuying(String msg) {
		this.bookBuying.output(msg);  // ������ å ������ Book Ŭ������ output() �޼ҵ�� ���
	}
}

class Book {
	String	title;      
	String 	author;  	
	String 	publisher;	
	int    	price;		

	// ����, ����, ���ǻ��, ������ �Ű������� �־����� �̸� �ʵ� title, author 
	//   publisher, price�� �����ϴ� ��ü ������
	Book(String title, String 	author, String 	publisher, int price) {
		this.title = title;    		
		this.author = author;  	    
		this.publisher = publisher; 
		this.price = price;    		
	}

	// toString(): ��ü�� �ʵ��� �ʵ尪�� ���ڿ��� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
	// �� �޼ҵ�� �ݵ�� �ۼ��Ǿ�� �ϴ� �޼ҵ� ���� �ϳ���
	public String toString() {
		return "����: " + this.title + ", ����: " + this.author + ", ���ǻ�: " 
				+ this.publisher + ", ����: " + this.price;
	}

	// output(): ��ü�� �ʵ��� �ʵ尪�� ����ϴ� �޼ҵ�
	void output(String msg) {
		System.out.println(msg + this.toString());
	}
}

class Ex6_3_6_PersonMgmt {
	public static void main(String[] args) {

		Person p = new Person("��ö��", 23);          // 23���� ��ö���� �ִ�
		p.goTo("��������");                           // ��ö���� ��������� ����

		// ������ ���ǻ��� ���� 1������ ����� ȫ�浿�� å�� ��ö���� ����
		p.buyBook("ȫ�浿��", "���", "������", 10000); 

		p.output("\n  * ��ö�� ��ü - ");                // ��ö�� ��ü ���
		p.outputBookBuying("\n  * ��ö�� ������ å - ");  // ��ö���� ������ å ���
	}
}

/*
 * [ ���α׷� ���� �� ���� ]
 * 
 *   1) �� ���α׷��� ���캸�� Ŭ������ �޼ҵ带 �ľ��϶�.
 *   
 *      - Person Ŭ�������� ����ǰ� �߰��� buyBook(), outputBookBuying()
 *        �޼ҵ� �ľ�
 *
 *      - buyBook() �޼ҵ忡���� �Ű������� �־��� å ���� �̿��Ͽ� å ��ü �����ϰ� 
 *        ������ å���� ���� Ȯ��(Book ��ü�� Person�� ���ο����� ������)
 *        
 *      - outputBookBuying()������ ������ å ������ �����ڰ� ����ϰ� ��
 *   
 *   2) ���α׷��� �����ϰ� ����� Ȯ���϶�.  
 *   
 *  
 * [ �ǽ����� ]
 * 
 *   1) ������ �̵������� å ���������� ���� ���� �����Ͽ� �ڿ������� �ѱ��� �������� �ۼ��϶�.
 *   
 *       �� 20�� ȫ�浿�� (��ħ��) �б��� ����. (�б�����) 18314 ���ǽǷ� ����.
 *       ���� (�������� Ȩ����������) ������ ��ũ�� ���ű��� ��(������, 11500��)�� �����ߴ�.
 *       
 *   2) 1)���� �ۼ��� ������ ��Ÿ���� ���� ������ å ���� ����ϴ� �ڵ带 main() �޼ҵ忡 
 *      �߰� �ۼ��϶�.
 *      
 *   3) �ൿ ������ �޼ҵ带 �� �ۼ��� ����� �������� Ȯ���� �������°�?     
 */
