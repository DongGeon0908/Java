import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * [ Subtracter_UsingInnerClass ]: ������ Ŭ������ ���� Ŭ������ �ۼ��ϱ�
 * 
 *   o ������ Ŭ����
 *     - Ư�� �̺�Ʈ�� ó���ϱ� ���� �ۼ��ϴ� Ŭ����
 *     - Ư�� �̺�Ʈ�� ���� ������ �������̽��� �����ϴ� ���� Ŭ������ �ۼ��ؾ� ��
 *     - ������ �������̽��� abstract �޼ҵ��� �̺�Ʈ ó�� �޼ҵ�� ��� �����ؾ� ��
 *     - ���� �̺�Ʈ ó�� �޼ҵ� �� �ʿ��� �޼ҵ常 �����ϰ� ���ʿ��� �޼ҵ�� ���� �޼ҵ�� �ۼ�
 * 
 *   o ������ Ŭ���� �ۼ� ����
 *     1) ������ Ŭ������ �ۼ��ϱ�
 *        - ������ Ŭ������ JFrame Ŭ������ �и��� Ŭ������ �ۼ�
 *        - JFrame ��ü�� ������Ʈ�� ������ ��ü���� ����Ϸ��� JFrame ��ü�� ������ ��ü�� �����ؾ� ��
 *        - JFrame ��ü�� ���޹޾� �����ϴ� ������ Ŭ������ ��ü ������ �ۼ��� �ʿ�
 *  
 *     2) ���� Ŭ����(inner class)�� �ۼ��ϱ�
 *        - ������ Ŭ������ JFrame Ŭ���� ���ο��� �ۼ�
 *        - ������ Ŭ�������� JFrame Ŭ������ ������Ʈ�� ������� ������ �� �־� ���� 
 *        - ������ Ŭ������ ��ü ������ �ۼ��� �ʿ� ����
 * 
 *     3) �͸� Ŭ����(anonymous class)�� �ۼ��ϱ�
 *        - ������ Ŭ������ JFrame Ŭ���� ���ο��� ���� Ŭ���� �����ϸ鼭 �ٷ� ��ü ����
 *        - ������ Ŭ������ ��ü�� �ϳ��� ���� ������
 *             new ����_Ŭ����() { ����_Ŭ������ ������ }
 *             new ����_�������̽�() { ����_�������̽��� ������ }
 *                
 *        - ������ Ŭ������ ��ü ������ �ۼ��� �ʿ� ����
 *        - ���α׷��� ���������� �����ϱⰡ �����Ƿ� �ʺ��ڴ� ������� �� ��
 */

public class Ex12_5_2_2_Subtracter_UsingInnerClass {

	public static void main(String [] args) {
		new SubtracterFrame_UsingInnerListener();
	}
} 

class SubtracterFrame_UsingInnerListener extends JFrame {
	JTextField tf1, tf2, tfRes;  // ���� �ǿ�����, ������ �ǿ�����, ����� ������ �ؽ�Ʈ �ʵ�
	JButton btnSub;              // �����ڸ� ��Ÿ���� ��ư

