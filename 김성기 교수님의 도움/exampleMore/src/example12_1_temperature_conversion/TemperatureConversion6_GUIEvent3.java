package example12_1_temperature_conversion;

import java.awt.*;
import javax.swing.*;        
import java.awt.event.*;

/**
 * [ TemperatureConversion6_GUIEvent3 ]: 
 *      GUI로 작성된, 화씨온도를 섭씨온도로, 섭씨온도를 화씨온도로 변환하여 출력하는 프로그램(입력 처리 함)
 *        
 *     o 온도 체계
 *       1) 섭씨온도(단위 C): 어는 온도: 0, 끓는 온도: 100 (100 등분시킨 온도체계)
 *       2) 화씨온도(단위 F): 어는 온도: 32, 끓는 온도: 212 (180 등분시킨 온도체계)
 *       3) 캘빈(Kelvin)온도(단위 K): -273.15C를 0K로 설정, 캘빈온도 0K 이하의 온도가 없는 
 *                                 물리학에서 사용하는 절대 온도체계
 *       
 *     o 화씨온도에서 섭씨온도로의 변환
 *       C = (F - 32) * 5 / 9;
 *       
 *     o GUI의 윈도우 생성과 컴포넌트 배치
 *       - 대개 입출력 화면은 가변 크기의 윈도우로 구성됨
 *       - 윈도우에 해당되는 클래스로 JFrame과 JDialog이 있으며, 이를 최상위 컨테이너라고 함       
 *       - 윈도우에는 여러 입출력을 위한 컴포넌트(component)들이 화면 구성에 따라 적절히 배치
 *       - 컴포넌트 중의 일부는 입력을 위한 컴포넌트, 일부는 출력을 위한 컴포넌트, 일부는 입출력을 위한 컴포넌트로 배정 
 *       
 *     o 대표적 컴포넌트
 *       - 입력 컴포넌트: JButton, JList, JCheckBox, JMenuItem, JScrollBar
 *       - 출력 컴포넌트: JLabel
 *       - 입출력 컴포넌트: JTextField, JPanel,JTable
 *       
 *     o 입력 처리를 위한 3가지 과정   
 *       1) 이벤트 리스너 클래스 작성
 *       2) 이벤트 리스너 클래스의 객체 생성 및 참조
 *       3) 이벤트 리스너 객체를 입력 컴포넌트에 등록
 */

class TemperatureConversion6_GUIEvent3  {
	// 필요한 컴포넌트를 배치할 윈도우 생성
	static JFrame frame = new JFrame("Temperature Conversion 6");

	// 프로그램 타이틀 출력을 위한 레이블 생성
	static JLabel titleLB = new JLabel("    Conversion of Fahrenheit and Centigrade    ");
	static JLabel dummyLB1 = new JLabel("         ");
	static JLabel dummyLB2 = new JLabel("         ");
	
	// 입력받을 화씨온도를 위한 프롬프트 메시지 레이블 및 텍스트필드  생성
	static JLabel fahrenheitLB = new JLabel("  Fahrenheit degree:");
	static JTextField fahrenheitTF = new JTextField(10);

	// 변환된 섭씨온도를 위한 레이블 및 텍스트필드 생성 
	static  JLabel centigradeLB = new JLabel("Centigrade degree:");
	static JTextField centigradeTF = new JTextField(10);

	static JButton toCentigradeBt = new JButton("to Centigrade");
	static JButton toFahrenheitBt = new JButton("to Fahrenheit");
	static JButton resetBt = new JButton("   reset   ");

	// 윈도우를 위한 frame 설정 메소드
	static void setupFrame() {   
		frame.setLayout(new FlowLayout());  // 컴포넌트 배치 방식을 FlowLayout으로 
		frame.setSize(400, 170);            // 가로 400픽셀, 세로 170픽셀 크기로
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 옵션 지정	
	}

	// 컴포넌트 설정 메소드
	static void setupComponents() {   
		toCentigradeBt.setSize(50, 250);  // toCentigradeBt 크기 설정 
		toFahrenheitBt.setSize(50, 150);  // toFahrenheitBt 크기 설정  
	}

	// 윈도우에 필요한 컴포넌트를 추가하여 배치하는 메소드
	static void addComponents() {   
		frame.add(dummyLB1);  // 타이틀을 위한 레이블 추가  
		frame.add(titleLB);  // 타이틀을 위한 레이블 추가  
		frame.add(dummyLB2);  // 타이틀을 위한 레이블 추가  

		frame.add(fahrenheitLB);  // 입력받을 화씨온도를 위한 레이블 추가 
		frame.add(fahrenheitTF);  // 입력받을 화씨온도를 위한 텍스트필드 추가 
		frame.add(toCentigradeBt);  // 섭씨온도로 변환 버튼 추가 

		frame.add(centigradeLB);  // 변환된 섭씨온도를 위한  레이블 추가 
		frame.add(centigradeTF);  // 변환된 섭씨온도를 위한 텍스트필드 추가		
		frame.add(toFahrenheitBt);  // 화씨온도로 변환 버튼 추가 

		frame.add(resetBt);         // reset 버튼 추가 
	}

