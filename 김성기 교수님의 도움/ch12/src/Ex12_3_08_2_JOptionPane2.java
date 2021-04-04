import java.awt.*;
import javax.swing.*;    

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * [ JOptionPane2 ]: JOptionPane�� ������ �����ִ� ����
 *        
 *   o JOptionPane
 *     - ���� �Է��ϰų� ������ ����ϱ� ���� ǥ�� ��ȭ���ڸ� �˾���Ű�� ���� ����� �����ϴ� Ŭ����
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

// JFrame�� Ȯ���ϴ� ���� Ŭ������ ������ �ۼ��ϱ�
class FrameForJOptionPane extends JFrame  {
	JButton showInputBt = new JButton("show input");
	JButton showConfirmBt = new JButton("show Confirm");
	JButton showMessageBt = new JButton("show Message");
	
	JLabel outputLb = new JLabel("LabelForJOptionPane");
	
	// ��ü ������ - �ʿ��� ������Ʈ�� ��ġ�� ������ ����
	FrameForJOptionPane(String title) {
		super(title);  // ���� Ŭ������ JFrame�� ��ü �����ڸ� �ݵ�� ȣ���ؾ� ��
	}

	// �����츦 ���� ���� �޼ҵ�
	void setupFrame() {   
		setLayout(new FlowLayout(FlowLayout.CENTER, 10, 15));  // ������Ʈ ��ġ ����� FlowLayout���� 
		setLocation(600, 500);
		setSize(400, 125);            // ���� 330�ȼ�, ���� 125�ȼ� ũ���
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ���� �ɼ� ����
	}

	// �����쿡 �ʿ��� ������Ʈ�� �߰��Ͽ� ��ġ�ϴ� �޼ҵ�
	void addComponents() {   

		outputLb.setOpaque(true);  // ** JLabel�� ������ �����Ϸ��� true�� �����ؾ� �� **
		outputLb.setBackground(Color.yellow);
		
		add(showInputBt); 
		add(showConfirmBt);
		add(showMessageBt); 		
		add(outputLb); 
	}
	
	// JButton ��ü�� ��ư �̺�Ʈ ������ ��ü�� ��Ͻ�Ű�� �޼ҵ�
	//  JButton ��ü���� ���콺 Ŭ���� �Ǹ�  
	//  ��ϵ� Button_Listener ��ü�� �̺�Ʈ �޼ҵ尡 �ڵ������� ȣ��Ǹ鼭 MouseEvent ��ü�� �Ű������� ���޵�
	void enrolEventListener() {
		// ���� Ŭ������ ����Ͽ� ������ ��ü ����
		MouseAdapter listener = new MouseAdapter() {
			// mousePressed() �޼ҵ�� ���콺 Ŭ���� �Ϸ�� ��  �ڵ������� ȣ��Ǵ� �޼ҵ���
			// �Էµ� ���ڿ��� �����Ͽ� �������� �Ǽ� �µ��̸� �ٸ� �µ��� ��ȯ�Ͽ� ���
			public void mousePressed(MouseEvent e) { 
				Object src = e.getSource();         // �̺�Ʈ �߻��� �ҽ��� ����
			
				if (src == showInputBt) {           // �Է� �̺�Ʈ �߻� �ҽ���  showInputBt ��ư�̸�
					String name = JOptionPane.showInputDialog(null, "�̸��� �Է��Ͻÿ�");  
					outputLb.setText("�̸�: " + name);					
				}
				else if (src == showConfirmBt) {    // �Է� �̺�Ʈ �߻� �ҽ��� showConfirmBt ��ư�̸�
					int yes_or_no = JOptionPane.showConfirmDialog(null, "����� �����Դϱ�?", 
							                                "Confirm��Dialog", JOptionPane.YES_NO_OPTION);  
					if (yes_or_no == JOptionPane.YES_OPTION) 
						outputLb.setText("�����  �����Դϴ�");
					else if (yes_or_no == JOptionPane.NO_OPTION) 
						outputLb.setText("����� �����Դϴ�");
					else
						outputLb.setText("���õ��� �ʾҽ��ϴ�.");
				}
				else if (src == showMessageBt) {    // �Է� �̺�Ʈ �߻� �ҽ��� showMessageBt ��ư�̸�
					JOptionPane.showMessageDialog(null, "JOptionPane.showMessageDialog�� ���", 
							                                  "MessageDialog", JOptionPane.PLAIN_MESSAGE);     
				}
			}
		}; // ������ ��ü ����

		showInputBt.addMouseListener(listener);    // ������ ��ü�� ��Ͻ�Ŵ
		showConfirmBt.addMouseListener(listener);  // ������ ��ü�� ��Ͻ�Ŵ
		showMessageBt.addMouseListener(listener);  // ������ ��ü�� ��Ͻ�Ŵ
	}
}
      
class Ex12_3_08_2_JOptionPane2 {
	public static void main(String[] args) {
		FrameForJOptionPane frame = new FrameForJOptionPane("JOptionPane ����");
		
		frame.setupFrame();          // ������ ����
		frame.addComponents();       // ������Ʈ���� ��ġ    
		frame.enrolEventListener();  // �̺�Ʈ ������ ��ü ���
		frame.setVisible(true);      // frame�� setVisible(true)�� �ϸ� �����찡 ��Ÿ�� 
	}  
}

/*
 * [ ���α׷��� ���� �� ���� ]
 *   
 *   1) �־��� ���α׷��� ���캸�� ���α׷��� ������ �ľ��϶�.
 *      - 3���� ��ư�� ��ġ�� �� Ŭ���� ��ư�� ���� �ٸ� JOptionPane�� �����Ͽ� ����� ������      
 *             
 *   2) ���α׷��� �����ϰ� ����� Ȯ���϶�.     
 */