import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

/**
 * [ JFrameWithJButtons] : 
 *    JButton Ŭ���ϸ� ���̺� �̹��� �����ֱ�
 *    
 *   o 2�� ��ư �� �ϳ� Ŭ���ϸ� �ش� ��ư�� �̹����� ������        
 */

// �밳 GUI ���α׷��� JFrame�� Ȯ���ϴ� ���� Ŭ������ JFrame ��ü�� ������
class Ex12_4_2_JFrameWithJButtons extends JFrame {
	JButton btShowCat = new JButton("����� ����");  // �ؽ�Ʈ ���� ��ư ����
	JButton btShowDog = new JButton("������ ����");  // �ؽ�Ʈ ���� ��ư ����

	ImageIcon iconCat = new ImageIcon("images/cat.jpg");  // �̹��� ������ ����
	JLabel labelCat = new JLabel(iconCat);       // �̹��� ���� ���̺� ����

	ImageIcon dogIcon = new ImageIcon("images/dog.jpg");  // �̹��� ������ ����
	JLabel labelDog = new JLabel("������ �̹���", dogIcon, SwingConstants.CENTER);   // �ؽ�Ʈ�� �̹��� ���� ���̺� ����

	// ��ü ������: �����츦 ���� ����
	Ex12_4_2_JFrameWithJButtons(String title) { 
		super(title);

		this.setSize(450, 300);       // ���� 450�ȼ�, ���� 300�ȼ� ũ���
		this.setLocation(420, 220);   // �����츦 (420, 220) ��ġ�� ��ġ
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ���� �ɼ� ����

		this.setLayout(new GridLayout(2, 2, 10, 10));  // ������Ʈ ��ġ����� grid layout���� 
	}

	// �����쿡 �ʿ��� ������Ʈ�� �߰��Ͽ� ��ġ�ϴ� �޼ҵ�
	void addComponents() {   
		this.add(btShowCat);
		this.add(btShowDog);
		this.add(labelCat);
		this.add(labelDog);
	}

	// �����츦 ��ũ���� ��Ÿ���� �ϰ� �Է��� ��ٸ��� �ϴ� �޼ҵ� 
	void showFrame() {
		labelCat.setVisible(false); // setVisible(false)�� ����� �̹��� ��Ÿ���� �ʰ� ��
		labelDog.setVisible(false); // setVisible(false)�� ������ �̹��� ��Ÿ���� �ʰ� ��

		this.setVisible(true);      // �� ��ü�� setVisible(true)�� �ϸ� �����찡 ��Ÿ�� 
	}

	// JButton ��ü�� ��ư �̺�Ʈ ������ ��ü�� ��Ͻ�Ű�� �޼ҵ�
	//    JButton ��ü���� ���콺 Ŭ���� �Ǹ�  
	//    ��ϵ� Button_Listener ��ü�� �̺�Ʈ �޼ҵ尡 �ڵ������� ȣ��Ǹ鼭 MouseEvent ��ü�� �Ű������� ���޵�
	void enrolEventListener() {
		// �͸� Ŭ������ ����Ͽ� ������ ��ü ����
		MouseAdapter listener = new MouseAdapter() {
			// mousePressed() �޼ҵ�� ���콺 Ŭ���� �Ϸ�� ��  �ڵ������� ȣ��Ǵ� �޼ҵ���
			// �Էµ� ���ڿ��� �����Ͽ� �������� �Ǽ� �µ��̸� �ٸ� �µ��� ��ȯ�Ͽ� ���
			public void mousePressed(MouseEvent e) { 
				Object src = e.getSource();       // �̺�Ʈ �߻��� �ҽ��� ����
				if (src == btShowCat) {           // �Է� �̺�Ʈ �߻� �ҽ���btShowCat ��ư�̸�
					labelCat.setVisible(true);    //   labelCat ���̺��� ���̰� ��
				}
				else if (src == btShowDog) {      // �Է� �̺�Ʈ �߻� �ҽ��� btShowDog ��ư�̸�
					labelDog.setVisible(true);    //   labelDog ���̺��� ���̰� ��
				}
			}
		}; // ������ ��ü ����

		btShowCat.addMouseListener(listener);  // ������ ��ü�� ��Ͻ�Ŵ
		btShowDog.addMouseListener(listener);  // ������ ��ü�� ��Ͻ�Ŵ
	}
	
	void enrolEventListener2() {
		Button_Listener listener = new Button_Listener(); // ������ ��ü ����
		btShowCat.addMouseListener(listener);  // ������ ��ü�� ��Ͻ�Ŵ
		btShowDog.addMouseListener(listener);  // ������ ��ü�� ��Ͻ�Ŵ
	}

	// MouseAdapter�� Ȯ���ϴ� ��ư �̺�Ʈ ������ Ŭ����(���� Ŭ����)
	//  �� Ŭ������ MouseAdapter�� mousePressed() �޼ҵ带 �������̵���
	//  ���콺 Ŭ���� �Ϸ�� �� �ڵ������� ȣ��Ǵ�  mousePressed()�� �̿��Ͽ� �Է�ó��
	class Button_Listener extends MouseAdapter {
		// mousePressed() �޼ҵ�� ���콺 Ŭ���� �Ϸ�� ��  �ڵ������� ȣ��Ǵ� �޼ҵ���
		// �Էµ� ���ڿ��� �����Ͽ� �������� �Ǽ� �µ��̸� �ٸ� �µ��� ��ȯ�Ͽ� ���
		public void mousePressed(MouseEvent e) { 
			Object src = e.getSource();       // �̺�Ʈ �߻��� �ҽ��� ����
			if (src == btShowCat) {           // �Է� �̺�Ʈ �߻� �ҽ���btShowCat ��ư�̸�
				labelCat.setVisible(true);    //   labelCat ���̺��� ���̰� ��
			}
			else if (src == btShowDog) {      // �Է� �̺�Ʈ �߻� �ҽ��� btShowDog ��ư�̸�
				labelDog.setVisible(true);    //   labelDog ���̺��� ���̰� ��
			}
		}
	}

	public static void main(String[] args) {
		Ex12_4_2_JFrameWithJButtons frame =  
				 new Ex12_4_2_JFrameWithJButtons("JFrameWithJButtons");  // ������ ���� �� ����
		
		frame.addComponents();      // frame�� ������Ʈ���� ��ġ  
		frame.enrolEventListener(); // ��ư�� ������ ��Ͻ�Ŵ
		frame.showFrame();          // frame�� ��Ÿ���� �ϰ� �Է��� ��ٸ�
	}
}

/*
 * [ ���α׷��� ���� �� ���� ]
 *   
 *   1) �־��� ���α׷��� ���캸�� ���α׷��� ������ �ľ��϶�.
 *                 
 *   2) ���α׷��� �����ϰ� ���α׷� ����� Ȯ���϶�.
 *   
 *   3) �� ���α׷��� �̺�Ʈ ó���� ���� ������ Ŭ������ 2�� �ۼ��Ǿ� �ִ�. 
 *      main()����  << frame.enrolEventListener(); >>��
 *      << frame.enrolEventListener2(); >>�� �����ص� �̺�Ʈ ó���ȴ�.
 */
