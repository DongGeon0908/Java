import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * [ Calculator5_Desktop ]: 탁상용 계산기를 구현하는 GUI 프로그램
 * 
 *   o 계산 결과 출력하는 텍스트필드와 16개의 키로 화면 구성
 *   
 *   o 첫 번째 피연산자, 연산자, 두 번째 피연산자의 입력에 따라 적절한 처리를 수행
 *   
 *   o 16개의 버튼에 대해 Action 이벤트 리스너로 이벤트 처리
 *
 *   o 소스 코드 잘 분석하여 이해할 수 있도록 노력할 것
 */

class Calculator5_Desktop extends JFrame  {

	// 계산기를 구성하는 컴포넌트들 선언
	private JPanel keyPadPanel = new JPanel();          // 키 버튼과 계산결과 텍스트필드 배치할 패널
	private JTextField resultTF = new JTextField(20);   // 계산결과 디스플레이할 텍스트필드
	private JButton keyButtons[]  = new JButton[16];    // 16개 키 버튼
	
	// 처리를 위한 변수들 선언
	String keyNames[] = {"1", "2", "3", "+", "4", "5", "6", "-", "7", "8", "9", "*", ".", "0", "=", "/" };
	private double result  = 0.0;                       // 결과 저장하는 변수
	private boolean isFirstOperand = true;              // 첫 번째 피연산자 입력이면 true, 아니면 false인 변수
	static boolean mustTextFieldCleared= true;          // 결과 텍스트가 지워져야 하는가 나타내는 변수
	private int operator = 0;                       // 마지막으로 눌라진 연산자 저장

	// 객체 생성자: 컴포넌트 배치 및 설정, 이벤트 객체 등록, 화면에 보이기 등 수행
	public Calculator5_Desktop() {
		setTitle("계산기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new BorderLayout());                // JFrame 객체를 Border 레이아웃으로 설정		

		add(resultTF, BorderLayout.NORTH);            // 계산결과 텍스트필드를 북쪽에 배치
		resultTF.setEditable(false);                  // 결과출력 텍스트필드에 입력하지 못하도록 설정

		add(keyPadPanel, BorderLayout.CENTER);        // 키패드 패널을 중앙에 배치

		//16개 키 배치할 키패드 패널을 4 * 4 grid layout으로 설정
		keyPadPanel.setLayout(new GridLayout(4, 4));

		// 16 키 버튼 생성하여 키패드 패널에 배치
		for (int i = 0; i < 16; i++) {
			keyButtons[i] = new JButton(keyNames[i]); // 키 버튼 생성
			keyPadPanel.add(keyButtons[i]);           // 키패드 패널에 키 버튼 배치
		}

		MyActionListener listener = new MyActionListener();  // 키 버튼을 위한 Action 리스너 객체 생성
		for ( int i = 0; i < 16; i++) {
			keyButtons[i].addActionListener(listener);       // 키 버튼에 Action 리스너 객체 등록
		}
		
		setBounds(300, 200, 220, 220);   // JFrame 객체의 크기와 위치 설정
		
		setVisible(true);                // 생성된 JFrame 객체를 화면에 나타나게 함
	}

	//  Action 이벤트 처리하는 리스너 클래스(내부 클래스로 작성)
    //   Action 리스너의 이벤트 처리 메소드는  actionPerformed() 하나임
	class MyActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// 입력된 키가 처리될 때까지 for 문을 반복
			for ( int i = 0; i < 16 ; i++) {
				JButton bt = (JButton) e.getSource();
				
				if( bt == keyButtons[i]) {  // 키가  찾아지면
					processKey(i);
				}
			}
		}

