import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import java.util.Arrays;  // 문자 배열 간의 비교를 위해 import

/**
 * [ JFrameWithJTextField_JPasswordField]: 
 *    JTextField와 JPasswordField를 JFrame 객체에 배치하고 아이디와 패스워드 입력하여 "1234"와 비교
 *    
 *   o JTextField와 JPasswordField
 *     - 한 라인의 문자열 입력하는 컴포넌트
 *     - TextField와 JPasswordField는 거의 같은 기능 가짐
 *     - 단, TextField는 입력되는 문자 표시되며, JPasswordField는 입력되는 문자 숨겨짐
 *     
 *   o TextField와 JPasswordField의 입력된 문자열 가져오기
 *     - public String getText() : JTextField에서 입력된 문자열 가져오는 메소드
 *     - public char[] getPassword() :JPasswordField에서 입력된 문자열 가져오는 메소드
 *     
 *     - Java의 문자열은 변경 불가하여 패스워드를 문자열로 저장하면 내용을 사용 후 지울 수 없으며, 
 *       문자열은 쓰레기가 수집될 때까지 JVM에 남으므로 해킹의 위험 있음
 *     - 그러므로 JPasswordField 값은  String으로 가져오지 않고 문자 배열로 가져옴
 *     - 패스워드를 사용 후 반드시 문자 배열의 내용을 지우는 것이 권장 사항임 
 *     
 *   o 문자 배열 비교하기
 *     - 문자 배열의 내용이 같은가를 검사하는 메소드: Java.util.Arrays 클래스의 equals() 메소드 사용     
 *     - equals() 메소드는  java.util 패키지의 Arrays 클래스의 클래스 메소드로, 
 *       매개변수인 2 문자 배열의 내용이 같으면 true, 아니면 false를 반환
 *        
 *           public static boolean equals(char[] a, char[] a2)      
 *            
 *   o TextField에 JPasswordField에 문자열 저장
 *     - public void setText(String s) : TextField에 JPasswordField에 문자열 저장하는 메소드             
 */

// GUI 프로그램은 JFrame을 확장하는 하위 클래스로 JFrame 객체를 생성함
class Ex12_4_3_JFrameWithJTextField_JPasswordField extends JFrame {
	JLabel labelLoginID = new JLabel ("로그인 아이디:");    // 텍스트 갖는 레이블 생성
	JLabel labelPassword = new JLabel("패스워드         :");   // 텍스트 갖는 레이블 생성

	JTextField tfLoginID = new JTextField(10);           // 20 문자 입력 가능한 텍스트 필드 생성
	JPasswordField pfPassword = new JPasswordField(10);  // 20 문자 입력 가능한 패스워드 필드 생성

	JButton btConfirm = new JButton(" 확인 ");             // 텍스트 갖는 버튼 생성

	// 객체 생성자: 윈도우를 위한 설정
	Ex12_4_3_JFrameWithJTextField_JPasswordField(String title) { 
		super(title);

		this.setSize(250, 150);         // 가로 250픽셀, 세로 150픽셀 크기로
		this.setLocation(420, 220);     // 윈도우를 (420, 220) 위치에 배치
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 옵션 지정

		this.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));  // 컴포넌트 배치방식을 flow layout으로 
	}

	// 윈도우에 필요한 컴포넌트를 추가하여 배치하는 메소드
	void addComponents() {   
		this.add(labelLoginID);
		this.add(tfLoginID);
		this.add(labelPassword);
		this.add(pfPassword);
		this.add(btConfirm);
	}

	// JButton 객체에 버튼 이벤트 리스너 객체를 등록시키는 메소드
	//  JButton 객체에서 마우스 클릭이 되면  
	//  등록된 Button_Listener 객체의 이벤트 메소드가 자동적으로 호출되면서 MouseEvent 객체가 매개변수로 전달됨
	void enrolEventListener() {
		// 익명 클래스를 사용하여 리스너 객체 생성
		MouseAdapter listener = new MouseAdapter() {
			// mousePressed() 메소드는 마우스 클릭이 완료된 후  자동적으로 호출되는 메소드
			// 로그인 아이디와 패스워드에 모두 1234 입력되었는가 확인
			public void mousePressed(MouseEvent e) { 
				Object src = e.getSource();  // 이벤트 발생한 소스를 구함
				if (src == btConfirm) {      // 입력 이벤트 발생 소스가 btConfirm 버튼이면
					String loginId = tfLoginID.getText();        // tfLoginID의 입력  텍스트를 가져와 문자열에 저장
					char[] password = pfPassword.getPassword();  // pfPassword의 입력  텍스트를 가져와 문자 배열에 저장
					
					// 입력된 아이디와 패스워드를 "1234"와 비교, 
					//   패스워드 비교는 문자 배열 동등 비교 메소드인 Arrays 클래스의 equals() 메소드 사용
					if (loginId.equals("1234") && Arrays.equals(password, "1234".toCharArray()))
						JOptionPane.showMessageDialog(null, "올바른 로그인 아이디와 패스워드가 입력됨");
					else
						JOptionPane.showMessageDialog(null, "잘못된 로그인 아이디 또는 패스워드가 입력됨");					
				}
			}
		}; // 리스너 객체 생성의 끝

		btConfirm.addMouseListener(listener);  // 리스너 객체 등록시킴
	}
    
	public static void main(String[] args) {
		Ex12_4_3_JFrameWithJTextField_JPasswordField frame =    
				new Ex12_4_3_JFrameWithJTextField_JPasswordField("JTextField_JPasswordField");  // 윈도우 생성 및 설정
		
		frame.addComponents();      // frame에 컴포넌트들을 배치  
		frame.enrolEventListener(); // 버튼에 리스너 등록시킴
	    frame.setVisible(true);     // frame을 setVisible(true)로 하면 윈도우가 나타남
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *   
 *   1) 이 프로그램은 JTextField에 로그인 아이디를, JPasswordField에 패스워드를 입력하고 
 *      입력된 로그인 아이디와 패스워드가 "1234"과 "1234"이면 "올바른 로그인 아이디와 패스워드가 입력됨" 메시지를, 
 *      아니면 "잘못된 로그인 아이디 또는 패스워드가 입력됨" 메시지를 출력한다.
 *      
 *      로그인 성공 또는 실패를 나타내기 위해서는 JOptionPane을 사용한다.
 *      
 *      아직 이벤트 처리를 배우지 않았지만 개략적인 방법을 익히도록 한다.
 *      
 *   2) 입력된 패스워드는 보안 강화를 위해 String이 아닌 문자 배열로 처리ehlsek.
 *   
 *      - << char[] password = pfPassword.getPassword(); >>에서 입력된 패스워드를 문자 배열로 가져옴
 *      
 *      - << java.util.Arrays.equals(password, "1234".toCharArray()) >>에서 ”1234”를 
 *        문자배열로 변환하여 equals() 메소드 사용하여 동일 여부 비교
 *        
 *      - equals() 메소드는  java.util 패키지의 Arrays 클래스의 클래스 메소드로, 
 *        매개변수인 2 문자 배열의 내용이 같으면 true, 아니면 false를 반환
 *        
 *            public static boolean equals(char[] a, char[] a2)  
 *            
 *   3) 주어진 프로그램을 살펴보고 프로그램의 내용을 파악하라.
 *                 
 *   4) 프로그램을 수행하고 프로그램 결과를 확인하라.
 */