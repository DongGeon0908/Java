package ex02_persons;


/*
 * [ Persons_Mgmt_UsingClass ]: �Ż����� �߰�, ��ü ����, ��ġ �̵�, ���� ����, �Ż����� ���� ���� �Ż����� �������� ����(Ʋ���� �̿�)
 *
 *   o ���α׷��� ��Ÿ��
 *     1) Person Ŭ���� �ۼ��Ͽ� ���� �۾��� �����ϰ� ��
 *     2) �޼ҵ���� �̿��Ͽ� �Ż����� �߰�, ��ü ����, ��ġ �̵�, ���� ����, ���� ���� �Ż����� ���������� ���� 
 *
 *   o ���α׷� ����
 *     1) ������: �Ż����� �׸���� �����ϴ� �迭, �޴��� ���õ� ������ ���� �ʵ�� ������
 *     2) �޼ҵ�: ���� �۾� ó���� ���� ���� �޼ҵ�� ������
 */

class Person {
	String 	name;    	      	// �̸��� ������ �ʵ�
	int    	age;		        // ���̸� ������ �ʵ�
	String 	currentLocation; 	// ����ġ�� ������ �ʵ�

	// �̸�, ���̰� �Ű������� �־����� �̸� �ʵ� name, age�� �����ϴ� ��ü ������
	Person(String name, int age) {
		this.name = name;  	// �Ű����� name�� this ��ü�� name �ʵ忡 ����
		this.age = age;    	// �Ű����� age�� this ��ü�� age �ʵ忡 ����
	}

	// �̸�, ����, ����ġ�� �Ű������� �־����� �̸� �ʵ� name, age, currentLocation�� �����ϴ� ��ü ������
	Person(String name, int age, String location) {
		this.name = name;  	// �Ű����� name�� this ��ü�� name �ʵ忡 ����
		this.age = age;    	// �Ű����� age�� this ��ü�� age �ʵ忡 ����
		this.currentLocation = location;
	}
	// goTo(): ���ٶ�� �ൿ�� �����ϴ� �޼ҵ�
	//   �־��� ��ҷ� ���ԵǸ� �� ��Ұ� ����ġ�� �ǹǷ� 
	//   �Ű����� location�� �ʵ� currentLocation�� ����
	void goTo(String location)  {
		this.currentLocation = location;  // �� ��ġ�� �־��� location���� ����
	}

	// toString(): ��ü�� �ʵ��� �ʵ尪�� ���ڿ��� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
	//    �� �޼ҵ�� �ݵ�� �ۼ��Ǿ�� �ϴ� �޼ҵ� ���� �ϳ���
	public String toString() {
		return "�̸�:" + this.name + ", ����:" + this.age + "��, ����ġ:"
				+ this.currentLocation ;
	}

	// output(): ��ü�� �ʵ��� �ʵ尪�� �־��� msg�� �Բ� ����ϴ� �޼ҵ�
	void output(String msg) {
		System.out.println(msg + this.toString());
	}	
}

class Ex6_Persons_Mgmt_UsingClass {

	/*
	 *   �޼ҵ� �ܺο� ����� �ʵ��: �̵� �������� ��� �޼ҵ忡�� ��� ������ ����������
	 */

	//  �Ż����� �׸�(�̸�, ����, ����ġ)�� �����ϱ� ���� �迭���� ����
	static Person[] persons = new Person[100];		

	// noPersons: �Ż����� �߰��� ����� �ο����� �����ϴ� ����, �� ������ �Ż����� �׸��� �����ϴ� �迭������ �ε����� �����
	static int noPersons = 0;   // ó���� �Ż����� �ο����� 0�� �ʱ�ȭ�ؾ� �� 

	// ���� ��ü�� Ÿ��Ʋ�� �����ϴ� ����
	static String workTitle = "\n\n"                              
	               		+     "  **************************************\n"
			            +     "  **        �Ż����� ��������                             **\n"
			            +     "  **************************************\n";

