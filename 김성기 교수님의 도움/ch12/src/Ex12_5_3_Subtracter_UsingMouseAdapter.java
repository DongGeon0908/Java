import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseAdapter;

/**
 * [ Subtracter_UsingMouseAdapter ]: 어댑터 클래스인 MouseAdapter 클래스를 이용하여 이벤트 처리하기
 * 
 *   o 어댑터(Adapter) 클래스
 *     - 이벤트 처리 메소드의 개수가 많은 리스너 인터페이스에 대해 모든 abstract 메소드를 공백 메소드(구현 부분이 {})로  
 *       미리 구현해 놓은 클래스
 *       
 *     - MouseAdapter 클래스: MouseListener, MouseMotionListener, MouseWheelListener 인터페이스의 
 *       모든 abstract 메소드를 공백 메소드로 구현한 어댑터 클래스
 *      
 *     - WindowAdapter: WindowListener 인터페이스에 대한 어댑터 클래스 
 *     - ComponentAdapter: ComponentListener 인터페이스에 대한 어댑터 클래스
 *     - ContainerAdapter: ContainerListener 인터페이스에 대한 어댑터 클래스
 *      
 *   o 어댑터 클래스는 이벤트 처리 메소드 중에서 필요한 것만 오버라이딩하여 작성하고 불필요한 것은 생략할 수 있게 함
 *         ==> 리스너 클래스 작성을 간단하게 하는 장점
 *         
 *   o 여러 어댑터 클래스가 제공되지만  MouseAdapter 클래스가 주로 사용
 */

public class Ex12_5_3_Subtracter_UsingMouseAdapter {

	public static void main(String[] args) {
		new SubtracterFrame_UsingMouseAdapter();
	}
} 

class SubtracterFrame_UsingMouseAdapter extends JFrame {
	JTextField tf1, tf2, tfRes;  // 왼쪽 피연산자, 오른쪽 피연산자, 결과를 저장할 텍스트 필드
	JButton btnSub;              // 연산자를 나타내는 버튼

	// 객체 생성자: 컴포넌트 배치 및 설정, 이벤트 객체 등록, 화면에 보이기 등 수행
	SubtracterFrame_UsingMouseAdapter() {
		setTitle("Subtracter(어댑터  클래스 이용)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());

		add(tf1 = new JTextField("1234", 10)); // 초기값 "1234", 크기 10인 텍스트필드
		add(btnSub = new JButton(" - "));

		add(tf2 = new JTextField("2345", 10)); // 초기값 "2345", 크기 10인 텍스트필드
		add(new JLabel(" = "));
		add(tfRes = new JTextField("", 10));   // 초기값 "", 크기 10인 텍스트필드

		MouseListener listener = new MyMouseListener();  // MouseAdapter 클래스를 확장한  리스너 객체 생성
		btnSub.addMouseListener(listener);               // 버튼에 리스너 객체 등록

		setBounds(500, 400, 450,100);	
		
		setVisible(true);    // 생성된 JFrame 객체를 화면에 나타나게 함
	}

	// Mouse가 버튼 클릭할 때 처리하는 리스너 클래스(내부 클래스로 작성)
    //   MouseAdapter 클래스를 확장하는 하위 클래스로 작성
	class MyMouseListener extends MouseAdapter {

		// 버튼을 클릭하면 호출되는 이벤트 처리 메소드를 오버라이딩함
		public void mouseClicked(MouseEvent e) {
			try {
				// 외부클래스의 tf1, tf2, tfRes 이용하여 결과 출력
				int op1 = Integer.parseInt(tf1.getText());   // 내부 클래스에서 외부 클래스의 필드 tf1 접근 가능
				int op2 = Integer.parseInt(tf2.getText());   // 내부 클래스에서 외부 클래스의 필드 tf2 접근 가능

				tfRes.setText(" " + (op1 - op2));            // 내부 클래스에서 외부 클래스의 필드 tfRes 접근 가능
			}
			catch(Exception ex) {
				JOptionPane.showMessageDialog(null, " Error - " + ex.getMessage(), 
						"정수 입력에서의 오류", JOptionPane.ERROR_MESSAGE);
			}
		} 
		
		// 다른 이벤트 처리 메소드는 작성하지 않아도 됨
		//  이미 MouseAdapter 클래스에서 공백 메소드로 작성되었기 때문임
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *   
 *   1) 이 프로그램은 버튼에 대해 MouseAdapter 클래스를 확장하는 MyMouseAdapter 클래스를 작성하였다.
 *      MyMouseAdapter 클래스에는 MouseClicked(MouseEvent e) 메소드만 오버라이딩하였고 
 *      다른 이벤트 처리 메소드는 오버라이딩하지 않았다.
 *        
 *   2) 주어진 프로그램을 살펴보고 프로그램의 내용을 파악하라.
 *  
 *   3) 어댑터 클래스로 리스너 클래스를 작성할 때의 장점을 이해하라. 
 *   
 *   4) 프로그램을 수행하고 프로그램 결과를 확인하라.
 *  
 */
