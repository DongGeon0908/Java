import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import java.util.Arrays;  // ���� �迭 ���� �񱳸� ���� import

/**
 * [ JFrameWithJTextField_JPasswordField]: 
 *    JTextField�� JPasswordField�� JFrame ��ü�� ��ġ�ϰ� ���̵�� �н����� �Է��Ͽ� "1234"�� ��
 *    
 *   o JTextField�� JPasswordField
 *     - �� ������ ���ڿ� �Է��ϴ� ������Ʈ
 *     - TextField�� JPasswordField�� ���� ���� ��� ����
 *     - ��, TextField�� �ԷµǴ� ���� ǥ�õǸ�, JPasswordField�� �ԷµǴ� ���� ������
 *     
 *   o TextField�� JPasswordField�� �Էµ� ���ڿ� ��������
 *     - public String getText() : JTextField���� �Էµ� ���ڿ� �������� �޼ҵ�
 *     - public char[] getPassword() :JPasswordField���� �Էµ� ���ڿ� �������� �޼ҵ�
 *     
 *     - Java�� ���ڿ��� ���� �Ұ��Ͽ� �н����带 ���ڿ��� �����ϸ� ������ ��� �� ���� �� ������, 
 *       ���ڿ��� �����Ⱑ ������ ������ JVM�� �����Ƿ� ��ŷ�� ���� ����
 *     - �׷��Ƿ� JPasswordField ����  String���� �������� �ʰ� ���� �迭�� ������
 *     - �н����带 ��� �� �ݵ�� ���� �迭�� ������ ����� ���� ���� ������ 
 *     
 *   o ���� �迭 ���ϱ�
 *     - ���� �迭�� ������ �������� �˻��ϴ� �޼ҵ�: Java.util.Arrays Ŭ������ equals() �޼ҵ� ���     
 *     - equals() �޼ҵ��  java.util ��Ű���� Arrays Ŭ������ Ŭ���� �޼ҵ��, 
 *       �Ű������� 2 ���� �迭�� ������ ������ true, �ƴϸ� false�� ��ȯ
 *        
 *           public static boolean equals(char[] a, char[] a2)      
 *            
 *   o TextField�� JPasswordField�� ���ڿ� ����
 *     - public void setText(String s) : TextField�� JPasswordField�� ���ڿ� �����ϴ� �޼ҵ�             
 */

// GUI ���α׷��� JFrame�� Ȯ���ϴ� ���� Ŭ������ JFrame ��ü�� ������
class Ex12_4_3_JFrameWithJTextField_JPasswordField extends JFrame {
	JLabel labelLoginID = new JLabel ("�α��� ���̵�:");    // �ؽ�Ʈ ���� ���̺� ����
	JLabel labelPassword = new JLabel("�н�����         :");   // �ؽ�Ʈ ���� ���̺� ����

	JTextField tfLoginID = new JTextField(10);           // 20 ���� �Է� ������ �ؽ�Ʈ �ʵ� ����
	JPasswordField pfPassword = new JPasswordField(10);  // 20 ���� �Է� ������ �н����� �ʵ� ����

	JButton btConfirm = new JButton(" Ȯ�� ");             // �ؽ�Ʈ ���� ��ư ����

