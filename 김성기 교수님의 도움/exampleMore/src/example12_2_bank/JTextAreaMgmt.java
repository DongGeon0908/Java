package example12_2_bank;

import java.awt.*;

import javax.swing.*;

/**
 * [ JTextAreaMgmt] : JTextArea의 생성과 패널에 컴포넌트 배치를 용이하게 하기 위한 클래스
 */

public class JTextAreaMgmt {

	static int DEFALTCELLHEIGHT = 20;  // 테이블의 셀 높이 디폴트 값
	
	static int wDeltaForScrollPane = 3;
	static int hDeltaForScrollPane = 3;
	
	// title, attrnames, tuples가 주어지면 이를 panel에 배치
	static void  displayJTextAreaToPanel(JFrame frame, JPanel panel, String title, JTextArea ta) {				
		JScrollPane sc = getScrollPaneWithJTextArea(ta);  	// JTextArea 객체를 포함하는 JScrolPane 객체 구함

		PanelMgmt.displayComponents(frame, panel, title, sc);
	}
	
	// title, JTextArea의 너비와 높이  주어지면 JTextArea의 생성하여 JScrollPane에 넣고 panel에 배치
	static void displayJTextAreaToPanel(JFrame frame, JPanel panel, String title, int rows, int cols) {
	
		JTextArea ta = new JTextArea("", rows, cols);
		
		displayJTextAreaToPanel(frame, panel, title, ta);
	}


	// 주어진 JTextArea 객체를 포함하는 JScrollPane 객체 생성하여 반환
	//    이때, JScrollPane 객체 크기는 JTextArea 객체 크기보다 (+3, +3) 해야 깔끔하게 출력됨
	static JScrollPane getScrollPaneWithJTextArea(JTextArea ta) {
		JScrollPane sc = new JScrollPane(ta);  			// JTextArea 객체를 JScrolPane 객체에 배치

		Dimension d = getJTextAreaSizeForJScrollPane(ta);

		int w = d.width;
		int h = d.height;
		
		sc.setPreferredSize(new Dimension(w , h));		
		sc.setSize(w, h);      

		return sc;
	}
	
	static Dimension getJTextAreaSize(JTextArea ta) {
			Dimension d = ta.getPreferredSize();		
			ta.setSize(d);
			
			return d;
	}

	static Dimension getJTextAreaSizeForJScrollPane(JTextArea ta) {
		Dimension d = ta.getPreferredSize();
		
		return new Dimension(d.width + wDeltaForScrollPane, d.height + hDeltaForScrollPane);   // JScrollPane 객체 크기 설정: (+3, +3) 하면 JScrollPane에 깔끔하게 표시됨
	}
}
