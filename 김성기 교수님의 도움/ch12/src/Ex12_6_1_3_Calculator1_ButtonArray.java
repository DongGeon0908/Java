import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * [ Calculator1_ButtonArray ] : 버튼 배열을 이용하여 4칙 연산 수행하는 GUI 프로그램
 * 
 *   o 이벤트 발생 버튼들이 다수일 때 이를 배열 원소로 저장
 *     - 버튼들을 버튼 배열에 저장하여 for 문 이용하여 전체적으로 관리하게 함
 * 
 *   o 이벤트 발생 버튼이 다수일 때 하나의 리스너 클래스 작성
 *     - 모든 버튼에 하나의 리스너 객체를 등록하여 이벤트 처리 메소드에서 이벤트 발생 버튼 확인하여 
 *       해당 버튼에 대한 이벤트 처리
 *       
 *     - 장점: 하나의 리스너 클래스, 하나의 리스너 객체 생성으로 가능 
 *     
 *     - 단점: 하나의 리스너 클래스에서 여러 버튼 중 이벤트 발생한 소스 찾아 소스별 이벤트  처리해야 하므로 
 *            이벤트 처리가 다소 복잡
 *            
 *     - 간결한 프로그램이 가능한 방법임
 */

public class Ex12_6_1_3_Calculator1_ButtonArray  {
	
	public static void main(String [] args) {
		new  CalculatorFrame_ButtonArray();
	}
}

class CalculatorFrame_ButtonArray extends JFrame {
	
	JTextField tf1, tf2, tfRes;  // 왼쪽 피연산자, 오른쪽 피연산자, 결과를 저장할 텍스트 필드
	String[] oprNames = { "더하기", "빼기", "곱하기", "나누기" };
	String[] oprSign = { " + ", " - ", " * ", " / " };
	
	JButton[] btnOprs  = new JButton[4];

	JLabel opr;

	// 객체 생성자: 컴포넌트 배치 및 설정, 이벤트 객체 등록, 화면에 보이기 등 수행
	CalculatorFrame_ButtonArray() {
		setTitle("계산기 - JButton 배열 이용");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new FlowLayout());

		add(tf1 = new JTextField("1234", 10));       // 초기값 "1234", 크기 10인 텍스트필드
		add(opr = new JLabel(oprSign[0]));

		add(tf2 = new JTextField("2345", 10));       // 초기값 "2345", 크기 10인 텍스트필드
		add(new JLabel("  =  "));
		add(tfRes = new JTextField("", 10));         // 초기값 "", 크기 10인 텍스트필드

		ActionListener listener = new MyActionListener(); // Action 리스너 객체 생성

		for (int i=0; i<4; i++) {
			btnOprs[i] = new JButton(oprNames[i]);   // 버튼 객체 생성하여 배열 원소로 저장
			btnOprs[i].addActionListener(listener);  // 버튼 객체에 리스너 객체 등록
			add(btnOprs[i]);                         // 버튼 객체를 JFrame 객체에 배치
		}

		setBounds(500, 400, 450,150);	
		
		setVisible(true);    // 생성된 JFrame 객체를 화면에 나타나게 함
	}

	// 4의 버튼에 대해 모두 Action 이벤트 처리하는 리스너 클래스(내부 클래스로 작성)
	//   ActionListener 구현하는  Action 리스너
    //   Action 리스너의 이벤트 처리 메소드는  actionPerformed() 하나임
	class MyActionListener implements ActionListener {
		
		// 버튼을 클릭하면 호출되는 이벤트 처리 메소드를 구현함
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();// e.getSource() 메소드는 선택된 버튼 객체 구함

			try {			// tf1과 tf2에 입력된 정수값을 가져와 선택 연산자에 따라 결과를 계산하여 tfRes에 출력
				int op1 = Integer.parseInt(tf1.getText());
				int op2 = Integer.parseInt(tf2.getText());
                int res = 0;

				for (int i=0; i < btnOprs.length; i++)  // 클릭된 버튼을 찾아 해당 연산을 수행하여 결과를 결과 텍스트필드에 출력
					if (b == btnOprs[i]) {
						opr.setText(oprSign[i]);        // 클릭된 버튼의 연산자 출력
						
						if (i == 0) res = op1 + op2;    // 클릭된 버튼에 따라 결과 계산
						else if (i == 1) res =  op1 - op2;
						else if (i == 2) res =  op1 * op2;
						else if (i == 3) res =  op1 / op2;

						tfRes.setText(" " + res);      // 계산 결과 출력
					}
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
 *   1) 4개 버튼에 대해 하나의 리스너 클래스를 작성하고 모든 버튼에 같은 리스너 객체를 등록하였다.
 *      하나의 리스너 클래스에는 4개 버튼에 대해 이벤트를 처리할 수 있도록 코드가 작성되며,
 *      특히 이벤트 소스를 찾아 적절한 처리를 할 수 있도록 이벤트 처리 메소드가 작성되었다.
 *     
 *      - 이벤트 소스를 찾기 위해 호출된 이벤트 처리 메소드의 매개변수로 주어진 이벤트 객체에 대해 getSource() 메소드를 호출한다.
 *     
 *   2) 버튼 개수가 다수일 때 배열 이용하면 버튼 생성, 배치, 리스너 객체 등록 등이 간단해지며
 *      리스너 클래스의 이벤트 처리 메소드의 작성도 용이해짐
 *
 *      - for 문으로  버튼 객체들 생성, 리스너 객체 등록, 배치, 이벤트 소스 찾기 등 가능
 *                  
 *   3) 주어진 프로그램을 살펴보고 프로그램의 내용을 파악하라.
 *  
 *   4) 예제 12-6-1-2의 프로그램과 비교하여 버튼 배열 활용의 장점을 파악하라.   
 *    
 *   5) 프로그램을 수행하고 프로그램 결과를 확인하라.
 *      
 */
