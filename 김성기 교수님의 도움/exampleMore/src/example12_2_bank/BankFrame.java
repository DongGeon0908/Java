package example12_2_bank;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

import java.util.*;
import java.text.*;         // DateFormat 클래스를 위하여 import

/**
 * o GUI 환경에서 은행업무를 처리하는 Java 프로그램
 *   - 은행업무 메뉴버튼을 통해 은행업무를 선택하고
 *     업무별 필요한 자료를 입력한 후 확인버튼을 클릭하면 특정 업무 수행
 *    
 *   - 업무를 처리하기 위한 메인 화면은 3가지 화면 타입 중 하나가 랜덤하게 선택
 *     (이는 PanelMgmt 클래스의 여러 메소드를 이용하면 GUI 화면 구성이 아주 용이함을 보여주기 위함)
 */

public class BankFrame extends JFrame {
	static  int defaultFrameWidth = 1200;    // 프레임의  디폴트 너비
	static  int defaultFrameHeight = defaultFrameWidth / 16 * 9;   // 프레임의 디폴트 높이, 너비 높이 비율을 16 : 9로 설정

	static int TOPCENTERframe = 1;
	static int TOPLEFTCENTERframe = 2;	
	static int TOPCENTERBOTTOMframe = 3;

	static int hGap = 5;
	static int vGap = 5;
	static int heightTop = 80;
	static int widthLeft = 120;
	static int heightBottom = 60;

	BankFrame thisFrame;

	int frameWidth;    // 프레임의 너비
	int frameHeight;   // 프레임의 높이 


	int frameType; // 패널 배치 방식에 따라 (위, 가운데), (위, 왼쪽, 중앙), (위, 중앙, 아래) 형태의  프레임 타입 구분

	JPanel  topPanel, leftPanel, centerPanel, bottomPanel;  // 전체 프레임을 2개 또는 3개의 패널로 나누어 업무 처리함
	JPanel  centerLeftPanel, centerRightPanel,  centerRightTopPanel,  centerRightBottomPanel;  // 중앙 패널을 필요에 따라 분할하여 업무 처리 

	JLabel bankTitleLb;  // top 패널에 배치할 은행 타이틀 레이블

	// 은행 업무 메뉴를 위한 버턴
	JButton openAccountBt =  new JButton("계좌 개설"),  listBt  = new JButton("계좌 리스트"), 
			depositBt     = new JButton("계좌 입금"),   withdrawBt  = new JButton("계좌 출금"),
			transferBt    = new JButton("계좌 이체"),   outputOwnerInfoBt = new JButton("소유자정보 조회"),
			outputTransactionInfoBt = new JButton("계좌 작업내역 조회"),  enrolBankerBt  = new JButton("은행원 등록");

	// 업무 메뉴별 확인 버튼
	JButton openAccountOKBt  = 	new JButton("계좌 개설 확인"), 
			depositOKBt  = 	new JButton("입금 확인"),       withdrawOKBt = new JButton("출금 확인"), 
			transferOKBt = new JButton("이체 확인"),        outputOwnerInfoOKBt = new JButton("소유자정보 확인"),
			outputTransactionInfoOKBt = new JButton("작업내역 확인"), enrolBankerOKBt  = new JButton("은행원 등록 확인");

	// 입력되는 컴포넌트를 저장하기 위한 JComponent 배열 변수인  inputComps의 선언
	// 이 배열 변수는 모든 업무에서 입력 정보를 차례로 저장하기 위해 사용됨
	JComponent[] inputComps = new JComponent[20];


	// 너비와 폭이 주어지지 않으면 디폴트  크기로  프레임을 생성하는 객체 생성자
	BankFrame() {
		this(defaultFrameWidth, defaultFrameHeight);
	}

	// 너비와 폭이 주어지면 그 크기의 프레임을 생성하는 객체 생성자
	BankFrame(int width, int height) {
		// JFrame 자체에 대한 설정
		thisFrame = this;

		frameWidth = width;    // 프레임의 너비 길이
		frameHeight = height;

		setTitle("은행 업무 시스템");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		setLayout(null);
		setSize(frameWidth, frameHeight);

		// 모니터 해상도(너비 픽셀수, 높이 픽셀수) 가져오기
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int w = (int) screen.getWidth();  // 모니터 너비 크기
		int h = (int) screen.getHeight(); // 모니터 높이 크기

		// 프레임을 화면 중앙에 배치
		setLocation((w - frameWidth) / 2, (h- frameHeight)/2);

		// topPanel에 배치할 은행 타이틀 레이블 설정(  
		bankTitleLb = new JLabel("은행 업무 시스템"); 
		bankTitleLb.setFont(new Font("고딕체", Font.BOLD, 28));
		bankTitleLb.setSize(350, 50);	
		bankTitleLb.setBackground(new Color(150, 170, 100)); // Color(255, 0, 105): 		
		bankTitleLb.setFocusable(false); 
		bankTitleLb.setOpaque(true); 
		bankTitleLb.setHorizontalAlignment(JLabel.CENTER);

		// 매번 수행할 때마다 3가지 업무 화면 중 하나를 랜덤하게 선택하게 함 
		//   java.lang.Math.random() 메소드는 0이상 1 미만의 실수값을 반환함
		int frameType = (int) (java.lang.Math.random() * 3 ) + 1 ;  // n에는 0, 1, 2 중의 한 값이 저장됨
		if (frameType==TOPCENTERframe)
			displayTopCenterFrameType();
		else if (frameType==TOPLEFTCENTERframe)
			displayTopLeftCenterFrameType();
		else if (frameType==TOPCENTERBOTTOMframe)
			displayTopCenterBottomFrameType();			

		addListenerToButtons();  // 업무 처리를 위한 메뉴 버튼과 확인 버튼에 리스너를 설정

		setVisible(true);	

		addResizeButton();
	}

