package car;

public class CarExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Car car1 = new Car();
		System.out.println(car1.company);

		Car car2 = new Car("자가용");
		System.out.println(car2.company);
		System.out.println(car2.model);

		Car car3 = new Car("자가용", "검정색");
		System.out.println(car3.company);
		System.out.println(car3.model);
		System.out.println(car3.color);

		Car car4 = new Car("택시", "검정색", 200);
		System.out.println(car4.company);
		System.out.println(car4.model);
		System.out.println(car4.color);
		System.out.println(car4.color);

	}

}
