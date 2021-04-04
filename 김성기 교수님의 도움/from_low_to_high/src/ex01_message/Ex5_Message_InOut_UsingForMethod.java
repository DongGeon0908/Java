package ex01_message;


/*
 *  [ Message_InOut_UsingForMethod]: For ���� �޼ҵ��� �̿��� ���� ���ڿ� �޽����� �Է� �� ���(SkScanner�� getString() �޼ҵ� �̿�)
 *
 *   o ���α׷��� ��Ÿ��
 *     1) main() �޼ҵ�� ���� ���ڿ��� �Է��Ͽ� ����ϴ� �޼ҵ�� Ŭ���� ����
 *     2) for ���� �޼ҵ�  �̿��Ͽ� ���� ���ڿ����� �Է��Ͽ� ���ڿ� �迭 ������ �����ϰ� ���ڿ����� ���
 *     3) ���� ������Ʈ �޽����� ��� ��� ���ڿ��� �迭�� �����Ͽ� 
 *        �Է��� ������ �ٸ� ������Ʈ �޽����� ��� ����� �̿��� 
 *
 *   o for ���� �̿��Ͽ� ���� ���ڿ� �Է� �� ����� ���� ���α׷� �ۼ� �� ����
 *     - SkScanner Ŭ������ �Է� �޼ҵ���� �̿��ϸ� ���� ���� ������ �Է��� ������
 *     - SkScanner Ŭ�������� getStringWithPrompt() �޼ҵ带 ���� ������Ʈ �޽��� ��� �� ���ڿ� �Է�
 *     - getStringWithPrompt() �޼ҵ�: ������Ʈ �޽��� ��� �� ����Ű�� Ÿ���ε� ������ Ÿ���ε� ��� ���ڵ��� �Է�

 *     - �Էµ� ���ڿ��� ���ڿ� ������ ���� ����
 *         String name = SkScanner.getStringWithPrompt("\n  o ù �Է� �޽��� �Է��Ͻÿ� > ");
 *
 *   o ������Ʈ �޽��� ��� 
 *     - ������Ʈ �޽����� " �̸� �Է� : ", " ��ȯ�� ���� �µ� > " ��� ���� �Է��� ����
 *       �뵵�� �ǹ̸� �˷��ִ� ���ڿ���
 *     - ���� �Է��ϱ� ���� System.out.print() �޼ҵ带 �̿��Ͽ� ������Ʈ �޽����� ����ϰų� 
 *        ������Ʈ �޽��� ��� �� �� �Է��ϴ� �޼ҵ带 ����� 
 *     
 *  o �ۼ��� �޼ҵ�
 *    - inputOutputMessages(): ����� ������Ʈ�� �־����� �̸� �̿��Ͽ� �޽����� �Է��ϰ� ����ϴ� �޼ҵ�
 *    - inputOutputMessage(): ����� ������Ʈ�� �־����� �̸� �̿��Ͽ� �޽����� �Է��ϰ� ����ϴ� �޼ҵ�
 */

class Ex5_Message_InOut_UsingForMethod{
	// main() �޼ҵ�� ���� �޼ҵ�� �ڵ������� ȣ���
	public static void main(String[] args) {
		
		System.out.println("\n\n  ** �޼ҵ带 �̿��� ���� ���ڿ� �޽��� �Է� �� ��� **"); 
		
		// 3���� ���ڿ� �Է��� ���� ������Ʈ �޽������� �����ϴ� String �迭 ���� 
		String inPrompts[] = { "\n  o ù �Է� �޽��� �Է��Ͻÿ� > ", 
				"\n  o ��ǥ �޽��� �Է��Ͻÿ� > ",
				"\n  o �ι�° �Է� �޽��� �Է��Ͻÿ� > "
		};

		// �Էµ� 3���� ���ڿ��� ����ϱ� ���� ��� ������Ʈ ���ڿ����� �����ϴ� String �迭 ����						  
		String outPrompts[] = { "  * ù �Է� �޽��� : ", 
				"  * �Է��� ��ǥ �޽��� : ",
				"  * �ι�° �Է� �޽��� : "
		};	
		
		int cnt = inPrompts.length;  // ������� ���ڿ� �޼����� ������ ����		
		String[] msgs = new String[cnt]; // �Է��� ���ڿ� �޽������� ������ String �迭 ����	

		inputOutputMessages(inPrompts, outPrompts,msgs);
		
		// �Է��� �޽����� �ٽ� �ѹ� �����
		System.out.println("\n\n  ** �Է��� �޽�����");
		for(String msg : msgs)
			System.out.println("  * " + msg); 
		
		System.out.println("\n\n  ^^ Well done! Have a good time!!! ^^\n"); // �� ������ ���α׷��� ���Ḧ ��Ÿ���� ������
	}

	// inputOutputMessages(): ����� ������Ʈ�� �־����� �̸� �̿��Ͽ� �޽����� �Է��Ͽ� ������ ��  ����ϴ� �޼ҵ�
	//   �Ű������� String �迭�� ���޵�
	static void inputOutputMessages(String[] inPrompts, String[] outPrompts, String[] msgs) {
		int cnt = inPrompts.length;  // ������� ���ڿ� �޼����� ������ ����
		
		for (int i=0; i < cnt; i++) 
			msgs[i] = inputOutputMessage(inPrompts[i], outPrompts[i]);		
	}
	
