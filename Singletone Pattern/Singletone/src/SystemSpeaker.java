
// 하나의 인스턴스를 하나의 메서드로 접근 가능

public class SystemSpeaker {

	static private SystemSpeaker instance;
	private int volume;

	private SystemSpeaker() {
		volume = 5;
	}

	public static SystemSpeaker getInstance() {
		if (instance == null) {
			// 시스템 스피커
			instance = new SystemSpeaker();
			System.out.println("새롭게 생성됨");
		}
		System.out.println("기존에 생성됨");
		return instance;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

}