	// ��ü ������: �����츦 ���� ����
	Ex12_4_3_JFrameWithJTextField_JPasswordField(String title) { 
		super(title);

		this.setSize(250, 150);         // ���� 250�ȼ�, ���� 150�ȼ� ũ���
		this.setLocation(420, 220);     // �����츦 (420, 220) ��ġ�� ��ġ
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ���� �ɼ� ����

		this.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));  // ������Ʈ ��ġ����� flow layout���� 
	}

	// �����쿡 �ʿ��� ������Ʈ�� �߰��Ͽ� ��ġ�ϴ� �޼ҵ�
	void addComponents() {   
		this.add(labelLoginID);
		this.add(tfLoginID);
		this.add(labelPassword);
		this.add(pfPassword);
		this.add(btConfirm);
	}

	// JButton ��ü�� ��ư �̺�Ʈ ������ ��ü�� ��Ͻ�Ű�� �޼ҵ�
	//  JButton ��ü���� ���콺 Ŭ���� �Ǹ�  
	//  ��ϵ� Button_Listener ��ü�� �̺�Ʈ �޼ҵ尡 �ڵ������� ȣ��Ǹ鼭 MouseEvent ��ü�� �Ű������� ���޵�
	void enrolEventListener() {
		// �͸� Ŭ������ ����Ͽ� ������ ��ü ����
		MouseAdapter listener = new MouseAdapter() {
			// mousePressed() �޼ҵ�� ���콺 Ŭ���� �Ϸ�� ��  �ڵ������� ȣ��Ǵ� �޼ҵ�
			// �α��� ���̵�� �н����忡 ��� 1234 �ԷµǾ��°� Ȯ��
			public void mousePressed(MouseEvent e) { 
				Object src = e.getSource();  // �̺�Ʈ �߻��� �ҽ��� ����
				if (src == btConfirm) {      // �Է� �̺�Ʈ �߻� �ҽ��� btConfirm ��ư�̸�
					String loginId = tfLoginID.getText();        // tfLoginID�� �Է�  �ؽ�Ʈ�� ������ ���ڿ��� ����
					char[] password = pfPassword.getPassword();  // pfPassword�� �Է�  �ؽ�Ʈ�� ������ ���� �迭�� ����
					
					// �Էµ� ���̵�� �н����带 "1234"�� ��, 
					//   �н����� �񱳴� ���� �迭 ���� �� �޼ҵ��� Arrays Ŭ������ equals() �޼ҵ� ���
					if (loginId.equals("1234") && Arrays.equals(password, "1234".toCharArray()))
						JOptionPane.showMessageDialog(null, "�ùٸ� �α��� ���̵�� �н����尡 �Էµ�");
					else
						JOptionPane.showMessageDialog(null, "�߸��� �α��� ���̵� �Ǵ� �н����尡 �Էµ�");					
				}
			}
		}; // ������ ��ü ������ ��

		btConfirm.addMouseListener(listener);  // ������ ��ü ��Ͻ�Ŵ
	}
    
	public static void main(String[] args) {
		Ex12_4_3_JFrameWithJTextField_JPasswordField frame =    
				new Ex12_4_3_JFrameWithJTextField_JPasswordField("JTextField_JPasswordField");  // ������ ���� �� ����
		
		frame.addComponents();      // frame�� ������Ʈ���� ��ġ  
		frame.enrolEventListener(); // ��ư�� ������ ��Ͻ�Ŵ
	    frame.setVisible(true);     // frame�� setVisible(true)�� �ϸ� �����찡 ��Ÿ��
	}
}

/*
 * [ ���α׷��� ���� �� ���� ]
 *   
 *   1) �� ���α׷��� JTextField�� �α��� ���̵�, JPasswordField�� �н����带 �Է��ϰ� 
 *      �Էµ� �α��� ���̵�� �н����尡 "1234"�� "1234"�̸� "�ùٸ� �α��� ���̵�� �н����尡 �Էµ�" �޽�����, 
 *      �ƴϸ� "�߸��� �α��� ���̵� �Ǵ� �н����尡 �Էµ�" �޽����� ����Ѵ�.
 *      
 *      �α��� ���� �Ǵ� ���и� ��Ÿ���� ���ؼ��� JOptionPane�� ����Ѵ�.
 *      
 *      ���� �̺�Ʈ ó���� ����� �ʾ����� �������� ����� �������� �Ѵ�.
 *      
 *   2) �Էµ� �н������ ���� ��ȭ�� ���� String�� �ƴ� ���� �迭�� ó��ehlsek.
 *   
 *      - << char[] password = pfPassword.getPassword(); >>���� �Էµ� �н����带 ���� �迭�� ������
 *      
 *      - << java.util.Arrays.equals(password, "1234".toCharArray()) >>���� ��1234���� 
 *        ���ڹ迭�� ��ȯ�Ͽ� equals() �޼ҵ� ����Ͽ� ���� ���� ��
 *        
 *      - equals() �޼ҵ��  java.util ��Ű���� Arrays Ŭ������ Ŭ���� �޼ҵ��, 
 *        �Ű������� 2 ���� �迭�� ������ ������ true, �ƴϸ� false�� ��ȯ
 *        
 *            public static boolean equals(char[] a, char[] a2)  
 *            
 *   3) �־��� ���α׷��� ���캸�� ���α׷��� ������ �ľ��϶�.
 *                 
 *   4) ���α׷��� �����ϰ� ���α׷� ����� Ȯ���϶�.
 */