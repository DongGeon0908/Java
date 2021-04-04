
import javax.swing.*;        

/**
 * [ JOptionPane ]: JOptionPane�� ������ �����ִ� ����
 * 
 *   o JOptionPane
 *     - ���ڿ��� �Է��ϰų� ������ ����ϱ� ���� ǥ�� ��ȭ���ڸ� �˾���Ű�� ���� ����� �����ϴ� Ŭ����
 *       
 *   o JOptionPane�� �ֿ� �޼ҵ�
 *     - public static String showInputDialog(Object message) : 
 *           message�� ����� �� ����� �Է� �޾� ���ڿ��� ��ȯ
 *           
 *     - public static int showConfirmDialog(Component parent, Object msg, 
 *           String title, int optionType): title�� msg ����ϰ� optionType�� ���� �Է��� ������ ��ȯ
 *           
 *     - public static void showMessageDialog(Component  parent, Object msg): msg ���
 *     
 *     - public static void showMessageDialog(Component parent, Object msg, 
 *           String title, int optionType): title ����ϰ� optionType�� ���� msg ���   
 *              
 *     - ��� static �޼ҵ��̹Ƿ� ��ü �������� �ʰ� Ŭ���� �̸����� ȣ�� ����
 *   
 *   o ��� ����(modal type)�� ��ȭ���� �۵����
 *     - JOptionPane�� �޼ҵ尡 ȣ��Ǹ� ��ȭ ���ڰ� �����Ǿ� ȭ�鿡 ��Ÿ��
 *     - JOptionPane ��ȭ������ �۾��� �Ϸ�� ������ Java ���α׷��� ���
 *     - �̷��� ����� ��ȭ���� �۵������ ��� ����(modal type)�̶� �� 
 */

class Ex12_3_08_1_JOptionPane {
	public static void main(String[] args) {		
		String name = JOptionPane.showInputDialog("�̸��� �Է��Ͻÿ�");  
		
		System.out.println("�̸�: " + name);			
		JOptionPane.showMessageDialog(null, "�Էµ� �̸��� " + name +"�Դϴ�.", 
                "INFORMATION_MESSAGE", JOptionPane.INFORMATION_MESSAGE); 


		int yes_or_no = JOptionPane.showConfirmDialog(null, "����� �����Դϱ�?", 
				                         "ConfirmDialog", JOptionPane.YES_NO_OPTION);  
		
		if (yes_or_no == JOptionPane.YES_OPTION) 
			System.out.println("����� �����Դϴ�.");
		else
			System.out.println("����� �����Դϴ�.");
	
		JOptionPane.showMessageDialog(null, "����� " + (yes_or_no == JOptionPane.YES_OPTION ? "����" : "����") + "�̳׿�.", 
                "INFORMATION_MESSAGE", JOptionPane.INFORMATION_MESSAGE); 
 
		// �л� ���� Ȯ�ν� ����ڿ� ���� ������ ��ҵ� ������
		int yes_or_no_cancel = JOptionPane.showConfirmDialog(null, "����� �л��Դϱ�?", 
				                   "ConfirmDialog", JOptionPane.YES_NO_CANCEL_OPTION);  		
		if (yes_or_no_cancel == JOptionPane.YES_OPTION) 
			System.out.println("����� �л��Դϴ�.");
		else if (yes_or_no_cancel == JOptionPane.NO_OPTION) 
			System.out.println("����� �л��� �ƴմϴ�.");
		else if (yes_or_no_cancel == JOptionPane.CANCEL_OPTION) 
			System.out.println("����ڿ� ���� ������.");
		else if (yes_or_no_cancel == JOptionPane.CLOSED_OPTION) 
			System.out.println("����ڿ� ���� ��ҵ�");  
			
		// ���� ������ �޽����� �����ִ� ����
		JOptionPane.showMessageDialog(null, "���ݺ��� ���� �޽��� ���ڰ� ���Դϴ�.", 
                "INFORMATION_MESSAGE", JOptionPane.INFORMATION_MESSAGE); 

		JOptionPane.showMessageDialog(null, "����ڿ� ���� ������"); 

		JOptionPane.showMessageDialog(null, "����ڿ� ���� ��ҵ�", 
            	                "PLAIN_MESSAGE", JOptionPane.PLAIN_MESSAGE); 
		
		JOptionPane.showMessageDialog(null, "������ �ԷµǾ�� �մϴ�", 
	                        	"ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE); 
		
		JOptionPane.showMessageDialog(null, "������ ���� ������� �ʾҽ��ϴ�", 
                             	"WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE); 
		
		JOptionPane.showMessageDialog(null, "�ο����� Ȯ���ϱ� �ٶ��ϴ�", 
             	                "QUESTION_MESSAGE", JOptionPane.QUESTION_MESSAGE); 
		
		JOptionPane.showMessageDialog(null, "����ڰ� �α��� �Ǿ����ϴ�", 
								"INFORMATION_MESSAGE", JOptionPane.INFORMATION_MESSAGE); 		
	}
}

/*
 * [ ���α׷��� ���� �� ���� ]
 *   
 *   1) �־��� ���α׷��� ���캸�� ���α׷��� ������ �ľ��϶�.
 *      - OptionPane�� �Է� �۾�, Ȯ�� �۾�, �޽��� ��� �۾� � ���Ǵ� �޼ҵ�� �޼ҵ��� �Ű������� �޶����� 
 *        ��ȭ���ڰ� �޶���
 *             
 *   2) ���α׷��� �����ϰ� ����� Ȯ���϶�.    
 *      - �Է� ��ȭ ���ڿ��� �Էµ� ���ڿ��� ���α׷��� ���޵Ǿ� ���� �信 ��µǰų� ��ȭ ���ڿ� ��µ��� Ȯ���϶�.      
 */
