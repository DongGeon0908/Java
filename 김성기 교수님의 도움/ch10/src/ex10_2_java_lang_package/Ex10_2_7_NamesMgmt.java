package ex10_2_java_lang_package;

/**
 * [ Names, NamesMgmt Ŭ���� ]: 
 *        ���� ���ڿ��� �迭�� �����ϰ� ���ڿ� �� �� Ž��
 *        
 *   o ���� �̸��鿡 ���� 5���� ���� �۾��� �����ϴ� ���� ���α׷�  
 *     - ���� �۾� �޴�
 *       1) ��� �̸� ����
 *       2) �̸� �߰�
 *       3) �̸� ã��
 *       4) ������ �̸� ã��
 *       5) ū �̸� ã��  
 *       
 *   o ���� ���α׷� ���� �а� �ۼ��ϸ鼭 ���α׷��� �ɷ��� ����ؾ� ��
 */

class Names {
	String[] names = new String[100];  // �ִ� 100�� �̸� �����ϴ� �迭���� names
	int cntNames = 0;                  // names[] �迭�� ����� ���� ����

	// ����� ��� �̸��� ����ϴ� �۾� ó�� �޼ҵ�
	void doList() {
		System.out.print("\n  ** ��� �̸��� **\n  * ");  

	    if (cntNames == 0)  
	        System.out.println("�̸��� �ϳ��� ���� ");
	    else 
	         for (int i = 0; i < cntNames; i++)   // �̸� ����� ���� ��ο� ����         
	           System.out.print(names[i] + "  ");
	}

	// �̸��� �Է��Ͽ� �Էµ� �̸��� �����ϰ� ����� ��ġ�� ����ϴ� �۾� ó�� �޼ҵ�
	void doAdd() {
		System.out.println("\n  ** �̸� �߰��ϱ� **");  
		String name = SkScanner.getString("  o �߰��� �̸� > ");
		int n = add(name);
		System.out.println("\n  * " + name + ": " + ( n + 1) + "��° �̸����� �߰���");
	}

	// �־��� �̸��� names[] �迭�� ������ ���� ������ �����ϰ� ��ġ ��ȯ�ϴ� �޼ҵ�
	int add(String name) {

		names[cntNames] = name; // ������ ���� ��ġ names[cntNames]�� name ����
		cntNames++;             // names[] �迭�� ����� ���� ���� 1 ����

		return cntNames - 1;    // ���� ��ġ ��ȯ
	}

	// �̸��� �Է��Ͽ� �Էµ� �̸��� ������ �̸��� ������ ����ϴ� �۾� ó�� �޼ҵ�
	void doSearchName() {
		System.out.println("\n  ** �̸� ã�� **");  
		String name = SkScanner.getString("  o ã�� �̸� > ");
		int cnt = 0;

		for (int i = 0; i < cntNames; i++)
			if (names[i].equals(name))  // names[i]�� name�� ������ 
				cnt++;
		if (cnt == 0)
			System.out.println("\n  * " + name + "�� �̸��� ����.");  
		else 
			System.out.println("\n  * " + name + "�� �̸��� " + cnt +"�� ����");  
	}

	// ���� �Է��Ͽ� �Էµ� ������ �����ϴ� �̸��� ������ ����ϴ� �۾� ó�� �޼ҵ�
	void doSearchFirstname() {
		System.out.println("\n  ** ������ �̸� ã�� **");  
		String fname = SkScanner.getString("  o ã�� �� > ");

		int cnt = 0;
		String namesMatch = "";

		for (int i = 0; i < cntNames; i++)
			if (names[i].startsWith(fname)) {  // names[i]�� fname���� �����ϸ�
				cnt++;
				namesMatch += names[i] + " ";
			}

		if (cnt == 0)
			System.out.println("\n  * ���� " + fname + "�� �̸��� ����");  
		else 
			System.out.println("\n  * ���� " + fname + "�� �̸� " + cnt +"��: " +
					namesMatch);  
	}

	// �̸��� �Է��Ͽ� �Էµ� �̸����� ū �̸��� ������ ����ϴ� �۾� ó�� �޼ҵ�
	void doSearchNameGT() {
		System.out.println("\n  ** ū �̸� ã�� **");  
		String name = SkScanner.getString("  o ã�� �̸� > ");
		int cnt = 0;
		String namesGT = "";

		for (int i = 0; i < cntNames; i++)
			if (names[i].compareTo(name) > 0) {  // names[i]�� name���� ũ��
				cnt++;
				namesGT += names[i] + " ";
			}

		if (cnt == 0)
			System.out.println("\n  * " + name + "���� ū �̸��� ����");  
		else 
			System.out.println("\n  * " + name + "���� ū �̸� " + cnt +"��: " 
					+ namesGT);  
	}    
}

