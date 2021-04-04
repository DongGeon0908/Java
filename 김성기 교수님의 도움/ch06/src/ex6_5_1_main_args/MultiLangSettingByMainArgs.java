package ex6_5_1_main_args;

/**
 * [ MultiLangSettingByMainArgs Ŭ���� ]: 
 *       �ܺο��� main() �޼ҵ�� ���޵� ���� �̿��Ͽ� �ٱ��� ó���ϱ�
 *   
 *   o main() �޼ҵ��� args[] �迭����
 *     - Java ���α׷��� ������ �� Java ���α׷����� ���ڿ� ������ �����ϱ� ���� ����
 *     
 *     - �ܺο��� ���α׷����� ���ڿ� ���� ���� ���
 *       1) ��ɾ� ���ο��� �����ϱ�: java Ŭ�����̸� ���ڿ�1 ���ڿ�2 ���ڿ�3 ...
 *       
 *          ��: java MultiLangSettingByMainArgs -lang ENG  Hi! "My name" -lang KOR  is "Hong Gildong" 
 *                                              -lang JAP  in "Seoul Korea"
 *                                                     
 *           
 *       2) Eclipse���� �����ϱ�: Run -> Run Configurations Ŭ���� ��
 *           (x)= argument ���� Ŭ���Ͽ� program arguments �Է�â�� ������ ���ڿ� �Է�
 *           
 *           -lang ENG  Hi! "My name" -lang KOR  is "Hong Gildong" -lang JAP  in "Seoul Korea"
 *           
 *     - �������
 *       1) ���ڿ��� "�� " ���̿� ǥ���� �� �ְų� " �����ص� �� 
 *       2) blank, tab ���� ȭ��Ʈ �����̽� ���ڰ� ���ڿ��� ���Ե� ��� �ݵ�� "�� " ���̿� ���ڿ� ǥ���ؾ� ��
 *        
 *   o main() �޼ҵ��� args[] �迭������ Ȱ��
 *     - �ܺο��� ���޵� ������ �ַ� ���α׷��� �ʱ� ������ ���Ǹ�, 
 *       �̵��� ���α׷� �ɼ� �������׿� �ش��
 *       
 *     - ���� ���, �ٱ��� ������ ������ ���α׷��� ��� ���� ��� �߿��� Ư�� ��� ������ 
 *       main() �޼ҵ��� args[]�� ���޹޾� ������ �� ���� 
 *       
 *     - �� ���α׷����� args[]�� �ǸŰ������� "-lang" ������ "KOR", "ENG", "JAP" �� �ϳ��� �־�����  
 *       ����� �ѱ���, ����, �Ϻ���� ��
 */

class MultiLangSettingByMainArgs {
	static int KOR = 0;
	static int ENG = 1;
	static int JAP = 2;
 
	public static void main(String[] args) {
		int lang = KOR;

		// ��ɾ� ������ ù �Ű������� "-lang"�̰� ���� �Ű������� "KOR", "ENG", "JAP" �� �ϳ��̸�
		// �ش� ���� ����
		if (args.length >= 2 && args[0].equals("-lang")) {
			if (args[1].equals("KOR"))
				lang = KOR;
			else  if (args[1].equals("ENG"))
				lang = ENG;
			else if (args[1].equals("JAP"))
				lang = JAP;
	    }

		if (args.length == 0) { // args.length�� args[] �迭�� ���� ���� �����ϴ� �ʵ�
			if (lang == KOR)
				System.out.println("  * �ܺ� ��ɾ� ���ο��� ���޵� ���ڿ� ������ ����");
			else  if (lang == ENG)
				System.out.println("  * No program arguments passed to from command-line ");
			else  if (lang == JAP)
				System.out.println("  * ��ݻ���ޫ�� �髤�󪫪� Ԥ���쪿 ���֪���ê��ʪ�����");      	 
		}
		else {
			if (lang == KOR)
				System.out.println("\n\n  ** �ܺο��� ���޵� ���ڿ� ���� ����: " + args.length + " ** \n");
			else  if (lang == ENG)
				System.out.println("\n\n  ** The number of program arguments passed to from command-line: " + args.length + " ** \n");
			else  if (lang == JAP)
				System.out.println("\n\n  ** ��ݻ���ޫ�� �髤�󪫪� Ԥ���쪿 ���֪���ë������: " + args.length + " ** \n"); 


			for (int i = 0; i < args.length; i++) {
				if (args[i].equals("-lang") && args.length > (i + 1)) {
					switch(args[i+1]) {
					case "KOR" : 
						lang = KOR;
						System.out.println("\n  ** ��� ����: �� �ѱ���� ������ ** \n");
						break;
					case "ENG" : 
						lang = ENG;
						System.out.println("\n  ** Language setting: The language is set to English **\n");
						break;
					case "JAP" : 
						lang = JAP;
						System.out.println("\n  ** ��������: ���ު������ު����Ҫ���� **\n");
						break;
					}		  
				}

				if (lang == KOR)
					System.out.println("  * " + (i + 1) + "��° ���޵� ���ڿ� ����: " + args[i]);
				else  if (lang == ENG)
					System.out.println("  * " + (i + 1) + "-th passed string information: " + args[i]);
				else  if (lang == JAP)
					System.out.println("  * " + (i + 1) + "����Ԥ���쪿���֪����: " + args[i]);      	 
			}
		}
	}
} 

/*
 * [ ���α׷� ���� �� ���� ]
 * 
 *   1) �� ���α׷��� ���α׷� �ܺο��� ���޵� ���ڿ� ������ main() �޼ҵ��� args[] �迭������ ���޹޾�
 *      ����ϸ鼭 -lang ENG, -lang KOR, -lang JAP�� ���ԵǸ� �ش� ���� ��� �޽����� �����Ѵ�.
 *      
 *      ���� ���, -lang ENG  Hi! "My name" -lang KOR  is "Hong Gildong" -lang JAP  in "Seoul Korea"�� �����ϸ� 
 *      �̵� ���ڿ� ������ ���ڿ����� ���ʷ� ����Ѵ�.
 *      
 *   2) Eclipse���� ���α׷����� ���ڿ� ���� �����ϴ� ���
 *   
 *      Eclipse�� Run -> Run Configurations... ->
 *        -> Main �ǿ���  << Main class: >> �������� search Ŭ���Ͽ� MultiLangSettingByMainArgs ã�� Ŭ��
 *        ->(x)= arguments �� Ŭ�� 
 *        -> Program arguments: â��  -lang JAP  Hi! "My name" is "Hong Gildong" in "Seoul Korea" �Է�
 *        -> Run Ŭ���ϸ� �������� console �信 ��µ�
 *          
 *   3) ���α׷��� �����ϰ� ����� Ȯ���϶�.
 *   
 *   
 * [ �ǽ����� ]
 * 
 *   1) Program arguments: â��  -lang ENG  Hi! "My name" is "Hong Gildong" in "Seoul Korea" 
 *      �Է� ������ �� ���α׷��� �����Ͽ� ��� Ȯ���϶�.
 *   
 *   2) Program arguments: â��  -lang KOR  Hi! "My name" is "Hong Gildong" in "Seoul Korea" 
 *      �Է� ������ �� ���α׷��� �����Ͽ� ��� Ȯ���϶�.
 */
