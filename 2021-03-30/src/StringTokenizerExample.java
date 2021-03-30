package jjj;

import java.util.StringTokenizer;

public class StringTokenizerExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String text = "홍길동/이수홍/박연수";

		StringTokenizer st = new StringTokenizer(text, "/");
		int count = st.countTokens(); // 꺼내올 토큰이 있는지 검사
		for (int i = 0; i < count; i++) {
			String token = st.nextToken();
			System.out.println(token);
		}

		System.out.println();

		st = new StringTokenizer(text, "/");
		while (st.hasMoreElements()) {
			String token = st.nextToken();
			System.out.println(token);
		}
	}

}