	// 전체 프레임을 top, center 등 2 영역으로 구분하여 각 영역에 JPanel 객체를 배치시킴
	void displayTopCenterFrameType(){
		frameType = 1;

		// 이를 위해 SubPanelCreation.createSubPanelsTopCenter() 메소드가 이용됨
		Container[] subPanels = SubPanelCreation.createSubPanelsTopCenter(this, 120, Color.green, Color.yellow, 5);

		// topPanel, centerPanel에 필요한 컴포넌트 배치
		topPanel = (JPanel) subPanels[0];
		centerPanel = (JPanel) subPanels[1];		

		// topPanel에 은행 타이틀과 메뉴 버튼을 배치
		JComponent comps[][] = { { openAccountBt,  listBt,     depositBt, 
			withdrawBt, transferBt,  outputOwnerInfoBt, outputTransactionInfoBt, enrolBankerBt, resizeBt} };

		// topPanel에 은행 타이틀과 은행업무를 위한 메뉴 레이블을 1줄에 배치
		PanelMgmt.displayComponents(this, topPanel, bankTitleLb, comps, null);

		// centerPanel에 환영 메시지 출력을 위한 레이블 배치
		displayInitialCenterPanel();
	}

	// 전체 프레임을 top, left, center 등 3 영역으로 구분하여 각 영역에 JPanel 객체를 배치시킴
	void displayTopLeftCenterFrameType(){

		frameType = 2;

		// 이를 위해 SubPanelCreation.createSubPanelsTopLeftCenter() 메소드가 이용됨
		Container[] subPanels = SubPanelCreation.createSubPanelsTopLeftCenter(this, 80, 160, Color.green, Color.orange, Color.yellow, 5);

		// 배치된 3영역의 JPanel 객체들을 topPanel, leftPanel, centerPanel에 각각 저장
		topPanel = (JPanel) subPanels[0];
		leftPanel = (JPanel) subPanels[1];
		centerPanel = (JPanel) subPanels[2];

		// topPanel에 은행 타이틀을 위한 레이블 배치
		PanelMgmt.displayComponents(this, topPanel, bankTitleLb);

		JComponent comps[][] = { { openAccountBt}, { listBt },     { depositBt }, 
				{withdrawBt},     { transferBt }, { outputOwnerInfoBt }, { outputTransactionInfoBt }, { enrolBankerBt }, { resizeBt} };

		// leftPanel에 은행업무를 위한 메뉴 버튼을 배치 - 1줄에 1 메뉴씩 배치함
		PanelMgmt.displayComponents(this, leftPanel, comps);	

		// centerPanel에 환영 메시지 출력을 위한 레이블 배치
		displayInitialCenterPanel();
	}

	// 전체 프레임을 top, center, bottom 등 3 영역으로 구분하여 각 영역에 JPanel 객체를 배치시킴
	void displayTopCenterBottomFrameType(){
		frameType = 3;

		// 이를 위해 SubPanelCreation.createSubPanelsTopCenterBottom() 메소드가 이용됨
		Container[] subPanels = SubPanelCreation.createSubPanelsTopCenterBottom(this, 80, 60, Color.green, Color.yellow, Color.orange, 5);

		// 배치된 3영역의 JPanel 객체들을 topPanel, centerPanel, bottomPanel에 각각 저장
		topPanel = (JPanel) subPanels[0];
		centerPanel = (JPanel) subPanels[1];
		bottomPanel = (JPanel) subPanels[2];

		// topPanel에 은행 타이틀 출력을 위한 레이블 배치
		PanelMgmt.displayComponents(this, topPanel, bankTitleLb);

		// centerPanel에 환영 메시지 출력을 위한 레이블 배치
		displayInitialCenterPanel();

		// 배치할 메뉴 버튼을 1차원 배열로 만들어 coms에 저장
		JComponent comps[] = { openAccountBt, listBt, depositBt, 
				withdrawBt, transferBt, outputOwnerInfoBt, outputTransactionInfoBt, enrolBankerBt, resizeBt };

		// bottomPanel에 은행업무를 위한 메뉴 버튼들을 배치 - 1줄에 9 메뉴씩 배치함
		PanelMgmt.displayComponents(this, bottomPanel,  null, 9, comps, null);
	}

	// centerPanel에 초기의 환영 메시지를 위한 JLabel 배치 
	void displayInitialCenterPanel() {
		JLabel welcomeLabel = new JLabel("환영합니다!."); 
		welcomeLabel.setForeground(Color.blue);
		welcomeLabel.setFont(new Font("고딕체", Font.BOLD, 20));
		//		welcomeLabel.setSize(welcomeLabel.getPreferredSize());		

		PanelMgmt.displayComponents(this, centerPanel, welcomeLabel);
	}

	// 업무 메뉴 버튼과 확인 버튼에 리스너를 연결시켜 버튼 클릭 시 이벤트 처리하게 함
	void addListenerToButtons() {

		// 업무 메뉴 버튼에 BankMenuListener를 add하여 메뉴 버튼이 클릭되면 해당 업무작업을 수행하게위한 정보를 입력하게 함
		ActionListener listener = new BankMenuListener();

		openAccountBt.addActionListener(listener);
		listBt.addActionListener(listener);
		depositBt.addActionListener(listener);
		withdrawBt.addActionListener(listener);
		transferBt.addActionListener(listener);
		outputOwnerInfoBt.addActionListener(listener);
		outputTransactionInfoBt.addActionListener(listener);
		enrolBankerBt.addActionListener(listener);

		// 업무 확인 버튼에 BankConfirmListener를 add하여 업무별 OK 버튼이 클릭되면 입력된 정보로 해당 업무를 완료하게 함
		listener = new BankConfirmListener();

		openAccountOKBt.addActionListener(listener);
		depositOKBt.addActionListener(listener);	
		withdrawOKBt.addActionListener(listener);
		transferOKBt.addActionListener(listener);
		outputOwnerInfoOKBt.addActionListener(listener);
		outputTransactionInfoOKBt.addActionListener(listener);
		enrolBankerOKBt.addActionListener(listener);
	}