	// 윈도우를 디스플레이에 나타나게 하고 입력을 기다리게 하는 메소드
	//  입력이 발생하면 이벤트 객체가 생성되고 등록된 이벤트 리스너에 의해 처리됨   
	static void showFrame() {
		frame.setVisible(true);   // frame을 setVisible(true)로 하면 윈도우가 나타남       
	}

	// 화씨온도를 입력받는 텍스트필드 fahrenheitTF에서 화씨온도가 입력되면   
	//  이를 처리하기 위해 이벤트 리스너 객체를 등록시키는 메소드
	//  JButton 객체에서 마우스 클릭이 되면  
	//  등록된 Button_Listener 객체의 이벤트 메소드가 자동적으로 호출되면서 MouseEvent 객체가 매개변수로 전달됨
	static void enrolEventListener() {
		Button_Listener listener = new Button_Listener(); // 리스너 객체 생성
		toCentigradeBt.addMouseListener(listener);  // 리스너 객체를 등록시킴
		toFahrenheitBt.addMouseListener(listener);  // 리스너 객체를 등록시킴
		resetBt.addMouseListener(listener);  // 리스너 객체를 등록시킴
	}

	// MouseAdapter를 확장하는 버튼 이벤트 리스너 클래스(내부 클래스)
	//  이 클래스는 MouseAdapter의 mousePressed() 메소드를 오버라이딩함
	//  마우스 클릭이 완료된 후 자동적으로 호출되는  mousePressed()를 이용하여 입력처리
	static class Button_Listener extends MouseAdapter {
		// mousePressed() 메소드는 마우스 클릭이 완료된 후  자동적으로 호출되는 메소드임
		// 입력된 문자열을 검토하여 정상적인 실수 온도이면 다른 온도로 변환하여 출력
		public void mousePressed(MouseEvent e) { 
			JTextField degreeToConvertTF = null;
			JTextField degreeConvertedTF = null;

			String tf ="";

			double degreeToConvert = 0;   // 입력온도 저장하는 변수
			double degreeConverted = 0;   // 변환된 온도 저장하는 변수

			Object src = e.getSource();  // 이벤트 발생한 소스를 구함
			if (src == resetBt) {           // 입력 이벤트 발생 소스가 reset 버튼이면
				fahrenheitTF.setText("");   //   화씨온도 부분을 지움
				centigradeTF.setText("");   //   섭씨온도 부분을 지움
				return;
			}
			else if (src == toCentigradeBt) {       // 입력 이벤트 발생 소스가 섭씨온도 변환 버튼이면
				degreeToConvertTF = fahrenheitTF;   //   입력 텍스트필드를 화씨온도 텍스트필드로 설정
				degreeConvertedTF = centigradeTF;   //   변환된 텍스트필드를 섭씨온도 텍스트필드로 설정
			}
			else if (src == toFahrenheitBt) {       // 입력 이벤트 발생소스가  화씨온도 변환 버튼이면
				degreeToConvertTF = centigradeTF;   //   입력 텍스트필드를 섭씨온도 텍스트필드로 설정
				degreeConvertedTF = fahrenheitTF;   //   변환된 텍스트필드를 화씨온도 텍스트필드로 설정			
			}

			tf = degreeToConvertTF.getText(); // 입력된 온도 문자열을 얻음

			try {
				// 입력된 문자열이 정상적인 실수 온도이면 요구되는 온도로 변환하여 출력
				degreeToConvert = Double.parseDouble(tf);          // 문자열을 실수로 변환하는 메소드

				if (src == toCentigradeBt)
					degreeConverted = (degreeToConvert - 32) * 5 / 9; // 화씨를 섭씨로 변환
				else if (src == toFahrenheitBt)
					degreeConverted = degreeToConvert * 9 / 5 + 32;   // 섭씨를 화씨로 변환

				degreeConvertedTF.setText(String.valueOf( 
						(long) (degreeConverted * 10000) / 10000.) );    // 변환된 온도 출력				
			}
			catch(Exception ex) {
				JOptionPane.showMessageDialog(null, "'"+ tf + "' : 잘못된 실수");
			}
		}
	}
	
	public static void main(String[] args) {
		setupFrame();         // 윈도우 설정
		setupComponents();    // 컴포넌트들을 설정
		addComponents();      // 컴포넌트들을 배치  
		enrolEventListener(); // fahrenheitTF에 이벤트 리스너 객체를 등록 
		showFrame();          // 윈도우를 나타나게 하고 입력을 기다림
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *   
 *   1) 이 프로그램은 화씨온도와 섭씨온도 간 온도변환하여 출력하는 GUI 프로그램이다.
 *   
 *   2) 프로그램을 실행하여 결과 확인하라.
 *   
 *   3) 전체 프로그램의 구조와 이벤트 처리에 대해 개략적으로 파악하라.
 */
