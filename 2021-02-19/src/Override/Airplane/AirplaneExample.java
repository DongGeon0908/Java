package Override.Airplane;

public class AirplaneExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SupersonicAirplane sp = new SupersonicAirplane();
		sp.takeOff();
		sp.fly();
		sp.flyMode = SupersonicAirplane.SUPERSONIC;
		sp.fly();
		sp.flyMode = SupersonicAirplane.NORMAL;
		sp.fly();
		sp.land();
	}

}
