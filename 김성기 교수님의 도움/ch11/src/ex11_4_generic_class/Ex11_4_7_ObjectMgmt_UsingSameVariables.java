package ex11_4_generic_class;

import java.util.Vector;

/**
 * [ Ex11_4_7_ObjectMgmt_UsingSameVariables Ŭ���� ]: 
 *       ���׸� Ŭ������ �ʿ伺�� �ٽ� �ѹ� ���̴� ����
 * 
 *   o ��ü���� �����ϴ� 3���� Ŭ������
 *     - IntegerMgmt: Integer ��ü�� �����ϰ� �����ϰ� ����ϴ� ���� ��� �����ϴ� Ŭ����
 *     - StringMgmt: ���ڿ��� �����ϰ� �����ϰ� ����ϴ� ���� ��� �����ϴ� Ŭ���� 
 *     - PersonMgmt: Person ��ü�� �����ϰ� �����ϰ� ����ϴ� ���� ��� �����ϴ� Ŭ����
 *  
 *   o ����� ��ɰ� ������ ������ �޼ҵ� ������ ������ Ŭ������
 *      - �̵� 3 Ŭ������ �� Ŭ������ ��ü�� �����ϰ� �����ϰ� ����ϴ� ����Ǵ� ����� ����
 *      - Ÿ���� �����ϰ� �ʵ� �̸��� �޼ҵ尡 ��� �����ϰ� ���ۼ���  
 *          ==> �ϳ��� ���׸� Ŭ������ ���� ���յ� �� ����
 *       
 *   o ������ Ŭ�������� ���� �ʿ伺
 *     - Employee Ŭ������ ��ü �����Ϸ��� EmployeeMgmt Ŭ������ �Ǵٽ� �ۼ��ؾ� ��
 *     - Ŭ�������� ���� Ŭ������ �ۼ��ؾ� �ϹǷ� ���� Ŭ������ �ۼ��ؾ� �ϸ�, �̴� ���׸� Ŭ������ �ʿ��� ����
 *    - �Ű����� ���� ���� ������ �޼ҵ带 �Ű����� ���� �ϳ��� �޼ҵ�� �����ϴ� �Ͱ� ������ ����
 *     - Ŭ������ �Ű������� �������� �����Ͽ� �ϳ��� ���׸� Ŭ������ �ۼ�
 */

class Mgmts {
	// IntegerMgmt: Integer ��ü�� �����ϰ� �����ϰ� ����ϴ� ���� ��� �����ϴ� Ŭ����
	static class IntegerMgmt {   
		String title;
		Vector<Integer> objects = new Vector<Integer>(); // Integer Ŭ���� ��ü���� �����ϴ� Vector �ʵ� 

		// �־��� title�� �ʵ� title�� �����ϴ� ��ü ������
		IntegerMgmt(String title) {  
			this.title = title;
		}

		// �־��� Integer ��ü�� Vector �ʵ� objects�� �����ϴ� �޼ҵ�
		void add(Integer element) {   
			objects.add(element);
		}

		// Vector �ʵ� objects�� ����� i ��ġ�� ��ü ��ȯ�ϴ� �޼ҵ�
		Integer get(int i) {     
			return objects.get(i);
		}

		// title�� objects�� ����� ��ü���� ���ڿ��� �����ϴ� �޼ҵ�
		public String toString() {  
			String s = title +": ";    // Ÿ��Ʋ�� ���ڿ��� �߰�
			for (Integer element: objects)   // objects�� �� ���� element�� ����
				s = s + "[ " + element.toString() + " ] ";  //element�� ���ڿ� ������ [�� ] ���̿� ����

			return s;
		}

		// title�� objects�� ����� ��ü�� ����ϴ� �޼ҵ�
		void output() {  
			System.out.println(this.toString());
		}
	}

	//StringMgmt: ���ڿ��� �����ϰ� �����ϰ� ����ϴ� ���� ��� �����ϴ� Ŭ���� 
	static class StringMgmt {   
		String title;
		Vector<String> objects = new Vector<String>(); // String Ŭ���� ��ü���� �����ϴ� Vector �ʵ� 

