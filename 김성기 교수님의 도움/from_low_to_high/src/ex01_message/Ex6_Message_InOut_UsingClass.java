package ex01_message;


/*
 *  [ Message_InOut_UsingClass]: Ŭ������ ��ü��  �̿��� ���� ���ڿ� �޽����� �Է� �� ���(SkScanner�� getString() �޼ҵ� �̿�)
 *
 *   o ���α׷��� ��Ÿ��
 *     1) �Է� ������Ʈ �ʵ�, ��� ������Ʈ �ʵ�, �Է� �޽��� ���� �ʵ带 ���� 
 *        Ŭ������ �ۼ��Ͽ� ���� �޽����� �Է��ϰ� �Էµ� �޽����� ����ϴ�  Ŭ���� ����
 *     2) ���� ���ڿ� �޽������� �Է��Ͽ���ü�� �ʵ忡 �����ϰ� ���
 *     3) ���� ������Ʈ �޽����� ��� ��� ���ڿ��� �迭�� �����Ͽ� 
 *        �Է��� ������ �ٸ� ������Ʈ �޽����� ��� ����� �̿��� 
 *
 *   o ���ڿ� �Է�
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
 *   o ���ڿ� ���
 *     - printf() �޼ҵ带 ���� ���ڿ� ���
 */

class Message {
	String inPrompt;   // �޽��� �Է��� ���� �Է� ������Ʈ
	String outPrompt;  // �޽��� ����� ���� ��� ������Ʈ
	String msg;
	
	// ����� ������Ʈ�� �־����� �̸� ����� ������Ʈ �ʵ忡 �����ϴ� ��ü ������
	Message(String inPrompt, String outPrompt) {
		this.inPrompt = inPrompt;
		this.outPrompt = outPrompt;
	}
	
	// �Է� ������Ʈ��  ����� �� �޽����� �Է��Ͽ� msg �ʵ忡 �����ϴ� �޼ҵ� 
	void inputMessage() {
       this.msg = SkScanner.getStringWithPrompt(inPrompt);   // �Է� ������Ʈ �޽��� ����ϰ� ���ڿ� �Է��Ͽ� msg �ʵ忡 ����
	}
	
	
	// ��� ������Ʈ�� msg �ʵ带 ����ϴ� �޼ҵ� 
	void outputMessage() {
		System.out.println(outPrompt + msg);  //  ��� ������Ʈ�� msg �ʵ带 ���			
	}
	
	// �Է� ������Ʈ��  ����� �� �޽����� �Է��Ͽ� msg �ʵ忡 �����ϰ� �Էµ� msg�� ��� ������Ʈ�� �Բ� ����ϴ�  �޼ҵ� 
	void inputOutputMessage() {
		inputMessage();
		outputMessage();
	}

}
class Ex6_Message_InOut_UsingClass{
	// main() �޼ҵ�� ���� �޼ҵ�� �ڵ������� ȣ���
	public static void main(String[] args) {
		
		System.out.println("\n\n  ** Ŭ������ �̿��� ���� ���ڿ� �޽��� �Է� �� ��� **"); 
		
		// 3���� ���ڿ� �޽��� �Է��� ���� Message �迭  �����Ͽ� msgs �迭�� ���� 
		Message[] msgs =  { 
				new Message("\n  o ù �Է� �޽��� �Է��Ͻÿ� > ",    "  * ù �Է� �޽��� : "),
				new Message("\n  o ��ǥ �޽��� �Է��Ͻÿ� > ",      "  * �Է��� ��ǥ �޽��� : "),
				new Message("\n  o �ι�° �Է� �޽��� �Է��Ͻÿ� > ", "  * �ι�° �Է� �޽��� : ")
		};
 
		inputOutputMessages(msgs);
	}

	// inputOutputMessages(): Message �迭 msgs�� �־����� �̸� �̿��Ͽ� ���� �޽����� �Է��ϰ� ����ϴ� �޼ҵ�
	static void inputOutputMessages(Message[] msgs) {
		int cnt = msgs.length;  // ������� ���ڿ� �޼����� ������ ����
				
		int i;
		for (i=0; i < cnt; i++)
			msgs[i].inputOutputMessage();

		System.out.println("\n\n  ^^ Well done! Have a good time!!! ^^\n"); // �� ������ ���α׷��� ���Ḧ ��Ÿ���� ������
	}
}


/*
 * [ ���α׷��� ���� �� ���� ]
 *
 *   1) �־��� ���α׷��� ���캸�� ���α׷��� ���븦 �ľ��϶�.
 *
 *      - Message Ŭ����
 *        . inPrompt, outPrompt, msg: �Է� ������Ʈ �ʵ�, ��� ������Ʈ �ʵ�, �Է��� �޽��� ������ �ʵ�
 *        . Message(String inPrompt, String outPrompt): �Է� ������Ʈ�� ��� ������Ʈ�� �����ϴ� ��ü ������
 *        . inputMessage(): �޽����� �Է��ϴ� �޼ҵ� 
 *        . outputMessage()�޽����� ����ϴ� �޼ҵ�
 *        . inputOutputMessage()�޽����� �Է��ϰ� ����ϴ� �޼ҵ�
 *        
 *      - main() �޼ҵ�
 *        . Message ��ü���� �����Ͽ� mads �迭�� ����
 *        . nputOutputMessages(Message[] msgs) �޼ҵ� ȣ���Ͽ� ���� �޽����� �Է��ϰ� ���
 *        
 *      - main() �޼ҵ�� inputOutputMessage() �޼ҵ带 ȣ���Ͽ� ���ڿ� �޽����� �Է��ϰ� �����
 *
 *   2) ���α׷��� �����Ͽ� ����� Ȯ���϶�.
 *
 *
 * [�ǽ� ���� ]
 * 
 *   1) ������ �����ϴ� �ݾ��� �߰��� �Է��Ͽ� ����ϵ��� ���α׷��� �����϶�. 
 *
 *      �̸� ���ؼ�  Message[] msgs�� �迭 �ʱ�ȭ �κп� ���ο� �迭��ü�� �����Ͽ� �߰��ϱ⸸ �ϸ� ��  
 *
 *   2) ������ �̸�, ����, ����ġ�� �߰��� �Է��Ͽ� ����ϵ��� ���α׷��� �����϶�.
 *   
 *   3) �� ���α׷��� ���ڿ� �޽����� �Է��ϰ� ���ڿ��� �ٷ� ����Ѵ�.
 *      �̿� �޸� ���� ���ڿ��� �Է��Ͽ� Message ��ü�� ������ �� �Էµ� ���ڿ��� �Ѳ����� ����ϵ��� 
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
 *       (1) Message �迭 msgs�� �־�����  msgs �迭 ������ �Է� ������Ʈ���� ����ϰ� �޽����� �Է��Ͽ� msgs �迭 ���ҿ� ���� �����ϴ� 
 *           static void inputMessages(Message[] msgs) �޼ҵ�
 *           
 *       (2) Message �迭 msgs��  �־����� msgs �迭 ������ ��� ������Ʈ��  �޽����� ����Ͽ�    
 *           static void outputMessages(Message[] msgs) �޼ҵ�           
 *           
 *        main() �޼ҵ忡���� inputMessages(Message[] msgs) �޼ҵ��  
 *        static void outputMessages(Message[] msgs) �޼ҵ带 ȣ���Ѵ�.
 *             
 *
 */
