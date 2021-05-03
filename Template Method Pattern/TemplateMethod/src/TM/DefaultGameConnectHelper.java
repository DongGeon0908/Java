package TM;

public class DefaultGameConnectHelper extends AbstGameConnectHelper {

	@Override
	protected String doSecurity(String string) {
		// TODO Auto-generated method stub
		System.out.println("강화된 알고리즘을 이용한 디코드");
		return string;
	}

	@Override
	protected boolean authentication(String id, String password) {
		// TODO Auto-generated method stub
		System.out.println("아이디/암호 확인 과정");
		return true;
	}

	@Override
	protected int authorization(String userName) {
		// TODO Auto-generated method stub
		System.out.println("권한 확인");

		// 서버에서 유저이름 유저의 나이를 알 수 있음
		// 나이를 확인하고 시간을 확인하고 성인이 아니고 10시가 지났다면 권한이 없는 것으로
		return 0;
	}

	@Override
	protected String connection(String info) {
		// TODO Auto-generated method stub
		System.out.println("마지막 접속단계!");
		return info;
	}

}
