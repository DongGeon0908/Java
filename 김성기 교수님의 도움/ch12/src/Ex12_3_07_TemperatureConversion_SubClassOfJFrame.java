// GUI 프로그래밍을 위한 import
import java.awt.*;
import javax.swing.*;        
       
/**
 * [ TemperatureConversion_SubClassOfJFrame ]: 
 *       화씨온도를 섭씨온도로 변환하여 출력하는 GUI 예제
 *       (JFrame의 하위 클래스로 작성, 입력 처리 않음)     
 *        
 *   o 온도 체계
 *     1) 섭씨온도(단위 C): 어는 온도: 0, 끓는 온도: 100 (100 등분시킨 온도체계)
 *     2) 화씨온도(단위 F): 어는 온도: 32, 끓는 온도: 212 (180 등분시킨 온도체계)
 *     3) 캘빈(Kelvin)온도(단위 K): -273.15C를 0K로 설정, 캘빈온도 0K 이하의 온도가 
 *                               없는 물리학에서 사용하는 절대 온도체계
 *       
 *   o 화씨온도에서 섭씨온도로의 변환
 *      C = (F - 32) * 5 / 9;
 *       
 *   o GUI 윈도우 생성과 컴포넌트 배치
 *     - 대개 입출력 화면은 가변 크기의 윈도우로 구성
 *     - 윈도우에 해당되는 클래스로 JFrame과 JDialog이 있으며, 이들은 최상위 컨테이너     
 *     - 윈도우에는 여러 입출력을 위한 컴포넌트(component)들이 화면 구성에 따라 적절히 배치
 *     - 컴포넌트 중의 일부는 입력을 위한 컴포넌트, 일부는 출력을 위한 컴포넌트, 일부는 입출력을 위한 컴포넌트로 배정 
 *         
 *   o 대표적 컴포넌트
 *     - 입력 컴포넌트: JButton, JList, JCheckBox, JMenuItem
 *     - 출력 컴포넌트: JLabel 
 *     - 입출력 컴포넌트: JTextField, JPanel, JTable
 *       
 *   o JFrame을 확장한 하위 클래스로 윈도우 작성
 *     - JFrame에 많은 컴포넌트 배치될 경우 JFrame의 하위 클래스로 윈도우 작성하는 것이 유리
 *     - 객체 지향적인 기법으로 클래스 작성 가능하며 배치되는 컴포넌트의 관리가 보다 용이
 *     
 *         class XxxFrame extends JFrame {
 *              << frame에 배치될 컴포넌트를 객체 필드로 선언 >>
 *              
 *              XxxFrame(String title) {  // 객체 생성자
 *                 super(title);
 *              }
 *              
 *              << 배치할 컴포넌트 생성 및 설정, 배치, 리스너 등록 등을 위한 코드 작성  >> 
 *          }
 */

// JFrame을 확장하는 하위 클래스로 윈도우 작성하기
class TemperatureConversionFrame extends JFrame  {

	// 프로그램 타이틀 출력을 위한 레이블 생성
	JLabel titleLB = new JLabel("Conversion of Fahrenheit to Centigrade");

	// 입력받을 화씨온도를 위한 프롬프트 메시지 레이블 및 텍스트필드 생성
	JLabel degreeToConvertLB = new JLabel("Fahrenheit degree to convert:");
	JTextField degreeToConvertTF = new JTextField(10);

	// 변환된 섭씨온도를 위한 레이블 및 텍스트필드 생성 
	JLabel degreeConvertedLB = new JLabel("Centigrade degree converted:");
	JTextField degreeConvertedTF = new JTextField(10);

	// 객체 생성자 - 필요한 컴포넌트를 배치할 윈도우 생성
	TemperatureConversionFrame(String title) {
		super(title);  // 상위 클래스인 JFrame의 객체 생성자를 반드시 호출해야 함
	}

	// 윈도우를 위한 설정 메소드
	void setupFrame() {   
		setLayout(new FlowLayout());  // 컴포넌트 배치 방식을 FlowLayout으로 
		setSize(330, 125);            // 가로 330픽셀, 세로 125픽셀 크기로
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 옵션 지정
	}

	// 윈도우에 필요한 컴포넌트를 추가하여 배치하는 메소드
	void addComponents() {   
		add(titleLB);  // 타이틀을 위한 레이블 추가  

		add(degreeToConvertLB);  // 입력받을 화씨온도를 위한 레이블 추가 
		add(degreeToConvertTF);  // 입력받을 화씨온도를 위한 텍스트필드 추가 

		add(degreeConvertedLB);  // 변환된 섭씨온도를 위한 레이블 추가 
		add(degreeConvertedTF);  // 변환된 섭씨온도를 위한 텍스트필드 추가
	}
}    

class Ex12_3_07_TemperatureConversion_SubClassOfJFrame {
	public static void main(String[] args) {
		TemperatureConversionFrame frame 
		       = new TemperatureConversionFrame("Temperature Conversion");
		frame.setupFrame();     // 윈도우 설정
		frame.addComponents();  // 컴포넌트들을 배치    
		frame.setVisible(true); // frame을 setVisible(true)로 하면 윈도우가 나타남 
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *   
 *   1) 주어진 프로그램을 살펴보고 프로그램의 내용을 파악하라.
 *      - TemperatureConversionFrame 클래스가 JFrame의 하위 클래스로 작성
 *      - 모든 컴포넌트들이 객체 필드에 저장되며, 모든 메소드가 객체 메소드로 작성
 *             
 *   2) 프로그램을 수행하고 결과를 확인하라.
 *   
 *   3) 이 프로그램은 화씨온도를 입력하여도 변환된 섭씨온도가 출력되지 않는다.
 *      그 이유는 입력 컴포넌트인 degreeToConvertTF 텍스트필드에 대한 이벤트 처리가 되지 않기 때문이다.
 *      Java에서 입력 처리를 위해서는 입력 컴포넌트에 대해 이벤트 처리가 되어야 한다.
 *  
 *  
 * [ 실습과제 ]
 *
 *   o 이름, 나이, 현위치를 입력하기 위한 GUI 프로그램을 PersonInfoFrame 클래스로 작성하려 한다.
 *      Ex12_3_4_JFrameOfGridLayout.java를 참조하여 PersonInfoFrame 클래스를 
 *      JFrmae 클래스의 하위 클래스로 작성하라.   
 */