	// ��ü ������: ������Ʈ ��ġ �� ����, �̺�Ʈ ��ü ���, ȭ�鿡 ���̱� �� ����
	SubtracterFrame_UsingInnerListener() {
		setTitle("Subtracter(���� ������ Ŭ���� �̿�)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());

		add(tf1 = new JTextField("1234", 10)); // �ʱⰪ "1234", ũ�� 10�� �ؽ�Ʈ�ʵ�
		add(btnSub = new JButton(" - "));

		add(tf2 = new JTextField("2345", 10)); // �ʱⰪ "2345", ũ�� 10�� �ؽ�Ʈ�ʵ�
		add(new JLabel(" = "));
		add(tfRes = new JTextField("", 10));   // �ʱⰪ "", ũ�� 10�� �ؽ�Ʈ�ʵ�

		ActionListener listener = new MyActionListener();  // ���� Ŭ������ �ۼ��� ������ ��ü ����
		btnSub.addActionListener(listener);                // ��ư�� ������ ��ü ���

		setBounds(500, 400, 450,100);		
		
		setVisible(true);    // ������ JFrame ��ü�� ȭ�鿡 ��Ÿ���� ��
	}

	// ActionListener �����ϴ�  Action ������ Ŭ������ ���� Ŭ������ �ۼ�
	//   Action �������� �̺�Ʈ ó�� �޼ҵ��  actionPerformed() �ϳ���
	class MyActionListener implements ActionListener {

		// ��ư�� Ŭ���ϸ� ȣ��Ǵ� �̺�Ʈ ó�� �޼ҵ带 ������
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton) e.getSource();// ���õ� ��ư ��ü ������

			try {
				// �ܺ� Ŭ������ �ʵ�  tf1, tf2, tfRes �̿��Ͽ� ��� ���
				int op1 = Integer.parseInt(tf1.getText());   // ���� Ŭ�������� �ܺ� Ŭ������ �ʵ� tf1 ���� ����
				int op2 = Integer.parseInt(tf2.getText());   // ���� Ŭ�������� �ܺ� Ŭ������ �ʵ� tf2 ���� ����

				tfRes.setText(" " + (op1 - op2));            // ���� Ŭ�������� �ܺ� Ŭ������ �ʵ� tfRes ���� ����
			}
			catch(Exception ex) {
				JOptionPane.showMessageDialog(null, " Error - " + ex.getMessage(), 
						"���� �Է¿����� ����", JOptionPane.ERROR_MESSAGE);
			}
		} 
	}
}

/*
 * [ ���α׷��� ���� �� ���� ]
 *   
 *   1) �� ���α׷����� ��ư�� ���� Action �̺�Ʈ�� ��ϵǾ� ������, �̸� ���� ActionListener �������̽��� �����ϴ� 
 *      MyActionListener Ŭ������ ���� Ŭ������ �ۼ��Ͽ���.
 *     
 *      MyActionListener Ŭ������ ���� Ŭ�����̹Ƿ� �ܺ� Ŭ������ ��� �ʵ带 ������ �� �ִ�. 
 *      �׷��Ƿ�  ������Ʈ�� ���Ե� JFrame ��ü�� ���޹ޱ� ���� ��ü �����ڰ� ���ʿ��ϸ� ���ǵ��� �ʾҴ�. 
 *   
 *      JFrame ��ü���� MyActionListener ��ü�� �����ϱ� ���� ������ Ŭ������ �Ű����� ���� ��ü �����ڸ� ȣ���Ѵ�.
 *      ( MyActionListener Ŭ������ �Ű����� ���� ��ü �����ڴ� ������ �ڵ������� ���ǵ�)
 *     
 *       	  ActionListener listener = new MyActionListener();  // ������ ��ü ����, �̶� �Ű����� ���� ��ü ������ ȣ��
 *      
 *        
 *   2) �־��� ���α׷��� ���캸�� ���α׷��� ������ �ľ��϶�.
 *  
 *   3) ���� Ŭ������ ������ Ŭ������ �ۼ��� �� �ܺ� Ŭ������ �ʵ带 ������ �� ������ �����϶�.
 *   
 *   4) ���α׷��� �����ϰ� ���α׷� ����� Ȯ���϶�.
 *  
 *  
 * [ �ǽ����� ]
 *
 *   1) �� ���α׷��� ��ư�� ���� Action �̺�Ʈ�� ��ϵǾ� �ִ�. Action �̺�Ʈ�� �������� �ʰ� 
 *      Mouse �̺�Ʈ�� ���� ������ �� �ֵ��� ���α׷��� �����Ϸ��Ѵ�.
 *     
 *      �̸� ���Ͽ� ������ Ŭ������ MyMouseListener Ŭ������ ���� Ŭ������ ������ ���� �ۼ��ϰ� �� Ŭ���� ��ü �����Ͽ� ��ư�� ����϶�.
 *     
 *      (1) Mouse �̺�Ʈ ó�� �޼ҵ� �߿���  buttonClicked(ActionEvent e) �޼ҵ�� �̺�Ʈ ó���ϵ��� 
 *          Mouse �������� �̺�Ʈ ó�� �޼ҵ带 �ۼ��϶�. 
 *     
 *      (2) �ٸ� �̺�Ʈ ó�� �޼ҵ�� �޼ҵ� ������ {}���� �ۼ��϶�.   
 */
