package practice12_2_divisor_primeno;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * [ 12장 실습과제 2번 기본 프로그램 ]
 * 
 *   2. 약수 및 소수 출력에서 미완성된 코드 완성하기
 *   
 *      정수를 입력하여 그 정수의 모든 약수를 출력하고 그 정수보다 큰 소수 10개를 출력하는 GUI 프로그램을 
 *      DivisorsNext10Primes 클래스로 작성하였다. 
 *      
 *      DivisorsNext10Primes 클래스에서 작성되지 않은 enrolComponents() 메소드와  enrolListener() 메소드를 
 *      작성하고 이벤트 처리에서 미완성 부분을 완성하라.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Practice12_2_Divisor_PrimeNo extends JFrame {  
	JLabel lbN = new JLabel("정수 입력:");
	JTextField tfN  = new JTextField("1234", 10);	// 숫자 입력받을 필드
	JTextField tfRes  = new JTextField("", 40); 	// 약수 또는 다음 소수 10개 결과 저장할 텍스트 필드

	JButton btnDiv = new JButton(" 모든 약수 구하기 ");
	JButton btnNextPrime  = new JButton(" 다음 소수 10개 구하기 ");

	Practice12_2_Divisor_PrimeNo() {
		setTitle("약수 및 다음 소수 10개 구하기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());

//		addComponents();	// 1) 컴포넌트들을 프레임에 배치하는 메소드 작성하라
		
//		enrolListener(); 	// 2) btnDiv와 btnNextPrime에 리스너 객체 생성하여  
							//    등록하는 메소드 작성하라
		
		setBounds(500, 400, 550,140);
		setVisible(true);
	}

	// ActionListener 구현하는 Action 리스너 클래스를 내부 클래스로 작성
	//    Action 리스너의 이벤트 처리 메소드는 actionPerformed() 하나
	class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton) e.getSource();  // 선택된 버튼 객체 가져옴

			try {
				// 3) 이벤트 처리하는 부분 작성하라
				//    이때 이미 작성된 isPrime() 메소드 사용하라
			}
			catch(Exception ex) {
				JOptionPane.showMessageDialog(null, " Error - " + ex.getMessage(), 
						"정수 입력에서 오류", JOptionPane.ERROR_MESSAGE);
			} 
		}

		// 주어진 n이 소수면 true, 아니면 false를 반환하는 메소드
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

