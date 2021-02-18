package phone;

public class CellPhone {

	String model;
	String color;

	void powerOn() {
		System.out.println("powerOn");
	}

	void powerOff() {
		System.out.println("powerOff");
	}

	void bell() {
		System.out.println("bell");
	}

	void sendVoic(String message) {
		System.out.println("Me + " + message);
	}

	void receiveVoic(String message) {
		System.out.println("You + " + message);
	}

	void hangUp() {
		System.out.println("hangup");
	}
}
