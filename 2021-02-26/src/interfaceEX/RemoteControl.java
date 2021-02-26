package interfaceEX;

public interface RemoteControl {

	// 상수
	int MAX = 9999;
	int MIN = 0;

	// 추상 메소드
	void turnOn();

	void turnOff(int time);

	// 디폴트 메소드
	default void setMute(boolean mute) {
		if (mute) {
			System.out.println("음소거 처리");
		} else {
			System.out.println("음소거 해제");
		}
	}
	
	// 정적 메소드
	static void change() {
		System.out.println("변환");
	}
}