	// ������ ���� �޴� �̸��� �����ϴ� �迭����
	static String nemuNames[] = { "�Ż����� ��ü ����", "�Ż����� �߰�", "��ġ �̵�", "���� 1 ����", "�Ż����� ����", "�����ϱ�" };	
	static int ENDmenu = nemuNames.length; // ����޴� ��ȣ�� �����ϴ� ������, nemuNames[] �迭�� ���� ������ ���� �޴� ��ȣ��

	static String menuPromptMsg = "\n   o ������ �����Ͻÿ� > ";
	static String menuErrorMsg = "\n\n  ??? ������ �߸� ���õǾ����ϴ�. �ٽ� �ùٸ� ������ �����Ͻÿ�!!!";


	/*
	 * main() �޼ҵ�: �ʱ�ȭ �޼ҵ带 ȣ���ϰ� ����޴� ���ñ��� �Ż����� ���������� �ݺ��Ͽ� ������
	 */
	public static void main(String[] args) {

		initializePersonsInfo();  // ó���� �Ż������� �ʱ�ȭ�ϴ� �޼ҵ带 ȣ���Ͽ� �̸� 4���� �Ż������� �߰���

		/*
		 *   ����޴��� ������ ������ �Ż����� ���������� �ݺ��Ͽ� ������ 
		 */ 

		while(true) {

			int menu = selectMenu();  // �޴��� �����Ͽ� menu ������ ������

			if (menu == ENDmenu) {   // ���� �޴��� �����ϸ� ���� ������ ���� �� ���α׷��� ������  		
				doEndMenu();
				return;  // main()������ return ������ ���α׷��� �����Ŵ, << break; >>�� ���α׷��� �����Ŵ 
			}

			doWorkForMenu(menu);  // ���õ� menu�� ���� ������ �����ϰ� ��

		}
	}

	// initializePersonsInfo(): ������ �����ϱ� ���� �ʱ�ȭ �۾��� �����ϴ� �޼ҵ�
	//   4���� �Ż������� �̸� �߰���
	static void initializePersonsInfo() {
		addPersonInfo("ȫ�浿", 18, "�ݰ���");
		addPersonInfo("�ڹ���", 35, "�Ѿ�");
		addPersonInfo("�̸���", 16, "����");
		addPersonInfo("������", 14, "����");
	}

	// addPersonInfo(): �Ż����� �׸���� �־����� �̸� �Ż������� �����ϴ� �迭�� �����ϴ� �޼ҵ�
	//   �� �޼ҵ尡 ����Ǹ� �ο����� �����ϴ� noPersons ������ 1 �����Ѵ�.
	static void addPersonInfo(String name, int age, String currentLocation) {
		Person p = new Person(name, age, currentLocation);   // �־��� �Ż������� Person ��ü ����                   
		persons[noPersons] = p;  // persons[] �迭�� noPersons ��ġ�� �־��� ����ġ�� ����

		noPersons++; // ����� �ο����� 1 ������Ŵ	
	}

	// listPersonsInfo(): �Ż������� �����ϴ� �迭�� ����� ��� �Ż������� ���ʷ� ����ϴ� �޼ҵ�
	//   �Ż����� ��½� ������ ���� ��µ�
	static void listPersonsInfo(String title) {
		System.out.println(title);

		for (int i = 0; i < noPersons; i++) 
			persons[i].output("  * " + (i +1) +"��° �Ż�����: ");

	}

	// add1ToAgesOfPersonsInfo(): �Ż������� ����� ��� ���̸� 1 ������Ű�� �޼ҵ�
	static void add1ToAgeOfPersonsInfo() {
		for (int i = 0; i < noPersons; i++) {	
			persons[i].age++;
		}
	}

	// deletePersonInfo(): �Ż������� �����ϴ� �迭�� ����� �Ż����� �߿��� index ��ġ�� �Ż������� �����ϴ� �޼ҵ�
	static void deletePersonInfo(int index) {

		// index ��ġ�� �Ż����� �׸��� �����ϱ� ���ؼ��� index ������ ��� �Ż����� �׸���� �� ��ġ ������ �̵���Ű�� �� 
		for (int i = index; i < noPersons - 1; i++) {	
			persons[i].name = persons[i + 1].name;          // ���� ��ġ�� �Ż����� �̸��� ���� ��ġ�� ���ʴ�� �����Ͽ�  index ��ġ�� �Ż����� �̸� �׸� ���� 
			persons[i].age = persons[i + 1].age;            // �Ż����� ���̿� ���� �����ϰ� ���� 
			persons[i].currentLocation = persons[i + 1].currentLocation;  // �Ż����� ����ġ�� ���� �����ϰ� ���� 
		}

		noPersons--; // index ��ġ�� �Ż������� �����Ͽ����Ƿ� ����� �Ż����� �ο����� 1 ������ 
	}

