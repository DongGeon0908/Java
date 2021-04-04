import java.awt.*;
import javax.swing.*;        

/**
 * [ JFrameOfBorderLayout ]: �ڵ� ��ġ����� border layout���� JFrame�� ��ư���� ��ġ�ϱ�
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
 *                                ���ο� ���� ũ�� �����Ͽ� ��ǥ (x, y) ��ġ��  ��ġ
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

class Ex12_3_03_JFrameOfBorderLayout {
	public static void main(String[] args) {
	    JFrame frame = new JFrame();
	    frame.setLayout(new BorderLayout());  // ��ġ���: border layout, ���� ����: 0, ���� ����: 0 

	    frame.setSize(270, 130);            // ���� 270�ȼ�, ���� 130�ȼ� ũ���
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ���� �ɼ� ����
	    
	    // border layout �����̳ʿ� ������Ʈ ��ġ - ��ġ�� ������ �Ű������� ǥ����
	    frame.add(new JButton("button-1"), BorderLayout.NORTH);   
	    frame.add(new JButton("button-2"), BorderLayout.SOUTH);  
	    frame.add(new JButton("button-3"), BorderLayout.EAST);   
	    frame.add(new JButton("button-4"), BorderLayout.WEST);    
	    frame.add(new JButton("button-5"), BorderLayout.CENTER);     

	    frame.setVisible(true);   // frame�� setVisible(true)�� �ϸ� �����찡 ��Ÿ��        }
	}
}


/*
 * [ ���α׷��� ���� �� ���� ]
 *   
 *   1) �־��� ���α׷��� ���캸�� ���α׷��� ������ �ľ��϶�.
 *                  
 *   2) ���α׷��� �����ϰ� ����� Ȯ���϶�.
 *   
 *   3) ���콺�� �������� ������ �Ʒ��� �巡���Ͽ� �������� ũ�⸦ �����ϸ� ��ġ�� ������Ʈ�� ��ġ�� ��� �Ǵ°��� Ȯ���϶�.
 *  
 *  
 * [ �ǽ����� ]
 *
 *   1) frame�� ũ�⸦ 230, 300���� �����϶�. �̶����� frame�� setSize() �޼ҵ带 �����Ѵ�.
 *         
 *   2) �� ���α׷��� ������� 5�� ��ư���� ��� �پ� �ִ�. �̴� ���� ����� ���� ������ ������ �־����� �ʾұ� �����̴�.
 *      ���� ����� ���� ���� 5�� border layout �����ϱ� ���Ͽ�
 *      << frame.setLayout(new BorderLayout()); >> �޼ҵ� ȣ���� �����϶�.  
 *      
 *      ���� ����� ���� ������ �����ϱ� ���ؼ��� BorderLayout Ŭ������ 
 *      ��ü ������ BorderLayout(int hGap, int vGap)�� hGap�� vGap �Ű������� ������ �ȼ� ���� �����Ѵ�.      
 */
