package example12_2_bank;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

import java.util.*;
import java.text.*;         // DateFormat Ŭ������ ���Ͽ� import

/**
 * o GUI ȯ�濡�� ��������� ó���ϴ� Java ���α׷�
 *   - ������� �޴���ư�� ���� ��������� �����ϰ�
 *     ������ �ʿ��� �ڷḦ �Է��� �� Ȯ�ι�ư�� Ŭ���ϸ� Ư�� ���� ����
 *    
 *   - ������ ó���ϱ� ���� ���� ȭ���� 3���� ȭ�� Ÿ�� �� �ϳ��� �����ϰ� ����
 *     (�̴� PanelMgmt Ŭ������ ���� �޼ҵ带 �̿��ϸ� GUI ȭ�� ������ ���� �������� �����ֱ� ����)
 */

public class BankFrame extends JFrame {
	static  int defaultFrameWidth = 1200;    // ��������  ����Ʈ �ʺ�
	static  int defaultFrameHeight = defaultFrameWidth / 16 * 9;   // �������� ����Ʈ ����, �ʺ� ���� ������ 16 : 9�� ����

	static int TOPCENTERframe = 1;
	static int TOPLEFTCENTERframe = 2;	
	static int TOPCENTERBOTTOMframe = 3;

	static int hGap = 5;
	static int vGap = 5;
	static int heightTop = 80;
	static int widthLeft = 120;
	static int heightBottom = 60;

	BankFrame thisFrame;

	int frameWidth;    // �������� �ʺ�
	int frameHeight;   // �������� ���� 


	int frameType; // �г� ��ġ ��Ŀ� ���� (��, ���), (��, ����, �߾�), (��, �߾�, �Ʒ�) ������  ������ Ÿ�� ����

	JPanel  topPanel, leftPanel, centerPanel, bottomPanel;  // ��ü �������� 2�� �Ǵ� 3���� �гη� ������ ���� ó����
	JPanel  centerLeftPanel, centerRightPanel,  centerRightTopPanel,  centerRightBottomPanel;  // �߾� �г��� �ʿ信 ���� �����Ͽ� ���� ó�� 

	JLabel bankTitleLb;  // top �гο� ��ġ�� ���� Ÿ��Ʋ ���̺�

	// ���� ���� �޴��� ���� ����
	JButton openAccountBt =  new JButton("���� ����"),  listBt  = new JButton("���� ����Ʈ"), 
			depositBt     = new JButton("���� �Ա�"),   withdrawBt  = new JButton("���� ���"),
			transferBt    = new JButton("���� ��ü"),   outputOwnerInfoBt = new JButton("���������� ��ȸ"),
			outputTransactionInfoBt = new JButton("���� �۾����� ��ȸ"),  enrolBankerBt  = new JButton("����� ���");

	// ���� �޴��� Ȯ�� ��ư
	JButton openAccountOKBt  = 	new JButton("���� ���� Ȯ��"), 
			depositOKBt  = 	new JButton("�Ա� Ȯ��"),       withdrawOKBt = new JButton("��� Ȯ��"), 
			transferOKBt = new JButton("��ü Ȯ��"),        outputOwnerInfoOKBt = new JButton("���������� Ȯ��"),
			outputTransactionInfoOKBt = new JButton("�۾����� Ȯ��"), enrolBankerOKBt  = new JButton("����� ��� Ȯ��");

	// �ԷµǴ� ������Ʈ�� �����ϱ� ���� JComponent �迭 ������  inputComps�� ����
	// �� �迭 ������ ��� �������� �Է� ������ ���ʷ� �����ϱ� ���� ����
	JComponent[] inputComps = new JComponent[20];


	// �ʺ�� ���� �־����� ������ ����Ʈ  ũ���  �������� �����ϴ� ��ü ������
	BankFrame() {
		this(defaultFrameWidth, defaultFrameHeight);
	}

	// �ʺ�� ���� �־����� �� ũ���� �������� �����ϴ� ��ü ������
	BankFrame(int width, int height) {
		// JFrame ��ü�� ���� ����
		thisFrame = this;

		frameWidth = width;    // �������� �ʺ� ����
		frameHeight = height;

		setTitle("���� ���� �ý���");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		setLayout(null);
		setSize(frameWidth, frameHeight);

		// ����� �ػ�(�ʺ� �ȼ���, ���� �ȼ���) ��������
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int w = (int) screen.getWidth();  // ����� �ʺ� ũ��
		int h = (int) screen.getHeight(); // ����� ���� ũ��

		// �������� ȭ�� �߾ӿ� ��ġ
		setLocation((w - frameWidth) / 2, (h- frameHeight)/2);

		// topPanel�� ��ġ�� ���� Ÿ��Ʋ ���̺� ����(  
		bankTitleLb = new JLabel("���� ���� �ý���"); 
		bankTitleLb.setFont(new Font("���ü", Font.BOLD, 28));
		bankTitleLb.setSize(350, 50);	
		bankTitleLb.setBackground(new Color(150, 170, 100)); // Color(255, 0, 105): 		
		bankTitleLb.setFocusable(false); 
		bankTitleLb.setOpaque(true); 
		bankTitleLb.setHorizontalAlignment(JLabel.CENTER);

		// �Ź� ������ ������ 3���� ���� ȭ�� �� �ϳ��� �����ϰ� �����ϰ� �� 
		//   java.lang.Math.random() �޼ҵ�� 0�̻� 1 �̸��� �Ǽ����� ��ȯ��
		int frameType = (int) (java.lang.Math.random() * 3 ) + 1 ;  // n���� 0, 1, 2 ���� �� ���� �����
		if (frameType==TOPCENTERframe)
			displayTopCenterFrameType();
		else if (frameType==TOPLEFTCENTERframe)
			displayTopLeftCenterFrameType();
		else if (frameType==TOPCENTERBOTTOMframe)
			displayTopCenterBottomFrameType();			

		addListenerToButtons();  // ���� ó���� ���� �޴� ��ư�� Ȯ�� ��ư�� �����ʸ� ����

		setVisible(true);	

		addResizeButton();
	}

