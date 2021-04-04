import java.awt.*;
import javax.swing.*;        

/**
 * [ JFrameWithJLabels]: JLabel ��ü���� JFrame ��ü�� ��ġ
 *   
 *   o JLabel
 *     - ȭ�鿡 ���ڿ� �Ǵ� �̹����� ȭ�鿡 ����Ͽ� �ʿ��� ���� �����ϱ� ���� ������Ʈ
 *   
 *   o JLabel ��ü ������
 *     - �ؽ�Ʈ ���� ���̺�, �̹��� ���� ���̺�, �̹����� �ؽ�Ʈ ��� ���� ���̺�  ������ �� �ְ� ��
 *     
 *       public JLabel(String text): �־��� �ؽ�Ʈ ���� ���̺� ���� 
 *       public JLabel(Icon image): �־��� �̹��� ���� ���̺� ���� 
 *       public JLabel(String text,Icon image, int horizontalAlignment):
 *           �־��� ���� ������ �ؽ�Ʈ�� �̹��� ���� ���̺�  ���� 
 *           (���� ������ SwingConstants Ŭ������ ��� LEFT, CENTER, RIGHT, LEADING, TRAILING �� �ϳ� ���)        
 */

// �밳 GUI ���α׷��� JFrame�� Ȯ���ϴ� ���� Ŭ������ JFrame ��ü�� ������
class Ex12_4_1_JFrameWithJLabels extends JFrame {
	JLabel labelCatText = new JLabel("�����");  // �ؽ�Ʈ ���� ���̺� ����

	ImageIcon iconCat = new ImageIcon("images/cat.jpg");  // �̹��� ������ ����
	JLabel labelCatImage = new JLabel(iconCat);    // �̹��� ���� ���̺� ����

	ImageIcon iconDog = new ImageIcon("images/dog.jpg");  // �̹��� ������ ����
	JLabel labelDog = new JLabel("������ �̹���", iconDog, SwingConstants.CENTER); // �ؽ�Ʈ�� �̹��� ���� ���̺� ����

	// ��ü ������: �����츦 ���� ����
	Ex12_4_1_JFrameWithJLabels(String title) { 
		super(title);

		this.setSize(450, 300);      // ���� 450�ȼ�, ���� 300�ȼ� ũ���
		this.setLocation(420, 220);  // �����츦 (420, 220) ��ġ�� ��ġ
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      // ���� �ɼ� ����
		
//		this.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));  // ������Ʈ ��ġ����� flow layout���� 
		this.setLayout(new GridLayout(2, 2));  // ������Ʈ ��ġ����� grid layout���� 
	}
	
	// �����쿡 �ʿ��� ������Ʈ�� �߰��Ͽ� ��ġ�ϴ� �޼ҵ�
	void addComponents() {   
		this.add(labelCatText);
		this.add(labelCatImage);
		this.add(labelDog);
	}

	public static void main(String[] args) {
		Ex12_4_1_JFrameWithJLabels frame = new   
				Ex12_4_1_JFrameWithJLabels("JFrameWithJLabels");  // ������ ���� �� ����

		frame.addComponents();    // frame�� ������Ʈ���� ��ġ  
		frame.setVisible(true);   // frame�� setVisible(true)�� �ϸ� �����찡 ��Ÿ�� 
	}
}

/*
 * [ ���α׷��� ���� �� ���� ]
 *   
 *   1) �־��� ���α׷��� ���캸�� ���α׷��� ������ �ľ��϶�.
 *   
 *   2) ���α׷��� �����ϰ� ���α׷� ����� Ȯ���϶�.                
 *                 
 *   3) ���̺��� �ؽ�Ʈ�� �����Ͽ� ���α׷� ����� Ȯ���϶�.  
 */