	// selectMenu(): �޴��� ����ϰ� �޴��� �Է¹޾� �������� �޴��̸� �̸� ��ȯ�ϴ� �޼ҵ�	
	static int selectMenu() {

		while (true) { // �ùٸ� ������ ���� �޴��� ���õ� ������ �ݺ��Ͽ� ���� �޴��� ������ 
			displayMenus(workTitle, nemuNames); // 

			int menu = SkScanner.getIntWithPrompt(menuPromptMsg);

			if (menu >=1 && menu <= ENDmenu) {   // ������ �޴� ������ �����ϸ� �޴� ������ �Ϸ�ǹǷ� 
				return menu;		             //     return ���� �̿��Ͽ�  ������ �޴���ȣ�� ��ȯ�ϰ� �޼ҵ� ������
			}
			else { // �߸��� �޴� ������ �����ϸ� �ٽ� �޴� ������ �Է��ϵ��� �� 
				System.out.println(menuErrorMsg);	
			}
		}
	}

	// displayMenus(): ���ڿ� �迭 menus[]�� �޴����� 1���� ���ʷ� ������ �ο��Ͽ� ����ϴ� �޼ҵ�
	static void displayMenus(String title, String[] menus) {
		System.out.println(title);

		for (int i = 0; i < menus.length; i++)
			System.out.println("    " + (i + 1) + ") " + menus[i]);    	
	}

	/* 
	 * �Ż����� ���������� �Ż����� �߰�, ����, ��ġ �̵�, ���� 1 ����, �Ż����� ���� ������ ������
	 *   ���� ���� ���õ� ������ ������ �����ϵ��� ������ �ڵ带 �ۼ���
	 */
	static void doWorkForMenu(int menu) {

		/*
		 * ������ �޴��� ���� �Ż����� ���������� ���� 
		 */
		switch (menu)  { 
		case 1:   
			doListPersonsInfoMenu();   // ��� �Ż����� ����Ʈ ���� 
			break;

		case 2:
			doAddPersonInfoMenu();  // �Ż����� ��ü ���� ����
			break;  				

		case 3:
			doChangeLocationMenu();  // ��ġ �̵� ���� 
			break;  

		case 4:
			doIncreaseAgeMenu();  // ���� 1 ���� ����
			break;  

		case 5:
			doDeletePersonInfoMenu();  // �Ż����� ����  ����
			break;  				
		}
	}

	static void doListPersonsInfoMenu() {

		if (noPersons == 0) {
			System.out.println("\n\n  ??? �Ż������� �ϳ��� �����ϴ�. �Ż����� �߰� �� �����Ͻʽÿ�.");
		}
		else { // �迭�� ����� noPersons ���� �Ż����� �׸���� ��� ���
			listPersonsInfo("\n\n  *** �Ż����� ��ü ����: �̸�, ����, ����ġ ��� ***\n");

			System.out.println("\n  [ �Ż����� ���� �Ϸ� ] ��� " + noPersons + "���� �Ż������� �ֽ��ϴ�.");
		}		
	}


	// doAddPersonInfoMenu(): �Ż����� �߰� ����ó�� �޼ҵ�
	static void doAddPersonInfoMenu() {

		System.out.println("\n\n  ** �Ż����� �߰�: �̸�, ����, ����ġ �Է��Ͽ� �Ż������� �߰� ** \n");

		// �Ż����� �׸� ���� �Է��Ͽ� addPersonInfo() �޼ҵ带 �̿��Ͽ� �Ż������� �߰���
		String name = SkScanner.getStringWithPrompt("   o �̸� > ");
		int age = SkScanner.getIntWithPrompt("   o ���� > ");
		String currentLocation = SkScanner.getStringWithPrompt("   o ����ġ > ");

		addPersonInfo(name, age, currentLocation);

		listPersonsInfo("\n  ** �߰��� �Ż����� **\n");

		System.out.println("\n  [ �Ż����� �߰� �Ϸ� ] " + name + "�� �Ż������� �߰��Ǿ����ϴ�.");
	}

