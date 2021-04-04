import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * [ Calculator3_ComboBox ]: JComboBox를 이용하여 4칙 연산 수행하는 GUI 프로그램
 * 
 *   o JComboBox  
 *     - 여러 아이템을 팝업 리스트에 포함시키고 한 아이템을 선택할 수 있게 하는 컴포넌트
 *     - 배열 또는 Vector에 저장된 원소들을 팝업 리스트의 아이템으로 포함시킬 수 있음
 */

public class Ex12_6_3_Calculator3_ComboBox extends JFrame {
	
	JTextField tf1, tf2, tfRes;  // 왼쪽 피연산자, 오른쪽 피연산자, 결과를 저장할 텍스트 필드
	String[] oprSigns = { " + ", " - ", " * ", " / ", "" };

	JComboBox cbOprs;
	
	// 객체 생성자: 컴포넌트 배치 및 설정, 이벤트 객체 등록, 화면에 보이기 등 수행
	Ex12_6_3_Calculator3_ComboBox() {
		setTitle("계산기  - JComboBox 이용");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

		add(tf1 = new JTextField("1234", 7)); // 초기값 "1234", 창 크기 7인 텍스트필드

		cbOprs = new JComboBox(oprSigns);	
		cbOprs.setSelectedIndex(4);          // 선택된 연산자를 ""로 설정함
		add(cbOprs);
				
		ActionListener alistener = new MyActionListener();  // Action 리스너 객체 생성하여 등록
		cbOprs.addActionListener(alistener);	

//		ItemListener ilistener = new MyItemListener();      // Item 리스너 객체 생성하여 등록
//		cbOprs.addItemListener(ilistener);	

		add(tf2 = new JTextField("2345", 7));    // 초기값 "2345", 크기 7인 텍스트필드
		add(new JLabel("  =  "));
		add(tfRes = new JTextField(" ", 7));     // 초기값 "", 크기 7인 텍스트필드

		setBounds(500, 400, 450,90);		
		
		setVisible(true);    // 생성된 JFrame 객체를 화면에 나타나게 함
	}

	public static void main(String [] args) {
		new Ex12_6_3_Calculator3_ComboBox();
	}

	// ActionListener를 구현하는 Action 리스너 클래스(내부 클래스로 작성)
	//   Action 리스너의 이벤트 처리 메소드는 actionPerformed() 하나임
	class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JComboBox cb = (JComboBox) e.getSource();  // e.getSource() 메소드는 선택된 콤보박스 객체 구함
			
			String opr = (String)cb.getSelectedItem(); // 콤보박스에서 선택된 아이템을 구함 
			int index = cb.getSelectedIndex() ;        // 콤보박스에서 선택된 아이템의 인덱스를 구함 
			System.out.println("선택된 아이템의 인덱스 = " + index + ", opr= " + opr );
			
			try {		
				int op1 = Integer.parseInt(tf1.getText());
				int op2 = Integer.parseInt(tf2.getText());
				
				if (index <= 3)         // 선택된 아이템이  " + ", " - ", " * ", " / " 하나이면
					tfRes.setText(" " + getResult(op1, index, op2));  // 연산 결과 구해 출력
				else
					tfRes.setText("");  // dummy 연산 결과 "" 출력
			}
			catch(Exception ex) {
				JOptionPane.showMessageDialog(null, " Error: " + ex.getMessage(), "계산기에서의 오류", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
		
	// ItemListener를 구현하는 Item 리스너  클래스
	class MyItemListener implements ItemListener {
		
		// 아이템을 선택하면 호출되는 이벤트 처리 메소드를 구현함
		public void itemStateChanged(ItemEvent e) {
			JComboBox cb = (JComboBox) e.getSource();  // e.getSource() 메소드는 선택된 콤보박스 객체 구함
			
			String opr = (String) cb.getSelectedItem(); // 콤보박스에서 선택된 아이템을 구함 
			
			int index = cb.getSelectedIndex() ;        // 콤보박스에서 선택된 아이템의 인덱스를 구함 
			System.out.println("선택된 아이템의 인덱스 = " + index + ", opr= " + opr );
			
			try {		
				int op1 = Integer.parseInt(tf1.getText());
				int op2 = Integer.parseInt(tf2.getText());
				
				if (index <= 3)        // 선택된 아이템이  " + ", " - ", " * ", " / " 하나이면
					tfRes.setText(" " + getResult(op1, index, op2));  //연산 결과 구해 출력
				else
					tfRes.setText(""); // dummy 연산 결과 "" 출력
			}
			catch(Exception ex) {
				JOptionPane.showMessageDialog(null, " Error: " + ex.getMessage(), "계산기에서의 오류", JOptionPane.ERROR_MESSAGE);
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
 *   1) 콤보박스를 이용하여 4칙 연산 수행한다.
 *      - 콤보박스의 객체 생성자, 속성 설정 메소드, 발생 가능한 이벤트와 리스너 객체 등록 방법 등을 이해할 것   
 *      - 특히, 콤보박스는 여러 아이템을 갖도록 객체 생성이 이루어져야 함을 확인할 것
 *     
 *   2) 콤보박스는 Action 이벤트, Item 이벤트 발생시키므로 이들을 위한 리스너 객체 등록이 가능하다.
 *      Item 이벤트 클래스 작성방법과 여러 콤보박스 아이템 중 선택된 아이템을 찾는 방법을 확인하라. 
 *               
 *   3) 주어진 프로그램을 살펴보고 프로그램의 내용을 파악하라.  
 *     
 *   4) 프로그램을 수행하고 프로그램 결과를 확인하라.
 */