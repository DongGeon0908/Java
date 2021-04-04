import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * [ Calculator1_ButtonVars_ManyListenerClasses ]: 
 *       버튼을 이용하여 4칙 연산 수행하는 GUI 프로그램
 * 
 *  o 이벤트 발생 버튼이 다수일 때 버튼 마다  리스너 클래스 작성
 *     - 4개의 버튼들에 대해 4개의 리스너 클래스와 리스너 객체를 생성하여 버튼에 등록
 * 
 *  o 각 버튼마다 다른 리스너 클래스 작성하여 버튼별 이벤트 처리 가능
 *    - 장점: 이벤트 소스에 따른 간단한 이벤트 처리 가능
 *    - 단점: 리스너 클래스 개수 많아지고 리스너 등록할 때마다 리스너 객체 생성해야 함
 *           ==> 선호하는 방법이 아님
 */

public class Ex12_6_1_1_Calculator1_ButtonVars_ManyListenerClasses {
	public static void main(String [] args) {
		new CalculatorFrame_ButtonVars_ManyListenerClasses();
	}
}

class CalculatorFrame_ButtonVars_ManyListenerClasses extends JFrame {
	
	JTextField tf1, tf2, tfRes;  // 왼쪽 피연산자, 오른쪽 피연산자, 결과를 저장할 텍스트 필드
	JButton btnAdd, btnSub, btnMult, btnDiv;
	JLabel opr;

