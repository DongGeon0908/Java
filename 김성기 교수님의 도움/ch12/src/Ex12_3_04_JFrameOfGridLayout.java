import java.awt.*;
import javax.swing.*;        

/**
 * [ JFrameOfGridLayout ]: �ڵ� ��ġ����� grid layout���� JFrame�� ��ư���� ��ġ�ϱ�
 *             
 *    o �����̳� ������Ʈ
 *       - �ٸ� ������Ʈ�� ��ġ�� �� �ִ� ������Ʈ
 *       - �ֻ��� �����̳ʿ� ���� �����̳ʷ� ���е�
 *       - �ֻ��� ������Ʈ: �ٸ� �����̳ʿ� ��ġ���� �ʰ� ��ũ���� ���÷��̵� �� �ִ� �����̳�
 *          JFrame, JDialog
 *          
 *       - ���� �����̳�: �ٸ� �����̳ʿ� ��ġ�Ǿ�߸� ��ũ���� ���÷��̵� �� �ִ� �����̳�
 *          JPanel, JScrollPane
 *       
 *    o �����̳� ������Ʈ���� �Ӽ� ������ ���� �޼ҵ�
 *     - public void setSize(int width, int height) : ���ο� ���� ũ�� ����
 *     - public void setLocation(int x, int y) : ��ǥ (x, y) ��ġ�� ��ġ
 *     - public void setBounds(int x, int y, int width, int height) : 
 *                               ���ο� ���� ũ�� �����Ͽ� ��ǥ (x, y) ��ġ��  ��ġ
 *       
 *     - public void setBackground(Color c) : ������ �־��� �������� ����
 *     - public void setForeground(Color c) : ������� �־��� �������� ����
 *     - public void setFont(Font f) : ������Ʈ�� ��Ʈ�� ����
 *      
 *     - public void setFocusable(boolean b) : ��Ŀ���� ���� �� �ְų� ���� �� 
 *     - public void setEnabled(boolean b) : �Է¿� ���� ������ �� �ְų� ���� ��
 *     - public void setVisible(boolean b) : ���÷��̵ǰ� �ϰų� ������� ��
 *       
 *   o �����̳� ������Ʈ�� ������Ʈ ��ġ�� ���� �޼ҵ�
 *     - public void setLayout(LayoutManager mgr) : ������Ʈ ��ġ�ϴ� ��� ����
 *     - public Component add(Component comp) : ������Ʈ comp �߰��Ͽ� ��ġ
 *     - public void remove(Component comp) : ��ġ�� comp ����
 *     - public Component getComponent(int n) : ��ġ�� n��°�� ������Ʈ ��ȯ
 *       
 *   o �����̳� ������Ʈ�� ��ġ��� �����ϱ�
 *     - setLayout(null) : ���� ��ġ��� - ������Ʈ ũ��� ��ġ�� ���� �����Ͽ� ��ġ
 *     - setLayout( new FlowLayout() ) : �ڵ� ��ġ��� - ���ʿ��� ������, ������ �Ʒ��� ���ʷ� ��ġ
 *     - setLayout( new BorderLayout() ) : �ڵ� ��ġ��� - ������Ʈ���� ��, ��, ��, ��, �߾� �� 5�� ������ ��ġ
 *     - setLayout( new GridLayout() ) : �ڵ� ��ġ��� - ��ġ ������ ������ ũ���� 2���� �׸���� ������ 
 *                                       ���ʿ��� ������, ������ �Ʒ��� �ڵ� ��ġ
 *     - setLayout( new CardLayout() ) : �ڵ� ��ġ��� - ������Ʈ���� ī�� ���� ���·� �ڵ� ��ġ, 
 *                                       �ϳ��� ������Ʈ�� ��Ÿ���� ��   
 */

class Ex12_3_04_JFrameOfGridLayout {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setLayout(new GridLayout(3, 2) ); // ��ġ���: 3*2 ����� grid layout

		frame.setSize(200, 100);            // ���� 150�ȼ�, ���� 100�ȼ� ũ���
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ���� �ɼ� ����

		// grid layout �����̳ʿ� ������Ʈ ��ġ 
		frame.add(new JLabel("    �̸�:"));   frame.add(new JTextField(10));  
		frame.add(new JLabel("    ����:"));   frame.add(new JTextField(10));  
		frame.add(new JLabel("    ����ġ:"));  frame.add(new JTextField(10));  
	
		frame.setVisible(true);   // frame�� setVisible(true)�� �ϸ� �����찡 ��Ÿ��    
	}
}

/*
 * [ ���α׷��� ���� �� ���� ]
 *   
 *   1) �־��� ���α׷��� ���캸�� ���α׷��� ������ �ľ��϶�.
 *                  
 *   2) ���α׷��� �����ϰ� ����� Ȯ���϶�.
 *   
 *   3) ���콺�� �������� ������ �Ʒ��� �巡���Ͽ� �������� ũ�⸦ �����ϸ� ��ġ�� ������Ʈ�� ��ġ�� 
 *      ��� �Ǵ°��� Ȯ���϶�.
 *  
 *  
 * [ �ǽ����� ]
 *
 *   1) frame�� ũ�⸦ 230, 300���� �����϶�. �̶����� frame�� setSize() �޼ҵ带 �����Ѵ�.
 *         
 *   2) �� ���α׷��� ������� 3�� ���̺�� 3�� �ؽ�Ʈ�ʵ尡 �� ���� 3, �� ���� 2�� �׸��忡 ��ġ�Ǿ� �ִ�. 
 *      �� ���� 3, �� ���� 3, ���� ���� 10�� ���� ���� 10�� grid layout �����ϱ� ���Ͽ�
 *      << frame.setLayout(new GridLayout(3, 2)); >> �޼ҵ� ȣ���� �����϶�.  
 *      
 *      �� ����, �� ����, ���� ����, ���� ������ �����ϱ� ���ؼ��� GridLayout Ŭ������ 
 *      ��ü ������ GridLayout(int rows, int cols, int hGap, int vGap)�� 
 *      rows, cols, hGap, vGap �Ű������� ������ ������ �����Ѵ�.
 */
