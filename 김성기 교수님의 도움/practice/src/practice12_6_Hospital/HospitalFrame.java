package practice12_6_Hospital;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;

/**
 *  * [ 12�� �ǽ����� 6�� ��� ��� �� �Ϻ� - HospitalFrame Ŭ���� ] : 
 *       ���� ������ ó���ϴ� GUI�� ���� JFrame�� ���� Ŭ����
 * 
*    o ��ü ȭ���� ���ʿ��� Ÿ��Ʋ�� ����ϴ� Ÿ��Ʋ �г�, ���ʿ��� �޴��� ����ϴ� �޴� �г�, 
 *     �����ʿ� ���� ó���� ���� ȭ���� �����ϴ� ���� �г� �� 3���� �гη� �����ȴ�.
 *      
 *   o ���� �޴� �г��� ù ��° ������ �ܷ�ȯ�� ��� ��ư�� Ŭ���ϸ� ������ ���� �гο� ȯ�ڹ�ȣ, ȯ���̸�, ȯ�� ����, 
 *     ���ᳯ¥ �� ȯ�������� �Է��ϴ� ȭ���� ��Ÿ����. 
 *      
 *   o ȯ�������� �Է��� �� ������ ���� �ܷ�ȯ�� ��� OK ��ư�� Ŭ���ϸ� �Էµ� ȯ�������κ��� OutPatient ��ü�� �����ϰ� 
 *     �̸� Hospital System Ŭ������ enrolPatient() �޼ҵ带 �̿��Ͽ� allPatients[] �迭�� �����Ѵ�.
 *     
 *   o ���ο� ������ �����Ǹ� ���� �гο� ���� ������ ���� ��ġ�ߴ� ������Ʈ�� �����ϰ� ������ ���� ���ο� ������Ʈ�� ��ġ�Ѵ�.
 *     �̿� ���� ����� ������ �ٶ���.  

 */

class HospitalFrame extends JFrame {
	HospitalSystem hospital;  // ���� ��ü�� �����ϴ� �ʵ�, ��ü �����ڷ� ���� ����

	JPanel titlePanel = new JPanel();   // Ÿ��Ʋ ��ư ��ġ�� �г� 
	JPanel menuPanel = new JPanel();    // ���� ��ư ��ġ�� �г� 
	JPanel taskPanel = new JPanel();  	// ���� ���� �� ������ ���� �Է¹��� �г�
	
	int widthFrame = 700;
	int heightFrame = 500;
	
	// ���� Ÿ��Ʋ �г� ũ�� �� ��ġ ��ġ
	int widthTitlePanel = widthFrame - (10 * 2 + 5);    // ������ �ʺ񺸴�  25 ���� 
	int heightTitlePanel = 45;  // ���� ũ�� ����
	int xTitlePanel = 10;    	// ���� ���� ����ŭ 
	int yTitlePanel = 10;    	// ���� ���� ���̸�ŭ

	// ���� �Ʒ� �޴� �г� ũ�� �� ��ġ ��ġ
	int widthMenuPanel = 130;  	// ���� ũ�� �ʺ�
	int heightMenuPanel = heightFrame - (heightTitlePanel + 3 * 10 + 28) ; 	// ��ü - (Ÿ��Ʋ �г� ���� + ���� 10 3�� + ������ Ÿ��Ʋ ���� 28)
	int xMenuPanel = 10;    	// ���� ���� 10 1��
	int yMenuPanel = heightTitlePanel + 2 * 10;    // Ÿ��Ʋ �г� ���� + ���� ���� 10 2��

	// ������ �Ʒ� ���� �г� ũ�� �� ��ġ ��ġ
	int widthTaskPanel = widthFrame - (widthMenuPanel + 10 * 3 + 5);		// ��ü - (�޴� �г� �ʺ� + ���� 10 3�� + 5)
	int heightTaskPanel = heightFrame - (heightTitlePanel + 3 * 10 + 28);  	// ��ü - (Ÿ��Ʋ �г� ���� + ���� 10 3�� + ������ Ÿ��Ʋ ���� 28) 
	int xTaskPanel = widthMenuPanel + 10 * 2;      // �޴� �г� �ʺ� + ���� ���� 10 2��
	int yTaskPanel = heightTitlePanel + 10 * 2;    // Ÿ��Ʋ �г� ���� + ���� ���� 10 2��
	
	JLabel titleLb = new JLabel();

	// ���� ������ ���� 5���� ���� ����
	JButton enrolOutPatientBt = new JButton("�ܷ�ȯ�� ���"), 
			enrolInPatientBt = new JButton("�Կ�ȯ�� ���"), 
			listPatientsBt = new JButton("    ȯ�� ����    "), 
			treatBt = new JButton("    ȯ�� ����    "), 
			leaveBt = new JButton("    ȯ�� ���    "),            
			payFeeBt = new JButton("  ������ ����  ");

