package Override.abstractClass;

public abstract class Phone {

	public String owner;

	public Phone(String owner) {
		this.owner = owner;
	}

	public void turnOn() {
		System.out.println("turnOn");
	}

	public void turnOff() {
		System.out.println("turnOff");
	}
}
