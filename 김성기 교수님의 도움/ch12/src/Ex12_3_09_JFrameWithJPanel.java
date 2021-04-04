import java.awt.*;
import javax.swing.*;        

/**
 * [ JFrameWithJPanel ]: JFrame ��ü�� JPanel ��ü���� �����ϰ� JPanel ��ü���� ��ġ
 *             
 *   o �����̳� ������Ʈ
 *     - �ٸ� ������Ʈ�� ��ġ�� �� �ִ� ������Ʈ
 *     - �ֻ��� �����̳ʿ� ���� �����̳ʷ� ���е�
 *     - �ֻ��� ������Ʈ: �ٸ� �����̳ʿ� ��ġ���� �ʰ� ��ũ���� ���÷��̵� �� �ִ� �����̳�
 *          JFrame, JDialog
 *          
 *     - ���� �����̳�: �ٸ� �����̳ʿ� ��ġ�Ǿ�߸� ��ũ���� ���÷��̵� �� �ִ� �����̳�
 *          JPanel, JScrollPane
 *       
 *   o �����̳� ������Ʈ���� �Ӽ� ������ ���� �޼ҵ�
 *     - public void setSize(int width, int height) : ���ο� ���� ũ�� ����
 *     - public void setLocation(int x,  int y) : ��ǥ (x, y) ��ġ�� ��ġ
 *     - public void setBounds(int x,  int y, int width, int height) : 
 *                                   ���ο� ���� ũ�� �����Ͽ� ��ǥ (x, y) ��ġ��  ��ġ
 *       
 *     - public void setBackground(Color c) : ������ �־��� �������� ����
 *     - public void setForeground(Color c) : ������� �־��� �������� ����
 *     - public void setFont(Font f) : �� ������Ʈ�� ��Ʈ ����
 *       
 *     - public void setFocusable(boolean b) : ��Ŀ���� ���� �� �ְų� ���� �� 
 *     - public void setEnabled(boolean b) : �Է¿� ���� ������ �� �ְų� ���� ��
 *     - public void setVisible(boolean b) : ���÷��̵ǰ� �ϰų� ������� ��
 *       
 *   o �����̳� ������Ʈ�� ������Ʈ ��ġ�� ���� �޼ҵ�
 *     - public void setLayout(LayoutManager mgr) : ������Ʈ ��ġ�ϴ� ��� ����
 *     - public Component add(Component comp) : ������Ʈ comp �߰��Ͽ� ��ġ
 *     - public void remove(Component comp) : ��ġ�� comp ����
 *     - public Component getComponent(int n) : ��ġ�� n��° ������Ʈ ��ȯ         
 */

// �밳 GUI ���α׷��� JFrame�� Ȯ���ϴ� ���� Ŭ������ JFrame ��ü�� ������
class Ex12_3_09_JFrameWithJPanel extends JFrame {
	JLabel labelInFrame = new JLabel("   JFrame�� ��ġ�� ���̺�");

	JPanel panel  = new JPanel();  // JPanel ��ü �����Ͽ� panel�� ����
	JLabel labelInPanel = new JLabel("   JPanel�� ��ġ�� ���̺�");

	// ��ü ������: �����츦 ���� ����
	Ex12_3_09_JFrameWithJPanel(String title) { 
		super(title);

		this.setLayout(null);         // ������Ʈ ��ġ����� �������� ����
		this.setSize(400, 220);       // ���� 400�ȼ�, ���� 220�ȼ� ũ���
		this.setLocation(420, 220);   // �����츦 (420, 220) ��ġ�� ��ġ
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ���� �ɼ� ����
	}

	// ������Ʈ�� ���� �޼ҵ�
	void setupComponents() {     
		// labelInFrame�� �Ӽ� ����
		labelInFrame.setOpaque(true);               // !! JLabel ���� ���� ���� �ʿ�
		labelInFrame.setBackground(Color.black);    // ���� �����ϱ�
		labelInFrame.setForeground(Color.orange);   // ����� �����ϱ�
		labelInFrame.setSize(160, 20);              // ũ�⸦ ���� 170�ȼ�, ���� 20�ȼ� ũ���
		labelInFrame.setLocation(120, 20);          // (120, 20) ��ġ�� ��ġ

		// panel�� �Ӽ� ����
		panel.setLayout(null);                      // null�̹Ƿ� ������Ʈ���� ��ġ ��ġ �����ϴ� ���� ��ġ
		panel.setBackground(Color.green);           // ���� �����ϱ�
		panel.setForeground(Color.magenta);          // ����� �����ϱ�
		panel.setSize(300, 100);                    // panel ũ�⸦ ���� 300�ȼ�, ���� 100�ȼ� ũ���
		panel.setLocation(50, 60);                  // panel�� (50, 60) ��ġ�� ��ġ

		// labelInPanel�� �Ӽ� ����
		labelInPanel.setOpaque(true);               // !! JLabel ���� ���� ���� �ʿ�
		labelInPanel.setBackground(Color.white);    // ���� �����ϱ�
		labelInPanel.setForeground(Color.red);      // ����� �����ϱ�
		labelInPanel.setSize(160, 20);              // ũ�⸦ ���� 170�ȼ�, ���� 20�ȼ� ũ���
		labelInPanel.setLocation(70, 40);           //  (70, 40) ��ġ�� ��ġ
	} 

	// �����쿡 �ʿ��� ������Ʈ�� �߰��Ͽ� ��ġ�ϴ� �޼ҵ�
	void addComponents() {   
		this.add(labelInFrame);    // frame�� ���̺� �߰�
		this.add(panel);           // frame�� panel �߰�
		panel.add(labelInPanel);   // panel�� ���̺� �߰�
	}

	public static void main(String[] args) {
		Ex12_3_09_JFrameWithJPanel frame = new   
				Ex12_3_09_JFrameWithJPanel("JFrameWithJPanel");  // ������ ���� �� ����

		frame.setupComponents();   // frame�� ��ġ�� ������Ʈ���� �Ӽ� ����
		frame.addComponents();     // frame�� ������Ʈ���� ��ġ  
		frame.setVisible(true);    // frame�� setVisible(true)�� �ϸ� �����찡 ��Ÿ�� 
	}
}

/*
 * [ ���α׷��� ���� �� ���� ]
 *   
 *   1) �� ���α׷��� JFrame�� JLabel�� JPanel�� ��ġ�ϰ� JPanel�� JLabel�� ��ġ�Ѵ�.
 *   
 *   2) �־��� ���α׷��� ���캸�� ���α׷��� ������ �ľ��϶�.
 *                   
 *   3) ���α׷��� �����ϰ� ����� Ȯ���϶�.
 */