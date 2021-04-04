import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * [ Calculator1_ButtonVars2_OneListenerClass ]: 버튼을 이용하여 4칙 연산 수행하는 GUI 프로그램
 * 
 *  o 이벤트 발생 버튼이 다수일 때 하나의 리스너 클래스 작성
 *    - 4개의 버튼들에 대해 1개 리스너 클래스 작성하고 1개 리스너 객체를 생성하여 4개의 버튼에 등록 
 *    
 *  o 모든 버튼에 하나의 리스너 객체를 등록하여 이벤트 처리 메소드에서 이벤트 발생 버튼 확인하여 해당 버튼에 대한 이벤트 처리
 *    - 장점: 하나의 리스너 클래스, 하나의 리스너 객체 생성으로 가능 
 *    - 단점: 하나의 리스너 클래스에서 여러 버튼 중 이벤트 발생한  소스 찾아  소스별 이벤트  처리해야 하므로 이벤트 처리가 다소 복잡
 *    - 선호하는 방법
 */

public class Ex12_6_1_2_Calculator1_ButtonVars_OneListenerClass extends JFrame {
	
	public static void main(String [] args) {
		new CalculatorFrame_ButtonVars_OneListenerClass();
	}
}

class CalculatorFrame_ButtonVars_OneListenerClass extends JFrame {

	JTextField tf1, tf2, tfRes;  // 왼쪽 피연산자, 오른쪽 피연산자, 결과를 저장할 텍스트 필드
	JButton btnAdd, btnSub, btnMult, btnDiv;
	JLabel opr;
	
