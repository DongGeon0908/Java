// GUI 프로그래밍을 위한 import
import java.awt.*;
import javax.swing.*;

// 이벤트 처리를 위한 import
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * [ TemperatureConversion_GUIEvent_SetupComponent ]: 
 *        화씨온도를 섭씨온도로 변환하여 출력하는 GUI 예제(컴포넌트의 속성 설정)
 *             
 *   o 컨테이너 컴포넌트
 *     - 다른 컴포넌트를 배치할 수 있는 컴포넌트
 *     - 최상위 컨테이너와 종속 컨테이너로 구분됨
 *     - 최상위 컴포넌트: 다른 컨테이너에 배치되지 않고서 스크린에 디스플레이될 수 있는 컨테이너
 *          JFrame, JDialog
 *          
 *     - 종속 컨테이너: 다른 컨테이너에 배치되어야만 스크린에 디스플레이될 수 있는 컨테이너
 *          JPanel, JScrollPane
 *       
 *   o 컴포넌트들의 속성 설정을 위한 메소드
 *     - public void setSize(int width, int height) : 가로와 세로 크기를 설정
 *     - public void setLocation(int x,  int y) : 좌표 (x, y) 위치에 배치
 *     - public void setBackground(Color c) : 배경색을 주어진 색상으로 설정
 *     - public void setForeground(Color c) : 전경색을 주어진 색상으로 설정
 *     - public void setFont(Font f) : 이 컴포넌트의 폰트를 설정
 *     - public void setEnabled(boolean b) : 입력에 대해 반응할 수 있거나 없게 함
 *     - public void setFocusable(boolean b) : 포커스를 받을 수 있거나 없게 함 
 *     - public void setVisible(boolean b) : 디스플레이 되게 하거나 사라지게 함 
 */

class Ex12_2_1_TemperatureConversion_GUIEvent_SetupComponent  {
	// 필요한 컴포넌트를 배치할 윈도우 생성
	static JFrame frame = new JFrame("Temperature Conversion");

	// 프로그램 타이틀 출력을 위한 레이블 생성
	static JLabel titleLB = new JLabel("Conversion of Fahrenheit to Centigrade");

	// 입력받을 화씨온도를 위한 프롬프트 메시지 레이블 및 텍스트필드  생성
	static JLabel degreeToConvertLB = new JLabel("Fahrenheit degree to convert:");
	static JTextField degreeToConvertTF = new JTextField(10);

	// 변환된 섭씨온도를 위한 레이블 및 텍스트필드 생성 
	static JLabel degreeConvertedLB = new JLabel("Centigrade degree converted:");
	static JTextField degreeConvertedTF = new JTextField(10);

	// 윈도우를 위한 frame 설정 메소드
	static void setupFrame() {   
		frame.setLayout(new FlowLayout());  // 컴포넌트 배치 방식을 FlowLayout으로 
		frame.setSize(330, 125);            // 가로 330픽셀, 세로 125픽셀 크기로
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 옵션 지정
		
		frame.getContentPane().setBackground(new Color(230, 130, 230));  // RGB 값을 이용하여 배경색 지정하기
		frame.setLocation(500, 300);       // 윈도우를 (500, 300) 위치의 화면 중앙쪽으로 배치 
	}
	
