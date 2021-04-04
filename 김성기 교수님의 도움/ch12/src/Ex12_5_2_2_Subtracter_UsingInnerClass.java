import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * [ Subtracter_UsingInnerClass ]: 리스너 클래스를 내부 클래스로 작성하기
 * 
 *   o 리스너 클래스
 *     - 특정 이벤트를 처리하기 위해 작성하는 클래스
 *     - 특정 이벤트에 대한 리스너 인터페이스를 구현하는 하위 클래스로 작성해야 함
 *     - 리스너 인터페이스의 abstract 메소드인 이벤트 처리 메소드들 모두 구현해야 함
 *     - 여러 이벤트 처리 메소드 중 필요한 메소드만 구현하고 불필요한 메소드는 공백 메소드로 작성
 * 
 *   o 리스너 클래스 작성 유형
 *     1) 독립된 클래스로 작성하기
 *        - 리스너 클래스를 JFrame 클래스와 분리된 클래스로 작성
 *        - JFrame 객체의 컴포넌트를 리스너 객체에서 사용하려면 JFrame 객체를 리스너 객체로 전달해야 함
 *        - JFrame 객체를 전달받아 저장하는 리스너 클래스의 객체 생성자 작성이 필요
 *  
 *     2) 내부 클래스(inner class)로 작성하기
 *        - 리스너 클래스를 JFrame 클래스 내부에서 작성
 *        - 리스너 클래스에서 JFrame 클래스의 컴포넌트를 마음대로 접근할 수 있어 편리함 
 *        - 리스너 클래스의 객체 생성자 작성할 필요 없음
 * 
 *     3) 익명 클래스(anonymous class)로 작성하기
 *        - 리스너 클래스를 JFrame 클래스 내부에서 하위 클래스 정의하면서 바로 객체 생성
 *        - 리스너 클래스의 객체를 하나만 생성 가능함
 *             new 상위_클래스() { 상위_클래스의 재정의 }
 *             new 상위_인터페이스() { 상위_인터페이스의 재정의 }
 *                
 *        - 리스너 클래스의 객체 생성자 작성할 필요 없음
 *        - 프로그램은 간단하지만 이해하기가 어려우므로 초보자는 사용하지 말 것
 */

public class Ex12_5_2_2_Subtracter_UsingInnerClass {

	public static void main(String [] args) {
		new SubtracterFrame_UsingInnerListener();
	}
} 

class SubtracterFrame_UsingInnerListener extends JFrame {
	JTextField tf1, tf2, tfRes;  // 왼쪽 피연산자, 오른쪽 피연산자, 결과를 저장할 텍스트 필드
	JButton btnSub;              // 연산자를 나타내는 버튼

	// 객체 생성자: 컴포넌트 배치 및 설정, 이벤트 객체 등록, 화면에 보이기 등 수행
	SubtracterFrame_UsingInnerListener() {
		setTitle("Subtracter(내부 리스너 클래스 이용)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());

		add(tf1 = new JTextField("1234", 10)); // 초기값 "1234", 크기 10인 텍스트필드
		add(btnSub = new JButton(" - "));

		add(tf2 = new JTextField("2345", 10)); // 초기값 "2345", 크기 10인 텍스트필드
		add(new JLabel(" = "));
		add(tfRes = new JTextField("", 10));   // 초기값 "", 크기 10인 텍스트필드

		ActionListener listener = new MyActionListener();  // 내부 클래스로 작성된 리스너 객체 생성
		btnSub.addActionListener(listener);                // 버튼에 리스너 객체 등록

		setBounds(500, 400, 450,100);		
		
		setVisible(true);    // 생성된 JFrame 객체를 화면에 나타나게 함
	}

	// ActionListener 구현하는  Action 리스너 클래스를 내부 클래스로 작성
	//   Action 리스너의 이벤트 처리 메소드는  actionPerformed() 하나임
	class MyActionListener implements ActionListener {

		// 버튼을 클릭하면 호출되는 이벤트 처리 메소드를 구현함
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton) e.getSource();// 선택된 버튼 객체 가져옴

			try {
				// 외부 클래스의 필드  tf1, tf2, tfRes 이용하여 결과 출력
				int op1 = Integer.parseInt(tf1.getText());   // 내부 클래스에서 외부 클래스의 필드 tf1 접근 가능
				int op2 = Integer.parseInt(tf2.getText());   // 내부 클래스에서 외부 클래스의 필드 tf2 접근 가능

				tfRes.setText(" " + (op1 - op2));            // 내부 클래스에서 외부 클래스의 필드 tfRes 접근 가능
			}
			catch(Exception ex) {
				JOptionPane.showMessageDialog(null, " Error - " + ex.getMessage(), 
						"정수 입력에서의 오류", JOptionPane.ERROR_MESSAGE);
			}
		} 
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *   
 *   1) 이 프로그램에는 버튼에 대해 Action 이벤트만 등록되어 있으며, 이를 위해 ActionListener 인터페이스를 구현하는 
 *      MyActionListener 클래스를 내부 클래스로 작성하였다.
 *     
 *      MyActionListener 클래스는 내부 클래스이므로 외부 클래스의 모든 필드를 접근할 수 있다. 
 *      그러므로  컴포넌트가 포함된 JFrame 객체를 전달받기 위한 객체 생성자가 불필요하며 정의되지 않았다. 
 *   
 *      JFrame 객체에서 MyActionListener 객체를 생성하기 위해 리스너 클래스의 매개변수 없는 객체 생성자를 호출한다.
 *      ( MyActionListener 클래스에 매개변수 없는 객체 생성자는 없지만 자동적으로 정의됨)
 *     
 *       	  ActionListener listener = new MyActionListener();  // 리스너 객체 생성, 이때 매개변수 없는 객체 생성자 호출
 *      
 *        
 *   2) 주어진 프로그램을 살펴보고 프로그램의 내용을 파악하라.
 *  
 *   3) 내부 클래스로 리스너 클래스를 작성할 때 외부 클래스의 필드를 접근할 수 있음을 이해하라.
 *   
 *   4) 프로그램을 수행하고 프로그램 결과를 확인하라.
 *  
 *  
 * [ 실습과제 ]
 *
 *   1) 이 프로그램은 버튼에 대해 Action 이벤트만 등록되어 있다. Action 이벤트에 동작하지 않고 
 *      Mouse 이벤트에 대해 동작할 수 있도록 프로그램을 수정하려한다.
 *     
 *      이를 위하여 리스너 클래스인 MyMouseListener 클래스를 내부 클래스로 다음과 같이 작성하고 이 클래스 객체 생성하여 버튼에 등록하라.
 *     
 *      (1) Mouse 이벤트 처리 메소드 중에서  buttonClicked(ActionEvent e) 메소드로 이벤트 처리하도록 
 *          Mouse 리스너의 이벤트 처리 메소드를 작성하라. 
 *     
 *      (2) 다른 이벤트 처리 메소드는 메소드 구현을 {}으로 작성하라.   
 */