	static void doChangeLocationMenu() { // ��ġ �̵� ���� 
		if (noPersons == 0) {
			System.out.println("\n\n  ??? �Ż������� �ϳ��� �����ϴ�. �Ż����� �߰� �� �����Ͻʽÿ�.");
		}
		else { // �迭�� ����� noPersons ���� �Ż����� �׸���� ��� �� Ư���� �����Ͽ� ���õ� ����� �̵� ��ġ �Է��Ͽ� ����ġ ���� 
			System.out.println("\n\n  *** ��ġ �̵�: ���õ� Ư������ ����ġ �����ϱ� ***\n");

			listPersonsInfo("  ** ����� �Ż����� **\n");


			int no; // �� ��ġ �̵��� ����� ������ȣ�� ������ ���� 

			no = getValidInt(1, noPersons, "\n   o ��ġ �̵��� ����� ���� ���� > ", 
					"\n   ??? ���� �߸� ���õǾ����ϴ�. 1���� " + noPersons + " ������ ������ �����Ͻÿ�!!!");

			int index = no - 1;  // �Ż������� �����ϴ� �迭������ �ε����� �������� 1 �����Ƿ� no - 1 

			String name =  persons[index].name;
			System.out.println("\n  ** " + name + "�� ��ġ �̵��ϱ� ** \n");

			String currentLocation = persons[index].currentLocation;
			System.out.println("   * " + name + "�� ����ġ: " + currentLocation);

			String newLocation = SkScanner.getStringWithPrompt("   o �̵��� ��ġ > ");
			persons[index].currentLocation = newLocation;  // no��° �Ż������� ����ġ�� �Է��� �̵� ��ġ�� �����Ŵ 

			listPersonsInfo("\n  ** ��ġ �̵��� �Ż����� **\n");

			System.out.println("\n  [ ��ġ �̵� �Ϸ� ] " + name + "�� ����ġ�� " + currentLocation + "���� " + newLocation + "(��)�� ����Ǿ����ϴ�.");
		}
	}


	static void doIncreaseAgeMenu() {  // ���� 1 ���� ����
		if (noPersons == 0) {
			System.out.println("\n\n  ??? �Ż������� �ϳ��� �����ϴ�. �Ż����� �߰� �� �����Ͻʽÿ�.");
		}
		else { 
			// ��� ���̸� 1 �����ϴ� �Ϳ� ���� �� �Ǵ� �ƴϿ��� Ȯ���� �� ���̸� ��� ���̸� 1 ������Ŵ

			System.out.println("\n\n  *** ��� ���� 1 ����: ���� ���� Ȯ�� �� ���� 1 �����ϱ� ***\n");

			listPersonsInfo("  ** ����� �Ż����� **\n");


			int YesOrNo; // �� �Ǵ� �ƴϿ��� ���� �������� ������ ���� 

			YesOrNo = SkScanner.getIntWithPrompt("\n   o ��� �Ż������� ���̸� 1 ���̸� 1 �����ϰڽ��ϱ�? (��:1, �ƴϿ�:0) > ");

			if (YesOrNo == 1) 
				add1ToAgeOfPersonsInfo();

			listPersonsInfo("\n\n  ** ���� 1 ������ �Ż����� **\n");

			System.out.println("\n  [ ���� 1 ���� �Ϸ� ] ��� " + noPersons + "���� ���̰� 1 �����Ǿ����ϴ�. ");
		}
	}



