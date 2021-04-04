import java.awt.*;
import javax.swing.*;        

/**
 * [ JFrameOfFlowLayout ]: �ڵ� ��ġ����� flow layout���� JFrame�� ��ư���� ��ġ�ϱ�
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

class Ex12_3_02_JFrameOfFlowLayout {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setLayout(new FlowLayout());  // ������Ʈ ��ġ����� flow layout���� 

		frame.setSize(230, 144);  // ���� 210�ȼ�, ���� 150�ȼ� ũ���
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ���� �ɼ� ����

		// flow layout �����̳ʿ� ������Ʈ ��ġ�ϱ� - ������Ʈ�� ũ��, ��ġ ������ �ʿ� ����
		frame.add(new JButton("button-1"));
		frame.add(new JButton("button-2"));  
		frame.add(new JButton("button-3"));
		frame.add(new JButton("button-4"));    
		frame.add(new JButton("button-5"));    

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
 *   2) �� ���α׷��� 5���� ��ư�� �����ϰ� �̸� frame�� ��ġ�Ѵ�.
 *      3���� ��ư�� �߰��� �����Ͽ� frame�� ��ġ�ϵ��� ���α׷��� �����϶�.
 *      
 *   3) 20���� ��ư�� �����Ͽ� frame�� ��ġ�ϵ��� ���α׷��� �����ϱ� ���ؼ��� 20���� ��ư�� �����ϰ� 
 *      20�� add() �޼ҵ带 ȣ���ؾ��Ѵ�.
 *       
 *      �� �۾��� �迭�� for ���� ����Ͽ� ���� �����ϰ� �ۼ��� �� �ִ�.
 *      �迭�� for ���� ����Ͽ� 20���� ��ư�� frame�� ��ġ�ϵ��� ���α׷��� �����϶�.
 *      
 *   4) ��ư���� ���� ����, ���� ���� 6, ���� ���� 7�� flow layout �����ϱ� ���Ͽ�
 *      << frame.setLayout(new FlowLayout()); >> �޼ҵ� ȣ���� �����϶�.  
 *      
 *      ���� ������ ���ؼ���  FlowLayout Ŭ������ ��ü ������  FlowLayout(int align, int hGap, int vGap)���� 
 *      align �Ű������� FlowLayout.LEFT�� �����Ѵ�.
 *      ���� ���� ����� ���� ������ �����ϱ� ���ؼ���  hGap�� vGap �Ű������� ������ �ȼ� ���� �����Ѵ�.
 *      
 *   5) ��ư���� ������ ����, ���� ���� 10, ���� ���� 10���� flow layout �����ϱ� ���Ͽ�
 *      << frame.setLayout(new FlowLayout()); >> �޼ҵ� ȣ���� �����϶�. 
 *      
 *      ������ ������ ���ؼ��� FlowLayout Ŭ������ ��ü �����ڿ���  align �Ű������� FlowLayout.RIGHT�� �����Ѵ�.
 *      
 *   6) Flow Layout���� �̸�, ����, �а�, �г��� �Է��ϴ� GUI ���α׷��� �ۼ��϶�. 
 *      �̶�, ���� ����� ���� ������ 5�� �����Ѵ�.
 */
