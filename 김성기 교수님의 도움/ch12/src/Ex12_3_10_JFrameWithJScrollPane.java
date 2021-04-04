import java.awt.*;
import javax.swing.*;        

/**
 * [ JFrameWithJScrollPane]: JFrame ��ü�� JScrollPane ��ü�� �����ϰ� JScrollPane ��ü�� JFrame ��ü�� ��ġ
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
 *     - public void setSize(int width, int height) : ���ο� ���� ũ�⸦ ����
 *     - public void setLocation(int x,  int y) : ��ǥ (x, y) ��ġ�� ��ġ
 *     - public void setBounds(int x,  int y, int width, int height) : 
 *                               ���ο� ���� ũ�� �����Ͽ� ��ǥ (x, y) ��ġ��  ��ġ
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
 *      
 *   o JTextArea
 *     - ���� ������ ���ڿ��� �Է��ϰ� ����� �� �ִ� ������Ʈ
 *     - ��ü ������
 *         JTextArea(int row, int column) : �־��� ��� ���� ������ ���ڿ��� �Է��ϴ� JTextArea ��ü ����
 *         JTextArea(String initialText, int row, int column): �־��� �ʱ� �ؽ�Ʈ, ��� ���� ���� JTextArea ��ü ����
 *         
 *   o JScrollPane
 *     - ���� ũ���� ������Ʈ�� ��ġ�Ͽ� ��ġ�� ������Ʈ�� Ŀ���� �ڵ������� ��ũ�� �ٸ� �����Ͽ� ��ũ�Ѹ��ǰ� �ϴ� �����̳�
 *     - ��ü ������
 *         JScrollPane(Component comp) :  ������Ʈ comp�� ��ġ�ϴ� JScrollPane ��ü ����   
 */

// JFrame�� Ȯ���ϴ� ���� Ŭ����
class Ex12_3_10_JFrameWithJScrollPane extends JFrame {
    
    JTextArea ta = new JTextArea("ȫ�浿\n�ڹ���\n�̸���\n", 4, 8); // ���� ���ο� ���� �ؽ�Ʈ�� �Է��� �� �ִ� ������Ʈ
    JScrollPane scrollPane = new JScrollPane(ta);  // ta ������Ʈ�� ��ġ�ϴ� JScrollPane ��ü ����

    // ��ü ������: �����츦 ���� ����
	Ex12_3_10_JFrameWithJScrollPane(String title) { 
		super(title);
	    this.setLayout(null);         // ��ġ����� ���� ��ġ��
		this.setLocation(500, 300);   // �����츦 (500, 300) ��ġ�� ��ġ
		this.setSize(320, 200);       // ���� 320�ȼ�, ���� 20�ȼ� ũ���		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ���� �ɼ� ����
	}

	// ������Ʈ�� ���� �޼ҵ�
	void setupComponents() {     				
		// ta�� �Ӽ� ����
		ta.setBackground(Color.yellow);   // ������� �̿��Ͽ� ���� �����ϱ�
		ta.setForeground(Color.blue);     // ������� �̿��Ͽ� ����� �����ϱ�

		// scrollPane�� �Ӽ� ����	
		scrollPane.setLocation(100, 30);  // (100, 30)�� ��ġ�� ��ġ
		scrollPane.setSize(100, 100);     // ���� 100�ȼ�, ���� 100�ȼ� ũ���
	}

	// �����쿡 �ʿ��� ������Ʈ�� �߰��Ͽ� ��ġ�ϴ� �޼ҵ�
	void addComponents() {   
		this.add(scrollPane);            // JFrame�� scrollPane ��ġ
	}

	public static void main(String[] args) {
		Ex12_3_10_JFrameWithJScrollPane frame = new Ex12_3_10_JFrameWithJScrollPane("JFrameWithScrollPane");  // ������ ���� �� ����

		frame.setupComponents();  // frame�� ��ġ�� ������Ʈ���� �Ӽ� ����
		frame.addComponents();    // frame�� ������Ʈ���� ��ġ  
		frame.setVisible(true);   // frame�� setVisible(true)�� �ϸ� �����찡 ��Ÿ�� 
	}
}

/*
 * [ ���α׷��� ���� �� ���� ]
 *   
 *   1) �־��� ���α׷��� ���캸�� ���α׷��� ������ �ľ��϶�.
 *                 
 *   2) ���α׷��� �����ϰ� ���� ���ο� ��ó �̸��� �Է��ϸ鼭
 *      ȭ���� ��� ���ϴ°��� Ȯ���϶�.  
 */