	// 객체 생성자: 컴포넌트 배치 및 설정, 이벤트 객체 등록, 화면에 보이기 등 수행
	CalculatorFrame_ButtonVars_OneListenerClass() {
		setTitle("계산기 - JButton 사용");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));

		add(tf1 = new JTextField("1234", 10));  // 초기값 "1234", 크기 10인 텍스트필드
		add(opr = new JLabel(" ? "));

		add(tf2 = new JTextField("2345", 10));  // 초기값 "2345", 크기 10인 텍스트필드
		add(new JLabel("  =  "));
		add(tfRes = new JTextField("", 10));    // 초기값 "", 크기 10인 텍스트필드

		/*
		 *  4개 버튼 객체 생성하여 배치
		 */
		add(btnAdd = new JButton("더하기"));
		add(btnSub = new JButton("빼기"));
		add(btnMult = new JButton("곱하기"));
		add(btnDiv = new JButton("나누기"));

		/*
		 * 하나의 리스너 클래스 작성하여 한 리스너 객체를 4개 버튼에 모두 등록
		 */
		MyActionListener listener = new MyActionListener();   // 리스너 객체 생성

		btnAdd.addActionListener(listener);  // 버튼에 리스너 객체 등록
		btnSub.addActionListener(listener);  // 버튼에 리스너 객체 등록
		btnMult.addActionListener(listener); // 버튼에 리스너 객체 등록
		btnDiv.addActionListener(listener);  // 버튼에 리스너 객체 등록

		setBounds(500, 400, 450,150);	
		
		setVisible(true);    // 생성된 JFrame 객체를 화면에 나타나게 함
	}

	// 4개 버튼에 대해 모두 Action 이벤트 처리하는 리스너 클래스(내부 클래스로 작성)
	//   ActionListener 구현하는  Action 리스너 클래스
	//   Action 리스너의 이벤트 처리 메소드는 actionPerformed() 하나임
	//   이벤트 발생한 버튼을 찾아 그 버튼에 해당되는 이벤트 처리하도록 함
	class MyActionListener implements ActionListener {

		// 버튼을 클릭하면 호출되는 이벤트 처리 메소드 구현함
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();// e.getSource() 메소드는 선택된 버튼 객체 구함

			try {
				// tf1과 tf2에 입력된 정수값 가져와 버튼에 따라 결과 계산하여 tfRes에 출력
				int op1 = Integer.parseInt(tf1.getText());
				int op2 = Integer.parseInt(tf2.getText());

				if (b == btnAdd)  {      // 클릭된 버튼이 btnAdd이면 더하기 연산을 수행하여 결과를 결과 텍스트필드에 출력
					opr.setText(" + ");
					tfRes.setText(" " + (op1 + op2));
				}
				else if (b == btnSub)  { // 클릭된 버튼이 btnSub이면 빼기 연산을 수행하여 결과를 결과 텍스트필드에 출력
					opr.setText(" - ");
					tfRes.setText(" " + (op1 - op2));
				}
				else if (b == btnMult) { // 클릭된 버튼이 btnMult이면 곱하기 연산을 수행하여 결과를 결과 텍스트필드에 출력
					opr.setText(" * ");
					tfRes.setText(" " + (op1 * op2));	
				}
				else if (b == btnDiv) {  // 클릭된 버튼이 btnDiv이면 나누기 연산을 수행하여 결과를 결과 텍스트필드에 출력
					opr.setText(" / ");
					tfRes.setText(" " + (op1 / op2));		
				}
			}
			catch(Exception ex) {
				JOptionPane.showMessageDialog(null, " Error: " + ex.getMessage(), "계산기에서의 오류", 
						                                                 JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *   
 *   1) 4개 버튼에 대해 하나의 리스너 클래스를 작성하고 모든 버튼에 같은 리스너 객체를 등록하였다.
 *      하나의 리스너 클래스에는 4개 버튼에 대해 이벤트를 처리할 수 있도록 코드가 작성되며,
 *      특히 이벤트 소스를 찾아 적절한 처리를 할 수 있도록 이벤트 처리 메소드가 작성되었다.
 *     
 *      - 이벤트 소스를 찾기 위해 호출된 이벤트 처리 메소드의 매개변수로 주어진 이벤트 객체에 대해 getSource() 메소드를 호출한다.
 *     
 *     		public void actionPerformed(ActionEvent e) {
 *			   JButton b = (JButton)e.getSource();// e.getSource() 메소드는 선택된 버튼 객체 구함
 *      
 *      - 그 다음 구해진 이벤트 소스를 각 버튼과 비교하여 4개 버튼 중 어느 버튼인가를 확인한다.
 *     
 *          if (b == btnAdd)  { // 클릭된 버튼이 btnAdd이면 더하기 연산을 수행하여 결과를 결과 텍스트필드에 출력
 *		     	opr.setText(" + ");
 *				tfRes.setText(" " + (op1 + op2));
 *			}
 *			else if (b == btnSub)  { // 클릭된 버튼이 btnSub이면 빼기 연산을 수행하여 결과를 결과 텍스트필드에 출력
 *				opr.setText(" - ");
 *				tfRes.setText(" " + (op1 - op2));
 *			}
 *             ...   
 *             
 *   2) 주어진 프로그램을 살펴보고 프로그램의 내용을 파악하라.
 *  
 *   3) 하나의 리스너 클래스를 작성하고 모든 버튼에 동일한 리스너 객체를 등록할 때의 장점을 파악해보라.
 *   
 *   4) 프로그램을 수행하고 프로그램 결과를 확인하라.
 *  
 *  
 * [ 실습과제 ]
 *
 *  1) 이 프로그램은 버튼에 대해 Action 이벤트만 등록되어 있다. Action 이벤트에 동작하지 않고 
 *     Mouse 이벤트에 대해 동작할 수 있도록 프로그램을 수정하려한다.
 *     
 *     이를 위하여 리스너 클래스인 MyMouseListener 클래스를 
 *     내부 클래스로 다음과 같이 작성하고, 이 리스너 클래스의  객체 하나를 생성하여 4개 버튼에 모두 등록하라.
 *     
 *     (1) Mouse 이벤트 처리 메소드 중에서 buttonClicked(ActionEvent e) 메소드로 이벤트 처리하도록 
 *         Mouse 리스너의 이벤트 처리 메소드를 작성하라. 
 *         
 *     (2) 다른 이벤트 처리 메소드는 메소드 구현을 {}으로 작성하라.        
 */
