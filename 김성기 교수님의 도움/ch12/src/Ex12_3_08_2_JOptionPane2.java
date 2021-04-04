import java.awt.*;
import javax.swing.*;    

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * [ JOptionPane2 ]: JOptionPane의 사용법을 보여주는 예제
 *        
 *   o JOptionPane
 *     - 값을 입력하거나 정보를 출력하기 위해 표준 대화상자를 팝업시키는 편리한 방법을 제공하는 클래스
 *       
 *   o JOptionPane의 주요 메소드
 *     - public static String showInputDialog(Object message) : 
 *           message를 출력한 후 사용자 입력 받아 문자열로 반환
 *           
 *     - public static int showConfirmDialog(Component parent, Object msg, 
 *           String title, int optionType): title과 msg 출력하고 optionType에 따른 입력을 정수로 반환
 *           
 *     - public static void showMessageDialog(Component  parent, Object msg): msg 출력
 *     
 *     - public static void showMessageDialog(Component parent, Object msg, 
 *           String title, int optionType): title 출력하고 optionType에 따른 msg 출력   
 *              
 *     - 모두 static 메소드이므로 객체 생성하지 않고 클래스 이름으로 호출 가능
 *             
 *   o 모달 유형(modal type)의 대화상자 작동방식
 *     - JOptionPane의 메소드가 호출되면 대화 상자가 생성되어 화면에 나타남
 *     - JOptionPane 대화상자의 작업이 완료될 때까지 Java 프로그램은 대기
 *     - 이러한 방식의 대화상자 작동방식을 모달 유형(modal type)이라 함              
 */

// JFrame을 확장하는 하위 클래스로 윈도우 작성하기
class FrameForJOptionPane extends JFrame  {
	JButton showInputBt = new JButton("show input");
	JButton showConfirmBt = new JButton("show Confirm");
	JButton showMessageBt = new JButton("show Message");
	
	JLabel outputLb = new JLabel("LabelForJOptionPane");
	
	// 객체 생성자 - 필요한 컴포넌트를 배치할 윈도우 생성
	FrameForJOptionPane(String title) {
		super(title);  // 상위 클래스인 JFrame의 객체 생성자를 반드시 호출해야 함
	}

	// 윈도우를 위한 설정 메소드
	void setupFrame() {   
		setLayout(new FlowLayout(FlowLayout.CENTER, 10, 15));  // 컴포넌트 배치 방식을 FlowLayout으로 
		setLocation(600, 500);
		setSize(400, 125);            // 가로 330픽셀, 세로 125픽셀 크기로
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 옵션 지정
	}

	// 윈도우에 필요한 컴포넌트를 추가하여 배치하는 메소드
	void addComponents() {   

		outputLb.setOpaque(true);  // ** JLabel의 배경색을 변경하려면 true로 설정해야 함 **
		outputLb.setBackground(Color.yellow);
		
		add(showInputBt); 
		add(showConfirmBt);
		add(showMessageBt); 		
		add(outputLb); 
	}
	
	// JButton 객체에 버튼 이벤트 리스너 객체를 등록시키는 메소드
	//  JButton 객체에서 마우스 클릭이 되면  
	//  등록된 Button_Listener 객체의 이벤트 메소드가 자동적으로 호출되면서 MouseEvent 객체가 매개변수로 전달됨
	void enrolEventListener() {
		// 무명 클래스를 사용하여 리스너 객체 생성
		MouseAdapter listener = new MouseAdapter() {
			// mousePressed() 메소드는 마우스 클릭이 완료된 후  자동적으로 호출되는 메소드임
			// 입력된 문자열을 검토하여 정상적인 실수 온도이면 다른 온도로 변환하여 출력
			public void mousePressed(MouseEvent e) { 
				Object src = e.getSource();         // 이벤트 발생한 소스를 구함
			
				if (src == showInputBt) {           // 입력 이벤트 발생 소스가  showInputBt 버튼이면
					String name = JOptionPane.showInputDialog(null, "이름을 입력하시오");  
					outputLb.setText("이름: " + name);					
				}
				else if (src == showConfirmBt) {    // 입력 이벤트 발생 소스가 showConfirmBt 버튼이면
					int yes_or_no = JOptionPane.showConfirmDialog(null, "당신은 남성입니까?", 
							                                "Confirm그Dialog", JOptionPane.YES_NO_OPTION);  
					if (yes_or_no == JOptionPane.YES_OPTION) 
						outputLb.setText("당신은  남성입니다");
					else if (yes_or_no == JOptionPane.NO_OPTION) 
						outputLb.setText("당신은 여성입니다");
					else
						outputLb.setText("선택되지 않았습니다.");
				}
				else if (src == showMessageBt) {    // 입력 이벤트 발생 소스가 showMessageBt 버튼이면
					JOptionPane.showMessageDialog(null, "JOptionPane.showMessageDialog의 결과", 
							                                  "MessageDialog", JOptionPane.PLAIN_MESSAGE);     
				}
			}
		}; // 리스너 객체 생성

		showInputBt.addMouseListener(listener);    // 리스너 객체를 등록시킴
		showConfirmBt.addMouseListener(listener);  // 리스너 객체를 등록시킴
		showMessageBt.addMouseListener(listener);  // 리스너 객체를 등록시킴
	}
}
      
class Ex12_3_08_2_JOptionPane2 {
	public static void main(String[] args) {
		FrameForJOptionPane frame = new FrameForJOptionPane("JOptionPane 예제");
		
		frame.setupFrame();          // 윈도우 설정
		frame.addComponents();       // 컴포넌트들을 배치    
		frame.enrolEventListener();  // 이벤트 리스너 객체 등록
		frame.setVisible(true);      // frame을 setVisible(true)로 하면 윈도우가 나타남 
	}  
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *   
 *   1) 주어진 프로그램을 살펴보고 프로그램의 내용을 파악하라.
 *      - 3개의 버튼을 배치한 후 클릭된 버튼에 따라 다른 JOptionPane을 실행하여 결과를 보여줌      
 *             
 *   2) 프로그램을 수행하고 결과를 확인하라.     
 */