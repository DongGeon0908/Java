package example12_2_bank;

import java.awt.*;

import javax.swing.*;

/**
 * [ JTextAreaMgmt] : JTextArea�� ������ �гο� ������Ʈ ��ġ�� �����ϰ� �ϱ� ���� Ŭ����
 */

public class JTextAreaMgmt {

	static int DEFALTCELLHEIGHT = 20;  // ���̺��� �� ���� ����Ʈ ��
	
	static int wDeltaForScrollPane = 3;
	static int hDeltaForScrollPane = 3;
	
	// title, attrnames, tuples�� �־����� �̸� panel�� ��ġ
	static void  displayJTextAreaToPanel(JFrame frame, JPanel panel, String title, JTextArea ta) {				
		JScrollPane sc = getScrollPaneWithJTextArea(ta);  	// JTextArea ��ü�� �����ϴ� JScrolPane ��ü ����

		PanelMgmt.displayComponents(frame, panel, title, sc);
	}
	
	// title, JTextArea�� �ʺ�� ����  �־����� JTextArea�� �����Ͽ� JScrollPane�� �ְ� panel�� ��ġ
	static void displayJTextAreaToPanel(JFrame frame, JPanel panel, String title, int rows, int cols) {
	
		JTextArea ta = new JTextArea("", rows, cols);
		
		displayJTextAreaToPanel(frame, panel, title, ta);
	}


	// �־��� JTextArea ��ü�� �����ϴ� JScrollPane ��ü �����Ͽ� ��ȯ
	//    �̶�, JScrollPane ��ü ũ��� JTextArea ��ü ũ�⺸�� (+3, +3) �ؾ� ����ϰ� ��µ�
	static JScrollPane getScrollPaneWithJTextArea(JTextArea ta) {
		JScrollPane sc = new JScrollPane(ta);  			// JTextArea ��ü�� JScrolPane ��ü�� ��ġ

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
		
		return new Dimension(d.width + wDeltaForScrollPane, d.height + hDeltaForScrollPane);   // JScrollPane ��ü ũ�� ����: (+3, +3) �ϸ� JScrollPane�� ����ϰ� ǥ�õ�
	}
}
