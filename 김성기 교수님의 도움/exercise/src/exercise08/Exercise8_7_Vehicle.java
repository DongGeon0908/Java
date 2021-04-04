package exercise08;

/**
 * [ 8�� �������� 7 ]
 * 
 *   7. ������ ���� Ŭ������ �������̽��� ����Ǿ���. ������ ���϶�.
 *   
 *      1) Bus Ŭ������ ���� Ŭ������ ���� �������̽��� ��� �����϶�. 
 *      
 *      2) Truck Ŭ������ ���� Ŭ������ ���� �������̽��� ��� �����϶�. 
 *      
 *      3) PassengerVehicle�� �����Ͽ� FreightVehicle Ŭ������ �ۼ��϶�. 
 *      
 *      4) ��������, ����, �ִ� �°����� �־����� �̸� �ʱ�ȭ�ϴ� Bus Ŭ������ ��ü ������ �ۼ��϶�.
 *      
 *      5) ��������, ����, �ִ� ȭ������ �־����� �̸� �ʱ�ȭ�ϴ� Truck Ŭ������ ��ü ������ �ۼ��϶�.
 *      
 *      6) main() �޼ҵ��� << PassengerIF v1 = new Bus("LPG", 50, 45); >>���� v1 ������ ������ Bus 
 *         ��ü�� ����� �� �ִ� ������ �����϶�.
 */

class Vehicle { 		// ���� Ŭ����
	String fuel;		// ����(�ֹ���, ���ָ�, LPG ��)
	int horsePower;		// ����

	Vehicle() {
	}
	
	Vehicle(String fuel, int horsePower) {
		this.fuel = fuel;   this.horsePower = horsePower;
	}
}

interface PassengerIF {						// �°��� ������ ���� �������̽�
	public void setMaxPassenger(int max); 	//    �ִ� �°��� �����ϴ� �޼ҵ�
	//	public int getMaxPassenger();       //    �ִ� ȭ���� ��ȯ�ϴ� �޼ҵ�
}

interface FreightIF {   					// ȭ���� ������ ���� �������̽�
	void setMaxFreight(double max);  		//    �ִ� ȭ���� �����ϴ� �޼ҵ�
	double getMaxFreight();           		//    �ִ� ȭ���� ��ȯ�ϴ� �޼ҵ�
}

class PassengerVehicle extends Vehicle implements PassengerIF {
	int maxPassenger;  		// �ִ� �°��� 
	
	// ��������, ����, �ִ� �°��� �־����� �̸� �ʱ�ȭ�ϴ� ��ü ������
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

	// 3) PassengerVehicle�� �����Ͽ� FreightVehicle Ŭ������ �ۼ��϶�
}

class Bus extends PassengerVehicle {

	// 4) ��������, ����, �ִ� �°��� �־����� �̸� �ʱ�ȭ�ϴ� ��ü ������
	//    �ۼ��϶�.
}

class Truck extends FreightVehicle {

	// 5) ��������, ����, �ִ� ȭ������ �־����� �̸� �ʱ�ȭ�ϴ� ��ü ������ 
	//    �ۼ��϶� 
}

class Exercise8_7_Vehicle {
	public static void main(String[] args) {
		PassengerIF v1 = new Bus("LPG", 50, 45);
		FreightIF v2 = new Truck("���ָ�", 120, 12.3);
	}
}

