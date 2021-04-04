package example12_2_bank;

import java.awt.*;

import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.table.*;


/**
 * [ JTableMgmt ] : JTable�� ������ �гο� ������Ʈ ��ġ�� �����ϰ� �ϱ� ���� Ŭ����
 */

public class JTableMgmt {

	static int DEFALTCELLHEIGHT = 20;  // ���̺��� �� ���� ����Ʈ ��
	static int wDeltaForScrollPane = 3;
	static int hDeltaForScrollPane = 5;

	// title, attrnames, tuples�� �־����� �̸� panel�� ��ġ
	static void  displayJTableToPanel(JFrame frame, JPanel panel, String title, String[] attrnames, Object[][] tuples) {
		JTable table = setupJTable(attrnames, tuples);
		
		JScrollPane sc = getScrollPaneWithJTable(table);  	// JTable ��ü�� �����ϴ� JScrolPane ��ü ����

		PanelMgmt.displayComponents(frame, panel, title, sc);
	}

	// title, attrnames, tuples, alignments�� �־����� �̸� panel�� ��ġ
	static void  displayJTableToPanel(JFrame frame, JPanel panel, String title, String[] attrnames, Object[][] tuples, int[] alignments) {
		JTable table = setupJTable(attrnames, tuples, alignments);

		JScrollPane sc = getScrollPaneWithJTable(table);  	// JTable ��ü�� �����ϴ� JScrolPane ��ü ����
		
		JComponent[][] comps = { { sc } };
		
		PanelMgmt.displayComponents(frame, panel, title, comps, null);
	}

	// title, table�� �־����� �̸� panel�� ��ġ
	static void displayJTableToPanel(JFrame frame, JPanel panel, String  title, JTable table ) {		
			
		JScrollPane sc = getScrollPaneWithJTable(table);  	// JTable ��ü�� �����ϴ� JScrolPane ��ü ����

		PanelMgmt.displayComponents(frame, panel, title, sc); 				
	}

	// �־��� JTable ��ü�� �����ϴ� JScrollPane ��ü �����Ͽ� ��ȯ
	//    �̶�, JScrollPane ��ü ũ��� JTable ��ü ũ�⺸�� (+3, +5) �ؾ� ����ϰ� ��µ�
	static JScrollPane getScrollPaneWithJTable(JTable table) {
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);  	// JTable�� JScrollPane���� ������ ������� ���ϰ� ����        

		JScrollPane sc = new JScrollPane(table);  			// JTable ��ü�� JScrolPane ��ü�� ��ġ

		Dimension d = getJTableSizeForJScrollPane(table);

		int w = d.width;
		int h = d.height;

		sc.setPreferredSize(new Dimension(w, h));		
		sc.setSize(w, h);      

		return sc;
	}
	
	// �־��� JTable ��ü�� ũ�⸦ ���Ͽ� ��ȯ�ϴ� �޼ҵ�
	static Dimension getJTableSize(JTable table) {
		Dimension d = table.getPreferredSize();	// JTable�� ũ���  getPreferredSize() �޼ҵ�� ���ؾ� ��(?)
		int tableWidth = d.width; 					// ��ü ���̺��� �� ����
		
		int rowCount = table.getRowCount();        		// ���̺� ����� ���� ���� ����
		int tableHeight = (rowCount + 1) * table.getRowHeight(); //  ��ü ���̺� ���� ����(��ü ���� = ���� ���� * �� ���� + ��� ��
		
		return new Dimension(tableWidth, tableHeight); 
	}

	// �־��� JTable ��ü�� �����ϴ� JScrollPane ��ü�� ũ�⸦ ��ȯ�ϴ� �޼ҵ�
	static Dimension getJTableSizeForJScrollPane(JTable table) {
		Dimension d = getJTableSize(table);
		
		return new Dimension(d.width + wDeltaForScrollPane, 
				d.height + hDeltaForScrollPane);   // JScrollPane ��ü ũ�� ����: (+3, +5) �ϸ� JScrollPane�� ����ϰ� ǥ�õ�
	}


	/*
	 * JTable�� �� ��Ʈ����Ʈ�� �־��� ���Ĺ������ �����ϱ� ���� �κ�	
	 */
	
	// �־��� attrnames[] �迭��  tuples[][] ������ �迭�� ���� JTable ��ü�� �����Ͽ� ��ȯ
	static JTable setupJTable(String[] attrnames, Object[][] tuples) {
		JTable table = new JTable(tuples, attrnames);   	// JTable ��ü ���� - tuples: ������ �迭, attrnames: 1���� �迭 

		JTableHeader header = table.getTableHeader();		// ���̺��� ����� ���� 	
		header.setBackground(Color.cyan);                   // ���̺��� ��� ���� ����
		header.setFont(new Font("���ü", Font.BOLD, header.getFont().getSize())); // ���̺��� ��� �ؽ��� bold�� ����

		table.setBackground(Color.cyan);                  // ���̺��� ��� ���� ����
		table.setForeground(Color.black);                 // ���̺��� ����(����) ���� ����
		table.setRowHeight(DEFALTCELLHEIGHT);             // ���̺��� �� ���� ����

		return table;
	}

	static DefaultTableCellRenderer dtcrLeft = new DefaultTableCellRenderer(); // ����Ʈ ���̺� �� ������ ����
	static DefaultTableCellRenderer dtcrCenter = new DefaultTableCellRenderer(); // ����Ʈ ���̺� �� ������ ����
	static DefaultTableCellRenderer dtcrRight = new DefaultTableCellRenderer(); // ����Ʈ ���̺� �� ������ ����
	static {
		dtcrLeft.setHorizontalAlignment(SwingConstants.LEFT); // ��������  ���� ������ LEFT��
		dtcrCenter.setHorizontalAlignment(SwingConstants.CENTER); // �������� ���� ������ CENTER��
		dtcrRight.setHorizontalAlignment(SwingConstants.RIGHT); // �������� ���� ������ RIGHT��
	}

	static DefaultTableCellRenderer[] dtcrArray = { dtcrLeft, dtcrCenter, dtcrRight };

 	// attrnames, tuples. alignments�� �־����� JTable ��ü�� �����Ͽ� ��ȯ�ϴ� �޼ҵ�	
	static  JTable setupJTable(String[] attrnames, Object[][] tuples, int[] alignments) {
		JTable table = setupJTable(attrnames, tuples);

		TableColumnModel tcm = table.getColumnModel() ; // ������ ���̺��� �÷����� ������

		// ������ ��Ʈ����Ʈ(�÷�)�� ���� �־��� ���Ĺ��(0: ���� ����, 1: �߾� ����, 2: ������ ����)��  ����
		// �÷��𵨿��� �÷��� ������ŭ �÷��� ������ for���� �̿��Ͽ� �־��� ���Ĺ������ ����
		for(int i = 0 ; i < tcm.getColumnCount() ; i++){   		
			// ������ �� �������� alignments[i]�� ���� ���� ����
			tcm.getColumn(i).setCellRenderer(dtcrArray[alignments[i]]);  
		}

		return table;		
	}
}