	// ��ü �������� top, center �� 2 �������� �����Ͽ� �� ������ JPanel ��ü�� ��ġ��Ŵ
	void displayTopCenterFrameType(){
		frameType = 1;

		// �̸� ���� SubPanelCreation.createSubPanelsTopCenter() �޼ҵ尡 �̿��
		Container[] subPanels = SubPanelCreation.createSubPanelsTopCenter(this, 120, Color.green, Color.yellow, 5);

		// topPanel, centerPanel�� �ʿ��� ������Ʈ ��ġ
		topPanel = (JPanel) subPanels[0];
		centerPanel = (JPanel) subPanels[1];		

		// topPanel�� ���� Ÿ��Ʋ�� �޴� ��ư�� ��ġ
		JComponent comps[][] = { { openAccountBt,  listBt,     depositBt, 
			withdrawBt, transferBt,  outputOwnerInfoBt, outputTransactionInfoBt, enrolBankerBt, resizeBt} };

		// topPanel�� ���� Ÿ��Ʋ�� ��������� ���� �޴� ���̺��� 1�ٿ� ��ġ
		PanelMgmt.displayComponents(this, topPanel, bankTitleLb, comps, null);

		// centerPanel�� ȯ�� �޽��� ����� ���� ���̺� ��ġ
		displayInitialCenterPanel();
	}

	// ��ü �������� top, left, center �� 3 �������� �����Ͽ� �� ������ JPanel ��ü�� ��ġ��Ŵ
	void displayTopLeftCenterFrameType(){

		frameType = 2;

		// �̸� ���� SubPanelCreation.createSubPanelsTopLeftCenter() �޼ҵ尡 �̿��
		Container[] subPanels = SubPanelCreation.createSubPanelsTopLeftCenter(this, 80, 160, Color.green, Color.orange, Color.yellow, 5);

		// ��ġ�� 3������ JPanel ��ü���� topPanel, leftPanel, centerPanel�� ���� ����
		topPanel = (JPanel) subPanels[0];
		leftPanel = (JPanel) subPanels[1];
		centerPanel = (JPanel) subPanels[2];

		// topPanel�� ���� Ÿ��Ʋ�� ���� ���̺� ��ġ
		PanelMgmt.displayComponents(this, topPanel, bankTitleLb);

		JComponent comps[][] = { { openAccountBt}, { listBt },     { depositBt }, 
				{withdrawBt},     { transferBt }, { outputOwnerInfoBt }, { outputTransactionInfoBt }, { enrolBankerBt }, { resizeBt} };

		// leftPanel�� ��������� ���� �޴� ��ư�� ��ġ - 1�ٿ� 1 �޴��� ��ġ��
		PanelMgmt.displayComponents(this, leftPanel, comps);	

		// centerPanel�� ȯ�� �޽��� ����� ���� ���̺� ��ġ
		displayInitialCenterPanel();
	}

	// ��ü �������� top, center, bottom �� 3 �������� �����Ͽ� �� ������ JPanel ��ü�� ��ġ��Ŵ
	void displayTopCenterBottomFrameType(){
		frameType = 3;

		// �̸� ���� SubPanelCreation.createSubPanelsTopCenterBottom() �޼ҵ尡 �̿��
		Container[] subPanels = SubPanelCreation.createSubPanelsTopCenterBottom(this, 80, 60, Color.green, Color.yellow, Color.orange, 5);

		// ��ġ�� 3������ JPanel ��ü���� topPanel, centerPanel, bottomPanel�� ���� ����
		topPanel = (JPanel) subPanels[0];
		centerPanel = (JPanel) subPanels[1];
		bottomPanel = (JPanel) subPanels[2];

		// topPanel�� ���� Ÿ��Ʋ ����� ���� ���̺� ��ġ
		PanelMgmt.displayComponents(this, topPanel, bankTitleLb);

		// centerPanel�� ȯ�� �޽��� ����� ���� ���̺� ��ġ
		displayInitialCenterPanel();

		// ��ġ�� �޴� ��ư�� 1���� �迭�� ����� coms�� ����
		JComponent comps[] = { openAccountBt, listBt, depositBt, 
				withdrawBt, transferBt, outputOwnerInfoBt, outputTransactionInfoBt, enrolBankerBt, resizeBt };

		// bottomPanel�� ��������� ���� �޴� ��ư���� ��ġ - 1�ٿ� 9 �޴��� ��ġ��
		PanelMgmt.displayComponents(this, bottomPanel,  null, 9, comps, null);
	}

	// centerPanel�� �ʱ��� ȯ�� �޽����� ���� JLabel ��ġ 
	void displayInitialCenterPanel() {
		JLabel welcomeLabel = new JLabel("ȯ���մϴ�!."); 
		welcomeLabel.setForeground(Color.blue);
		welcomeLabel.setFont(new Font("���ü", Font.BOLD, 20));
		//		welcomeLabel.setSize(welcomeLabel.getPreferredSize());		

		PanelMgmt.displayComponents(this, centerPanel, welcomeLabel);
	}

	// ���� �޴� ��ư�� Ȯ�� ��ư�� �����ʸ� ������� ��ư Ŭ�� �� �̺�Ʈ ó���ϰ� ��
	void addListenerToButtons() {

		// ���� �޴� ��ư�� BankMenuListener�� add�Ͽ� �޴� ��ư�� Ŭ���Ǹ� �ش� �����۾��� �����ϰ����� ������ �Է��ϰ� ��
		ActionListener listener = new BankMenuListener();

		openAccountBt.addActionListener(listener);
		listBt.addActionListener(listener);
		depositBt.addActionListener(listener);
		withdrawBt.addActionListener(listener);
		transferBt.addActionListener(listener);
		outputOwnerInfoBt.addActionListener(listener);
		outputTransactionInfoBt.addActionListener(listener);
		enrolBankerBt.addActionListener(listener);

		// ���� Ȯ�� ��ư�� BankConfirmListener�� add�Ͽ� ������ OK ��ư�� Ŭ���Ǹ� �Էµ� ������ �ش� ������ �Ϸ��ϰ� ��
		listener = new BankConfirmListener();

		openAccountOKBt.addActionListener(listener);
		depositOKBt.addActionListener(listener);	
		withdrawOKBt.addActionListener(listener);
		transferOKBt.addActionListener(listener);
		outputOwnerInfoOKBt.addActionListener(listener);
		outputTransactionInfoOKBt.addActionListener(listener);
		enrolBankerOKBt.addActionListener(listener);
	}

