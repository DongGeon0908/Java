import java.awt.*;
import javax.swing.*;        

/**
 * [ JFrameOfCardLayout ]: �ڵ� ��ġ����� card layout���� JFrame�� ��ư�� ��ġ�ϱ�
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

class Ex12_3_05_JFrameOfCardLayout {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		CardLayout cardlo = new CardLayout(30, 20);  // ���� �� ���� ������ 30��  card layout ��ü ����

		frame.setLayout(cardlo);  //  ��ġ���: card layout
		frame.setSize(210, 150);  // ���� 210�ȼ�, ���� 150�ȼ� ũ���
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ���� �ɼ� ����

		// card layout �����̳ʿ� ��ư�� ��ġ�ϱ� - ��ư�� ũ��, ��ġ ������ �ʿ� ����
		int noButtons = 20;
		JButton[] bts = new JButton[noButtons];    // ��ư ������ �迭 ���� �� ����
  
		for (int i = 0; i < noButtons; i++) {  
			bts[i] = new JButton("button-" + (i+1));  // ��ư �����Ͽ� ��ư �迭�� ����
			frame.add(bts[i]);                        // ��ư�� frame�� ��ġ
		}     
		
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
 *   4) card layout�� ��� ó�� ��ġ�� ������Ʈ�� ���÷��̵ǰ� �ٸ� ������Ʈ�� ��������.
 *      �ٸ� ������Ʈ�� ���÷����Ϸ��� ó�� ��ġ�� bts[0]�� setVisible(false)�� �ϰ� 
 *      ���÷����� ������Ʈ�� setVisible(true)�� �ϸ� �ȴ�.      
 *      
 *      main() �޼ҵ��� ������ ���� << frame.setVisible(true); >> ���� ���ο� ���� �ڵ� �߰��ϰ� ��� Ȯ���϶�.
 *      
         for (int i = 0; i < noButtons - 1; i++) {
            try { Thread.sleep(1000); } catch(Exception e ) {} // ���α׷� ������ 1�� ���� ������Ŵ

            bts[i].setVisible(false);  // ���� ��ư�� ������ �ʰ� ��
            bts[i+1].setVisible(true); // ���� ��ư�� ���̰� ��
         }
          
 *     
 */
