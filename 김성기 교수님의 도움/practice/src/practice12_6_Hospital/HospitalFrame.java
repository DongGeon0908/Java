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
 *  * [ 12장 실습문제 6번 모범 답안 중 일부 - HospitalFrame 클래스 ] : 
 *       병원 업무를 처리하는 GUI를 위한 JFrame의 하위 클래스
 * 
*    o 전체 화면은 위쪽에서 타이틀을 출력하는 타이틀 패널, 왼쪽에서 메뉴를 출력하는 메뉴 패널, 
 *     오른쪽에 업무 처리를 위한 화면을 구성하는 업무 패널 등 3개의 패널로 구성된다.
 *      
 *   o 왼쪽 메뉴 패널의 첫 번째 업무인 외래환자 등록 버튼을 클릭하면 오른쪽 업무 패널에 환자번호, 환자이름, 환자 나이, 
 *     진료날짜 등 환자정보를 입력하는 화면이 나타난다. 
 *      
 *   o 환자정보를 입력한 후 오른쪽 밑의 외래환자 등록 OK 버튼을 클릭하면 입력된 환자정보로부터 OutPatient 객체를 생성하고 
 *     이를 Hospital System 클래스의 enrolPatient() 메소드를 이용하여 allPatients[] 배열에 저장한다.
 *     
 *   o 새로운 업무가 결정되면 업무 패널에 기존 업무를 위해 배치했던 컴포넌트를 제거하고 업무를 위한 새로운 컴포넌트를 배치한다.
 *     이에 대한 방법도 익히기 바란다.  

 */

class HospitalFrame extends JFrame {
	HospitalSystem hospital;  // 병원 객체를 저장하는 필드, 객체 생성자로 전달 받음

	JPanel titlePanel = new JPanel();   // 타이틀 버튼 배치할 패널 
	JPanel menuPanel = new JPanel();    // 업무 버튼 배치할 패널 
	JPanel taskPanel = new JPanel();  	// 업무 선택 후 업무별 정보 입력받을 패널
	
	int widthFrame = 700;
	int heightFrame = 500;
	
	// 위쪽 타이틀 패널 크기 및 배치 위치
	int widthTitlePanel = widthFrame - (10 * 2 + 5);    // 프레임 너비보다  25 작음 
	int heightTitlePanel = 45;  // 고정 크기 높이
	int xTitlePanel = 10;    	// 수평 여백 폭만큼 
	int yTitlePanel = 10;    	// 수직 여백 높이만큼

	// 왼쪽 아래 메뉴 패널 크기 및 배치 위치
	int widthMenuPanel = 130;  	// 고정 크기 너비
	int heightMenuPanel = heightFrame - (heightTitlePanel + 3 * 10 + 28) ; 	// 전체 - (타이틀 패널 높이 + 여백 10 3개 + 프레임 타이틀 높이 28)
	int xMenuPanel = 10;    	// 수평 여백 10 1개
	int yMenuPanel = heightTitlePanel + 2 * 10;    // 타이틀 패널 높이 + 수직 여백 10 2개

	// 오른쪽 아래 업무 패널 크기 및 배치 위치
	int widthTaskPanel = widthFrame - (widthMenuPanel + 10 * 3 + 5);		// 전체 - (메뉴 패널 너비 + 여백 10 3개 + 5)
	int heightTaskPanel = heightFrame - (heightTitlePanel + 3 * 10 + 28);  	// 전체 - (타이틀 패널 높이 + 여백 10 3개 + 프레임 타이틀 높이 28) 
	int xTaskPanel = widthMenuPanel + 10 * 2;      // 메뉴 패널 너비 + 수평 여백 10 2개
	int yTaskPanel = heightTitlePanel + 10 * 2;    // 타이틀 패널 높이 + 수직 여백 10 2개
	
	JLabel titleLb = new JLabel();

	// 병원 업무를 위한 5개의 업무 버턴
	JButton enrolOutPatientBt = new JButton("외래환자 등록"), 
			enrolInPatientBt = new JButton("입원환자 등록"), 
			listPatientsBt = new JButton("    환자 보기    "), 
			treatBt = new JButton("    환자 진료    "), 
			leaveBt = new JButton("    환자 퇴원    "),            
			payFeeBt = new JButton("  병원비 정산  ");

