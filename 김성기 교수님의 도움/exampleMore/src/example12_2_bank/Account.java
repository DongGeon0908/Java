package example12_2_bank;

import java.util.*;

// Account: 계좌 정보 저장하는 클래스 
public class Account {
	int accno;     // 계좌번호
	int accType;   // 계좌유형
	String owner;  // 소유주
	Date openDate; // 개설일
	private int balance;   // 잔고
	private int password;  // 4자리 숫자 패스워드

	// 객체 생성자
	public Account(int accno, int accType, String owner, Date openDate, int balance, int password) {
		this.accno = accno;	this.accType = accType;  this.owner = owner; 
		this.openDate = openDate; this.balance = balance; this.password = password;
	}
	
	/*
	 *  다음의 메소드들은 필드(멤버변수)의 값 반환하거나 저장하는 메소드이며, 이를 getter 메소드, setter 메소드라 함
	 */
	
	public int getAccno() {
		return accno;
	}


	public void setAccno(int accno) {
		this.accno = accno;
	}


	public int getAccType() {
		return accType;
	}

	public String getAccTypename() {
		return accType==1 ? "보통예금" : "저축예금";
	}
	
	public void setAccType(int accType) {
		this.accType = accType;
	}
	
	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public Date getOpenDate() {
		return openDate;
	}


	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	public String toString() {
		return "   계좌번호: " + accno +",  "+ "계좌유형 : " + getAccTypename() +", "
	         + "소유자 : " + owner+",  " + "잔액: " + balance+",   "
		     + "개설일: " + openDate+", " + "비밀번호: " + password;

	}
	
	public void output() {
		System.out.print( this.toString()+"\n");
	}
	
	// 입금 처리: 잔액 증가
	int deposit(int amount) {
		balance += amount;
		
		return balance;
	}
	
	// 출금 처리: 잔액 감소
	int withdraw(int amount) {
		balance -= amount;
		
		return balance;
	}
	
	// 주어진 패스워드가 올바른 패스워드인지 확인하는 메소드
	boolean isValidPassword(int password) {
		return this.password == password;
	}
}