	// inputOutputMessage(): ����� ������Ʈ�� �־����� �̸� �̿��Ͽ� �޽����� �Է��ϰ� ����ϴ� �޼ҵ�
	//   �Ű������� String �迭�� ���޵�
	static String inputOutputMessage(String inPrompts, String outPrompt) {

		String msg; // �Է��� ���ڿ� �޽������� ������ String �迭 ����	

		msg = SkScanner.getStringWithPrompt(inPrompts);   // ������Ʈ �޽��� ����ϰ� ���ڿ� �Է��Ͽ� �迭 ���� msgs[i]�� ����

		System.out.println(outPrompt + msg);  // outPrompts[]�� �̿��Ͽ� �Է��� �迭 ���� msgs[i] ���� ��� 
		
		return msg;
	}
}


/*
 * [ ���α׷��� ���� �� ���� ]
 *
 *   1) �־��� ���α׷��� ���캸�� ���α׷��� ���븦 �ľ��϶�.
 *
 *      - main() �޼ҵ尡 �ۼ��Ǿ� �ִ�.
 *
 *      - main() �޼ҵ�� inputOutputMessage() �޼ҵ带 ȣ���Ͽ� ���ڿ� �޽����� �Է��ϰ� �����
 *      
 *      - inputOutputMessage() �޼ҵ�� String �迭�� �Ű������� ���޵Ǹ�,
 *        for ���� �̿��Ͽ� ���� ���ڿ����� �Է��Ͽ� ���ڿ� �迭 ������ �����ϰ� ���ڿ����� ����Ѵ�.
 * 
 *      - ���� ������Ʈ �޽����� ��� ��� ���ڿ��� �迭�� �����Ͽ� 
 *        �Է��� ������ �ٸ� ������Ʈ �޽����� ��� ����� �̿��Ѵ�. 
 *
 *   2) ���α׷��� �����Ͽ� ����� Ȯ���϶�.
 *
 * [�ǽ� ���� ]
 * 
 *   1) ������ �����ϴ� �ݾ��� �߰��� �Է��Ͽ� ����ϵ��� ���α׷��� �����϶�. 
 *
 *      �̸� ���ؼ�  inPrompts[]�� outPrompts[]�� ���ο� ������Ʈ ���ڿ��� �߰��ϱ⸸ �ϸ� ��  
 *
 *   2) ������ �̸�, ����, ����ġ�� �߰��� �Է��Ͽ� ����ϵ��� ���α׷��� �����϶�.
 *   
 *   3) �� ���α׷��� ���ڿ� �޽����� �Է��ϰ� ���ڿ��� �ٷ� ����Ѵ�.
 *      �̿� �޸� ���� ���ڿ� �޽����� �Է��Ͽ������� �� �Էµ� ���ڿ� �޽������� �Ѳ����� ����ϵ��� 
 *      ���α׷��� �����϶�.
 *       
 *      ���� ���, ����� ���α׷��� ������� ������ ����.
 *      ================================
        
        ** �޼ҵ带 �̿��� ���� ���ڿ� �޽��� �Է� �� ��� **

        o ù �Է� �޽��� �Է��Ͻÿ� > ù ���α׷�
        o ��ǥ �޽��� �Է��Ͻÿ� > Java ������
        o �ι�° �Է� �޽��� �Է��Ͻÿ� > good       
        
        * ù �Է� �޽��� : ù ���α׷�
        * �Է��� ��ǥ �޽��� : Java ������
        * �ι�° �Է� �޽��� : good

   
        ^^ Well done! Have a good time!!! ^^
 *      ================================
 *              
 *     �̸� ���Ͽ�  ������ �޼ҵ带 �ۼ��϶�.
 *     
 *       (1) �Է� ������Ʈ���� �־����� �Է� ������Ʈ���� ����ϰ�  �޽������� �Է��Ͽ� mags �迭�� �����Ͽ� ��ȯ�ϴ� 
 *           static String[] inputMessages(String[] inPrompts, String[] msgs) �޼ҵ�
 *           
 *       (2) ���  ������Ʈ �޽������  �޽������� �־����� �̵��� ����ϴ�   
 *           static void outputMessages(String[] outPprompts, String[] Msgs) �޼ҵ�
 *           
 *       (3) �Է� ������Ʈ �޽����� �־����� �� �޽������� ����ϰ� ���ڿ��� �Է��Ͽ� ��ȯ�ϴ�    
 *           static String inputMessage(String inPrompt) �޼ҵ�
 *           
 *       (4) ���  ������Ʈ �޽����� ��� �޽����� �־�����  �̵��� ����ϴ�   
 *           static void outputMessage(String outPrompt, String Msg) �޼ҵ�
 *           
 *        main() �޼ҵ忡���� inputMessages(String[] inPrompts, String[] msgs) �޼ҵ��  
 *        outputMessages(String[] outPprompts, String[] Msgs) �޼ҵ带 ȣ���Ѵ�.
 *             
 *
 */
