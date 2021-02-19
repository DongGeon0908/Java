package Override.abstractMethod;

public abstract class Animal {
	public String kind;

	public void breathe() {
		System.out.println("숨을 쉬다ㄹ");
	}

	public abstract void sound();
}
