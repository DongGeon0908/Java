package example11_1_phone_book;

import java.util.*;

// 전화번호부 엔트리인 이름과 전화번호를 저장하는 클래스
class PhoneBookEntry {
	String name;  // 이름
	String phone; // 전화번호

	// 이름과 전화번호가 주어지면 이를 필드에 저장하는 객체 생성자
	PhoneBookEntry(String name, String phone) {
		this.name = name; this.phone = phone;
	}

	public String toString() {
		return "이름: " + name +", 전화번호: " + phone;
	}
}

// 여러 이름과 전화번호를 저장하고 전화번호 탐색, 전화변경 등을 수행하는 전화번호부 클래스
class PhoneBook { 
	String ownername;  // 소유자 이름을 저장하는 필드
	Vector<PhoneBookEntry> pbEntries; // 전화번호부 엔트리를 저장하는 Vector 객체

	// 객체 생성자: 소유자 이름이 주어지면 이를 저장하고 엔트리를 위한 Vector 생성 
	PhoneBook(String ownername) {
		this.ownername = ownername;  // 전화번호 소유자를 저장

		// 전화번호부 엔트리(이름, 전화번호)를 저장할 Vector 객체 생성하여 저장 
		this.pbEntries = new Vector<PhoneBookEntry>(); 
	}

	// 주어진 전화번호부 소유자, 이름 및 전화번호들이 문자열 배열을 이용하여 
	// 전화번호부 생성하고 초기화하는 클래스 메소드
	static PhoneBook setupPhoneBook(String ownername, String[] ss) {
		PhoneBook pb = new PhoneBook(ownername);

		// 배열로 주어진 이름과 전화번호 쌍을 전화번호부 엔트리로 추가함
		for (int i = 0; i < ss.length; i += 2) 
			pb.addEntry(ss[i], ss[i+1]);

		return pb; // 생성된 전화번호부를 반환
	}

	// 주어진 이름과 전화번호 쌍을 전화번호부 엔트리로 추가함
	void addEntry(String name, String phone) {
		pbEntries.add(new PhoneBookEntry(name, phone));
	}

	// 주어진 이름의 전화번호부 엔트리를 찾아 반환, 이름이 없으면 null 반환
	PhoneBookEntry searchPhoneBookEntry(String name) {
		for (PhoneBookEntry e : pbEntries) // Vector 객체 pbEntries의 각 원소에 대해 
			if (e.name.equals(name))       //  엔트리의 이름이 주어진 이름과 같으면
				return e;                  //  주어진 엔트리를 반환

		return null;                       // 주어진 이름이 전화번호부에 없으므로 false 반환
	}

	// 주어진 이름의 전화번호를 찾아 반환, 이름 없으면 null 반환       
	String searchPhone(String name) {
		PhoneBookEntry e = searchPhoneBookEntry(name);  // 주어진 이름의 전화번호부 엔트리를 찾음 

		if (e != null)       // 주어진 이름의 엔트리가 있으면
			return e.phone;  // 전화번호를 반환

		return null;         // 없으면 null 반환
	}

	// 주어진 이름의 전화번호를 새로운 전화번호로 변경
	boolean changePhone(String name, String phone) { 
		PhoneBookEntry e = searchPhoneBookEntry(name);  // 주어진 이름의 전화번호부 엔트리를 찾음 

		if (e != null) {          // 주어진 이름의 엔트리가 있으면
			e.phone = phone;  // 그 엔트리의 전화번호 변경하고
			return true;      // 변경 성공을 나타내는 true 반환
		}

		return false; // 주어진 이름이 전화번호부에 없으므로 false 반환
	}   

	public String toString(){
		String s = "\n  ** " + ownername + "의 전화번호부(" 
				+  pbEntries.size() + "명의 전화번호)\n\n";

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
			{ "홍길동", "3401-1234", "박문수", "2222-5678", "이몽룡", "3333-1111", 
		      "성춘향", "5555-1234", "심청", "6666-9999" };

		PhoneBook pb = PhoneBook.setupPhoneBook("홍길동", namePhones);

		pb.output(); // 초기화된 전화번호부 출력

		String name, phone; 
		name = SkScanner.getString("\n  o 전화번호 찾을 이름 입력 > ");
		if ((phone = pb.searchPhone(name)) != null)
			System.out.println("\n  * " + name + "의 전화번호 : " + phone +"\n");
		else
			System.out.println("\n  * " + name + "의 전화번호가 없습니다.\n");

		name = SkScanner.getString("\n  o 전화번호 변경할 이름 입력 > ");
		phone = SkScanner.getString("  o " + name +"의 새로운 전화번호 입력 > ");

		if (pb.changePhone(name, phone))
			System.out.println("\n  * " + name + "의 전화번호가 " + phone +"(로)로 변경되었습니다.\n");
		else {
			System.out.println("\n  * " + name + "의 전화번호가 없습니다.\n");
		}

		pb.output();  // 변경된  전화번호부 출력
	}
}