	// ���� ������ ���� ���� �Է� Ȯ�� ����
	JButton enrolOutPatientOkBt = new JButton("�ܷ�ȯ�� ����ϱ�"),
			enrolInPatientOkBt = new JButton("�Կ�ȯ�� ����ϱ�"),
			treatSelectedOkBt =  new JButton("������ ȯ�� �����ϱ�"), 
			treatOkBt =  new JButton("ȯ�� �����ϱ�"), 
			leaveOkBt =  new JButton("ȯ�� ����ϱ�"),
			payFeeOkBt = new JButton("������ �����ϱ�");
	
	// JLabel �ʵ� ����
	JLabel welcomeLb = new JLabel("ȯ���մϴ�. ���� �����ϱ� �ٶ��ϴ�."),
	       patientNoLb =   new JLabel("  ȯ�� ��ȣ:"),
		   patientNameLb = new JLabel("  ȯ�� �̸�:"), 
		   patientAgeLb =  new JLabel("  ȯ�� ����:"),

		   dateTreatLb =   new JLabel("  ġ�� ��¥:"), 
	       dateHospitalLb =   new JLabel("  �Կ� ��¥:"), 
	       treatMinutesLb =   new JLabel("  ���� �ð�:"), 

	       patientFeeLb =  new JLabel("      ������:"); 
	
	// JTextField �ʵ� ����	
	JTextField patientNoField = new JTextField(12), 
			patientNameField = new JTextField(12), 
			patientAgeField = new JTextField(12),
			dateTreatField = new JTextField(12),
			dateHospitalField = new JTextField(12), 
			treatMinutesField = new JTextField(12), 
			patientFeeField = new JTextField(12);

	// ��ü ������
	HospitalFrame(HospitalSystem aHospital, String title) { 
		
		super(title);
		
		hospital = aHospital; // �־��� ���� ��ü�� hospital �ʵ忡 ����
		
		titleLb.setText(title);
		
		setFrameAndPanels();         // �����Ӱ� �гε� ����
		enrolTaskButtonListener();   // ���� ������ ���� ���� ��ư�� ������ ���
		enrolTaskOkListener();       // ���� Ȯ�ι�ư�� ������ ���
				
		setVisible(true);  
	}

