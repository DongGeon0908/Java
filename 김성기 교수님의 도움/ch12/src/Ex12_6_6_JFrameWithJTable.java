
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * [ JTable ]: JTable�� ������ �����ֱ� ���� ����
 *  
 *   o JTable 2���� �����Ͽ� �� ȭ�鿡 ����ϰ� �̺�Ʈ ó����
 *     - ù��° ���̺�: 3���� ��� 3���� �� ������ �Ż����� JTable
 *     - �ι�° ���̺�: 7���� ��� 4���� �� ������ �¼� ���� JTable
 *      
 *   o JTable�� ��� ���� ������ ���� ũ�Ⱑ �޶����Ƿ� JScrollPane�� �����Ͽ� ���÷����ϸ� ��
 *    
 *   o JTable�� Ư�� ���� Ŭ���Ǿ��� �� Ŭ���� �� Ȯ���ϱ� ���� ���
 *     1) MouseListener �������̽��� �����ϴ�  ������ Ŭ���� �ۼ��Ͽ� JTable ��ü�� ���
 *     2) ������ Ŭ������  mouseClicked(MouseEvent e) �޼ҵ忡��
 *        (1) Ŭ���� ��ġ�� ��ǥ ���Ͽ� ����: Point p = e.getPoint();  
 *	   (2) ���̺��� p ��ġ�� �� ��ȣ ���Ͽ� ����: int row = tbl.rowAtPoint(p);     
 *	   (3) ���̺��� p ��ġ�� �� ��ȣ ���Ͽ� ����: int col = tbl.columnAtPoint(p);  
 */

public class Ex12_6_6_JFrameWithJTable extends JFrame{  
	String[] columnNames =  { "�̸�", "����", "����ġ" };    
	
	Object[][] tuples =  
		{  	{ "ȫ�浿", 18, "�ݰ���" }, 
			{ "�̸���", 20, "����" }, 
			{ "�ڹ���", 30, "�Ѿ�" }
	    };    

	String[] columnNames2 =  { "1��",    "2��", "3��", "4��" };    
	String[][] tuples2 =   
		{  	{ "1A", "2A", "3A",  "4A"   }, 
			{ "1B", "2B", "3B",  "4B"   }, 
			{ "1C", "2C", "3C",  "4C"   },
			{ "1D", "2D", "3D",  "4D"   },
			{ "1E", "2E", "3E",  "4E"   },
			{ "1F", "2F", "3F",  "4F"   },
			{ "1G", "2G", "3G",  "4G"   }
	    };    
	
	JTable personsTbl, seatsTbl;
	JLabel seatLabel;

	// ��ü ������: ������Ʈ ��ġ �� ����, �̺�Ʈ ��ü ���, ȭ�鿡 ���̱� �� ����
	public Ex12_6_6_JFrameWithJTable(String title)    {   
		super(title);
		
		setLayout(null);

	    // �Ż����� �����ϴ� ���̺�  personsTbl �����Ͽ� ���� �Ӽ� ���� 
		personsTbl = new JTable(tuples, columnNames);  // 2���� �迭 ���õ�� 1�����迭 ��Ʈ����Ʈ�� JTable ��ü ������		
		personsTbl.setBackground(Color.cyan);
		personsTbl.setForeground(Color.black); 
		personsTbl.getTableHeader().setBackground(Color.YELLOW); // JTable�� ��� ���Ͽ� ���� ����		
		//	personsTbl.getTableHeader().setVisible(false);       // JTable�� Header �κ��� ������ �ʰ� ��
		personsTbl.setCellSelectionEnabled(true);                // JTable�� �� cell�� ������ �� �ְ� ��
		
		// personsTbl�� ���� ��ũ������ �����Ͽ� ��ġ
		JScrollPane jScrollPane1 = new JScrollPane(personsTbl); 
		jScrollPane1.setSize(300, 80);
		jScrollPane1.setLocation(130, 30);
		add(jScrollPane1);   
		
		
		// �¼� �������� �����ϴ� ���̺�  seatsTbl �����Ͽ� ���� �Ӽ� ���� 
		seatsTbl = new JTable(tuples2, columnNames2);  // 2���� �迭 ���õ�� 1�����迭 ��Ʈ����Ʈ�� JTable ��ü ������		
		seatsTbl.setBackground(Color.cyan);
		seatsTbl.setForeground(Color.black); 
		seatsTbl.getTableHeader().setBackground(Color.YELLOW); // JTable�� ��� ���Ͽ� ���� ����		
//		seatsTbl.getTableHeader().setVisible(false);           // JTable�� Header �κ��� ������ �ʰ� �Ϸ��� false�� �����ϸ� ��
		seatsTbl.setCellSelectionEnabled(true);                // JTable�� �� cell�� ������ �� �ְ� ��

		// seatsTbl�� ���� ��ũ������ �����Ͽ� ��ġ
		JScrollPane jScrollPane2 = new JScrollPane(seatsTbl);  	
		jScrollPane2.setSize(300, 100);
		jScrollPane2.setLocation(130, 150);
		add(jScrollPane2);   

		// MouseAdapter�� Ȯ���� ������ ��ü �����Ͽ� ���̺� ��ü�� ���
		MouseListener listener = new MyMouseAdapter();
		personsTbl.addMouseListener(listener);  
		seatsTbl.addMouseListener(listener); 

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  

		setBounds(150, 150, 600, 350);      
		
		setVisible(true);    // ������ JFrame ��ü�� ȭ�鿡 ��Ÿ���� ��
	}  

