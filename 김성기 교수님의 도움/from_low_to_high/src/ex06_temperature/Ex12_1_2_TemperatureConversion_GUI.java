package ex06_temperature;
import java.awt.*;

import javax.swing.*;        

/*
 * [ TemperatureConversion_GUI ]: GUI로 작성된, 화씨 온도를 섭씨 온도로 변환하여 출력하는 프로그램
 *                                (입력 처리를 하지 않음)
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
 */

class Ex12_1_2_TemperatureConversion_GUI  {
	// 필요한 컴포넌트를 배치할 윈도우 생성
	static JFrame frame = new JFrame("Temperature Conversion");

	// 프로그램 타이틀 출력을 위한 레이블 생성
	static JLabel titleLB = new JLabel("Conversion of Fahrenheit to Centigrade");

	// 입력받을 화씨온도를 위한 프롬프트 메시지 레이블 및 텍스트필드  생성
	static JLabel degreeToConvertLB = new JLabel("Fahrenheit degree to convert:");
	static JTextField degreeToConvertTF = new JTextField(10);

	// 변환된 섭씨온도를 위한 레이블 및 텍스트필드 생성 
	static  JLabel degreeConvertedLB = new JLabel("Centigrade degree converted:");
	static JTextField degreeConvertedTF = new JTextField(10);

	// 윈도우를 위한 frame 설정 메소드
	static void setupFrame() {   
		frame.setLayout(new FlowLayout());  // 컴포넌트 배치 방식을 FlowLayout으로 
		frame.setSize(330, 125);            // 가로 330픽셀, 세로 125픽셀 크기로
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 옵션 지정
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

	public static void main(String[] args) {
		setupFrame();     // 윈도우 설정
		addComponents();  // 컴포넌트들을 배치    
		showFrame();      // 윈도우를 나타나게 하고 입력을 기다림
	}
}


/*
 * [ 프로그램의 이해 및 실행 ]
 *   
 *   1) 주어진 프로그램을 살펴보고 프로그램의 내용를 파악하라.
 *      - 이 프로그램은 윈도우를 생성하고  크기를 가로 330 픽셀, 세로 125 픽셀로 설정하며, 종료 버튼을 추가한다.
 *      - 화씨온도를 입력받기 위하여 프롬프트 메시지를 출력할 레이블과 텍스트 필드를 윈도우에 추가한다.  
 *      - 변환된 섭씨온도를 출력받기 위하여 프롬프트 메시지를 출력할 레이블과 텍스트 필드를 윈도우에 추가한다.       
 *             
 *   2) 프로그램을 수행하고 결과를 확인하라라.
 *   
 *   3) 이 프로그램은 화씨 온도를 입력하여도 변환된 섭씨 온도가 출력되지 않는다.
 *      그 이유는 입력받는 컴포넌트인 degreeToConvertTF 텍스트필드에 대한 이벤트 처리가 되지 않기 때문이다.
 *      Java에서 입력에 대한 처리를 위해서는 입력 컴포넌트에 대해 이벤트 처리가 되어야 한다.
 *      
 *      예제 12-1-3은 degreeToConvertTF 텍스트필드에 대한 이벤트 처리가 되는 프로그램이다.
 *  
 *  
 * [ 실습과제 ]
 *
 *   1) 이 프로그램은 화씨온도를 섭씨온도로 변환하여 출력하기 위해 작성된 GUI 프로그램이다.
 *      반대로 섭씨온도를 입력하여 화씨온도로 변환하여 출력하기 위한 프로그램을 
 *      Pr12_1_2_TemperatureConversion_GUI_CtoF 클래스로 작성하라. 
 *      (이 프로그램도 역시 화씨 온도를 입력하여도 섭씨 온도는 출력되지 않게 한다.)
 *   
 *   2) 이 프로그램은 화씨온도를 섭씨온도로 변환하여 출력하기 위해 작성되었다. 
 *      화씨 온도를 캘빈 온도로  변환하여 출력하기 위한 프로그램을 
 *      Pr12_1_2_TemperatureConversion_GUI_ 클래스로 작성하라.  
 *      (이 프로그램도 역시 화씨 온도를 입력하여도 캘빈 온도는 출력되지 않게 한다.) 
 */