package Override.instanceOf;

public class InstanceofExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parent parentA = new Child();
		method1(parentA);
		method2(parentA);

		Parent parentB = new Parent();
		method1(parentB);
		method2(parentB);

	}

	private static void method2(Parent parent) {
		// TODO Auto-generated method stub
		Child child = (Child) parent;
		System.out.println("method2 - Child로 변환 성공");
	}

	private static void method1(Parent parent) {
		// TODO Auto-generated method stub
		if (parent instanceof Child) {
			Child child = (Child) parent;
			System.out.println("method1 - child 변환 성공");
		} else {
			System.out.println("method1 - child 변환 실패");
		}
	}

}
