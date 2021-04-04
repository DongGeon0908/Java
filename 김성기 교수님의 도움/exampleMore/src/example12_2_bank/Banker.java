package example12_2_bank;

import java.util.Date;

// Banker: 모든 은행원을 표현하는 클래스
public class Banker {

	String bankerType;  // 은행원 유형
	int bno;            // 은행원 번호 - 정규직과 비정규직에 따라 다르게 번호 부여
	String bname;       // 은행원 이름
	String ID;          // 로그인 ID
	char[] password;    // 비밀번호 : 비밀번호는 String이 아닌 char[] 타입으로 저장
	Date dateHired;     // 입사일
	String branch;      // 근무지점


	public Banker() {
	}
	
	// 은행원  객체 생성자- 은행원 유형이 주어지면 유형별 다음 은행원 번호를 생성하여 은행원 객체를 생성 
	public Banker(String bankerType, int bno, String bname, String ID, char[] password, Date dateHired, String branch) {
		this.bankerType = bankerType;		
		this.bno = bno;
		this.bname = bname;
		this.ID = ID;
		this.password = password;
		this.dateHired = dateHired; 
		this.branch = branch;			

	}

	public String toString() {
		return "   은행원 유형: " + bankerType +", " + "은행원 번호 : " + bno +", "
		     + "이름: " + bname+",  " + "아이디: " + ID +",  " + "패스워드: " + new String(password) + ", "
		     + "입사일 : " + dateHired +", "+ "근무지점: " + branch+"  ";

	}

	public void output() {
		System.out.print( this.toString()+"\n");
	}

	public void doBankerWork() {};  // 이 메소드는 오버라이딩될 메소드임
}