	// 객체 생성자: 컴포넌트 배치 및 설정, 이벤트 객체 등록, 화면에 보이기 등 수행
	CalculatorFrame_ButtonVars_ManyListenerClasses() {
		setTitle("계산기 - JButton 사용");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));

		add(tf1 = new JTextField("1234", 10)); // 초기값 "1234", 크기 10인 텍스트필드
		add(opr = new JLabel(" + "));

		add(tf2 = new JTextField("2345", 10)); // 초기값 "2345", 크기 10인 텍스트필드
		add(new JLabel("  =  "));
		add(tfRes = new JTextField("", 10));   // 초기값 "", 크기 10인 텍스트필드

		/*
		 *  4개 버튼 객체 생성하여 배치
		 */
		add(btnAdd = new JButton("더하기"));
		add(btnSub = new JButton("빼기"));
		add(btnMult = new JButton("곱하기"));
		add(btnDiv = new JButton("나누기"));

		/*
		 * 4개 버튼에 대하여 서로 다른 리스너 클래스 작성하여 리스너 객체 등록
		 */
		ActionListener listenerAdd = new ActionListenerAdd(); 
		btnAdd.addActionListener(listenerAdd);
		
		ActionListener listenerSub = new ActionListenerSub();
		btnSub.addActionListener(listenerSub);
		
		ActionListener listenerMult = new ActionListenerMult();
		btnMult.addActionListener(listenerMult);
		
		ActionListener listenerDiv = new ActionListenerDiv();
		btnDiv.addActionListener(listenerDiv);

		setBounds(500, 400, 450,150);		
		
		setVisible(true);    // 생성된 JFrame 객체를 화면에 나타나게 함
	}

	// 더하기 버튼을 위한 리스너 클래스(내부 클래스로 작성)
	//  ActionListener 구현하는  Action 리스너 클래스
    //  Action 리스너의 이벤트 처리 메소드는  actionPerformed() 하나
	class ActionListenerAdd implements ActionListener {
		
		// 이 이벤트 처리 메소드는 더하기 버튼 클릭에 의해 호출되므로 더하기를 계산하여 출력
		public void actionPerformed(ActionEvent e) {
			try {
				// tf1과 tf2에 입력된 정수값을 가져와 더하기 결과를 계산하여 tfRes에 출력
				int op1 = Integer.parseInt(tf1.getText());
				int op2 = Integer.parseInt(tf2.getText());
					opr.setText(" + ");
					tfRes.setText(" " + (op1 + op2));
			}
			catch(Exception ex) {
				JOptionPane.showMessageDialog(null, " Error: " + ex.getMessage(), "계산기에서의 오류", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	// 빼기 버튼을 위한 리스너 클래스(내부 클래스로 작성)
	//   ActionListener 구현하는  Action 리스너 클래스
    //   Action 리스너의 이벤트 처리 메소드는  actionPerformed() 하나
	class ActionListenerSub implements ActionListener {
		
		// 이 이벤트 처리 메소드는 빼기 버튼 클릭에 의해 발생하므로 빼기를 계산하여 출력
		public void actionPerformed(ActionEvent e) {
			try {
				// tf1과 tf2에 입력된 정수값을 가져와 더하기 결과를 계산하여 tfRes에 출력
				int op1 = Integer.parseInt(tf1.getText());
				int op2 = Integer.parseInt(tf2.getText());
					opr.setText(" - ");
					tfRes.setText(" " + (op1 - op2));
			}
			catch(Exception ex) {
				JOptionPane.showMessageDialog(null, " Error: " + ex.getMessage(), "계산기에서의 오류", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	// 곱하기 버튼을 위한 리스너 클래스(내부 클래스로 작성)
	//   ActionListener 구현하는  Action 리스너 클래스
    //   Action 리스너의 이벤트 처리 메소드는  actionPerformed() 하나
	class ActionListenerMult implements ActionListener {
		
		// 이 이벤트 처리 메소드는 곱하기 버튼 클릭에 의해 발생하므로 곱하기를 계산하여 출력
		public void actionPerformed(ActionEvent e) {
			try {
				// tf1과 tf2에 입력된 정수값을 가져와 더하기 결과를 계산하여 tfRes에 출력
				int op1 = Integer.parseInt(tf1.getText());
				int op2 = Integer.parseInt(tf2.getText());
					opr.setText(" * ");
					tfRes.setText(" " + (op1 * op2));
			}
			catch(Exception ex) {
				JOptionPane.showMessageDialog(null, " Error: " + ex.getMessage(), "계산기에서의 오류", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	// 나누기 버튼을 위한 리스너 클래스(내부 클래스로 작성)
	//   ActionListener 구현하는  Action 리스너 클래스
    //   Action 리스너의 이벤트 처리 메소드는  actionPerformed() 하나
	class ActionListenerDiv implements ActionListener {
		
		// 이 이벤트 처리 메소드는 나누기 버튼 클릭에 의해 발생하므로 나누기를 계산하여 출력
		public void actionPerformed(ActionEvent e) {
			try {
				// tf1과 tf2에 입력된 정수값을 가져와 더하기 결과를 계산하여 tfRes에 출력
				int op1 = Integer.parseInt(tf1.getText());
				int op2 = Integer.parseInt(tf2.getText());
					opr.setText(" / ");
					tfRes.setText(" " + (op1 / op2));
			}
			catch(Exception ex) {
				JOptionPane.showMessageDialog(null, " Error: " + ex.getMessage(), "계산기에서의 오류", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *   
 *   1) 이 프로그램은 4개의 버튼에 대해 4개의 다른 리스너 클래스를 작성하고 각 버튼마다 다른 리스너 객체를 등록하였다.
 *             
 *   2) 주어진 프로그램을 살펴보고 프로그램의 내용을 파악하라.
 *  
 *   3) 4개의 다른 리스너 클래스를 작성하고 각 버튼마다 다른 리스너 객체를 등록할 때의 문제점을 파악해보라.
 *   
 *   4) 프로그램을 수행하고 프로그램 결과를 확인하라.
 *  
 *  
 * [ 실습과제 ]
 *
 *   1) 이 프로그램은 버튼에 대해 Action 이벤트가 등록되어 있다. Action 이벤트에 동작하지 않고 
 *      Mouse 이벤트에 대해 동작할 수 있도록 프로그램을 수정하려한다.
 *     
 *      이를 위하여 리스너 클래스인 MouseListenerAdd, MouseListenerSub, MouseListenerMult, 
 *      MouseListenerDiv 클래스를  내부 클래스로 다음과 같이 작성하고  각 리스너 클래스의 객체를 생성하여 
 *      4개 버튼에 각각 등록하라.
 *     
 *      (1) Mouse 이벤트 처리 메소드 중에서  buttonClicked(ActionEvent e) 메소드로 이벤트 처리하도록 
 *          Mouse 리스너의 이벤트 처리 메소드를 작성하라. 
 *      
 *      (2) 다른 이벤트 처리 메소드는 메소드 구현을 {}으로 작성하라.        
 */
