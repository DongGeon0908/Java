import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * [ Calculator_Subtracter_UsingIndependentClass]: ������ Ŭ������ ���� Ŭ������ �ۼ��ϱ�
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

public class Ex12_5_2_1_Subtracter_UsingIndependentClass {

	public static void main(String [] args) {
		new SubtracterFrame_UsingIndependentListener();
	}
}

class SubtracterFrame_UsingIndependentListener extends JFrame {
	JTextField tf1, tf2, tfRes;  // ���� �ǿ�����, ������ �ǿ�����, ����� ������ �ؽ�Ʈ �ʵ�
	JButton btnSub;              // �����ڸ� ��Ÿ���� ��ư

	// ��ü ������: ������Ʈ ��ġ �� ����, �̺�Ʈ ��ü ���, ȭ�鿡 ���̱� �� ����
	SubtracterFrame_UsingIndependentListener() {
		setTitle("Subtracter(���� ������ Ŭ���� �̿�)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());

		add(tf1 = new JTextField("1234", 10));      // �ʱⰪ "1234", ũ�� 10�� �ؽ�Ʈ�ʵ�
		add(btnSub = new JButton(" - "));

		add(tf2 = new JTextField("2345", 10));      // �ʱⰪ "2345", ũ�� 10�� �ؽ�Ʈ�ʵ�
		add(new JLabel(" = "));
		add(tfRes = new JTextField("", 10));        // �ʱⰪ "", ũ�� 10�� �ؽ�Ʈ�ʵ�

		ActionListener listener = new MyActionListener(this);  // ������ ��ü ����, �̶� JFrame ��ü�� this�� �Ű������� ����
		btnSub.addActionListener(listener);                    // ��ư�� ������ ��ü ���

		setBounds(500, 400, 450,100);	
		
		setVisible(true);   // ������ JFrame ��ü�� ȭ�鿡 ��Ÿ���� ��
	}
}

// ActionListener �����ϴ�  Action ������ Ŭ������ ���� Ŭ������ �ۼ�
//   Action �������� �̺�Ʈ ó�� �޼ҵ�� actionPerformed() �ϳ���
class MyActionListener implements ActionListener {

	// �̺�Ʈ ó���� JFrame ��ü �����ϴ� ����(JFrame ��ü�� ������Ʈ�� �����ϱ� ���� �ݵ�� �ʿ�)
	SubtracterFrame_UsingIndependentListener frame;   

	// �̺�Ʈ ó���� JFrame ��ü�� ���޹޾� �ʵ忡 �����ϴ� ��ü ������
	MyActionListener(SubtracterFrame_UsingIndependentListener frame) {  
		this.frame = frame;     // ���޵� frame ��ü�� �ʵ� frame�� ����
	}

	// ��ư�� Ŭ���ϸ� ȣ��Ǵ� �̺�Ʈ ó�� �޼ҵ带 ������
	public void actionPerformed(ActionEvent e) {
		try {
			// frame�� tf1, tf2, tfRes �̿��Ͽ� ��� ���
			int op1 = Integer.parseInt(frame.tf1.getText());   // ����� frame�� tf1 �ʵ� ����
			int op2 = Integer.parseInt(frame.tf2.getText());   // ����� frame�� tf2 �ʵ� ����

			frame.tfRes.setText(" " + (op1 - op2));            // ����� frame�� tfRes �ʵ� ����
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, " Error - " + ex.getMessage(), 
					"���� �Է¿����� ����", JOptionPane.ERROR_MESSAGE);
		}
	} 
}

/*
 * [ ���α׷��� ���� �� ���� ]
 *   
 *   1) �� ���α׷����� ��ư�� ���� Action �̺�Ʈ �����ʰ� ��ϵǾ� ������, ActionListener �������̽��� �����ϴ� 
 *      MyActionListener Ŭ������ ���� Ŭ������ �ۼ��Ͽ���.
 *     
 *      - MyActionListener Ŭ�������� ������Ʈ�� ���Ե� JFrame ��ü�� ���޹ޱ� ���� ��ü �����ڰ� ���ǵǾ���. 
 *        ��ü �����ڴ� ���޵� JFrame ��ü�� ������ Ŭ������ �ʵ忡 �����Ͽ� ���߿� JFrame ��ü�� ������Ʈ�� �����Ѵ�.
 *     
 *           // �̺�Ʈ ó���� JFrame ��ü  �����ϴ� ����(JFrame ��ü�� ������Ʈ�� �����ϱ� ���� �ݵ�� �ʿ�)
 *           Subtracter_UsingIndependentListener frame;   
 *
 *           // �̺�Ʈ ó���� JFrame ��ü�� ���޹޾� �ʵ忡 �����ϴ� ��ü ������
 *           MyActionListener(Subtracter_UsingIndependentListener frame) {  
 *	            this.frame = frame;     // ���޵� frame ��ü�� �ʵ� frame�� ����
 *   	     }
 *   
 *      - JFrame ��ü���� MyActionListener ��ü�� �����ϱ� ���� ��ü ������ ȣ���� �� JFrame ��ü�� this�� �Ű������� �����Ѵ�.
 *     
 *           MyActionListener listener = new MyActionListener(this);  // ������ ��ü ����, �̶� JFrame ��ü�� this�� �Ű������� ����
 *             
 *   2) �־��� ���α׷��� ���캸�� ���α׷��� ������ �ľ��϶�.
 *  
 *   3) ���� Ŭ������ ������ Ŭ������ �ۼ��� �� JFrame ��ü�� ������ ��ü ���� �� �����ؾ� ���� �ݵ�� �����϶�.
 *   
 *   4) ���α׷��� �����ϰ� ���α׷� ����� Ȯ���϶�.
 *  
 *  
 * [ �ǽ����� ]
 *
 *   1) �� ���α׷��� ��ư�� ���� Action �̺�Ʈ�� ��ϵǾ� �ִ�. Action �̺�Ʈ�� �������� �ʰ� 
 *      Mouse �̺�Ʈ�� ���� ������ �� �ֵ��� ���α׷��� �����Ϸ��Ѵ�.
 *     
 *      �̸� ���Ͽ� ������ Ŭ������ MyMouseListener Ŭ������ ���� Ŭ������ ������ ���� �ۼ��ϰ� 
 *      �� Ŭ���� ��ü �����Ͽ� ��ư�� ����϶�.
 *     
 *      (1) JFrame ��ü�� �Ű������� ������ ��ü �����ڸ� �����϶�.
 *      
 *      (2) Mouse �̺�Ʈ ó�� �޼ҵ� �߿��� buttonClicked(ActionEvent e) �޼ҵ�� �̺�Ʈ 
 *          ó���ϵ��� Mouse �������� �̺�Ʈ ó�� �޼ҵ带 �ۼ��϶�. 
 *          
 *      (3) �ٸ� �̺�Ʈ ó�� �޼ҵ�� �޼ҵ� ������ {}���� �ۼ��϶�.
 *      
 */
