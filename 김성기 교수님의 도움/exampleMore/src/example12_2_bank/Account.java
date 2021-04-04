package example12_2_bank;

import java.util.*;

// Account: ���� ���� �����ϴ� Ŭ���� 
public class Account {
	int accno;     // ���¹�ȣ
	int accType;   // ��������
	String owner;  // ������
	Date openDate; // ������
	private int balance;   // �ܰ�
	private int password;  // 4�ڸ� ���� �н�����

	// ��ü ������
	public Account(int accno, int accType, String owner, Date openDate, int balance, int password) {
		this.accno = accno;	this.accType = accType;  this.owner = owner; 
		this.openDate = openDate; this.balance = balance; this.password = password;
	}
	
	/*
	 *  ������ �޼ҵ���� �ʵ�(�������)�� �� ��ȯ�ϰų� �����ϴ� �޼ҵ��̸�, �̸� getter �޼ҵ�, setter �޼ҵ�� ��
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
		return accType==1 ? "���뿹��" : "���࿹��";
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
		return "   ���¹�ȣ: " + accno +",  "+ "�������� : " + getAccTypename() +", "
	         + "������ : " + owner+",  " + "�ܾ�: " + balance+",   "
		     + "������: " + openDate+", " + "��й�ȣ: " + password;

	}
	
	public void output() {
		System.out.print( this.toString()+"\n");
	}
	
	// �Ա� ó��: �ܾ� ����
	int deposit(int amount) {
		balance += amount;
		
		return balance;
	}
	
	// ��� ó��: �ܾ� ����
	int withdraw(int amount) {
		balance -= amount;
		
		return balance;
	}
	
	// �־��� �н����尡 �ùٸ� �н��������� Ȯ���ϴ� �޼ҵ�
	boolean isValidPassword(int password) {
		return this.password == password;
	}
}