	// 업무 수행을 위한 정보 입력 확인 버턴
	JButton enrolOutPatientOkBt = new JButton("외래환자 등록하기"),
			enrolInPatientOkBt = new JButton("입원환자 등록하기"),
			treatSelectedOkBt =  new JButton("선택한 환자 진료하기"), 
			treatOkBt =  new JButton("환자 진료하기"), 
			leaveOkBt =  new JButton("환자 퇴원하기"),
			payFeeOkBt = new JButton("병원비 정산하기");
	
	// JLabel 필드 선언
	JLabel welcomeLb = new JLabel("환영합니다. 업무 선택하기 바랍니다."),
	       patientNoLb =   new JLabel("  환자 번호:"),
		   patientNameLb = new JLabel("  환자 이름:"), 
		   patientAgeLb =  new JLabel("  환자 나이:"),

		   dateTreatLb =   new JLabel("  치료 날짜:"), 
	       dateHospitalLb =   new JLabel("  입원 날짜:"), 
	       treatMinutesLb =   new JLabel("  진료 시간:"), 

	       patientFeeLb =  new JLabel("      병원비:"); 
	
	// JTextField 필드 선언	
	JTextField patientNoField = new JTextField(12), 
			patientNameField = new JTextField(12), 
			patientAgeField = new JTextField(12),
			dateTreatField = new JTextField(12),
			dateHospitalField = new JTextField(12), 
			treatMinutesField = new JTextField(12), 
			patientFeeField = new JTextField(12);

	// 객체 생성자
	HospitalFrame(HospitalSystem aHospital, String title) { 
		
		super(title);
		
		hospital = aHospital; // 주어진 병원 객체를 hospital 필드에 저장
		
		titleLb.setText(title);
		
		setFrameAndPanels();         // 프레임과 패널들 설정
		enrolTaskButtonListener();   // 업무 수행을 위한 업무 버튼에 리스너 등록
		enrolTaskOkListener();       // 업무 확인버튼에 리스너 등록
				
		setVisible(true);  
	}

