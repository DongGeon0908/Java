package practice09;

/**
 *  [ 9�� �ǽ�����  1�� ��� ��� ]
 *  
 *    1. ���� �߻� �޼ҵ� �ۼ� �� �������� �޼ҵ� ȣ��
 *    
 *       ������ Ŭ������ �ۼ��ϸ鼭 �䱸�Ǵ� ����� �����ϴ� �޼ҵ带 ���ܹ߻� �޼ҵ�� �ۼ��ϰ� 
 *       main()���� �� �޼ҵ带 ȣ���ϰ� ���� ó���� ������ �����϶�. ���ܹ߻� �޼ҵ尡 ��ü �޼ҵ��̸� 
 *       ��ü�� ���� �����Ѵ�.
 *       
 *      1) UniversityStudent Ŭ����
 *     
 *         o UniversityStudent Ŭ������ �ʵ�� �̸�, �а�, �г��� ��Ÿ���� String name, String dept, 
 *           int grade�� ����
 *          
 *         o UniversityStudent Ŭ������ ��ü �����ڴ� �̸�, �а�, �г��� �Ű������� �־����� �ʵ� name, dept, 
 *           grade�� �ʱ�ȭ
 *          
 *         o int setGrade(int grade) �޼ҵ�� �г� grade�� �־����� �̸� UniversityStudent Ŭ������
 *           grade �ʵ忡 �����ϰ� ����� �г��� ��ȯ
 *          
 *         o setGrade(int grade) �޼ҵ�� grade�� ���� �Ǵ� 5 �ʰ��� "�߸��� �г�" ���� �߻�
 *         
 *      2) Menu Ŭ����
 *     
 *         o Menu Ŭ������ �ʵ�� ����
 *        
 *         o static int getMenuNo(String[] menus) �޼ҵ�� String �迭 menus�� �־�����
 *           menus �迭�� ���Ҹ� ������ �Բ� ����� �� ������ �Է��Ͽ� ��ȯ�ϴ� �޼ҵ�
 *          
 *         o getMenuNo(String[] menus) �޼ҵ�� �Է¹��� ������ 1���� �۰ų� ���� �������� ũ�� 
 *           "�߸��� �޴� ����" ���� �߻�
 *           
 *      3) IntArray Ŭ����
 *    
 *         o IntArray Ŭ������ �ʵ�� int[] array, int maxNo, int posToSave�� ����
 *       
 *         o IntArray Ŭ������ ��ü �����ڴ� ������ ����
 *       
 *            IntArray(int no) {
 *               array = new int[no];		// array �迭������ �ִ� no�� ���� ���� ����
 *               maxNo = no;       		// ���� ���� ���� ������ n���� ����
 *               posToSave = 0;   			// ������ ����� ��ġ�� 0���� ����
 *            }
 *          
 *         o int add(int n) �޼ҵ�� �־��� n�� �ʵ� �迭���� array�� posToSave ��ġ�� �����ϰ� posToSave��
 *           1 �����ϰ� ����� ��ġ�� ��ȯ�ϴ� �޼ҵ�
 *         
 *         o int add(int n) �޼ҵ�� �ʵ� posToSave�� ���� �ʵ� maxNo�� ������ "���� ���� �������� ���� �Ұ�" 
 *           ���� �߻�
 */

class UniversitySt {
	String name; String dept; int year;

	UniversitySt(String name, String dept, int year) {
		this.name = name; this.dept = dept; this.year = year;
	}

	int setYear(int year) throws Exception {
		if (year >= 1 && year <= 4) {
			this.year = year;
			return this.year;
		}
		else
			throw new Exception("�߸��� �г� " + year);
	}
}

class Menu {	
	static int getMenuNo(String[] menus) throws Exception { 

		System.out.println("\n"); 

		int menuNo = menus.length;
		for (int i = 1; i <= menuNo; i++)
			System.out.println("  " + i + ") " + menus[i-1]);

		int menu = SkScanner.getInt("\n  o �޴� ���� > ");

		if (menu >= 1 && menu <= menuNo)
			return menu;
		else
			throw new Exception("�߸��� �޴� ����");		
	}
}

class IntArray {
	int[] array; int maxNo; int posToSave;


	IntArray(int no) {
		array = new int[no]; // array �迭������ �ִ� no�� ���� ���� ����
		maxNo = no;        // ���� ���� ���� ������ n���� ����
		posToSave = 0;     //  ������ ����� ��ġ�� 0���� ����
	}

	int add(int n) throws Exception {
		if (posToSave < maxNo) {
			array[posToSave++] = n;
			return posToSave -1;
		}
		else 
			throw new Exception("���� ���� �������� ���� �Ұ�");
	}
}

class Practice9_1_ExceptionMgmt {
	public static void main(String[] args) {
		System.out.println("\n  ** �г� ���� �� ��� **\n");

		UniversitySt st = new UniversitySt("ȫ�浿", "��ǻ���а�", 2);

		for (int i = 1; i <= 5; i++)
			try {
				System.out.println("  * ����� �г� = " + st.setYear(i));
			}
		catch(Exception e) {
			System.out.println("  * ����: " + e.getMessage());
		}


		System.out.println("\n  ** �޴� ��� �� �Է� **\n");

		String[] menus = {"���� ����", "�Ա�", "���", "��ü", "����" };

		for (int i = 1; i <= 5; i++)
			try {
				System.out.println("  * ���õ� �޴� = " + Menu.getMenuNo(menus));
			}
		    catch(Exception e) {
			    System.out.println("  * ����: " + e.getMessage());
		    }

		System.out.println("\n  ** ���� ���� �� ���� ��ġ ��� **\n");

		IntArray ia  = new IntArray(4);

		for (int i = 1; i <= 5; i++)
			try {
				System.out.println("  * " + i + " ����� ��ġ = " + ia.add(i) );
			}
		catch(Exception e) {
			System.out.println("  * ����: " + e.getMessage());
		}
	}
}
