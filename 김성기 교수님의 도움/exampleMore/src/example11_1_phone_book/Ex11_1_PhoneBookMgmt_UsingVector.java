package example11_1_phone_book;

import java.util.*;

// ��ȭ��ȣ�� ��Ʈ���� �̸��� ��ȭ��ȣ�� �����ϴ� Ŭ����
class PhoneBookEntry {
	String name;  // �̸�
	String phone; // ��ȭ��ȣ

	// �̸��� ��ȭ��ȣ�� �־����� �̸� �ʵ忡 �����ϴ� ��ü ������
	PhoneBookEntry(String name, String phone) {
		this.name = name; this.phone = phone;
	}

	public String toString() {
		return "�̸�: " + name +", ��ȭ��ȣ: " + phone;
	}
}

// ���� �̸��� ��ȭ��ȣ�� �����ϰ� ��ȭ��ȣ Ž��, ��ȭ���� ���� �����ϴ� ��ȭ��ȣ�� Ŭ����
class PhoneBook { 
	String ownername;  // ������ �̸��� �����ϴ� �ʵ�
	Vector<PhoneBookEntry> pbEntries; // ��ȭ��ȣ�� ��Ʈ���� �����ϴ� Vector ��ü

	// ��ü ������: ������ �̸��� �־����� �̸� �����ϰ� ��Ʈ���� ���� Vector ���� 
	PhoneBook(String ownername) {
		this.ownername = ownername;  // ��ȭ��ȣ �����ڸ� ����

		// ��ȭ��ȣ�� ��Ʈ��(�̸�, ��ȭ��ȣ)�� ������ Vector ��ü �����Ͽ� ���� 
		this.pbEntries = new Vector<PhoneBookEntry>(); 
	}

	// �־��� ��ȭ��ȣ�� ������, �̸� �� ��ȭ��ȣ���� ���ڿ� �迭�� �̿��Ͽ� 
	// ��ȭ��ȣ�� �����ϰ� �ʱ�ȭ�ϴ� Ŭ���� �޼ҵ�
	static PhoneBook setupPhoneBook(String ownername, String[] ss) {
		PhoneBook pb = new PhoneBook(ownername);

		// �迭�� �־��� �̸��� ��ȭ��ȣ ���� ��ȭ��ȣ�� ��Ʈ���� �߰���
		for (int i = 0; i < ss.length; i += 2) 
			pb.addEntry(ss[i], ss[i+1]);

		return pb; // ������ ��ȭ��ȣ�θ� ��ȯ
	}

	// �־��� �̸��� ��ȭ��ȣ ���� ��ȭ��ȣ�� ��Ʈ���� �߰���
	void addEntry(String name, String phone) {
		pbEntries.add(new PhoneBookEntry(name, phone));
	}

	// �־��� �̸��� ��ȭ��ȣ�� ��Ʈ���� ã�� ��ȯ, �̸��� ������ null ��ȯ
	PhoneBookEntry searchPhoneBookEntry(String name) {
		for (PhoneBookEntry e : pbEntries) // Vector ��ü pbEntries�� �� ���ҿ� ���� 
			if (e.name.equals(name))       //  ��Ʈ���� �̸��� �־��� �̸��� ������
				return e;                  //  �־��� ��Ʈ���� ��ȯ

		return null;                       // �־��� �̸��� ��ȭ��ȣ�ο� �����Ƿ� false ��ȯ
	}

	// �־��� �̸��� ��ȭ��ȣ�� ã�� ��ȯ, �̸� ������ null ��ȯ       
	String searchPhone(String name) {
		PhoneBookEntry e = searchPhoneBookEntry(name);  // �־��� �̸��� ��ȭ��ȣ�� ��Ʈ���� ã�� 

		if (e != null)       // �־��� �̸��� ��Ʈ���� ������
			return e.phone;  // ��ȭ��ȣ�� ��ȯ

		return null;         // ������ null ��ȯ
	}

	// �־��� �̸��� ��ȭ��ȣ�� ���ο� ��ȭ��ȣ�� ����
	boolean changePhone(String name, String phone) { 
		PhoneBookEntry e = searchPhoneBookEntry(name);  // �־��� �̸��� ��ȭ��ȣ�� ��Ʈ���� ã�� 

		if (e != null) {          // �־��� �̸��� ��Ʈ���� ������
			e.phone = phone;  // �� ��Ʈ���� ��ȭ��ȣ �����ϰ�
			return true;      // ���� ������ ��Ÿ���� true ��ȯ
		}

		return false; // �־��� �̸��� ��ȭ��ȣ�ο� �����Ƿ� false ��ȯ
	}   

	public String toString(){
		String s = "\n  ** " + ownername + "�� ��ȭ��ȣ��(" 
				+  pbEntries.size() + "���� ��ȭ��ȣ)\n\n";

		for ( int i = 0; i < pbEntries.size(); i++) 
			s = s + "  " + (i + 1) + ") " + pbEntries.get(i).toString() + "\n";

		return s;
	}

	void output() {
		System.out.println(toString());
	}
}

class Ex11_1_PhoneBookMgmt_UsingVector {
	public static void main(String[] args) { 
		String[] namePhones = 
			{ "ȫ�浿", "3401-1234", "�ڹ���", "2222-5678", "�̸���", "3333-1111", 
		      "������", "5555-1234", "��û", "6666-9999" };

		PhoneBook pb = PhoneBook.setupPhoneBook("ȫ�浿", namePhones);

		pb.output(); // �ʱ�ȭ�� ��ȭ��ȣ�� ���

		String name, phone; 
		name = SkScanner.getString("\n  o ��ȭ��ȣ ã�� �̸� �Է� > ");
		if ((phone = pb.searchPhone(name)) != null)
			System.out.println("\n  * " + name + "�� ��ȭ��ȣ : " + phone +"\n");
		else
			System.out.println("\n  * " + name + "�� ��ȭ��ȣ�� �����ϴ�.\n");

		name = SkScanner.getString("\n  o ��ȭ��ȣ ������ �̸� �Է� > ");
		phone = SkScanner.getString("  o " + name +"�� ���ο� ��ȭ��ȣ �Է� > ");

		if (pb.changePhone(name, phone))
			System.out.println("\n  * " + name + "�� ��ȭ��ȣ�� " + phone +"(��)�� ����Ǿ����ϴ�.\n");
		else {
			System.out.println("\n  * " + name + "�� ��ȭ��ȣ�� �����ϴ�.\n");
		}

		pb.output();  // �����  ��ȭ��ȣ�� ���
	}
}