		// 눌러진 키에 대해 처리하는 메소드
		void processKey(int keyNo) {			
			switch(keyNo) {
			// 숫자 키 및 .(period) 키 입력 시의 처리
			case 0:   case 1:   case 2:   case 4:   case 5:              // 1, 2, 3, 4, 5
			case 6:   case 8:   case 9:   case 10:  case 12:  case 13:   // 6, 7, 8, 9, ., 0

				if(mustTextFieldCleared) {   // 처음으로 숫자 키 클릭되면 기존 텍스트필드 내용을 지움
					resultTF.setText("");
					mustTextFieldCleared = false;
				}

				// 텍스트필드의 내용 뒤에 입력된 숫자를 출력
				resultTF.setText(resultTF.getText() + keyButtons[keyNo].getText());					

				break;

				// 연산자 입력 시의 처리
			case 3:  case 7:  case 11: case 14: case 15: // 더하기, 빼기, 곱하기, = , 나누기

				// mustTextFieldCleared 변수를 true로 하여 다음 숫자 키 클릭 시 텍스트필드를 지우게 함
				mustTextFieldCleared = true;

				if (isFirstOperand) {  // 첫 피연산자 입력되었으면, 다음 피연산자를 기다리게 함	
					// 텍스트필드 값을 result 변수에 저장함
					if(resultTF.getText().length() == 0) 
						result = 0.0;
					else
						result = Double.valueOf(resultTF.getText());

					if (keyNo == 14)  // = 버튼이면 result를 텍스트필드에 출력
						resultTF.setText(toString(result));

					isFirstOperand = false;
					operator = keyNo; // 입력된 연산자의 인덱스를 operator 변수에 저장
				}
				else { // 두 번째 피연산자가 입력되었으면, result, operator, 텍스트필드의 값으로 계산하여 결과 출력	

					switch(operator) {
					case 3: // 더하기
						result += Double.valueOf(resultTF.getText());
						break;

					case 7: // 빼기
						result -= Double.valueOf(resultTF.getText());
						break;

					case 11: // 곱하기
						result *= Double.valueOf(resultTF.getText());
						break;

					case 15: // 나누기
						result /= Double.valueOf(resultTF.getText());
						break;

					case 14: // =
						result = Double.valueOf(resultTF.getText());
						break;

					}

					resultTF.setText(toString(result)); // 결과를 텍스트필드에 출력

					if (keyNo == 14)          // = 연산자이면  isFirstOperand를 true로 
						isFirstOperand = true;
					else
						operator = keyNo;     // 아니면 입력된 연산자의 인덱스를 operator 변수에 저장
				}

				break;
			}
		}

		// double 타입의 값을 문자열로 변환하는 메소드
		//  소수점 이하값이 없으면 정수 문자열로 변환함
		String toString(double d) {
			String s = "";

			if (d == (int) d)      // 소수점 이하값이 없으면 
				s = s + (int) d;   //   정수 문자열로 변환
			else
				s = s + d;

			return s;
		}		
	}
}

class Ex12_6_5_Calculator5_Desktop {
	public static void main(String[] args)  {
		System.out.println("Starting Calculator...");
		new Calculator5_Desktop();
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *   
 *   1) 16개 키가 부착된 키패드를 이용하여 탁상용 계산기를 구현하였다.
 *      - 숫자키와 . 키가 클릭되면 왼쪽 피연간자와 오른쪽 피연산자를 구분시켜 처리할 수 있게 함
 *      - 왼쪽 피연산자가 입력되면 연산자를 기다리도록 처리
 *      - 오른쪽 피연산자 입력되면 이전의 저장시킨 연산자로 연산 수행하여 연산결과 구해 결과 텍스트필드에 디스플레이
 *      - 연산자 키가 클릭되면 오른쪽 피연산자 후 계산할 수 있도록 연산자를 저장함
 *     
 *   2) 구체적인 처리 과정은 다소 복잡하므로 소스 코드를 잘 읽어보면서 이해해야 한다.
 *               
 *   3) 주어진 프로그램을 살펴보고 프로그램의 내용을 파악하라.  
 *   
 *   4) 프로그램을 수행하고 프로그램 결과를 확인하라.      
 */ 
