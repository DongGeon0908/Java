package exercise08;

/**
 * [ 8장 연습문제 7 ]
 * 
 *   7. 다음과 같은 클래스와 인터페이스가 선언되었다. 물음에 답하라.
 *   
 *      1) Bus 클래스의 상위 클래스와 상위 인터페이스를 모두 나열하라. 
 *      
 *      2) Truck 클래스의 상위 클래스와 상위 인터페이스를 모두 나열하라. 
 *      
 *      3) PassengerVehicle을 참조하여 FreightVehicle 클래스를 작성하라. 
 *      
 *      4) 연료종류, 마력, 최대 승객수가 주어지면 이를 초기화하는 Bus 클래스의 객체 생성자 작성하라.
 *      
 *      5) 연료종류, 마력, 최대 화물량이 주어지면 이를 초기화하는 Truck 클래스의 객체 생성자 작성하라.
 *      
 *      6) main() 메소드의 << PassengerIF v1 = new Bus("LPG", 50, 45); >>에서 v1 변수에 생성된 Bus 
 *         객체가 저장될 수 있는 이유를 설명하라.
 */

class Vehicle { 		// 차량 클래스
	String fuel;		// 연료(휘발유, 가솔린, LPG 등)
	int horsePower;		// 마력

	Vehicle() {
	}
	
	Vehicle(String fuel, int horsePower) {
		this.fuel = fuel;   this.horsePower = horsePower;
	}
}

interface PassengerIF {						// 승객용 차량을 위한 인터페이스
	public void setMaxPassenger(int max); 	//    최대 승객수 저장하는 메소드
	//	public int getMaxPassenger();       //    최대 화물량 반환하는 메소드
}

interface FreightIF {   					// 화물용 차량을 위한 인터페이스
	void setMaxFreight(double max);  		//    최대 화물량 저장하는 메소드
	double getMaxFreight();           		//    최대 화물량 반환하는 메소드
}

class PassengerVehicle extends Vehicle implements PassengerIF {
	int maxPassenger;  		// 최대 승객수 
	
	// 연료종류, 마력, 최대 승객수 주어지면 이를 초기화하는 객체 생성자
	PassengerVehicle(String fuel, int horsePower, int maxPassenger) {
		super(fuel, horsePower);
		setMaxPassenger(maxPassenger);
	} 
	
	public void setMaxPassenger(int max) {
		this.maxPassenger = max;
	}
	
	public int getMaxPassenger() {
		return maxPassenger;
	}   
}

class FreightVehicle extends Vehicle implements FreightIF {

	// 3) PassengerVehicle을 참조하여 FreightVehicle 클래스를 작성하라
}

class Bus extends PassengerVehicle {

	// 4) 연료종류, 마력, 최대 승객수 주어지면 이를 초기화하는 객체 생성자
	//    작성하라.
}

class Truck extends FreightVehicle {

	// 5) 연료종류, 마력, 최대 화물량이 주어지면 이를 초기화하는 객체 생성자 
	//    작성하라 
}

class Exercise8_7_Vehicle {
	public static void main(String[] args) {
		PassengerIF v1 = new Bus("LPG", 50, 45);
		FreightIF v2 = new Truck("가솔린", 120, 12.3);
	}
}

