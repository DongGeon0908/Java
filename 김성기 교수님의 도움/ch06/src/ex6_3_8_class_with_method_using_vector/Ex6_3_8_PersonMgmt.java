package ex6_3_8_class_with_method_using_vector;

import java.util.Vector;   // Vector Ŭ���� ����ϱ� ���� import

/**
 * [ Person, Book, PersonMgmt Ŭ���� ]: 
 *       "23���� ��ö���� 30������ ���� ��ȭ������ ���ٰ� �������� ���� ���ǻ簡 �������̰�
 *       ������ 1������ ����� ȫ�浿���� ���ǻ簡 �������̰� ������ 19800����  
 *       ���� ���� �����۽��� ��Ƽ�� �⽺�� �����ߴ�"��� ��Ȳ�� ��Ÿ���� Java ���α׷�
 *                
 *   o Ŭ���� ���� 4: �ൿ�� ������ �޼ҵ带 ���� Ŭ����
 *     - ��ü�� �ൿ�� �������� �ൿ�� ����� ��ü�� ���°� ��ȭ��
 *     - �ൿ�� ������ �޼ҵ�� ���� �۾��� �����Ͽ� ��������� �ʵ� ���� ������
 *     - �޼ҵ尡 �� �ۼ��Ǹ� ��ü�� �ൿ�� �ڿ������� ��Ÿ�� �� ���� 
 *
 *   o �ൿ�� ������ �޼ҵ�
 *     - int makeMoney(int amount) : �־��� �ݾ׸�ŭ�� ���� �� ���� ó���ϴ� �޼ҵ� 
 *                                   �� �ݾ� amount��ŭ ���������� ������Ű�� ���������� ��ȯ��
 *     - goTo(String location) : �Ű������� ��ҷ� �̵��� ó��
 *     - buyBook(String title, String author, String publisher, int price) : 
 *          �Ű������� å ������� å ��ü �����Ͽ� ������ ���� ó��
 *     - buyBook(Book book, int cnt) : å�� ���� �� �����ϴ� �ൿ�� ����
 *
 *   o ����, å �����ϴ� ���� �ൿ�� ���� �̷� ����
 *     - ���� ������ ���� �̷��� �����ϵ��� buyBook() �޼ҵ�� goTo() �޼ҵ� ����
 *     - java.util.Vector Ŭ������ �̿��Ͽ� ���� �����͸� ���ϰ� ����
 *   
 *   
 *   o java.util.Vector Ŭ����
 *     - �迭���� ���� �����͸� ���ϰ� �����ϰ� �˻��ϴ� ��� �����ϴ� Ŭ����
 *     - Vector ��ü�� ����Ǵ�  ���� ������ ��  �ϳ��� ���Ҷ� ��
 *   
 *     - ����ϱ� ���ؼ� �ݵ�� import �ؾ� ��
 *         import java.util.Vector;   // java.util.Vector�� �ݵ�� import
 *   
 *     - ���� ������ �����ϱ� ���� Vector ��ü ���� �� ���������� ����    
 *       Vector<������-����-Ŭ����> �������� = new Vector<������-����-Ŭ����>();  // ������ ���� Ŭ������ <�� > ���̿� ǥ����
 *     
 *       Vector<String> locs = new Vector<String>();     // ���� ��ġ�� ���ڿ� �����ϱ� ���� vector ��ü �����Ͽ� locs�� �����ϰ� ��
 *       Vector<Book> booksBuying = new Vector<Book>();  // ���� ������ å �����ϱ� ���� vector ��ü �����Ͽ� booksBuying�� �����ϰ� ��
 *     
 *     - ���� �����ϰ� �˻��ϱ� ���� �޼ҵ�
 *   
 *       void add(Object o): Vector ��ü�� ��  ��ġ�� ���� o�� �����ϴ� �޼ҵ�
 *       Object get(int index): Vector ��ü�� ��ġ index�� ����� ���Ҹ� ���Ͽ� ��ȯ�ϴ�  �޼ҵ�(index�� 0���� ����)
 *         
 *     - Vector ��ü�� ���� �����ϱ�  
 *       locs.add("��ȭ��");      // "��ȭ��"�� locs�� �߰�
 *       booksBuying.add(b);     // å ��ü b�� booksBuying�� �߰�
 *     
 *     - Vector ��ü�� ����� i��° ��ġ�� ���� ���ϱ�       
 *       String loc = locs.get(0);  // locs�� ����� ���ҵ� �� ù ���� ���� loc�� ����
 *       Book b = booksBuying.get(booksBuying.size() -1);  // booksBuying�� ����� ���ҵ� �� ������ ���Ҹ� ���� b�� ����
 *          
 *   o ��ü�� ����� ���� �޼ҵ�
 *     - public String toString() : ��ü�� �ʵ��� �ʵ尪���� ���ڿ��� �����Ͽ� ��ȯ
 *     - output(String msg) : msg�� toString()�� ��� ���
 */

