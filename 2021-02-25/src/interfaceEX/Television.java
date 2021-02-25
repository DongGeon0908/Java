package interfaceEX;

public class Television implements RemoteControl{
	
	private int volume;
	
	public void turnOn() {
		System.out.println("테레비 전원 키자");
	}

	@Override
	public void turnOff(int time) {
		// TODO Auto-generated method stub
		System.out.println(time);
	}
}
