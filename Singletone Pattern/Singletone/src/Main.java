
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SystemSpeaker speaker1 = SystemSpeaker.getInstance();
		SystemSpeaker speaker2 = SystemSpeaker.getInstance();

		System.out.println(speaker1.getVolume());
		System.out.println(speaker2.getVolume());

		speaker1.setVolume(11);

		System.out.println(speaker1.getVolume());
		System.out.println(speaker2.getVolume());

		// speaker1과 speaker2는 같은 인스턴스를 가짐
		// 하나의 인스턴스를 가짐을 알 수 있음
	}

}