	// 프레임과 패널들을 설정하는 메소드
	void setFrameAndPanels() {
		
		this.setSize( widthFrame, heightFrame);  
		this.setLocation(420, 220);  // 윈도우를 (420, 220) 위치에 배치
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 옵션 지정
		this.setResizable(false);
		this.setLayout(null);        // 컴포넌트 배치방식을 수동 배치로 

		/*
		 *  타이틀 패널 설정: 타이틀 출력
		 */
		titlePanel.setBounds(xTitlePanel, yTitlePanel, widthTitlePanel, heightTitlePanel);
		titlePanel.setBackground(Color.green);
		
		setJLabel(titleLb, "신명조", Font.BOLD, 24);
		titlePanel.add(titleLb);
		
		add(titlePanel);

		/*
		 * 메뉴 패널 설정: 5개의 업무 버튼 배치
		 */
		menuPanel.setBounds(xMenuPanel, yMenuPanel, widthMenuPanel, heightMenuPanel);
		menuPanel.setBackground(Color.cyan);		
		add(menuPanel);
		
		Dimension d = enrolOutPatientBt.getPreferredSize();

		int widthBt = d.width;
		int heightBt = d.height;
		
		int hGap = (widthMenuPanel - widthBt) / 2;
		int vGap = (heightMenuPanel - heightBt * 6) / (6 + 1) ;
		
		menuPanel.setLayout(new FlowLayout(FlowLayout.CENTER, hGap, vGap)); // 컴포넌트 배치방식을 flow layout 배치로 
		menuPanel.add(enrolOutPatientBt);
		menuPanel.add(enrolInPatientBt);
		menuPanel.add(listPatientsBt);
		menuPanel.add(treatBt);
		menuPanel.add(leaveBt);       
		menuPanel.add(payFeeBt);

		/*
		 * 업무 패널 설정: 
		 */
		taskPanel.setBounds(xTaskPanel, yTaskPanel, widthTaskPanel, heightTaskPanel);
		taskPanel.setBackground(Color.yellow);
		
		taskPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 100));

		setJLabel(welcomeLb, "신명조", Font.BOLD, 17);
		taskPanel.add(welcomeLb);
		
		add(taskPanel);
	}
	
	// 병원 업무 버튼에 Action 리스너 클래스 등록시킴
	void enrolTaskButtonListener(){
		ActionListener al = new TaskActionListener();
		
		enrolOutPatientBt.addActionListener(al);
		enrolInPatientBt.addActionListener(al);
		treatBt.addActionListener(al);
		listPatientsBt.addActionListener(al);
		leaveBt.addActionListener(al);          
		payFeeBt.addActionListener(al);
	}

	// 병원 업무 버튼을 위한 ActionListener을 상속받은 Action 리스너  클래스
	class TaskActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();  // 선택된 버튼 객체를 알아냄
	
			if (b == enrolOutPatientBt) // 이벤트가 발생한 버튼이 외래환자 등록 버튼이면
				showEnrolOutPatient();  //     showEnrolOutPatient() 메소드 호출
			if (b == enrolInPatientBt)  // 이벤트가 발생한 버튼이 입원환자 등록 버튼이면
				showEnrolInPatient();   //     showEnrolInPatient() 메소드 호출
			if (b == listPatientsBt)    // 이벤트가 발생한 버튼이 환자 리스 버튼이면
				showListPatients();     //     showListPatients() 메소드 호출
			if (b == treatBt)           // 이벤트가 발생한 버튼이 환자 진료 버튼이면
				showTreat();            //     showTreat() 메소드 호출
			if (b == leaveBt)           // 이벤트가 발생한 버튼이 환자 퇴원 버튼이면
				showLeaveHospital();    //     showLeaveHospital() 메소드 호출  
			else if (b == payFeeBt)     // 이벤트가 발생한 버튼이  병원비 정산 버튼이면
				showPayFee();           //     showPayFee() 메소드 호출

		}
	}
	
	// 병원 업무 위한 정보 입력 후 확인 버튼에 Action 리스너를 등록시킴
	void enrolTaskOkListener() {
		
		ActionListener al = new TaskOkActionListener();
		
		enrolOutPatientOkBt.addActionListener(al);
		enrolInPatientOkBt.addActionListener(al);
		treatOkBt.addActionListener(al);
		leaveOkBt.addActionListener(al);
        payFeeOkBt.addActionListener(al);

	}

	// 업무 처리를 위한 정보 입력 후 확인 버튼이 클릭될 때의 Action 리스너 클래스
	class TaskOkActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();// 선택된 버튼 객체를 알아냄
			
			// 이벤트가 발생한 OK 버튼이 외래환자 등록 Ok 버튼이면
			// doEnrolOutPatient() 메소드를 호출
			if (b == enrolOutPatientOkBt)  // 이벤트가 발생한 버튼이 입원환자 등록 확인 버튼이면
				doEnrolOutPatient();       //    doEnrolInPatient() 메소드 호출
			if (b == enrolInPatientOkBt)   // 이벤트가 발생한 버튼이 입원환자 등록 확인 버튼이면
				doEnrolInPatient();        //    doEnrolInPatient() 메소드 호출
			if (b == treatOkBt)            // 이벤트가 발생한 버튼이 환자 진료 확인 버튼이면
				doTreat();                 //    doTreat() 메소드 호출
			if (b == leaveOkBt)            // 이벤트가 발생한 버튼이 환자 퇴원 확인 버튼이면
				doLeaveHospital();         //    doLeaveHospital() 메소드 호출  
			else if (b == payFeeOkBt)      // 이벤트가 발생한 버튼이 병원비 정산 확인 버튼이면
				doPayFee();	               //    doPayFee() 메소드 호출	
			
			// 확인 버튼에 따라 나머지 해당 업무를 수행하는 메소드 호출하라.
		}
	}

	// 외래환자 등록 버튼이 클릭되면 수행되는 메소드
	//   외래환자 정보를 입력하기 위한 컴포넌트들과 확인 버튼을 업무 패널에 배치
	void showEnrolOutPatient() {

		taskPanel.setVisible(false);  // 기존에 배치된 컴포넌트 제거하기 위해 false로 하여 사라지게 함
		taskPanel.removeAll();        // taskPanel의 모든 컴포넌트를 제거
		
		taskPanel.setLayout(null);

		JLabel titleLb = new JLabel("   외래환자 등록     ");
		setJLabel(titleLb, Color.cyan, "신명조", Font.BOLD, 17);

		patientNameField.setText("");  
		patientAgeField.setText("");  
		
		// 외래 환자 정보 입력 위한 컴포넌트와 등록 확인 버튼을 taskPanel에 배치시킴
		
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

		taskPanel.setVisible(true);   // 업무 패널을 true로 하여 나타나게 함
	}
	
	// 외래 환자 등록을 처리하는 메소드
	void doEnrolOutPatient() {
				
		// 입력된 이름이 올바른 이름인지 확인 
		String name = patientNameField.getText();  
		if (isInvalidPatientname(name)) {			
			showEnrolOutPatient();  // 다시 외래 환자 등록하게 함
			return;
		}
		
		// 입력된 나이가 올바른 나이인지 확인 
		String ageString = patientAgeField.getText();  
		if (isInvalidAgeString(ageString)) {			
			showEnrolOutPatient();  // 다시 외래 환자 등록하게 함
			return;
		}
		
		int age = Integer.valueOf(ageString);
		
		/*
		 * 업무 패널에 새로운 환자 정보를 디스플레이시키기 위해 패널 초기화
		 */			
		taskPanel.setVisible(false);  // 기존에 배치된 컴포넌트 제거하기 위해  false로 하여 사라지게 함
		taskPanel.removeAll();        // taskPanel의 모든 컴포넌트 제거
		
		taskPanel.setLayout(null);

		/*
		 * 배치할 컴포넌트 설정
		 */
		JLabel titleLb = new JLabel("   등록된  외래환자    ");
		setJLabel(titleLb, Color.cyan, "신명조", Font.BOLD, 17);

		int patientNo = hospital.getNewPatientNo();  // 새로운 환자번호를 Hospital 객체에서 구함
		patientNoField.setText("   "+ patientNo);  
		
		patientNameField.setText("   " + name);  
		patientAgeField.setText("   " + ageString);  

		
		java.util.Date dateTreat = new java.util.Date();   // 진료날짜는 오늘로 설정
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 M월 d일(E)");
		String dateTreatString = sdf.format(dateTreat);    // dateTreat를 포매팅한 문자열 반환
		dateTreatField.setText("   " + dateTreatString);
		
		/*
		 * 업무 패널에 컴포넌트 배치
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

		taskPanel.setVisible(true);  // 업무 패널을 true로 하여 나타나게 함
		
		// 입력된 외래 환자 정보로 외래 환자 객체를 병원에 등록시킴
		hospital.enrolOutPatient(patientNo, name, age, dateTreat);		
	}
	
	static final int LEFT=0, CENTER=1, RIGHT=2; // JTable의 각 셀의 정렬방식(왼쪽, 중앙, 오른쪽)을 지정하기 위한 상수변수
	
	// 환자 리스트 버튼 클릭되면 수행되는 메소드
	//    환자 리스트를 보여주고 선택된 환자를 진료하게 함
	void showListPatients() {
		/*
		 * 업무 패널에 새로운 환자 정보를 디스플레이시키기 위해 패널 초기화
		 */			
		taskPanel.setVisible(false);  // 기존에 배치된 컴포넌트 제거하기 위해  false로 하여 사라지게 함
		taskPanel.removeAll();        // taskPanel의 모든 컴포넌트 제거
		
		taskPanel.setLayout(null);

		/*
		 * 배치할 컴포넌트 설정
		 */
		JLabel titleLb = new JLabel("   모든 환자  리스트    ");
		setJLabel(titleLb, Color.cyan, "신명조", Font.BOLD, 17);
		
		/*
		 * 업무 패널에 컴포넌트 배치
		 */
		titleLb.setSize(titleLb.getPreferredSize());
		titleLb.setLocation(190, 50);
		taskPanel.add(titleLb);

		Vector<Patient> patients = hospital.getAllPatients();
		int noPatients = patients.size();

		String[] attrnames = { "환자번호", "환자종류", "환자이름", "나이", "진료시간", "병원비"}; // 테이블 형태로 출력할, 환자 정보의  애트리뷰트들  
		
		Object[][] tuples = new Object[noPatients][6];
		for (int i = 0; i < noPatients; i++) {             // 계좌 객체들의 필드들을 테이블 형태로 출력하기 위해 2차원 배열로 구성
			Patient p = patients.get(i);

			tuples[i][0] = p.pno;
			tuples[i][1] = (p instanceof  OutPatient) ? "외래환자" : "입원환자";
			tuples[i][2] = p.name;
			tuples[i][3] = p.age;
			tuples[i][4] = p.minutesTreat ;
	
			tuples[i][5] = p.getPayFee();
		}

		// "환자번호", "환자종류", "환자이름", "나이", "진료시간", "병원비"애 대한  정렬방식을 설정
		int[] alignments = { CENTER, CENTER, CENTER, RIGHT, RIGHT, RIGHT };

		JTable tbl = setupJTable(attrnames, tuples, alignments);
		JScrollPane sc = getScrollPaneWithJTable(tbl);
		
		titleLb.setSize(titleLb.getPreferredSize());
	 	sc.setLocation(36, 90);
	 	taskPanel.add(sc);


		taskPanel.setVisible(true);  // 업무 패널을 true로 하여 나타나게 함

	}
	
	
	/*
	 * JTable의 각 애트리뷰트를 주어진 정렬방식으로 정렬하기 위한 부분	
	 */
	
	static int DEFALTCELLHEIGHT = 20;  // 테이블의 셀 높이 디폴트 값
	
	// 주어진 attrnames[] 배열과  tuples[][] 이차원 배열에 대해 JTable 객체를 생성하여 반환
	static JTable setupJTable(String[] attrnames, Object[][] tuples) {
		JTable jTable = new JTable(tuples, attrnames);   	// JTable 객체 생성 - tuples: 이차원 배열, attrnames: 1차원 배열 

		JTableHeader header = jTable.getTableHeader();		// 테이블의 헤더를 구함 	
		header.setBackground(Color.cyan);                   // 테이블의 헤더 색상 설정
		header.setFont(new Font("고딕체", Font.BOLD, header.getFont().getSize())); // 테이블의 헤더 텍스를 bold로 설정

		jTable.setBackground(Color.cyan);                  // 테이블의 배경 색상 설정
		jTable.setForeground(Color.black);                 // 테이블의 전경(글자) 색상 설정
		jTable.setRowHeight(DEFALTCELLHEIGHT);             // 테이블의 셀 높이 설정

		return jTable;
	}

	static DefaultTableCellRenderer dtcrLeft = new DefaultTableCellRenderer(); // 디폴트 테이블 셀 렌더러 생성
	static DefaultTableCellRenderer dtcrCenter = new DefaultTableCellRenderer(); // 디폴트 테이블 셀 렌더러 생성
	static DefaultTableCellRenderer dtcrRight = new DefaultTableCellRenderer(); // 디폴트 테이블 셀 렌더러 생성
	
	static {
		dtcrLeft.setHorizontalAlignment(SwingConstants.LEFT); // 렌더러의 수평 정렬을 LEFT로
		dtcrCenter.setHorizontalAlignment(SwingConstants.CENTER); // 렌더러의 수평 정렬을 CENTER로
		dtcrRight.setHorizontalAlignment(SwingConstants.RIGHT); // 렌더러의 수평 정렬을 RIGHT로
	}

	static DefaultTableCellRenderer[] dtcrArray = { dtcrLeft, dtcrCenter, dtcrRight };

	static  JTable setupJTable(String[] attrnames, Object[][] tuples, int[] alignments) {
		JTable jTable = setupJTable(attrnames, tuples);

		TableColumnModel tcm = jTable.getColumnModel() ; // 정렬할 테이블의 컬럼모델을 가져옴

		// 각각의 애트리뷰트(컬럼)에 대해 주어진 정렬방식(0: 왼쪽 정렬, 1: 중앙 정렬, 2: 오른쪽 정렬)을  지정
		// 컬럼모델에서 컬럼의 갯수만큼 컬럼을 가져와 for문을 이용하여 주어진 정렬방식으로 설정
		for(int i = 0 ; i < tcm.getColumnCount() ; i++){   		
			// 각각의 셀렌더러를 alignments[i]의 값에 따라 설정
			tcm.getColumn(i).setCellRenderer(dtcrArray[alignments[i]]);  
		}

		return jTable;		
	}
	
	// 주어진 JTable 객체를 포함하는 JScrollPane 객체 생성하여 반환
	//    이때, JScrollPane 객체 크기는 JTable 객체 크기보다 +5 해야 깔끔하게 출력됨
	static JScrollPane getScrollPaneWithJTable(JTable jTable) {
		jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);  	// JTable이 JScrollPane에서 사이즈 변경되지 못하게 설정        

		JScrollPane sc = new JScrollPane(jTable);  			// JTable 객체를 JScrolPane 객체에 배치

		Dimension dimJTable = jTable.getPreferredSize();	// JTable의 크기는  getPreferredSize() 메소드로 구해야 함(?)
		int jTableWidth = dimJTable.width; 					// 전체 테이블의 폭 구함
		int rowCount = jTable.getRowCount();        		// 테이블에 저장된 투플 개수 구함
		int jTableHeight = (rowCount + 1) * jTable.getRowHeight(); //  전체 테이블 높이 구함(전체 높이 = 투플 개수 * 셀 높이 + 헤더 높이)

		sc.setSize(jTableWidth + 5, jTableHeight + 5);      // JScrollPane 객체 크기 설정: +5 해야함
		
		return sc;
	}


	// 병원비 정산 버튼이 클릭되면 수행되는 메소드
	//   환자 번호를 입력하기 위한 컴포넌트들과 확인 버튼을 업무 패널에 배치
	void showPayFee() {
		
		taskPanel.setVisible(false);  // 기존에 배치된 컴포넌트 제거하기 위해 false로 하여 사라지게 함
		taskPanel.removeAll();        // taskPanel의 모든 컴포넌트를 제거

		taskPanel.setLayout(null);
		
		JLabel titleLb = new JLabel("   병원비 정산   "); 
		setJLabel(titleLb,Color.cyan, "신명조", Font.BOLD, 17);

		patientNoField.setText("10001");  

		
		// 환자 번호 입력위한 컴포넌트와 병원비 정산 확인 버튼을 taskPanel에 배치시킴
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
		taskPanel.add(payFeeOkBt); // 이 버튼이 클릭되면 이벤트 처리됨
		
		taskPanel.setVisible(true);  // 업무 패널을 true로 하여 나타나게 함
	}
	
	// 병원비 정산 처리하는 메소드
	void doPayFee() {	

		// 입력된 환자 번호가 올바른  환자 번호인가 검사
		String pnoString = patientNoField.getText();  
		if (isInvalidPatientNoString(pnoString)) {			
			showPayFee();
			return;
		}
		
		/*
		 * 입력된 환자 번호의 환자 객체 구함
		 */
		int pno = Integer.valueOf(pnoString);		
		Patient p = hospital.getPatient(pno);
		
		if (p == null) {
			JOptionPane.showMessageDialog(this, "\"" + pno + "\" : 환자 번호의 환자가 없습니다.", 
                	"ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE); 
			
			showPayFee();
			return;
		}
		
		/*
		 * 업무 패널에 새로운 환자 정보를 디스플레이시키기 위해 패널 초기화
		 */
		taskPanel.setVisible(false);  // 기존에 배치된 컴포넌트 제거하기 위해 false로 하여 업무 패널 사라지게 함
		taskPanel.removeAll();        // taskPanel의 모든 컴포넌트 제거
		
		taskPanel.setLayout(null);	

		/*
		 * 배치할 컴포넌트 설정
		 */
		JLabel titleLb = new JLabel("   정산 결과   ");
		titleLb.setOpaque(true);
		titleLb.setBackground(Color.cyan);
		titleLb.setFont(new Font("신명조", Font.BOLD, 17));

		taskPanel.add(titleLb);

		patientNoField.setText("   "+ pno);  
		patientNameField.setText("   " + p.name);
		patientAgeField.setText("   " + p.age);  	
		
		int fee = p.getPayFee();                // 환자의 진료비를 구함
		patientFeeField.setText("   " + fee);  
		
		/*
		 * 업무 패널에 컴포넌트 배치
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

		taskPanel.setVisible(true);  // 업무 패널을 true로 하여 나타나게 함
	}
	
	
	// 입원환자 등록 버튼이 클릭되면 수행되는 메소드
	//   입원환자 정보를 입력하기 위한 컴포넌트들과 확인 버튼 배치
	void showEnrolInPatient() {
		taskPanel.setVisible(false);  // 기존에 배치된 컴포넌트 제거하기 위해 false로 하여 업무 패널 사라지게 함 
		taskPanel.removeAll();        // taskPanel의 모든 컴포넌트 제거
		
		taskPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 50));

		JLabel lb = new JLabel(" 작성되지 않았습니다. ");
		setJLabel(lb, Color.cyan, "신명조", Font.BOLD, 17);

		taskPanel.add(lb);
		
		taskPanel.setVisible(true);  // 업무 패널을 true로 하여 나타나게 함
	}

	void doEnrolInPatient() {
		// 작성하라.
	}
	
	void showTreat() {
		taskPanel.setVisible(false);  // 기존에 배치된 컴포넌트 제거하기 위해 false로 하여 업무 패널 사라지게 함
		taskPanel.removeAll();        // taskPanel의 모든 컴포넌트 제거
		
		taskPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 50));

		JLabel lb = new JLabel(" 작성되지 않았습니다. ");
		setJLabel(lb, Color.cyan, "신명조", Font.BOLD, 17);

		taskPanel.add(lb);
		
		taskPanel.setVisible(true);  // 업무 패널을 true로 하여 나타나게 함
	}
	
	void doTreat() {
		// 작성하라.
	}
	
	void showLeaveHospital() {
		taskPanel.setVisible(false);  // 기존에 배치된 컴포넌트 제거하기 위해 false로 하여 업무 패널 사라지게 함
		taskPanel.removeAll();        // taskPanel의 모든 컴포넌트 제거
		
		taskPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 50));

		JLabel lb = new JLabel(" 작성되지 않았습니다. ");
		setJLabel(lb, Color.cyan, "신명조", Font.BOLD, 17);

		taskPanel.add(lb);
		
		taskPanel.setVisible(true);  // 업무 패널을 true로 하여 나타나게 함

	}

	void doLeaveHospital() {
		// 작성하라.

	}

	/*
	 * 편리한 프로그래밍을 위한 메소드들 
	 */

	// JLabel의 속성 설정 메소드
	void setJLabel(JLabel lb, Color color, String fontname, int fontStyle, int size) {
		lb.setOpaque(true);
		lb.setBackground(color);
		lb.setFont(new Font(fontname, fontStyle, size));
		
	}	
	
	// JLabel의 속성 설정 메소드
	void setJLabel(JLabel lb, String fontname, int fontStyle, int size) {
		lb.setFont(new Font(fontname, fontStyle, size));
		
	}	
	
	// 주어진 이름이 올바른 문자열 아니면 오류 창을 띄우고 false 반환하는 메소드
	boolean isInvalidPatientname(String name) {
		if (name.equals("")) {
			JOptionPane.showMessageDialog(this, "이름이 입력되지 않았습니다", 
					"ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE); 
			return true;
		}
		else
			return false;
	}
	
	// 주어진 나이 문자열이 올바른 나이 문자열 아니면 오류 창을 띄우고 false 반환하는 메소드
	boolean isInvalidAgeString(String ageString) {
		int age;
		
		if (ageString.equals("")) {
			JOptionPane.showMessageDialog(this, "나이가 입력되지 않았습니다", 
					"ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE); 
			return true;
		}

		try {
			age = Integer.parseInt(ageString);

			if (age < 0) {
				JOptionPane.showMessageDialog(this, age + " : 나이는 0 이상이어야 합니다.", 
						"ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE); 

				return true;
			}				
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(this, "\"" + ageString + "\" : 나이는 정수이어야 합니다.", 
					"ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE); 

			return true;
		}

		return false;
	}
	
	// 주어진 환자 번호 문자열이 올바른 환자 번호 문자열 아니면 오류 창을 띄우고 false 반환하는 메소드
	boolean isInvalidPatientNoString(String pnoString) {
		int pno;
		
		if (pnoString.equals("")) {
			JOptionPane.showMessageDialog(this, "환자 번호가 입력되지 않았습니다", 
					"ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE); 
			return true;
		}

		try {
			pno = Integer.parseInt(pnoString);

			if (pno <= 0) {
				JOptionPane.showMessageDialog(this, pno + " : 환자 번호는 양수이어야 합니다.", 
						"ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE); 

				return true;
			}				
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(this, "\"" + pnoString + "\" : 환자 번호는 정수이어야 합니다.", 
					"ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE); 

			return true;
		}

		return false;
	}
}
