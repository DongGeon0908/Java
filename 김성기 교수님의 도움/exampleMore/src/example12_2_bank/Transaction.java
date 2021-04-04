package example12_2_bank;

import java.util.*;

// Transaction: ���� �۾������� ���� Ŭ���� 
public class Transaction {
	Account trAccount;   // �۾� ���¹�ȣ
	String trType;       // �۾�����: �Ա�, ���, ��ü���, ��ü�Ա�
	String  customer;    // �۾��� �̸�
	int amount;          // �ݾ�
	int balance;         // �ܰ�
	Date trDate;         // �۾���¥


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

	// Transaction ��ü ������
	public Transaction(Account trAccount, String trType, String customer, int amount, 	int balance) {
		this.trAccount = trAccount; 
		this.trType = trType;
		this.customer = customer; 
		this.amount = amount;  
		this.balance = balance;
		this.trDate = new Date();
	}

	// ���� �۾������� ���¸� ��ȯ�ϴ� �޼ҵ�
	public Account getAccount() {
		return trAccount;
	}

	public String toString() {
		return "   �۾� ���¹�ȣ : " + trAccount.accno+",  " + "�۾�����: " + trType +",  "
	         + "����: " + customer+",   " + "�ݾ�: " + amount+",   "
		     + "�ܰ�: " + balance+ "    " + "�۾��ð�: " + trDate;
	}
	
	public void output() {
		System.out.print( this.toString()+"\n");
	}
}
