import java.awt.*;
import javax.swing.*;        

/**
 * [ JFrameOfNullLayout ]: ���� ��ġ������� ��ư���� ��ġ�ϱ�
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
 *     - public void setLocation(int x, int y) : ��ǥ (x, y) ��ġ�� ��ġ
 *     - public void setBounds(int x, int y, int width, int height) : 
 *                               ���ο� ���� ũ�� �����Ͽ� ��ǥ (x, y) ��ġ��  ��ġ
 *       
 *     - public void setBackground(Color c) : ������ �־��� �������� ����
 *     - public void setForeground(Color c) : ������� �־��� �������� ����
 *     - public void setFont(Font f) : ������Ʈ�� ��Ʈ ����
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

class Ex12_3_01_JFrameOfNullLayout {
	public static void main(String[] args) {
	    JFrame frame = new JFrame();
	    frame.setLayout(null);    // ������Ʈ ��ġ ����� ���� ��ġ������� 

	    frame.setSize(250, 150);  // ���� 210�ȼ�, ���� 150�ȼ� ũ���
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ���� �ɼ� ����
	  
	    // ���� ��ġ������� ������Ʈ�� ��ġ�ϱ� ���� ������Ʈ ����, ũ��� ��ġ ����
	    JButton bt1 = new JButton("button-1");         // ��ư ��ü ����
	    bt1.setSize(90, 30); bt1.setLocation(5, 5);    // ��ư ũ��� ��ġ ����
	    
	    JButton bt2 = new JButton("button-2"); 
	    bt2.setSize(90, 30); bt2.setLocation(140, 5); 	    
	    
	    JButton bt3 = new JButton("button-3"); 
	    bt3.setSize(90, 30); bt3.setLocation(25, 40); 
	    
	    JButton bt4 = new JButton("button-4"); 
	    bt4.setSize(90, 30); bt4.setLocation(120, 40); 
	    
	    JButton bt5 = new JButton("button-5"); 
	    bt5.setBounds(105, 75, 90, 30);       
	      
	    // ���� ��ġ��� �����̳ʿ� ������Ʈ ��ġ�ϱ� - ������Ʈ�� ũ��� ��ġ�� �̸� �����Ǿ�� ��
	    frame.add(bt1); frame.add(bt2); frame.add(bt3); frame.add(bt4); frame.add(bt5);

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
 *   1) frame�� ũ�⸦ 130, 300���� �����϶�. �̶����� frame�� setSize() �޼ҵ带 �����Ѵ�.
 *   
 *   2) ��ư���� �� ���ο� �ϳ����� ����ϵ��� �� ��ư�� ���� setLocation() �޼ҵ� ȣ���� �����϶�.
 *      �� ������ ��ư�� setLocation() �޼ҵ��� x ��ġ�� ��� �����ϰ� �ϰ�  
 *      y ��ġ ���� �� ��ư���� �����ϰ� �������Ѿ� �Ѵ�.
 *      
 *   3) ���� ��ġ������� �̸�, ����, �а�, �г��� �Է��ϴ� GUI ���α׷��� �ۼ��϶�.
 *      �̶� ���̺�� �ؽ�Ʈ�ʵ��� ũ��� ��ġ�� ������ �����Ѵ�.
 */