class Ex10_2_7_NamesMgmt {  
	public static void main(String[] args) {
		Names names = new Names();  // ���� �̸����� �����ϰ� �����ϴ� names ��ü ���� �� ����

		// ȫ�浿, ȫ�漭, ȫ�泲, ȫ����� �̸� �߰���
		names.add("ȫ�浿"); names.add("ȫ�漭"); 
		names.add("ȫ�泲"); names.add("ȫ���");

		while(true) {
			System.out.println("\n\n  **** �̸� ���� ****\n");
			System.out.println("  1) ��� �̸� ����   \t2) �̸� �߰�     \t  3) �̸� ã�� ");
			System.out.println("  4) ������ �̸� ã�� \t5) ū �̸� ã��  \t  6) ����");

			int menu = getMenu(1, 6, "\n  o �۾� �����Ͻÿ� > ", "  !!! �ùٸ� �۾��� �����Ͻÿ�\n");    
			
			switch(menu) {
			case 1: names.doList();             break;
			case 2: names.doAdd();              break; 
			case 3: names.doSearchName();       break;
			case 4: names.doSearchFirstname();  break;
			case 5: names.doSearchNameGT();     break;
			case 6: exit();                   return;
			}
		}
	}

	static void exit() {
		System.out.println("\n\n ** �̸� ���� �����մϴ� \n\n");
	}
	
	static int getMenu(int min, int max, String prompt, String errMsg) {
		while(true) {
			int menu = SkScanner.getIntWithPrompt(prompt);
			
			if (menu >= min && menu <= max)
				return menu;
			
			System.out.print(errMsg);			
		}
	}
}

/*
 * [ ���α׷� ���� �� ���� ]
 * 
 *   1) �� ���α׷��� �̸��鿡 ���� 5���� ���� �۾��� �����Ѵ�.
 *      - �۾� ó���� ���� �޼ҵ�� �տ� do�� �ٿ� �۾�ó������ ǥ���Ѵ�.
 *      - doList() �޼ҵ�� �̸� ��� �۾��� �����Ѵ�.
 *      - ������ 4���� �۾�ó�� �޼ҵ�� �־��� �۾��� ó���Ѵ�.
 *      
 *   
 *   2) getMenu(int min, int max, String prompt, String errorMsg) �޼ҵ�
 *      - main()�� << int menu = getMenu(1, 6, ...  >>���� ���Ǵ� �޼ҵ�
 *      - �־��� ������ ������ �Է��ϴ� Ŭ���� �޼ҵ�
 *      - ������Ʈ �޽��� prompt�� ����� �� �־��� min�� max ������ �������� �Է��Ͽ� ��ȯ
 *      - ���� ���� ������ �ԷµǸ� ���� �޽��� errorMsg�� ����� �� �ٽ� �Է��� �õ�
 *      
 *   3) ���α׷��� �����Ͽ� �޴� ������ �� �۾��� �����ϰ� ����� Ȯ���϶�.   
 *   
 *   
 * [ �ǽ� ���� ]
 * 
 *   o �̸��� �Է��Ͽ� �Էµ� �̸��� ���� �̸��� �����ϴ� �޴��� 3�� �޴��� �ۼ��Ϸ� �Ѵ�.
 *       
 *     (1) Names Ŭ������ void delete() �޼ҵ带 �ۼ��϶�.
 *     (2) main()���� ������ 3�������� �޴��� 4�� ������ �޴��� �����ϰ� << 3) �̸� ���� >> �޴��� �߰��϶�. 
 *     (3) main()���� �޴� �����ϰ� ���õ� �޴��� ���� �ش� �޼ҵ带 ȣ���ϴ� �κ��� �����϶�.
 *     
 *   o getMenu() �޼ҵ�� �Էµ� �޴� ��ȣ�� min���� �۰ų� max���� ũ�� main()���� ���޵Ǵ� ���� �޽����� 
 *     ����Ͽ� ������ ó���Ѵ�.
 *     
 *     getMenu() �޼ҵ忡�� ���� ��Ȳ�� �߻��ϸ� ���� ��ü�� ������ main()���� ���� Ž���ϰ� ó���ϵ��� 
 *     ���α׷��� �����϶�.
 *     
 *     �� ��, getMenu() �޼ҵ��� ������ �Ű����� String errorMsg�� �����Ѵ�.
 */
