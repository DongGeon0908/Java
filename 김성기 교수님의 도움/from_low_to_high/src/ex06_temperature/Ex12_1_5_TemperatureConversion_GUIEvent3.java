package ex06_temperature;
import java.awt.*;

import javax.swing.*;        

import java.awt.event.*;


/*
 * [ TemperatureConversion_GUI ]: GUI로 작성된, 화씨 온도를 섭씨 온도로 변환하여 출력하는 프로그램
 *                                (입력 처리를 함)
 *        
 *     o 온도 체계
 *       1) 섭씨온도(단위 C): 어는 온도: 0, 끓는 온도: 100 (100 등분시킨 온도체계)
 *       2) 화씨온도(단위 F): 어는 온도: 32, 끓는 온도: 212 (180 등분시킨 온도체계)
 *       3) 캘빈(Kelvin)온도(단위 K): -273.15C를 0K로 설정, 캘빈온도 0K 이하의 온도가 없는 물리학에서 사용하는 절대 온도체계
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

class Ex12_1_5_TemperatureConversion_GUIEvent3  {
	// 필요한 컴포넌트를 배치할 윈도우 생성
	static JFrame frame = new JFrame("Temperature Conversion 3");

	// 프로그램 타이틀 출력을 위한 레이블 생성
	static JLabel titleLB = new JLabel("    Conversion of Fahrenheit and Centigrade    ");

	// 입력받을 화씨온도를 위한 프롬프트 메시지 레이블 및 텍스트필드  생성
	static JLabel fahrenheitLB = new JLabel("Fahrenheit degree:");
	static JTextField fahrenheitTF = new JTextField(10);

	// 변환된 섭씨온도를 위한 레이블 및 텍스트필드 생성 
	static  JLabel centigradeLB = new JLabel("Centigrade degree:");
	static JTextField centigradeTF = new JTextField(10);

	static JButton toCentigradeBt = new JButton("to Centigrade");
	static JButton toFahrenheitBt = new JButton("to Fahrenheit");
	static JButton resetBt = new JButton("   reset   ");

	// 윈도우를 위한 frame 설정 메소드
	static void Fahrenheit() {   
		frame.setLayout(new FlowLayout());  // 컴포넌트 배치 방식을 FlowLayout으로 
		frame.setSize(350, 250);            // 가로 330픽셀, 세로 125픽셀 크기로
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 옵션 지정		
	}

	// 윈도우를 위한 frame 설정 메소드
	static void setupFrame() {   
		frame.setLayout(new FlowLayout());  // 컴포넌트 배치 방식을 FlowLayout으로 
		frame.setSize(330, 190);            // 가로 330픽셀, 세로 125픽셀 크기로
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 옵션 지정	
	}


	// 컴포넌트 설정 메소드
	static void setupComponents() {   
		toCentigradeBt.setSize(50, 250);  // toCentigradeBt 크기 설정 
		toFahrenheitBt.setSize(50, 150);  // toFahrenheitBt 크기 설정  
	}

	// 윈도우에 필요한 컴포넌트를 추가하여 배치하는 메소드
	static void addComponents() {   
		frame.add(titleLB);  // 타이틀을 위한 레이블 추가  

		frame.add(fahrenheitLB);  // 입력받을 화씨온도를 위한 레이블 추가 
		frame.add(fahrenheitTF);  // 입력받을 화씨온도를 위한 텍스트필드 추가 

		frame.add(centigradeLB);  // 변환된 섭씨온도를 위한  레이블 추가 
		frame.add(centigradeTF);  // 변환된 섭씨온도를 위한 텍스트필드 추가		

		frame.add(toCentigradeBt);  // 섭씨온도로 변환 버튼 추가 
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
	//  이 클래스는 MouseAdapter의 mousePressed() 메소드를오버라이딩함
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
 *   1) 주어진 프로그램을 살펴보고 프로그램의 내용를 파악하라.
 *      - 이 프로그램은 윈도우를 생성하고  크기를 가로 330픽셀, 세로 125픽셀 크기로 픽셀로 설정하며, 
 *        종료 버튼을 클릭하면 윈도우가 사리지며 프로그램도 종료된다.
 *      - 화씨온도를 입력받기 위하여 프롬프트 메시지를 출력할 레이블과 텍스트 필드를 윈도우에 추가한다.  
 *      - 변환된 섭씨온도를 출력하기 위하여 프롬프트 메시지를 출력할 레이블과 텍스트 필드를 윈도우에 추가한다.   
 *             
 *   2) 이 프로그램은 화씨 온도를 입력하면 변환된 섭씨 온도가 출력된다. 
 *      그 이유는 입력받는 컴포넌트인 fahrenheitTF 텍스트필드에 대한 이벤트 처리가 되었기 때문이다.
 *      Java에서 입력에 대한 처리를 위해서는 입력 컴포넌트에 대해 이벤트 처리가 되어야 한다.
 *      
 *   3) fahrenheitTF 텍스트필드에 대한 이벤트 처리는 3가지 과정으로 구성된다.
 *      (1) KeyListener 인터페이스를 구현하는 이벤트 리스너 클래스(내부 클래스)인 
 *          fahrenheitTF_Listener 클래스 작성
 *          
 *          여기에서 keyReleased( KeyEvent e ) 메소드 작성이 중요하며, 이 메소드는 입력된 화씨온도 문자열을 
 *          가져와서 입력을 처리함
 *          
 *      (2) 이벤트 리스너 객체를 생성
 *          KeyListener listener = new fahrenheitTF_Listener(); // 리스너 객체 생성		
 *      
 *      (3) 이벤트 리스너 객체를 fahrenheitTF에 등록
 *          fahrenheitTF.addKeyListener(listener);  // 리스너 객체를 등록시킴
 *  
 * [ 실습과제 ]
 *
 *   1) 이 프로그램은 화씨온도를 섭씨온도로 변환하여 출력하는 GUI 프로그램이다.
 *      반대로 섭씨온도를  입력하여 화씨온도로 변환하여 출력하는 프로그램을 
 *      Pr12_1_3_TemperatureConversion_GUIEvent_CtoF 클래스로 작성하라. 
 *      (섭씨온도 C를 화씨온도 F로 변환하는 공식은 F = C * 9 / 5  + 32 임)
 *   
 *   2) 이 프로그램은 화씨온도를 섭씨온도로 변환하여 출력한다. 화씨 온도를 캘빈 온도로 
 *      변환하여 출력하는 프로그램을 Pr12_1_3_TemperatureConversion_GUIEvent_CtoK 클래스로 작성하라.  
 *      (섭씨온도 C를 캘빈온도 K로 변환하는 공식은 K = C + 273.15이며, 
 *       화씨온도에서 섭씨온도를 구한 후 다시 섭씨온도에서 캘빈온도를 구해 출력하면 됨) 
 */