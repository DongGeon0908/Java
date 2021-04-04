package practice12_1_Interest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * [ 12�� �ǽ����� 1�� �⺻ ���α׷� ]
 * 
 *   1. ���� ���ϱ��� �̿ϼ��� �ڵ� �ϼ��ϱ�
 *   
 *      �־��� GUI�� ���� ����(principal)�� �� ������(rate, �ۼ�Ʈ ������ 0���� 100���� ����)�� �Է��Ͽ� "���� ���" ��ư��
 *      Ŭ���Ǹ� ���ݿ� ���� �� ����(interest)�� ����Ͽ� ����ϴ� Java ���α׷��� �̿ϼ� �κ��� �ۼ��϶�.
 */

public class Practice12_1_CalInterest extends JFrame {
	JTextField principalTF, rateTF, interestTF; 	// ����, ������, ���� ���� �ؽ�Ʈ �ʵ�
	JLabel principalLB, rateLB, interestLB;  		// �ؽ�Ʈ �ʵ� �����ϱ� ���� ���̺�
	JButton OKBt;                      				// "���� ���: Ȯ�� ��ư

	Practice12_1_CalInterest() {
		setTitle("Calculating Interest");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());

		// (1) JFrame�� ������Ʈ ��ġ�ϰ� ������ ��ü ����ϴ� �ڵ� �ۼ��϶�.

		setSize(480,110);   
		setVisible(true);
	}

	// ActionListener �����ϴ� Action ������ �ۼ�
	class CalActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// (2) principalTF, rateTF�� �Էµ� ������ ������ ���� ����Ͽ� 
			//      interestTF�� ����ϴ� �ڵ� �ۼ��϶�.
		} 
	}

	public static void main(String[] args) {
		new Practice12_1_CalInterest();
	}
}
