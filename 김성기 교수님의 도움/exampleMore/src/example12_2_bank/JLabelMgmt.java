package example12_2_bank;

import java.awt.*;

import javax.swing.*;

/**
 * [ JLabelMgmtMgmt] : 이미지를 갖는 JLabel 객체 생성과 패널에 컴포넌트 배치를 용이하게 하기 위한 클래스
 */

public class JLabelMgmt {

	static int DEFALTCELLHEIGHT = 20;  // 테이블의 셀 높이 디폴트 값
	static int wDeltaForScrollPane = 3;
	static int hDeltaForScrollPane = 3;
	
	static double ratioOfImageToPanel = 3 / 5.;  // 이미지 레이블을 배치할 패널에 대한 상대적 크기 비율(현재 4/5로 설정)

	// JLabel 객체 주어지면 이를  JScrollPane에 넣고 panel에 배치
	static void  displayJLabelToPanel(JFrame frame, JPanel panel, String title, JLabel la) {				
		JScrollPane sc = getScrollPaneWithJLabel(panel, la);  	// JLabel 객체를 포함하는 JScrollPane 객체 구함		

		JComponent[][] comps = { { sc } };
		PanelMgmt.displayComponents(frame, panel, title, comps, null);
	}
	
	// 파일이름이 주어지면  주어지면 JLabel 객체 생성하여 JScrollPane에 넣고 panel에 배치하는 메소드
	static void displayImageJLabelToPanel(JFrame frame, JPanel panel, String title, String filename) {		
		JLabel la = new JLabel(new ImageIcon(filename));
		
		JScrollPane sc = getScrollPaneWithJLabel(panel, la);
		
		displayJLabelToPanel(frame, panel, title, la);
	}
	
	// JLabel 객체 주어지면 이를  포함할 JScrollPane의 크기를 구하여 반환하는 메소드
	static Dimension getJLabelSizeForScrollPane(JPanel panel, JLabel la) {
		Icon icon = la.getIcon();
		
		String t = la.getText();
				
		if (icon == null)
			return la.getSize();
		
		int wIcon = icon.getIconWidth();
		int hIcon = icon.getIconHeight();
		
		int wPanel = panel.getWidth();
		int hPanel = panel.getHeight();
		
		int wRelativeToPanel = (int) (wPanel * ratioOfImageToPanel);
		int hRelativeToPanel = (int) (hPanel * ratioOfImageToPanel);
		
		int w = wIcon;
		int h = hIcon;	

		Dimension  d = new Dimension(w + wDeltaForScrollPane, 
				h + hDeltaForScrollPane);
		
		return d;
	}

	// 주어진 JLabel 객체를 포함하는 JScrollPane 객체 생성하여 반환
	//    이때, JScrollPane 객체 크기는 JLabel 객체 크기보다 (+3, +3) 해야 깔끔하게 출력됨
	static JScrollPane getScrollPaneWithJLabel(JPanel panel, JLabel la) {
		JScrollPane sc = new JScrollPane(la);  			// JLabel 객체를 JScrollPane 객체에 배치
		
		Dimension d = getJLabelSizeForScrollPane(panel, la);
		
		sc.setPreferredSize(d);		
		sc.setSize(d);      

		return sc;
	}
	
	// 주어진 filename의 JLabel 객체 생성하여 JScrollPane 객체에 포함시킨 후  JScrollPane객체 반환
	//    이때, JScrollPane 객체 크기는 JLabel 객체 크기보다 (+3, +3) 해야 깔끔하게 출력됨
	static JScrollPane getScrollPaneWithJLabel(JPanel panel, String filename) {
		JLabel la = new JLabel(new ImageIcon(filename));
		
		return getScrollPaneWithJLabel(panel, la);
	}

	
	static Dimension getJLabelSize(JLabel la) {
			Dimension d = la.getSize();		
			
			return d;
	}
}