	static void doDeletePersonInfoMenu() {  // �Ż����� ����  ����
		if (noPersons == 0) {
			System.out.println("\n\n  ??? �Ż������� �ϳ��� �����ϴ�. �Ż����� �߰� �� �����Ͻʽÿ�.");
		}
		else { 
			// �迭�� ����� noPersons ���� �Ż����� �׸���� ��� �� Ư�� �Ż����� �����Ͽ� ���õ� �Ż������� �Ż����� �׸� �迭���� ����
			System.out.println("\n\n  *** �Ż����� ����:  ���õ� �Ż������� ���� ***\n");

			listPersonsInfo("  ** ����� �Ż����� **\n");

			int no; // ������ �Ż������� ������ȣ�� ������ ���� 

			no = getValidInt(1, noPersons, "\n   o ������ �Ż������� ���� ���� > ",
					"\n   ??? ���� �߸� �����Ͽ����ϴ�. 1���� " + noPersons + " ������ ������ �����Ͻÿ�!!!\n");	

			int index = no - 1;  // �Ż������� �����ϴ� �迭������ �ε����� �������� 1 �����Ƿ� no - 1 

			String name = persons[index].name;  // ������ ����� �̸��� name�� ����

			deletePersonInfo(index);     // �Ż����� �迭���� index ��ġ�� �ż������� �����ϴ� �޼ҵ� ȣ��

			listPersonsInfo("\n  ** ������ ���� �Ż����� **\n");

			System.out.println("\n  [ �Ż����� ���� �Ϸ� ] " + no + "��° " + name + "�� �Ż������� �����Ͽ����ϴ�. ");
		}
	}


	// doEndMenu(): ���� ó�� �޼ҵ�
	static void doEndMenu() {
		System.out.println("\n\n  !!!  �Ż����� ���������� �����մϴ�.");

		System.out.println("\n\n  ^^ Well done! Have a good time!!! ^^"); // �� ������ ���α׷��� ���Ḧ ��Ÿ���� ������
	}

	// getvalidInt(): min�� max ������ �ùٸ� ������ �Է��� ������ �ݺ��Ͽ� �Է��ϰ� ��
	//   �Է��� �� ������Ʈ �޽��� promptMsg�� ����ϸ�, �߸��� ���� �Է½� ���� �޽��� errorMsg�� �����
	static int getValidInt(int min, int max, String promptMsg, String errorMsg) {

		while(true) {	
			int n = SkScanner.getIntWithPrompt(promptMsg);

			if (n < min || n > max) { // �߸��� ������ �Է��ϸ� ���� �޼��� ��� �� �ٽ� �Է��ϰ� �� 
				System.out.println(errorMsg);	
			}
			else                      // �ùٸ� ������ �Է��ϸ�
				return n;             //   return ���� �̿��Ͽ� �Էµ� ������ ��ȯ��
		}
	}
}



/*
 * [ ���α׷��� ���� �� ���� ]
 *
 *   1) �־��� ���α׷��� ���캸�� ���α׷��� ������ �ľ��϶�.
 *
 *      - main() �޼ҵ�� �ʱ�ȭ �޼ҵ带 ȣ���ϰ� ����޴� ���ñ��� �Ż����� ���������� �ݺ��Ͽ� �����Ѵ�.
 *
 *      - ���α׷��� ��������� �ۼ��Ǿ� �����Ƿ� ��ü�� �ľ�, ��� �߰��� ���� ���� ���� �����ϴ�..
 *
 *   2) ���α׷��� �����Ͽ� �޴��� �����ϰ� �ʿ��� ������ �����Ͽ� ����� Ȯ���϶�.
 *
 *
 * [ �ǽ����� ]
 * 
 *   1) �Ż����� �׸� Ű�� ��ȭ��ȣ�� �߰��ϵ��� ���α׷��� �����϶�. 
 *
 *   2) �ְ���ڿ� �ֿ����ڿ� �ְ������ �̸��� ���̸� ����ϴ� �޴��� ���ο� �޴� 6)���� �߰��Ϸ� �Ѵ�.
 *      �̸� ���� "�ְ���� �� �ֿ����� ��������" �޴��� �߰��ϵ��� ���α׷��� �����϶�. 
 *       (�������: doListYoungestOldestMenu() �޼ҵ带 �ۼ��϶�. nameOldest, ageOldest, nameYoungest, ageYoungest ������ �����ϰ� 
 *          ��� ���� �߿��� ���� ū ���� ���� ���� ã�� �� ���� �̸��� nameOldest�� nameYoungest�� 
 *          �����Ѵ�.) 
 *      
 */