class Person {
   String 	name;    	     	  // �̸�
   int    	age;		     	  // ����
   String 	currentLocation;  	  // ����ġ

   //** makeMoney(), goTo(), buyBook() �� �ൿ�� ������ �޼ҵ带 ���� �ʵ��

   Vector<String> prevLocs = new Vector<String>(); // ���� ��ġ�� �����ϴ� Vector ��ü 

   int  moneyHaving = 0;     // �������� �����ϴ� �ʵ�

   Vector<Book>  booksBuying = new Vector<Book>(); // ������ å�� �����ϴ� Vector ��ü 

   // ��ü ������: �̸�, ���̰� �־����� �̸� ��ü�� �ʵ� ������ ����
   Person(String name, int age) {
      this.name = name; this.age = age; 
   }

   /*
    *  makeMoney(), goTo(), buyBook() �� �ൿ�� ������ �޼ҵ�
    */

   // makeMoney(): �־��� �ݾ׸�ŭ�� �� �� �� ó���ϴ� �޼ҵ�
   //   �� �ݾ� amount��ŭ ���������� ������Ű�� �������� ��ȯ��
   int makeMoney(int amount) {
      this.moneyHaving += amount;  // �� �ݾ׸�ŭ �������� ����

      return this.moneyHaving;     // �������� ��ȯ
   }

   // goTo(): "����" �ൿ �����ϴ� �޼ҵ�
   //   location���� �ʵ� currentLocation���� ������
   void goTo(String location) {      
      this.addToPrevLocs(this.currentLocation); // ����ġ�� ���� ��ġ�� �߰���
      this.currentLocation = location;          // �� ��ġ�� �־��� location���� ����
   }
 
   // buyBook(): "å�� �����ϴ�" �ൿ �����ϴ� �޼ҵ�
   //   �Ű������� å �����׸��� Book ��ü �����Ͽ� buyBook() �޼ҵ� ȣ��
   //   ������ ���� ���������� ��ȯ
   int buyBook(String  title,  String   author,  String   publisher,  int  price) {
	   Book book = new Book(title, author, publisher, price); // å �����׸�����  Book ��ü ����, book�� ����
	   return this.buyBook(book);                             // book ��ü�� �Ű������� �Ͽ� buyBook() �޼ҵ� ȣ��
   }

   // buyBook(): "å�� �����ϴ�" �ൿ �����ϴ� �޼ҵ�
   //   ���� å�Ǽ��� 1 �����ϰ� å ���ݸ�ŭ ���������� ������ �� ���������� ��ȯ
   int buyBook(Book book) {
       this.addToBooksBuying(book);     // ������ å book�鿡 �߰���Ŵ
       this.moneyHaving -= book.price;  // ���������� å ���� book.price��ŭ ����

       return this.moneyHaving;
   }
  
   // buyBook(): "å�� ���� �� �����ϴ�" �ൿ �����ϴ� �޼ҵ�
   //   �Ű������� �־��� cnt �Ǽ���ŭ book ���� ó���ϰ� ���� �������� ��ȯ 
   int buyBook(Book book, int cnt) {
	   int moneyHaving = this.moneyHaving;
	   
       while(cnt-- > 0) {
    	   moneyHaving = this.buyBook(book);  // book�� ���� ó����
       }
       
       return moneyHaving;
   }
      
  /*
   * makeMoney(), goTo(), buyBook() �� �ൿ�� ������ �޼ҵ带 ���� �޼ҵ�  
   */

  // addToPrevLocs(): �־��� ��ġ�� ���� ��ġ�� �߰���Ű�� �޼ҵ�
  void addToPrevLocs(String location) { 
     if (location == null) return;

     this.prevLocs.add(location);	// ���� ��ġ�� �����ϴ� Vector ��ü prevLocs�� loc �߰�
  }

  // addToBooksBuying(): �־��� å�� ������ å�鿡 �߰���Ű�� �޼ҵ�
  void addToBooksBuying(Book book) { 
     this.booksBuying.add(book); 	// ������ å��  �����ϴ� Vector ��ü booksBuying�� book �߰�     
  }

  // Vector ��ü�� ����� ���� ��ġ���� "[ "�� " ]" ������ ���ڿ��� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
  String prevLocsToString() {
     String locs = "[ ";
     int cnt = this.prevLocs.size();
     
     for(int i = 0; i < cnt; i++)
        locs += this.prevLocs.get(i)   // get(i)�� i ��ġ�� ���Ҹ� ���ϴ� �޼Ҵ�
              +  (( i < cnt - 1) ? ", " : "" );
     
     return locs + " ]";
  }
  
