package car;

public class CarExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 객체 생성
		Car myCar = new Car();

		System.out.println(myCar.company);
		System.out.println(myCar.color);
		System.out.println(myCar.maxSpeed);
		System.out.println(myCar.model);
		System.out.println(myCar.speed);

		// 필드값 변경
		myCar.company = "기아차";
		System.out.println(myCar.company);
	}

}