	// �����Ӱ� �гε��� �����ϴ� �޼ҵ�
	void setFrameAndPanels() {
		
		this.setSize( widthFrame, heightFrame);  
		this.setLocation(420, 220);  // �����츦 (420, 220) ��ġ�� ��ġ
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ���� �ɼ� ����
		this.setResizable(false);
		this.setLayout(null);        // ������Ʈ ��ġ����� ���� ��ġ�� 

		/*
		 *  Ÿ��Ʋ �г� ����: Ÿ��Ʋ ���
		 */
		titlePanel.setBounds(xTitlePanel, yTitlePanel, widthTitlePanel, heightTitlePanel);
		titlePanel.setBackground(Color.green);
		
		setJLabel(titleLb, "�Ÿ���", Font.BOLD, 24);
		titlePanel.add(titleLb);
		
		add(titlePanel);

		/*
		 * �޴� �г� ����: 5���� ���� ��ư ��ġ
		 */
		menuPanel.setBounds(xMenuPanel, yMenuPanel, widthMenuPanel, heightMenuPanel);
		menuPanel.setBackground(Color.cyan);		
		add(menuPanel);
		
		Dimension d = enrolOutPatientBt.getPreferredSize();

		int widthBt = d.width;
		int heightBt = d.height;
		
		int hGap = (widthMenuPanel - widthBt) / 2;
		int vGap = (heightMenuPanel - heightBt * 6) / (6 + 1) ;
		
		menuPanel.setLayout(new FlowLayout(FlowLayout.CENTER, hGap, vGap)); // ������Ʈ ��ġ����� flow layout ��ġ�� 
		menuPanel.add(enrolOutPatientBt);
		menuPanel.add(enrolInPatientBt);
		menuPanel.add(listPatientsBt);
		menuPanel.add(treatBt);
		menuPanel.add(leaveBt);       
		menuPanel.add(payFeeBt);

		/*
		 * ���� �г� ����: 
		 */
		taskPanel.setBounds(xTaskPanel, yTaskPanel, widthTaskPanel, heightTaskPanel);
		taskPanel.setBackground(Color.yellow);
		
		taskPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 100));

		setJLabel(welcomeLb, "�Ÿ���", Font.BOLD, 17);
		taskPanel.add(welcomeLb);
		
		add(taskPanel);
	}
	
	// ���� ���� ��ư�� Action ������ Ŭ���� ��Ͻ�Ŵ
	void enrolTaskButtonListener(){
		ActionListener al = new TaskActionListener();
		
		enrolOutPatientBt.addActionListener(al);
		enrolInPatientBt.addActionListener(al);
		treatBt.addActionListener(al);
		listPatientsBt.addActionListener(al);
		leaveBt.addActionListener(al);          
		payFeeBt.addActionListener(al);
	}

	// ���� ���� ��ư�� ���� ActionListener�� ��ӹ��� Action ������  Ŭ����
	class TaskActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();  // ���õ� ��ư ��ü�� �˾Ƴ�
	
			if (b == enrolOutPatientBt) // �̺�Ʈ�� �߻��� ��ư�� �ܷ�ȯ�� ��� ��ư�̸�
				showEnrolOutPatient();  //     showEnrolOutPatient() �޼ҵ� ȣ��
			if (b == enrolInPatientBt)  // �̺�Ʈ�� �߻��� ��ư�� �Կ�ȯ�� ��� ��ư�̸�
				showEnrolInPatient();   //     showEnrolInPatient() �޼ҵ� ȣ��
			if (b == listPatientsBt)    // �̺�Ʈ�� �߻��� ��ư�� ȯ�� ���� ��ư�̸�
				showListPatients();     //     showListPatients() �޼ҵ� ȣ��
			if (b == treatBt)           // �̺�Ʈ�� �߻��� ��ư�� ȯ�� ���� ��ư�̸�
				showTreat();            //     showTreat() �޼ҵ� ȣ��
			if (b == leaveBt)           // �̺�Ʈ�� �߻��� ��ư�� ȯ�� ��� ��ư�̸�
				showLeaveHospital();    //     showLeaveHospital() �޼ҵ� ȣ��  
			else if (b == payFeeBt)     // �̺�Ʈ�� �߻��� ��ư��  ������ ���� ��ư�̸�
				showPayFee();           //     showPayFee() �޼ҵ� ȣ��

		}
	}
	
	// ���� ���� ���� ���� �Է� �� Ȯ�� ��ư�� Action �����ʸ� ��Ͻ�Ŵ
	void enrolTaskOkListener() {
		
		ActionListener al = new TaskOkActionListener();
		
		enrolOutPatientOkBt.addActionListener(al);
		enrolInPatientOkBt.addActionListener(al);
		treatOkBt.addActionListener(al);
		leaveOkBt.addActionListener(al);
        payFeeOkBt.addActionListener(al);

	}

	// ���� ó���� ���� ���� �Է� �� Ȯ�� ��ư�� Ŭ���� ���� Action ������ Ŭ����
	class TaskOkActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();// ���õ� ��ư ��ü�� �˾Ƴ�
			
			// �̺�Ʈ�� �߻��� OK ��ư�� �ܷ�ȯ�� ��� Ok ��ư�̸�
			// doEnrolOutPatient() �޼ҵ带 ȣ��
			if (b == enrolOutPatientOkBt)  // �̺�Ʈ�� �߻��� ��ư�� �Կ�ȯ�� ��� Ȯ�� ��ư�̸�
				doEnrolOutPatient();       //    doEnrolInPatient() �޼ҵ� ȣ��
			if (b == enrolInPatientOkBt)   // �̺�Ʈ�� �߻��� ��ư�� �Կ�ȯ�� ��� Ȯ�� ��ư�̸�
				doEnrolInPatient();        //    doEnrolInPatient() �޼ҵ� ȣ��
			if (b == treatOkBt)            // �̺�Ʈ�� �߻��� ��ư�� ȯ�� ���� Ȯ�� ��ư�̸�
				doTreat();                 //    doTreat() �޼ҵ� ȣ��
			if (b == leaveOkBt)            // �̺�Ʈ�� �߻��� ��ư�� ȯ�� ��� Ȯ�� ��ư�̸�
				doLeaveHospital();         //    doLeaveHospital() �޼ҵ� ȣ��  
			else if (b == payFeeOkBt)      // �̺�Ʈ�� �߻��� ��ư�� ������ ���� Ȯ�� ��ư�̸�
				doPayFee();	               //    doPayFee() �޼ҵ� ȣ��	
			
			// Ȯ�� ��ư�� ���� ������ �ش� ������ �����ϴ� �޼ҵ� ȣ���϶�.
		}
	}

	// �ܷ�ȯ�� ��� ��ư�� Ŭ���Ǹ� ����Ǵ� �޼ҵ�
	//   �ܷ�ȯ�� ������ �Է��ϱ� ���� ������Ʈ��� Ȯ�� ��ư�� ���� �гο� ��ġ
	void showEnrolOutPatient() {

		taskPanel.setVisible(false);  // ������ ��ġ�� ������Ʈ �����ϱ� ���� false�� �Ͽ� ������� ��
		taskPanel.removeAll();        // taskPanel�� ��� ������Ʈ�� ����
		
		taskPanel.setLayout(null);

		JLabel titleLb = new JLabel("   �ܷ�ȯ�� ���     ");
		setJLabel(titleLb, Color.cyan, "�Ÿ���", Font.BOLD, 17);

		patientNameField.setText("");  
		patientAgeField.setText("");  
		
		// �ܷ� ȯ�� ���� �Է� ���� ������Ʈ�� ��� Ȯ�� ��ư�� taskPanel�� ��ġ��Ŵ
		
		titleLb.setSize(titleLb.getPreferredSize());
		titleLb.setLocation(180, 50);
		taskPanel.add(titleLb);
	
		patientNameLb.setSize(patientNameLb.getPreferredSize());
		patientNameLb.setLocation(181, 110);
		taskPanel.add(patientNameLb);	
		
		patientNameField.setSize(patientNameLb.getPreferredSize());
		patientNameField.setLocation(248, 110);
		taskPanel.add(patientNameField);
				
		patientAgeLb.setSize(patientNameLb.getPreferredSize());
		patientAgeLb.setLocation(181, 150);
		taskPanel.add(patientAgeLb);
				
		patientAgeField.setSize(patientNameLb.getPreferredSize());
		patientAgeField.setLocation(248, 150);
		taskPanel.add(patientAgeField);
			
		enrolOutPatientOkBt.setSize(enrolOutPatientOkBt.getPreferredSize());
		enrolOutPatientOkBt.setLocation(179, 200);
		taskPanel.add(enrolOutPatientOkBt);

		taskPanel.setVisible(true);   // ���� �г��� true�� �Ͽ� ��Ÿ���� ��
	}
	
	// �ܷ� ȯ�� ����� ó���ϴ� �޼ҵ�
	void doEnrolOutPatient() {
				
		// �Էµ� �̸��� �ùٸ� �̸����� Ȯ�� 
		String name = patientNameField.getText();  
		if (isInvalidPatientname(name)) {			
			showEnrolOutPatient();  // �ٽ� �ܷ� ȯ�� ����ϰ� ��
			return;
		}
		
		// �Էµ� ���̰� �ùٸ� �������� Ȯ�� 
		String ageString = patientAgeField.getText();  
		if (isInvalidAgeString(ageString)) {			
			showEnrolOutPatient();  // �ٽ� �ܷ� ȯ�� ����ϰ� ��
			return;
		}
		
		int age = Integer.valueOf(ageString);
		
		/*
		 * ���� �гο� ���ο� ȯ�� ������ ���÷��̽�Ű�� ���� �г� �ʱ�ȭ
		 */			
		taskPanel.setVisible(false);  // ������ ��ġ�� ������Ʈ �����ϱ� ����  false�� �Ͽ� ������� ��
		taskPanel.removeAll();        // taskPanel�� ��� ������Ʈ ����
		
		taskPanel.setLayout(null);

		/*
		 * ��ġ�� ������Ʈ ����
		 */
		JLabel titleLb = new JLabel("   ��ϵ�  �ܷ�ȯ��    ");
		setJLabel(titleLb, Color.cyan, "�Ÿ���", Font.BOLD, 17);

		int patientNo = hospital.getNewPatientNo();  // ���ο� ȯ�ڹ�ȣ�� Hospital ��ü���� ����
		patientNoField.setText("   "+ patientNo);  
		
		patientNameField.setText("   " + name);  
		patientAgeField.setText("   " + ageString);  

		
		java.util.Date dateTreat = new java.util.Date();   // ���ᳯ¥�� ���÷� ����
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� M�� d��(E)");
		String dateTreatString = sdf.format(dateTreat);    // dateTreat�� �������� ���ڿ� ��ȯ
		dateTreatField.setText("   " + dateTreatString);
		
		/*
		 * ���� �гο� ������Ʈ ��ġ
		 */
		
		titleLb.setSize(titleLb.getPreferredSize());
		titleLb.setLocation(180, 50);	
		taskPanel.add(titleLb);
			
		patientNoLb.setSize(patientNoLb.getPreferredSize());
		patientNoLb.setLocation(181, 110);
		taskPanel.add(patientNoLb);
		
		patientNoField.setSize(patientNoField.getPreferredSize());
		patientNoField.setLocation(248, 110);
		taskPanel.add(patientNoField);
		
		patientNameLb.setSize(patientNameLb.getPreferredSize());
		patientNameLb.setLocation(181, 150);
		taskPanel.add(patientNameLb);	
		
		patientNameField.setSize(patientNameField.getPreferredSize());
		patientNameField.setLocation(248, 150);
		taskPanel.add(patientNameField);
				
		patientAgeLb.setSize(patientAgeLb.getPreferredSize());
		patientAgeLb.setLocation(181, 190);
		taskPanel.add(patientAgeLb);
			
		patientAgeField.setSize(patientAgeField.getPreferredSize());
		patientAgeField.setLocation(248, 190);
		taskPanel.add(patientAgeField);
		
		dateTreatLb.setSize(dateTreatLb.getPreferredSize());
		dateTreatLb.setLocation(181, 230);
		taskPanel.add(dateTreatLb);
		
		dateTreatField.setSize(dateTreatField.getPreferredSize());
		dateTreatField.setLocation(248, 230);	
		taskPanel.add(dateTreatField);

		taskPanel.setVisible(true);  // ���� �г��� true�� �Ͽ� ��Ÿ���� ��
		
		// �Էµ� �ܷ� ȯ�� ������ �ܷ� ȯ�� ��ü�� ������ ��Ͻ�Ŵ
		hospital.enrolOutPatient(patientNo, name, age, dateTreat);		
	}
	
	static final int LEFT=0, CENTER=1, RIGHT=2; // JTable�� �� ���� ���Ĺ��(����, �߾�, ������)�� �����ϱ� ���� �������
	
	// ȯ�� ����Ʈ ��ư Ŭ���Ǹ� ����Ǵ� �޼ҵ�
	//    ȯ�� ����Ʈ�� �����ְ� ���õ� ȯ�ڸ� �����ϰ� ��
	void showListPatients() {
		/*
		 * ���� �гο� ���ο� ȯ�� ������ ���÷��̽�Ű�� ���� �г� �ʱ�ȭ
		 */			
		taskPanel.setVisible(false);  // ������ ��ġ�� ������Ʈ �����ϱ� ����  false�� �Ͽ� ������� ��
		taskPanel.removeAll();        // taskPanel�� ��� ������Ʈ ����
		
		taskPanel.setLayout(null);

		/*
		 * ��ġ�� ������Ʈ ����
		 */
		JLabel titleLb = new JLabel("   ��� ȯ��  ����Ʈ    ");
		setJLabel(titleLb, Color.cyan, "�Ÿ���", Font.BOLD, 17);
		
		/*
		 * ���� �гο� ������Ʈ ��ġ
		 */
		titleLb.setSize(titleLb.getPreferredSize());
		titleLb.setLocation(190, 50);
		taskPanel.add(titleLb);

		Vector<Patient> patients = hospital.getAllPatients();
		int noPatients = patients.size();

		String[] attrnames = { "ȯ�ڹ�ȣ", "ȯ������", "ȯ���̸�", "����", "����ð�", "������"}; // ���̺� ���·� �����, ȯ�� ������  ��Ʈ����Ʈ��  
		
		Object[][] tuples = new Object[noPatients][6];
		for (int i = 0; i < noPatients; i++) {             // ���� ��ü���� �ʵ���� ���̺� ���·� ����ϱ� ���� 2���� �迭�� ����
			Patient p = patients.get(i);

			tuples[i][0] = p.pno;
			tuples[i][1] = (p instanceof  OutPatient) ? "�ܷ�ȯ��" : "�Կ�ȯ��";
			tuples[i][2] = p.name;
			tuples[i][3] = p.age;
			tuples[i][4] = p.minutesTreat ;
	
			tuples[i][5] = p.getPayFee();
		}

		// "ȯ�ڹ�ȣ", "ȯ������", "ȯ���̸�", "����", "����ð�", "������"�� ����  ���Ĺ���� ����
		int[] alignments = { CENTER, CENTER, CENTER, RIGHT, RIGHT, RIGHT };

		JTable tbl = setupJTable(attrnames, tuples, alignments);
		JScrollPane sc = getScrollPaneWithJTable(tbl);
		
		titleLb.setSize(titleLb.getPreferredSize());
	 	sc.setLocation(36, 90);
	 	taskPanel.add(sc);


		taskPanel.setVisible(true);  // ���� �г��� true�� �Ͽ� ��Ÿ���� ��

	}
	
	
	/*
	 * JTable�� �� ��Ʈ����Ʈ�� �־��� ���Ĺ������ �����ϱ� ���� �κ�	
	 */
	
	static int DEFALTCELLHEIGHT = 20;  // ���̺��� �� ���� ����Ʈ ��
	
	// �־��� attrnames[] �迭��  tuples[][] ������ �迭�� ���� JTable ��ü�� �����Ͽ� ��ȯ
	static JTable setupJTable(String[] attrnames, Object[][] tuples) {
		JTable jTable = new JTable(tuples, attrnames);   	// JTable ��ü ���� - tuples: ������ �迭, attrnames: 1���� �迭 

		JTableHeader header = jTable.getTableHeader();		// ���̺��� ����� ���� 	
		header.setBackground(Color.cyan);                   // ���̺��� ��� ���� ����
		header.setFont(new Font("���ü", Font.BOLD, header.getFont().getSize())); // ���̺��� ��� �ؽ��� bold�� ����

		jTable.setBackground(Color.cyan);                  // ���̺��� ��� ���� ����
		jTable.setForeground(Color.black);                 // ���̺��� ����(����) ���� ����
		jTable.setRowHeight(DEFALTCELLHEIGHT);             // ���̺��� �� ���� ����

		return jTable;
	}

	static DefaultTableCellRenderer dtcrLeft = new DefaultTableCellRenderer(); // ����Ʈ ���̺� �� ������ ����
	static DefaultTableCellRenderer dtcrCenter = new DefaultTableCellRenderer(); // ����Ʈ ���̺� �� ������ ����
	static DefaultTableCellRenderer dtcrRight = new DefaultTableCellRenderer(); // ����Ʈ ���̺� �� ������ ����
	
	static {
		dtcrLeft.setHorizontalAlignment(SwingConstants.LEFT); // �������� ���� ������ LEFT��
		dtcrCenter.setHorizontalAlignment(SwingConstants.CENTER); // �������� ���� ������ CENTER��
		dtcrRight.setHorizontalAlignment(SwingConstants.RIGHT); // �������� ���� ������ RIGHT��
	}

	static DefaultTableCellRenderer[] dtcrArray = { dtcrLeft, dtcrCenter, dtcrRight };

	static  JTable setupJTable(String[] attrnames, Object[][] tuples, int[] alignments) {
		JTable jTable = setupJTable(attrnames, tuples);

		TableColumnModel tcm = jTable.getColumnModel() ; // ������ ���̺��� �÷����� ������

		// ������ ��Ʈ����Ʈ(�÷�)�� ���� �־��� ���Ĺ��(0: ���� ����, 1: �߾� ����, 2: ������ ����)��  ����
		// �÷��𵨿��� �÷��� ������ŭ �÷��� ������ for���� �̿��Ͽ� �־��� ���Ĺ������ ����
		for(int i = 0 ; i < tcm.getColumnCount() ; i++){   		
			// ������ ���������� alignments[i]�� ���� ���� ����
			tcm.getColumn(i).setCellRenderer(dtcrArray[alignments[i]]);  
		}

		return jTable;		
	}
	
	// �־��� JTable ��ü�� �����ϴ� JScrollPane ��ü �����Ͽ� ��ȯ
	//    �̶�, JScrollPane ��ü ũ��� JTable ��ü ũ�⺸�� +5 �ؾ� ����ϰ� ��µ�
	static JScrollPane getScrollPaneWithJTable(JTable jTable) {
		jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);  	// JTable�� JScrollPane���� ������ ������� ���ϰ� ����        

		JScrollPane sc = new JScrollPane(jTable);  			// JTable ��ü�� JScrolPane ��ü�� ��ġ

		Dimension dimJTable = jTable.getPreferredSize();	// JTable�� ũ���  getPreferredSize() �޼ҵ�� ���ؾ� ��(?)
		int jTableWidth = dimJTable.width; 					// ��ü ���̺��� �� ����
		int rowCount = jTable.getRowCount();        		// ���̺� ����� ���� ���� ����
		int jTableHeight = (rowCount + 1) * jTable.getRowHeight(); //  ��ü ���̺� ���� ����(��ü ���� = ���� ���� * �� ���� + ��� ����)

		sc.setSize(jTableWidth + 5, jTableHeight + 5);      // JScrollPane ��ü ũ�� ����: +5 �ؾ���
		
		return sc;
	}


	// ������ ���� ��ư�� Ŭ���Ǹ� ����Ǵ� �޼ҵ�
	//   ȯ�� ��ȣ�� �Է��ϱ� ���� ������Ʈ��� Ȯ�� ��ư�� ���� �гο� ��ġ
	void showPayFee() {
		
		taskPanel.setVisible(false);  // ������ ��ġ�� ������Ʈ �����ϱ� ���� false�� �Ͽ� ������� ��
		taskPanel.removeAll();        // taskPanel�� ��� ������Ʈ�� ����

		taskPanel.setLayout(null);
		
		JLabel titleLb = new JLabel("   ������ ����   "); 
		setJLabel(titleLb,Color.cyan, "�Ÿ���", Font.BOLD, 17);

		patientNoField.setText("10001");  

		
		// ȯ�� ��ȣ �Է����� ������Ʈ�� ������ ���� Ȯ�� ��ư�� taskPanel�� ��ġ��Ŵ
		titleLb.setSize(titleLb.getPreferredSize());
		titleLb.setLocation(185, 50);	
		taskPanel.add(titleLb);
			
		patientNoLb.setSize(patientNoLb.getPreferredSize());
		patientNoLb.setLocation(181, 110);
		taskPanel.add(patientNoLb);
		
		patientNoField.setSize(60, 22);
		patientNoField.setLocation(248, 110);
		taskPanel.add(patientNoField);
			
		payFeeOkBt.setSize(payFeeOkBt.getPreferredSize());
		payFeeOkBt.setLocation(179, 160);
		taskPanel.add(payFeeOkBt); // �� ��ư�� Ŭ���Ǹ� �̺�Ʈ ó����
		
		taskPanel.setVisible(true);  // ���� �г��� true�� �Ͽ� ��Ÿ���� ��
	}
	
	// ������ ���� ó���ϴ� �޼ҵ�
	void doPayFee() {	

		// �Էµ� ȯ�� ��ȣ�� �ùٸ�  ȯ�� ��ȣ�ΰ� �˻�
		String pnoString = patientNoField.getText();  
		if (isInvalidPatientNoString(pnoString)) {			
			showPayFee();
			return;
		}
		
		/*
		 * �Էµ� ȯ�� ��ȣ�� ȯ�� ��ü ����
		 */
		int pno = Integer.valueOf(pnoString);		
		Patient p = hospital.getPatient(pno);
		
		if (p == null) {
			JOptionPane.showMessageDialog(this, "\"" + pno + "\" : ȯ�� ��ȣ�� ȯ�ڰ� �����ϴ�.", 
                	"ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE); 
			
			showPayFee();
			return;
		}
		
		/*
		 * ���� �гο� ���ο� ȯ�� ������ ���÷��̽�Ű�� ���� �г� �ʱ�ȭ
		 */
		taskPanel.setVisible(false);  // ������ ��ġ�� ������Ʈ �����ϱ� ���� false�� �Ͽ� ���� �г� ������� ��
		taskPanel.removeAll();        // taskPanel�� ��� ������Ʈ ����
		
		taskPanel.setLayout(null);	

		/*
		 * ��ġ�� ������Ʈ ����
		 */
		JLabel titleLb = new JLabel("   ���� ���   ");
		titleLb.setOpaque(true);
		titleLb.setBackground(Color.cyan);
		titleLb.setFont(new Font("�Ÿ���", Font.BOLD, 17));

		taskPanel.add(titleLb);

		patientNoField.setText("   "+ pno);  
		patientNameField.setText("   " + p.name);
		patientAgeField.setText("   " + p.age);  	
		
		int fee = p.getPayFee();                // ȯ���� ����� ����
		patientFeeField.setText("   " + fee);  
		
		/*
		 * ���� �гο� ������Ʈ ��ġ
		 */
		titleLb.setSize(titleLb.getPreferredSize());
		titleLb.setLocation(215, 50);	
		taskPanel.add(titleLb);
			
		patientNoLb.setSize(patientNoLb.getPreferredSize());
		patientNoLb.setLocation(181, 110);
		taskPanel.add(patientNoLb);
		
		patientNoField.setSize(patientNoField.getPreferredSize());
		patientNoField.setLocation(248, 110);
		taskPanel.add(patientNoField);
		
		patientNameLb.setSize(patientNameLb.getPreferredSize());
		patientNameLb.setLocation(181, 150);
		taskPanel.add(patientNameLb);	
		
		patientNameField.setSize(patientNameField.getPreferredSize());
		patientNameField.setLocation(248, 150);
		taskPanel.add(patientNameField);
				
		patientAgeLb.setSize(patientAgeLb.getPreferredSize());
		patientAgeLb.setLocation(181, 190);
		taskPanel.add(patientAgeLb);
			
		patientAgeField.setSize(patientAgeField.getPreferredSize());
		patientAgeField.setLocation(248, 190);
		taskPanel.add(patientAgeField);
		
		patientFeeLb.setSize(patientFeeLb.getPreferredSize());
		patientFeeLb.setLocation(184, 230);
		taskPanel.add(patientFeeLb);
		
		patientFeeField.setSize(patientFeeField.getPreferredSize());
		patientFeeField.setLocation(248, 230);	
		taskPanel.add(patientFeeField);
		taskPanel.add(titleLb);

		taskPanel.setVisible(true);  // ���� �г��� true�� �Ͽ� ��Ÿ���� ��
	}
	
	
	// �Կ�ȯ�� ��� ��ư�� Ŭ���Ǹ� ����Ǵ� �޼ҵ�
	//   �Կ�ȯ�� ������ �Է��ϱ� ���� ������Ʈ��� Ȯ�� ��ư ��ġ
	void showEnrolInPatient() {
		taskPanel.setVisible(false);  // ������ ��ġ�� ������Ʈ �����ϱ� ���� false�� �Ͽ� ���� �г� ������� �� 
		taskPanel.removeAll();        // taskPanel�� ��� ������Ʈ ����
		
		taskPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 50));

		JLabel lb = new JLabel(" �ۼ����� �ʾҽ��ϴ�. ");
		setJLabel(lb, Color.cyan, "�Ÿ���", Font.BOLD, 17);

		taskPanel.add(lb);
		
		taskPanel.setVisible(true);  // ���� �г��� true�� �Ͽ� ��Ÿ���� ��
	}

	void doEnrolInPatient() {
		// �ۼ��϶�.
	}
	
	void showTreat() {
		taskPanel.setVisible(false);  // ������ ��ġ�� ������Ʈ �����ϱ� ���� false�� �Ͽ� ���� �г� ������� ��
		taskPanel.removeAll();        // taskPanel�� ��� ������Ʈ ����
		
		taskPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 50));

		JLabel lb = new JLabel(" �ۼ����� �ʾҽ��ϴ�. ");
		setJLabel(lb, Color.cyan, "�Ÿ���", Font.BOLD, 17);

		taskPanel.add(lb);
		
		taskPanel.setVisible(true);  // ���� �г��� true�� �Ͽ� ��Ÿ���� ��
	}
	
	void doTreat() {
		// �ۼ��϶�.
	}
	
	void showLeaveHospital() {
		taskPanel.setVisible(false);  // ������ ��ġ�� ������Ʈ �����ϱ� ���� false�� �Ͽ� ���� �г� ������� ��
		taskPanel.removeAll();        // taskPanel�� ��� ������Ʈ ����
		
		taskPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 50));

		JLabel lb = new JLabel(" �ۼ����� �ʾҽ��ϴ�. ");
		setJLabel(lb, Color.cyan, "�Ÿ���", Font.BOLD, 17);

		taskPanel.add(lb);
		
		taskPanel.setVisible(true);  // ���� �г��� true�� �Ͽ� ��Ÿ���� ��

	}

	void doLeaveHospital() {
		// �ۼ��϶�.

	}

	/*
	 * ���� ���α׷����� ���� �޼ҵ�� 
	 */

	// JLabel�� �Ӽ� ���� �޼ҵ�
	void setJLabel(JLabel lb, Color color, String fontname, int fontStyle, int size) {
		lb.setOpaque(true);
		lb.setBackground(color);
		lb.setFont(new Font(fontname, fontStyle, size));
		
	}	
	
	// JLabel�� �Ӽ� ���� �޼ҵ�
	void setJLabel(JLabel lb, String fontname, int fontStyle, int size) {
		lb.setFont(new Font(fontname, fontStyle, size));
		
	}	
	
	// �־��� �̸��� �ùٸ� ���ڿ� �ƴϸ� ���� â�� ���� false ��ȯ�ϴ� �޼ҵ�
	boolean isInvalidPatientname(String name) {
		if (name.equals("")) {
			JOptionPane.showMessageDialog(this, "�̸��� �Էµ��� �ʾҽ��ϴ�", 
					"ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE); 
			return true;
		}
		else
			return false;
	}
	
	// �־��� ���� ���ڿ��� �ùٸ� ���� ���ڿ� �ƴϸ� ���� â�� ���� false ��ȯ�ϴ� �޼ҵ�
	boolean isInvalidAgeString(String ageString) {
		int age;
		
		if (ageString.equals("")) {
			JOptionPane.showMessageDialog(this, "���̰� �Էµ��� �ʾҽ��ϴ�", 
					"ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE); 
			return true;
		}

		try {
			age = Integer.parseInt(ageString);

			if (age < 0) {
				JOptionPane.showMessageDialog(this, age + " : ���̴� 0 �̻��̾�� �մϴ�.", 
						"ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE); 

				return true;
			}				
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(this, "\"" + ageString + "\" : ���̴� �����̾�� �մϴ�.", 
					"ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE); 

			return true;
		}

		return false;
	}
	
	// �־��� ȯ�� ��ȣ ���ڿ��� �ùٸ� ȯ�� ��ȣ ���ڿ� �ƴϸ� ���� â�� ���� false ��ȯ�ϴ� �޼ҵ�
	boolean isInvalidPatientNoString(String pnoString) {
		int pno;
		
		if (pnoString.equals("")) {
			JOptionPane.showMessageDialog(this, "ȯ�� ��ȣ�� �Էµ��� �ʾҽ��ϴ�", 
					"ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE); 
			return true;
		}

		try {
			pno = Integer.parseInt(pnoString);

			if (pno <= 0) {
				JOptionPane.showMessageDialog(this, pno + " : ȯ�� ��ȣ�� ����̾�� �մϴ�.", 
						"ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE); 

				return true;
			}				
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(this, "\"" + pnoString + "\" : ȯ�� ��ȣ�� �����̾�� �մϴ�.", 
					"ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE); 

			return true;
		}

		return false;
	}
}