  // Vector ��ü�� ����� ���� å���� ������� "[ "�� " ]" ������ ���ڿ��� ��ȯ�ϴ� �޼ҵ�
  String booksBuyingToString() {
     String books = "[ ";
     int cnt = this.booksBuying.size();
     
     for(int i = 0; i < cnt; i++)
        books += this.booksBuying.get(i).title   // get(i)�� i ��ġ�� ���Ҹ� ���ϴ� �޼Ҵ�
                               + (( i < cnt - 1) ? ", " : " ");
     return books + "]";
  }

  // toString(): ��ü�� �ʵ��� �ʵ尪�� ���ڿ��� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
  public String toString() {
     return "�̸�:" + this.name + ", ����:" + this.age
       + "��, ��������:" + this.moneyHaving 
       + "��\n        ����ġ:" + this.currentLocation + ", ���� ��ġ:" 
       + this.prevLocsToString() + ", ������ å:" + this.booksBuyingToString();
  }

  // output(): ��ü�� �ʵ��� �ʵ尪 ����ϴ� �޼ҵ�
  void output(String msg) {
    System.out.println(msg + this.toString());
  }
}

class Book {
   String	title, author, publisher;  // ����, ����, ���ǻ���� ������ �ʵ�
   int    	price;		     		   // ������ ������ �ʵ�
 
   // ��ü ������: ����, ����, ���ǻ�, ������ �־����� �̸� ��ü�� �ʵ� ������ ����
   Book(String title, String author, String publisher, int price) {
      this.title = title; this.author = author;
      this.publisher = publisher;  this.price = price;
   }

   // toString(): Book ��ü�� �ʵ��� �ʵ尪�� ���ڿ��� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
   public String toString() {
      return "����: " + this.title + ", ����: " + this.author + ", ���ǻ�: " 
                     + this.publisher + ", ����: " + this.price;
   }

   // output(): Book ��ü�� �ʵ��� �ʵ尪 ����ϴ� �޼ҵ�
   void output(String msg) {
     System.out.println(msg + this.toString());
   }
}

class Ex6_3_8_PersonMgmt {
  public static void main(String[] args) {
     Person p = new Person("��ö��",  23);    // 23���� ��ö���� �ִ�.
     p.goTo("��ȭ��");                        // ��ö���� ��ȭ���� ����

     int moneyAfter1 = p.makeMoney(300000);  // ��ö���� 30������ ������.
     p.goTo("��������");                       // ��ö���� �������� ����

     // ȫ�浿���� ��Ƽ�� �⽺ �ڼ��� å�� ��ö���� ����
     int moneyAfter2 = p.buyBook("ȫ�浿��", "���", "������", 10000);
     int moneyAfter3 = p.buyBook("��Ƽ�� �⽺", "���� �����۽�", "������", 19800);

     p.goTo("��");                           // ��ö���� ���� ���� 

     // ��ö�� ��ü�� ��� ���¸� �����
     p.output("\n  * ��ö�� ��Ȳ - ");

     // 30���� �� ��, ȫ�浿�� ���� ��, ��Ƽ�� �ڼ��� ���� ���� �������� ���
     System.out.println("\n  * 30���� �� �� ��������: " + moneyAfter1 + "��");
     System.out.println("\n  * ȫ�浿�� ���� �� ��������: " + moneyAfter2 + "��");
     System.out.println("\n  * ��Ƽ�� �⽺ ���� �� ��������: " + moneyAfter3 + "��");
   }
}

/*
 * [ ���α׷� ���� �� ���� ]
 * 
 *   1) �� ���α׷��� java.util.Vector Ŭ������ �̿��Ͽ� ���� ���� ���� ���� ��ġ�� ������ å�� �����Ѵ�. 
 *   
 *      java.util.Vector Ŭ������ ���߿� ��� �����̹Ƿ� ���������� �ľ��� ��
 *      
 *   2) ���α׷��� �����ϰ� ����� Ȯ���϶�.
 *   
 *      ���� ���α׷��� ����� ���������� ���α׷��� �ξ� �������� �� �� �ִ�.
 *      
 *      
 * [ �ǽ� ����] (����� ����� ���� �����غ� ����)
 *  
 *   1) ������ �������� �̵��ϱ�, �� ����, å �����ϱ� ���� ���� ���� �����Ͽ� �ڿ�������
 *      �ѱ��� �������� �ۼ��϶�.
 *       
 *      �� 20�� ȫ�浿�� (���� �Ƹ�����Ʈ�Ͽ�) 5���� ������. (��ħ��) �б��� ����. (�б�����) 18314 ���ǽǷ� ����. 
 *      (�������� Ȩ����������) ������ ��ũ�� ���ű��� ��(������, 11500��) �� ����������, �� �ٸ� å ���� �����ߴ�.
 *       
 *   2) 1)���� �ۼ��� ������ ��Ÿ���� ���� ������ ����ϴ� �ڵ带 main() �޼ҵ忡 �߰� �ۼ��϶�.
 *    
 *   3) �ൿ�� ������ �޼ҵ��� ���� ���ؿ� ���� ���α׷� �ۼ��� �޶����� Ȯ���� �������°�?
 */
