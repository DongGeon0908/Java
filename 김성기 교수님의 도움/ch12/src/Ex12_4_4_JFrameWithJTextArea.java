import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

/**
 * [ JFrameWithJTextArea]: 
 *     JTextArea�� JFrame ��ü�� ��ġ�ϰ� 1���� 1000 ���� �Ҽ� ��� 
 *     
 *   o JTextArea 
 *     - ���� ������ ���ڿ� �Է��ϴ� ������Ʈ
 *     - TextArea�� �����Ͱ� �������� ũ�Ⱑ ���ϴ� ������Ʈ
 *     - JScrollPane�� ��ġ�ϸ� ũ�Ⱑ Ŀ���� ���� ����            
 */

// �밳 GUI ���α׷��� JFrame�� Ȯ���ϴ� ���� Ŭ������ JFrame ��ü�� ������
class Ex12_4_4_JFrameWithJTextArea extends JFrame {
	JTextArea ta = new JTextArea(""); 
	JScrollPane scrollPane = new JScrollPane(ta);  // ta�� ��ġ�ϴ� JScrollPane ��ü

	Ex12_4_4_JFrameWithJTextArea(String title) {   // ��ü ������: ������ ����
		super(title);
		this.setLayout(null);        // ��ġ����� ���� ��ġ��
		this.setLocation(500, 300);  // �����츦 (500, 300) ��ġ�� ��ġ
		this.setSize(500, 350);      // ���� 500�ȼ�, ���� 350�ȼ� ũ���    
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ���� �ɼ� ����
	}

	void setupComponents() {   // ������Ʈ�� ���� �޼ҵ�              
		// ta�� �Ӽ� ����
		ta.setBackground(Color.yellow);  // ����� �̿��Ͽ� ���� �����ϱ�
		ta.setForeground(Color.blue);    // ����� �̿��Ͽ� ����� �����ϱ�
		
		// scrollPane�� �Ӽ� ����  
		scrollPane.setLocation(100, 50); // (100, 30)�� ��ġ�� ��ġ
		scrollPane.setSize(300, 200);    // ���� 300�ȼ�, ���� 200�ȼ� ũ���
	}

	void addComponents() {   
		this.add(scrollPane);   // JFrame�� scrollPane ��ġ
	} 

	// from���� to������ ���� �� �Ҽ��� ���Ͽ� �ؽ�Ʈ ������ �����ϴ� �޼ҵ�
	void addPrimeNo(int from, int to, int cntInLine) {
		ta.setText("    ** " + from +"���� " + to + "������ �Ҽ��� **\n\n");;
		
		int cnt = 0;
		for (int i = from; i <= to; i++) {
			if (isPrimeNo(i)) {  // �Ҽ��̸�   �ؽ�Ʈ ������ ���� �߰�
				ta.append("  " + i);

				if (++cnt % cntInLine == 0)   // cntInLine���� �� �ٿ� �����
					ta.append("\n");
			}
		}
	}
	
	static boolean isPrimeNo(int n) {  // �־��� n�� �Ҽ����� �Ǻ��ϴ� �޼ҵ�
		if (n < 2)
			return false;
		
		for  (int i = 2; i < n; i++)
			if (n % i == 0)
				return false;
		return true;
	}

	public static void main(String[] args) {
		Ex12_4_4_JFrameWithJTextArea frame =          // ������ ���� �� ����
				new Ex12_4_4_JFrameWithJTextArea("JFrameWithJTextArea");  
		
		frame.setupComponents();        // frame�� ��ġ�� ������Ʈ���� �Ӽ� ����
		frame.addComponents();          // frame�� ������Ʈ���� ��ġ  
		frame.addPrimeNo(1, 1000, 10);  // 1���� 1000 ���� �Ҽ���  �ؽ�Ʈ ������ �� ���ο� 10���� �����ϴ� �޼ҵ� ȣ��
	    frame.setVisible(true);         // frame�� setVisible(true)�� �ϸ� �����찡 ��Ÿ��
	}
}

/*
 * [ ���α׷��� ���� �� ���� ]
 *   
 *   1) �� ���α׷���  �ؽ�Ʈ ������ JScrollPane�� ��ġ�ϰ� �ؽ�Ʈ ������ 1���� 1000������ �Ҽ���  �� ���ο� 15���� �����Ѵ�.
 *   
 *   2) JScrollPane�� JFrame�� ��ġ�� �� JFrame�� ȭ�鿡 ���÷��̽�Ű�� �ؽ�Ʈ ������ ���÷��̵ȴ�. 
 *      
 *   3) �־��� ���α׷��� ���캸�� ���α׷��� ������ �ľ��϶�.
 *                 
 *   4) ���α׷��� �����ϰ� ���α׷� ����� Ȯ���϶�.
 *   
 */
