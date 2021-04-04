import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

/**
 * [ JFrameWithJTextArea]: 
 *     JTextArea를 JFrame 객체에 배치하고 1부터 1000 사이 소수 출력 
 *     
 *   o JTextArea 
 *     - 여러 라인의 문자열 입력하는 컴포넌트
 *     - TextArea는 데이터가 많아지면 크기가 변하는 컴포넌트
 *     - JScrollPane에 배치하면 크기가 커져도 문제 없음            
 */

// 대개 GUI 프로그램은 JFrame을 확장하는 하위 클래스로 JFrame 객체를 생성함
class Ex12_4_4_JFrameWithJTextArea extends JFrame {
	JTextArea ta = new JTextArea(""); 
	JScrollPane scrollPane = new JScrollPane(ta);  // ta를 배치하는 JScrollPane 객체

	Ex12_4_4_JFrameWithJTextArea(String title) {   // 객체 생성자: 윈도우 설정
		super(title);
		this.setLayout(null);        // 배치방식을 수동 배치로
		this.setLocation(500, 300);  // 윈도우를 (500, 300) 위치에 배치
		this.setSize(500, 350);      // 가로 500픽셀, 세로 350픽셀 크기로    
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 옵션 지정
	}

	void setupComponents() {   // 컴포넌트들 설정 메소드              
		// ta의 속성 설정
		ta.setBackground(Color.yellow);  // 색상명 이용하여 배경색 지정하기
		ta.setForeground(Color.blue);    // 색상명 이용하여 전경색 지정하기
		
		// scrollPane의 속성 설정  
		scrollPane.setLocation(100, 50); // (100, 30)의 위치에 배치
		scrollPane.setSize(300, 200);    // 가로 300픽셀, 세로 200픽셀 크기로
	}

	void addComponents() {   
		this.add(scrollPane);   // JFrame에 scrollPane 배치
	} 

	// from에서 to까지의 정수 중 소수를 구하여 텍스트 영역에 저장하는 메소드
	void addPrimeNo(int from, int to, int cntInLine) {
		ta.setText("    ** " + from +"에서 " + to + "까지의 소수들 **\n\n");;
		
		int cnt = 0;
		for (int i = from; i <= to; i++) {
			if (isPrimeNo(i)) {  // 소수이면   텍스트 영역의 끝에 추가
				ta.append("  " + i);

				if (++cnt % cntInLine == 0)   // cntInLine개씩 한 줄에 출력함
					ta.append("\n");
			}
		}
	}
	
	static boolean isPrimeNo(int n) {  // 주어진 n이 소수인지 판별하는 메소드
		if (n < 2)
			return false;
		
		for  (int i = 2; i < n; i++)
			if (n % i == 0)
				return false;
		return true;
	}

	public static void main(String[] args) {
		Ex12_4_4_JFrameWithJTextArea frame =          // 윈도우 생성 및 설정
				new Ex12_4_4_JFrameWithJTextArea("JFrameWithJTextArea");  
		
		frame.setupComponents();        // frame에 배치될 컴포넌트들의 속성 설정
		frame.addComponents();          // frame에 컴포넌트들을 배치  
		frame.addPrimeNo(1, 1000, 10);  // 1부터 1000 사이 소수를  텍스트 영역의 한 라인에 10개씩 저장하는 메소드 호출
	    frame.setVisible(true);         // frame을 setVisible(true)로 하면 윈도우가 나타남
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *   
 *   1) 이 프로그램은  텍스트 영역을 JScrollPane에 배치하고 텍스트 영역에 1부터 1000까지의 소수를  한 라인에 15개씩 저장한다.
 *   
 *   2) JScrollPane을 JFrame에 배치한 후 JFrame을 화면에 디스플레이시키면 텍스트 영역도 디스플레이된다. 
 *      
 *   3) 주어진 프로그램을 살펴보고 프로그램의 내용을 파악하라.
 *                 
 *   4) 프로그램을 수행하고 프로그램 결과를 확인하라.
 *   
 */
