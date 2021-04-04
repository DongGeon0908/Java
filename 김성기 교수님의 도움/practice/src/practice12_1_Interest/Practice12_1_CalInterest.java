package practice12_1_Interest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * [ 12장 실습과제 1번 기본 프로그램 ]
 * 
 *   1. 이자 구하기의 미완성된 코드 완성하기
 *   
 *      주어진 GUI와 같이 원금(principal)과 연 이자율(rate, 퍼센트 값으로 0부터 100까지 정수)을 입력하여 "이자 계산" 버튼이
 *      클릭되면 원금에 대한 연 이자(interest)를 계산하여 출력하는 Java 프로그램의 미완성 부분을 작성하라.
 */

public class Practice12_1_CalInterest extends JFrame {
	JTextField principalTF, rateTF, interestTF; 	// 원금, 이자율, 이자 위한 텍스트 필드
	JLabel principalLB, rateLB, interestLB;  		// 텍스트 필드 설명하기 위한 레이블
	JButton OKBt;                      				// "이자 계산: 확인 버튼

	Practice12_1_CalInterest() {
		setTitle("Calculating Interest");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());

		// (1) JFrame에 컴포넌트 배치하고 리스너 객체 등록하는 코드 작성하라.

		setSize(480,110);   
		setVisible(true);
	}

	// ActionListener 구현하는 Action 리스너 작성
	class CalActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// (2) principalTF, rateTF에 입력된 정수값 가져와 이자 계산하여 
			//      interestTF에 출력하는 코드 작성하라.
		} 
	}

	public static void main(String[] args) {
		new Practice12_1_CalInterest();
	}
}
