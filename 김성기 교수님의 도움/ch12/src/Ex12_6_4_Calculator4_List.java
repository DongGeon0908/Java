import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

/**
 * [ Calculator4_List ]: JList를 이용하여 4칙 연산 수행하는 GUI 프로그램
 * 
 *   o JList  
 *     - 여러 아이템을 디스플레이시키고 한 아이템을 선택할 수 있게 하는 컴포넌트
 *     - 배열 또는 Vector에 저장된 원소들을 리스트의 아이템으로 포함시킬 수 있음
 */

public class Ex12_6_4_Calculator4_List extends JFrame {
	
	JTextField tf1, tf2, tfRes;  // 왼쪽 피연산자, 오른쪽 피연산자, 결과를 저장할 텍스트 필드
	String[] oprSigns = { " + ", " - ", " * ", " / " };

	JList listOprs;

	// 객체 생성자: 컴포넌트 배치 및 설정, 이벤트 객체 등록, 화면에 보이기 등 수행
	Ex12_6_4_Calculator4_List() {
		setTitle("계산기 - List 이용");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new FlowLayout());

		add(tf1 = new JTextField("1234", 10)); // 초기값 "1234", 크기 10인 텍스트필드

		listOprs = new JList(oprSigns);
		add(listOprs);
		
		MyListSelectionListener slistener = new MyListSelectionListener();
		listOprs.addListSelectionListener(slistener);

//		MyMouseListener mlistener = new MyMouseListener();
//		listOprs.addMouseListener(mlistener);

		add(tf2 = new JTextField("2345", 10)); // 초기값 "2345", 크기 10인 텍스트필드
		add(new JLabel("  =  "));
		add(tfRes = new JTextField("", 10));   // 초기값 "", 크기 10인 텍스트필드

		setBounds(500, 400, 450,150);		
		
		setVisible(true);     // 생성된 JFrame 객체를 화면에 나타나게 함
	}

	public static void main(String [] args) {
		new Ex12_6_4_Calculator4_List();
	}

	// ListSelectionListener 구현하는 ListSelection 리스너(내부 클래스로 작성)
	class MyListSelectionListener implements ListSelectionListener {
		
		// 리스트 아이템을 선택하면 호출되는 이벤트 처리 메소드를 구현함
		public void valueChanged(ListSelectionEvent e) {
			JList l = (JList) e.getSource();// 선택된 버튼 객체 구함

			String opr = (String) l.getSelectedValue(); // 리스트에서 선택된 아이템을 구함 
			
			int index = l.getSelectedIndex() ;         //  선택된 리스트 아이템의 인덱스 번호를 가져옴
			System.out.println("선택된 아이템 = " + opr + ", 인덱스 = " + index );


			try {
				// tf1과 tf2에 입력된 정수값을 가져와 선택 연산자에 따라 결과를 계산하여 tfRes에 출력
				int op1 = Integer.parseInt(tf1.getText());
				int op2 = Integer.parseInt(tf2.getText());

				tfRes.setText(" " + getResult(op1, index, op2));

			}
			catch(Exception ex) {
				JOptionPane.showMessageDialog(null, " Error: " + ex.getMessage(), "계산기에서의 오류", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	// MouseAdapter를 확장하는  Mouse 리스너
	class MyMouseListener extends  MouseAdapter {
		public void mouseClicked(MouseEvent e) { 				
			JList l = (JList) e.getSource();// 선택된 버튼 객체를 구함

			try {			// tf1과 tf2에 입력된 정수값을 가져와 선택 연산자에 따라 결과를 계산하여 tfRes에 출력
				int op1 = Integer.parseInt(tf1.getText());
				int op2 = Integer.parseInt(tf2.getText());


				int oprIndex = l.getSelectedIndex();   // 선택상태인 아이템의 인덱스 번호를 가져옴
				tfRes.setText(" " + getResult(op1, oprIndex, op2));
			}
			catch(Exception ex) {
				JOptionPane.showMessageDialog(null, " Error: " + ex.getMessage(), "정수 입력에서의 오류", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
		
	// 왼쪽 피연산자, 연산자 번호(0: 더하기, 1: 빼기, 2: 곱하기, 3; 나누기), 오른쪽 피연산자가 주어지면 계산하여 결과 반환하는 메소드
	int getResult(int op1, int opr, int op2) { 
		int res  = 0;

		if (opr == 0) res = op1 + op2;
		else if (opr == 1) res =  op1 - op2;
		else if (opr == 2) res =  op1 * op2;
		else if (opr == 3) res =  op1 / op2;

		return res;			
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *   
 *   1) 리스트를 이용하여 4칙 연산 수행한다.
 *      - 리스트의 객체 생성자, 속성 설정 메소드, 발생 가능한 이벤트와 리스너 객체 등록 방법 등을 이해할 것   
 *      - 특히, 리스트는 여러 아이템을 갖도록 객체 생성이 이루어져야 함을 확인할 것
 *     
 *   2) 리스트는 Mouse 이벤트, ListSelection 이벤트 발생시키므로 이들을 위한 리스너 객체 등록이 가능하다.
 *      ListSelection 이벤트 클래스 작성방법과 여러 리스트 아이템 중 선택된 아이템을 찾는 방법을 확인하라. 
 *               
 *   3) 주어진 프로그램을 살펴보고 프로그램의 내용을 파악하라.  
 *   
 *   4) 프로그램을 수행하고 프로그램 결과를 확인하라.  
 */