	// JTable�� Ư�� �� Ŭ������ ���� �̺�Ʈ ó���� ���� ������ Ŭ����
    //    MouseAdapter�� Ȯ���� ������ Ŭ���� �ۼ�
	class MyMouseAdapter extends MouseAdapter {
		
		// ���콺 Ŭ���ϸ� ȣ��Ǵ� �̺�Ʈ ó�� �޼ҵ带 �������̵���    
		public void mouseClicked(java.awt.event.MouseEvent e) {
			JTable tbl = (JTable) e.getSource();  // e.getSource() �޼ҵ�� ���õ� ���̺� ��ü ����

			Point p = e.getPoint();               // ���콺�� Ŭ���� ��ǥ (x, y)�� ���޹޾� p�� ����

			int row = tbl.rowAtPoint(p);          // ���̺��� p ��ġ�� �� ��ȣ�� ���Ͽ� row�� ����
			int col = tbl.columnAtPoint(p);       // ���̺��� p ��ġ�� �� ��ȣ�� ���Ͽ� row�� ����

			Object obj = tbl.getValueAt(row, col);   // ���̺��� (row, col)�� �� ���� ���Ͽ� obj�� ����
			System.out.println("���콺 Ŭ���� ��ġ: "  + p + ", Ŭ���� ��ġ�� ������: " + obj);

			if (tbl==seatsTbl) {
				if (obj.equals("����")) {         // �̹� ����� �¼��� �����ϸ� ���� â ���
					JOptionPane.showMessageDialog(null, "���õ��� ���� �¼��� �����Ͻʽÿ�", 
							                "�̹� ���õ� �¼�", JOptionPane.ERROR_MESSAGE);
					return;
				}

				tbl.setValueAt("����", row, col); // �ش� �¼��� ����� �¼����� ����				
			}

			String tblName = (tbl == personsTbl ? "�Ż� ���̺�": "�¼� ���� ���̺�");

			// ���õ� ���� ��ü�� ���ְ� â�� ���� ���
			System.out.println(tblName +"���� ���õ�  (" + row + ", "+ col + ") �� : "  + obj);
			JOptionPane.showMessageDialog(null, 
				           	tblName + "�� (" + row + ", "+ col + ") �� : " + obj, 
				         	tblName + "������ ����", JOptionPane.INFORMATION_MESSAGE );
		}

		// �ٸ� �̺�Ʈ ó�� �޼ҵ�� �ۼ����� �ʾƵ� ��
		//  �̹� MouseAdapter Ŭ�������� ���� �޼ҵ�� �ۼ��Ǿ��� ������
	}    
	
	public static void main(String[] args)    { 
		new Ex12_6_6_JFrameWithJTable("JTable ����");  
	}	
} 

/*
 * [ ���α׷��� ���� �� ���� ]
 *   
 *   1) 2���� ���̺� ��ü�� ���÷����Ѵ�.
 *      - �Ż� ���� ���̺�: Ư�� ���� Ŭ���ϸ� �� ���� ��� �� ��ȣ�� ���� ������ ���� ��
 *      - ��ȭ ���� ���� ���̺�: Ư�� �� Ŭ������ �� ���� �ȵ� ���̸� ����� ���� �����ϰ�
 *        �̹� ����� ���̸� ���õ� �¼����� �˸�
 *        
 *      - ���̺��� ��ü ������, �޼ҵ�, �߻� ������ �̺�Ʈ�� ������ ��ü ��� ��� ���� ������ ��   
 *      - Ư��, 2���� �迭�� ���̺��� ���� �����ϴ� ����� Ȯ���� ������ ��
 *     
 *   2) ���̺��� Mouse �̺�Ʈ�� �߻���Ű�Ƿ� �̵� ���� ������ ��ü ����� �����ϴ�.
 *      ���콺 �̺�Ʈ ó�� �޼ҵ忡�� Ŭ���� ���� �� ��ȣ�� �� ��ȣ�� ���ϴ� ����� Ȯ���϶�. 
 *               
 *   3) �־��� ���α׷��� ���캸�� ���α׷��� ������ �ľ��϶�.  
 *   
 *   4) ���α׷��� �����ϰ� ���α׷� ����� Ȯ���϶�.     
 */
