package example12_2_bank;

import java.util.Date;

// Banker: ��� ������� ǥ���ϴ� Ŭ����
public class Banker {

	String bankerType;  // ����� ����
	int bno;            // ����� ��ȣ - �������� ���������� ���� �ٸ��� ��ȣ �ο�
	String bname;       // ����� �̸�
	String ID;          // �α��� ID
	char[] password;    // ��й�ȣ : ��й�ȣ�� String�� �ƴ� char[] Ÿ������ ����
	Date dateHired;     // �Ի���
	String branch;      // �ٹ�����


	public Banker() {
	}
	
	// �����  ��ü ������- ����� ������ �־����� ������ ���� ����� ��ȣ�� �����Ͽ� ����� ��ü�� ���� 
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
		return "   ����� ����: " + bankerType +", " + "����� ��ȣ : " + bno +", "
		     + "�̸�: " + bname+",  " + "���̵�: " + ID +",  " + "�н�����: " + new String(password) + ", "
		     + "�Ի��� : " + dateHired +", "+ "�ٹ�����: " + branch+"  ";

	}

	public void output() {
		System.out.print( this.toString()+"\n");
	}

	public void doBankerWork() {};  // �� �޼ҵ�� �������̵��� �޼ҵ���
}