	// 컴포넌트들 설정 메소드
	static void setupComponents() {     
		// titleLB의 속성 설정
		titleLB.setOpaque(true);  // ** JLabel의 배경색, 전경색을 변경하려면 true로 설정해야 함 **
		titleLB.setBackground(Color.pink);     // 소문자 색상명을 이용하여 배경색 지정하기
		titleLB.setForeground(Color.BLUE);     // 대문자 색상명을 이용하여 전경색 지정하기
		titleLB.setFont(new Font("신명조", Font.ITALIC, 17));  // (신명조체, 이탤릭, 크기 17)로 폰트 지정
	
		// degreeToConvertLB의 속성 설정
		degreeToConvertLB.setOpaque(true);     // ** JLabel의 배경색을 변경하려면 true로 설정해야 함 **
		degreeToConvertLB.setBackground(Color.yellow);
		degreeToConvertLB.setFont(new Font("고딕", Font.PLAIN, 14));  // (고딕체, 일반 폰트, 크기 14)로 폰트 지정

		// degreeConvertedLB의 속성 설정
		degreeConvertedLB.setOpaque(true);     // ** JLabel의 배경색을 변경하려면 true로 설정해야 함 **
		degreeConvertedLB.setBackground(Color.yellow);
		
		degreeToConvertLB.setFont(new Font("Times New Roman", Font.PLAIN, 14));  // (Times, 일반 폰트, 크기 14)로 폰트 지정
		
		degreeToConvertTF.setBackground(Color.cyan);		
		degreeToConvertTF.setFocusable(true);  // setFocusable(true)는 포커스를 가질 수 있게 함
		
		degreeConvertedTF.setBackground(Color.cyan);
		degreeConvertedTF.setEnabled(true);     //setEnabled(true)로 하면 입력받을 수 있게 함       
		degreeConvertedTF.setFocusable(false);  // setFocusable(false)는 포커스 가질 수 없게 함 - 입력도 불가
	}
	
	// 윈도우에 필요한 컴포넌트를 추가하여 배치하는 메소드 
	static void addComponents() {   
		frame.add(titleLB);  // 타이틀을 위한 레이블 추가  

		frame.add(degreeToConvertLB);  // 입력받을 화씨온도를 위한 레이블 추가 
		frame.add(degreeToConvertTF);  // 입력받을 화씨온도를 위한 텍스트필드 추가 

		frame.add(degreeConvertedLB);  // 변환된 섭씨온도를 위한  레이블 추가 
		frame.add(degreeConvertedTF);  // 변환된 섭씨온도를 위한 텍스트필드 추가
	}

	// 윈도우를 디스플레이에 나타나게 하고 입력을 기다리게 하는 메소드
	//  입력이 발생하면 이벤트 객체가 생성되고 등록된 이벤트 리스너에 의해 처리됨   
	static void showFrame() {
		frame.setVisible(true);   // frame을 setVisible(true)로 하면 윈도우가 나타남       
	}

	// 화씨온도 입력받는 텍스트필드 degreeToConvertTF에서 화씨온도 입력되면   
	//   이를 처리하기 위한 이벤트 리스너 객체 등록시키는 메소드
	//   degreeToConvertTF 객체에서 키보드 입력되면 KeyEvent 객체 생성되고  
	//   등록된 KeyListener 객체의 이벤트 처리 메소드가 자동적으로 호출되면서 KeyEvent 객체가 매개변수로 전달됨
	static void enrolEventListener() {
		KeyListener listener = new MyKeyListener();  // 리스너 객체 생성
		degreeToConvertTF.addKeyListener(listener);  // 리스너 객체를 등록시킴
	}

	// KeyListener 인터페이스를 구현하는 이벤트 리스너 클래스(static nested 클래스)
	//   이 클래스는 KeyListener 인터페이스의 3개 abstract 메소드를 구현해야 하며,
	//   키 입력이 완료된 후 자동적으로 호출되는 KeyReleased()를 이용하여 입력처리
	static class MyKeyListener implements KeyListener {
		String prevTF = "";  // 이전에 입력된 화씨온도 문자열을 저장하는 필드
		
		public void keyPressed(KeyEvent e) {}  // 이 메소드는 사용하지 않음    
		public void keyTyped(KeyEvent e) {}    // 이 메소드는 사용하지 않음 

