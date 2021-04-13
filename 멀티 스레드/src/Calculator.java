
public class Calculator {
	private int memory;

	public int getMoney() {
		return memory;
	}

	public synchronized void setMemory(int memory) {
		this.memory = memory;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

		}
		System.out.println(Thread.currentThread().getName() + " : " + this.memory);
	}

	// setMemory()와 동등한 역할
	public void setMemory2(int memory) {
		synchronized (this) {
			this.memory = memory;
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {

			}
			System.out.println(Thread.currentThread().getName() + " : " + this.memory);
		}
	}
}
