public class StringEqualsExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "김동건";
		String str2 = "김동건";

		if (str1 == str2) {
			System.out.println("참조 일치");
		} else {
			System.out.println("참조 불일치");
		}

		if (str1.equals(str2)) {
			System.out.println("문자열 일치");
		}

		String str3 = new String("김동건");
		String str4 = new String("김동건");

		if (str3 == str4) {
			System.out.println("참조 일치");
		} else {
			System.out.println("참조 불일치");
		}

		if (str3.equals(str4)) {
			System.out.println("문자열 일치");
		}
	}

}