	//  은행 업무 처리를 위한 메뉴 버튼이 클릭될 때의 Action 리스너
	class BankMenuListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			centerPanel.setVisible(false);
			centerPanel.removeAll();

			JButton b = (JButton)e.getSource();   // 클릭된 버튼 객체를 알아냄
			String cmd = e.getActionCommand();    // 클릭된 버튼 객체의 문자열 명령을 알아냄

			// 클릭된 메뉴 버튼의 종류에 따라 주어진 작업을 수행함
			if (cmd.equals("계좌 개설"))         //	if (b == openAccountBt) 로도 가능함
				doOpenAccount();			
			else if (cmd.equals("계좌 리스트"))   // if (b == listBt) 로도 가능함
				doListAccount();
			else  if (cmd.equals("계좌 입금"))   // if (b == depositBt) 로도 가능함
				doDeposit(); 
			else   if (cmd.equals("계좌 출금"))  // if (b == withdrawBt) 로도 가능함
				doWithDraw();
			else if (cmd.equals("계좌 이체"))    // if (b == TransferBt) 로도 가능함
				doTransfer();
			else  if (cmd.equals("소유자정보 조회")) // if (b == outputOwnerInfoBt) 로도 가능함
				doOutputOwnerInfo();				
			else  if (cmd.equals("계좌 작업내역 조회")) // if (b == outputTransactionInfoBt) 로도 가능함
				doOutputTransactionInfo();				
			else  if (cmd.equals("은행원 등록")) // if (b == enrolBankerBt) 로도 가능함
				doEnrolBankerBt();				
		}
	}

	JButton resizeBt = new JButton("크기 변경");

	void addResizeButton() {
		resizeBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {		
					String wString = JOptionPane.showInputDialog("너비 입력하시오"); 

					int w = Integer.parseInt(wString);
					String hString = JOptionPane.showInputDialog("높이 입력하시오"); 
					int h = Integer.parseInt(hString);

					new BankFrame(w, h);		
					dispose();  // 기존의 프레임을 제거함
				}
				catch(Exception ex) { }
			}
		});
	}

	// 업무에 사용되는 가상적인 이름들: 소유자, 입금자, 출금자, 이체자 등으로 사용됨
	static String[] names = { "홍길동", "박문수", "성춘향", "이몽룡", "변학도", "향단", "심청", "심학규", "허생"};

	// 업무에 사용되는 가상적인 이름들: 은행원 이름으로 사용됨
	static String[] bankerNames = { "홍길서", "박문산", "성추향", "이몽호", "심백", "허사"};

	// 업무에 사용되는 가상적인ID들: 은행원 ID로 사용됨
	static String[] bankerIDs = { "hgs34", "p1m2s3", "chslml", "chlove", "heart100", "hur4"};

	// 계좌 개설 업무 수행
	//   계좌 개설 버튼이 클릭되면 중앙 패널에 예금종류, 소유자, 초기입금액, 비밀번호를 입력할 수 있도록 컴포넌트를 배치하고  
	//   openAccountOKBt 버튼이 클릭되기를 기다림
	void doOpenAccount() {
		// 계좌 개설		
		String[] accountTypes = {"보통예금", "저축예금"};
		JComboBox cb = new JComboBox(accountTypes);    // 콤보박스에 "보통예금"과, "저축예금"을 아이템으로 설정 - 두 종류 중 선택하게 함
		cb.setSelectedIndex((int) (java.lang.Math.random() *  cb.getItemCount()) );  // 두 예금 종류중 하나를 랜덤으로 미리 선택해둠

		inputComps[0] = cb;
		inputComps[1] = new JTextField(names[(int) (java.lang.Math.random() *  names.length) ] );  // 소유자 입력받을 텍스트필드, 랜덤한 소유자 미리 설정
		inputComps[2] = new JTextField("" + (int) (java.lang.Math.random() * 100000) / 1000 * 1000); // 입금액을 입력할 텍스트필드, 랜덤한 입금액 미리 설정
		inputComps[3] = new JPasswordField("1234"); // 비밀번호를 입력할 패스워드필드, 비밀번호 1234 미리 설정

		JComponent[][]  openComps =   // 계좌 개설 화면에 배치할 입출력 컴포넌트들의 2차원배열을 생성
			{   { new JButton("계좌종류"),   inputComps[0] }, 
					{ new JButton("소유자"),     inputComps[1] }, 
					{ new JButton("초기입금액"), inputComps[2] },
					{ new JButton("비밀번호"),   inputComps[3] } }; 

		centerPanel.setVisible(false);
		centerPanel.removeAll();

		Container[] subPanels = SubPanelCreation.createSubPanelsLeftRight(centerPanel, 220, new Color(128, 255, 255), Color.pink, 5);
		centerLeftPanel = (JPanel) subPanels[0];
		centerRightPanel = (JPanel) subPanels[1];	

		// PanelMgmt 클래스의 displayComponents(this, ) 메소드로 계좌 개설을 위한 컴포넌트를 디스플레이
		PanelMgmt.displayComponents(this, centerLeftPanel, "계좌  개설", openComps, openAccountOKBt);  // 계좌 개설 화면에 컴포넌트를 배치하고 계좌 개설 정보 입력 대기

		JScrollPane scImg = JLabelMgmt.getScrollPaneWithJLabel(centerRightPanel, "images\\dog.jpg");		
		JComponent[][] comps = {{new JLabel("개좌 개설을 위한 정보 입력")}, {scImg}};

		PanelMgmt.displayComponents(this, centerRightPanel, comps);  // 계좌 개설 결과 화면에 컴포넌트를 배치

		centerPanel.setVisible(true);

	}

	// 모든 계좌 조회
	//    계좌 리스트 버튼이 클릭되면 중앙 패널에 모든 계좌 정보를 조회함
	void doListAccount() { 
		Account[] accs = BankSystem.getAllAccounts() ;  // 모든 계좌 객체를 배열에 가져옴(배열로 가져온 이유는 JTable을 이용하여 출력하기 위함임)

		displayAccounts(centerPanel, "계좌 리스트", accs);  // 배열에 저장된 계좌 객체를 화면에 출력
	}

	// 계좌 입금 업무 수행
	//   계좌 입금 버튼이 클릭되면 중앙 패널에 계좌번호, 입금자, 입금액을  입력할 수 있도록 컴포넌트를 배치하고  
	//   depositOKBt 버튼이 클릭되기를 기다림
	void doDeposit() {        // 계좌 입금 메뉴의 처리
		String[] accnos = BankSystem.getAllAccnos();   // 모든 계좌의 계좌번호들을 String 배열에 가져옴

		if (accnos.length==0) {   // 계좌번호가 0개, 즉 생성된 계좌가 없으면 오류 처리
			JOptionPane.showMessageDialog(null, "입금할 수 있는 계좌가 없습니다. 계좌 개설 하십시오", "입금 가능 계좌 없음", JOptionPane.ERROR_MESSAGE);
			return;
		}

		JComboBox cb = new JComboBox(accnos); // 콤보박스에 모든 계좌번호들을 아이템으로 설정 - 여러 계좌번호 중 하나를 선택하게 함
		cb.setSelectedIndex((int) (java.lang.Math.random() * cb.getItemCount() ));  // 여러 계좌번호 중 하나를 랜덤으로 미리 선택하게 함

		inputComps[0] = cb;
		inputComps[1] = new JTextField(names[(int) (java.lang.Math.random() * names.length )]);      // 입금자 입력받을 텍스트필드
		inputComps[2] = new JTextField("" + (int) (java.lang.Math.random() * 100000) / 1000 * 1000);   // 입금액 입력받을 텍스트필드

		JComponent[][]  depositComps = // 입금 화면에 배치할 입출력 컴포넌트들의 2차원 배열을 생성
			{   { new JButton("계좌번호"),  inputComps[0] },  
					{ new JButton("입금자"),    inputComps[1] }, 
					{ new JButton("입금액"),    inputComps[2] }  };  

		centerPanel.setVisible(false);
		centerPanel.removeAll();

		Container[] subPanels = SubPanelCreation.createSubPanelsLeftRight(centerPanel, 220, new Color(128, 255, 255), Color.pink, 5);
		centerLeftPanel = (JPanel) subPanels[0];
		centerRightPanel = (JPanel) subPanels[1];	

		// PanelMgmt 클래스의 displayComponents() 메소드로 계좌 입금을 위한 컴포넌트를 디스플레이
		PanelMgmt.displayComponents(this, centerLeftPanel, "계좌  입금", depositComps, depositOKBt);   // 계좌 입금 화면에 컴포넌트를 배치하고 입금을 위한 정보 입력 대기

		JScrollPane scImg = JLabelMgmt.getScrollPaneWithJLabel(centerRightPanel, "images\\dog.jpg");		
		JComponent[][] comps = {{new JLabel("개좌 입금을 위한 정보 입력")}, {scImg}};

		PanelMgmt.displayComponents(this, centerRightPanel, comps);  // 계좌 개설 결과 화면에 컴포넌트를 배치

		centerPanel.setVisible(true);
	}

	// 계좌 출금 업무 수행
	//   계좌 출금 버튼이 클릭되면 중앙 패널에 계좌번호, 출금자, 출금액, 비밀번호를  입력할 수 있도록 컴포넌트를 배치하고  
	//   withdrawOKBt 버튼이 클릭되기를 기다림
	void doWithDraw() {
		// << 작성하시오>>

		PanelMgmt.displayComponents(this, centerPanel, "작성되지 않았습니다.", null); 

	}

	// 계좌 이체 업무 수행
	//   계좌 이체 버튼이 클릭되면 중앙 패널에 이체출금 계좌번호, 이체입금 계좌번호, 출금자, 출금액, 비밀번호를  입력할 수 있도록 컴포넌트를 배치하고  
	//   transferOKBt 버튼이 클릭되기를 기다림	
	void doTransfer() {
		// << 작성하시오>>

		PanelMgmt.displayComponents(this, centerPanel, "작성되지 않았습니다.", null); 

	}

	//  소유자 정보 업무 수행
	//   소유자 정보 조회 버튼이 클릭되면 중앙 패널에 소유자 이름을 입력할 수 있도록 컴포넌트를 배치하고  
	//   ownerInfoOKBt 버튼이 클릭되기를 기다림
	void doOutputOwnerInfo() {
		// << 작성하시오>>

		PanelMgmt.displayComponents(this, centerPanel, "작성되지 않았습니다.", null); 

	}

	// 계좌 작업내역 조회 업무 처리
	//   계좌 작업내역 조회 버튼이 클릭되면 중앙 패널에 계좌 번호를 입력할 수 있도록 컴포넌트를 배치하고  
	//   outputTransactionOKBt 버튼이 클릭되기를 기다림
	void doOutputTransactionInfo() {

		String[] accnos = BankSystem.getAllAccnos();   // 모든 계좌의 계좌번호들을 String 배열에 가져옴

		if (accnos.length==0) {   // 계좌번호가 0개, 즉 조회할 계좌가 없으면 오류 처리
			JOptionPane.showMessageDialog(null, "조회할 수 있는 계좌가 없습니다. 계좌 개설 하십시오", "조회 가능 계좌 없음", JOptionPane.ERROR_MESSAGE);
			return;
		}

		JComboBox cb = new JComboBox(accnos); // 콤보박스에 모든 계좌번호들을 아이템으로 설정 - 여러 계좌번호 중 하나를 선택하게 함
		cb.setSelectedIndex((int) (java.lang.Math.random() * cb.getItemCount() ));  // 여러 계좌번호 중 하나를 랜덤으로 미리 선택하게 함

		inputComps[0] = cb;

		JComponent[][]  depositComps = // 입금 화면에 배치할 입출력 컴포넌트 2차원 배열을 생성
			{  { new JButton("조회할 계좌번호"), inputComps[0]  } };  

		centerPanel.setVisible(false);
		centerPanel.removeAll();

		Container[] subPanels = SubPanelCreation.createSubPanelsLeftRight(centerPanel, 220, new Color(128, 255, 255), Color.pink, 5);
		centerLeftPanel = (JPanel) subPanels[0];
		centerRightPanel = (JPanel) subPanels[1];	

		// PanelMgmt 클래스의 displayComponents() 메소드로 작업내역 조회를 위한 컴포넌트를 디스플레이
		PanelMgmt.displayComponents(this, centerLeftPanel, "작업내역 조회", depositComps, outputTransactionInfoOKBt);   // 작업내역 조회 화면에 컴포넌트 배치하고 조회할 계좌번호 입력 대기

		JScrollPane scImg = JLabelMgmt.getScrollPaneWithJLabel(centerRightPanel, "images\\cat.jpg");

		JComponent[][] comps = {{new JLabel("작업내역 조회 위한 정보 입력")}, {scImg}};
		PanelMgmt.displayComponents(this, centerRightPanel, comps);  // 계좌 개설 결과 화면에 컴포넌트를 배치

		centerPanel.setVisible(true);
	}

	boolean wasCheckedIDDuplication;  // 은행원 ID 중복 검사 완료 여부를 나타내는 필드

	void doEnrolBankerBt() {
		// 계좌 개설		

		wasCheckedIDDuplication = false;  // ID 중복 검사가 이루어지지 않음을 표시

		String[] bankerTypes = {"정규직", "비정규직"};
		JComboBox cb = new JComboBox(bankerTypes);    // 콤보박스에 "정규직", "비정규직"을 아이템으로 설정 - 두 종류 중 선택하게 함
		cb.setSelectedIndex((int) (java.lang.Math.random() *  cb.getItemCount()) );  // 두 직종 종류중 하나를 랜덤으로 미리 선택해둠

		inputComps[0] = cb;
		inputComps[1] = new JTextField( bankerNames[(int) (java.lang.Math.random() * bankerNames.length )] );  // 은행원 이름 입력받을 텍스트필드
		inputComps[2] = new JTextField( bankerIDs[(int) (java.lang.Math.random() * bankerIDs.length )] );      // 은행원 ID 입력받을 텍스트필드
		inputComps[3] = new JPasswordField("1234"); // 비밀번호를 입력할 패스워드필드, 비밀번호 1234 미리 설정
		inputComps[4] = new JPasswordField("1234"); // 비밀번호를 입력할 패스워드필드, 비밀번호 1234 미리 설정
		inputComps[5] = new JTextField("수원지점");   // 은행원 근무지점 입력받을 텍스트필드, 수원지점 미리 설정

		JButton checkIDDuplicationBt = new JButton("ID 중복 확인");  // 입력된 은행원 ID의 중복 여부를 확인하기 위한 버튼
		checkIDDuplicationBt.addActionListener(new checkIDDuplicationActionListener());

		JComponent[][]  enrolComps =   // 계좌 개설 화면에 배치할 입출력 컴포넌트들의 2차원배열을 생성
			{   { new JButton("은행원 유형"),   inputComps[0] },  
					{ new JButton("은행원 이름"),   inputComps[1] }, 
					{ new JButton("은행원 ID"),    inputComps[2], checkIDDuplicationBt },
					{ new JButton("비밀번호"),     inputComps[3] },
					{ new JButton("비밀번호 확인"), inputComps[4] },
					{ new JButton("근무지점"),     inputComps[5] }  }; 

		Container[] subPanels = SubPanelCreation.createSubPanelsLeftRight(centerPanel, 350, new Color(128, 255, 255), Color.pink, 5);
		centerLeftPanel = (JPanel) subPanels[0];
		centerRightPanel = (JPanel) subPanels[1];	

		// PanelMgmt 클래스의 displayComponents() 메소드로 계좌 개설을 위한 컴포넌트를 디스플레이
		PanelMgmt.displayComponents(this, centerLeftPanel, "은행원 등록", enrolComps, enrolBankerOKBt);  // 계좌 개설 화면에 컴포넌트를 배치하고 계좌 개설 정보 입력 대기

		JScrollPane scImg = JLabelMgmt.getScrollPaneWithJLabel(centerRightPanel, "images\\cat.jpg");

		JComponent[][] comps = {{new JLabel("은행원 등록을 위한 정보 입력")}, {scImg}};
		PanelMgmt.displayComponents(this, centerRightPanel, comps);  // 계좌 개설 결과 화면에 컴포넌트를 배치

		centerPanel.setVisible(true);

	}

	//  은행 업무 처리를 위한 메뉴에 대한 OK 버튼이 클릭될 때의  Action 리스너
	class BankConfirmListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();// 선택된 버튼 객체를 알아냄

			if (b == openAccountOKBt) 	
				doOpenAccountOK();

			else if (b ==  depositOKBt) 
				doDepositOK();

			else  if (b == withdrawOKBt) {
				// << 작성하시오>>
			}
			else  if (b == transferOKBt) {
				// << 작성하시오>>
			}
			else  if (b == outputOwnerInfoOKBt) {
				// << 작성하시오>>
			}
			else  if (b == outputTransactionInfoOKBt) {
				doOutputTransactionInfoOK();
			}
			else  if (b == enrolBankerOKBt) {
				doEnrolBankerOK();
			}
		} 
	}

	// ID 중복 확인버튼이 클릭되면 입력된 ID가 기존의 은행원 ID와 동일한 것이 있는가를 검사하여
	//    동일한 것이 없으면 wasCheckedIDDuplication를 true로 설정
	//    (나중에 이 변수의 값이 true이어야 은행원 등록 확인 버튼이 클릭되었을 때 은행원 객체를 생성하게 함)
	class checkIDDuplicationActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();// 선택된 버튼 객체를 알아냄

			String ID = ((JTextField) inputComps[2]).getText(); // 입력된 은행원 ID를 가져옴

			if (ID == null || ID.equals("") ) {
				JOptionPane.showMessageDialog(null, "은행원 ID는 반드시 입력되어야 합니다.",
						"은행원 ID 미입력 오류", JOptionPane.ERROR_MESSAGE);					
			} 
			else if ( BankSystem.isThereSameID(ID) == false) {
				JOptionPane.showMessageDialog(null, "입력된 은행원 ID '" + ID + "' : 사용가능한 ID입니다.",
						"사용가능 ID 입력", JOptionPane.PLAIN_MESSAGE);

				wasCheckedIDDuplication = true;   // 이 변수 값을 true로 설정하여 나중에 은행원 등록 확인 버턴이 클릭되면 통과하게 함
			}
			else
				JOptionPane.showMessageDialog(null, "중복 은행원 ID '" + ID + "' : 이미 존재하는 ID이므로 사용할 수 없습니다.",
						"중복된 ID 입력 오류", JOptionPane.ERROR_MESSAGE);
		} 
	}

	// 계좌 개설 처리: 입력된 계좌종류, 소유자, 초기입금액을 이용하여 계좌객체를 생성하고 생성된 계좌객체를 출력
	void doOpenAccountOK() {  
		int accType, initAmount = 0, password = 0;
		accType = ((JComboBox) inputComps[0]).getSelectedIndex() + 1; // 콤보박스에 선택된 계좌 타입을 가져옴(1: 보통예금, 2: 저축예금)
		String owner = ((JTextField) inputComps[1]).getText();        // 소유자 이름을 가져옴
		try {
			initAmount = Integer.parseInt( ((JTextField) inputComps[2]).getText() );  // 초기 입금액을 가져옴
		}
		catch(Exception ex) {
			// 초기 입금액이 정수값이 아니면 오류 메시지 출력
			JOptionPane.showMessageDialog(null, "초기 입금액: "+((JTextField)inputComps[2]).getText() + "은 정수이어야 합니다",
					"입금액 오류", JOptionPane.ERROR_MESSAGE);

			return;
		}

		try {
			password = Integer.parseInt( ((JTextField) inputComps[3]).getText() );  // 비밀번호를 가져옴
		}
		catch(Exception ex) {
			// 비밀번호가 정수 아니면 오류 메시지 출력
			JOptionPane.showMessageDialog(null, "비밀번호는 정수이어야 합니다", "비밀번호 오류", JOptionPane.ERROR_MESSAGE);

			return;
		}

		// 입력된 계좌 개설 정보로 계좌를 생성하고 이를 계좌 저장하는 벡터에 저장
		Account newAccount = BankSystem.openAccount(accType, owner, initAmount, password);

		// 생성된 계좌 정보를 화면에 출력
		displayAccount(centerRightPanel, "생성된 계좌", newAccount);
		centerPanel.setVisible(true);
	}

	// 계좌입금 처리: 입력된 계좌번호, 입금자, 입금액을 이용하여 계좌 잔고를 수정하고 계좌객체를 출력
	void doDepositOK(){

		int accno, amount = 0;
		accno = Integer.parseInt( (String) (((JComboBox) inputComps[0]).getSelectedItem()) ) ;  // 콤보박스 inputComps[0]에서 계좌번호 가져옴
		String customer = ((JTextField) inputComps[1]).getText();								// 텍스트필드 inputComps[1]에서 소유자 가져옴
		try {
			amount = Integer.parseInt( ((JTextField) inputComps[2]).getText() );				// 텍스트필드 inputComps[2]에서 정수값 입금액 가져옴
		}
		catch(Exception ex) {     //입금액이 정수가 아니면 오류 처리함
			JOptionPane.showMessageDialog(null, "입금액: "+((JTextField)inputComps[2]).getText() 
					+ "은 정수이어야 합니다", "입금액 오류", JOptionPane.ERROR_MESSAGE);

			return;
		}

		Account acc = BankSystem.findAccount(accno);   // accno 계좌번호의 계좌객체를 탐색
		int oldBalance = acc.getBalance();			   // 계좌객체에서 잔고를 가져옴
		BankSystem.deposit(acc, amount, customer);	   // 계좌에 대한 입금을 처리

		displayDeposit(centerRightPanel, "계좌 입금 결과", acc, customer, amount, oldBalance);  // 입금 관련 정보를 화면에 출력
	}

	// 계좌 작업내역 조회 처리: 입력된 계좌번호를 이용하여 계좌 정보와 그 계좌의 작업내역을 출력
	void doOutputTransactionInfoOK() {
		int accno;
		accno = Integer.parseInt( (String) (((JComboBox) inputComps[0]).getSelectedItem()) ) ;  // 콤보박스 inputComps[0]에서 계좌번호 가져옴

		Account acc = BankSystem.findAccount(accno);   // accno 계좌번호의 계좌객체를 탐색

		Transaction[] trans = BankSystem.getTransactionInfo(acc);  // 주어진 계좌의 작업내역들을 가져옴

		centerRightPanel.setVisible(false);
		centerRightPanel.removeAll();

		// centerPanel을 top, center 등 2 영역으로 구분하여 각 영역에 계좌 정보와 작업내역 정보를 출력하기 위해 JTable 객체 2개를 배치시킴
		//   이를 위해 SubPanelCreation.createSubPanelsTopCenter() 메소드가 이용됨
		Container[] subPanels = SubPanelCreation.createSubPanelsTopCenter(centerRightPanel, 115, new Color(128, 255, 255), Color.pink, 5);

		// centerRightTopPanel, centerRightBottomPanel에 필요한 컴포넌트 배치
		centerRightTopPanel = (JPanel) subPanels[0];
		centerRightBottomPanel = (JPanel) subPanels[1];

		displayAccount(centerRightTopPanel, "작업내역 조회할 계좌", acc);  // 작업내역 조회할 계좌를 위쪽 centerRightTopPanel에 출력
		displayTransactions(centerRightBottomPanel, "'" + acc.getAccno() + "' 계좌의 작업내역", trans);  // 작업내역들을 centerRightBottomPanel에 출력

		centerRightPanel.setVisible(true);
	}

	void doEnrolBankerOK() {
		String bankerType =(String) (((JComboBox) inputComps[0]).getSelectedItem()) ;  // 콤보박스 inputComps[0]에서 은행원 유형 가져옴

		String bname = ((JTextField) inputComps[1]).getText(); 
		String ID = ((JTextField) inputComps[2]).getText(); // 입력된 은행원 ID를 가져옴

		if ( wasCheckedIDDuplication == false) {
			JOptionPane.showMessageDialog(null, "입력된 '" + ID + "' ID의 중복확인 되지 않았습니다. 중복 확인 버튼을 클릭하십시오.",
					"ID 중복 미확인 오류", JOptionPane.ERROR_MESSAGE);
			return;
		}

		wasCheckedIDDuplication = false; // 한번 중복 검사 성공 후 다시 검사하도록 하기 위함

		char[] password1 = ((JPasswordField) inputComps[3]).getPassword(); // 입력된 은행원 ID를 가져옴
		char[] password2 = ((JPasswordField) inputComps[4]).getPassword(); // 입력된 은행원 ID를 가져옴		

		if (java.util.Arrays.equals(password1, password2) == false) {
			JOptionPane.showMessageDialog(null, "입력된 패스워드가 일치하지 않습니다.",
					"패스워드 불일치 오류", JOptionPane.ERROR_MESSAGE);		
			return;
		}

		String branch = ((JTextField) inputComps[5]).getText(); 

		Banker banker = BankSystem.enrolBanker(bankerType, bname, ID, password1, branch);
		displayBanker(centerRightPanel, "은행원 등록 결과", banker);  // 은행원 등록 관련 정보를 화면에 출력

		centerPanel.setVisible(true);
	}


	static final int LEFT=0, CENTER=1, RIGHT=2; // JTable의 각 셀의 정렬방식(왼쪽, 중앙, 오른쪽)을 지정하기 위한 상수변수

	// 주어진 하나의 계좌 정보를 타이틀과 함께 주어진 패널  panel에 출력
	void displayAccount(JPanel panel, String title, Account acc) {
		Account accs[] = {acc};

		displayAccounts(panel, title, accs);
	}

	void displayAccountOLD(JPanel panel, String title, Account acc) {
		panel.setVisible(false);

		String[] attrnames = { "계좌번호", "계좌유형", "소유자", "개설일", "잔액", "비밀번호"};  // 테이블 형태로 출력할, 계좌 정보의  애트리뷰트들  
		Object[][] tuples = { { acc.getAccno(), acc.getAccTypename(), acc.getOwner(), getDate(acc.getOpenDate()), 
			formatAmount(acc.getBalance()), acc.getPassword()+" " }} ;  // 계좌 객체의 필드들을 테이블 형태로 출력하기 위해 2차원 배열로 구성

		// "계좌번호", "계좌유형", "소유자", "개설일", "잔액", "비밀번호"에 대한 정렬방식을 설정
		int[] alignments = { CENTER, CENTER, CENTER, CENTER, RIGHT, RIGHT };

		// JTableMgmt 클래스의displayJTableToPanel() 메소드로 panel에 계좌 정보 출력
		JTableMgmt.displayJTableToPanel(this, panel, title, attrnames, tuples, alignments);
	}

	// 주어진 계좌들을 타이틀과 함께 주어진 패널 panel에 출력
	void displayAccounts(JPanel panel, String title, Account[] accs) {
		panel.setVisible(false);

		int n = accs.length;

		String[] attrnames = { "계좌번호", "계좌유형", "소유자", "개설일", "잔액", "비밀번호"}; // 테이블 형태로 출력할, 계좌 정보의  애트리뷰트들  
		Object[][] tuples = new Object[accs.length][attrnames.length + 1];
		for (int i = 0; i < n; i++) {             // 계좌 객체들의 필드들을 테이블 형태로 출력하기 위해 2차원 배열로 구성
			tuples[i][0] = accs[i].getAccno();
			tuples[i][1] = accs[i].getAccTypename();
			tuples[i][2] = accs[i].getOwner();
			tuples[i][3] = getDate(accs[i].getOpenDate());
			tuples[i][4] = formatAmount(accs[i].getBalance()) ;
			tuples[i][5] = accs[i].getPassword() + " ";
		}

		// "계좌번호", "계좌유형", "소유자", "개설일", "잔액"애 대한  정렬방식을 설정
		int[] alignments = { CENTER, CENTER, CENTER, CENTER, RIGHT, RIGHT, CENTER };

		// JTableMgmt 클래스의displayJTableToPanel() 메소드로 panel에 계좌 정보들을  출력
		JTableMgmt.displayJTableToPanel(this, panel, title, attrnames, tuples, alignments);

	}

	// 주어진 입금 정보들을 타이틀과 함께 주어진 패널 panel에 출력
	void displayDeposit(JPanel panel, String title, Account acc,String customer, int amount, int oldBalance) {
		panel.setVisible(false);

		String[] attrnames = { "계좌번호", "소유자", "입금자", "입금액",  "기존 잔액", "새 잔액"};   // 테이블 형태로 출력할, 입금 정보의 애트리뷰트들  
		Object[][] tuples = { { acc.getAccno() , acc.getOwner(), customer, formatAmount(amount), 
			formatAmount(oldBalance), formatAmount(acc.getBalance()) }} ;   // 입금 정보들을 테이블 형태로 출력하기 위해 2차원 배열로 구성

		// "계좌번호", "소유자", "입금자", "입금액",  "기존 잔액", "새 잔액"애 대한  정렬방식을 설정
		int[] alignments = { CENTER, CENTER, CENTER, RIGHT, RIGHT, RIGHT };

		// JTableMgmt 클래스의displayJTableToPanel() 메소드로 panel에 입금 정보 출력
		JTableMgmt.displayJTableToPanel(this, panel, title, attrnames, tuples, alignments);
	}

	// 주어진 작업내역들을 타이틀과 함께  주어진 패널 panel에 출력
	void displayTransactions(JPanel panel, String title, Transaction[] trans) {
		panel.setVisible(false);

		int n = trans.length;

		String[] attrnames = { "계좌번호", "작업유형", "고객명", "금액", "잔액", "작업일"}; // 테이블 형태로 출력할, 계좌 정보의  애트리뷰트들  
		Object[][] tuples = new Object[trans.length][attrnames.length];
		for (int i = 0; i < n; i++) {             // 작업내역 객체들의 필드들을 테이블 형태로 출력하기 위해 2차원 배열로 구성
			tuples[i][0] = trans[i].getTrAccount().getAccno();
			tuples[i][1] = trans[i].getTrType();
			tuples[i][2] = trans[i].getCustomer();
			tuples[i][3] = formatAmount(trans[i].getAmount()) ;
			tuples[i][4] = formatAmount(trans[i].getBalance());
			tuples[i][5] = getDate(trans[i].getTrDate());
		}

		// "계좌번호", "작업유형", "고객명", "금액", "잔액", "작업일"애 대한  정렬방식을 설정
		int[] alignments = { CENTER, CENTER, CENTER, RIGHT, RIGHT, CENTER};

		// JTableMgmt 클래스의displayJTableToPanel() 메소드로 panel에 계좌 정보들을  출력
		JTableMgmt.displayJTableToPanel(this, panel, title, attrnames, tuples, alignments);
	}

	// 주어진 은행원 정보들을 타이틀과 함께 주어진 패널 panel에 출력
	void displayBanker(JPanel panel, String title, Banker banker ) {
		panel.setVisible(false);

		JComponent[][] comps = 	{ 	{ new JButton("은행원 유형"), new JTextField(banker.bankerType) },
				{ new JButton("은행원 번호"), new JTextField(Integer.toString(banker.bno)) },
				{ new JButton("이름"), new JTextField(banker.bname) }, 
				{ new JButton("ID"), new JTextField(banker.ID) },
				{ new JButton("비밀번호"), new JTextField(new String(banker.password)) },
				{ new JButton("근무지점"), new JTextField(banker.branch)  }
		};   

		PanelMgmt.displayComponents(this, centerRightPanel, title, comps, null);

		//      // 테이블 형대로 등록된 은행원 디스플레이
		//		String[] attrnames = { "은행원 유형", "은행원 번호", "이름", "ID",  "비밀번호", "근무지점"};   // 테이블 형태로 출력할, 입금 정보의 애트리뷰트들  
		//		Object[][] tuples = { { banker.bankerType , banker.bno, banker.bname, banker.ID, new String(banker.password), 
		//			banker.branch }} ;   // 입금 정보들을 테이블 형태로 출력하기 위해 2차원 배열로 구성
		//
		//		//  "은행원 유형", "은행원 번호", "이름", "ID",  "비밀번호", "근무지점"에 대한  정렬방식을 설정
		//		int[] alignments = { CENTER, CENTER, CENTER, CENTER, CENTER, CENTER };
		//
		//		// JTableMgmt 클래스의displayJTableToPanel() 메소드로 panel에 입금 정보 출력
		//		JTableMgmt.displayJTableToPanel(panel, title, attrnames, tuples, alignments);
	}

	// 금액의 천원, 백만원 위치에 ','를 넣어주기 위한 메소드
	static DecimalFormat dfAmount = new DecimalFormat("#,###,###,##0 ");

	public static String formatAmount(int amount){
		return dfAmount.format(amount);   // DecimalFormat 클래스의 format() 메소드를 이용하여 십진수 포매팅하기
	}

	// getDate(Date d) - Date 객체에서 년월일을 구하여 반환
	//   getYear(), getMonth(), getDay() 등은 deprecated 메소드(더 이상 사용하지 않기로 한 메소드)이지만 가장 쉽기 때문에 사용함
	//   getYear() 메소드는 (년도 - 1900)을 반환하므로 1900을 더해야 함
	//   getMonth()는 0~11의 값을 달의 값으로 반환하므로 1을 더해줘야 함
	static String getDate(Date d) {
		return (1900 + d.getYear()) + "-" + (d.getMonth()+1) + "-"+d.getDate();		
	}
}

