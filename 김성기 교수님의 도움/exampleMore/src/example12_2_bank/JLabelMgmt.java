package example12_2_bank;

import java.awt.*;

import javax.swing.*;

/**
 * [ JLabelMgmtMgmt] : �̹����� ���� JLabel ��ü ������ �гο� ������Ʈ ��ġ�� �����ϰ� �ϱ� ���� Ŭ����
 */

public class JLabelMgmt {

	static int DEFALTCELLHEIGHT = 20;  // ���̺��� �� ���� ����Ʈ ��
	static int wDeltaForScrollPane = 3;
	static int hDeltaForScrollPane = 3;
	
	static double ratioOfImageToPanel = 3 / 5.;  // �̹��� ���̺��� ��ġ�� �гο� ���� ����� ũ�� ����(���� 4/5�� ����)

	// JLabel ��ü �־����� �̸�  JScrollPane�� �ְ� panel�� ��ġ
	static void  displayJLabelToPanel(JFrame frame, JPanel panel, String title, JLabel la) {				
		JScrollPane sc = getScrollPaneWithJLabel(panel, la);  	// JLabel ��ü�� �����ϴ� JScrollPane ��ü ����		

		JComponent[][] comps = { { sc } };
		PanelMgmt.displayComponents(frame, panel, title, comps, null);
	}
	
	// �����̸��� �־�����  �־����� JLabel ��ü �����Ͽ� JScrollPane�� �ְ� panel�� ��ġ�ϴ� �޼ҵ�
	static void displayImageJLabelToPanel(JFrame frame, JPanel panel, String title, String filename) {		
		JLabel la = new JLabel(new ImageIcon(filename));
		
		JScrollPane sc = getScrollPaneWithJLabel(panel, la);
		
		displayJLabelToPanel(frame, panel, title, la);
	}
	
	// JLabel ��ü �־����� �̸�  ������ JScrollPane�� ũ�⸦ ���Ͽ� ��ȯ�ϴ� �޼ҵ�
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

	// �־��� JLabel ��ü�� �����ϴ� JScrollPane ��ü �����Ͽ� ��ȯ
	//    �̶�, JScrollPane ��ü ũ��� JLabel ��ü ũ�⺸�� (+3, +3) �ؾ� ����ϰ� ��µ�
	static JScrollPane getScrollPaneWithJLabel(JPanel panel, JLabel la) {
		JScrollPane sc = new JScrollPane(la);  			// JLabel ��ü�� JScrollPane ��ü�� ��ġ
		
		Dimension d = getJLabelSizeForScrollPane(panel, la);
		
		sc.setPreferredSize(d);		
		sc.setSize(d);      

		return sc;
	}
	
	// �־��� filename�� JLabel ��ü �����Ͽ� JScrollPane ��ü�� ���Խ�Ų ��  JScrollPane��ü ��ȯ
	//    �̶�, JScrollPane ��ü ũ��� JLabel ��ü ũ�⺸�� (+3, +3) �ؾ� ����ϰ� ��µ�
	static JScrollPane getScrollPaneWithJLabel(JPanel panel, String filename) {
		JLabel la = new JLabel(new ImageIcon(filename));
		
		return getScrollPaneWithJLabel(panel, la);
	}

	
	static Dimension getJLabelSize(JLabel la) {
			Dimension d = la.getSize();		
			
			return d;
	}
}
