package practice12_2_divisor_primeno;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * [ 12�� �ǽ����� 2�� �⺻ ���α׷� ]
 * 
 *   2. ��� �� �Ҽ� ��¿��� �̿ϼ��� �ڵ� �ϼ��ϱ�
 *   
 *      ������ �Է��Ͽ� �� ������ ��� ����� ����ϰ� �� �������� ū �Ҽ� 10���� ����ϴ� GUI ���α׷��� 
 *      DivisorsNext10Primes Ŭ������ �ۼ��Ͽ���. 
 *      
 *      DivisorsNext10Primes Ŭ�������� �ۼ����� ���� enrolComponents() �޼ҵ��  enrolListener() �޼ҵ带 
 *      �ۼ��ϰ� �̺�Ʈ ó������ �̿ϼ� �κ��� �ϼ��϶�.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Practice12_2_Divisor_PrimeNo extends JFrame {  
	JLabel lbN = new JLabel("���� �Է�:");
	JTextField tfN  = new JTextField("1234", 10);	// ���� �Է¹��� �ʵ�
	JTextField tfRes  = new JTextField("", 40); 	// ��� �Ǵ� ���� �Ҽ� 10�� ��� ������ �ؽ�Ʈ �ʵ�

	JButton btnDiv = new JButton(" ��� ��� ���ϱ� ");
	JButton btnNextPrime  = new JButton(" ���� �Ҽ� 10�� ���ϱ� ");

	Practice12_2_Divisor_PrimeNo() {
		setTitle("��� �� ���� �Ҽ� 10�� ���ϱ�");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());

//		addComponents();	// 1) ������Ʈ���� �����ӿ� ��ġ�ϴ� �޼ҵ� �ۼ��϶�
		
//		enrolListener(); 	// 2) btnDiv�� btnNextPrime�� ������ ��ü �����Ͽ�  
							//    ����ϴ� �޼ҵ� �ۼ��϶�
		
		setBounds(500, 400, 550,140);
		setVisible(true);
	}

	// ActionListener �����ϴ� Action ������ Ŭ������ ���� Ŭ������ �ۼ�
	//    Action �������� �̺�Ʈ ó�� �޼ҵ�� actionPerformed() �ϳ�
	class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton) e.getSource();  // ���õ� ��ư ��ü ������

			try {
				// 3) �̺�Ʈ ó���ϴ� �κ� �ۼ��϶�
				//    �̶� �̹� �ۼ��� isPrime() �޼ҵ� ����϶�
			}
			catch(Exception ex) {
				JOptionPane.showMessageDialog(null, " Error - " + ex.getMessage(), 
						"���� �Է¿��� ����", JOptionPane.ERROR_MESSAGE);
			} 
		}

		// �־��� n�� �Ҽ��� true, �ƴϸ� false�� ��ȯ�ϴ� �޼ҵ�
		boolean isPrime(int n) { 
			if (n <= 1)
				return false;
			if (n == 2) return true;
			if (n % 2 ==0) return false;

			for (int i = 3;  i < n; i += 2)
				if (n % i == 0)
					return false;

			return true;   
		}
	}
	
	public static void main(String[] args) {
		new Practice12_2_Divisor_PrimeNo();
	}
}

