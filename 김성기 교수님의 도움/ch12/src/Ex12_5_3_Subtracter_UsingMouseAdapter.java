import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseAdapter;

/**
 * [ Subtracter_UsingMouseAdapter ]: ����� Ŭ������ MouseAdapter Ŭ������ �̿��Ͽ� �̺�Ʈ ó���ϱ�
 * 
 *   o �����(Adapter) Ŭ����
 *     - �̺�Ʈ ó�� �޼ҵ��� ������ ���� ������ �������̽��� ���� ��� abstract �޼ҵ带 ���� �޼ҵ�(���� �κ��� {})��  
 *       �̸� ������ ���� Ŭ����
 *       
 *     - MouseAdapter Ŭ����: MouseListener, MouseMotionListener, MouseWheelListener �������̽��� 
 *       ��� abstract �޼ҵ带 ���� �޼ҵ�� ������ ����� Ŭ����
 *      
 *     - WindowAdapter: WindowListener �������̽��� ���� ����� Ŭ���� 
 *     - ComponentAdapter: ComponentListener �������̽��� ���� ����� Ŭ����
 *     - ContainerAdapter: ContainerListener �������̽��� ���� ����� Ŭ����
 *      
 *   o ����� Ŭ������ �̺�Ʈ ó�� �޼ҵ� �߿��� �ʿ��� �͸� �������̵��Ͽ� �ۼ��ϰ� ���ʿ��� ���� ������ �� �ְ� ��
 *         ==> ������ Ŭ���� �ۼ��� �����ϰ� �ϴ� ����
 *         
 *   o ���� ����� Ŭ������ ����������  MouseAdapter Ŭ������ �ַ� ���
 */

public class Ex12_5_3_Subtracter_UsingMouseAdapter {

	public static void main(String[] args) {
		new SubtracterFrame_UsingMouseAdapter();
	}
} 

class SubtracterFrame_UsingMouseAdapter extends JFrame {
	JTextField tf1, tf2, tfRes;  // ���� �ǿ�����, ������ �ǿ�����, ����� ������ �ؽ�Ʈ �ʵ�
	JButton btnSub;              // �����ڸ� ��Ÿ���� ��ư

	// ��ü ������: ������Ʈ ��ġ �� ����, �̺�Ʈ ��ü ���, ȭ�鿡 ���̱� �� ����
	SubtracterFrame_UsingMouseAdapter() {
		setTitle("Subtracter(�����  Ŭ���� �̿�)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());

		add(tf1 = new JTextField("1234", 10)); // �ʱⰪ "1234", ũ�� 10�� �ؽ�Ʈ�ʵ�
		add(btnSub = new JButton(" - "));

		add(tf2 = new JTextField("2345", 10)); // �ʱⰪ "2345", ũ�� 10�� �ؽ�Ʈ�ʵ�
		add(new JLabel(" = "));
		add(tfRes = new JTextField("", 10));   // �ʱⰪ "", ũ�� 10�� �ؽ�Ʈ�ʵ�

		MouseListener listener = new MyMouseListener();  // MouseAdapter Ŭ������ Ȯ����  ������ ��ü ����
		btnSub.addMouseListener(listener);               // ��ư�� ������ ��ü ���

		setBounds(500, 400, 450,100);	
		
		setVisible(true);    // ������ JFrame ��ü�� ȭ�鿡 ��Ÿ���� ��
	}

	// Mouse�� ��ư Ŭ���� �� ó���ϴ� ������ Ŭ����(���� Ŭ������ �ۼ�)
    //   MouseAdapter Ŭ������ Ȯ���ϴ� ���� Ŭ������ �ۼ�
	class MyMouseListener extends MouseAdapter {

		// ��ư�� Ŭ���ϸ� ȣ��Ǵ� �̺�Ʈ ó�� �޼ҵ带 �������̵���
		public void mouseClicked(MouseEvent e) {
			try {
				// �ܺ�Ŭ������ tf1, tf2, tfRes �̿��Ͽ� ��� ���
				int op1 = Integer.parseInt(tf1.getText());   // ���� Ŭ�������� �ܺ� Ŭ������ �ʵ� tf1 ���� ����
				int op2 = Integer.parseInt(tf2.getText());   // ���� Ŭ�������� �ܺ� Ŭ������ �ʵ� tf2 ���� ����

				tfRes.setText(" " + (op1 - op2));            // ���� Ŭ�������� �ܺ� Ŭ������ �ʵ� tfRes ���� ����
			}
			catch(Exception ex) {
				JOptionPane.showMessageDialog(null, " Error - " + ex.getMessage(), 
						"���� �Է¿����� ����", JOptionPane.ERROR_MESSAGE);
			}
		} 
		
		// �ٸ� �̺�Ʈ ó�� �޼ҵ�� �ۼ����� �ʾƵ� ��
		//  �̹� MouseAdapter Ŭ�������� ���� �޼ҵ�� �ۼ��Ǿ��� ������
	}
}

/*
 * [ ���α׷��� ���� �� ���� ]
 *   
 *   1) �� ���α׷��� ��ư�� ���� MouseAdapter Ŭ������ Ȯ���ϴ� MyMouseAdapter Ŭ������ �ۼ��Ͽ���.
 *      MyMouseAdapter Ŭ�������� MouseClicked(MouseEvent e) �޼ҵ常 �������̵��Ͽ��� 
 *      �ٸ� �̺�Ʈ ó�� �޼ҵ�� �������̵����� �ʾҴ�.
 *        
 *   2) �־��� ���α׷��� ���캸�� ���α׷��� ������ �ľ��϶�.
 *  
 *   3) ����� Ŭ������ ������ Ŭ������ �ۼ��� ���� ������ �����϶�. 
 *   
 *   4) ���α׷��� �����ϰ� ���α׷� ����� Ȯ���϶�.
 *  
 */