		// �־��� title�� �ʵ� title�� �����ϴ� ��ü ������
		StringMgmt(String title) {  
			this.title = title;
		}

		// �־��� String Ŭ������ ��ü�� Vector �ʵ� objects�� �����ϴ� �޼ҵ�
		void add(String element) {   
			objects.add(element);
		}

		// Vector �ʵ� objects�� ����� i ��ġ�� ��ü ��ȯ�ϴ� �޼ҵ�
		String get(int i) {     
			return objects.get(i);
		}

		// title�� objects�� ����� ��ü���� ���ڿ��� �����ϴ� �޼ҵ�
		public String toString() {  
			String s = title +": ";         // Ÿ��Ʋ�� ���ڿ��� �߰�
			for (String element: objects)         // objects�� �� ���� element�� ����
				s = s + "[ " + element.toString() + " ] ";  // element�� ���ڿ� ������ [�� ] ���̿� ����

			return s;
		}

		// title�� objects�� ����� ��ü���� ����ϴ� �޼ҵ�
		void output() {  
			System.out.println(this.toString());
		}
	}

	// PersonMgmt: Person ��ü���� �����ϰ� �����ϰ� ����ϴ� ���� ��� �����ϴ� Ŭ����
	static class PersonMgmt {   
		String title;
		Vector<Person> objects = new Vector<Person>(); // Person Ŭ���� ��ü�� �����ϴ� Vector �ʵ� 

		// �־��� title�� �ʵ� title�� �����ϴ� ��ü ������
		PersonMgmt(String title) {  
			this.title = title;
		}

		// �־��� Person Ŭ������ ��ü�� Vector �ʵ� objects�� �����ϴ� �޼ҵ�
		void add(Person element) {   
			objects.add(element);
		}

		// Vector �ʵ� objects�� ����� i ��ġ�� ��ü ��ȯ�ϴ� �޼ҵ�
		Person get(int i) {     
			return objects.get(i);
		}

		// title�� objects�� ����� ��ü���� ���ڿ��� �����ϴ� �޼ҵ�
		public String toString() {  
			String s = title +": ";              // Ÿ��Ʋ�� ���ڿ��� �߰�
			for (Person element: objects)           // objects�� �� ���� element�� ����
				s = s + "[ " + element.toString() + " ] ";  // element�� ���ڿ� ������ [�� ] ���̿� ����

			return s;
		}

		// title�� objects�� ����� ��ü���� ����ϴ� �޼ҵ�
		void output() {  
			System.out.println(this.toString());
		}
	}
}
	
class Ex11_4_7_ObjectMgmt_UsingSameVariables {  
	public static void main(String[] args) {   
		// IntegerMgmt ��ü �����Ͽ� ageMgmt�� �����ϰ� �� 
		Mgmts.IntegerMgmt ageMgmt = new Mgmts.IntegerMgmt("���� ����");  

		ageMgmt.add( 18 ); 
		ageMgmt.add( 16 ); 
		ageMgmt.add( 23 ); 

		ageMgmt.output();        


		// StringMgmt ��ü �����Ͽ� nameMgmt�� �����ϰ� �� 
		Mgmts.StringMgmt nameMgmt = new Mgmts.StringMgmt("�̸� ����");  

		nameMgmt.add( "ȫ�浿" ); 
		nameMgmt.add( "�̸���" ); 
		nameMgmt.add( "��ö��" ); 

		nameMgmt.output();        


		// PersonMgmt ��ü �����Ͽ� persontMgmt�� �����ϰ� �� 
		Mgmts.PersonMgmt personMgmt = new Mgmts.PersonMgmt("�Ż����� ����");  

		personMgmt.add( new Person("ȫ�浿", 18) ); 
		personMgmt.add( new Person("�̸���", 16) ); 
		personMgmt.add( new Person("��ö��", 23) ); 

		personMgmt.output();  
	}
} 