		// 키보드에서 키 입력이 한 번씩 완료되면 자동적으로 호출되는 메소드임
		// 입력된 문자열을 검토하여 정상적인 실수 화씨온도이면 섭씨로 변환하여 출력
		public void keyReleased( KeyEvent e ) {
			String tf = degreeToConvertTF.getText(); // 입력된 화씨온도 문자열을 얻음

			try {
				// 입력된 문자열이 정상적인 실수 화씨온도이면 이를 섭씨온도로 변환하여 출력
				double degreeToConvert = Double.parseDouble(tf);          // 문자열을 실수로 변환하는 메소드
				double degreeConverted = (degreeToConvert - 32) * 5 / 9;  // 화씨를 섭씨로 변환
				
				degreeConvertedTF.setText(String.valueOf( 
						(long) (degreeConverted * 10000) / 10000.) );     // 변환된 섭씨온도를 출력
				
				prevTF = tf;
			}
			catch(Exception ex) {
				// Double.parseDouble()로 문자열을 실수로 변환 시 예외 발생하면 예외를 처리함
				if (tf.equals("") || tf.equals("-") || tf.equals(".")) {  // 새로운 화씨온도 입력 시작이면
					degreeConvertedTF.setText("");                        // 기존 섭씨온도 부분을 지움
					prevTF = tf;
				}
				else {
					degreeToConvertTF.setText(prevTF); // 화씨온도 부분을 이전 문자열로 대체시킴
					
					if (prevTF.equals("") || prevTF.equals("-") || prevTF.equals(".")) {  // 새로운 화씨온도 입력 시작이면
						degreeConvertedTF.setText("");                                    // 기존 섭씨온도 부분을 지움
					}
				}
			}
		}
	}
		
	public static void main(String[] args) {
		setupFrame();         // 윈도우 설정
		setupComponents();    // 컴포넌트들 속성 설정
		addComponents();      // 컴포넌트들을 배치  
		enrolEventListener(); // degreeToConvertTF에 이벤트 리스너 객체를 등록 
		showFrame();          // 윈도우를 나타나게 하고 입력을 기다림
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *   
*   1) 주어진 프로그램을 살펴보고 프로그램의 내용을 파악하라.
 *      - 이 프로그램은 윈도우 생성, 크기 가로 330 픽셀, 세로 125 픽셀로 설정, 종료 버튼 추가
 *      - 화씨온도 입력 위해 프롬프트 메시지 출력할 레이블과 입력 텍스트 필드를 윈도우에 추가  
 *      - 종료 버튼 클릭하면 윈도우 사라지며 프로그램도 종료
 *      - 변환된 섭씨온도 출력 위해 프롬프트 메시지 출력할 레이블과 텍스트 필드를 윈도우에 추가     
 *               
 *   2) 이 프로그램은 화씨온도를 입력하면 변환된 섭씨온도가 출력된다. 
 *      - 그 이유는 입력 컴포넌트인 degreeToConvertTF 텍스트필드에 대한 이벤트 처리가 되었기 때문
 *      - Java에서 입력 처리를 위해 입력 컴포넌트에 대해 이벤트 처리되어야 함
 *      
 *   3) setupFrame() 메소드와 setupComponents() 메소드에 여러 속성을 설정하는 작업이 추가되어
 *      스크린에 디스플레이되는 윈도우의 외양이 달라진다.
 *   
 * 
 * [ 실습과제 ]
 *
 *   1) 이 프로그램의 setupFrame() 메소드와 setupComponents() 메소드의 속성을 
 *      다음과 같이 변경하여 윈도우의 외양이 달자지는 것을 확인하라.
 *       
 *      - 윈도우의 크기를 (900, 700)으로 변경하라.
 *      - 윈도우의 배경색을 Color.white로 변경하라.
 *      - titleLB의 배경색을 new Color(200, 200, 200)으로, 전경색을 new Color(20, 20, 20)으로 변경하라.
 *      
 *   2) 색상을 색상 이름으로 표현하는 것은 Color.WHITE, Color.white, CoLor.BLACK, Color.black 등 여러 가지가 있다.
 *      Java에서 지원하는 색상 이름을 알아보고 이를 이용하여 각 컴포넌트의 색상을 변경해보라.     
 */
     