
public class DaemonExample {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AutoSaveThread autoSaveThread = new AutoSaveThread();

		// 데몬 스레드로 지정
		autoSaveThread.setDaemon(true);
		autoSaveThread.start();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
		System.out.println("메인 스레드 종료");
	}
}