	//  ���� ���� ó���� ���� �޴� ��ư�� Ŭ���� ���� Action ������
	class BankMenuListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			centerPanel.setVisible(false);
			centerPanel.removeAll();

			JButton b = (JButton)e.getSource();   // Ŭ���� ��ư ��ü�� �˾Ƴ�
			String cmd = e.getActionCommand();    // Ŭ���� ��ư ��ü�� ���ڿ� ����� �˾Ƴ�

			// Ŭ���� �޴� ��ư�� ������ ���� �־��� �۾��� ������
			if (cmd.equals("���� ����"))         //	if (b == openAccountBt) �ε� ������
				doOpenAccount();			
			else if (cmd.equals("���� ����Ʈ"))   // if (b == listBt) �ε� ������
				doListAccount();
			else  if (cmd.equals("���� �Ա�"))   // if (b == depositBt) �ε� ������
				doDeposit(); 
			else   if (cmd.equals("���� ���"))  // if (b == withdrawBt) �ε� ������
				doWithDraw();
			else if (cmd.equals("���� ��ü"))    // if (b == TransferBt) �ε� ������
				doTransfer();
			else  if (cmd.equals("���������� ��ȸ")) // if (b == outputOwnerInfoBt) �ε� ������
				doOutputOwnerInfo();				
			else  if (cmd.equals("���� �۾����� ��ȸ")) // if (b == outputTransactionInfoBt) �ε� ������
				doOutputTransactionInfo();				
			else  if (cmd.equals("����� ���")) // if (b == enrolBankerBt) �ε� ������
				doEnrolBankerBt();				
		}
	}

	JButton resizeBt = new JButton("ũ�� ����");

	void addResizeButton() {
		resizeBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {		
					String wString = JOptionPane.showInputDialog("�ʺ� �Է��Ͻÿ�"); 

					int w = Integer.parseInt(wString);
					String hString = JOptionPane.showInputDialog("���� �Է��Ͻÿ�"); 
					int h = Integer.parseInt(hString);

					new BankFrame(w, h);		
					dispose();  // ������ �������� ������
				}
				catch(Exception ex) { }
			}
		});
	}

	// ������ ���Ǵ� �������� �̸���: ������, �Ա���, �����, ��ü�� ������ ����
	static String[] names = { "ȫ�浿", "�ڹ���", "������", "�̸���", "���е�", "���", "��û", "���б�", "���"};

	// ������ ���Ǵ� �������� �̸���: ����� �̸����� ����
	static String[] bankerNames = { "ȫ�漭", "�ڹ���", "������", "�̸�ȣ", "�ɹ�", "���"};

	// ������ ���Ǵ� ��������ID��: ����� ID�� ����
	static String[] bankerIDs = { "hgs34", "p1m2s3", "chslml", "chlove", "heart100", "hur4"};

	// ���� ���� ���� ����
	//   ���� ���� ��ư�� Ŭ���Ǹ� �߾� �гο� ��������, ������, �ʱ��Աݾ�, ��й�ȣ�� �Է��� �� �ֵ��� ������Ʈ�� ��ġ�ϰ�  
	//   openAccountOKBt ��ư�� Ŭ���Ǳ⸦ ��ٸ�
	void doOpenAccount() {
		// ���� ����		
		String[] accountTypes = {"���뿹��", "���࿹��"};
		JComboBox cb = new JComboBox(accountTypes);    // �޺��ڽ��� "���뿹��"��, "���࿹��"�� ���������� ���� - �� ���� �� �����ϰ� ��
		cb.setSelectedIndex((int) (java.lang.Math.random() *  cb.getItemCount()) );  // �� ���� ������ �ϳ��� �������� �̸� �����ص�

		inputComps[0] = cb;
		inputComps[1] = new JTextField(names[(int) (java.lang.Math.random() *  names.length) ] );  // ������ �Է¹��� �ؽ�Ʈ�ʵ�, ������ ������ �̸� ����
		inputComps[2] = new JTextField("" + (int) (java.lang.Math.random() * 100000) / 1000 * 1000); // �Աݾ��� �Է��� �ؽ�Ʈ�ʵ�, ������ �Աݾ� �̸� ����
		inputComps[3] = new JPasswordField("1234"); // ��й�ȣ�� �Է��� �н������ʵ�, ��й�ȣ 1234 �̸� ����

		JComponent[][]  openComps =   // ���� ���� ȭ�鿡 ��ġ�� ����� ������Ʈ���� 2�����迭�� ����
			{   { new JButton("��������"),   inputComps[0] }, 
					{ new JButton("������"),     inputComps[1] }, 
					{ new JButton("�ʱ��Աݾ�"), inputComps[2] },
					{ new JButton("��й�ȣ"),   inputComps[3] } }; 

		centerPanel.setVisible(false);
		centerPanel.removeAll();

		Container[] subPanels = SubPanelCreation.createSubPanelsLeftRight(centerPanel, 220, new Color(128, 255, 255), Color.pink, 5);
		centerLeftPanel = (JPanel) subPanels[0];
		centerRightPanel = (JPanel) subPanels[1];	

		// PanelMgmt Ŭ������ displayComponents(this, ) �޼ҵ�� ���� ������ ���� ������Ʈ�� ���÷���
		PanelMgmt.displayComponents(this, centerLeftPanel, "����  ����", openComps, openAccountOKBt);  // ���� ���� ȭ�鿡 ������Ʈ�� ��ġ�ϰ� ���� ���� ���� �Է� ���

		JScrollPane scImg = JLabelMgmt.getScrollPaneWithJLabel(centerRightPanel, "images\\dog.jpg");		
		JComponent[][] comps = {{new JLabel("���� ������ ���� ���� �Է�")}, {scImg}};

		PanelMgmt.displayComponents(this, centerRightPanel, comps);  // ���� ���� ��� ȭ�鿡 ������Ʈ�� ��ġ

		centerPanel.setVisible(true);

	}

	// ��� ���� ��ȸ
	//    ���� ����Ʈ ��ư�� Ŭ���Ǹ� �߾� �гο� ��� ���� ������ ��ȸ��
	void doListAccount() { 
		Account[] accs = BankSystem.getAllAccounts() ;  // ��� ���� ��ü�� �迭�� ������(�迭�� ������ ������ JTable�� �̿��Ͽ� ����ϱ� ������)

		displayAccounts(centerPanel, "���� ����Ʈ", accs);  // �迭�� ����� ���� ��ü�� ȭ�鿡 ���
	}

	// ���� �Ա� ���� ����
	//   ���� �Ա� ��ư�� Ŭ���Ǹ� �߾� �гο� ���¹�ȣ, �Ա���, �Աݾ���  �Է��� �� �ֵ��� ������Ʈ�� ��ġ�ϰ�  
	//   depositOKBt ��ư�� Ŭ���Ǳ⸦ ��ٸ�
	void doDeposit() {        // ���� �Ա� �޴��� ó��
		String[] accnos = BankSystem.getAllAccnos();   // ��� ������ ���¹�ȣ���� String �迭�� ������

		if (accnos.length==0) {   // ���¹�ȣ�� 0��, �� ������ ���°� ������ ���� ó��
			JOptionPane.showMessageDialog(null, "�Ա��� �� �ִ� ���°� �����ϴ�. ���� ���� �Ͻʽÿ�", "�Ա� ���� ���� ����", JOptionPane.ERROR_MESSAGE);
			return;
		}

		JComboBox cb = new JComboBox(accnos); // �޺��ڽ��� ��� ���¹�ȣ���� ���������� ���� - ���� ���¹�ȣ �� �ϳ��� �����ϰ� ��
		cb.setSelectedIndex((int) (java.lang.Math.random() * cb.getItemCount() ));  // ���� ���¹�ȣ �� �ϳ��� �������� �̸� �����ϰ� ��

		inputComps[0] = cb;
		inputComps[1] = new JTextField(names[(int) (java.lang.Math.random() * names.length )]);      // �Ա��� �Է¹��� �ؽ�Ʈ�ʵ�
		inputComps[2] = new JTextField("" + (int) (java.lang.Math.random() * 100000) / 1000 * 1000);   // �Աݾ� �Է¹��� �ؽ�Ʈ�ʵ�

		JComponent[][]  depositComps = // �Ա� ȭ�鿡 ��ġ�� ����� ������Ʈ���� 2���� �迭�� ����
			{   { new JButton("���¹�ȣ"),  inputComps[0] },  
					{ new JButton("�Ա���"),    inputComps[1] }, 
					{ new JButton("�Աݾ�"),    inputComps[2] }  };  

		centerPanel.setVisible(false);
		centerPanel.removeAll();

		Container[] subPanels = SubPanelCreation.createSubPanelsLeftRight(centerPanel, 220, new Color(128, 255, 255), Color.pink, 5);
		centerLeftPanel = (JPanel) subPanels[0];
		centerRightPanel = (JPanel) subPanels[1];	

		// PanelMgmt Ŭ������ displayComponents() �޼ҵ�� ���� �Ա��� ���� ������Ʈ�� ���÷���
		PanelMgmt.displayComponents(this, centerLeftPanel, "����  �Ա�", depositComps, depositOKBt);   // ���� �Ա� ȭ�鿡 ������Ʈ�� ��ġ�ϰ� �Ա��� ���� ���� �Է� ���

		JScrollPane scImg = JLabelMgmt.getScrollPaneWithJLabel(centerRightPanel, "images\\dog.jpg");		
		JComponent[][] comps = {{new JLabel("���� �Ա��� ���� ���� �Է�")}, {scImg}};

		PanelMgmt.displayComponents(this, centerRightPanel, comps);  // ���� ���� ��� ȭ�鿡 ������Ʈ�� ��ġ

		centerPanel.setVisible(true);
	}

	// ���� ��� ���� ����
	//   ���� ��� ��ư�� Ŭ���Ǹ� �߾� �гο� ���¹�ȣ, �����, ��ݾ�, ��й�ȣ��  �Է��� �� �ֵ��� ������Ʈ�� ��ġ�ϰ�  
	//   withdrawOKBt ��ư�� Ŭ���Ǳ⸦ ��ٸ�
	void doWithDraw() {
		// << �ۼ��Ͻÿ�>>

		PanelMgmt.displayComponents(this, centerPanel, "�ۼ����� �ʾҽ��ϴ�.", null); 

	}

	// ���� ��ü ���� ����
	//   ���� ��ü ��ư�� Ŭ���Ǹ� �߾� �гο� ��ü��� ���¹�ȣ, ��ü�Ա� ���¹�ȣ, �����, ��ݾ�, ��й�ȣ��  �Է��� �� �ֵ��� ������Ʈ�� ��ġ�ϰ�  
	//   transferOKBt ��ư�� Ŭ���Ǳ⸦ ��ٸ�	
	void doTransfer() {
		// << �ۼ��Ͻÿ�>>

		PanelMgmt.displayComponents(this, centerPanel, "�ۼ����� �ʾҽ��ϴ�.", null); 

	}

	//  ������ ���� ���� ����
	//   ������ ���� ��ȸ ��ư�� Ŭ���Ǹ� �߾� �гο� ������ �̸��� �Է��� �� �ֵ��� ������Ʈ�� ��ġ�ϰ�  
	//   ownerInfoOKBt ��ư�� Ŭ���Ǳ⸦ ��ٸ�
	void doOutputOwnerInfo() {
		// << �ۼ��Ͻÿ�>>

		PanelMgmt.displayComponents(this, centerPanel, "�ۼ����� �ʾҽ��ϴ�.", null); 

	}

	// ���� �۾����� ��ȸ ���� ó��
	//   ���� �۾����� ��ȸ ��ư�� Ŭ���Ǹ� �߾� �гο� ���� ��ȣ�� �Է��� �� �ֵ��� ������Ʈ�� ��ġ�ϰ�  
	//   outputTransactionOKBt ��ư�� Ŭ���Ǳ⸦ ��ٸ�
	void doOutputTransactionInfo() {

		String[] accnos = BankSystem.getAllAccnos();   // ��� ������ ���¹�ȣ���� String �迭�� ������

		if (accnos.length==0) {   // ���¹�ȣ�� 0��, �� ��ȸ�� ���°� ������ ���� ó��
			JOptionPane.showMessageDialog(null, "��ȸ�� �� �ִ� ���°� �����ϴ�. ���� ���� �Ͻʽÿ�", "��ȸ ���� ���� ����", JOptionPane.ERROR_MESSAGE);
			return;
		}

		JComboBox cb = new JComboBox(accnos); // �޺��ڽ��� ��� ���¹�ȣ���� ���������� ���� - ���� ���¹�ȣ �� �ϳ��� �����ϰ� ��
		cb.setSelectedIndex((int) (java.lang.Math.random() * cb.getItemCount() ));  // ���� ���¹�ȣ �� �ϳ��� �������� �̸� �����ϰ� ��

		inputComps[0] = cb;

		JComponent[][]  depositComps = // �Ա� ȭ�鿡 ��ġ�� ����� ������Ʈ 2���� �迭�� ����
			{  { new JButton("��ȸ�� ���¹�ȣ"), inputComps[0]  } };  

		centerPanel.setVisible(false);
		centerPanel.removeAll();

		Container[] subPanels = SubPanelCreation.createSubPanelsLeftRight(centerPanel, 220, new Color(128, 255, 255), Color.pink, 5);
		centerLeftPanel = (JPanel) subPanels[0];
		centerRightPanel = (JPanel) subPanels[1];	

		// PanelMgmt Ŭ������ displayComponents() �޼ҵ�� �۾����� ��ȸ�� ���� ������Ʈ�� ���÷���
		PanelMgmt.displayComponents(this, centerLeftPanel, "�۾����� ��ȸ", depositComps, outputTransactionInfoOKBt);   // �۾����� ��ȸ ȭ�鿡 ������Ʈ ��ġ�ϰ� ��ȸ�� ���¹�ȣ �Է� ���

		JScrollPane scImg = JLabelMgmt.getScrollPaneWithJLabel(centerRightPanel, "images\\cat.jpg");

		JComponent[][] comps = {{new JLabel("�۾����� ��ȸ ���� ���� �Է�")}, {scImg}};
		PanelMgmt.displayComponents(this, centerRightPanel, comps);  // ���� ���� ��� ȭ�鿡 ������Ʈ�� ��ġ

		centerPanel.setVisible(true);
	}

	boolean wasCheckedIDDuplication;  // ����� ID �ߺ� �˻� �Ϸ� ���θ� ��Ÿ���� �ʵ�

	void doEnrolBankerBt() {
		// ���� ����		

		wasCheckedIDDuplication = false;  // ID �ߺ� �˻簡 �̷������ ������ ǥ��

		String[] bankerTypes = {"������", "��������"};
		JComboBox cb = new JComboBox(bankerTypes);    // �޺��ڽ��� "������", "��������"�� ���������� ���� - �� ���� �� �����ϰ� ��
		cb.setSelectedIndex((int) (java.lang.Math.random() *  cb.getItemCount()) );  // �� ���� ������ �ϳ��� �������� �̸� �����ص�

		inputComps[0] = cb;
		inputComps[1] = new JTextField( bankerNames[(int) (java.lang.Math.random() * bankerNames.length )] );  // ����� �̸� �Է¹��� �ؽ�Ʈ�ʵ�
		inputComps[2] = new JTextField( bankerIDs[(int) (java.lang.Math.random() * bankerIDs.length )] );      // ����� ID �Է¹��� �ؽ�Ʈ�ʵ�
		inputComps[3] = new JPasswordField("1234"); // ��й�ȣ�� �Է��� �н������ʵ�, ��й�ȣ 1234 �̸� ����
		inputComps[4] = new JPasswordField("1234"); // ��й�ȣ�� �Է��� �н������ʵ�, ��й�ȣ 1234 �̸� ����
		inputComps[5] = new JTextField("��������");   // ����� �ٹ����� �Է¹��� �ؽ�Ʈ�ʵ�, �������� �̸� ����

		JButton checkIDDuplicationBt = new JButton("ID �ߺ� Ȯ��");  // �Էµ� ����� ID�� �ߺ� ���θ� Ȯ���ϱ� ���� ��ư
		checkIDDuplicationBt.addActionListener(new checkIDDuplicationActionListener());

		JComponent[][]  enrolComps =   // ���� ���� ȭ�鿡 ��ġ�� ����� ������Ʈ���� 2�����迭�� ����
			{   { new JButton("����� ����"),   inputComps[0] },  
					{ new JButton("����� �̸�"),   inputComps[1] }, 
					{ new JButton("����� ID"),    inputComps[2], checkIDDuplicationBt },
					{ new JButton("��й�ȣ"),     inputComps[3] },
					{ new JButton("��й�ȣ Ȯ��"), inputComps[4] },
					{ new JButton("�ٹ�����"),     inputComps[5] }  }; 

		Container[] subPanels = SubPanelCreation.createSubPanelsLeftRight(centerPanel, 350, new Color(128, 255, 255), Color.pink, 5);
		centerLeftPanel = (JPanel) subPanels[0];
		centerRightPanel = (JPanel) subPanels[1];	

		// PanelMgmt Ŭ������ displayComponents() �޼ҵ�� ���� ������ ���� ������Ʈ�� ���÷���
		PanelMgmt.displayComponents(this, centerLeftPanel, "����� ���", enrolComps, enrolBankerOKBt);  // ���� ���� ȭ�鿡 ������Ʈ�� ��ġ�ϰ� ���� ���� ���� �Է� ���

		JScrollPane scImg = JLabelMgmt.getScrollPaneWithJLabel(centerRightPanel, "images\\cat.jpg");

		JComponent[][] comps = {{new JLabel("����� ����� ���� ���� �Է�")}, {scImg}};
		PanelMgmt.displayComponents(this, centerRightPanel, comps);  // ���� ���� ��� ȭ�鿡 ������Ʈ�� ��ġ

		centerPanel.setVisible(true);

	}

	//  ���� ���� ó���� ���� �޴��� ���� OK ��ư�� Ŭ���� ����  Action ������
	class BankConfirmListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();// ���õ� ��ư ��ü�� �˾Ƴ�

			if (b == openAccountOKBt) 	
				doOpenAccountOK();

			else if (b ==  depositOKBt) 
				doDepositOK();

			else  if (b == withdrawOKBt) {
				// << �ۼ��Ͻÿ�>>
			}
			else  if (b == transferOKBt) {
				// << �ۼ��Ͻÿ�>>
			}
			else  if (b == outputOwnerInfoOKBt) {
				// << �ۼ��Ͻÿ�>>
			}
			else  if (b == outputTransactionInfoOKBt) {
				doOutputTransactionInfoOK();
			}
			else  if (b == enrolBankerOKBt) {
				doEnrolBankerOK();
			}
		} 
	}

	// ID �ߺ� Ȯ�ι�ư�� Ŭ���Ǹ� �Էµ� ID�� ������ ����� ID�� ������ ���� �ִ°��� �˻��Ͽ�
	//    ������ ���� ������ wasCheckedIDDuplication�� true�� ����
	//    (���߿� �� ������ ���� true�̾�� ����� ��� Ȯ�� ��ư�� Ŭ���Ǿ��� �� ����� ��ü�� �����ϰ� ��)
	class checkIDDuplicationActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();// ���õ� ��ư ��ü�� �˾Ƴ�

			String ID = ((JTextField) inputComps[2]).getText(); // �Էµ� ����� ID�� ������

			if (ID == null || ID.equals("") ) {
				JOptionPane.showMessageDialog(null, "����� ID�� �ݵ�� �ԷµǾ�� �մϴ�.",
						"����� ID ���Է� ����", JOptionPane.ERROR_MESSAGE);					
			} 
			else if ( BankSystem.isThereSameID(ID) == false) {
				JOptionPane.showMessageDialog(null, "�Էµ� ����� ID '" + ID + "' : ��밡���� ID�Դϴ�.",
						"��밡�� ID �Է�", JOptionPane.PLAIN_MESSAGE);

				wasCheckedIDDuplication = true;   // �� ���� ���� true�� �����Ͽ� ���߿� ����� ��� Ȯ�� ������ Ŭ���Ǹ� ����ϰ� ��
			}
			else
				JOptionPane.showMessageDialog(null, "�ߺ� ����� ID '" + ID + "' : �̹� �����ϴ� ID�̹Ƿ� ����� �� �����ϴ�.",
						"�ߺ��� ID �Է� ����", JOptionPane.ERROR_MESSAGE);
		} 
	}

	// ���� ���� ó��: �Էµ� ��������, ������, �ʱ��Աݾ��� �̿��Ͽ� ���°�ü�� �����ϰ� ������ ���°�ü�� ���
	void doOpenAccountOK() {  
		int accType, initAmount = 0, password = 0;
		accType = ((JComboBox) inputComps[0]).getSelectedIndex() + 1; // �޺��ڽ��� ���õ� ���� Ÿ���� ������(1: ���뿹��, 2: ���࿹��)
		String owner = ((JTextField) inputComps[1]).getText();        // ������ �̸��� ������
		try {
			initAmount = Integer.parseInt( ((JTextField) inputComps[2]).getText() );  // �ʱ� �Աݾ��� ������
		}
		catch(Exception ex) {
			// �ʱ� �Աݾ��� �������� �ƴϸ� ���� �޽��� ���
			JOptionPane.showMessageDialog(null, "�ʱ� �Աݾ�: "+((JTextField)inputComps[2]).getText() + "�� �����̾�� �մϴ�",
					"�Աݾ� ����", JOptionPane.ERROR_MESSAGE);

			return;
		}

		try {
			password = Integer.parseInt( ((JTextField) inputComps[3]).getText() );  // ��й�ȣ�� ������
		}
		catch(Exception ex) {
			// ��й�ȣ�� ���� �ƴϸ� ���� �޽��� ���
			JOptionPane.showMessageDialog(null, "��й�ȣ�� �����̾�� �մϴ�", "��й�ȣ ����", JOptionPane.ERROR_MESSAGE);

			return;
		}

		// �Էµ� ���� ���� ������ ���¸� �����ϰ� �̸� ���� �����ϴ� ���Ϳ� ����
		Account newAccount = BankSystem.openAccount(accType, owner, initAmount, password);

		// ������ ���� ������ ȭ�鿡 ���
		displayAccount(centerRightPanel, "������ ����", newAccount);
		centerPanel.setVisible(true);
	}

	// �����Ա� ó��: �Էµ� ���¹�ȣ, �Ա���, �Աݾ��� �̿��Ͽ� ���� �ܰ� �����ϰ� ���°�ü�� ���
	void doDepositOK(){

		int accno, amount = 0;
		accno = Integer.parseInt( (String) (((JComboBox) inputComps[0]).getSelectedItem()) ) ;  // �޺��ڽ� inputComps[0]���� ���¹�ȣ ������
		String customer = ((JTextField) inputComps[1]).getText();								// �ؽ�Ʈ�ʵ� inputComps[1]���� ������ ������
		try {
			amount = Integer.parseInt( ((JTextField) inputComps[2]).getText() );				// �ؽ�Ʈ�ʵ� inputComps[2]���� ������ �Աݾ� ������
		}
		catch(Exception ex) {     //�Աݾ��� ������ �ƴϸ� ���� ó����
			JOptionPane.showMessageDialog(null, "�Աݾ�: "+((JTextField)inputComps[2]).getText() 
					+ "�� �����̾�� �մϴ�", "�Աݾ� ����", JOptionPane.ERROR_MESSAGE);

			return;
		}

		Account acc = BankSystem.findAccount(accno);   // accno ���¹�ȣ�� ���°�ü�� Ž��
		int oldBalance = acc.getBalance();			   // ���°�ü���� �ܰ� ������
		BankSystem.deposit(acc, amount, customer);	   // ���¿� ���� �Ա��� ó��

		displayDeposit(centerRightPanel, "���� �Ա� ���", acc, customer, amount, oldBalance);  // �Ա� ���� ������ ȭ�鿡 ���
	}

	// ���� �۾����� ��ȸ ó��: �Էµ� ���¹�ȣ�� �̿��Ͽ� ���� ������ �� ������ �۾������� ���
	void doOutputTransactionInfoOK() {
		int accno;
		accno = Integer.parseInt( (String) (((JComboBox) inputComps[0]).getSelectedItem()) ) ;  // �޺��ڽ� inputComps[0]���� ���¹�ȣ ������

		Account acc = BankSystem.findAccount(accno);   // accno ���¹�ȣ�� ���°�ü�� Ž��

		Transaction[] trans = BankSystem.getTransactionInfo(acc);  // �־��� ������ �۾��������� ������

		centerRightPanel.setVisible(false);
		centerRightPanel.removeAll();

		// centerPanel�� top, center �� 2 �������� �����Ͽ� �� ������ ���� ������ �۾����� ������ ����ϱ� ���� JTable ��ü 2���� ��ġ��Ŵ
		//   �̸� ���� SubPanelCreation.createSubPanelsTopCenter() �޼ҵ尡 �̿��
		Container[] subPanels = SubPanelCreation.createSubPanelsTopCenter(centerRightPanel, 115, new Color(128, 255, 255), Color.pink, 5);

		// centerRightTopPanel, centerRightBottomPanel�� �ʿ��� ������Ʈ ��ġ
		centerRightTopPanel = (JPanel) subPanels[0];
		centerRightBottomPanel = (JPanel) subPanels[1];

		displayAccount(centerRightTopPanel, "�۾����� ��ȸ�� ����", acc);  // �۾����� ��ȸ�� ���¸� ���� centerRightTopPanel�� ���
		displayTransactions(centerRightBottomPanel, "'" + acc.getAccno() + "' ������ �۾�����", trans);  // �۾��������� centerRightBottomPanel�� ���

		centerRightPanel.setVisible(true);
	}

	void doEnrolBankerOK() {
		String bankerType =(String) (((JComboBox) inputComps[0]).getSelectedItem()) ;  // �޺��ڽ� inputComps[0]���� ����� ���� ������

		String bname = ((JTextField) inputComps[1]).getText(); 
		String ID = ((JTextField) inputComps[2]).getText(); // �Էµ� ����� ID�� ������

		if ( wasCheckedIDDuplication == false) {
			JOptionPane.showMessageDialog(null, "�Էµ� '" + ID + "' ID�� �ߺ�Ȯ�� ���� �ʾҽ��ϴ�. �ߺ� Ȯ�� ��ư�� Ŭ���Ͻʽÿ�.",
					"ID �ߺ� ��Ȯ�� ����", JOptionPane.ERROR_MESSAGE);
			return;
		}

		wasCheckedIDDuplication = false; // �ѹ� �ߺ� �˻� ���� �� �ٽ� �˻��ϵ��� �ϱ� ����

		char[] password1 = ((JPasswordField) inputComps[3]).getPassword(); // �Էµ� ����� ID�� ������
		char[] password2 = ((JPasswordField) inputComps[4]).getPassword(); // �Էµ� ����� ID�� ������		

		if (java.util.Arrays.equals(password1, password2) == false) {
			JOptionPane.showMessageDialog(null, "�Էµ� �н����尡 ��ġ���� �ʽ��ϴ�.",
					"�н����� ����ġ ����", JOptionPane.ERROR_MESSAGE);		
			return;
		}

		String branch = ((JTextField) inputComps[5]).getText(); 

		Banker banker = BankSystem.enrolBanker(bankerType, bname, ID, password1, branch);
		displayBanker(centerRightPanel, "����� ��� ���", banker);  // ����� ��� ���� ������ ȭ�鿡 ���

		centerPanel.setVisible(true);
	}


	static final int LEFT=0, CENTER=1, RIGHT=2; // JTable�� �� ���� ���Ĺ��(����, �߾�, ������)�� �����ϱ� ���� �������

	// �־��� �ϳ��� ���� ������ Ÿ��Ʋ�� �Բ� �־��� �г�  panel�� ���
	void displayAccount(JPanel panel, String title, Account acc) {
		Account accs[] = {acc};

		displayAccounts(panel, title, accs);
	}

	void displayAccountOLD(JPanel panel, String title, Account acc) {
		panel.setVisible(false);

		String[] attrnames = { "���¹�ȣ", "��������", "������", "������", "�ܾ�", "��й�ȣ"};  // ���̺� ���·� �����, ���� ������  ��Ʈ����Ʈ��  
		Object[][] tuples = { { acc.getAccno(), acc.getAccTypename(), acc.getOwner(), getDate(acc.getOpenDate()), 
			formatAmount(acc.getBalance()), acc.getPassword()+" " }} ;  // ���� ��ü�� �ʵ���� ���̺� ���·� ����ϱ� ���� 2���� �迭�� ����

		// "���¹�ȣ", "��������", "������", "������", "�ܾ�", "��й�ȣ"�� ���� ���Ĺ���� ����
		int[] alignments = { CENTER, CENTER, CENTER, CENTER, RIGHT, RIGHT };

		// JTableMgmt Ŭ������displayJTableToPanel() �޼ҵ�� panel�� ���� ���� ���
		JTableMgmt.displayJTableToPanel(this, panel, title, attrnames, tuples, alignments);
	}

	// �־��� ���µ��� Ÿ��Ʋ�� �Բ� �־��� �г� panel�� ���
	void displayAccounts(JPanel panel, String title, Account[] accs) {
		panel.setVisible(false);

		int n = accs.length;

		String[] attrnames = { "���¹�ȣ", "��������", "������", "������", "�ܾ�", "��й�ȣ"}; // ���̺� ���·� �����, ���� ������  ��Ʈ����Ʈ��  
		Object[][] tuples = new Object[accs.length][attrnames.length + 1];
		for (int i = 0; i < n; i++) {             // ���� ��ü���� �ʵ���� ���̺� ���·� ����ϱ� ���� 2���� �迭�� ����
			tuples[i][0] = accs[i].getAccno();
			tuples[i][1] = accs[i].getAccTypename();
			tuples[i][2] = accs[i].getOwner();
			tuples[i][3] = getDate(accs[i].getOpenDate());
			tuples[i][4] = formatAmount(accs[i].getBalance()) ;
			tuples[i][5] = accs[i].getPassword() + " ";
		}

		// "���¹�ȣ", "��������", "������", "������", "�ܾ�"�� ����  ���Ĺ���� ����
		int[] alignments = { CENTER, CENTER, CENTER, CENTER, RIGHT, RIGHT, CENTER };

		// JTableMgmt Ŭ������displayJTableToPanel() �޼ҵ�� panel�� ���� ��������  ���
		JTableMgmt.displayJTableToPanel(this, panel, title, attrnames, tuples, alignments);

	}

	// �־��� �Ա� �������� Ÿ��Ʋ�� �Բ� �־��� �г� panel�� ���
	void displayDeposit(JPanel panel, String title, Account acc,String customer, int amount, int oldBalance) {
		panel.setVisible(false);

		String[] attrnames = { "���¹�ȣ", "������", "�Ա���", "�Աݾ�",  "���� �ܾ�", "�� �ܾ�"};   // ���̺� ���·� �����, �Ա� ������ ��Ʈ����Ʈ��  
		Object[][] tuples = { { acc.getAccno() , acc.getOwner(), customer, formatAmount(amount), 
			formatAmount(oldBalance), formatAmount(acc.getBalance()) }} ;   // �Ա� �������� ���̺� ���·� ����ϱ� ���� 2���� �迭�� ����

		// "���¹�ȣ", "������", "�Ա���", "�Աݾ�",  "���� �ܾ�", "�� �ܾ�"�� ����  ���Ĺ���� ����
		int[] alignments = { CENTER, CENTER, CENTER, RIGHT, RIGHT, RIGHT };

		// JTableMgmt Ŭ������displayJTableToPanel() �޼ҵ�� panel�� �Ա� ���� ���
		JTableMgmt.displayJTableToPanel(this, panel, title, attrnames, tuples, alignments);
	}

	// �־��� �۾��������� Ÿ��Ʋ�� �Բ�  �־��� �г� panel�� ���
	void displayTransactions(JPanel panel, String title, Transaction[] trans) {
		panel.setVisible(false);

		int n = trans.length;

		String[] attrnames = { "���¹�ȣ", "�۾�����", "����", "�ݾ�", "�ܾ�", "�۾���"}; // ���̺� ���·� �����, ���� ������  ��Ʈ����Ʈ��  
		Object[][] tuples = new Object[trans.length][attrnames.length];
		for (int i = 0; i < n; i++) {             // �۾����� ��ü���� �ʵ���� ���̺� ���·� ����ϱ� ���� 2���� �迭�� ����
			tuples[i][0] = trans[i].getTrAccount().getAccno();
			tuples[i][1] = trans[i].getTrType();
			tuples[i][2] = trans[i].getCustomer();
			tuples[i][3] = formatAmount(trans[i].getAmount()) ;
			tuples[i][4] = formatAmount(trans[i].getBalance());
			tuples[i][5] = getDate(trans[i].getTrDate());
		}

		// "���¹�ȣ", "�۾�����", "����", "�ݾ�", "�ܾ�", "�۾���"�� ����  ���Ĺ���� ����
		int[] alignments = { CENTER, CENTER, CENTER, RIGHT, RIGHT, CENTER};

		// JTableMgmt Ŭ������displayJTableToPanel() �޼ҵ�� panel�� ���� ��������  ���
		JTableMgmt.displayJTableToPanel(this, panel, title, attrnames, tuples, alignments);
	}

	// �־��� ����� �������� Ÿ��Ʋ�� �Բ� �־��� �г� panel�� ���
	void displayBanker(JPanel panel, String title, Banker banker ) {
		panel.setVisible(false);

		JComponent[][] comps = 	{ 	{ new JButton("����� ����"), new JTextField(banker.bankerType) },
				{ new JButton("����� ��ȣ"), new JTextField(Integer.toString(banker.bno)) },
				{ new JButton("�̸�"), new JTextField(banker.bname) }, 
				{ new JButton("ID"), new JTextField(banker.ID) },
				{ new JButton("��й�ȣ"), new JTextField(new String(banker.password)) },
				{ new JButton("�ٹ�����"), new JTextField(banker.branch)  }
		};   

		PanelMgmt.displayComponents(this, centerRightPanel, title, comps, null);

		//      // ���̺� ����� ��ϵ� ����� ���÷���
		//		String[] attrnames = { "����� ����", "����� ��ȣ", "�̸�", "ID",  "��й�ȣ", "�ٹ�����"};   // ���̺� ���·� �����, �Ա� ������ ��Ʈ����Ʈ��  
		//		Object[][] tuples = { { banker.bankerType , banker.bno, banker.bname, banker.ID, new String(banker.password), 
		//			banker.branch }} ;   // �Ա� �������� ���̺� ���·� ����ϱ� ���� 2���� �迭�� ����
		//
		//		//  "����� ����", "����� ��ȣ", "�̸�", "ID",  "��й�ȣ", "�ٹ�����"�� ����  ���Ĺ���� ����
		//		int[] alignments = { CENTER, CENTER, CENTER, CENTER, CENTER, CENTER };
		//
		//		// JTableMgmt Ŭ������displayJTableToPanel() �޼ҵ�� panel�� �Ա� ���� ���
		//		JTableMgmt.displayJTableToPanel(panel, title, attrnames, tuples, alignments);
	}

	// �ݾ��� õ��, �鸸�� ��ġ�� ','�� �־��ֱ� ���� �޼ҵ�
	static DecimalFormat dfAmount = new DecimalFormat("#,###,###,##0 ");

	public static String formatAmount(int amount){
		return dfAmount.format(amount);   // DecimalFormat Ŭ������ format() �޼ҵ带 �̿��Ͽ� ������ �������ϱ�
	}

	// getDate(Date d) - Date ��ü���� ������� ���Ͽ� ��ȯ
	//   getYear(), getMonth(), getDay() ���� deprecated �޼ҵ�(�� �̻� ������� �ʱ�� �� �޼ҵ�)������ ���� ���� ������ �����
	//   getYear() �޼ҵ�� (�⵵ - 1900)�� ��ȯ�ϹǷ� 1900�� ���ؾ� ��
	//   getMonth()�� 0~11�� ���� ���� ������ ��ȯ�ϹǷ� 1�� ������� ��
	static String getDate(Date d) {
		return (1900 + d.getYear()) + "-" + (d.getMonth()+1) + "-"+d.getDate();		
	}
}

