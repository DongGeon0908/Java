package example12_2_bank;

import java.util.*;

// Transaction: 계좌 작업내역을 위한 클래스 
public class Transaction {
	Account trAccount;   // 작업 계좌번호
	String trType;       // 작업유형: 입금, 출금, 이체출금, 이체입금
	String  customer;    // 작업자 이름
	int amount;          // 금액
	int balance;         // 잔고
	Date trDate;         // 작업날짜


    public String getTrType() {
		return trType;
	}

	public void setTrType(String trType) {
		this.trType = trType;
	}

	public Account getTrAccount() {
		return trAccount;
	}

	public void setTrAccount(Account trAccount) {
		this.trAccount = trAccount;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public Date getTrDate() {
		return trDate;
	}

	public void setTrDate(Date trDate) {
		this.trDate = trDate;
	}

	// Transaction 객체 생성자
	public Transaction(Account trAccount, String trType, String customer, int amount, 	int balance) {
		this.trAccount = trAccount; 
		this.trType = trType;
		this.customer = customer; 
		this.amount = amount;  
		this.balance = balance;
		this.trDate = new Date();
	}

	// 계좌 작업내역의 계좌를 반환하는 메소드
	public Account getAccount() {
		return trAccount;
	}

	public String toString() {
		return "   작업 계좌번호 : " + trAccount.accno+",  " + "작업유형: " + trType +",  "
	         + "고객명: " + customer+",   " + "금액: " + amount+",   "
		     + "잔고: " + balance+ "    " + "작업시각: " + trDate;
	}
	
	public void output() {
		System.out.print( this.toString()+"\n");
	}
}