/*
 * [ ���α׷��� ���� �� ���� ]
 *   
 *   1) �� ���α׷��� 3���� ���� Ŭ������ ������ �ۼ��ϰ� main() �޼ҵ忡�� ���� Ŭ���� ��ü�� �����ϰ�
 *      Ŭ������ ��ü�� ���� ��ü�� �߰��ϰ� ����Ѵ�.
 *      
 *      3���� Ŭ������ Ÿ�Ը� �ٸ��� ��� ������ �޼ҵ�  �̸��� �����ϹǷ� �ٷ� ���׸� Ŭ������ ��ȯ�� �� �ִ�.
 *     
 *   2) 3���� ���� Ŭ������ ���� ������ ��Ȯ�� �ľ��϶�.
 *      (1) ���� Ŭ�������� ������� ������
 *      (2) ���� Ŭ�������� �ʵ�� �޼ҵ忡���� ������
 *      
 *   3) ���α׷��� �����ϰ� ����� Ȯ���϶�.
 *   
 *  
 * [ ������� ]
 *  
 *   o �� ���α׷����� IntegerMgmt, StringMgmt, PersonMgmt Ŭ������ 
 *     ���� 11-4-6�� Ŭ���� �̸��� �����ϹǷ� ����� �� ���� �̸��̴�. 
 *     
 *     �ֳ��ϸ� �ϳ��� ��Ű������ Ŭ���� �̸��� ���� �޶�� �ϱ� �����̴�.
 *     
 *   o �׷��Ƿ� �� ���α׷������� IntegerMgmt, StringMgmt, PersonMgmt Ŭ������ 
 *     �ܺ� Ŭ����(outer class)�� Mgmt Ŭ������ ���� Ŭ����(inner class)�� �ۼ��Ǿ� �ִ�.
 *     
 *   o ���� Ŭ������ �� Ŭ������ �����ϴ� �ܺ� Ŭ������ ���ο��� �ۼ��Ǵ� Ŭ�����μ�,
 *     ���� Ŭ������ �ۼ��� Ŭ���� ���ο����� ���ǰų�  << �ܺ�Ŭ����.����Ŭ���� >> �� �������� ���ȴ�.
 *     
 *   o main() �޼ҵ��� << Mgmts.IntegerMgmt ageMgmt = new Mgmts.IntegerMgmt("���� ����"); >>��
 *     << �ܺ�Ŭ����.����Ŭ���� >> �� �������� ���� ���̴�.
 *     
 *   o ���� Ŭ������ GUI ���α׷��ֿ��� �̺�Ʈ ������ Ŭ���� �ۼ� �� �ٽ� �Ұ��Ǹ�,
 *     ���� Ŭ������ ���� ������ �н��ϱ� �ٶ���.
 *     
 *     
 * [ �ǽ� ���� ]
 * 
 *   1) Character ��ü�� �����ϰ� �����ϰ� ����ϴ� ���� ����� �����ϴ� Ŭ������ CharacterMgmt�� �ۼ��Ͽ�
 *      �� Ŭ������ ��ü�� �����Ͽ� 'ȫ', '��', '��'�� �����ϰ� ����϶�.
 *       
 *   2) Double ��ü�� �����ϰ� �����ϰ� ����ϴ� ���� ����� �����ϴ� Ŭ������ DoubleMgmt�� �ۼ��ϰ�
 *      �� Ŭ������ ��ü�� �����Ͽ� 177.7, 162.0, 172.2�� �����ϰ� ����϶�
 *      
 *   �� �������: 
 *     CharacterMgmt Ŭ������ DoubleMgmt Ŭ������ IntegerMgmt Ŭ������ ���� �ʵ�� �޼ҵ带 �������� �ۼ��ϸ� 
 *     �ʵ� �̸��̳� �Ű����� �̸���  IntegerMgmt Ŭ������ �����ϰ� �ۼ��Ѵ�.
 *      
 *   3) �Ű������� ���� ������ �޼ҵ带 �ۼ��� ���� �������� ���� ������ ���� Ŭ������ �ۼ��� ���� �������� 
 *      ������ �������ΰ��� �����غ���.      
 */